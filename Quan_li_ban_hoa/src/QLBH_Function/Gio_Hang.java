/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

import java.time.Period;

/**
 *
 * @author TOSHIBA
 */
public class Gio_Hang {
    private String maDonHang;
    private String maHoa;
    private int soLuong;
    private double giaBan;
    private double thanhTien;

    public Gio_Hang(String maDonHang, String maHoa, int soLuong, double giaBan, double thanhTien) {
        this.maDonHang = maDonHang;
        this.maHoa = maHoa;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public String getMaHoa() {
        return maHoa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public void setMaHoa(String maHoa) {
        this.maHoa = maHoa;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    public Object[] getArrGioHang() {
        return new Object[]{maDonHang, maHoa, soLuong, giaBan, thanhTien};
    }
}
