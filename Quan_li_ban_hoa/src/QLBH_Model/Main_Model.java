/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Model;

import QLBH_Function.Nhan_vien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024 Phạm Nguyễn Hoàng Long - 23540017
 */
/**
 * Lớp Main_Model kế thừa từ BaseModel, cung cấp các phương thức truy xuất dữ
 * liệu liên quan đến nhân viên và bộ phận từ cơ sở dữ liệu.
 */
public class Main_Model extends BaseModel {

    /**
     * Lấy thông tin nhân viên dựa trên mã nhân viên truyền vào.
     *
     * @param maNhanVienString Mã nhân viên cần tìm.
     * @return Đối tượng Nhan_vien chứa thông tin nhân viên nếu tìm thấy, ngược
     * lại trả về null.
     */
    public Nhan_vien getNhanVienTheoMa(String maNhanVienString) {
        Nhan_vien nv;
        String sql = "select * from NHANVIEN where MANHANVIEN = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maNhanVienString);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nv = new Nhan_vien(rs.getString("MANHANVIEN"), rs.getString("TENNHANVIEN"), rs.getString("SODIENTHOAI"), rs.getString("MABOPHAN"));
                ps.close();
                rs.close();
                conn.close();
                return nv;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Lấy tên bộ phận dựa trên mã bộ phận truyền vào.
     *
     * @param maBoPhanString Mã bộ phận cần tìm.
     * @return Tên bộ phận nếu tìm thấy, ngược lại trả về null.
     */
    public String getTenBoPhanTheoMa(String maBoPhanString) {
        String sql = "select * from BOPHAN where MABOPHAN = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maBoPhanString);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String tenBoPhanString = rs.getString("TENBOPHAN");
                ps.close();
                rs.close();
                conn.close();
                return tenBoPhanString;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
