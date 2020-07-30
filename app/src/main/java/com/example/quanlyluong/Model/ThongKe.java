package com.example.quanlyluong.Model;

public class ThongKe {
    String maNhanVien, tenNhanVien, tenPhongBan, luongCoBan, ngayCong, tamUng, ngayChamCong,luong, thucLanh, tongLuong;

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getTenNhanVien() {
        return tenNhanVien;
    }

    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public String getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(String luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public String getNgayCong() {
        return ngayCong;
    }

    public void setNgayCong(String ngayCong) {
        this.ngayCong = ngayCong;
    }

    public String getTamUng() {
        return tamUng;
    }

    public void setTamUng(String tamUng) {
        this.tamUng = tamUng;
    }

    public String getNgayChamCong() {
        return ngayChamCong;
    }

    public void setNgayChamCong(String ngayChamCong) {
        this.ngayChamCong = ngayChamCong;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
    }

    public String getThucLanh() {
        return thucLanh;
    }

    public void setThucLanh(String thucLanh) {
        this.thucLanh = thucLanh;
    }

    public String getTongLuong() {
        return tongLuong;
    }

    public void setTongLuong(String tongLuong) {
        this.tongLuong = tongLuong;
    }

    @Override
    public String toString() {
        return "ThongKe{" +
                "maNhanVien='" + maNhanVien + '\'' +
                ", tenNhanVien='" + tenNhanVien + '\'' +
                ", tenPhongBan='" + tenPhongBan + '\'' +
                ", luongCoBan='" + luongCoBan + '\'' +
                ", ngayCong='" + ngayCong + '\'' +
                ", tamUng='" + tamUng + '\'' +
                ", ngayChamCong='" + ngayChamCong + '\'' +
                '}';
    }
}
