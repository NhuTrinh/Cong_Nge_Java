/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_MVC;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author TOSHIBA
 */
public class Model {
    public static Connection getConnection() throws ClassNotFoundException{
        Connection conn = null; 
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=QLBH;trustServerCertificate=true", "sa", "123456789");
            System.out.print("Kết nối thành công!!!!");
        } catch (SQLException ex){
            System.out.println("Kết nối thất bại");
            ex.printStackTrace();
        }
        return conn;
    }
}
