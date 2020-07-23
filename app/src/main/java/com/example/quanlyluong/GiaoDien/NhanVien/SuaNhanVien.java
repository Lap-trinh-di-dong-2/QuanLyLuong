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
import android.widget.TextView;

import com.example.quanlyluong.DataBase.DBNhanVien;
import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.R;

import java.util.ArrayList;

public class SuaNhanVien extends AppCompatActivity {
    EditText txtTenNhanVien,txtNgaySinh,txtHeSoLuong;
    TextView tvMaNhanVien;
    RadioButton radNam,radNu;
    Button btnSuaNhanVien;
    Spinner spPhongBan;
    ArrayList<String> data_phongban = new ArrayList<>();
    ArrayAdapter adapter_phongban;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sua_nhanvien);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();
    }

    private void setEvent() {
        LoadPhongBan();
        adapter_phongban = new ArrayAdapter(SuaNhanVien.this,android.R.layout.simple_spinner_item,data_phongban);
        spPhongBan.setAdapter(adapter_phongban);

        btnSuaNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suaNhanVien();
                Intent intent =new Intent(SuaNhanVien.this,MainNhanVien.class);
                startActivity(intent);
            }
        });
    }

    private void suaNhanVien() {

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNhanVien(tvMaNhanVien.getText().toString());
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
        dbNhanVien.suaNhanVien(nhanVien);
    }

    private void LoadPhongBan()
    {
        data_phongban.add("Nhan su");
        data_phongban.add("Ke toan");
    }

    private void setControl() {
        btnSuaNhanVien = findViewById(R.id.btnSuaNhanVien);
        spPhongBan = findViewById(R.id.spPhongBan);
        tvMaNhanVien = findViewById(R.id.txtMaNhanVien);
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