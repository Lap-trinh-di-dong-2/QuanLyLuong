package com.example.quanlyluong.GiaoDien.ChamCong;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlyluong.DataBase.DBChamCong;
import com.example.quanlyluong.DataBase.DBNhanVien;
import com.example.quanlyluong.GiaoDien.TamUng.BangTamUng;
import com.example.quanlyluong.GiaoDien.TamUng.ThemTamUng;
import com.example.quanlyluong.Model.ChamCong;
import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.R;

import java.util.ArrayList;
import java.util.Calendar;

public class ThemChamCong extends AppCompatActivity {
    TextView tvMaNhanVien,tvTenNhanVien,tvNgayChamCong;
    EditText txtSoNgayCong;
    Button btnLuu,btnThoat;
    Calendar calendar;
    int year, month;
    ArrayList<NhanVien> dataNV = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_chamcong);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();
    }

    private void setEvent() {
        showDate(year, month + 1);
        String manv = getIntent().getExtras().getString("ma");
        DBNhanVien dbNhanVien = new DBNhanVien(this);
        dataNV = dbNhanVien.layNhanVienChamCong(manv);
        tvMaNhanVien.setText(dataNV.get(0).getMaNhanVien());
        tvTenNhanVien.setText(dataNV.get(0).getTenNhanVien());
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themChamCong();
                Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(ThemChamCong.this, BangChamCong.class);
                startActivity(intent);
            }
        });
    }

    private void themChamCong() {
        ChamCong chamCong = new ChamCong();
        chamCong.setMaNhanVien(tvMaNhanVien.getText().toString());
        chamCong.setThang(tvNgayChamCong.getText().toString());
        chamCong.setSoNgayCong(txtSoNgayCong.getText().toString());
        DBChamCong dbChamCong =new DBChamCong(getApplicationContext());
        dbChamCong.themChamCong(chamCong);
    }

    private void showDate(int year, int month) {
        tvNgayChamCong.setText(new StringBuilder().append(month > 9 ?
                month: "0" + month).append("/").append(year));
    }

    private void setControl() {
        tvMaNhanVien =findViewById(R.id.tvMaNhanVien);
        tvTenNhanVien = findViewById(R.id.tvTenNhanVien);
        tvNgayChamCong =findViewById(R.id.txtNgayChamCong);
        txtSoNgayCong = findViewById(R.id.txtSoNgayCong);
        btnLuu = findViewById(R.id.btnLuuChamCong);
        btnThoat= findViewById(R.id.btnThoat);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
    }
}