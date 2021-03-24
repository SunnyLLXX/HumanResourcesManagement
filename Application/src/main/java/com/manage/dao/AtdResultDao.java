package com.manage.dao;

import com.manage.pojo.AtdResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AtdResultDao {
    @Select("SELECT * FROM attendanceresults WHERE 1=1 ORDER BY ${type} desc LIMIT 3")
    List<AtdResult> select(AtdResult atdResult);
}
