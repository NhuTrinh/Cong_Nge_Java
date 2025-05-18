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
 * @author TOSHIBA
 */
public class Main_Model extends BaseModel{
    
    public Nhan_vien getNhanVienTheoMa(String maNhanVienString) {
        Nhan_vien nv;
        String sql = "select * from NHANVIEN where MANHANVIEN = ?";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);   
              ps.setString(1, maNhanVienString);
              ResultSet rs = ps.executeQuery();
              if(rs.next())
              {
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
   
    public String getTenBoPhanTheoMa(String maBoPhanString)
    {
        String sql = "select * from BOPHAN where MABOPHAN = ?";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);   
              ps.setString(1, maBoPhanString);
              ResultSet rs = ps.executeQuery();
              if(rs.next())
              {
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
