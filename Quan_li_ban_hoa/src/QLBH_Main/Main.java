/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QLBH_Main;

import QLBH_Controller.Dang_Nhap_Controller;
import QLBH_Controller.Danh_Sach_Hoa_Controller;
import QLBH_Controller.Don_Hang_Controller;
import QLBH_Controller.Khach_Hang_Controller;
import QLBH_Controller.Main_Controller;
import QLBH_Model.Dang_Nhap_Model;
import QLBH_Model.Danh_Sach_Hoa_Model;
import QLBH_Model.Don_Hang_Model;
import QLBH_Model.Khach_Hang_Model;
import QLBH_Model.Main_Model;
import QLBH_View.Chi_Tiet_Don_Hang_View;
import QLBH_View.Dang_Nhap_View;
import QLBH_View.Danh_Sach_Hoa_View;
import QLBH_View.Don_Hang_View;
import QLBH_View.Gio_Hang_View;
import QLBH_View.Hoa_Tao_Cap_Nhat;
import QLBH_View.Khach_Hang_Tao_Cap_Nhat;
import QLBH_View.Khach_Hang_View;
import QLBH_View.MainFrame;
import QLBH_View.Them_Gio_Hang;
import QLBH_View.Thong_Bao_Loi;
import QLBH_View.Thong_bao_xoa;
import java.awt.Frame;
import javax.swing.JFrame;

/**
 * Main class khởi tạo và kết nối các thành phần MVC cho ứng dụng quản lý bán hoa.
 * 
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    /**
     * Phương thức main - điểm bắt đầu của chương trình.
     * Khởi tạo model, view, controller và đăng ký các hành động.
     */
    public static void main(String[] args) {
        // Khởi tạo View
        MainFrame mainFrame = new MainFrame(); //Trang chủ
        Dang_Nhap_View v = new Dang_Nhap_View(mainFrame, true); //Đăng nhập
        Khach_Hang_View khView = new Khach_Hang_View(); //Khách Hàng
        Khach_Hang_Tao_Cap_Nhat khTaoCapNhatView = new Khach_Hang_Tao_Cap_Nhat(); //Cập nhật khách hàng
        Don_Hang_View dhView = new Don_Hang_View(); //Đơn Hàng
        Chi_Tiet_Don_Hang_View ctdhView = new Chi_Tiet_Don_Hang_View(); //Chi tiết đơn hàng
        Gio_Hang_View ghView = new Gio_Hang_View(); //Giỏ hàng
        Them_Gio_Hang tghView = new Them_Gio_Hang(); //Thêm giỏ hàng
        Danh_Sach_Hoa_View dshView = new Danh_Sach_Hoa_View(); //Danh sách hoa
        Hoa_Tao_Cap_Nhat chiTietHoaView = new Hoa_Tao_Cap_Nhat(); //Tạo cập nhật hoa
        Thong_Bao_Loi tbView = new Thong_Bao_Loi(); //Thông báo 
        Thong_bao_xoa tbXoaView = new Thong_bao_xoa(); // Cảnh báo xóa
        
        // Khởi tạo Model
        Dang_Nhap_Model m = new Dang_Nhap_Model(); //Đăng nhập
        Main_Model mainModel = new Main_Model(); ////Trang chủ
        Khach_Hang_Model khModel = new Khach_Hang_Model(); ////Khách Hàng
        Danh_Sach_Hoa_Model dshModel = new Danh_Sach_Hoa_Model(); //Danh sách hoa
        Don_Hang_Model dhModel = new Don_Hang_Model(); //Đơn hàng
        
        // Khởi tạo Controller
        Khach_Hang_Controller khController = new Khach_Hang_Controller(mainFrame, khView, khModel, khTaoCapNhatView, dhView, dshView, tbView,tbXoaView); //Khách hàng
        Dang_Nhap_Controller cl = new Dang_Nhap_Controller(m, v, mainFrame); //Đăng nhập
        Don_Hang_Controller dhController = new Don_Hang_Controller(mainFrame, dhView, dhModel, ctdhView, ghView, dshView, tghView, tbView, tbXoaView); //Đơn hàng
        Danh_Sach_Hoa_Controller dshController = new Danh_Sach_Hoa_Controller(mainFrame, dshView, dshModel, chiTietHoaView, dhView, khView, tbView, tbXoaView); //Danh sách hoa
        Main_Controller mainController = new Main_Controller(mainModel, mainFrame, v, khView, khModel, dshView, dshModel, dhView, dhModel); //Trang chủ      
        
        //Log in vào hệ thống
        cl.loginAction();
        
        //Hiển thị màn hình đăng nhập
        v.setVisible(true);
        
        //Thoát khỏi trang chủ
        mainController.thoatAction();
        
        //Đi tới Khách Hàng
        mainController.khachHangAction();
        
        //Đi tới Danh Mục Hoa
        mainController.danhMucHoaAction();
        
        //Đi tới đơn hàng
        mainController.donHangAction();
        
        //Thoát khỏi khách hàng
        khController.thoatAction();
        
        //Xem chi tiết khách hàng
        khController.xemChiTietKhachHang();
        
        //Thêm khách hàng mới
        khController.themKhachHang();
        
        //Cập nhật khách hàng đã có
        khController.capNhatAction();
        
        //Xóa khách hàng
        khController.xoaAction();
        
        //Đi đến đơn hàng từ khách hàng
        khController.donHangAction();
        
        //Đi đến danh mục hoa từ khách hàng
        khController.danhSachHoaAction();
        
        
        //Thoát khỏi danh mục hoa
        dshController.thoatAction();
        
        //Xem chi tiết hoa
        dshController.xemChiTietHoa();
        
        //Thêm hoa mới
        dshController.themHoa();
        
        //Cập nhật hoa đã có
        dshController.capNhatAction();
        
        //Xóa hoa
        dshController.xoaAction();
        
        //Đi đến khách hàng
        dshController.khachHangAction();
        
        //Đi đến đơn hàng
        dshController.donHangAction();
        
        
        //Thoát khỏi đơn hàng
        dhController.thoatDonHang();
        
        //Xem chi tiết đơn hàng
        dhController.xemAction();
        
        //Thêm đơn hàng mới
        dhController.themDonHangAction();
        
        //Cập nhật khách hàng
        dhController.capNhatDonHangAction();
        
        //Xóa đơn hàng
        dhController.xoaAction();
    }
    
}
