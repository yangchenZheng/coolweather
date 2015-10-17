package com.app.coolweather.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.app.coolweather.model.City;
import com.app.coolweather.model.County;
import com.app.coolweather.model.Province;

/**
 * Created by zhengyangchen on 2015/10/16.
 */
public class CoolWeatherOpenHelper extends SQLiteOpenHelper {
    /**
     * Province建表语句
     */
    public static final String CREATE_PROVINCE = "create table" + Province.TABLE_NAME + "("
            + "id integer primary key autoincrement,"
            + Province.COLUMN_PROVINCE_NAME + "text,"
            + Province.COLUMN_PROVINCE_CODE + "text"
            + ")";
    /**
     * City建表语句
     */
    public static final String CREATE_CITY = "create table" + City.TABLE_NAME + "("
            + "id integer primary key autoincrement,"
            + City.COLUMN_CITY_NAME + "text,"
            + City.COLUMN_CITY_CODE + "text,"
            + City.COLUMN_PROVINCE_ID + "integer"
            + ")";
    /**
     * County建表语句
     */
    public static final String CREATE_COUNTY = "create table" + County.TABLE_NAME + "("
            + "id integer primary key autoincrement,"
            + County.COLUMN_CITY_NAME + "text,"
            + County.COLUMN_CITY_CODE + "text,"
            + County.COLUMN_CITY_ID + "integer"
            + ")";


    public CoolWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);//创建Province表
        db.execSQL(CREATE_CITY);//创建City表
        db.execSQL(CREATE_COUNTY);//创建County表
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
