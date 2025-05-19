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
 *
 * @author TOSHIBA
 */
public class Khach_Hang_Model extends BaseModel{
    
    public ArrayList<Khach_Hang> getAllKhachHang(){
        ArrayList<Khach_Hang> dskh = new ArrayList<>();
        String sql = "select * from KHACHHANG";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);  
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                  Khach_Hang kh = new Khach_Hang(rs.getString("MAKHACHHANG"), rs.getString("TENKHACHHANG"), rs.getString("SODIENTHOAI"), rs.getString("XEPLOAI"), rs.getString("EMAIL"), rs.getString("DIACHI"));
                  dskh.add(kh);
              }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dskh;
    } 
    
    public Khach_Hang getAllKhachHangTheoMa(String maKhachHang){
        String sql = "select * from KHACHHANG where MAKHACHHANG =?";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);   
              ps.setString(1, maKhachHang);
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
    
    public boolean themKhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, String xepLoai, String email, String diaChi){
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
    
    public boolean capNhatKhachHang(String maKhachHang, String tenKhachHang, String soDienThoai, String xepLoai, String email, String diaChi){
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
    
    public boolean xoaKhachHang(String maKhachHang){
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
}
