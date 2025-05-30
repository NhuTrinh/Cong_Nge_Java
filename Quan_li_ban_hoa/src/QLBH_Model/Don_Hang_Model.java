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
        
}
