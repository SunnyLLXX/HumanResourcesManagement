package com.manage.service;

import com.manage.pojo.AttendanceInfo;

import java.util.HashMap;

public interface AttendanceInfoService {
    //查询
    HashMap<String,Object> select(AttendanceInfo attendance);
    //修改
    String update(AttendanceInfo attendance);
    //删除
    String del(AttendanceInfo attendance);
    //添加
    String addInfo(AttendanceInfo attendance);
    //按照id查询
    AttendanceInfo selectByAttendanceId(AttendanceInfo attendance);


}
