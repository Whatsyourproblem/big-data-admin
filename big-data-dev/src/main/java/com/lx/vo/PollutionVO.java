package com.lx.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PollutionVO {

    // 省的名字
    private String name;

    // 省信息
    private List<Map<String,Object>> pollutions;
}
