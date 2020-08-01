package com.example.quanlyluong.GiaoDien.Thongke;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.quanlyluong.Adapter.CustomAdapterThongKe;
import com.example.quanlyluong.DataBase.DBChamCong;
import com.example.quanlyluong.DataBase.DBNhanVien;
import com.example.quanlyluong.Model.ThongKe;
import com.example.quanlyluong.R;

import java.util.ArrayList;

public class ChiTietThongKe extends AppCompatActivity {
    TextView tvMaNV, tvTenNV, tvThoiGianCham, tvTenPhongBan, tvLuongCoBan, tvNgayCong, tvTamUng, tvLuong, tvThucLanh, tvTongLuong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitiet_thongke);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();
    }

    private void setEvent() {
        String manv = getIntent().getExtras().getString("manv");
        DBNhanVien dbNhanVien = new DBNhanVien(getApplicationContext());
        ThongKe thongKe = new ThongKe();
        thongKe = dbNhanVien.layThongKe(manv);
        tvMaNV.setText(thongKe.getMaNhanVien());
        tvTenNV.setText(thongKe.getTenNhanVien());
        tvThoiGianCham.setText(thongKe.getNgayChamCong());
        tvTenPhongBan.setText(thongKe.getTenPhongBan());
        tvLuongCoBan.setText(thongKe.getLuongCoBan());
        tvNgayCong.setText(thongKe.getNgayCong());
        tvTamUng.setText(thongKe.getTamUng());

        int luong = 0;
        int ngayCong = Integer.parseInt(thongKe.getNgayCong());
        int luongCoBan = Integer.parseInt(thongKe.getLuongCoBan());
        int tamUng = Integer.parseInt(thongKe.getTamUng());
        luong = (luongCoBan *  ngayCong);
        thongKe.setLuong(luong+"");
        tvLuong.setText(thongKe.getLuong());
        int thucLanh = 0;
        thucLanh = luong - tamUng;
        thongKe.setThucLanh(thucLanh+"");
        tvThucLanh.setText(thongKe.getThucLanh());

    }

    private void setControl() {
        tvMaNV = findViewById(R.id.tvMaNhanVien);
        tvTenNV = findViewById(R.id.tvTenNhanVien);
        tvThoiGianCham = findViewById(R.id.tvThoiGianCham);
        tvTenPhongBan = findViewById(R.id.tvTenPhongBan);
        tvLuongCoBan = findViewById(R.id.tvHeSoLuong);
        tvNgayCong = findViewById(R.id.tvSoNgayCong);
        tvTamUng = findViewById(R.id.tvTamUng);
        tvLuong = findViewById(R.id.tvLuong);
        tvThucLanh = findViewById(R.id.tvThucLanh);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}