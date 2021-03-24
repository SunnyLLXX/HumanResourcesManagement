package com.manage.service;

import com.manage.pojo.AtdResult;
import java.util.HashMap;


public interface AtdResultService {
    //统计图

    //饼图
    HashMap<String,Object> bing(AtdResult atdResult);

}
