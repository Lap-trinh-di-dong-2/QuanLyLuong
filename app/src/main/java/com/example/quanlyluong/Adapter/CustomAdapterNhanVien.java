package com.example.quanlyluong.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;

import com.example.quanlyluong.DataBase.DBNhanVien;
import com.example.quanlyluong.GiaoDien.ChamCong.ThemChamCong;
import com.example.quanlyluong.GiaoDien.NhanVien.MainNhanVien;
import com.example.quanlyluong.GiaoDien.NhanVien.SuaNhanVien;
import com.example.quanlyluong.GiaoDien.TamUng.ThemTamUng;
import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.R;

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

    @Override
    public int getCount() {
        return data.size();
    }

    private static class Holder {
        TextView tvMaNV, tvTenNV, tvNgaySinh, tvMaPB, tvLuong;
        ImageView imgXoa, imgHinh;
        Button btnChamCong,btnTamUng;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        Holder holder = null;
        if(view == null) {
            holder = new Holder();
            view = LayoutInflater.from(context).inflate(resource, null);
            holder.tvMaNV = view.findViewById(R.id.tvMaNV);
            holder.tvTenNV = view.findViewById(R.id.tvTenNV);
            holder.tvNgaySinh = view.findViewById(R.id.tvNgaySinh);
            holder.tvMaPB = view.findViewById(R.id.tvMaPB);
            holder.tvLuong = view.findViewById(R.id.tvLuong);
            holder.imgXoa = view.findViewById(R.id.imgXoa);
            holder.imgHinh = view.findViewById(R.id.imgHinh);
            holder.btnChamCong = view.findViewById(R.id.btnChamCong);
            holder.btnTamUng = view.findViewById(R.id.btnTamUng);


            view.setTag(holder);
        }
        else
            holder=(Holder)view.getTag();

        final NhanVien nhanVien = data.get(position);


        holder.tvMaNV.setText(nhanVien.getMaNhanVien());
        holder.tvTenNV.setText(nhanVien.getTenNhanVien());
        holder.tvNgaySinh.setText(nhanVien.getNgaySinh());
        holder.tvMaPB.setText(nhanVien.getPhongBan());
        holder.tvLuong.setText(nhanVien.getHeSoLuong());

        Bitmap bmHinhDaiDien = BitmapFactory.decodeByteArray(nhanVien.getAnh(), 0, nhanVien.getAnh().length);
        holder.imgHinh.setImageBitmap(bmHinhDaiDien);
//        if(nhanVien.getGioiTinh().equals("Nam"))
//        {
//            holder.imgHinh.setImageResource(R.drawable.nam);
//
//        }
//        if(nhanVien.getGioiTinh().equals("Nữ"))
//        {
//            holder.imgHinh.setImageResource(R.drawable.nu);
//        }
        holder.imgHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SuaNhanVien.class);
                Bundle bundle = new Bundle();
                bundle.putString("ma",nhanVien.getMaNhanVien());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        holder.imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBNhanVien dbNhanVien = new DBNhanVien(getContext());
                dbNhanVien.xoaNhanVien(nhanVien);
                Intent intent = new Intent(getContext(), MainNhanVien.class);
                context.startActivity(intent);

            }
        });
        holder.btnChamCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ThemChamCong.class);
                Bundle bundle = new Bundle();
                bundle.putString("ma",nhanVien.getMaNhanVien());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        holder.btnTamUng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ThemTamUng.class);
                Bundle bundle = new Bundle();
                bundle.putString("ma",nhanVien.getMaNhanVien());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        return view;
    }
}
