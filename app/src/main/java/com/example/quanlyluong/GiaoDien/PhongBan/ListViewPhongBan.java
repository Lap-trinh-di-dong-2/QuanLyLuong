package com.example.quanlyluong.GiaoDien.PhongBan;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.quanlyluong.Adapter.CustomAdapter;
import com.example.quanlyluong.DataBase.DBPhongBan;
import com.example.quanlyluong.R;

public class ListViewPhongBan extends AppCompatActivity {
    ListView lvDanhSach;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danhsach_phongban);
        setControl();
        setEvent();
    }

    private void setEvent() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        DBPhongBan dbPhongBan = new DBPhongBan(this);
        CustomAdapter adapter = new CustomAdapter(this,R.layout.listview_phongban,dbPhongBan.layDuLieu());
        lvDanhSach.setAdapter(adapter);
    }

    private void setControl() {
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
