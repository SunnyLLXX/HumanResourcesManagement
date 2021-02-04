package com.manage.dao;

import com.manage.pojo.ApplyInfo;
import com.manage.pojo.CountInfo;
import com.manage.pojo.EmployInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface EmployInfoDao {
    //查询所有用户列表
    @Select("select * from employInfo ")
    List<EmployInfo> select();

    //根据姓名查询
    @Select("select * from employInfo where employName=#{employName}")
    List<EmployInfo> findByEmployName(EmployInfo employ);

    //根据入职状态查询
    @Select("select * from employInfo where employState=#{employState}")
    List<EmployInfo> findByEmplyState(EmployInfo employ);

    //根据部门查询
    @Select("select * from employInfo where `group`=#{group}")
    List<EmployInfo> findByEmployGroup(EmployInfo employ);

    //删除employ
    @Delete("delete from employInfo where employId=#{employId}")
    int del(EmployInfo employ);

    //根据employid查询
    @Select("select * from employInfo where employId=#{employId}")
    EmployInfo selectByEmployId(EmployInfo employ);

    //入岗
    @Insert("insert into employInfo(employName,college,`group`,employPosition,employState,employDate) value(#{employName},#{college},#{group},#{employPosition},#{employState},#{employDate})")
    int position(EmployInfo employ);

    @Insert("insert into groupCount(part,dataCount) select `group`,count(*) as 'dataCount' from employInfo group by `group`")
    int count();


    @Select("select distinct(part),dataCount from groupCount")
    List<CountInfo> dataCount();


}
