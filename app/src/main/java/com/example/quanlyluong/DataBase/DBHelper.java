package com.example.quanlyluong.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context,"SQLQuanLyLuong",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "Create table PhongBan (ma text, ten text) ";
        sqLiteDatabase.execSQL(sql);
        String sqlNhanVien ="Create table NhanVien (ma text, ten text, ngaysinh text, gioitinh text,phongban text, hesoluong text)";
        sqLiteDatabase.execSQL(sqlNhanVien);
}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
