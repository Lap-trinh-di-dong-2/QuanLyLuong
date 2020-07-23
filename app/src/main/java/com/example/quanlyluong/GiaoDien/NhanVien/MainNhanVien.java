package com.example.quanlyluong.GiaoDien.NhanVien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.R;

public class MainNhanVien extends AppCompatActivity {
        Button btnThemNhanVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nhanvien);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnThemNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainNhanVien.this,ThemNhanVien.class);
                startActivity(intent);
            }
        });
    }

    private void setControl() {
        btnThemNhanVien = findViewById(R.id.btnthemNhanVien);
    }
}