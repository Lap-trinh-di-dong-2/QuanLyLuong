package com.example.quanlyluong.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.quanlyluong.Model.ChamCong;
import com.example.quanlyluong.Model.TamUng;

import java.util.ArrayList;

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
        values.put("ngaycham",chamCong.getThang());
        values.put("songaycong",chamCong.getSoNgayCong());
        db.insert("ChamCong", null, values);
        db.close();
    }
    public ArrayList<ChamCong> layDuLieu() {
        ArrayList<ChamCong> data = new ArrayList<>();
        String sql = "Select * from ChamCong ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            cursor.moveToFirst();
            do {
                ChamCong chamCong = new ChamCong();
                chamCong.setMaNhanVien(cursor.getString(0));
                chamCong.setThang(cursor.getString(1));
                chamCong.setSoNgayCong(cursor.getString(2));
                data.add(chamCong);
            }
            while (cursor.moveToNext());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public void xoaChamCong(ChamCong chamCong) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("TamUng", "manv= '" + chamCong.getMaNhanVien() + "'", null);
        db.close();
    }
}
