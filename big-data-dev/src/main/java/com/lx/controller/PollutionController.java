package com.lx.controller;


import com.lx.common.R;
import com.lx.pojo.Pollution;
import com.lx.service.PollutionService;
import com.lx.vo.PollutionDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Api(tags = "污染物接口")
@RestController
@RequestMapping("/api/pollution/")
@CrossOrigin
public class PollutionController {

    @Autowired
    private PollutionService pollutionService;

    /*
    *  这里后续要拓展为根据 年份进行查询
    * */
    @GetMapping("get_all_province")
    @ApiOperation("获取中国地图各个省的污染平均值")
    public R getAllProvincePollutions(){
        List<Map<String, Object>> pollutions = pollutionService.getAllProvincePollutions();
        return R.ok(pollutions,"查询成功!");
    }

    @GetMapping("get_info_by_year/{year}")
    @ApiOperation("根据年份获取各个省的污染物平均值")
    public R getInfoByYear(@PathVariable String year){
        List<Map<String, Object>> pollutions = pollutionService.getInfoByYear(year);
        return R.ok(pollutions,"查询成功!");
    }

    @GetMapping("get_city_by_province/{year}/{name}")
    @ApiOperation("根据省的名称获取城市污染数据")
    public R getCityInfoByProvince(@PathVariable String year,@PathVariable String name){
        List<Map<String, Object>> cityInfoByProvince = pollutionService.getCityInfoByProvince(year,name);
        return R.ok(cityInfoByProvince);
    }

    @GetMapping("get_some_average")
    @ApiOperation("获取近六年省份污染物平均值")
    public R getSomeAvgCount(){
        Map<String,Object> countMap  = pollutionService.getSomeAvgCount();
        return R.ok(countMap);
    }

    @GetMapping("get_some_city_average/{name}")
    @ApiOperation("获取目标年城市污染物平均值")
    public R getSomeCityAvgCount(@PathVariable String name){
        Map<String,Object> countMap  = pollutionService.getSomeCityAvgCount(name);
        return R.ok(countMap);
    }

    // 获取每年AQI前十名省份，其他污染物按照aqi城市顺序返回
    @GetMapping("get_ten_aqi_asc")
    @ApiOperation("获取近六年的前十个省的污染物数据")
    public R getTenProvinceAsc(){
        List<Map<String,Object>> map = pollutionService.getTenProvinceAsc();
        return R.ok(map);
    }


    // 获取六年污染物平均值
    @GetMapping("get_six_average")
    @ApiOperation("获取近六年污染物平均值")
    public R getSixAverage(){
        List<Double[]> list = pollutionService.getSixAverage();
        return R.ok(list);
    }

    // 获取当前年份、省份的城市污染物数据前十名
    @GetMapping("get_ten_city_aqi_asc/{name}")
    @ApiOperation("获取近六年某省份的前十名城市污染物数据")
    public R getTenCityAsc(@PathVariable String name){
        List<Map<String,Object>> map = pollutionService.getTenCityAsc(name);
        return R.ok(map);
    }

    // 获取近六年某省份的污染物平均数据
    @GetMapping("get_six_average_province/{name}")
    @ApiOperation("获取近六年某省份的污染物平均数据")
    public R getSixAverageByProvince(@PathVariable String name){
        List<Double[]> list = pollutionService.getSixAverageByProvince(name);
        return R.ok(list);
    }

}
