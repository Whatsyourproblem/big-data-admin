package com.lx.controller;


import com.lx.common.R;
import com.lx.pojo.Pollution;
import com.lx.service.PollutionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Api(tags = "污染物接口")
@RestController
@CrossOrigin
public class PollutionController {

    @Autowired
    private PollutionService pollutionService;

    @GetMapping("/api/pollution/get_all_province")
    @ApiOperation("获取中国地图各个省的污染平均值")
    public R getAllProvincePollutions(){
        List<Map<String, Object>> pollutions = pollutionService.getAllProvincePollutions();
        return R.ok(pollutions,"查询成功!");
    }

}
