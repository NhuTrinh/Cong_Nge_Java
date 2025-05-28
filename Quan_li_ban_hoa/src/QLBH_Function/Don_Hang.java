/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

import jdk.jshell.Diag;

/**
 *
 * @author TOSHIBA
 */
public class Don_Hang {

    private String maDonHang;
    private String ngayLap;
    private String trangThai;
    private String maNhanVien;
    private String maKhachHang;
    private Double tongTien;

    public Don_Hang(String maDonHang, String ngayLap, String trangThai, String maNhanVien, String maKhachHang, Double tongTien) {
        this.maDonHang = maDonHang;
        this.ngayLap = ngayLap;
        this.trangThai = trangThai;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.tongTien = tongTien;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public Double getTongTien() {
        return tongTien;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setTongTien(Double tongTien) {
        this.tongTien = tongTien;
    }
    
    public Object[] getArrDH() {
        return new Object[]{maDonHang, ngayLap, trangThai, maNhanVien, maKhachHang, tongTien};
    }
    

}
