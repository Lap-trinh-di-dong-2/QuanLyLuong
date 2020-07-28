package com.example.quanlyluong.GiaoDien.ChamCong;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlyluong.Adapter.CustomAdapterChamCong;
import com.example.quanlyluong.DataBase.DBChamCong;
import com.example.quanlyluong.Model.ChamCong;
import com.example.quanlyluong.R;

import java.util.ArrayList;

public class BangChamCong extends AppCompatActivity {
    ImageView imgXoa, imgTamUng;
    ListView lvChamCong;
   CustomAdapterChamCong adapter_chamcong;
    ArrayList<ChamCong> data_chamcong = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bang_chamcong);
        setControl();
        setEvent();
    }

    private void setEvent() {
        HienThiDL();
    }
    private void HienThiDL() {
        DBChamCong dbChamCong = new DBChamCong(getApplicationContext());
        data_chamcong = dbChamCong.layDuLieu();
        adapter_chamcong = new CustomAdapterChamCong(BangChamCong.this, R.layout.listview_chamcong, data_chamcong);
        adapter_chamcong.notifyDataSetChanged();
        lvChamCong.setAdapter(adapter_chamcong);
    }
    private void setControl() {
        lvChamCong =findViewById(R.id.lvBangChamCong);

    }
}