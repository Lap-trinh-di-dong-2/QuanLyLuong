package com.example.quanlyluong.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.quanlyluong.Model.ChamCong;

public class DBChamCong {
    DBHelper dbHelper;

    public DBChamCong(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public  void themChamCong(ChamCong chamCong)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("manv",chamCong.getMaNhanVien());
        values.put("tennv",chamCong.getTenNhanVien());
        values.put("ngaycham",chamCong.getThang());
        values.put("songaycong",chamCong.getSoNgayCong());
        db.insert("ChamCong", null, values);
        db.close();
    }
}
