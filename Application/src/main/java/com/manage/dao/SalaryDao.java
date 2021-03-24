package com.manage.dao;

import com.manage.pojo.AttendanceInfo;
import com.manage.pojo.Salary;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SalaryDao {
   //查询所有记录列表
  /*  @Select("SELECT * from salary")
    List<Salary> select(Salary salary);*/
     @Select("SELECT * from salary")
     List<Salary> select();

    //按ID删除记录
    @Delete("DELETE from salary WHERE salaryID= #{salaryID}")
    int del(Salary salary);

    //修改
    @Update("UPDATE salary SET staffID = #{staffID}, staffName = #{staffName}, jiben = #{jiben}, jixiao = #{jixiao}, jiangjing = #{jiangjing}, fakuan = #{fakuan}, sum = #{sum} , time = #{time} WHERE salaryID=#{salaryID}")
    int update(Salary salary);
    //根据salaryID查询
    @Select("SELECT * from salary WHERE salaryID = #{salaryID}")
    List<Salary> selectByID(Salary salary);
    //根据salaryID查询
    @Select("SELECT * from salary WHERE salaryID = #{salaryID}")
    List<Salary> findByID(Salary salary);
    //根据salaryID查询
    @Select("SELECT * from salary WHERE staffID = #{staffID}")
    List<Salary> findBystaffID(Salary salary);
    // 按名字查询所有员工基本信息
    @Select("SELECT * FROM salary WHERE  staffName = #{staffName}")
    List<Salary> findByStaffName(Salary salary);

    //添加
    @Insert("INSERT INTO salary SET salaryID=#{salaryID}, staffID = #{staffID}, staffName = #{staffName}, jiben = #{jiben}, jixiao = #{jixiao}, jiangjing = #{jiangjing}, fakuan = #{fakuan}, sum = #{sum} ,time = #{time}")
    int addInfo(Salary salary);

    //查询前三
    @Select("SELECT * FROM salary WHERE time = '2021-01-19' ORDER BY ${type} DESC LIMIT 3")
   List<Salary> Selectbing(Salary salary);

}
