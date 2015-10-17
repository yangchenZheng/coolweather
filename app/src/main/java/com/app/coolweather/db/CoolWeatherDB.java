package com.app.coolweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;

import com.app.coolweather.model.City;
import com.app.coolweather.model.County;
import com.app.coolweather.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * 封装常用的数据库操作
 * Created by zhengyangchen on 2015/10/16.
 */
public class CoolWeatherDB {
    /**
     * 数据库名
     */
    public static final String DB_NAME = "cool_weather";

    /**
     * 数据库版本
     */
    public static final int VERSION = 1;

    private static CoolWeatherDB coolWeatherDB;

    private SQLiteDatabase db;

    /**
     * 单利模式 将构造方法私有
     */
    private CoolWeatherDB(Context context) {
        CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);//实例数据库帮助类
        db = dbHelper.getWritableDatabase();
    }

    /**
     * 单例模式 获取CoolWeather实例
     *
     * @param context
     * @return
     */
    public synchronized static CoolWeatherDB getInstance(Context context) {
        if (coolWeatherDB == null) {
            coolWeatherDB = new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }

    /**
     * 将Province实例存储到数据库
     */
    public void saveProvince(Province province) {
        if (province == null) {
            ContentValues values = new ContentValues();
            values.put(Province.COLUMN_PROVINCE_NAME, province.getProvinceName());
            values.put(Province.COLUMN_PROVINCE_CODE, province.getProvinceCode());
            db.insert(Province.TABLE_NAME, null, values);
        }
    }

    /**
     * 从数据库读取全国所有省份的信息
     *
     * @return
     */
    public List<Province> loadProvince() {
        List<Province> list = new ArrayList<Province>();
        Cursor cursor = db.query(Province.TABLE_NAME, null, null, null, null, null, null);
        if (cursor.moveToFirst()) {//判断cursor中是否存在数据
            do {
                list.add(new Province(cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex(Province.COLUMN_PROVINCE_NAME)),
                        cursor.getString(cursor.getColumnIndex(Province.COLUMN_PROVINCE_CODE))));
            } while (cursor.moveToNext());

        }
        if (cursor != null) {
            cursor.close();
        }
        return list;
    }

    /**
     * 将city实例存储到数据库
     *
     * @param city
     */
    public void saveCity(City city) {
        ContentValues values = new ContentValues();
        values.put(City.COLUMN_CITY_NAME, city.getCityName());
        values.put(City.COLUMN_CITY_CODE, city.getCityCode());
        values.put(City.COLUMN_PROVINCE_ID, city.getProvinceId());
        db.insert(City.TABLE_NAME, null, values);
    }

    /**
     * 从数据库中读取某省下的所有城市信息
     *
     * @return
     */
    public List<City> loadCity(int provinceId) {
        List<City> list = new ArrayList<City>();
        Cursor cursor = db.query(City.TABLE_NAME, null, City.COLUMN_PROVINCE_ID + "= ?", new String[]{String.valueOf(provinceId)}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(new City(cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex(City.COLUMN_CITY_NAME)),
                        cursor.getString(cursor.getColumnIndex(City.COLUMN_CITY_CODE)),
                        cursor.getInt(cursor.getColumnIndex(City.COLUMN_PROVINCE_ID))));
            } while (cursor.moveToNext());

        }
        if (cursor != null) {
            cursor.close();
        }
        return list;
    }

    /**
     * 将县实例添加到数据库中
     *
     * @param county
     */
    public void saveCounty(County county) {
        ContentValues values = new ContentValues();
        values.put(County.COLUMN_CITY_NAME, county.getCountyName());
        values.put(County.COLUMN_CITY_CODE, county.getCountyCode());
        values.put(County.COLUMN_CITY_ID, county.getCityId());
        db.insert(County.TABLE_NAME, null, values);
    }

    /**
     * 从数据库中获取所有县的信息
     *
     * @return
     */
    public List<County> loadCounty(int cityId) {
        List<County> list = new ArrayList<County>();
        Cursor cursor = db.query(County.TABLE_NAME, null, City.COLUMN_PROVINCE_ID + "= ?", new String[]{String.valueOf(cityId)}, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                list.add(new County(cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex(County.COLUMN_CITY_NAME)),
                        cursor.getString(cursor.getColumnIndex(County.COLUMN_CITY_CODE)),
                        cursor.getInt(cursor.getColumnIndex(County.COLUMN_CITY_ID))));
            } while (cursor.moveToNext());
        }
        if (cursor != null) {
            cursor.close();
        }
        return list;
    }

}
