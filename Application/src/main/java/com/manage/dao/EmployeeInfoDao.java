package com.manage.dao;

import com.manage.pojo.EmployeeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 人员档案及人事调配所用
 *
 * @author 张杰
 */
@Mapper
public interface EmployeeInfoDao {

    // 查询所有员工基本信息
    @Select("SELECT * FROM employeeInfo")
    List<EmployeeInfo> selectInfo();

    // 按ID查询所有员工基本信息
    @Select("SELECT * FROM employeeInfo WHERE id = #{id}")
    List<EmployeeInfo> selectInfoById(EmployeeInfo employeeInfo);

    // 按名字查询所有员工基本信息
    @Select("SELECT * FROM employeeInfo WHERE empName = #{empName}")
    List<EmployeeInfo> selectInfoByEmpName(EmployeeInfo employeeInfo);

    //修改
    @Update("UPDATE employeeInfo SET empName = #{empName}, gender = #{gender}, birthDay = #{birthDay}," +
            "telNum = #{telNum}, mailNum = #{mailNum}, qualification = #{qualification}, " +
            "department = #{department}, job = #{job}, hireDate = #{hireDate}, state = #{state}," +
            "remarks = #{remarks}  WHERE id = #{id}")
    int updateInfo(EmployeeInfo employeeInfo);
}
