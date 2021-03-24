package com.manage.service;

import com.manage.pojo.AtdResult;
import com.manage.pojo.Salary;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public interface SalaryService {
    //查询
    HashMap<String,Object> select(Salary salary);

    //修改
    String update(Salary salary);

    //删除
    String del(Salary salary);

    //添加
    String addInfo(Salary salary);

    //按照id查询
    Salary selectById(Salary salary);
    //饼图
    HashMap<String,Object> bing(Salary salary);

}
