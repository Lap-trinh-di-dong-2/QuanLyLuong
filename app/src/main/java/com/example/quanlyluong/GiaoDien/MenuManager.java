package com.example.quanlyluong.GiaoDien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.quanlyluong.GiaoDien.ChamCong.BangChamCong;
import com.example.quanlyluong.GiaoDien.NhanVien.MainNhanVien;
import com.example.quanlyluong.GiaoDien.NhanVien.ThemNhanVien;
import com.example.quanlyluong.GiaoDien.PhongBan.MainPhongBan;
import com.example.quanlyluong.GiaoDien.TamUng.BangTamUng;
import com.example.quanlyluong.GiaoDien.Thongke.ThongKe;
import com.example.quanlyluong.R;

public class MenuManager extends AppCompatActivity {
    Button btnPhongBan,btnNhanVien,btnChamCong,btnTamUng,btnThongke;
    boolean ngonNgu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manager);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnPhongBan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuManager.this, MainPhongBan.class);
                startActivity(intent);
            }
        });
        btnNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MenuManager.this, MainNhanVien.class);
                startActivity(intent1);
            }
        });
        btnChamCong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(MenuManager.this, BangChamCong.class);
                startActivity(intent2);
            }
        });
        btnTamUng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3 = new Intent(MenuManager.this, BangTamUng.class);
                startActivity(intent3);
            }
        });
        btnThongke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MenuManager.this, ThongKe.class);
                startActivity(intent4);
            }
        });

    }

    private void setControl() {
        btnPhongBan = findViewById(R.id.btnPhongBan);
        btnNhanVien = findViewById(R.id.btnNhanVien);
        btnChamCong = findViewById(R.id.btnChamCong);
        btnTamUng = findViewById(R.id.btnTamUng);
        btnThongke = findViewById(R.id.btnThongke);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_manager,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.ngonNgu:
                if(ngonNgu==true)
                {
                    item.setIcon(R.drawable.anh);
                }
                else
                {
                    item.setIcon(R.drawable.vietnam);
                }
                ngonNgu=!ngonNgu;
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
