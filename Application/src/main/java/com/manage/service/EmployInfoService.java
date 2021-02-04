package com.manage.service;

import com.manage.pojo.ApplyInfo;
import com.manage.pojo.EmployInfo;

import java.util.HashMap;

public interface EmployInfoService {
    //查询employ列表
    HashMap<String, Object> select(EmployInfo employ);
    //查询employ列表
    HashMap<String, Object> findAll(EmployInfo employ);
    //删除employ
    String del(EmployInfo employ);
    //根据applyid查询
    EmployInfo selectByEmployId(EmployInfo employ);

    //添加入岗
    String position(EmployInfo employ);

    //统计employ列表
    HashMap<String, Object> count();
}
