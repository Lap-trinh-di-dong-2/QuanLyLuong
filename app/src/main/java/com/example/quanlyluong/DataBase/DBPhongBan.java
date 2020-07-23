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
    public void themPhongBan(PhongBan phongBan)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ma",phongBan.getMaPhong());
        values.put("ten",phongBan.getTenPhong());
        db.insert("PhongBan",null,values);
    }
    public ArrayList<PhongBan> layDuLieu()
    {
        ArrayList<PhongBan>data = new ArrayList<>();
        String sql = "Select * from PhongBan ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        do{
            PhongBan phongBan = new PhongBan();
            phongBan.setMaPhong(cursor.getString(0));
            phongBan.setTenPhong(cursor.getString(1));
            data.add(phongBan);
        }
        while (cursor.moveToNext());
        return data;
    }

    public ArrayList<PhongBan> layDuLieu(String ma)
    {
        ArrayList<PhongBan>data = new ArrayList<>();
        String sql = "Select * from PhongBan where ma = '"+ ma +"' ";
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        do{
            PhongBan phongBan = new PhongBan();
            phongBan.setMaPhong(cursor.getString(0));
            phongBan.setTenPhong(cursor.getString(1));
            data.add(phongBan);
        }
        while (cursor.moveToNext());
        return data;
    }
public void suaPhongBan(PhongBan phongBan)
{
    SQLiteDatabase db = dbHelper.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put("ma",phongBan.getMaPhong());
    values.put("ten",phongBan.getTenPhong());
    db.update("PhongBan",values,"ma='" + phongBan.getMaPhong() + "'",null );
    db.close();
}
    public void xoaPhongBan(PhongBan phongBan)
    {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("PhongBan","ma= '" + phongBan.getMaPhong()+ "'",null);
        db.close();
    }
}
