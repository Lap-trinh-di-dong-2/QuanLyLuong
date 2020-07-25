package com.example.quanlyluong.GiaoDien.PhongBan;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlyluong.Adapter.CustomAdapterPhongBan;
import com.example.quanlyluong.DataBase.DBPhongBan;
import com.example.quanlyluong.R;

public class GridviewPhongBan extends AppCompatActivity {
    GridView gvDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridviewlist_phongban);
        setControl();
        setEvent();

    }

    private void setEvent() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        DBPhongBan dbPhongBan = new DBPhongBan(this);
        CustomAdapterPhongBan adapter = new CustomAdapterPhongBan(this,R.layout.gridview_phongban,dbPhongBan.layDuLieu());
        gvDanhSach.setAdapter(adapter);

    }

    private void setControl() {
        gvDanhSach = findViewById(R.id.gridDanhSach);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
