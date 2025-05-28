/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

/**
 *
 * @author TOSHIBA
 */
public class Giao_Hang {
    private int maGiaoHang;
    private String maDonHang;
    private String tenNguoiNhan;
    private String soDienThoai;
    private String diaChi;

    public Giao_Hang(int maGiaoHang, String maDonHang, String tenNguoiNhan, String soDienThoai, String diaChi) {
        this.maGiaoHang = maGiaoHang;
        this.maDonHang = maDonHang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }
    
    
    
}
