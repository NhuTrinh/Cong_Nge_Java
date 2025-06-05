/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Model;

import QLBH_Function.Nhan_vien;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Lớp Dang_Nhap_Model xử lý logic dữ liệu liên quan đến đăng nhập và truy xuất
 * thông tin nhân viên từ cơ sở dữ liệu.
 *
 * Kế thừa lớp BaseModel để sử dụng sẵn kết nối CSDL.
 *
 * Các chức năng chính bao gồm: - Kiểm tra tài khoản đăng nhập. - Lấy thông tin
 * nhân viên theo mã. - Lấy danh sách toàn bộ nhân viên.
 *
 * CSDL: bảng DANGNHAP và NHANVIEN.
 *
 * Author: Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
public class Dang_Nhap_Model extends BaseModel {

    /**
     * Kiểm tra thông tin đăng nhập dựa vào tên đăng nhập và mật khẩu.
     *
     * @param userName Tên đăng nhập của người dùng.
     * @param passWord Mật khẩu tương ứng.
     * @return Mã nhân viên nếu đăng nhập thành công, ngược lại trả về null.
     */
    public String login(String userName, String passWord) {
        String sql = "select MANHANVIEN from DANGNHAP where USERNAME = ? and PASSWORD = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, passWord);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String maNhanVienString = rs.getString("MANHANVIEN");
                ps.close();
                rs.close();
                conn.close();
                return maNhanVienString;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Lấy thông tin chi tiết của một nhân viên dựa theo mã nhân viên.
     *
     * @param maNhanVien Mã định danh của nhân viên cần truy vấn.
     * @return Đối tượng Nhan_vien nếu tồn tại, ngược lại trả về null.
     */
    public Nhan_vien getAllNhanVienTheoMa(String maNhanVien) {
        String sql = "select * from NHANVIEN where MANHANVIEN =?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVien);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Nhan_vien kh = new Nhan_vien(rs.getString("MANHANVIEN"), rs.getString("TENNHANVIEN"), rs.getString("SODIENTHOAI"), rs.getString("MABOPHAN"));
                return kh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Truy xuất danh sách toàn bộ nhân viên hiện có trong hệ thống.
     *
     * @return Danh sách đối tượng Nhan_vien.
     */
    public ArrayList<Nhan_vien> getAllNhanVienTheoMa() {
        String sql = "select * from NHANVIEN";
        ArrayList<Nhan_vien> dsnv = new ArrayList<>();
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Nhan_vien nv = new Nhan_vien(rs.getString("MANHANVIEN"), rs.getString("TENNHANVIEN"), rs.getString("SODIENTHOAI"), rs.getString("MABOPHAN"));
                dsnv.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsnv;
    }

}
