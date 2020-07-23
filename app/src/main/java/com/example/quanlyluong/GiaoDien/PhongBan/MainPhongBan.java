package com.example.quanlyluong.GiaoDien.PhongBan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.quanlyluong.Adapter.CustomAdapterPhongBan;
import com.example.quanlyluong.DataBase.DBPhongBan;
import com.example.quanlyluong.Model.PhongBan;
import com.example.quanlyluong.R;

public class MainPhongBan extends AppCompatActivity {
    EditText txtMaPhong,txtTenPhong;
    Button btnThem;
    ImageButton btnThoat,btnClear;
    ListView lvDanhSach;
    boolean ngonNgu =true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.phongban);
        setControl();
        setEvent();
    }

    private void setEvent() {
        Load();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhongBan phongBan = new PhongBan();
                phongBan . setMaPhong(txtMaPhong.getText().toString());
                phongBan.setTenPhong(txtTenPhong.getText().toString());
                DBPhongBan dbPhongBan = new DBPhongBan(getApplicationContext());
                dbPhongBan.themPhongBan(phongBan);
                Toast.makeText(MainPhongBan.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                Load();
            }
        });
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainPhongBan.this);
                builder.setTitle("Thông báo");
                builder.setMessage("Bạn có muốn thoát không");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                builder.show();
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtMaPhong.setText("");
                txtTenPhong.setText("");
            }
        });
    }
    private void Load()
    {
        DBPhongBan dbPhongBan = new DBPhongBan(this);
        CustomAdapterPhongBan adapter = new CustomAdapterPhongBan(this,R.layout.listview_phongban,dbPhongBan.layDuLieu());
        lvDanhSach.setAdapter(adapter);
    }

    private void setControl() {
        txtMaPhong = findViewById(R.id.txtMaPhong);
        txtTenPhong = findViewById(R.id.txtTenPhong);
        btnThem = findViewById(R.id.btnThem);
        btnThoat = findViewById(R.id.btnThoat);
        btnClear = findViewById(R.id.btnClear);
        lvDanhSach = findViewById(R.id.lvDanhSach);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity,menu);
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
            case R.id.show:
                Intent intent = new Intent(MainPhongBan.this, ListViewPhongBan.class);
                startActivity(intent);
                break;
            case R.id.gridview:
                Intent intent1 = new Intent(MainPhongBan.this,GridviewPhongBan.class);
                startActivity(intent1);
                break;
            case R.id.recycleview:
                Intent intent2 = new Intent(MainPhongBan.this,RecyclerViewPhongBan.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
