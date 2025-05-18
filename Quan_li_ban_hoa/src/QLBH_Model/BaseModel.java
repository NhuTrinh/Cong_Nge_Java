/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.text.PasswordView;

/**
 *
 * @author TOSHIBA
 */
public class BaseModel {
    private static String uRL = "jdbc:sqlserver://localhost:1433;databaseName=QLBH;trustServerCertificate=true";
    private static String userName = "sa";
    private static String passWord = "123456789";
    
    public static Connection getConnection() throws SQLException{
        Connection conn = null; 
        try {
            conn = DriverManager.getConnection(uRL, userName, passWord);
            System.out.print("\nKet noi thanh cong");
        } catch (SQLException ex){
            System.out.println("\nKet noi that bai");
            ex.printStackTrace();
        }
        return conn;
    }
}
