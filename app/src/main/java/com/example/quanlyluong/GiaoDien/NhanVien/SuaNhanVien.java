package com.example.quanlyluong.GiaoDien.NhanVien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.quanlyluong.DataBase.DBNhanVien;
import com.example.quanlyluong.DataBase.DBPhongBan;
import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.R;

import java.util.ArrayList;
import java.util.Calendar;

public class SuaNhanVien extends AppCompatActivity {
    Button btnsetDay;
    Calendar calendar;
    int year, month, day;

    EditText txtTenNhanVien,txtNgaySinh,txtHeSoLuong;
    TextView tvMaNhanVien;
    RadioButton radNam,radNu;
    Button btnSuaNhanVien;
    Spinner spPhongBan;
    ArrayList<String> data_phongban = new ArrayList<>();
    ArrayAdapter adapter_phongban;
    ArrayList<NhanVien> dataNV = new ArrayList<>();

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
        DBPhongBan dbPhongBan = new DBPhongBan(getApplicationContext());
        data_phongban = dbPhongBan.layDSPhongBan();
        adapter_phongban = new ArrayAdapter(SuaNhanVien.this,android.R.layout.simple_spinner_item,data_phongban);
        spPhongBan.setAdapter(adapter_phongban);

        String manv = getIntent().getExtras().getString("ma");
        DBNhanVien dbNhanVien  =new DBNhanVien(this);
        dataNV = dbNhanVien.layNhanVien(manv);
        tvMaNhanVien.setText(dataNV.get(0).getMaNhanVien());
        txtTenNhanVien.setText(dataNV.get(0).getTenNhanVien());
        txtNgaySinh.setText(dataNV.get(0).getNgaySinh());
        if (dataNV.get(0).getGioiTinh().equals("Nam")) {
            radNam.setChecked(true);
        }
        if (dataNV.get(0).getGioiTinh().equals("Nữ")) {
            radNu.setChecked(true);
        }
        spPhongBan.setSelection(getIndex(spPhongBan, dataNV.get(0).getPhongBan()));
        txtHeSoLuong.setText(dataNV.get(0).getHeSoLuong());


        btnSuaNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                suaNhanVien();
                Intent intent =new Intent(SuaNhanVien.this,MainNhanVien.class);
                startActivity(intent);
            }
        });
        btnsetDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(1);
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

    //Hàm xử lý lấy vị trí phòng trong spinner
    private int getIndex(Spinner spinner, String myString){
        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                return i;
            }
        }

        return 0;
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

        btnsetDay = findViewById(R.id.btnDay);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);

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


    @Override
    protected Dialog onCreateDialog(int id) {
        if(id == 1){
            return new DatePickerDialog(this, dateSetListener,year,month,day);
        }
        return null;
    }

    DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int day, int month, int year) {
            showDate(day, month + 1, year);
        }
    };

    private void showDate(int year, int month, int day) {
        txtNgaySinh.setText(new StringBuilder().append(day > 9 ? day: "0"+day).append("/").append(month > 9 ?
                month: "0" + month).append("/").append(year));
    }
}