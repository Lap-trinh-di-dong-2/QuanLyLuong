package com.example.quanlyluong.GiaoDien.TamUng;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quanlyluong.DataBase.DBNhanVien;
import com.example.quanlyluong.DataBase.DBTamUng;
import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.Model.TamUng;
import com.example.quanlyluong.R;

import java.util.ArrayList;
import java.util.Calendar;

public class ThemTamUng extends AppCompatActivity {
    EditText txtSophieu, txtSoTien;
    TextView tvMaNhanVien, tvTenNhanVien, tvNgayUng;
    Calendar calendar;
    int year, month, day;
    Button btnTamUng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_tamung);
        setControl();
        setEvent();
    }

    private void setEvent() {
        showDate(year, month + 1, day);
        String manv = getIntent().getExtras().getString("ma");
        DBNhanVien dbNhanVien = new DBNhanVien(getApplicationContext());
        ArrayList<NhanVien> nhanViens = dbNhanVien.layNhanVien(manv);
        tvMaNhanVien.setText(nhanViens.get(0).getMaNhanVien());
        tvTenNhanVien.setText(nhanViens.get(0).getTenNhanVien());

        btnTamUng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themTamUng();
                Toast.makeText(getApplicationContext(),"Thêm thành công",Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(ThemTamUng.this, BangTamUng.class);
                startActivity(intent);
            }
        });


    }

    private void themTamUng() {
        TamUng tamUng = new TamUng();
        tamUng.setSoPhieu(txtSophieu.getText().toString());
        tamUng.setMaNhanVien(tvMaNhanVien.getText().toString());
        tamUng.setNgayUng(tvNgayUng.getText().toString());
        tamUng.setSoTien(txtSoTien.getText().toString());
        DBTamUng dbTamUng = new DBTamUng(getApplicationContext());
        dbTamUng.themTamUng(tamUng);

    }

    private void showDate(int year, int month, int day) {
        tvNgayUng.setText(new StringBuilder().append(day > 9 ? day: "0"+day).append("/").append(month > 9 ?
                month: "0" + month).append("/").append(year));
    }

    private void setControl() {
        txtSophieu = findViewById(R.id.txtSoPhieu);
        txtSoTien = findViewById(R.id.txtSoTien);

        tvMaNhanVien = findViewById(R.id.tvMaNhanVien);
        tvTenNhanVien = findViewById(R.id.tvTenNhanVien);
        tvNgayUng = findViewById(R.id.tvNgayUng);
        btnTamUng = findViewById(R.id.btnTamUng);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

    }


}