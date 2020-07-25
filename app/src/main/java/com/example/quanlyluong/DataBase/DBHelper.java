package com.example.quanlyluong.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context) {
        super(context, "SQLQuanLyLuong", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "Create table PhongBan (mapb text PRIMARY KEY NOT NULL, tenpb text) ";
        sqLiteDatabase.execSQL(sql);
        String sqlNhanVien = "Create table NhanVien (manv text PRIMARY KEY NOT NULL, tennv text, ngaysinh text, gioitinh text,phongban text, hesoluong text)";
        sqLiteDatabase.execSQL(sqlNhanVien);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.execSQL("PRAGMA foreign_keys=ON;");
        }
    }



//    String sqlNhanVien = "Create table NhanVien (manv text PRIMARY KEY NOT NULL, " +
//            "tennv text, ngaysinh text, gioitinh text,phongban text, hesoluong text, mapb text,CONSTRAINT fk_PhongBan" +
//            "    FOREIGN KEY (mapb)" +
//            "    REFERENCES PhongBan(mapb)" +
//            "    ON UPDATE CASCADE)";
}
