package com.manage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.dao.EmployeeInfoDao;
import com.manage.pojo.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class EmpInfoServiceImplement implements EmpInfoService {
    @Autowired
    EmployeeInfoDao employeeInfoDao;

    @Override
    public HashMap<String, Object> selectInfo(EmployeeInfo employeeInfo) {
        HashMap<String, Object> map = new HashMap<>();
        //设置分页参数
        PageHelper.startPage(employeeInfo.getPage(), employeeInfo.getRow());

        //根据用户选择的查询条件查询结果
        List<EmployeeInfo> list = null;
        if (employeeInfo.getConValue() != null) {
            if (employeeInfo.getConValue().equals("")) {
                list = employeeInfoDao.selectInfo();
            } else {
                if (employeeInfo.getCondition().equals("编号")) {
                    //设置用户输入的查询条件
                    employeeInfo.setId(Integer.parseInt(employeeInfo.getConValue()));
                    list = employeeInfoDao.selectInfoById(employeeInfo);
                } else if (employeeInfo.getCondition().equals("姓名")) {
                    employeeInfo.setEmpName(employeeInfo.getConValue());
                    list = employeeInfoDao.selectInfoByEmpName(employeeInfo);
                } else {
                    //查询数据库表数据
                    list = employeeInfoDao.selectInfo();
                }
            }
        } else {
            list = employeeInfoDao.selectInfo();
        }

        //把查询到的数据转换成分页对象
        PageInfo<EmployeeInfo> page = new PageInfo<>(list);

        //获取分页的当前页的集合
        map.put("list", page.getList());
        //总条数
        map.put("total", page.getTotal());
        //总页数
        map.put("totalPage", page.getPages());
        //上一页
        if (page.getPrePage() == 0) {
            map.put("pre", 1);
        } else {
            map.put("pre", page.getPrePage());
        }
        //下一页
        if (page.getNextPage() == 0) {
            map.put("next", page.getPages());
        } else {
            map.put("next", page.getNextPage());
        }
        //当前页
        map.put("cur", page.getPageNum());

        return map;
    }

    @Override
    public EmployeeInfo selectInfoById(EmployeeInfo employeeInfo) {
        return employeeInfoDao.selectInfoById(employeeInfo).get(0);
    }

    @Override
    public String updateInfo(EmployeeInfo employeeInfo) {
        int num = employeeInfoDao.updateInfo(employeeInfo);
        if (num > 0) {
            return "修改成功";
        }
        return "修改失败";
    }
}
