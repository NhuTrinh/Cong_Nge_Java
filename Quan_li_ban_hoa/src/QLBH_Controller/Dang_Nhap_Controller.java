/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Controller;

import QLBH_Function.Nhan_vien;
import QLBH_View.Khach_Hang_View;
import QLBH_View.Dang_Nhap_View;
import QLBH_Model.Dang_Nhap_Model;
import QLBH_Model.Main_Model;
import QLBH_View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSet;


/**
 *
 * @author TOSHIBA
 */
public class Dang_Nhap_Controller {
    public Dang_Nhap_Model dangNhapModel;
    public Dang_Nhap_View dangNhapView;
    public MainFrame mainFrameView;

    public Dang_Nhap_Controller(Dang_Nhap_Model m, Dang_Nhap_View dn, MainFrame mainFrame) {
        this.dangNhapView = dn;
        this.dangNhapModel = m;
        this.mainFrameView = mainFrame;
    }

    
    public void loginAction()
    {
        dangNhapView.btnDangNhapActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = dangNhapView.getTxtTenDangNhap();
                System.out.println(userName);
                String passWord = dangNhapView.getTxtMatKhau();
                System.out.println(passWord);
                String maNhanVienString = dangNhapModel.login(userName, passWord);
                if(maNhanVienString != null)
                {
                    dangNhapView.setLblThongBaoLoi("");
                    dangNhapView.setVisible(false);
                    dangNhapView.dispose();
                    Main_Model mainModel = new Main_Model();
                    Nhan_vien nv = mainModel.getNhanVienTheoMa(maNhanVienString);
                    mainFrameView.setTxtMaSo(nv.getMaNhanVien());
                    mainFrameView.setTxtHoTen(nv.getTenNhanVien());
                    mainFrameView.setTxtSoDienThoai(nv.getSoDienThoai());
                    mainFrameView.setTxtBoPhan(mainModel.getTenBoPhanTheoMa(nv.getMaBoPhan()));
                    mainFrameView.setVisible(true);
                } else {
                    dangNhapView.setLblThongBaoLoi("Tên đăng nhập hoặc mật khẩu không chính xác!!");
                }
            }  
        });
    }
    
    
    
}
