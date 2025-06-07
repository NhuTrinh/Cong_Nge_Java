/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

import java.time.Period;

/**
 * Lớp Gio_Hang đại diện cho một mặt hàng trong giỏ hàng của đơn hàng. Chứa mã
 * đơn hàng, mã hoa, số lượng, giá bán và thành tiền.
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
public class Gio_Hang {

    private String maDonHang;
    private String maHoa;
    private int soLuong;
    private double giaBan;
    private double thanhTien;

    /**
     * Constructor khởi tạo đối tượng Gio_Hang.
     */
    public Gio_Hang(String maDonHang, String maHoa, int soLuong, double giaBan, double thanhTien) {
        this.maDonHang = maDonHang;
        this.maHoa = maHoa;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thanhTien = thanhTien;
    }

    // Getters
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

    // Setters
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

    /**
     * Trả về dữ liệu giỏ hàng dưới dạng mảng Object, thuận tiện cho việc hiển
     * thị trong bảng (JTable).
     */
    public Object[] getArrGioHang() {
        return new Object[]{maDonHang, maHoa, soLuong, giaBan, thanhTien};
    }
}
