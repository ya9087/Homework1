package com.example.hyeseong.homework1;

import android.provider.BaseColumns;

public class RestaurantInformation {

    public static final String DB_NAME = "Restaurant.db";
    public static final int DATABASE_VERSION = 1;
    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";

    private RestaurantInformation() {
    }

    public static class Restaurants implements BaseColumns {
        public static final String TABLE_NAME = "Restaurants";
        public static final String KEY_NAME = "Name";
        public static final String KEY_ADDRESS = "Address";
        public static final String KEY_PHONE = "Phone";
        public static final String KEY_IMAGE = "Image";


        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                KEY_NAME + TEXT_TYPE + COMMA_SEP +
                KEY_ADDRESS + TEXT_TYPE + COMMA_SEP +
                KEY_PHONE + TEXT_TYPE + COMMA_SEP +
                KEY_IMAGE + TEXT_TYPE + " )";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }


    public static class Menu implements BaseColumns {
        public static final String TABLE_NAME = "Menu";
        public static final String KEY_NAME = "Name";
        public static final String KEY_Price = "Price";
        public static final String KEY_Explanation = "Explanation";
        public static final String KEY_IMAGE = "Image";

        public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY" + COMMA_SEP +
                KEY_NAME + TEXT_TYPE + COMMA_SEP +
                KEY_Price + TEXT_TYPE + COMMA_SEP +
                KEY_Explanation + TEXT_TYPE + COMMA_SEP +
                KEY_IMAGE + TEXT_TYPE + " )";
        public static final String DELETE_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
