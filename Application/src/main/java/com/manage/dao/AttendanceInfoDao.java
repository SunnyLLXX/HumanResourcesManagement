package com.manage.dao;

import com.manage.pojo.AttendanceInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/*
* 关于attendanInfo的数据库操作
* */
@Mapper//这个接口是执行的是mybatis的数据库操作
public interface AttendanceInfoDao {
    //查询所有考勤记录列表
    @Select("SELECT * from attendanceInfo")
    List<AttendanceInfo> select(AttendanceInfo atdResults);

   /* //根据类型查询//这个能不能用上再说
    @Select("SELECT * from attendanceInfo WHERE type = #{type} and staffID = #{staffID}"  )
    List<AttendanceInfo> select_2();*/

    //删除某条考勤记录
    @Delete("DELETE from attendanceInfo WHERE attendanceID= #{attendanceID}")
    int del(AttendanceInfo attendance);

    //修改
    @Update("UPDATE attendanceInfo SET staffID = #{staffID}, type = #{type}, amount = #{amount}, staffName = #{staffName}, mouth = #{mouth} WHERE attendanceID=#{attendanceID}")
    int update(AttendanceInfo attendance);

    //根据attendanceID查询
    @Select("SELECT * from attendanceInfo WHERE attendanceID = #{attendanceID}")
    AttendanceInfo selectByAttendanceID(AttendanceInfo attendance);

    //添加
    @Insert("INSERT INTO attendanceInfo SET attendanceID = #{attendanceID}, staffID = #{staffID}, type = #{type}, amount = #{amount}, staffName = #{staffName}, mouth = #{mouth}")
    int addInfo(AttendanceInfo attendance);



   /* //验证用户名是否重名
    @Select("select count(*) from attendanceInfo where username=#{username} and userId<>#{userId}")
    int valName(AttendanceInfo attendance);*/
   /* //修改
    @Update("update attendanceInfo set username=#{username} where userId=#{userId}")
    int update(AttendanceInfo attendance);*/

}
