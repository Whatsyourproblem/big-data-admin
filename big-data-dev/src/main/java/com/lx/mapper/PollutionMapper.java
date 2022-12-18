package com.lx.mapper;

import com.lx.pojo.Pollution;
import com.lx.vo.Geo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Repository
@Mapper
public interface PollutionMapper extends BaseMapper<Pollution> {


    // 分组查询出所有污染物
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,province,`month` from info_2013 GROUP BY province")
    public List<Pollution> selectAvgPollutionGroupByProvince();

    // ------------------------------------------------------------------------------

    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,province,city,`month` from info_2018 where province = #{name} GROUP BY city")
    List<Pollution> selectCityByName2018(String name);

    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,province,city,`month` from info_2017 where province = #{name} GROUP BY city")
    List<Pollution> selectCityByName2017(String name);

    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,province,city,`month` from info_2016 where province = #{name} GROUP BY city")
    List<Pollution> selectCityByName2016(String name);

    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,province,city,`month` from info_2015 where province = #{name} GROUP BY city")
    List<Pollution> selectCityByName2015(String name);

    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,province,city,`month` from info_2014 where province = #{name} GROUP BY city")
    List<Pollution> selectCityByName2014(String name);

    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,province,city,`month` from info_2013 where province = #{name} GROUP BY city")
    List<Pollution> selectCityByName2013(String name);

    //------------------------------------------------------------------

    /*
    *  2013年全球平均污染物 不按省分组
    * */
    @Select("SELECT AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,`month` from info_2013")
    Pollution selectAvgCount2013();

    /*
     *  2014年全球平均污染物 不按省分组
     * */
    @Select("SELECT AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,`month` from info_2014")
    Pollution selectAvgCount2014();

    /*
     *  2015年全球平均污染物 不按省分组
     * */
    @Select("SELECT AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,`month` from info_2015")
    Pollution selectAvgCount2015();

    /*
     *  2016年全球平均污染物 不按省分组
     * */
    @Select("SELECT AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,`month` from info_2016")
    Pollution selectAvgCount2016();

    /*
     *  2017年全球平均污染物 不按省分组
     * */
    @Select("SELECT AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,`month` from info_2017")
    Pollution selectAvgCount2017();

    /*
     *  2018年全球平均污染物 不按省分组
     * */
    @Select("SELECT AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,`month` from info_2018")
    Pollution selectAvgCount2018();


    //-----------------------------------------------------------------------------------------
    /*
    *  按省分组查询出每一年各省市的污染物数据 2013年
    * */
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,`month`,province from info_2013 Group By province")
    List<Pollution> selectAvgCount2013GroupByProvince();

    /*
     *  按省分组查询出每一年各省市的污染物数据 2014年
     * */
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,`month`,province from info_2014 Group By province")
    List<Pollution> selectAvgCount2014GroupByProvince();


    /*
     *  按省分组查询出每一年各省市的污染物数据 2015年
     * */
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,`month`,province from info_2015 Group By province")
    List<Pollution> selectAvgCount2015GroupByProvince();

    /*
     *  按省分组查询出每一年各省市的污染物数据 2016年
     * */
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,`month`,province from info_2016 Group By province")
    List<Pollution> selectAvgCount2016GroupByProvince();


    /*
     *  按省分组查询出每一年各省市的污染物数据 2017年
     * */
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,`month`,province from info_2017 Group By province")
    List<Pollution> selectAvgCount2017GroupByProvince();


    /*
     *  按省分组查询出每一年各省市的污染物数据 2018年
     * */
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,AVG(lat) as lat,AVG(lon) as lon,`month`,province from info_2018 Group By province")
    List<Pollution> selectAvgCount2018GroupByProvince();

    /*
    * -----------------------------------------------------------------
    * */

    /*
     *  2013年某省平均污染物
     * */
    @Select("SELECT AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc from info_2013 where province = #{name}")
    Pollution selectAvgCount2013ByProvince(String name);

    /*
     *  2014年某省平均污染物
     * */
    @Select("SELECT AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc from info_2014 where province = #{name}")
    Pollution selectAvgCount2014ByProvince(String name);

    /*
     *  2015年某省平均污染物
     * */
    @Select("SELECT AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc from info_2015 where province = #{name}")
    Pollution selectAvgCount2015ByProvince(String name);


    /*
     *  2016年某省平均污染物
     * */
    @Select("SELECT AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc from info_2016 where province = #{name}")
    Pollution selectAvgCount2016ByProvince(String name);


    /*
     *  2017年某省平均污染物
     * */
    @Select("SELECT AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc from info_2017 where province = #{name}")
    Pollution selectAvgCount2017ByProvince(String name);

    /*
     *  2018年某省平均污染物
     * */
    @Select("SELECT AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc from info_2018 where province = #{name}")
    Pollution selectAvgCount2018ByProvince(String name);







    // ----------------------------------------------------------------------
    /*
    *  指定省份，获取近六年的城市污染物前十名
    * */
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,province,city from info_2013 where province = #{name} Group By city")
    List<Pollution> selectAvgCount2013GroupByCity(String name);

    /*
     *  指定省份，获取近六年的aqi、温度、湿度  2014年
     * */
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,province,city from info_2014 where province = #{name} Group By city")
    List<Pollution> selectAvgCount2014GroupByCity(String name);

    /*
     *  指定省份，获取近六年的aqi、温度、湿度  2015年
     * */
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,province,city from info_2015 where province = #{name} Group By city")
    List<Pollution> selectAvgCount2015GroupByCity(String name);

    /*
     *  指定省份，获取近六年的aqi、温度、湿度  2016年
     * */
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,province,city from info_2016 where province = #{name} Group By city")
    List<Pollution> selectAvgCount2016GroupByCity(String name);

    /*
     *  指定省份，获取近六年的aqi、温度、湿度  2017年
     * */
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,province,city from info_2017 where province = #{name} Group By city")
    List<Pollution> selectAvgCount2017GroupByCity(String name);

    /*
     *  指定省份，获取近六年的aqi、温度、湿度  2018年
     * */
    @Select("SELECT id,AVG(pm2) as pm2,AVG(pm10) as pm10,AVG(so2) as so2,AVG(no2) as no2,AVG(co) as co,AVG(o3) as o3,AVG(u) as u,AVG(v) as v,AVG(temp) as temp,AVG(rh) as rh,AVG(psfc) as psfc,province,city from info_2018 where province = #{name} Group By city")
    List<Pollution> selectAvgCount2018GroupByCity(String name);
}
