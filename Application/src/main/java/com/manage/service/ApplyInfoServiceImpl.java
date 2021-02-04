package com.manage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.dao.ApplyInfoDao;
import com.manage.pojo.ApplyInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class ApplyInfoServiceImpl implements ApplyInfoService{
    //创建一个applyInfoDao的实现类对象
    @Autowired(required = false)
    ApplyInfoDao applyInfoDao;



    //查询apply列表
    @Override
    public HashMap<String, Object> select(ApplyInfo apply){
        HashMap<String, Object> map = new HashMap<String, Object>();
//1 设置分页查询的页码，每页显示的行数
        PageHelper.startPage(apply.getPage(),apply.getRow());
        List<ApplyInfo> list = new ArrayList<>();
        //判断用户输入的查询条件是否有值
        if(apply.getConValue().equals("")){
            list = applyInfoDao.select();

        }else {
            //根据用户选择查询条件需要查询
            if(apply.getCondition().equals("姓名")){
                //设置用户姓名的查询条件
                apply.setApplyName(apply.getConValue());
                list=applyInfoDao.findByApplyName(apply);
            }else if(apply.getCondition().equals("出生日期")) {
                apply.setApplyBirth(apply.getConValue());
                list=applyInfoDao.findByApplyBirth(apply);
            }else if(apply.getCondition().equals("性别")){
                apply.setApplySex(apply.getConValue());
                list=applyInfoDao.findByApplySex(apply);
            }else if(apply.getCondition().equals("应聘日期")){
                apply.setApplyDate(apply.getConValue());
                list=applyInfoDao.findByApplyDate(apply);
            }
            else {
                list = applyInfoDao.select();
            }
        }

        //3 创建分页对象
        PageInfo<ApplyInfo> page = new PageInfo<ApplyInfo>(list);
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
    public HashMap<String, Object> findAll(ApplyInfo apply) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<ApplyInfo> list = new ArrayList<>();
        list=applyInfoDao.select();
        map.put("list",list);
        return map;
    }

    //根据applyid查询
    @Override
    public ApplyInfo selectByApplyId(ApplyInfo apply) {
        return applyInfoDao.selectByApplyId(apply);
    }
    //修改apply
    @Override
    public String update(ApplyInfo apply) {
        int num = applyInfoDao.update(apply);
        if(num>0){

            return "修改成功";
        }
        return "修改失败";
    }
    //评价
    @Override
    public String evaluate(ApplyInfo apply) {
        int num = applyInfoDao.evaluate(apply);
        if(num>0){
            return "评价成功";
        }
        return "评价失败";
    }

    //删除apply
    @Override
    public String del(ApplyInfo apply) {
        int num = applyInfoDao.del(apply);
        if(num>0){
            return "删除成功";
        }
        return "删除失败";
    }

    @Override
    public String add(ApplyInfo apply) {
        int n = applyInfoDao.add(apply);
        if(n>0){
            return "添加成功";
        }
        return "添加失败";
    }

}
