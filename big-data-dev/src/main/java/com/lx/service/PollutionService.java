package com.lx.service;

import java.util.List;
import java.util.Map;

public interface PollutionService {

    public List<Map<String, Object>> getAllProvincePollutions();

    List<Map<String,Object>> getCityInfoByProvince(String year, String name);

    Map<String, Object> getSomeAvgCount();

    List<Map<String, Object>> getTenProvinceAsc();

    List<Double[]> getSixAverage();
}
