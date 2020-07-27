package com.example.quanlyluong.GiaoDien.TamUng;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlyluong.Adapter.CustomAdapterTamUng;
import com.example.quanlyluong.DataBase.DBTamUng;
import com.example.quanlyluong.Model.TamUng;
import com.example.quanlyluong.R;

import java.util.ArrayList;

public class BangTamUng extends AppCompatActivity {
    ImageView imgXoa, imgTamUng;
    ListView lvDanhSachTU;
    CustomAdapterTamUng adapterTU;
    ArrayList<TamUng> dataTU = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bang_tamung);
        setControl();
        setEvent();
    }

    private void setEvent() {
        HienThiDL();
    }

    private void HienThiDL() {
        DBTamUng dbTamUng = new DBTamUng(getApplicationContext());
        dataTU = dbTamUng.layDuLieu();
        adapterTU = new CustomAdapterTamUng(BangTamUng.this, R.layout.listview_tamung, dataTU);
        adapterTU.notifyDataSetChanged();
        lvDanhSachTU.setAdapter(adapterTU);
    }

    private void setControl() {
        imgTamUng = findViewById(R.id.imgTamUng);
        imgXoa = findViewById(R.id.imgXoa);
        lvDanhSachTU = findViewById(R.id.lvBangTamUng);
    }


}