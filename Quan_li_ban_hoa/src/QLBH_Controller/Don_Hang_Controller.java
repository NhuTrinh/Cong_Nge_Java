/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Controller;

import QLBH_Function.Don_Hang;
import QLBH_Function.Giao_Hang;
import QLBH_Function.Khach_Hang;
import QLBH_Function.San_Pham;
import QLBH_Function.Thanh_Toan;
import QLBH_Model.Don_Hang_Model;
import QLBH_Model.Khach_Hang_Model;
import QLBH_View.Chi_Tiet_Don_Hang_View;
import QLBH_View.Don_Hang_View;
import QLBH_View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.crypto.spec.DESKeySpec;

/**
 *
 * @author TOSHIBA
 */
public class Don_Hang_Controller {
    private MainFrame mainView;
    private Don_Hang_View dhView;
    private Don_Hang_Model dhModel;
    private Chi_Tiet_Don_Hang_View ctdhView;

    public Don_Hang_Controller(MainFrame mainView, Don_Hang_View dhView, Don_Hang_Model dhModel, Chi_Tiet_Don_Hang_View ctdhView) {
        this.mainView = mainView;
        this.dhView = dhView;
        this.dhModel = dhModel;
        this.ctdhView = ctdhView;
    }        
    
    public void xoaAction() {
        dhView.btnXoaActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Don_Hang dh = dhView.getDonHangSelectedRow();
                String maDonHang = dh.getMaDonHang();
                dhModel.xoaCTDonHang(maDonHang);
                dhModel.xoaDonHang(maDonHang);
                dhView.setTableDonHang(dhModel.getAllDonHang());
            }
        });
    }
    
    public void xemAction() {
        dhView.btnXemActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Don_Hang dh = dhView.getDonHangSelectedRow();
                String tenKhachHang = dh.getMaKhachHang();
                Khach_Hang_Model khModel = new Khach_Hang_Model();
                Khach_Hang kh = khModel.getAllKhachHangTheoTen(tenKhachHang);
                ctdhView.disableFieldsKhachHang();
                ctdhView.setTxtTenKhachHang(dh.getMaKhachHang());
                ctdhView.setTxtSoDienThoai(kh.getSoDienThoai());
                Giao_Hang gh = dhModel.getAllGiaoHangTheoMaDon(dh.getMaDonHang());
                ctdhView.setTxtTenNguoiNhan(gh.getTenNguoiNhan());
                ctdhView.setTxtSoDienThoaiNhan(gh.getSoDienThoai());
                ctdhView.setTxtDiaChiNhan(gh.getDiaChi());
                Thanh_Toan cttt = dhModel.getAllThanhToanTheoMaDon(dh.getMaDonHang());
                ctdhView.setTxtTienHoa(String.valueOf(cttt.getTienHang()));
                ctdhView.setTxtTienVanChuyen(String.valueOf(cttt.getPhiVanChuyen()));
                ctdhView.setTxtTienCamHoa(String.valueOf(cttt.getPhiCamHoa()));
                ctdhView.setTxtVAT(String.valueOf(cttt.getVAT()));
                ctdhView.setTxtVIP(String.valueOf(cttt.getVIP()));
                ctdhView.setTxtTongTien(String.valueOf(cttt.getTongTien()));
                ctdhView.setVisible(true);
                dhView.setVisible(false);
            }
        });
    }
    
    
}
