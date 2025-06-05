/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Model;

import QLBH_Function.Khach_Hang;
import static QLBH_Model.BaseModel.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Lớp model để thao tác với bảng KHACHHANG trong cơ sở dữ liệu. Cung cấp các
 * phương thức CRUD và truy vấn liên quan đến khách hàng.
 */
/**
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024 Phạm Nguyễn Hoàng Long - 23540017
 */
public class Khach_Hang_Model extends BaseModel {

    /**
     * Lấy danh sách tất cả khách hàng từ bảng KHACHHANG.
     *
     * @return Danh sách các đối tượng Khach_Hang.
     */
    public ArrayList<Khach_Hang> getAllKhachHang() {
        ArrayList<Khach_Hang> dskh = new ArrayList<>();
        String sql = "select * from KHACHHANG";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Khach_Hang kh = new Khach_Hang(rs.getString("MAKHACHHANG"), rs.getString("TENKHACHHANG"), rs.getString("SODIENTHOAI"), rs.getString("XEPLOAI"), rs.getString("EMAIL"), rs.getString("DIACHI"));
                dskh.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dskh;
    }

    /**
     * Lấy thông tin khách hàng theo mã khách hàng.
     *
     * @param maKhachHang Mã khách hàng cần tìm.
     * @return Đối tượng Khach_Hang nếu tìm thấy, ngược lại trả về null.
     */
    public Khach_Hang getAllKhachHangTheoMa(String maKhachHang) {
        String sql = "select * from KHACHHANG where MAKHACHHANG =?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maKhachHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Khach_Hang kh = new Khach_Hang(rs.getString("MAKHACHHANG"), rs.getString("TENKHACHHANG"), rs.getString("SODIENTHOAI"), rs.getString("XEPLOAI"), rs.getString("EMAIL"), rs.getString("DIACHI"));
                return kh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Lấy thông tin khách hàng theo tên khách hàng.
     *
     * @param tenKhachHang Tên khách hàng cần tìm.
     * @return Đối tượng Khach_Hang nếu tìm thấy, ngược lại trả về null.
     */
    public Khach_Hang getAllKhachHangTheoTen(String tenKhachHang) {
        String sql = "select * from KHACHHANG where TENKHACHHANG =?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenKhachHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Khach_Hang kh = new Khach_Hang(rs.getString("MAKHACHHANG"), rs.getString("TENKHACHHANG"), rs.getString("SODIENTHOAI"), rs.getString("XEPLOAI"), rs.getString("EMAIL"), rs.getString("DIACHI"));
                return kh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Thêm khách hàng mới vào cơ sở dữ liệu.
     *
     * @return true nếu thêm thành công, false nếu thất bại.
     */
    public boolean themKhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, String xepLoai, String email, String diaChi) {
        String sql = "INSERT INTO KHACHHANG (MAKHACHHANG, TENKHACHHANG, SODIENTHOAI, XEPLOAI, EMAIL, DIACHI) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maKhachHang);
            ps.setString(2, tenKhachHang);
            ps.setString(3, soDienThoai);
            ps.setString(4, xepLoai);
            ps.setString(5, email);
            ps.setString(6, diaChi);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Cập nhật thông tin khách hàng theo mã khách hàng.
     *
     * @return true nếu cập nhật thành công, false nếu thất bại.
     */
    public boolean capNhatKhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, String xepLoai, String email, String diaChi) {
        String sql = "UPDATE KHACHHANG SET TENKHACHHANG = ?, SODIENTHOAI = ?, XEPLOAI = ?, EMAIL = ?, DIACHI = ? WHERE MAKHACHHANG = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenKhachHang);
            ps.setString(2, soDienThoai);
            ps.setString(3, xepLoai);
            ps.setString(4, email);
            ps.setString(5, diaChi);
            ps.setString(6, maKhachHang);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Xóa khách hàng theo mã khách hàng.
     *
     * @return true nếu xóa thành công, false nếu thất bại.
     */
    public boolean xoaKhachHang(String maKhachHang) {
        String sql = "DELETE FROM KHACHHANG WHERE MAKHACHHANG = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maKhachHang);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Lấy xếp loại của khách hàng theo mã khách hàng.
     *
     * @return Xếp loại nếu có, ngược lại trả về 0.
     */
    public int layXepLoaiKhachHang(String maKhachHang) {
        String sql = "SELECT XEPLOAI FROM KHACHHANG WHERE MAKHACHHANG = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("XEPLOAI");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
