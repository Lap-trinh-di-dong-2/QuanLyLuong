package com.example.quanlyluong.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlyluong.Model.PhongBan;

import java.util.ArrayList;

public class DBPhongBan {
    DBHelper dbHelper;

    public DBPhongBan(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public void themPhongBan(PhongBan phongBan) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mapb", phongBan.getMaPhong());
        values.put("tenpb", phongBan.getTenPhong());
        db.insert("PhongBan", null, values);
        db.close();
    }

    public ArrayList<PhongBan> layDuLieu() {
        ArrayList<PhongBan> data = new ArrayList<>();
        String sql = "Select * from PhongBan ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            cursor.moveToFirst();
            do {
                PhongBan phongBan = new PhongBan();
                phongBan.setMaPhong(cursor.getString(0));
                phongBan.setTenPhong(cursor.getString(1));
                data.add(phongBan);
            }
            while (cursor.moveToNext());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public ArrayList<String> layDSPhongBan() {
        ArrayList<String> data = new ArrayList<>();
        String sql = "Select tenpb from PhongBan ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            cursor.moveToFirst();
            do {
                PhongBan phongBan = new PhongBan();
                String tenPhong = "";
                phongBan.setTenPhong(cursor.getString(0));
                tenPhong = phongBan.getTenPhong();
                data.add(tenPhong);
            }
            while (cursor.moveToNext());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public ArrayList<PhongBan> layDuLieu(String ma) {
        ArrayList<PhongBan> data = new ArrayList<>();
        String sql = "Select * from PhongBan where mapb = '" + ma + "' ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            cursor.moveToFirst();
            do {
                PhongBan phongBan = new PhongBan();
                phongBan.setMaPhong(cursor.getString(0));
                phongBan.setTenPhong(cursor.getString(1));
                data.add(phongBan);
            }
            while (cursor.moveToNext());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public void suaPhongBan(PhongBan phongBan) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mapb", phongBan.getMaPhong());
        values.put("tenpb", phongBan.getTenPhong());
        db.update("PhongBan", values, "mapb='" + phongBan.getMaPhong() + "'", null);
        db.close();
    }

    public void xoaPhongBan(PhongBan phongBan) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("PhongBan", "mapb= '" + phongBan.getMaPhong() + "'", null);
        db.close();
    }

    public String layTenPhong(String maPhong) {
        String tenPhong = "";
        String sql = "SELECT tenpb FROM PhongBan WHERE mapb LIKE \"%"+maPhong+"%\" ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        try {
            cursor.moveToFirst();
            do {
                PhongBan phongBan = new PhongBan();
                phongBan.setMaPhong(cursor.getString(0));
                tenPhong = phongBan.getMaPhong();
            }
            while (cursor.moveToNext());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tenPhong;
    }

    public boolean checkXoaPhong(String maPhong) {
        boolean check = false;
        String sql = "SELECT count(*) FROM NhanVien WHERE mapb LIKE \""+maPhong+"\" ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        cursor.moveToFirst();
        int count  = cursor.getInt(0);
        if(count > 0) {
            check = true;
        }
        return check;
    }
}
