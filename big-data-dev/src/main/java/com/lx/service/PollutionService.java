package com.lx.service;

import com.lx.vo.PollutionDTO;

import java.util.List;
import java.util.Map;

public interface PollutionService {

    public List<Map<String, Object>> getAllProvincePollutions();

    List<Map<String,Object>> getCityInfoByProvince(String year,String name);

    Map<String, Object> getSomeAvgCount();

    List<Map<String, Object>> getTenProvinceAsc();

    List<Double[]> getSixAverage();

    List<Map<String, Object>> getInfoByYear(String year);

    Map<String, Object> getSomeCityAvgCount(String name);

    List<Map<String, Object>> getTenCityAsc(String name);

    List<Double[]> getSixAverageByProvince(String name);
}
