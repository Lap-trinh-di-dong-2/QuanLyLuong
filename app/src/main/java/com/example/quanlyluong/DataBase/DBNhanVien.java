package com.example.quanlyluong.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.quanlyluong.Model.NhanVien;

public class DBNhanVien {
    DBHelper dbHelper;
    public DBNhanVien(Context context) {
        this.dbHelper = new DBHelper(context);
    }
    public void themNhanVien(NhanVien nhanVien)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ma",nhanVien.getMaNhanVien());
        values.put("ten",nhanVien.getTenNhanVien());
        values.put("ngaysinh",nhanVien.getNgaySinh());
        values.put("gioitinh",nhanVien.getGioiTinh());
        values.put("phongban",nhanVien.getPhongBan());
        values.put("hesoluong",nhanVien.getHeSoLuong());
        db.insert("PhongBan",null,values);
        db.close();
    }
}
