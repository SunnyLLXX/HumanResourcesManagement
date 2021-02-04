package com.manage.dao;

import com.manage.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * 安全管理及系统管理所用
 *
 * @author 朱海燕
 */
@Mapper
public interface UserInfoDao {
    //登录
    @Select("select * from userinfo where username=#{username} and password=#{password}")
    UserInfo login(UserInfo user);

    //验证用户名是否重名
    @Select("select count(*) from userinfo where username=#{username} and userId<>#{userId}")
    int valName(UserInfo user);

    //查询用户名是否存在，并且取出盐值
    @Select("select * from userinfo where username=#{username}")
    UserInfo selectByName(UserInfo user);

    //注册
    @Insert("insert into userinfo (username,password,salt,role,permission) value (#{username},#{password},#{salt},#{role},#{permission})")
    int register(UserInfo user);

    //查询
    @Select("select * from userinfo ")
    List<UserInfo> select();

    //根据userid查询
    @Select("select * from userinfo where userId=#{userId}")
    UserInfo selectByUserId(UserInfo user);

    //修改
    @Update("update userinfo set username=#{username} where userId=#{userId}")
    int update(UserInfo user);

    //删除
    @Delete("delete from userinfo where userId=#{userId}")
    int del(UserInfo user);

    //根据编号查询
    @Select("select * from userinfo where userId=#{userId}")
    List<UserInfo> findByUserId(UserInfo user);

    //根据用户名查询
    @Select("select * from userinfo where username=#{username}")
    List<UserInfo> findByUserName(UserInfo user);

    //根据角色查询
    @Select("select * from userinfo where role=#{role}")
    List<UserInfo> findByRole(UserInfo user);

    //修改密码
    @Update("update userinfo set password=#{password} where userId=#{userId}")
    int updatePwd(UserInfo user);

    //修改头像
    @Update("update userinfo set url=#{url} where userId=#{userId}")
    int updateHead(UserInfo user);

}
