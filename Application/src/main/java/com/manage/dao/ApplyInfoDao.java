package com.manage.dao;

import com.manage.pojo.ApplyInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ApplyInfoDao {


    //查询所有用户列表
    @Select("select * from applyInfo ")
    List<ApplyInfo> select();

    //根据applyid查询
    @Select("select * from applyInfo where applyId=#{applyId}")
    ApplyInfo selectByApplyId(ApplyInfo apply);
    //修改apply
    @Update("update applyInfo set applySex=#{applySex},applyPhone=#{applyPhone},applyDate=#{applyDate},applyGroup=#{applyGroup},applyPosition=#{applyPosition},applyState=#{applyState} where applyId=#{applyId}")
    int update(ApplyInfo apply);

    //评价apply
    @Update("update applyInfo set penScore=#{penScore},faceScore=#{faceScore},evaluate=#{evaluate} where applyId=#{applyId}")
    int evaluate(ApplyInfo apply);

    //删除apply
    @Delete("delete from applyInfo where applyId=#{applyId}")
    int del(ApplyInfo apply);

    //根据编号查询
    @Select("select * from applyInfo where applyId=#{applyId}")
    List<ApplyInfo> findByApplyId(ApplyInfo apply);

    //根据姓名查询
    @Select("select * from applyInfo where applyName=#{applyName}")
    List<ApplyInfo> findByApplyName(ApplyInfo apply);

    //根据出生日期查询
    @Select("select * from applyInfo where applyBirth=#{applyBirth}")
    List<ApplyInfo> findByApplyBirth(ApplyInfo apply);

    //根据应聘日期查询
    @Select("select * from applyInfo where applyDate=#{applyDate}")
    List<ApplyInfo> findByApplyDate(ApplyInfo apply);

    //根据性别查询
    @Select("select * from applyInfo where applySex=#{applySex}")
    List<ApplyInfo> findByApplySex(ApplyInfo apply);


    //添加
    @Insert("insert into applyInfo(applyName,applySex,applyCollege,applyBirth,applyPhone,applyEmail,applyDate,applyGroup,applyPosition) value(#{applyName},#{applySex},#{applyCollege},#{applyBirth},#{applyPhone},#{applyEmail},#{applyDate},#{applyGroup},#{applyPosition})")
    int add(ApplyInfo apply);

}
