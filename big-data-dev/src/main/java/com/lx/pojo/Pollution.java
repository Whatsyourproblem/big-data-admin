package com.lx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "info_2013")
public class Pollution implements Serializable {

    // id 自增
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // pm2.5 含量
    private Double pm2;

    // pm10 含量
    private Double pm10;

    // SO2含量
    private Double so2;

    // NO2含量
    private Double no2;

    // CO含量
    private Double co;

    // O3含量
    private Double o3;

    // U纬向风速
    private Double u;

    //V经向风速
    private Double v;

    // TEMP温度
    private Double temp;

    // RH 相对湿度
    private Double rh;

    // PSFC 地面气压
    private Double psfc;

    // lat 中心维度
    private Double lat;

    // lon 中心经度
    private Double lon;

    // aqi空气质量指数
    private Double aqi;

    // 省
    private String province;

    // 市
    private String city;

    // 区
    private String district;

    // 月份
    private Integer month;
}
