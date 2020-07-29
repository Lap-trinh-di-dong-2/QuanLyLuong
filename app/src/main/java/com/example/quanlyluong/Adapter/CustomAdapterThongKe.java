package com.example.quanlyluong.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.Model.TamUng;
import com.example.quanlyluong.Model.ThongKe;
import com.example.quanlyluong.R;

import java.util.ArrayList;


public class CustomAdapterThongKe extends ArrayAdapter {
    Context context;
    int resource;
    ArrayList<ThongKe> data;

    public CustomAdapterThongKe(Context context, int resource, ArrayList<ThongKe> data) {
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
        TextView tvMaNV, tvTenNV, tvThoiGianCham, tvTenPhongBan, tvLuongCoBan, tvNgayCong, tvTamUng, tvLuong;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view = convertView;

        CustomAdapterThongKe.Holder holder = null;
        if (view == null) {
            holder = new CustomAdapterThongKe.Holder();
            view = LayoutInflater.from(context).inflate(resource, null);

            holder.tvMaNV = view.findViewById(R.id.tvMaNhanVien);
            holder.tvTenNV = view.findViewById(R.id.tvTenNhanVien);
            holder.tvThoiGianCham = view.findViewById(R.id.tvThoiGianCham);
            holder.tvTenPhongBan = view.findViewById(R.id.tvTenPhongBan);
            holder.tvLuongCoBan = view.findViewById(R.id.tvHeSoLuong);
            holder.tvNgayCong = view.findViewById(R.id.tvSoNgayCong);
            holder.tvTamUng = view.findViewById(R.id.tvTamUng);
            holder.tvLuong = view.findViewById(R.id.tvLuong);

            view.setTag(holder);
        } else
            holder = (CustomAdapterThongKe.Holder) view.getTag();
        final ThongKe thongKe = data.get(position);
        holder.tvMaNV.setText(thongKe.getMaNhanVien());
        holder.tvTenNV.setText(thongKe.getTenNhanVien());
        holder.tvTenPhongBan.setText(thongKe.getTenPhongBan());
        holder.tvLuongCoBan.setText(thongKe.getLuongCoBan());
        holder.tvNgayCong.setText(thongKe.getNgayCong());
        holder.tvThoiGianCham.setText(thongKe.getNgayChamCong());
        holder.tvTamUng.setText(thongKe.getTamUng());

        int luong = 0;
        int ngayCong = Integer.parseInt(thongKe.getNgayCong());
        int luongCoBan = Integer.parseInt(thongKe.getNgayCong());
        luong = ((luongCoBan * 26) / ngayCong);
        thongKe.setLuong(luong+"");
        holder.tvLuong.setText(thongKe.getLuong());

        return view;
    }
}
