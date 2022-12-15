package com.lx.service.impl;

import com.lx.mapper.PollutionMapper;
import com.lx.pojo.Pollution;
import com.lx.service.PollutionService;
import com.lx.util.CountUtils;
import com.lx.util.PollutionUtils;
import com.lx.vo.Geo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PollutionServiceImpl implements PollutionService {

    @Autowired
    private PollutionMapper pollutionMapper;

    @Autowired
    private CountUtils countUtils;

    @Autowired
    private PollutionUtils pollutionUtils;

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
            //double aqi = 55.5;
            Double aqi = countUtils.getAQI(v);

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

    /*
    *  根据省份名称以及年份获取数据
    * */
    @Override
    public List<Map<String, Object>> getCityInfoByProvince(String year, String name) {
        // 判断year 为哪一年也就是查询哪张表
        List<Pollution> pollution = pollutionMapper.selectCityByName(name);
        List<Map<String,Object>> cityInfos = new ArrayList<>();

        pollution.forEach(v->{
            Map<String, Object> map = new LinkedHashMap<>();
            // 计算aqi
            // double aqi = getAQI();
            //double aqi = 55.5;
            Double aqi = countUtils.getAQI(v);

            map.put("name",v.getCity());
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
            cityInfos.add(map);
        });

        return cityInfos;
    }

    /*
    *  获取近六年的污染物平均值
    * */
    @Override
    public Map<String, Object> getSomeAvgCount() {
        Pollution info_2013 = pollutionMapper.selectAvgCount2013();
        Pollution info_2014 = pollutionMapper.selectAvgCount2014();
        Pollution info_2015 = pollutionMapper.selectAvgCount2015();
        Pollution info_2016 = pollutionMapper.selectAvgCount2016();
        Pollution info_2017 = pollutionMapper.selectAvgCount2017();
        Pollution info_2018 = pollutionMapper.selectAvgCount2018();
        // 先放进一个集合进行处理
        // 获取各个平均值

        // 定义平均值集合 aqi、temp、psfc、rh
        Double[] aqiArr = new Double[6];
        Double[] tempArr = new Double[6];
        Double[] psfcArr = new Double[6];
        Double[] rhArr = new Double[6];

        int i = 0;
        List<Pollution> infoList = Arrays.asList(info_2013,info_2014,info_2015,info_2016,info_2017,info_2018);
        infoList.stream().map(info ->{
            // 统一计算aqi
            aqiArr[i] = countUtils.getAQI(info);
            tempArr[i] = info.getTemp();
            psfcArr[i] = info.getPsfc();
            rhArr[i] = info.getRh();
            info.setAqi(countUtils.getAQI(info));
            return info;
        }).collect(Collectors.toList());


        // 组装Map 并返回
        Map<String,Object> map = new HashMap<>();
        map.put("aqi",aqiArr);
        map.put("temp",tempArr);
        map.put("psfc",psfcArr);
        map.put("rh",rhArr);
        return map;
    }

    /*
    *  获取近六年的前十名身份的aqi、no2等污染物
    * */
    @Override
    public List<Map<String, Object>> getTenProvinceAsc() {
        // 处理2013年
        List<Pollution> info_2013 = pollutionMapper.selectAvgCount2013GroupByProvince();
        List<Pollution> pollution_2013 = pollutionUtils.simple(info_2013);
        // 处理2014年
        List<Pollution> info_2014 = pollutionMapper.selectAvgCount2014GroupByProvince();
        List<Pollution> pollution_2014 = pollutionUtils.simple(info_2014);
        // 处理2015年
        List<Pollution> info_2015 = pollutionMapper.selectAvgCount2015GroupByProvince();
        List<Pollution> pollution_2015 = pollutionUtils.simple(info_2015);
        // 处理2016年
        List<Pollution> info_2016 = pollutionMapper.selectAvgCount2016GroupByProvince();
        List<Pollution> pollution_2016 = pollutionUtils.simple(info_2016);
        // 处理2017年
        List<Pollution> info_2017 = pollutionMapper.selectAvgCount2017GroupByProvince();
        List<Pollution> pollution_2017 = pollutionUtils.simple(info_2017);
        // 处理2018年
        List<Pollution> info_2018 = pollutionMapper.selectAvgCount2018GroupByProvince();
        List<Pollution> pollution_2018 = pollutionUtils.simple(info_2018);

        // 开始组装数据
        // 定义平均值集合 aqi、pm2、pm10、so2、no2、co、o3
        // 组装2013年数据
        Double[] aqi_2013 = new Double[10];
        Double[] pm2_2013 = new Double[10];
        Double[] pm10_2013 = new Double[10];
        Double[] so2_2013 = new Double[10];
        Double[] no2_2013 = new Double[10];
        Double[] co_2013 = new Double[10];
        Double[] o3_2013 = new Double[10];
        for (int i = 0; i < info_2013.size(); i++) {
            aqi_2013[i] = info_2013.get(i).getAqi();
            pm2_2013[i] = info_2013.get(i).getPm2();
            pm10_2013[i] = info_2013.get(i).getPm10();
            so2_2013[i] = info_2013.get(i).getSo2();
            no2_2013[i] = info_2013.get(i).getNo2();
            co_2013[i] = info_2013.get(i).getCo();
            o3_2013[i] = info_2013.get(i).getO3();
        }
        // 组装2014年
        Double[] aqi_2014 = new Double[10];
        Double[] pm2_2014 = new Double[10];
        Double[] pm10_2014 = new Double[10];
        Double[] so2_2014 = new Double[10];
        Double[] no2_2014 = new Double[10];
        Double[] co_2014 = new Double[10];
        Double[] o3_2014 = new Double[10];
        for (int i = 0; i < info_2014.size(); i++) {
            aqi_2014[i] = info_2014.get(i).getAqi();
            pm2_2014[i] = info_2014.get(i).getPm2();
            pm10_2014[i] = info_2014.get(i).getPm10();
            so2_2014[i] = info_2014.get(i).getSo2();
            no2_2014[i] = info_2014.get(i).getNo2();
            co_2014[i] = info_2014.get(i).getCo();
            o3_2014[i] = info_2014.get(i).getO3();
        }

        // 组装2015年
        Double[] aqi_2015 = new Double[10];
        Double[] pm2_2015 = new Double[10];
        Double[] pm10_2015 = new Double[10];
        Double[] so2_2015 = new Double[10];
        Double[] no2_2015 = new Double[10];
        Double[] co_2015 = new Double[10];
        Double[] o3_2015 = new Double[10];
        for (int i = 0; i < info_2015.size(); i++) {
            aqi_2015[i] = info_2015.get(i).getAqi();
            pm2_2015[i] = info_2015.get(i).getPm2();
            pm10_2015[i] = info_2015.get(i).getPm10();
            so2_2015[i] = info_2015.get(i).getSo2();
            no2_2015[i] = info_2015.get(i).getNo2();
            co_2015[i] = info_2015.get(i).getCo();
            o3_2015[i] = info_2015.get(i).getO3();
        }

        // 组装2016年
        Double[] aqi_2016 = new Double[10];
        Double[] pm2_2016 = new Double[10];
        Double[] pm10_2016 = new Double[10];
        Double[] so2_2016 = new Double[10];
        Double[] no2_2016 = new Double[10];
        Double[] co_2016 = new Double[10];
        Double[] o3_2016 = new Double[10];
        for (int i = 0; i < info_2016.size(); i++) {
            aqi_2016[i] = info_2016.get(i).getAqi();
            pm2_2016[i] = info_2016.get(i).getPm2();
            pm10_2016[i] = info_2016.get(i).getPm10();
            so2_2016[i] = info_2016.get(i).getSo2();
            no2_2016[i] = info_2016.get(i).getNo2();
            co_2016[i] = info_2016.get(i).getCo();
            o3_2016[i] = info_2016.get(i).getO3();
        }

        // 组装2017年
        Double[] aqi_2017 = new Double[10];
        Double[] pm2_2017 = new Double[10];
        Double[] pm10_2017 = new Double[10];
        Double[] so2_2017 = new Double[10];
        Double[] no2_2017 = new Double[10];
        Double[] co_2017 = new Double[10];
        Double[] o3_2017 = new Double[10];
        for (int i = 0; i < info_2017.size(); i++) {
            aqi_2017[i] = info_2017.get(i).getAqi();
            pm2_2017[i] = info_2017.get(i).getPm2();
            pm10_2017[i] = info_2017.get(i).getPm10();
            so2_2017[i] = info_2017.get(i).getSo2();
            no2_2017[i] = info_2017.get(i).getNo2();
            co_2017[i] = info_2017.get(i).getCo();
            o3_2017[i] = info_2017.get(i).getO3();
        }

        // 组装2018年
        Double[] aqi_2018 = new Double[10];
        Double[] pm2_2018 = new Double[10];
        Double[] pm10_2018 = new Double[10];
        Double[] so2_2018 = new Double[10];
        Double[] no2_2018 = new Double[10];
        Double[] co_2018 = new Double[10];
        Double[] o3_2018 = new Double[10];
        for (int i = 0; i < info_2018.size(); i++) {
            aqi_2018[i] = info_2018.get(i).getAqi();
            pm2_2018[i] = info_2018.get(i).getPm2();
            pm10_2018[i] = info_2018.get(i).getPm10();
            so2_2018[i] = info_2018.get(i).getSo2();
            no2_2018[i] = info_2018.get(i).getNo2();
            co_2018[i] = info_2018.get(i).getCo();
            o3_2018[i] = info_2018.get(i).getO3();
        }

        // 组装完毕开始返回
        List<Map<String,Object>> list = new ArrayList<>();
        // 创建集合组装返回数据
        // 组装返回api
        Map<String,Object> aqiData = new HashMap<>();
        aqiData.put("2018",aqi_2018);
        aqiData.put("2017",aqi_2017);
        aqiData.put("2016",aqi_2016);
        aqiData.put("2015",aqi_2015);
        aqiData.put("2014",aqi_2014);
        aqiData.put("2013",aqi_2013);

        // 组装返回pm2
        Map<String,Object> pm2Data = new HashMap<>();
        aqiData.put("2018",pm2_2018);
        aqiData.put("2017",pm2_2017);
        aqiData.put("2016",pm2_2016);
        aqiData.put("2015",pm2_2015);
        aqiData.put("2014",pm2_2014);
        aqiData.put("2013",pm2_2013);

        // 组装返回pm10
        Map<String,Object> pm10Data = new HashMap<>();
        aqiData.put("2018",pm10_2018);
        aqiData.put("2017",pm10_2017);
        aqiData.put("2016",pm10_2016);
        aqiData.put("2015",pm10_2015);
        aqiData.put("2014",pm10_2014);
        aqiData.put("2013",pm10_2013);

        // 组装返回no2
        Map<String,Object> no2Data = new HashMap<>();
        aqiData.put("2018",no2_2018);
        aqiData.put("2017",no2_2017);
        aqiData.put("2016",no2_2016);
        aqiData.put("2015",no2_2015);
        aqiData.put("2014",no2_2014);
        aqiData.put("2013",no2_2013);

        // 组装返回so2
        Map<String,Object> so2Data = new HashMap<>();
        aqiData.put("2018",so2_2018);
        aqiData.put("2017",so2_2017);
        aqiData.put("2016",so2_2016);
        aqiData.put("2015",so2_2015);
        aqiData.put("2014",so2_2014);
        aqiData.put("2013",so2_2013);

        // 组装返回co
        Map<String,Object> coData = new HashMap<>();
        aqiData.put("2018",co_2018);
        aqiData.put("2017",co_2017);
        aqiData.put("2016",co_2016);
        aqiData.put("2015",co_2015);
        aqiData.put("2014",co_2014);
        aqiData.put("2013",co_2013);

        // 组装返回o3
        Map<String,Object> o3Data = new HashMap<>();
        aqiData.put("2018",o3_2018);
        aqiData.put("2017",o3_2017);
        aqiData.put("2016",o3_2016);
        aqiData.put("2015",o3_2015);
        aqiData.put("2014",o3_2014);
        aqiData.put("2013",o3_2013);

        //放入返回集合并返回
        list.add(aqiData);
        list.add(pm2Data);
        list.add(pm10Data);
        list.add(so2Data);
        list.add(no2Data);
        list.add(coData);
        list.add(o3Data);

        return list;
    }

    /*
    *  获取六年污染物平均值
    * */
    @Override
    public List<Double[]> getSixAverage() {
        // 获取2013年所有污染物
        Pollution info_2013 = pollutionMapper.selectAvgCount2013();
        // 获取2014年所有污染物
        Pollution info_2014 = pollutionMapper.selectAvgCount2014();
        // 获取2013年所有污染物
        Pollution info_2015 = pollutionMapper.selectAvgCount2015();
        // 获取2013年所有污染物
        Pollution info_2016 = pollutionMapper.selectAvgCount2016();
        // 获取2013年所有污染物
        Pollution info_2017 = pollutionMapper.selectAvgCount2017();
        // 获取2013年所有污染物
        Pollution info_2018 = pollutionMapper.selectAvgCount2018();

        List<Pollution> infos = Arrays.asList(info_2013, info_2014, info_2015, info_2016, info_2017, info_2018);

        // 开始组装
        List<Double[]> list = new LinkedList<>();
        // PM2.5数组
        Double[] pm2Arr = new Double[6];
        Double[] pm10Arr = new Double[6];
        Double[] so2Arr = new Double[6];
        Double[] no2Arr = new Double[6];
        Double[] coArr = new Double[6];
        Double[] o3Arr = new Double[6];

        // 组装
        int i = 0;
        infos.forEach(v ->{
            pm2Arr[i] = v.getPm2();
            pm10Arr[i] = v.getPm10();
            so2Arr[i] = v.getSo2();
            no2Arr[i] = v.getNo2();
            coArr[i] = v.getCo();
            o3Arr[i] = v.getO3();
        });

        list.add(pm2Arr);
        list.add(pm10Arr);
        list.add(so2Arr);
        list.add(no2Arr);
        list.add(coArr);
        list.add(o3Arr);

        return list;
    }

}
