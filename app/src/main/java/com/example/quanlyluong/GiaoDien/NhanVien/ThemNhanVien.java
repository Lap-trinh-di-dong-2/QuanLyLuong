package com.example.quanlyluong.GiaoDien.NhanVien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.quanlyluong.DataBase.DBNhanVien;
import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.R;

import java.util.ArrayList;

public class ThemNhanVien extends AppCompatActivity {
    Button btnLuuNhanVien;
    EditText txtMaNhanVien,txtTenNhanVien,txtNgaySinh,txtHeSoLuong;
    RadioButton radNam,radNu;
    Spinner spPhongBan;
    ArrayList<String> data_phongban = new ArrayList<>();
    ArrayAdapter adapter_phongban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_nhanvien);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();
    }

    private void setEvent() {
        LoadPhongBan();
        adapter_phongban = new ArrayAdapter(ThemNhanVien.this,android.R.layout.simple_spinner_item,data_phongban);
        spPhongBan.setAdapter(adapter_phongban);

        btnLuuNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themNhanVien();
                Intent intent =new Intent(ThemNhanVien.this,MainNhanVien.class);
                startActivity(intent);
            }
        });
    }

    private void themNhanVien() {

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNhanVien(txtMaNhanVien.getText().toString());
        nhanVien.setTenNhanVien(txtTenNhanVien.getText().toString());
        nhanVien.setNgaySinh(txtNgaySinh.getText().toString());
        if(radNam.isChecked()==true)
        {
            nhanVien.setGioiTinh("Nam");
        }
        if(radNu.isChecked()==true)
        {
            nhanVien.setGioiTinh("Nữ");
        }
        nhanVien.setPhongBan(spPhongBan.getSelectedItem().toString());
        nhanVien.setHeSoLuong(txtHeSoLuong.getText().toString());

        DBNhanVien dbNhanVien = new DBNhanVien(getApplicationContext());
        dbNhanVien.themNhanVien(nhanVien);
    }

    private void LoadPhongBan()
    {
        data_phongban.add("Nhan su");
        data_phongban.add("Ke toan");
    }
    private void setControl() {
        btnLuuNhanVien = findViewById(R.id.btnSuaNhanVien);
        spPhongBan = findViewById(R.id.spPhongBan);
        txtMaNhanVien = findViewById(R.id.txtMaNhanVien);
        txtTenNhanVien = findViewById(R.id.txtTenNhanVien);
        txtNgaySinh = findViewById(R.id.txtNgaySinh);
        radNam = findViewById(R.id.radNam);
        radNu = findViewById(R.id.radNu);
        txtHeSoLuong= findViewById(R.id.txtHeSoLuong);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}