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
    ArrayList<ThongKe> thongKes;
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
        String ngaycham = getIntent().getExtras().getString("ngaycham");
        DBNhanVien dbNhanVien = new DBNhanVien(getApplicationContext());
        thongKes = dbNhanVien.layThongKe(ngaycham);
        tvMaNV.setText(thongKes.get(0).getMaNhanVien());
        tvTenNV.setText(thongKes.get(0).getTenNhanVien());
        tvThoiGianCham.setText(thongKes.get(0).getNgayChamCong());
        tvTenPhongBan.setText(thongKes.get(0).getTenPhongBan());
        tvLuongCoBan.setText(thongKes.get(0).getLuongCoBan());
        tvNgayCong.setText(thongKes.get(0).getNgayCong());
        tvTamUng.setText(thongKes.get(0).getTamUng());

        int luong = 0;
        int ngayCong = Integer.parseInt(thongKes.get(0).getNgayCong());
        int luongCoBan = Integer.parseInt(thongKes.get(0).getLuongCoBan());
        int tamUng = Integer.parseInt(thongKes.get(0).getTamUng());
        luong = (luongCoBan *  ngayCong);
        thongKes.get(0).setLuong(luong+"");
        tvLuong.setText(thongKes.get(0).getLuong());
        int thucLanh = 0;
        thucLanh = luong - tamUng;
        thongKes.get(0).setThucLanh(thucLanh+"");
        tvThucLanh.setText(thongKes.get(0).getThucLanh());

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