package com.manage.service;

/**
 * 用户登录所用
 *
 * @author 朱海燕
 */

import com.manage.pojo.UserInfo;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Service
public interface UserInfoService {
    //登录方法
    String login(UserInfo user, HttpServletRequest request);

    //注册
    String register(UserInfo user);

    //邮件发送
    HashMap<String,Object> sendCode(String toEmail, HttpServletRequest request);

    //查询
    HashMap<String,Object> select(UserInfo user);

    //根据userId查询
    UserInfo selectByUserId(UserInfo user);

    //修改
    String update(UserInfo user);

    //删除
    String del(UserInfo user);
    //修改密码
    String updatePwd(UserInfo user,HttpServletRequest request);

    //修改头像
    String updateHead(UserInfo user, HttpServletRequest request);

    //新增用户
    //String add(UserInfo user);
}
