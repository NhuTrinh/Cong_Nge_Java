/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Controller;

import QLBH_Function.Khach_Hang;
import QLBH_Function.Loai_Hoa;
import QLBH_Function.San_Pham;
import QLBH_Model.Danh_Sach_Hoa_Model;
import QLBH_View.Danh_Sach_Hoa_View;
import QLBH_View.Hoa_Tao_Cap_Nhat;
import QLBH_View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.invoke.MethodHandles;

/**
 *
 * @author TOSHIBA
 */
public class Danh_Sach_Hoa_Controller {
    public MainFrame mainView;
    public Danh_Sach_Hoa_View dshView;
    public Danh_Sach_Hoa_Model dshModel;
    public Hoa_Tao_Cap_Nhat hoaTaoCapNhatView;

    public Danh_Sach_Hoa_Controller(MainFrame mainView, Danh_Sach_Hoa_View dshView, Danh_Sach_Hoa_Model dshModel, Hoa_Tao_Cap_Nhat hoaTaoCapNhatView) {
        this.mainView = mainView;
        this.dshView = dshView;
        this.dshModel = dshModel;
        this.hoaTaoCapNhatView = hoaTaoCapNhatView;
    }
    
    public void thoatAction() {
        dshView.btnThoatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dshView.dispose();
                mainView.setVisible(true);
            }
        });
    }
    
    public void xemChiTietHoa() {
        dshView.btnXemActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                San_Pham sp = dshView.getHoaSelectedRow();
                String maHoa = sp.getMaHoa();
                San_Pham sanPhamInfor = dshModel.getAllHoaTheoMa(maHoa);
                dshView.setLblMaHoa(maHoa);
                dshView.setLblTenHoa(sp.getTenHoa());
                dshView.setLblQuocGia(sanPhamInfor.getQuocGia());
                dshView.setLblMauSac(sanPhamInfor.getMauSac());
                dshView.setLblGia(String.valueOf(sp.getGia()));
                dshView.setLblSoLuong(String.valueOf(sp.getSoLuong()));
                String loaiHoa = dshModel.getLoaiHoaTuMaLoaiHoa(sanPhamInfor.getMaLoaiHoa());
                dshView.setLblLoaiHoa(loaiHoa);
                dshView.setLblGhiChu(sanPhamInfor.getGhiChu());
            }
        });
    }
    
    public void themHoa() {
        dshView.btnThemActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!hoaTaoCapNhatView.checkEditableOfTxtMa())
                {
                    hoaTaoCapNhatView.setTxtMaHoaEnable();
                }
                hoaTaoCapNhatView.setVisible(true);
                luuHoa();
            }
        });
    }
    
    public void luuHoa() {
        hoaTaoCapNhatView.btnLuuActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maHoa = hoaTaoCapNhatView.getTxtMaHoa();
                String tenHoa = hoaTaoCapNhatView.getTxtTenHoa();
                String quocGia = hoaTaoCapNhatView.getTxtQuocGia();
                String mauSac = hoaTaoCapNhatView.getTxtMauSac();
                int soLuong = Integer.parseInt(hoaTaoCapNhatView.getTxtSoLuong());
                double gia = Double.parseDouble(hoaTaoCapNhatView.getTxtGia());
                String loaiHoa = hoaTaoCapNhatView.getCbxLoaiHoa();
                Loai_Hoa lh = Loai_Hoa.timLoaiHoaTheoTen(loaiHoa);
                loaiHoa = lh.getMa();
                String ghiChu = hoaTaoCapNhatView.getTxtGhiChu();
                
                if(hoaTaoCapNhatView.checkEditableOfTxtMa())
                {
                    dshModel.themHoa(maHoa, tenHoa, quocGia, mauSac, soLuong, gia, loaiHoa, ghiChu);
                } else {
                    dshModel.capNhatHoa(maHoa, tenHoa, quocGia, mauSac, soLuong, gia, loaiHoa, ghiChu);
                }
                hoaTaoCapNhatView.dispose();
                setValueIsEmpty();
                dshView.setTableSanPham(dshModel.getAllHoa());
            }
        });  
    }
    
    public void capNhatAction() {
        dshView.btnCapNhatActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                San_Pham sp = dshView.getHoaSelectedRow();
                String maHoa = sp.getMaHoa();
                sp = dshModel.getAllHoaTheoMa(maHoa);
                hoaTaoCapNhatView.setTxtMaHoa(maHoa);
                hoaTaoCapNhatView.setTxtTenHoa(sp.getTenHoa());
                hoaTaoCapNhatView.setTxtQuocGia(sp.getQuocGia());
                hoaTaoCapNhatView.setTxtMauSac(sp.getMauSac());
                System.out.println("So luong: " + String.valueOf(sp.getSoLuong()));
                hoaTaoCapNhatView.setTxtSoLuong(String.valueOf(sp.getSoLuong()));
                hoaTaoCapNhatView.setTxtGia(String.valueOf(sp.getGia()));
                hoaTaoCapNhatView.setCbxLoaiHoa(Loai_Hoa.timLoaiHoaTheoMa(sp.getMaLoaiHoa()).getTen());
                hoaTaoCapNhatView.setTxtGhiChu(sp.getGhiChu());
                hoaTaoCapNhatView.setTxtMaHoaDisable();
                hoaTaoCapNhatView.setVisible(true);
                luuHoa();
            }
        });
    }
    
    public void xoaAction() {
        dshView.btnXoaActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                San_Pham sp = dshView.getHoaSelectedRow();
                String maHoa = sp.getMaHoa();
                dshModel.xoaHoa(maHoa);
                dshView.setTableSanPham(dshModel.getAllHoa());
                setAllValueInDSHoaIsEmpty();
            }
        });
    }
    
    public void setValueIsEmpty() {
        hoaTaoCapNhatView.setTxtMaHoa("");
        hoaTaoCapNhatView.setTxtTenHoa("");
        hoaTaoCapNhatView.setTxtQuocGia("");
        hoaTaoCapNhatView.setTxtMauSac("");
        hoaTaoCapNhatView.setTxtSoLuong("");
        hoaTaoCapNhatView.setTxtGia("");
        hoaTaoCapNhatView.setCbxLoaiHoa("Select");
        hoaTaoCapNhatView.setTxtGhiChu("");
    }
    
    public void setAllValueInDSHoaIsEmpty() {
        dshView.setLblMaHoa("");
        dshView.setLblTenHoa("");
        dshView.setLblQuocGia("");
        dshView.setLblSoLuong("");
        dshView.setLblMauSac("");
        dshView.setLblGia("");
        dshView.setLblLoaiHoa("");
        dshView.setLblGhiChu("");
    }
    
}
