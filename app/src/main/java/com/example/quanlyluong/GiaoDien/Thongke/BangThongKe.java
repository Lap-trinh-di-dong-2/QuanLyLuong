package com.example.quanlyluong.GiaoDien.Thongke;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlyluong.Adapter.CustomAdapterThongKe;
import com.example.quanlyluong.DataBase.DBChamCong;
import com.example.quanlyluong.DataBase.DBNhanVien;
import com.example.quanlyluong.Model.ThongKe;
import com.example.quanlyluong.R;

import java.util.ArrayList;

public class BangThongKe extends AppCompatActivity {
    ArrayList<ThongKe> thongKes = new ArrayList<>();
    ListView lvThongke;
    Spinner spNgayCham;
    ArrayList<String> sp_data;
    ArrayAdapter adapter_ngaycham;
    CustomAdapterThongKe adapterThongKe;
    Button btnLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bang_thongke);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();
    }


    private void setEvent() {
        final DBNhanVien dbNhanVien = new DBNhanVien(getApplicationContext());
//        thongKes = dbNhanVien.layDSThongKe();
//        adapterThongKe = new CustomAdapterThongKe(this, R.layout.listview_thongke, thongKes);
//        lvThongke.setAdapter(adapterThongKe);
        DBChamCong dbChamCong = new DBChamCong(getApplicationContext());
        sp_data = dbChamCong.layDSNgayCham();

        adapter_ngaycham = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, sp_data);
        spNgayCham.setAdapter(adapter_ngaycham);

        btnLoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                thongKes = dbNhanVien.locDSThongKe(spNgayCham.getSelectedItem().toString());
                adapterThongKe = new CustomAdapterThongKe(getApplicationContext(), R.layout.listview_thongke, thongKes);
                lvThongke.setAdapter(adapterThongKe);
            }
        });
    }

    private void setControl() {
        lvThongke = findViewById(R.id.lvThongKe);
        spNgayCham = findViewById(R.id.spNgayCham);
        btnLoc = findViewById(R.id.btnLoc);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}