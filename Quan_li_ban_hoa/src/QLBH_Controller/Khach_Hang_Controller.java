/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Controller;

import QLBH_Function.Khach_Hang;
import QLBH_Model.Khach_Hang_Model;
import QLBH_View.Khach_Hang_Tao_Cap_Nhat;
import QLBH_View.Khach_Hang_View;
import QLBH_View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author TOSHIBA
 */
public class Khach_Hang_Controller {
    public MainFrame mainView;
    public Khach_Hang_View khView;
    public Khach_Hang_Model khModel;
    public Khach_Hang_Tao_Cap_Nhat khTaoCapNhatView;

    public Khach_Hang_Controller(MainFrame mainView, Khach_Hang_View khView, Khach_Hang_Model khModel, Khach_Hang_Tao_Cap_Nhat khTaoCapNhatView) {
        this.mainView = mainView;
        this.khView = khView;
        this.khModel = khModel;
        this.khTaoCapNhatView = khTaoCapNhatView;
    }
    
    public void thoatAction() {
        khView.btnThoatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                khView.dispose();
                mainView.setVisible(true);
            }
        });
    }
    
    public void xemChiTietKhachHang() {
        khView.btnXemActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                khView.getInformationSelectedRow();
                String maKhachHang = khView.getTxtMaKhachHang();
                Khach_Hang kh = khModel.getAllKhachHangTheoMa(maKhachHang);
                System.out.println(kh.getEmail());
                khView.setTxtXepLoai(kh.getXepLoai());
                khView.setTxtEmail(kh.getEmail());
            }
        });
    }
    
    public void themKhachHang() {
        khView.btnThemActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                khTaoCapNhatView.setVisible(true);
                luuKhachHang();
            }
        });
    }
    
    public void luuKhachHang() {
        khTaoCapNhatView.btnLuuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maKhachHang = khTaoCapNhatView.getTxtMaKhachHang();
                String tenKhachHang = khTaoCapNhatView.getTxtTenKhachHang();
                String soDienThoai = khTaoCapNhatView.getTxtSoDienThoai();
                String xepLoai = khTaoCapNhatView.getTxtXepLoai();
                String email = khTaoCapNhatView.getTxtEmail();
                String diaChi = khTaoCapNhatView.getTxtDiaChi();
                khModel.themKhachHang(maKhachHang, tenKhachHang, soDienThoai, xepLoai, email, diaChi);
                khTaoCapNhatView.dispose();
                khView.setTableKhachHang(khModel.getAllKhachHang());
            }
        });
    }
}
