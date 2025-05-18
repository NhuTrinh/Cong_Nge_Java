/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

/**
 *
 * @author TOSHIBA
 */
public class Khach_Hang {
    private String maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    private String xepLoai;
    private String email;
    private String diaChi;

    public Khach_Hang(String maKhachHang, String tenKhachHang, String soDienThoai, String xepLoai, String email, String diaChi) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.xepLoai = xepLoai;
        this.email = email;
        this.diaChi = diaChi;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getXepLoai() {
        return xepLoai;
    }

    public String getEmail() {
        return email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public void setXepLoai(String xepLoai) {
        this.xepLoai = xepLoai;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "%s, %s , %s, %s, %s, %s".formatted(maKhachHang, tenKhachHang, soDienThoai, xepLoai, email, diaChi);
    }
    
    public Object[] getArrKH() {
        return new Object[]{maKhachHang, tenKhachHang, soDienThoai, diaChi};
    }
}
