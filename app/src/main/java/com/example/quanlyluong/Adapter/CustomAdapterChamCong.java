package com.example.quanlyluong.Adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.quanlyluong.Model.ChamCong;

import java.util.ArrayList;

public class CustomAdapterChamCong extends ArrayAdapter {
    Context context;
    int  resource;
    ArrayList<ChamCong> data;
    public CustomAdapterChamCong(Context context, int resource, ArrayList<ChamCong> data) {
        super(context, resource);
        this.context=context;
        this.resource=resource;
        this.data=data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
