package com.app.coolweather.model;

/**
 * 市一级实体类
 * Created by zhengyangchen on 2015/10/16.
 */
public class City {
    private int id;//id 主键
    private String cityName;//城市名称
    private String cityCode;//城市代码
    private int provinceId;//所属省id
    public static final String TABLE_NAME = "city";//表名
    public static final String COLUMN_CITY_NAME = "cityName";//列
    public static final String COLUMN_CITY_CODE = "cityCode";
    public static final String COLUMN_PROVINCE_ID = "provinceId";

    public City(int id, String cityName, String cityCode, int provinceId) {
        this.id = id;
        this.cityName = cityName;
        this.cityCode = cityCode;
        this.provinceId = provinceId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
