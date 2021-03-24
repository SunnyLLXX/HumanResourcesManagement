package com.manage.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manage.dao.AttendanceInfoDao;
import com.manage.pojo.AttendanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service //该类的对象创建交给spring管理
public class AttendanceInfoServiceImpl implements AttendanceInfoService {
   //创建一个AttendanceInfoDao的实现类对象
    @Autowired(required = false)
    AttendanceInfoDao attendanceInfoDao;
    @Override
    public HashMap<String, Object> select(AttendanceInfo attendance) {
        HashMap<String, Object> map = new HashMap<>();
        //1 设置分页参数
        PageHelper.startPage(attendance.getPage(),attendance.getRow());
        //根据用户选择的查询条件，判断用户需要查询的
        List<AttendanceInfo> list = null;
        list = attendanceInfoDao.select(attendance);

        //3.把查询的数据转换成分页对象
        PageInfo<AttendanceInfo> page = new PageInfo<AttendanceInfo>(list);

        //获取分页的当前页的集合
        map.put("list",page.getList());
        //总条数
        map.put("total",page.getTotal());
        //总页数
        map.put("totalPage",page.getPages());
        //上一页
        if(page.getPrePage()==0){
            map.put("pre",1);
        }else{
            map.put("pre",page.getPrePage());
        }

        //下一页
        //保持在最后一页
        if(page.getNextPage()==0){
            map.put("next",page.getPages());
        }else{
            map.put("next",page.getNextPage());
        }
        //当前页
        map.put("cur",page.getPageNum());

        return map;
    }

    @Override
    public String update(AttendanceInfo attendance) {
        int num = attendanceInfoDao.update(attendance);
        if (num>0){
            return "修改成功";
        }
        return "修改失败";
    }

    @Override
    public String del(AttendanceInfo attendance) {

            int num = attendanceInfoDao.del(attendance);
            if(num>0){
                return "删除成功";
            }
            return "删除失败";
            }

    @Override
    public String addInfo(AttendanceInfo attendance) {
        int num =attendanceInfoDao.addInfo(attendance);
        if (num > 0) {
            return "添加成功";
        }
        return "添加失败";
    }

    @Override
    public AttendanceInfo selectByAttendanceId(AttendanceInfo attendance) {
        return attendanceInfoDao.selectByAttendanceID(attendance);
    }

   /* @Override
    public HashMap<String, Object> picture(AttendanceInfo attendance) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        //查询数据库
        List<AttendanceInfo> list = null;
        list = attendanceInfoDao.select_2();
        //构建统计图需要的数据类型
        List<HashMap<String,Object>> mapList = new ArrayList<>();
        for(AttendanceInfo i:list){
            HashMap<String,Object> m = new HashMap<>();
            m.put("value",i.getLateCount());
            m.put("name",i.getStaffName());
            //添加到构建饼图的集合里
            mapList.add(m);
        }
        return map;
    }*/

}
