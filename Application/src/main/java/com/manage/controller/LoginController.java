package com.manage.controller;

import com.manage.pojo.UserInfo;
import com.manage.service.UserInfoService;
import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * 用户登录所用
 *
 * @author 朱海燕
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    //创建一个userInfoService的实现类对象
    @Autowired
    UserInfoService userInfoService;

    //接收用户发送的登录信息，用户名和密码
    //ModelMap 是用来把服务端的值传给前端的
    @RequestMapping("/loginForm")
    public String loginForm(UserInfo user, ModelMap map,HttpServletRequest request){

        String info = userInfoService.login(user,request);
        map.addAttribute("info",info);
        //返回登录页面
        return "login";
    }
    //访问登录页面login.html
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "security/login";
    }

    //ajax登录
    @RequestMapping("/loginAjax")
    @ResponseBody
    public HashMap<String,Object> loginajax(UserInfo user,HttpServletRequest request){

        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = userInfoService.login(user,request);
        map.put("info",info);
        return map;
    }
    //访问注册页面register.html
    @RequestMapping("/registerPage")
    public String registerPage(){
        return "security/register";
    }

    //处理注册请求
    @RequestMapping("/register")
    @ResponseBody
    public HashMap<String,Object> register(UserInfo user){
        HashMap<String,Object> map = new HashMap<String,Object>();
        //访问注册方法
        String info = userInfoService.register(user);
        map.put("info",info);
        return map;
    }

    //处理邮件发送的请求
    @RequestMapping("/sendEmail")
    @ResponseBody
    public HashMap<String,Object> sendEmail(String email, HttpServletRequest request){
        return userInfoService.sendCode(email,request);
    }
    //处理邮件登录的请求
    @RequestMapping("/emailLogin")
    @ResponseBody
    public HashMap<String,Object> emailLogin(String code,HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<String,Object>();

        //获取session对象
        HttpSession session = request.getSession();
        //取出存到session中的验证码的值
        String valCode = session.getAttribute("valCode")+"";
        //判断用户输入的验证码和邮箱接收的验证码是否一致
        if(code.equals(valCode)){
            map.put("info","邮箱登录成功");
        }else{
            map.put("info","验证码输入错误");
        }
        return map;
    }

    //注销
    @RequestMapping("/cancle")
    public String cancle(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.invalidate();
        return "security/login";
    }
}
