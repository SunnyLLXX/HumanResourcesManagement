package com.manage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.dao.UserInfoDao;
import com.manage.pojo.UserInfo;
import com.manage.util.MdFive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class UserInfoServiceImplement implements UserInfoService {
    //创建一个userInfoDao的实现类对象
    @Autowired(required = false)
    UserInfoDao userInfoDao;

    //创建加密工具类对象
    @Autowired
    MdFive mdfive;

    //获取发件人邮箱
    @Value("${spring.mail.username}")
    String sendEmail;

    //创建发送邮件的对象
    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public String login(UserInfo user, HttpServletRequest request) {
        //查询用户名是否存在，如果存在，就取出它的盐值
        UserInfo u = userInfoDao.selectByName(user);
        if(u!=null){
            //加密用户输入的密码
            String pwd = mdfive.encrypt(user.getPassword(),u.getSalt());
            //把加过密码的传到数据层中
            user.setPassword(pwd);
            //查询数据层的登录方法，并且拿到返回值
            UserInfo userinfo =userInfoDao.login(user);
            //如果查询到值，userinfo就不等于null，否则就等于null
            if(userinfo!=null){
                //创建session对象
                HttpSession session = request.getSession();
                //存入用户对象
                session.setAttribute("user",userinfo);
                return "登录成功";
            }
        }else{
            return "用户名不存在";
        }
        return "密码错误";
    }

    @Override
    public String register(UserInfo user) {
        //查询用户名是否重名
        int num = userInfoDao.valName(user);
        if(num>0){
            return "用户名已经被注册";
        }else{
            //自动生成一个盐值
            Random rd = new Random();
            String salt = rd.nextInt(10000)+"";

            //加密用户输入的密码
            String pwd = mdfive.encrypt(user.getPassword(),salt);
            //把加过密码的传到数据层中
            user.setPassword(pwd);
            //存入盐值
            user.setSalt(salt);
            user.setPermission(user.getRole());
            //注册
            int n = userInfoDao.register(user);
            if(n>0){
                return "注册成功";
            }
        }
        return "注册失败";
    }


    @Override
    public HashMap<String, Object> sendCode(String email, HttpServletRequest request) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        try {
            //从session中获取当前用户信息
            HttpSession session = request.getSession();
            //创建普通邮件对象
            SimpleMailMessage message = new SimpleMailMessage();
            //设置发件人邮箱
            message.setFrom(sendEmail);
            //设置收件人邮箱
            message.setTo(email);
            //设置邮件标题
            message.setSubject("学员信息管理系统验证码");
            // 生成随机验证码
            Random rd = new Random();
            String valCode = rd.nextInt(9999)+"";
            //设置邮件正文
            message.setText("你的验证码是:"+valCode);
            //发送邮件
            javaMailSender.send(message);
            //发送成功
            //把验证码存入session中
            session.setAttribute("valCode",valCode);
            map.put("info","发送成功");
            return map;

        } catch (Exception e) {
            System.out.println("发送邮件时发生异常！");
            e.printStackTrace();
        }
        map.put("info","发送邮件异常");
        return map;
    }

    @Override
    public HashMap<String, Object> select(UserInfo user) {
        HashMap<String, Object> map =  new HashMap<String, Object>();
        //1 设置分页参数
        PageHelper.startPage(user.getPage(),user.getRow());
        //根据用户选择的查询条件，判断用户需要查询的
        List<UserInfo> list = new ArrayList<>();

        //判断用户输入的查询条件是否有值
        if(user.getConValue().equals("")){
            list  = userInfoDao.select();
        }else{
            if(user.getCondition().equals("角色")){
                //设置用户输入的查询条件
                user.setRole(user.getConValue());
                list = userInfoDao.findByRole(user);
            }else if(user.getCondition().equals("用户名")){
                user.setUsername(user.getConValue());
                list = userInfoDao.findByUserName(user);
            }else{
                list  = userInfoDao.select();
            }
        }

        //3.把查询的数据转换成分页对象
        PageInfo<UserInfo> page = new PageInfo<UserInfo>(list);

        //获取分页的当前页的集合
        map.put("list",page.getList());
        //总条数
        map.put("total",page.getTotal());
        //总页数
        map.put("totalPage",page.getPages());
        //上一页
        if(page.getPrePage()==0){
            map.put("pre",1);
        }else{
            map.put("pre",page.getPrePage());
        }

        //下一页
        //保持在最后一页
        if(page.getNextPage()==0){
            map.put("next",page.getPages());
        }else{
            map.put("next",page.getNextPage());
        }
        //当前页
        map.put("cur",page.getPageNum());

        return map;
    }

    @Override
    public UserInfo selectByUserId(UserInfo user) {
        return userInfoDao.selectByUserId(user);
    }


    @Override
    public String update(UserInfo user) {

        //验证修改的用户名是否重名
        int v = userInfoDao.valName(user);
        if(v==0){
            int num = userInfoDao.update(user);
            if(num>0){
                return "修改成功";
            }
        }else{
            return "用户名重名";
        }

        return "修改失败";
    }

    @Override
    public String del(UserInfo user) {
        int num = userInfoDao.del(user);
        if(num>0){
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public String updatePwd(UserInfo user,HttpServletRequest request) {
        //取出用户存入session中的密码
        HttpSession session = request.getSession();
        UserInfo u = (UserInfo) session.getAttribute("user");
        String pwd = u.getPassword();
        //加密下旧密码
        String oldPwd = mdfive.encrypt(user.getOldPwd(),u.getSalt());

        //判断用户输入的旧密码是否正确
        if(oldPwd.equals(pwd)){
            //加密新密码
            String p = mdfive.encrypt(user.getNewPwd(),u.getSalt());
            //存入加密后的新密码
            u.setPassword(p);
            int num= userInfoDao.updatePwd(u);
            if(num >0){
                return "修改密码成功";
            }

        }else{
            return "旧密码输入不正确";
        }

        return "修改密码失败";
    }

    @Override
    public String updateHead(UserInfo user, HttpServletRequest request) {
        //获取session
        HttpSession session = request.getSession();
        UserInfo u = (UserInfo) session.getAttribute("user");
        //存入要修改的用户id
        user.setUserId(u.getUserId());
        //
        int num = userInfoDao.updateHead(user);
        if(num > 0){
            return "保存成功";
        }
        return  "保存失败";
    }
}
