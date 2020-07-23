package com.example.quanlyluong.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlyluong.DataBase.DBPhongBan;
import com.example.quanlyluong.GiaoDien.PhongBan.EditPhongBan;
import com.example.quanlyluong.GiaoDien.PhongBan.MainPhongBan;
import com.example.quanlyluong.Model.PhongBan;
import com.example.quanlyluong.R;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context context;
    int  resource;
    ArrayList<PhongBan> data;
    public CustomAdapter(Context context, int resource, ArrayList<PhongBan> data) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public View getView(int position, final View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resource,null);
        ImageView imgChiTiet = view.findViewById(R.id.imgChitiet);
        ImageView imgXoa = view.findViewById(R.id.imgXoa);
        ImageView imgHinh = view.findViewById(R.id.imgHinh);
        TextView tvMaPhong = view.findViewById(R.id.tvMaPhong);
        TextView tvTenPhong = view.findViewById(R.id.tvTenPhong);
        final PhongBan phongBan = data.get(position);

        imgHinh.setImageResource(R.drawable.phong);
        tvMaPhong.setText(phongBan.getMaPhong());
        tvTenPhong.setText(phongBan.getTenPhong());
        imgChiTiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent((Activity) context, EditPhongBan.class);
                Bundle bundle = new Bundle();
                bundle.putString("ma", phongBan.getMaPhong());
                intent.putExtras(bundle);
                ((Activity)context).startActivity(intent);
            }
        });
        imgXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(context);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn xóa không");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        DBPhongBan dbPhongBan =new DBPhongBan(getContext());
                        dbPhongBan.xoaPhongBan(phongBan);
                        Intent intent =new Intent(context, MainPhongBan.class);
                        context.startActivity(intent);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
        return view;
    }
}
