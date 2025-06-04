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
import QLBH_View.Hoa_Don;
import QLBH_View.Hoa_Tao_Cap_Nhat;
import QLBH_View.Khach_Hang_Tao_Cap_Nhat;
import QLBH_View.Khach_Hang_View;
import QLBH_View.MainFrame;
import QLBH_View.Them_Gio_Hang;
import java.awt.Frame;
import javax.swing.JFrame;

/**
 *
 * @author TOSHIBA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Dang_Nhap_Model m = new Dang_Nhap_Model();
        MainFrame mainFrame = new MainFrame();
        Main_Model mainModel = new Main_Model();
        Dang_Nhap_View v = new Dang_Nhap_View(mainFrame, true);
        Khach_Hang_View khView = new Khach_Hang_View();
        Khach_Hang_Model khModel = new Khach_Hang_Model();
        Khach_Hang_Tao_Cap_Nhat khTaoCapNhatModel = new Khach_Hang_Tao_Cap_Nhat();
        Khach_Hang_Controller khController = new Khach_Hang_Controller(mainFrame, khView, khModel, khTaoCapNhatModel);
        Dang_Nhap_Controller cl = new Dang_Nhap_Controller(m, v, mainFrame);
        Danh_Sach_Hoa_View dshView = new Danh_Sach_Hoa_View();
        Danh_Sach_Hoa_Model dshModel = new Danh_Sach_Hoa_Model();
        Hoa_Tao_Cap_Nhat chiTietHoaView = new Hoa_Tao_Cap_Nhat();
        Don_Hang_Model dhModel = new Don_Hang_Model();
        Don_Hang_View dhView = new Don_Hang_View();
        Chi_Tiet_Don_Hang_View ctdhView = new Chi_Tiet_Don_Hang_View();
        Gio_Hang_View ghView = new Gio_Hang_View();
        Them_Gio_Hang tghView = new Them_Gio_Hang();
        Don_Hang_Controller dhController = new Don_Hang_Controller(mainFrame, dhView, dhModel, ctdhView, ghView, dshView, tghView);
        Danh_Sach_Hoa_Controller dshController = new Danh_Sach_Hoa_Controller(mainFrame, dshView, dshModel, chiTietHoaView);
        Main_Controller mainController = new Main_Controller(mainModel, mainFrame, v, khView, khModel, dshView, dshModel, dhView, dhModel);       
        cl.loginAction();
        v.setVisible(true);
        mainController.thoatAction();
        mainController.khachHangAction();
        khController.thoatAction();
        khController.xemChiTietKhachHang();
        khController.themKhachHang();
        khController.huyAction();
        khController.ThoatAddUpdateAction();
        khController.capNhatAction();
        khController.xoaAction();
        mainController.danhMucHoaAction();
        dshController.thoatAction();
        dshController.xemChiTietHoa();
        dshController.themHoa();
        dshController.capNhatAction();
        dshController.xoaAction();
        mainController.donHangAction();
        dhController.xoaAction();
        dhController.xemAction();
        dhController.capNhatDonHangAction();
        //dhController.themGioHangAction();
        //dhController.giamGioHangAction();
        //dhController.xoaGioHangAction();
        //dhController.thoatGioHang();
        //dhController.themDonHangAction();
        //dhController.thoatChiTietDonHangAction();
        //dhController.thoatThemGioHang();
    }
    
}
