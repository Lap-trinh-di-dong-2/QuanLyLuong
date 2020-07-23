package com.example.quanlyluong.Adapter;


import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quanlyluong.Model.PhongBan;
import com.example.quanlyluong.R;

import java.util.ArrayList;


public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.RecycleViewHolder> {
    private int layoutID;
    private ArrayList<PhongBan> data = new ArrayList<>();

    public AdapterRecycleView(int layoutID,ArrayList<PhongBan> data) {
        this.layoutID = layoutID;
        this.data = data;

    }

    public static class RecycleViewHolder extends RecyclerView.ViewHolder{
        TextView tvMa,tvTen;
        ImageView imgHinh;
        public RecycleViewHolder(View itemView)
        {
            super(itemView);
            tvMa = (TextView) itemView.findViewById(R.id.tvMaPhong);
            tvTen = (TextView) itemView.findViewById(R.id.tvTenPhong);
            imgHinh = (ImageView) itemView.findViewById(R.id.imgHinh);

        }
    }
    @NonNull
    @Override
    public RecycleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CardView cardView =(CardView)inflater.inflate(layoutID,parent,false);
        return new RecycleViewHolder(cardView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onBindViewHolder(RecycleViewHolder holder, int position) {
        PhongBan phongBan = data.get(position);
        Drawable drawable = holder.imgHinh.getResources().getDrawable(R.drawable.phong);
        holder.imgHinh.setImageDrawable(drawable);
        holder.tvMa.setText(phongBan.getMaPhong());
        holder.tvTen.setText(phongBan.getTenPhong());
    }


}
