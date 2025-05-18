/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author TOSHIBA
 */
public class Dang_Nhap_Model extends BaseModel{
    
    public String login(String userName, String passWord)
    {
        String sql = "select MANHANVIEN from DANGNHAP where USERNAME = ? and PASSWORD = ?";
        try {
              Connection conn = getConnection();
              PreparedStatement ps = conn.prepareStatement(sql);   
              ps.setString(1, userName);
              ps.setString(2, passWord);
              ResultSet rs = ps.executeQuery();
              if(rs.next())
              {
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
}
