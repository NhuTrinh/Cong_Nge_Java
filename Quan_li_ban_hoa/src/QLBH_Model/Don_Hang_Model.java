/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Model;

import QLBH_Function.Don_Hang;
import QLBH_Function.Giao_Hang;
import QLBH_Function.Gio_Hang;
import QLBH_Function.Khach_Hang;
import QLBH_Function.Nhan_vien;
import QLBH_Function.San_Pham;
import QLBH_Function.Thanh_Toan;
import static QLBH_Model.BaseModel.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Model xử lý các thao tác liên quan đến đơn hàng, giỏ hàng, giao hàng và thanh
 * toán.
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
public class Don_Hang_Model extends BaseModel {

    /**
     * Lấy danh sách tất cả đơn hàng.
     */
    public ArrayList<Don_Hang> getAllDonHang() {
        ArrayList<Don_Hang> dsdh = new ArrayList<>();
        String sql = "select * from DONHANG";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Khach_Hang_Model khModel = new Khach_Hang_Model();
                Khach_Hang kh = khModel.getAllKhachHangTheoMa(rs.getString("MAKHACHHANG"));
                Dang_Nhap_Model dnModel = new Dang_Nhap_Model();
                Nhan_vien nv = dnModel.getAllNhanVienTheoMa(rs.getString("MANHANVIEN"));
                Don_Hang dh = new Don_Hang(rs.getString("SODH"), rs.getString("NGAYLAP"), rs.getString("TRANGTHAI"), rs.getString("MANHANVIEN"), kh.getTenKhachHang(), rs.getDouble("GIABAN"));
                dsdh.add(dh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsdh;
    }

    /**
     * Xóa chi tiết đơn hàng theo mã đơn hàng.
     */
    public boolean xoaCTDonHang(String maDonHang) {
        String sql = "DELETE FROM CTDONHANG WHERE SODH = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Xóa đơn hàng theo mã đơn hàng.
     */
    public boolean xoaDonHang(String maDonHang) {
        String sql = "DELETE FROM DONHANG WHERE SODH = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Lấy thông tin giao hàng theo mã đơn hàng.
     */
    public Giao_Hang getAllGiaoHangTheoMaDon(String maDonHang) {
        String sql = "select * from GIAOHANG WHERE SODH = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Giao_Hang ctgh = new Giao_Hang(rs.getInt("MAGIAOHANG"), rs.getString("SODH"), rs.getString("TENNGUOINHAN"), rs.getString("SODIENTHOAI"), rs.getString("DIACHI"));
                return ctgh;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Lấy thông tin thanh toán theo mã đơn hàng.
     */
    public Thanh_Toan getAllThanhToanTheoMaDon(String maDonHang) {
        String sql = "select * from THANHTOAN WHERE SODH = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Thanh_Toan cttt = new Thanh_Toan(rs.getInt("MATHANHTOAN"), rs.getString("SODH"), rs.getDouble("TIENHANG"), rs.getDouble("VANCHUYEN"), rs.getDouble("PHICAMHOA"), rs.getDouble("VAT"), rs.getDouble("VIP"), rs.getDouble("TONGTIEN"));
                return cttt;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Lấy danh sách giỏ hàng theo mã đơn hàng.
     */
    public ArrayList<Gio_Hang> getAllGioHangTheoMaDon(String maDonHang) {
        String sql = "select * from CTDONHANG WHERE SODH = ?";
        ArrayList<Gio_Hang> dsgh = new ArrayList<>();
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Danh_Sach_Hoa_Model dsModel = new Danh_Sach_Hoa_Model();
                System.out.println("1111: " + rs.getString("MAHOA"));
                String tenHoa = dsModel.getTenHoaTheoMaHoa(rs.getString("MAHOA"));
                Gio_Hang gh = new Gio_Hang(rs.getString("SODH"), tenHoa, rs.getInt("SOLUONG"), rs.getDouble("GIABAN"), rs.getDouble("THANHTIEN"));
                dsgh.add(gh);
                System.out.println("1111: " + dsgh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dsgh;
    }

    /**
     * Cập nhật số lượng hoa trong giỏ hàng theo mã hoa.
     */
    public boolean updateSoLuongHoa(String maHoa, int soLuong) {

        String sql = "UPDATE CTDONHANG SET SOLUONG = ? WHERE MAHOA = ?";
        Danh_Sach_Hoa_Model dsModel = new Danh_Sach_Hoa_Model();
        maHoa = dsModel.getMaHoaTheoTenHoa(maHoa);
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, soLuong);
            ps.setString(2, maHoa);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Lấy mã đơn hàng từ mã hoa trong giỏ hàng.
     */
    public String getMaDonTuMaHoa(String maHoa) {

        String sql = "SELECT SODH FROM CTDONHANG WHERE MAHOA = ?";
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maHoa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("SODH");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * Xóa sản phẩm trong giỏ hàng theo mã hoa.
     */
    public void deleteHoaTrongGioHang(String maHoa) {
        String sql = "DELETE FROM CTDONHANG WHERE MAHOA = ?";
        Danh_Sach_Hoa_Model dsModel = new Danh_Sach_Hoa_Model();
        maHoa = dsModel.getMaHoaTheoTenHoa(maHoa);
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maHoa);
            int rs = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Tìm khách hàng theo số điện thoại.
     */
    public Khach_Hang timKhachHangTheoSoDienThoai(String soDienThoai) {
        String sql = "SELECT * FROM KHACHHANG WHERE SODIENTHOAI = ?";
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, soDienThoai);
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
     * Thêm thông tin giao hàng cho đơn hàng.
     */
    public boolean themThongTinGiaoHangVaoDonHang(String maDonHang, String tenNguoiNhan, String soDienThoaiNhan, String diaChiNhan) {
        String sql = "INSERT INTO GIAOHANG (SODH, TENNGUOINHAN, SODIENTHOAI, DIACHI) VALUES (?, ?, ?, ?)";
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            ps.setString(2, tenNguoiNhan);
            ps.setString(3, soDienThoaiNhan);
            ps.setString(4, diaChiNhan);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Cập nhật thông tin giao hàng cho đơn hàng.
     */
    public boolean capNhatThongTinGiaoHangVaoDonHang(String maDonHang, String tenNguoiNhan, String soDienThoaiNhan, String diaChiNhan) {
        String sql = "UPDATE GIAOHANG SET TENNGUOINHAN = ?, SODIENTHOAI = ?, DIACHI = ? WHERE SODH = ?";
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tenNguoiNhan);
            ps.setString(2, soDienThoaiNhan);
            ps.setString(3, diaChiNhan);
            ps.setString(4, maDonHang);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Kiểm tra xem mã đơn hàng có trong bảng giao hàng không.
     */
    public boolean kiemTraMaDonHangTrongBangGiaoHang(String maDonHang) {
        String sql = "SELECT * FROM GIAOHANG WHERE SODH = ?";
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Lưu sản phẩm vào giỏ hàng theo mã đơn hàng.
     */
    public boolean luuSanPhamVaoGioHang(String maDonHang, String maHoa, int soLuong, double giaBan) {
        String sql = "INSERT INTO CTDONHANG (SODH, MAHOA, SOLUONG, GIABAN) VALUES (?, ?, ?, ?)";
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            ps.setString(2, maHoa);
            ps.setInt(3, soLuong);
            ps.setDouble(4, giaBan);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Tạo đơn hàng tạm với thông tin cơ bản.
     */
    public boolean taoDonHangTam(String maDonHang, String ngayLap, String trangThai, double giaBan, String maNhanVien, String maKhachHang) {
        String sql = "INSERT INTO DONHANG (SODH, NGAYLAP, TRANGTHAI, GIABAN, MANHANVIEN, MAKHACHHANG) VALUES (?, ?, ?, ?, ?, ?)";
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            ps.setString(2, ngayLap);
            ps.setString(3, trangThai);
            ps.setDouble(4, giaBan);
            ps.setString(5, maNhanVien);
            ps.setString(6, maKhachHang);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Tính tổng tiền các hoa trong giỏ hàng theo mã đơn hàng.
     */
    public double tinhTongTienHoaTuGioHang(String maDonHang) {
        String sql = "SELECT THANHTIEN FROM CTDONHANG WHERE SODH = ?";
        double tongTien = 0.0;
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tongTien = tongTien + rs.getDouble("THANHTIEN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongTien;

    }

    /**
     * Tính tổng số lượng hoa trong giỏ hàng theo mã đơn hàng.
     */
    public int tongSoLuongHoaTrongGioHang(String maDonHang) {
        String sql = "SELECT SOLUONG FROM CTDONHANG WHERE SODH = ?";
        int soLuong = 0;
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                soLuong = soLuong + rs.getInt("SOLUONG");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuong;

    }

    /**
     * Thêm thông tin thanh toán cho đơn hàng.
     */
    public boolean themThongTinThanhToan(String maDonHang, double tienHang, double vanChuyen, double phiCamHoa, double VAT, double VIP) {
        String sql = "INSERT INTO THANHTOAN (SODH, TIENHANG, VANCHUYEN, PHICAMHOA, VAT, VIP) VALUES (?, ?, ?, ?, ?, ?)";
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            ps.setDouble(2, tienHang);
            ps.setDouble(3, vanChuyen);
            ps.setDouble(4, phiCamHoa);
            ps.setDouble(5, VAT);
            ps.setDouble(6, VIP);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Cập nhật thông tin thanh toán cho đơn hàng.
     */
    public boolean capNhatThongTinThanhToan(String maDonHang, double tienHang, double vanChuyen, double phiCamHoa, double VAT, double VIP) {
        String sql = "UPDATE THANHTOAN SET TIENHANG = ?, VANCHUYEN = ?, PHICAMHOA = ?, VAT = ?, VIP = ? WHERE SODH = ?";
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, tienHang);
            ps.setDouble(2, vanChuyen);
            ps.setDouble(3, phiCamHoa);
            ps.setDouble(4, VAT);
            ps.setDouble(5, VIP);
            ps.setString(6, maDonHang);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Kiểm tra mã đơn hàng có trong bảng thanh toán không.
     */
    public boolean kiemTraMaDonHangTrongBangThanhToan(String maDonHang) {
        String sql = "SELECT * FROM THANHTOAN WHERE SODH = ?";
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Lấy tổng tiền thanh toán của đơn hàng.
     */
    public double layTongThanhToanDonHang(String maDonHang) {
        String sql = "SELECT TONGTIEN FROM THANHTOAN WHERE SODH = ?";
        double tongTien = 0.0;
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tongTien = rs.getDouble("TONGTIEN");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongTien;

    }

    /**
     * Cập nhật tổng tiền trong đơn hàng.
     */
    public boolean capNhatDonHang(String maDonHang, double tongTien) {
        String sql = "UPDATE DONHANG SET GIABAN = ? WHERE SODH = ?";
        try {

            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, tongTien);
            ps.setString(2, maDonHang);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    /**
     * Xóa thông tin thanh toán của đơn hàng.
     */
    public boolean xoaThanhToan(String maDonHang) {
        String sql = "DELETE FROM THANHTOAN WHERE SODH = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Xóa thông tin giao hàng của đơn hàng.
     */
    public boolean xoaThongTinGiaoHang(String maDonHang) {
        String sql = "DELETE FROM GIAOHANG WHERE SODH = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Xóa giỏ hàng theo mã đơn hàng.
     */
    public boolean xoaGioHang(String maDonHang) {
        String sql = "DELETE FROM CTDONHANG WHERE SODH = ?";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maDonHang);
            int rs = ps.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
