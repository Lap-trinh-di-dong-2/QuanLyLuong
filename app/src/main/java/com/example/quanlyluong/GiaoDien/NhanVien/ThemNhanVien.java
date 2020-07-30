package com.example.quanlyluong.GiaoDien.NhanVien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.quanlyluong.DataBase.DBNhanVien;
import com.example.quanlyluong.DataBase.DBPhongBan;
import com.example.quanlyluong.Model.NhanVien;
import com.example.quanlyluong.Model.PhongBan;
import com.example.quanlyluong.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;

public class ThemNhanVien extends AppCompatActivity {
    final int RESQUEST_TAKE_PHOTO = 123;
    final int REQUEST_CHOOSE_PHOTO = 321;
    Button btnChonHinh, btnChupHinh, btnHuy;
    ImageView imgHinhDaiDien;
    Button btnLuuNhanVien, btnsetDay;
    Calendar calendar;
    int year, month, day;
    EditText txtMaNhanVien,txtTenNhanVien,txtNgaySinh,txtHeSoLuong;
    RadioButton radNam,radNu;
    Spinner spPhongBan;
    ArrayList<String> data_phongban = new ArrayList<>();
    ArrayAdapter adapter_phongban;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.them_nhanvien);
        setControl();
        setEvent();
    }

    private void setEvent() {
        DBPhongBan dbPhongBan = new DBPhongBan(getApplicationContext());
        data_phongban = dbPhongBan.layDSPhongBan();

        adapter_phongban = new ArrayAdapter(ThemNhanVien.this,android.R.layout.simple_spinner_item,data_phongban);
        spPhongBan.setAdapter(adapter_phongban);


        showDate(year, month+1, day);
        btnsetDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(1);
            }
        });



        btnLuuNhanVien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                themNhanVien();
                Intent intent =new Intent(ThemNhanVien.this,MainNhanVien.class);
                startActivity(intent);
                finish();
            }
        });

        btnChonHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoto();
            }
        });
        btnChupHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takePicture();
            }
        });


        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

    private void themNhanVien() {

        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNhanVien(txtMaNhanVien.getText().toString());
        nhanVien.setTenNhanVien(txtTenNhanVien.getText().toString());
        nhanVien.setNgaySinh(txtNgaySinh.getText().toString());
        if(radNu.isChecked() == true)
        {
            nhanVien.setGioiTinh("Nữ");
            radNam.setChecked(false);
        }
        if(radNam.isChecked() == true){
            nhanVien.setGioiTinh("Nam");
        }
        byte[] anh = getByteArrayFromImageView(imgHinhDaiDien);
        nhanVien.setAnh(anh);
        nhanVien.setPhongBan(spPhongBan.getSelectedItem().toString());
        nhanVien.setHeSoLuong(txtHeSoLuong.getText().toString());

        DBNhanVien dbNhanVien = new DBNhanVien(getApplicationContext());
        dbNhanVien.themNhanVien(nhanVien);
    }


    private void setControl() {
        btnLuuNhanVien = findViewById(R.id.btnSuaNhanVien);
        spPhongBan = findViewById(R.id.spPhongBan);
        txtMaNhanVien = findViewById(R.id.txtMaNhanVien);
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


        btnChonHinh = findViewById(R.id.btnChonHinh);
        btnChupHinh = findViewById(R.id.btnChupHinh);
        btnHuy = findViewById(R.id.btnHuy);
        imgHinhDaiDien = findViewById(R.id.imgHinhDaiDien);



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
        public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
            showDate(i, i1 + 1, i2);
        }
    };

    private void showDate(int year, int month, int day) {
        txtNgaySinh.setText(new StringBuilder().append(day > 9 ? day: "0"+day).append("/").append(month > 9 ?
                month: "0" + month).append("/").append(year));
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


    private void choosePhoto(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_CHOOSE_PHOTO);
    }

    private void takePicture(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, RESQUEST_TAKE_PHOTO);
    }
    private void cancel(){
        Intent intent = new Intent(this, MainNhanVien.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CHOOSE_PHOTO) {
                try {
                    Uri imageUri = data.getData();
                    InputStream is = getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    imgHinhDaiDien.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            } else if (requestCode == RESQUEST_TAKE_PHOTO) {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                imgHinhDaiDien.setImageBitmap(bitmap);
            }
        }
    }

    private byte[] getByteArrayFromImageView(ImageView imgv){

        BitmapDrawable drawable = (BitmapDrawable) imgv.getDrawable();
        Bitmap bmp = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }

}