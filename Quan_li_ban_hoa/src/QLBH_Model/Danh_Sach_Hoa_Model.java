/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Model;

import QLBH_Function.Khach_Hang;
import QLBH_Function.Loai_Hoa;
import QLBH_Function.San_Pham;
import static QLBH_Model.BaseModel.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author TOSHIBA
 */
public class Danh_Sach_Hoa_Model extends BaseModel{
    
    public ArrayList<San_Pham> getAllHoa(){
        ArrayList<San_Pham> dssp = new ArrayList<>();
        String sql = "select * from HOA";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);  
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                  San_Pham sp = new San_Pham(rs.getString("MAHOA"), rs.getString("TENHOA"), rs.getString("GHICHU"), rs.getString("QUOCGIA"), rs.getString("MAUSAC"), rs.getInt("SOLUONG"), rs.getDouble("GIA"), rs.getString("MALH"));
                  dssp.add(sp);
              }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return dssp;
    } 
    
    public San_Pham getAllHoaTheoMa(String maHoa){
        String sql = "select * from HOA where MAHOA =?";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);   
              ps.setString(1, maHoa);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                  San_Pham sp = new San_Pham(rs.getString("MAHOA"), rs.getString("TENHOA"), rs.getString("GHICHU"), rs.getString("QUOCGIA"), rs.getString("MAUSAC"), rs.getInt("SOLUONG"), rs.getDouble("GIA"), rs.getString("MALH"));
                  return sp;
              }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public String getLoaiHoaTuMaLoaiHoa (String maHoa){
        String sql = "select * from LOAIHOA where MALH =?";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);   
              ps.setString(1, maHoa);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                  String tenLoaiHoa = rs.getString("TENLH");
                  return tenLoaiHoa;
              }  
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return null;
    }
   
    
    public boolean themHoa(String maHoa, String tenHoa, String quocGia, String mauSac, int soLuong, double gia, String loaiHoa, String ghiChu){
        String sql = "INSERT INTO HOA (MAHOA, TENHOA, QUOCGIA, MAUSAC, SOLUONG, GIA, MALH, GHICHU) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);   
             
              ps.setString(1, maHoa);
              ps.setString(2, tenHoa);
              ps.setString(3, quocGia);
              ps.setString(4, mauSac);
              ps.setInt(5, soLuong);
              ps.setDouble(6, gia);
              ps.setString(7, loaiHoa);
              ps.setString(8, ghiChu);
              int rs = ps.executeUpdate();
              return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean capNhatHoa(String maHoa, String tenHoa, String quocGia, String mauSac, int soLuong, double gia, String loaiHoa, String ghiChu){
        String sql = "UPDATE HOA SET TENHOA = ?, QUOCGIA = ?, MAUSAC = ?, SOLUONG = ?, GIA = ?, MALH = ?, GHICHU = ? WHERE MAHOA = ?";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);   
              ps.setString(1, tenHoa);
              ps.setString(2, quocGia);
              ps.setString(3, mauSac);
              ps.setInt(4, soLuong);
              ps.setDouble(5, gia);
              ps.setString(6, loaiHoa);
              ps.setString(7, ghiChu);
              ps.setString(8, maHoa);
              int rs = ps.executeUpdate();
               return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoaHoa(String maHoa){
        String sql = "DELETE FROM HOA WHERE MAHOA = ?";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);   
              ps.setString(1, maHoa);
              int rs = ps.executeUpdate();
              return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String getTenHoaTheoMaHoa(String maHoa){
        String sql = "SELECT * FROM HOA WHERE MAHOA = ?";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);   
              ps.setString(1, maHoa);
              System.out.println("111: " + sql);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              { 
                return rs.getString("TENHOA");
              }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public String getMaHoaTheoTenHoa(String tenHoa){
        String sql = "SELECT * FROM HOA WHERE TENHOA = ?";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);   
              ps.setString(1, tenHoa);
              System.out.println("111: " + sql);
              ResultSet rs = ps.executeQuery();
              while(rs.next())
              { 
                return rs.getString("MAHOA");
              }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public boolean capNhatSoLuongHoaSauKhiThemGioHang(String maHoa, int soLuong){
        String sql = "UPDATE HOA SET SOLUONG = ? WHERE MAHOA = ?";
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
}
