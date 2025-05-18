/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

/**
 *
 * @author TOSHIBA
 */
public class Nhan_vien {
    private String maNhanVien;
    private String tenNhanVien;
    private String soDienThoai;
    private String maBoPhan;
    
    /*
    Constructor
        + String maNhanVien
        + String tenNhanVien
        + String soDienThoai
        + String maBoPhan
    */
    public Nhan_vien(String maNhanVien, String tenNhanVien, String soDienThoai, String maBoPhan) {
        this.maNhanVien = maNhanVien;
        this.tenNhanVien = tenNhanVien;
        this.soDienThoai = soDienThoai;
        this.maBoPhan = maBoPhan;
    }
    
    /*
    Get mã nhân viên: String
    */
    public String getMaNhanVien() {
        return maNhanVien;
    }
    
    /*
    Get tên nhân viên: String
    */
    public String getTenNhanVien() {
        return tenNhanVien;
    }
    
    /*
    Get số điện thoại: String
    */
    public String getSoDienThoai() {
        return soDienThoai;
    }
    
    /*
    Get mã bộ phận: String
    */
    public String getMaBoPhan() {
        return maBoPhan;
    }
    
    /*
    Set mã nhân viên
        String maNhanVien
    */
    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }
    
    /*
    Set Tên nhân viên
        String tenNhanVien
    */
    public void setTenNhanVien(String tenNhanVien) {
        this.tenNhanVien = tenNhanVien;
    }
    
    /*
    Set số điện thoại
        String số điện thoại
    */
    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
    
    /*
    Set mã bộ phận
        String maBoPhan
    */
    public void setMaBoPhan(String maBoPhan) {
        this.maBoPhan = maBoPhan;
    }
}
