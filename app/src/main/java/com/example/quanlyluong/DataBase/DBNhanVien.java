package com.example.quanlyluong.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.Model.ThongKe;

import java.util.ArrayList;

public class DBNhanVien {
    DBHelper dbHelper;

    public DBNhanVien(Context context) {
        this.dbHelper = new DBHelper(context);
    }

    public void themNhanVien(NhanVien nhanVien) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("manv", nhanVien.getMaNhanVien());
        values.put("tennv", nhanVien.getTenNhanVien());
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
        values.put("manv", nhanVien.getMaNhanVien());
        values.put("tennv", nhanVien.getTenNhanVien());
        values.put("ngaysinh", nhanVien.getNgaySinh());
        values.put("gioitinh", nhanVien.getGioiTinh());
        values.put("phongban", nhanVien.getPhongBan());
        values.put("hesoluong", nhanVien.getHeSoLuong());
        db.update("NhanVien", values, "manv ='" + nhanVien.getMaNhanVien() + "'", null);
        db.close();
    }

    public void xoaNhanVien(NhanVien nhanVien) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("NhanVien", "manv ='" + nhanVien.getMaNhanVien() + "'", null);
        db.close();
    }

    public ArrayList<NhanVien> layDSNhanVien() {
        ArrayList<NhanVien> data = new ArrayList<>();
        String sql = "Select * from NhanVien ";
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
            ex.printStackTrace();
        }
        return data;
    }

    public ArrayList<NhanVien> layNhanVien(String manv) {
        ArrayList<NhanVien> data = new ArrayList<>();
        String sql = "select * from NhanVien where manv ='" + manv + "'";
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
            ex.printStackTrace();
        }

        db.close();
        return data;
    }


    public ArrayList<ThongKe> layDSThongKe() {
        ArrayList<ThongKe> data = new ArrayList<>();
        String sql = "select NhanVien.manv,NhanVien.tennv,NhanVien.phongban,NhanVien.hesoluong,ChamCong.ngaycham,ChamCong.songaycong,TamUng.sotien from NhanVien INNER JOIN  ChamCong on NhanVien.manv = ChamCong.manv  INNER JOIN TamUng on NhanVien.manv = TamUng.manv ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            cursor.moveToFirst();
            do {
                ThongKe thongKe = new ThongKe();
                thongKe.setMaNhanVien(cursor.getString(0));
                thongKe.setTenNhanVien(cursor.getString(1));
                thongKe.setTenPhongBan(cursor.getString(2));
                thongKe.setLuongCoBan(cursor.getString(3));
                thongKe.setNgayChamCong(cursor.getString(4));
                thongKe.setNgayCong(cursor.getString(5));
                thongKe.setTamUng(cursor.getString(6));
                data.add(thongKe);
            }
            while (cursor.moveToNext());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

    public ArrayList<ThongKe> locDSThongKe(String key) {
        ArrayList<ThongKe> data = new ArrayList<>();
        String sql = "SELECT NhanVien.manv,NhanVien.tennv,NhanVien.phongban,NhanVien.hesoluong,ChamCong.ngaycham,ChamCong.songaycong,TamUng.sotien " +
                "FROM NhanVien INNER JOIN  ChamCong on NhanVien.manv = ChamCong.manv  " +
                "INNER JOIN TamUng ON NhanVien.manv = TamUng.manv WHERE ChamCong.ngaycham LIKE \"%"+key+"%\" ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        try {
            cursor.moveToFirst();
            do {
                ThongKe thongKe = new ThongKe();
                thongKe.setMaNhanVien(cursor.getString(0));
                thongKe.setTenNhanVien(cursor.getString(1));
                thongKe.setTenPhongBan(cursor.getString(2));
                thongKe.setLuongCoBan(cursor.getString(3));
                thongKe.setNgayChamCong(cursor.getString(4));
                thongKe.setNgayCong(cursor.getString(5));
                thongKe.setTamUng(cursor.getString(6));
                data.add(thongKe);
            }
            while (cursor.moveToNext());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

}
