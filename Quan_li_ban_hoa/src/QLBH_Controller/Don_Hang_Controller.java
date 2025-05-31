/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Controller;

import QLBH_Function.Don_Hang;
import QLBH_Function.Giao_Hang;
import QLBH_Function.Gio_Hang;
import QLBH_Function.Khach_Hang;
import QLBH_Function.San_Pham;
import QLBH_Function.Thanh_Toan;
import QLBH_Model.Don_Hang_Model;
import QLBH_Model.Khach_Hang_Model;
import QLBH_View.Chi_Tiet_Don_Hang_View;
import QLBH_View.Don_Hang_View;
import QLBH_View.Gio_Hang_View;
import QLBH_View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author TOSHIBA
 */
public class Don_Hang_Controller {
    private MainFrame mainView;
    private Don_Hang_View dhView;
    private Don_Hang_Model dhModel;
    private Chi_Tiet_Don_Hang_View ctdhView;
    private Gio_Hang_View ghView;

    public Don_Hang_Controller(MainFrame mainView, Don_Hang_View dhView, Don_Hang_Model dhModel, Chi_Tiet_Don_Hang_View ctdhView, Gio_Hang_View ghView) {
        this.mainView = mainView;
        this.dhView = dhView;
        this.dhModel = dhModel;
        this.ctdhView = ctdhView;
        this.ghView = ghView;
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
                xemGioHangAction(dh.getMaDonHang());
            }
        });
    }
    
    public void xemGioHangAction(String maDonHang) {
        ctdhView.btnXemGioHangActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ghView.setTableGioHang(dhModel.getAllGioHangTheoMaDon(maDonHang));
                ghView.setVisible(true);
                ctdhView.setVisible(false);
            }
            
        });
    }
    
    public void ThemGioHangAction() {
        ghView.btnThemActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Gio_Hang gh = ghView.getGioHangSelectedRow();
                String maDon = gh.getMaDonHang();
                String maHoa = gh.getMaHoa();
                int soLuongHoa = gh.getSoLuong();
                System.out.println("maDon" + maDon);
                System.out.println("maHoa" + maHoa);
                System.out.println("soLuongHoa" + soLuongHoa);
                dhModel.updateSoLuongHoa(maHoa, soLuongHoa + 1);
                ghView.setTableGioHang(dhModel.getAllGioHangTheoMaDon(maDon));
            }
        });
    }
    
    public void ThoatGioHang() {
        ghView.btnThoatActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ghView.dispose();
                ctdhView.setVisible(true);
            }
        });
    }
    
    public void xoaGioHangAction() {
        ghView.btnXoaActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Gio_Hang gh = ghView.getGioHangSelectedRow();
                String maDon = gh.getMaDonHang();
                String maHoa = gh.getMaHoa();
                dhModel.deleteHoaTrongGioHang(maHoa);
                ghView.setTableGioHang(dhModel.getAllGioHangTheoMaDon(maDon));
            }
        });
    }
    
    public void giamGioHangAction() {
        ghView.btnGiamActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Gio_Hang gh = ghView.getGioHangSelectedRow();
                String maDon = gh.getMaDonHang();
                String maHoa = gh.getMaHoa();
                int soLuongHoa = gh.getSoLuong();
                System.out.println("maDon" + maDon);
                System.out.println("maHoa" + maHoa);
                System.out.println("soLuongHoa" + soLuongHoa);
                dhModel.updateSoLuongHoa(maHoa, soLuongHoa - 1);
                ghView.setTableGioHang(dhModel.getAllGioHangTheoMaDon(maDon));
            }
        });
    }


}
