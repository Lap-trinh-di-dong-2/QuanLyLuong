package com.example.quanlyluong.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.Model.PhongBan;

import java.util.ArrayList;

public class DBNhanVien {
    DBHelper dbHelper;

    public DBNhanVien(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public void themNhanVien(NhanVien nhanVien) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ma", nhanVien.getMaNhanVien());
        values.put("ten", nhanVien.getTenNhanVien());
        values.put("ngaysinh", nhanVien.getNgaySinh());
        values.put("gioitinh", nhanVien.getGioiTinh());
        values.put("phongban", nhanVien.getPhongBan());
        values.put("hesoluong", nhanVien.getHeSoLuong());
        db.insert("NhanVien", null, values);
        db.close();
    }
    public void suaNhanVien(NhanVien nhanVien) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ma", nhanVien.getMaNhanVien());
        values.put("ten", nhanVien.getTenNhanVien());
        values.put("ngaysinh", nhanVien.getNgaySinh());
        values.put("gioitinh", nhanVien.getGioiTinh());
        values.put("phongban", nhanVien.getPhongBan());
        values.put("hesoluong", nhanVien.getHeSoLuong());
        db.update("NhanVien", values, "ma ='" + nhanVien.getMaNhanVien() + "'", null);
        db.close();
    }

    public void xoaNhanVien(NhanVien nhanVien) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("NhanVien", "ma ='" + nhanVien.getMaNhanVien() + "'", null);
        db.close();
    }

    public ArrayList<NhanVien> layDSNhanVien()
    {
        ArrayList<NhanVien>data = new ArrayList<>();
        String sql = "Select * from NhanVien ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        do{
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNhanVien(cursor.getString(0));
            nhanVien.setTenNhanVien(cursor.getString(1));
            nhanVien.setNgaySinh(cursor.getString(2));
            nhanVien.setGioiTinh(cursor.getString(3));
            nhanVien.setPhongBan(cursor.getString(4));
            nhanVien.setHeSoLuong(cursor.getString(5));
            data.add(nhanVien);
        }
        while (cursor.moveToNext());
        db.close();
        return data;
    }

    public ArrayList<NhanVien> layNhanVien(String manv) {
        ArrayList<NhanVien> data = new ArrayList<>();
        String sql = "select * from NhanVien where ma ='" + manv + "'";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            cursor.moveToFirst();
            do {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNhanVien(cursor.getString(0));
                nhanVien.setTenNhanVien(cursor.getString(1));
                nhanVien.setNgaySinh(cursor.getString(2));
                nhanVien.setGioiTinh(cursor.getString(3));
                nhanVien.setPhongBan(cursor.getString(4));
                nhanVien.setHeSoLuong(cursor.getString(5));
                data.add(nhanVien);
            }
            while (cursor.moveToNext());
        } catch (Exception ex) {
        }

        db.close();
        return data;
    }
}