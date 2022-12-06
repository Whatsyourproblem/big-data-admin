package com.lx.mapper;

import com.lx.pojo.Pollution;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Repository
@Mapper
public interface PollutionMapper extends BaseMapper<Pollution> {


    // 分组查询出所有污染物
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,province,`month` from info_2013 GROUP BY province;")
    public List<Pollution> selectAvgPollutionGroupByProvince();
}
