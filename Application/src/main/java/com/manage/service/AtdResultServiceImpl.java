package com.manage.service;

import com.manage.dao.AtdResultDao;
import com.manage.pojo.AtdResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class AtdResultServiceImpl implements AtdResultService {

    @Autowired (required = false)
    AtdResultDao atdResultDao;

    @Override
    public HashMap<String, Object> bing(AtdResult atdResult) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        //查询数据库
        if(atdResult.getCon().equals("0")){
           atdResult.setType("chidao");
        }
        if(atdResult.getCon().equals("1")){
            atdResult.setType("kuanggong");
        }
        if(atdResult.getCon().equals("2")){
            atdResult.setType("qingjia");
        }
        if(atdResult.getCon().equals("3")){
            atdResult.setType("jiaban");
        }
        if(atdResult.getCon().equals("4")){
            atdResult.setType("chuchai");
        }
        if(atdResult.getCon().equals("5")){
            atdResult.setType("tiaoban");
        }
        if(atdResult.getCon().equals("6")){
            atdResult.setType("tinggong");
        }
        List<AtdResult> list = atdResultDao.select(atdResult);
        //构建饼图需要的数据类型
        List<HashMap<String,Object>> mapList = new ArrayList<>();
        //遍历查询的数据集合
        for(AtdResult i:list){
            HashMap<String,Object> m = new HashMap<>();
            if(atdResult.getCon().equals("0")){
                m.put("value",i.getChidao());
                m.put("name",i.getStaffName());
            }
            if(atdResult.getCon().equals("1")){
                m.put("value",i.getKuanggong());
                m.put("name",i.getStaffName());
            }
            if(atdResult.getCon().equals("2")){
                m.put("value",i.getQingjia());
                m.put("name",i.getStaffName());
            }
            if(atdResult.getCon().equals("3")){
                m.put("value",i.getJiaban());
                m.put("name",i.getStaffName());
            }
            if(atdResult.getCon().equals("4")){
                m.put("value",i.getChuchai());
                m.put("name",i.getStaffName());
            }
            if(atdResult.getCon().equals("5")){
                m.put("value",i.getTiaoban());
                m.put("name",i.getStaffName());
            }
            if(atdResult.getCon().equals("6")){
                m.put("value",i.getTinggong());
                m.put("name",i.getStaffName());
            }

            //添加到构建饼图的集合里
            mapList.add(m);
        }
        //把构建好的饼图数据存到map中
        map.put("info",mapList);
        return map;
    }
}
