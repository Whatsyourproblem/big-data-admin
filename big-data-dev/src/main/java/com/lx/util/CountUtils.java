package com.lx.util;

import com.lx.pojo.Pollution;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class CountUtils {

    private static int[] aqiArr = { 0, 50, 100, 150, 200, 300, 400, 500 };

    // 计算各项污染物指标
    // 计算PM2.5的IAQI
    public static double countPm2IAQI(double pm2){
        double bph = 0; // 与 cp相近的污染物浓度限值的高位值
        double bpl = 0; // 与 cp相近的污染物浓度限值的低位值
        double iaqih = 0; // 与 bph对应的空气质量分指数
        double iaqil = 0; // 与 bpl对应的空气质量分指数
        double iaqip = 0; // 当前污染物项目P的空气质量分指数

        int[] pm2Arr = { 0, 35, 75, 115, 150, 250, 350, 500 };
        double max = 500;
        double min = 0;
        if (pm2 <= min || pm2 >= max){
            return 0;
        }else {
            for (int i = 0; i < aqiArr.length; i++) {
                if (pm2 < pm2Arr[i]){
                    // 接着完善
                    bph = pm2Arr[i];
                    bpl = pm2Arr[i - 1];
                    iaqih = aqiArr[i];
                    iaqil = aqiArr[i - 1];
                    break;
                }
            }
            // 计算污染物项目 P的空气质量分指数
            iaqip = (iaqih - iaqil) / (bph - bpl) * (pm2 - bpl) + iaqil;
            BigDecimal bg = new BigDecimal(iaqip);
            double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return f1;
        }
    }

    // 计算PM10的IAQI
    public static double countPm10IAQI(double pm10){
        double bph = 0; // 与 cp相近的污染物浓度限值的高位值
        double bpl = 0; // 与 cp相近的污染物浓度限值的低位值
        double iaqih = 0; // 与 bph对应的空气质量分指数
        double iaqil = 0; // 与 bpl对应的空气质量分指数
        double iaqip = 0; // 当前污染物项目P的空气质量分指数

        int[] pm10Arr = { 0, 50, 150, 250, 350, 420, 500, 600 };
        double max = 600;
        double min = 0;
        if (pm10 <= min || pm10 >= max){
            return 0;
        }else {
            for (int i = 0; i < aqiArr.length; i++) {
                if (pm10 < pm10Arr[i]){
                    // 接着完善
                    bph = pm10Arr[i];
                    bpl = pm10Arr[i - 1];
                    iaqih = aqiArr[i];
                    iaqil = aqiArr[i - 1];
                    break;
                }
            }
            // 计算污染物项目 P的空气质量分指数
            iaqip = (iaqih - iaqil) / (bph - bpl) * (pm10 - bpl) + iaqil;
            BigDecimal bg = new BigDecimal(iaqip);
            double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return f1;
        }
    }

    // 计算CO的IAQI
    public static double countCoIAQI(double co){
        double bph = 0; // 与 cp相近的污染物浓度限值的高位值
        double bpl = 0; // 与 cp相近的污染物浓度限值的低位值
        double iaqih = 0; // 与 bph对应的空气质量分指数
        double iaqil = 0; // 与 bpl对应的空气质量分指数
        double iaqip = 0; // 当前污染物项目P的空气质量分指数

        int[] CoArr = { 0, 2, 4, 14, 24, 36, 48, 60 };
        double max = 60;
        double min = 0;
        if (co <= min || co >= max){
            return 0;
        }else {
            for (int i = 0; i < aqiArr.length; i++) {
                if (co < CoArr[i]){
                    // 接着完善
                    bph = CoArr[i];
                    bpl = CoArr[i - 1];
                    iaqih = aqiArr[i];
                    iaqil = aqiArr[i - 1];
                    break;
                }
            }
            // 计算污染物项目 P的空气质量分指数
            iaqip = (iaqih - iaqil) / (bph - bpl) * (co - bpl) + iaqil;
            BigDecimal bg = new BigDecimal(iaqip);
            double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return f1;
        }
    }


    // 计算No2的IAQI
    public static double countNo2IAQI(double no2){
        double bph = 0; // 与 cp相近的污染物浓度限值的高位值
        double bpl = 0; // 与 cp相近的污染物浓度限值的低位值
        double iaqih = 0; // 与 bph对应的空气质量分指数
        double iaqil = 0; // 与 bpl对应的空气质量分指数
        double iaqip = 0; // 当前污染物项目P的空气质量分指数

        int[] No2Arr = { 0, 40, 80, 180, 280, 565, 750, 940 };
        double max = 940;
        double min = 0;
        if (no2 <= min || no2 >= max){
            return 0;
        }else {
            for (int i = 0; i < aqiArr.length; i++) {
                if (no2 < No2Arr[i]){
                    // 接着完善
                    bph = No2Arr[i];
                    bpl = No2Arr[i - 1];
                    iaqih = aqiArr[i];
                    iaqil = aqiArr[i - 1];
                    break;
                }
            }
            // 计算污染物项目 P的空气质量分指数
            iaqip = (iaqih - iaqil) / (bph - bpl) * (no2 - bpl) + iaqil;
            BigDecimal bg = new BigDecimal(iaqip);
            double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return f1;
        }
    }

    // 计算O3的IAQI
    public static double countO3IAQI(double o3){
        double bph = 0; // 与 cp相近的污染物浓度限值的高位值
        double bpl = 0; // 与 cp相近的污染物浓度限值的低位值
        double iaqih = 0; // 与 bph对应的空气质量分指数
        double iaqil = 0; // 与 bpl对应的空气质量分指数
        double iaqip = 0; // 当前污染物项目P的空气质量分指数

        int[] O3Arr = { 0, 160, 200, 300, 400, 800, 1000, 1200 };
        double max = 1200;
        double min = 0;
        if (o3 <= min || o3 >= max){
            return 0;
        }else {
            for (int i = 0; i < aqiArr.length; i++) {
                if (o3 < O3Arr[i]){
                    // 接着完善
                    bph = O3Arr[i];
                    bpl = O3Arr[i - 1];
                    iaqih = aqiArr[i];
                    iaqil = aqiArr[i - 1];
                    break;
                }
            }
            // 计算污染物项目 P的空气质量分指数
            iaqip = (iaqih - iaqil) / (bph - bpl) * (o3 - bpl) + iaqil;
            BigDecimal bg = new BigDecimal(iaqip);
            double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return f1;
        }
    }

    // 计算So2的IAQI
    public static double countSo2IAQI(double so2){
        double bph = 0; // 与 cp相近的污染物浓度限值的高位值
        double bpl = 0; // 与 cp相近的污染物浓度限值的低位值
        double iaqih = 0; // 与 bph对应的空气质量分指数
        double iaqil = 0; // 与 bpl对应的空气质量分指数
        double iaqip = 0; // 当前污染物项目P的空气质量分指数

        int[] So2Arr =     { 0, 50, 150, 475, 800, 1600, 2100, 2620 };
        double max = 2620;
        double min = 0;
        if (so2 <= min || so2 >= max){
            return 0;
        }else {
            for (int i = 0; i < aqiArr.length; i++) {
                if (so2 < So2Arr[i]){
                    // 接着完善
                    bph = So2Arr[i];
                    bpl = So2Arr[i - 1];
                    iaqih = aqiArr[i];
                    iaqil = aqiArr[i - 1];
                    break;
                }
            }
            // 计算污染物项目 P的空气质量分指数
            iaqip = (iaqih - iaqil) / (bph - bpl) * (so2 - bpl) + iaqil;
            BigDecimal bg = new BigDecimal(iaqip);
            double f1 = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            return f1;
        }
    }

    // 计算AQI
    public Double getAQI(Pollution pollution){

        // 注意这里的O3为8小时滑动平均，其他污染物均为24小时平均
        double pm2 = countPm2IAQI(pollution.getPm2());
        double pm10 = countPm10IAQI(pollution.getPm10());
        double no2 = countNo2IAQI(pollution.getNo2());
        double so2 = countSo2IAQI(pollution.getSo2());
        double co = countCoIAQI(pollution.getCo());
        //double o3 = countPm2IAQI(pollution.getO3());
        Double[] aqi = {pm2,pm10,no2,so2,co};
        List<Double> list = Arrays.asList(aqi);
        Double max = Collections.max(list);
        return max;
    }

    // 格式化浮点数
    public Double[] formatData(List<Double> pollutions){

        Double[] doubles = new Double[pollutions.size()];
        for (int i = 0; i < pollutions.size(); i++) {
            doubles[i] = Double.parseDouble(String.format("%.2f", pollutions.get(i)));
        }
        return doubles;
    }


    // 格式化省 例如将黑龙江省格式化成黑龙江 上海市格式化成上海
    public String formatProvince(String province){
        // 判断是否包含省
        if (province.contains("省")){
            return province.replace("省","");
        } else if (province.contains("市")){
            return province.replace("市","");
        }else if (province.contains("自治区")){
            // 单独处理内蒙古
            if (province.contains("内蒙古")){
                return province.substring(0,3);
            }
            return province.substring(0,2);
        }else if(province.contains("行政区")){
            return province.substring(0,2);
        }else {
            return "";
        }
    }


    // 格式化城市
    public String formatCity(String city){
        // 判断是否包含省
        if (city.contains("市")) {
            return city.replace("市", "");
        } else if (city.contains("自治州")){
            return city.replace("自治州", "");
        } else if (city.contains("地区")){
            return city.replace("地区", "");
        }else if (city.contains("盟")){
            return city.replace("盟", "");
        }else if (city.contains("林区")){
            return city.replace("林区","");
        }else {
            return city;
        }
    }




}
