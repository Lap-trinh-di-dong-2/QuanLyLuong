package com.example.quanlyluong.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.example.quanlyluong.Model.NhanVien;

import java.util.ArrayList;

public class CustomAdapterNhanVien extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<NhanVien>data;
    public CustomAdapterNhanVien(@NonNull Context context, int resource, ArrayList<NhanVien>data) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
        this.data=data;
    }
}
