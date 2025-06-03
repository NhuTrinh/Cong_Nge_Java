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
 *
 * @author TOSHIBA
 */
public class Don_Hang_Model extends BaseModel{
    public ArrayList<Don_Hang> getAllDonHang(){
        ArrayList<Don_Hang> dsdh = new ArrayList<>();
        String sql = "select * from DONHANG";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);  
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                  Khach_Hang_Model khModel = new Khach_Hang_Model();
                  Khach_Hang kh = khModel.getAllKhachHangTheoMa(rs.getString("MAKHACHHANG"));
                  Dang_Nhap_Model dnModel = new Dang_Nhap_Model();
                  Nhan_vien nv = dnModel.getAllNhanVienTheoMa(rs.getString("MANHANVIEN"));
                  Don_Hang dh = new Don_Hang(rs.getString("SODH"), rs.getString("NGAYLAP"), rs.getString("TRANGTHAI"), nv.getTenNhanVien(), kh.getTenKhachHang(), rs.getDouble("GIABAN"));
                  dsdh.add(dh);
              }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dsdh;
    } 
    
    public boolean xoaCTDonHang(String maDonHang){
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
    
    public boolean xoaDonHang(String maDonHang){
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
    
    public Giao_Hang getAllGiaoHangTheoMaDon(String maDonHang){
        String sql = "select * from GIAOHANG WHERE SODH = ?";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);  
              ps.setString(1, maDonHang);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                  Giao_Hang ctgh = new Giao_Hang(rs.getInt("MAGIAOHANG"), rs.getString("SODH"), rs.getString("TENNGUOINHAN"), rs.getString("SODIENTHOAI"), rs.getString("DIACHI"));
                  return ctgh;
              }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    } 
    
    public Thanh_Toan getAllThanhToanTheoMaDon(String maDonHang){
        String sql = "select * from THANHTOAN WHERE SODH = ?";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);  
              ps.setString(1, maDonHang);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                  Thanh_Toan cttt = new Thanh_Toan(rs.getInt("MATHANHTOAN"), rs.getString("SODH"), rs.getDouble("TIENHANG"), rs.getDouble("VANCHUYEN"), rs.getDouble("PHICAMHOA"), rs.getDouble("VAT"), rs.getDouble("VIP"), rs.getDouble("TONGTIEN"));
                  return cttt;
              }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    } 
    
    public ArrayList<Gio_Hang> getAllGioHangTheoMaDon(String maDonHang){
        String sql = "select * from CTDONHANG WHERE SODH = ?";
        ArrayList<Gio_Hang> dsgh = new ArrayList<>();
        try {
            
            Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);  
              ps.setString(1, maDonHang);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
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
    
    public boolean updateSoLuongHoa(String maHoa, int soLuong){
        
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
    
    public String getMaDonTuMaHoa(String maHoa){
        
        String sql = "SELECT SODH FROM CTDONHANG WHERE MAHOA = ?";
        try {
            
            Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);  
              ps.setString(1, maHoa);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                  return rs.getString("SODH");
              } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    } 

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
    
    public Khach_Hang timKhachHangTheoSoDienThoai (String soDienThoai) {
        String sql = "SELECT * FROM KHACHHANG WHERE SODIENTHOAI = ?";
        try {
            
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);  
              ps.setString(1, soDienThoai);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                  Khach_Hang kh = new Khach_Hang(rs.getString("MAKHACHHANG"), rs.getString("TENKHACHHANG"), rs.getString("SODIENTHOAI"), rs.getString("XEPLOAI"), rs.getString("EMAIL"), rs.getString("DIACHI"));
                  return kh;
              } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    } 
    
    public boolean themThongTinGiaoHangVaoDonHang (String maDonHang, String tenNguoiNhan, String soDienThoaiNhan, String diaChiNhan ) {
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
    
    public boolean luuSanPhamVaoGioHang (String maDonHang, String maHoa, int soLuong, double giaBan) {
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
    
    public boolean taoDonHangTam (String maDonHang, String ngayLap, String trangThai, double giaBan, String maNhanVien, String maKhachHang) {
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
    
    public double tinhTongTienHoaTuGioHang(String maDonHang) {
        String sql = "SELECT THANHTIEN FROM CTDONHANG WHERE SODH = ?";
        double tongTien = 0.0;
        try {
            
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);  
              ps.setString(1, maDonHang);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                  tongTien = tongTien + rs.getDouble("THANHTIEN");
              } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongTien;
        
    }
    
    public int tongSoLuongHoaTrongGioHang(String maDonHang) {
        String sql = "SELECT SOLUONG FROM CTDONHANG WHERE SODH = ?";
        int soLuong = 0;
        try {
            
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);  
              ps.setString(1, maDonHang);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                  soLuong = soLuong + rs.getInt("SOLUONG");
              } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuong;
        
    }
    
    public boolean themThongTinThanhToan (String maDonHang, double tienHang, double vanChuyen, double phiCamHoa, double VAT, double VIP) {
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
    
    public double layTongThanhToanDonHang(String maDonHang) {
        String sql = "SELECT TONGTIEN FROM THANHTOAN WHERE SODH = ?";
        double tongTien = 0.0;
        try {
            
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);  
              ps.setString(1, maDonHang);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                  tongTien = rs.getDouble("TONGTIEN");
              } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tongTien;
        
    }
    
    public boolean capNhatDonHang(String maDonHang, double tongTien){
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
}
