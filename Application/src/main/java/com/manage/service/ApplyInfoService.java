package com.manage.service;

import com.manage.pojo.ApplyInfo;

import java.util.HashMap;

public interface ApplyInfoService {
    //查询apply列表
    HashMap<String, Object> select(ApplyInfo apply);

    //查询apply列表
    HashMap<String, Object> findAll(ApplyInfo apply);

    //根据applyid查询
    ApplyInfo selectByApplyId(ApplyInfo apply);

    //修改apply
    String update(ApplyInfo apply);

    //评价apply
    String evaluate(ApplyInfo apply);

    //删除apply
    String del(ApplyInfo apply);

    //添加apply
    String add(ApplyInfo apply);

}
