package com.lx.service.impl;

import com.lx.mapper.PollutionMapper;
import com.lx.pojo.Pollution;
import com.lx.service.PollutionService;
import com.lx.util.CountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PollutionServiceImpl implements PollutionService {

    @Autowired
    private PollutionMapper pollutionMapper;

    @Autowired
    private CountUtils countUtils;

    /*
    *  获取所有省份平均污染水平
    * */
    @Override
    public List<Map<String, Object>> getAllProvincePollutions() {
        // 开始进行业务处理


        List<Pollution> pollution = pollutionMapper.selectAvgPollutionGroupByProvince();

        List<Map<String,Object>> pollutions = new ArrayList<>();

        pollution.forEach(v ->{
            Map<String, Object> map = new LinkedHashMap<>();
            // 计算aqi
            // double aqi = getAQI();
            double aqi = 55.5;

            map.put("name",v.getProvince());
            List<Double> doubles = new LinkedList<>();
            // 保留两位小数
            doubles.add(v.getLon());
            doubles.add(v.getLat());
            doubles.add(aqi);
            doubles.add(v.getPm2());
            doubles.add(v.getPm10());
            doubles.add(v.getSo2());
            doubles.add(v.getNo2());
            doubles.add(v.getCo());
            doubles.add(v.getO3());

            // 格式化doubles
            Double[] formatData = countUtils.formatData(doubles);
            map.put("value",formatData);

            // 放入集合
            pollutions.add(map);
        });
        return pollutions;
    }
}
