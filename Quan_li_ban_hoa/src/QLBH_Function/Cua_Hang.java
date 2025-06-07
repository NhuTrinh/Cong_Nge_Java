/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

import java.util.ArrayList;

/**
 * Lớp Cua_Hang đại diện cho cửa hàng với danh sách nhân viên, đơn hàng, sản phẩm và khách hàng.
 * 
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
public class Cua_Hang {
    private String tenCuaHang;
    private ArrayList<Nhan_vien> dsNhanVien;
    private ArrayList<Don_Hang> dsDonHang;
    private ArrayList<San_Pham> dsSanPham;
    private ArrayList<Khach_Hang> dsKhachHang;

    /**
     * Constructor khởi tạo cửa hàng với tên và danh sách rỗng cho các thuộc tính.
     * @param tenCuaHang Tên cửa hàng
     */
    public Cua_Hang(String tenCuaHang) {
        this.tenCuaHang = tenCuaHang;
        this.dsNhanVien = new ArrayList<>();
        this.dsDonHang = new ArrayList<>();
        this.dsSanPham = new ArrayList<>();
        this.dsKhachHang = new ArrayList<>();
    }
    
    /**
     * In danh sách khách hàng ra console.
     * @param dsKhachHang Danh sách khách hàng cần in
     */
    public void printDSKH(ArrayList<Khach_Hang> dsKhachHang)
    {
        for(Khach_Hang kh : dsKhachHang)
        {
            System.out.println(kh);
        }
    }
}
