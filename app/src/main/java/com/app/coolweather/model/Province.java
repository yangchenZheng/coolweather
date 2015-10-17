package com.app.coolweather.model;

/**
 * 省实体类
 * Created by zhengyangchen on 2015/10/16.
 */
public class Province {
    private int id;//id 主键
    private String provinceName;//省的名称
    private String provinceCode;//省得代码
    public static final String TABLE_NAME = "tb_province";//表名
    public static final String COLUMN_PROVINCE_NAME = "provinceName";//列
    public static final String COLUMN_PROVINCE_CODE = "provinceCode";//列

    public Province(int id, String provinceName, String provinceCode) {
        this.id = id;
        this.provinceName = provinceName;
        this.provinceCode = provinceCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
