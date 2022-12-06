package com.lx.util;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountUtils {

    // 计算各项污染物指标
    // 计算PM2.5的IAQI
    public static double countPm2IAQI(double pm2){


        double bph = 0; // 与 cp相近的污染物浓度限值的高位值
        double bpl = 0; // 与 cp相近的污染物浓度限值的低位值
        double iaqih = 0; // 与 bph对应的空气质量分指数
        double iaqil = 0; // 与 bpl对应的空气质量分指数
        double iaqip = 0; // 当前污染物项目P的空气质量分指数

        int[] aqiArr = { 0, 35, 75, 115, 150, 250, 350, 500 };
        double max = 500;
        double min = 0;
        if (pm2 <= min || pm2 >= max){
            return 0;
        }else {
            for (int i = 0; i < aqiArr.length; i++) {
                if (pm2 < aqiArr[i]){
                    // 接着完善
                    bph = aqiArr[i];
                    bpl = aqiArr[i - 1];
                    iaqih = aqiArr[i];
                    iaqil = aqiArr[i - 1];
                    break;
                }
            }
        }
        return 0;
    }


    // 计算AQI
    public Double getAQI(){

        return 2.0;
    }

    // 格式化浮点数
    public Double[] formatData(List<Double> pollutions){

        Double[] doubles = new Double[pollutions.size()];
        for (int i = 0; i < pollutions.size(); i++) {
            doubles[i] = Double.parseDouble(String.format("%.2f", pollutions.get(i)));
        }
        return doubles;
    }



}
