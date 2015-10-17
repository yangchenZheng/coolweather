package com.app.coolweather.model;

/**
 * 县实体类
 * Created by zhengyangchen on 2015/10/16.
 */
public class County {

    private int id;//id 主键
    private String countyName;//县名称
    private String countyCode;//县代码
    private int cityId;//所属市id
    public static final String TABLE_NAME = "county";//表名
    public static final String COLUMN_CITY_NAME = "countyName";//列
    public static final String COLUMN_CITY_CODE = "countyCode";
    public static final String COLUMN_CITY_ID = "cityId";

    public County(int id, String countyName, String countyCode, int cityId) {
        this.id = id;
        this.countyName = countyName;
        this.countyCode = countyCode;
        this.cityId = cityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getCountyCode() {
        return countyCode;
    }

    public void setCountyCode(String countyCode) {
        this.countyCode = countyCode;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }
}
