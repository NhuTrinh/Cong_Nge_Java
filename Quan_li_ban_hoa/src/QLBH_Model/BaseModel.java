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
 * Lớp BaseModel chịu trách nhiệm tạo kết nối đến cơ sở dữ liệu SQL Server. Đây
 * là lớp cha dùng chung cho các lớp model khác trong hệ thống quản lý bán hoa.
 *
 * CSDL: QLBH (trên SQL Server, localhost, cổng 1433) Người dùng: sa Mật khẩu:
 * 123456789
 *
 * Chú ý: Đảm bảo SQL Server đã bật TCP/IP và đang hoạt động.
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
public class BaseModel {

    /**
     * URL kết nối đến cơ sở dữ liệu SQL Server.
     */
    private static String uRL = "jdbc:sqlserver://localhost:1433;databaseName=QLBH;trustServerCertificate=true";

    /**
     * Tên người dùng (username) đăng nhập vào cơ sở dữ liệu.
     */
    private static String userName = "sa";

    /**
     * Mật khẩu (password) của người dùng cơ sở dữ liệu.
     */
    private static String passWord = "123456789";

    /**
     * Phương thức khởi tạo và trả về đối tượng Connection để kết nối với CSDL.
     *
     * @return Đối tượng Connection đã kết nối thành công hoặc null nếu thất
     * bại.
     * @throws SQLException nếu có lỗi xảy ra trong quá trình kết nối.
     */
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(uRL, userName, passWord);
            System.out.print("\nKet noi thanh cong");
        } catch (SQLException ex) {
            System.out.println("\nKet noi that bai");
            ex.printStackTrace();
        }
        return conn;
    }
}
