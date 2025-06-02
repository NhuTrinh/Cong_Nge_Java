/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Controller;

import QLBH_Function.Don_Hang;
import QLBH_Function.Giao_Hang;
import QLBH_Function.Gio_Hang;
import QLBH_Function.Khach_Hang;
import QLBH_Function.Nhan_vien;
import QLBH_Function.San_Pham;
import QLBH_Function.Thanh_Toan;
import QLBH_Model.Dang_Nhap_Model;
import QLBH_Model.Danh_Sach_Hoa_Model;
import QLBH_Model.Don_Hang_Model;
import QLBH_Model.Khach_Hang_Model;
import QLBH_View.Chi_Tiet_Don_Hang_View;
import QLBH_View.Danh_Sach_Hoa_View;
import QLBH_View.Don_Hang_View;
import QLBH_View.Gio_Hang_View;
import QLBH_View.MainFrame;
import QLBH_View.Them_Gio_Hang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.interfaces.DSAKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
    private Danh_Sach_Hoa_View dshView;
    private Them_Gio_Hang tghView;

    public Don_Hang_Controller(MainFrame mainView, Don_Hang_View dhView, Don_Hang_Model dhModel, Chi_Tiet_Don_Hang_View ctdhView, Gio_Hang_View ghView, Danh_Sach_Hoa_View dshView, Them_Gio_Hang tghView) {
        this.mainView = mainView;
        this.dhView = dhView;
        this.dhModel = dhModel;
        this.ctdhView = ctdhView;
        this.ghView = ghView;
        this.dshView = dshView;
        this.tghView = tghView;
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
    
        public void setAllValueInCTDHIsEmpty() {
            ctdhView.setTxtTenKhachHang("");
            ctdhView.setTxtSoDienThoai("");
            ctdhView.setTxtTim("");
            ctdhView.setTxtTenNguoiNhan("");
            ctdhView.setTxtSoDienThoaiNhan("");
            ctdhView.setTxtDiaChiNhan("");
            ctdhView.setTxtTienHoa("");
            ctdhView.setTxtTienVanChuyen("");
            ctdhView.setTxtTienCamHoa("");
            ctdhView.setTxtVAT("");
            ctdhView.setTxtVIP("");
            ctdhView.setTxtTongTien("");
        }
        
        public void themDonHangAction() {
        dhView.btnThemActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setAllValueInCTDHIsEmpty();
                dhView.dispose();
                ctdhView.setVisible(true);
                timKhachHangChiTietDonHangAction();
                loadListNhanVienToChiTietDonHang();
                themHoaVaoGioHangAction();
                
            }
        });
    }
        
        public void thoatChiTietDonHangAction() {
        ctdhView.btnThoatGioHangActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ctdhView.dispose();
                dhView.setVisible(true);
            }
        });
    }
        
    public void timKhachHangChiTietDonHangAction() {
        ctdhView.btnTimGioHangActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String soDienThoai = ctdhView.getTxtSoDienThoai();
                System.out.println("SDT: " + soDienThoai);
                Khach_Hang kh = dhModel.timKhachHangTheoSoDienThoai(soDienThoai);
                ctdhView.setTxtTenKhachHang(kh.getTenKhachHang());
                ctdhView.setTxtSoDienThoai(kh.getSoDienThoai());
                themDonHangTam();
            }
        });
    }

    public void loadListNhanVienToChiTietDonHang() {
        Dang_Nhap_Model dnModel = new Dang_Nhap_Model();
        ArrayList<Nhan_vien> dsnv = dnModel.getAllNhanVienTheoMa();
        for(Nhan_vien nv : dsnv){
            System.out.println(nv);
        }
        ctdhView.loadDanhSachNhanVien(dsnv);
    }
    
    public void themThongTinNguoiNhan() {
        String maDonHang = ctdhView.getTxtMaDonHang();
        String tenNguoiNhan = ctdhView.getTxtTenNguoiNhan();
        String soDienThoaiNhan = ctdhView.getTxtSoDienThoaiNhan();
        String diaChiNhan = ctdhView.getTxtDiaChiNhan();
        dhModel.themThongTinGiaoHangVaoDonHang(maDonHang, tenNguoiNhan, soDienThoaiNhan, diaChiNhan);
    }
    
    public void themThongTinThanhToan() {
        String maDonHang = ctdhView.getTxtMaDonHang();
        
        //dhModel.themThongTinGiaoHangVaoDonHang(maDonHang, tenNguoiNhan, soDienThoaiNhan, diaChiNhan);
    }
    
    public void themHoaVaoGioHangAction() {
        ctdhView.btnThemGioHangActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String maDonHang = ctdhView.getTxtMaDonHang();
                Danh_Sach_Hoa_Model dshModel = new Danh_Sach_Hoa_Model();
                tghView.setTableThemGioHang(dshModel.getAllHoa());
                tghView.setVisible(true);
                themSanPhamAction(maDonHang);
            }
        });
    }
    
    public void themSanPhamAction(String maDonHang) {
        tghView.btnThemVaoGioHangActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int soLuong = Integer.parseInt(tghView.getTxtSoLuong());
                San_Pham sp = tghView.getHoaSelectedRow();
                String maHoa = sp.getMaHoa();
                Double giaBan = sp.getGia();
                dhModel.luuSanPhamVaoGioHang(maDonHang, maHoa, soLuong, giaBan);
            }
        });
    }
    
    public void themDonHangTam() {
        String maDonHang = ctdhView.getTxtMaDonHang();
        String trangThai = ctdhView.getCbxTrangThai();
        String maNhanVien = ctdhView.getCbxNhanVien();
        String tenKhachHang = ctdhView.getTxtTenKhachHang();
        Khach_Hang_Model khModel = new Khach_Hang_Model();
        Khach_Hang kh = khModel.getAllKhachHangTheoTen(tenKhachHang);
        String maKhachHang = kh.getMaKhachHang();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String ngayLap = now.format(formatter);
        dhModel.taoDonHangTam(maDonHang, ngayLap, trangThai, 1.0, maNhanVien, maKhachHang);
    }
    

}
