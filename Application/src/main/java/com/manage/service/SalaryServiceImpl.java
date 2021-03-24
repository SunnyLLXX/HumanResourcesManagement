package com.manage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.dao.SalaryDao;
import com.manage.pojo.AtdResult;
import com.manage.pojo.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService{
@Autowired (required = false)
    SalaryDao salaryDao;
    @Override
    public HashMap<String, Object> select(Salary salary) {
        HashMap<String, Object> map = new HashMap<>();
        //1 设置分页参数
        PageHelper.startPage(salary.getPage(),salary.getRow());
        //根据用户选择的查询条件，判断用户需要查询的
        List<Salary>list =new ArrayList<>();
        if(salary.getConValue()!=null)
        {
            if(salary.getConValue().equals("")){
            list= salaryDao.select();
        }else {
                if (salary.getCondition().equals("记录编号")) {
                    //设置用户输入的查询条件
                    salary.setSalaryID(Integer.parseInt(salary.getConValue()));
                    list = salaryDao.findByID(salary);
                } else if (salary.getCondition().equals("员工姓名")) {
                    salary.setStaffName(salary.getConValue());
                    list = salaryDao.findByStaffName(salary);
                }else if (salary.getCondition().equals("员工编号")) {
                    salary.setStaffID(Integer.parseInt(salary.getConValue()));
                    list = salaryDao.findBystaffID(salary);
                }
                else {
                    //查询数据库表数据
                    list = salaryDao.select();
                }
            }
        } else {
            list = salaryDao.select();
        }
        //把查询的数据转换成分页对象
        PageInfo<Salary> page = new PageInfo<>(list);

        //获取分页的当前页的集合
        map.put("list",page.getList());
        //总条数
        map.put("total",page.getTotal());
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
    public String update(Salary salary) {
        int num = salaryDao.update(salary);
        if (num>0){
            return "修改成功";
        }
        return "修改失败";
    }

    @Override
    public String del(Salary salary) {
        int num = salaryDao.del(salary);
        if(num>0){
            return "删除成功";
        }
        return "删除失败";
    }


    @Override
    public String addInfo(Salary salary) {
        int num =salaryDao.addInfo(salary);
        if (num > 0) {
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public Salary selectById(Salary salary) {
        return salaryDao.selectByID(salary).get(0);
    }

    @Override
    public HashMap<String, Object> bing(Salary salary) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        //查询数据库
        if(salary.getCon().equals("0")){
            salary.setType("jiangjing");
        }
        if(salary.getCon().equals("1")){
            salary.setType("fakuan");
        }
        List<Salary>list = salaryDao.Selectbing(salary);
        List<HashMap<String,Object>>mapList = new ArrayList<>();
        for(Salary i:list){
            HashMap<String,Object> m = new HashMap<>();
            if(salary.getCon().equals("0")){
                m.put("value",i.getJiangjing());
                m.put("name",i.getStaffName());
            }
            if(salary.getCon().equals("1")){
                m.put("value",i.getFakuan());
                m.put("name",i.getStaffName());
            }

            //添加到构建饼图的集合里
            mapList.add(m);
        }
        map.put("info",mapList);
        return  map;
    }
}
