package com.example.quanlyluong.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlyluong.Model.PhongBan;
import com.example.quanlyluong.Model.TamUng;

import java.util.ArrayList;

public class DBTamUng {
    DBHelper dbHelper;
    public DBTamUng(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public void themTamUng(TamUng tamUng) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("sophieu", tamUng.getSoPhieu());
        values.put("ngay", tamUng.getNgayUng());
        values.put("sotien", tamUng.getSoTien());
        values.put("manv", tamUng.getMaNhanVien());
        db.insert("TamUng", null, values);
        db.close();
    }

    public ArrayList<TamUng> layDuLieu() {
        ArrayList<TamUng> data = new ArrayList<>();
        String sql = "Select * from TamUng";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            cursor.moveToFirst();
            do {
                TamUng tamUng = new TamUng();
                tamUng.setSoPhieu(cursor.getString(0));
                tamUng.setNgayUng(cursor.getString(1));
                tamUng.setSoTien(cursor.getString(2));
                tamUng.setMaNhanVien(cursor.getString(3));
                data.add(tamUng);
            }
            while (cursor.moveToNext());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public void xoaTamUng(TamUng tamUng) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("TamUng", "sophieu= '" + tamUng.getSoPhieu() + "'", null);
        db.close();
    }
}
