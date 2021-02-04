package com.manage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.dao.ApplyInfoDao;
import com.manage.dao.EmployInfoDao;
import com.manage.pojo.ApplyInfo;
import com.manage.pojo.CountInfo;
import com.manage.pojo.EmployInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class EmployInfoServiceImpl implements EmployInfoService{
    //创建一个employInfoDao的实现类对象
    @Autowired(required = false)
    EmployInfoDao employInfoDao;

    //查询employee
    @Override
    public HashMap<String, Object> select(EmployInfo employ) {
        HashMap<String, Object> map = new HashMap<String, Object>();
//1 设置分页查询的页码，每页显示的行数
        PageHelper.startPage(employ.getPage(),employ.getRow());
        List<EmployInfo> list = new ArrayList<>();
        //判断用户输入的查询条件是否有值
        if(employ.getConValue().equals("")){
            list = employInfoDao.select();
        }else {
            //根据用户选择查询条件需要查询
            if(employ.getCondition().equals("姓名")){
                //设置用户姓名的查询条件
                employ.setEmployName(employ.getConValue());
                list=employInfoDao.findByEmployName(employ);
            }else if(employ.getCondition().equals("部门")) {
                employ.setGroup(employ.getConValue());
                list=employInfoDao.findByEmployGroup(employ);
            }else if(employ.getCondition().equals("入职状态")){
                employ.setEmployState(employ.getConValue());
                list=employInfoDao.findByEmplyState(employ);
            }
            else {
                list = employInfoDao.select();
            }
        }

        //3 创建分页对象
        PageInfo<EmployInfo> page = new PageInfo<EmployInfo>(list);
        //将查询数据进行插入，结果集
        map.put("list",page.getList());
        //总条数
        map.put("total",page.getTotal());
        //总页数
        map.put("totalPage",page.getPages());
        //上一页
        if(page.getPrePage() == 0){
            map.put("prePage",1);
        }
        else {
            map.put("prePage",page.getPrePage());
        }

        //下一页
        if(page.getNextPage() == 0){
            map.put("nextPage",page.getPages());
        }else{
            map.put("nextPage",page.getNextPage());
        }
        //当前页
        map.put("cur",page.getPageNum());

        return map;
    }

    @Override
    public HashMap<String, Object> findAll(EmployInfo employ) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<EmployInfo> list = new ArrayList<>();
        list=employInfoDao.select();
        map.put("list",list);
        return map;
    }

    @Override
    public String del(EmployInfo employ) {
        int num = employInfoDao.del(employ);
        if(num>0){
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public EmployInfo selectByEmployId(EmployInfo employ) {
        return employInfoDao.selectByEmployId(employ);
    }

    @Override
    public String position(EmployInfo employ) {
        int n = employInfoDao.position(employ);
        if(n>0){
            return "入岗成功";
        }
        return "入岗失败";
    }

    @Override
    public HashMap<String, Object> count() {
        HashMap<String, Object> map=new HashMap<String, Object>();
        int num=employInfoDao.count();
        if(num>0){
            //查询数据库
            List<CountInfo> list= employInfoDao.dataCount();
            //构建柱状图所需要的的数据
            List<String> xList=new ArrayList<>();
            List<Integer> yList=new ArrayList<>();
            System.out.println(list);
            for(CountInfo i:list){
                xList.add(i.getPart());
                yList.add(i.getDataCount());
            }
            map.put("x",xList);
            map.put("y",yList);

        }else {
            map.put("data","数据有误");
        }
        return map;
    }
}
