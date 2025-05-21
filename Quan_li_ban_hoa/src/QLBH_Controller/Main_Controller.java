/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Controller;

import QLBH_Model.BaseModel;
import QLBH_Model.Khach_Hang_Model;
import QLBH_Model.Main_Model;
import QLBH_View.Dang_Nhap_View;
import QLBH_View.Danh_Sach_Hoa_View;
import QLBH_View.Khach_Hang_View;
import QLBH_View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.plaf.basic.BasicViewportUI;

/**
 *
 * @author TOSHIBA
 */
public class Main_Controller {
    public Main_Model mainModel;
    public MainFrame mainView;
    public Dang_Nhap_View dnView;
    public Khach_Hang_View khView;
    public Khach_Hang_Model khModel;
    public Danh_Sach_Hoa_View dshView;

    public Main_Controller(Main_Model mainModel, MainFrame mainView, Dang_Nhap_View dnView, Khach_Hang_View khView, Khach_Hang_Model khModel, Danh_Sach_Hoa_View dshView) {
        this.mainModel = mainModel;
        this.mainView = mainView;
        this.dnView = dnView;
        this.khView = khView;
        this.khModel = khModel;
        this.dshView = dshView;
    }
    
    public void thoatAction() {
        mainView.btnThoatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.dispose();
                dnView.setTxtMatKhau("");
                dnView.setTxtTenDangNhap("");
                dnView.setVisible(true);
            }
        });
    }
   
    public void khachHangAction() {
        mainView.btnKhachHangActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               mainView.dispose();
               khView.setTableKhachHang(khModel.getAllKhachHang());
               khView.setVisible(true);
            }
        });
    }
    
    public void danhMucHoaAction() {
        mainView.btnDanhMucHoaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               mainView.dispose();
               khView.setTableKhachHang(khModel.getAllKhachHang());
               dshView.setVisible(true);
            }
        });
    }
}
