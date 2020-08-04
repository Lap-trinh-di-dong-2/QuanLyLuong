package com.example.quanlyluong.GiaoDien.PhongBan;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.quanlyluong.DataBase.DBPhongBan;
import com.example.quanlyluong.Library.CheckError;
import com.example.quanlyluong.Model.PhongBan;
import com.example.quanlyluong.R;

import java.util.ArrayList;

public class EditPhongBan extends AppCompatActivity {
    TextView tvMaPhong;
    EditText txtTenPhong;
    Button btnSua, btnThoat;
    ArrayList<PhongBan> data_phongban = new ArrayList<>();
    CheckError checkError = new CheckError(EditPhongBan.this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_phongban);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setControl();
        setEvent();

    }

    private void setEvent() {
        String ma = getIntent().getExtras().getString("ma");
        DBPhongBan dbPhongBan = new DBPhongBan(getApplicationContext());
        data_phongban = dbPhongBan.layDuLieu(ma);
        tvMaPhong.setText(data_phongban.get(0).getMaPhong());
        txtTenPhong.setText(data_phongban.get(0).getTenPhong());

        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txtTenPhong.getText().toString().isEmpty()) {
                    checkError.checkEmpty(txtTenPhong, "Vui lòng nhập tên phòng");
                } else {
                    PhongBan phongBan = new PhongBan();
                    phongBan.setMaPhong(tvMaPhong.getText().toString());
                    phongBan.setTenPhong(txtTenPhong.getText().toString());
                    DBPhongBan dbPhongBan = new DBPhongBan(getApplicationContext());
                    dbPhongBan.suaPhongBan(phongBan);
                    Intent intent = new Intent(EditPhongBan.this, MainPhongBan.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(getApplicationContext(), "Sửa thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setControl() {
        btnSua = findViewById(R.id.btnSua);
        btnThoat = findViewById(R.id.btnThoat);
        tvMaPhong = findViewById(R.id.tvMaPhong);
        txtTenPhong = findViewById(R.id.txtTenPhong);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }
}
