/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package QLBH_Main;

import QLBH_Controller.Dang_Nhap_Controller;
import QLBH_Controller.Khach_Hang_Controller;
import QLBH_Controller.Main_Controller;
import QLBH_Model.Dang_Nhap_Model;
import QLBH_Model.Khach_Hang_Model;
import QLBH_Model.Main_Model;
import QLBH_View.Dang_Nhap_View;
import QLBH_View.Danh_Sach_Hoa_View;
import QLBH_View.Hoa_Don;
import QLBH_View.Khach_Hang_Tao_Cap_Nhat;
import QLBH_View.Khach_Hang_View;
import QLBH_View.MainFrame;
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
        Danh_Sach_Hoa_View dmhView = new Danh_Sach_Hoa_View();
        Main_Controller mainController = new Main_Controller(mainModel, mainFrame, v, khView, khModel, dmhView);       
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
    }
    
}
