/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Controller;

import QLBH_Function.Don_Hang;
import QLBH_Model.BaseModel;
import QLBH_Model.Danh_Sach_Hoa_Model;
import QLBH_Model.Don_Hang_Model;
import QLBH_Model.Khach_Hang_Model;
import QLBH_Model.Main_Model;
import QLBH_View.Dang_Nhap_View;
import QLBH_View.Danh_Sach_Hoa_View;
import QLBH_View.Don_Hang_View;
import QLBH_View.Khach_Hang_View;
import QLBH_View.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller chính điều phối các thao tác từ MainFrame. Đóng vai trò là trung
 * tâm điều hướng giữa các màn hình: Đăng nhập, Khách hàng, Đơn hàng, Danh mục
 * hoa.
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
public class Main_Controller {

    public Main_Model mainModel;
    public MainFrame mainView;
    public Dang_Nhap_View dnView;
    public Khach_Hang_View khView;
    public Khach_Hang_Model khModel;
    public Danh_Sach_Hoa_View dshView;
    public Danh_Sach_Hoa_Model dshModel;
    public Don_Hang_View dhView;
    public Don_Hang_Model dhModel;

    /**
     * Constructor nhận vào tất cả các View và Model cần dùng để kết nối điều
     * hướng
     */
    public Main_Controller(Main_Model mainModel, MainFrame mainView, Dang_Nhap_View dnView, Khach_Hang_View khView, Khach_Hang_Model khModel, Danh_Sach_Hoa_View dshView, Danh_Sach_Hoa_Model dshModel, Don_Hang_View dhView, Don_Hang_Model dhModel) {
        this.mainModel = mainModel;
        this.mainView = mainView;
        this.dnView = dnView;
        this.khView = khView;
        this.khModel = khModel;
        this.dshView = dshView;
        this.dshModel = dshModel;
        this.dhView = dhView;
        this.dhModel = dhModel;
    }

    /**
     * Thiết lập chức năng cho nút "Thoát" Khi nhấn thoát, MainFrame sẽ đóng và
     * quay lại giao diện đăng nhập
     */
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

    /**
     * Thiết lập chức năng cho nút "Khách hàng" Khi nhấn sẽ chuyển sang giao
     * diện danh sách khách hàng
     */
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

    /**
     * Thiết lập chức năng cho nút "Đơn hàng" Khi nhấn sẽ chuyển sang giao diện
     * danh sách đơn hàng
     */
    public void donHangAction() {
        mainView.btnDonHangActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.dispose();
                dhView.setTableDonHang(dhModel.getAllDonHang());
                dhView.setVisible(true);
            }
        });
    }

    /**
     * Thiết lập chức năng cho nút "Danh mục hoa" Khi nhấn sẽ chuyển sang giao
     * diện danh sách các loại hoa
     */
    public void danhMucHoaAction() {
        mainView.btnDanhMucHoaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainView.dispose();
                dshView.setTableSanPham(dshModel.getAllHoa());
                dshView.setVisible(true);
            }
        });
    }
}
