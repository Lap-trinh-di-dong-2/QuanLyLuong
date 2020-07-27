package com.example.quanlyluong.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlyluong.DataBase.DBNhanVien;
import com.example.quanlyluong.DataBase.DBTamUng;
import com.example.quanlyluong.GiaoDien.TamUng.BangTamUng;
import com.example.quanlyluong.GiaoDien.TamUng.ThemTamUng;
import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.Model.TamUng;
import com.example.quanlyluong.R;

import java.util.ArrayList;


public class CustomAdapterTamUng extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<TamUng> data;
    ArrayList<NhanVien> nhanVien = new ArrayList<>();

    public CustomAdapterTamUng(Context context, int resource, ArrayList<TamUng> data) {
        super(context, resource);
        this.context = context;
        this.resource = resource;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    private static class Holder {
        TextView tvMaNV, tvTenNV, tvNgayUng, tvSoTien, tvSoPhieu;
        ImageView imgTamUng, imgXoa, imgHinh;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        CustomAdapterTamUng.Holder holder = null;
        if (view == null) {
            holder = new CustomAdapterTamUng.Holder();
            view = LayoutInflater.from(context).inflate(resource, null);
            holder.tvMaNV = view.findViewById(R.id.tvMaNV);
            holder.tvTenNV = view.findViewById(R.id.tvTenNV);
            holder.tvNgayUng = view.findViewById(R.id.tvNgayUng);
            holder.tvSoTien = view.findViewById(R.id.tvSoTien);
            holder.imgTamUng = view.findViewById(R.id.imgTamUng);
            holder.imgXoa = view.findViewById(R.id.imgXoa);
            holder.imgHinh = view.findViewById(R.id.imgHinh);


            view.setTag(holder);
        } else
            holder = (CustomAdapterTamUng.Holder) view.getTag();

        final TamUng tamUng = data.get(position);


        holder.tvMaNV.setText(tamUng.getMaNhanVien());

        holder.tvSoTien.setText(tamUng.getSoTien());
        holder.tvNgayUng.setText(tamUng.getNgayUng());
        DBNhanVien dbNhanVien = new DBNhanVien(getContext());
        nhanVien = dbNhanVien.layNhanVien(tamUng.getMaNhanVien());
        holder.tvTenNV.setText(nhanVien.get(0).getTenNhanVien());
        if ("Nam".equals(nhanVien.get(0).getGioiTinh())) {
            holder.imgHinh.setImageResource(R.drawable.nam);

        }
        if ("Nữ".equals(nhanVien.get(0).getGioiTinh())) {
            holder.imgHinh.setImageResource(R.drawable.nu);
        }
        holder.imgTamUng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ThemTamUng.class);
                Bundle bundle = new Bundle();
                bundle.putString("ma", tamUng.getMaNhanVien());
                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
        holder.imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBTamUng dbTamUng = new DBTamUng(getContext());
                dbTamUng.xoaTamUng(tamUng);
                Intent intent = new Intent(getContext(), BangTamUng.class);
                context.startActivity(intent);
            }
        });

        return view;
    }
}
