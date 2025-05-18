/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

import java.util.ArrayList;

/**
 *
 * @author TOSHIBA
 */
public class Cua_Hang {
    private String tenCuaHang;
    private ArrayList<Nhan_vien> dsNhanVien;
    private ArrayList<Don_Hang> dsDonHang;
    private ArrayList<San_Pham> dsSanPham;
    private ArrayList<Khach_Hang> dsKhachHang;

    /*
    Constructor
        + String tenCuaHang;
    */
    public Cua_Hang(String tenCuaHang) {
        this.tenCuaHang = tenCuaHang;
        this.dsNhanVien = new ArrayList<>();
        this.dsDonHang = new ArrayList<>();
        this.dsSanPham = new ArrayList<>();
        this.dsKhachHang = new ArrayList<>();
    }
    
    public void printDSKH(ArrayList<Khach_Hang> dsKhachHang)
    {
        for(Khach_Hang kh : dsKhachHang)
        {
            System.out.println(kh);
        }
    }
}
