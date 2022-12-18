package com.lx.util;

import com.lx.pojo.Pollution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PollutionUtils {

    @Autowired
    private CountUtils countUtils;

    // 数据处理、获取aqi、根据aqi排序
    public List<Pollution> simple(List<Pollution> infos){
        // 过滤为null的
        List<Pollution> newInfos = infos.stream().filter(x -> x.getPm2() != null || "".equals(x.getCity())).collect(Collectors.toList());

        // 获取AQI
        newInfos.stream().map(info ->{
            info.setAqi(countUtils.getAQI(info));
            return info;
        }).collect(Collectors.toList());
        // 根据AQI排序返回
        List<Pollution> pollutionList = newInfos.stream().sorted(Comparator.comparing(Pollution::getAqi)).collect(Collectors.toList());
        // 截取pollitionList前十条记录
        if (pollutionList.size() > 10){
            return pollutionList.subList(0,10);
        }else {
            return pollutionList;
        }
    };
}
