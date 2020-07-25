package com.example.quanlyluong.GiaoDien.PhongBan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlyluong.Adapter.AdapterRecycleView;
import com.example.quanlyluong.DataBase.DBPhongBan;
import com.example.quanlyluong.R;


public class RecyclerViewPhongBan extends AppCompatActivity {
    AdapterRecycleView adapterRecycleView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycleview_phongban);
        setControl();
        setEvent();
    }

    private void setEvent() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        DBPhongBan dbPhongBan = new DBPhongBan(getApplicationContext());

        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        adapterRecycleView = new AdapterRecycleView(R.layout.cardview_phongban, dbPhongBan.layDuLieu());
        recyclerView.setAdapter(adapterRecycleView);
    }

    private void setControl() {
        recyclerView = findViewById(R.id.recycleviewPhongBan);
    }


}
