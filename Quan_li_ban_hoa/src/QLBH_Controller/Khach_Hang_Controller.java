/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Controller;

import QLBH_Function.Khach_Hang;
import QLBH_Model.Khach_Hang_Model;
import QLBH_View.Danh_Sach_Hoa_View;
import QLBH_View.Don_Hang_View;
import QLBH_View.Khach_Hang_Tao_Cap_Nhat;
import QLBH_View.Khach_Hang_View;
import QLBH_View.MainFrame;
import java.awt.AWTEventMulticaster;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.AcceptPendingException;

/**
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
/**
 * Lớp Khach_Hang_Controller chịu trách nhiệm điều phối tương tác giữa View và
 * Model Nhận sự kiện từ View Gọi các phương thức xử lý dữ liệu từ Model Cập
 * nhật kết quả lên View
 */
public class Khach_Hang_Controller {

    public MainFrame mainView;
    public Khach_Hang_View khView;
    public Khach_Hang_Model khModel;
    public Khach_Hang_Tao_Cap_Nhat khTaoCapNhatView;
    public Don_Hang_View dhView;
    public Danh_Sach_Hoa_View dshView;

    /**
     * Hàm khởi tạo
     *
     * @param mainView Trang chủ của ứng dụng
     * @param khView Giao diện chính hiển thị danh sách và xem chi tiết khách
     * hàng
     * @param khModel Xử lý dữ liệu
     * @param khTaoCapNhatView Giao diện tạo và cập nhật thông tin khách hàng
     * @param dhView Giao diện chính đơn hàng hiển thị danh sách đơn hàng
     * @param dshView Giao diện chính danh sách hoa hiển thị danh sách và xem
     * chi tiết hoa
     *
     */
    public Khach_Hang_Controller(MainFrame mainView, Khach_Hang_View khView, Khach_Hang_Model khModel, Khach_Hang_Tao_Cap_Nhat khTaoCapNhatView, Don_Hang_View dhView, Danh_Sach_Hoa_View dshView) {
        this.mainView = mainView;
        this.khView = khView;
        this.khModel = khModel;
        this.khTaoCapNhatView = khTaoCapNhatView;
        this.dhView = dhView;
        this.dshView = dshView;
    }

    /**
     * Thoát khỏi giao diện khách hàng và trở về trang chủ
     */
    public void thoatAction() {
        khView.btnThoatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                khView.dispose();
                mainView.setVisible(true);
            }
        });
    }

    /**
     * Xem chi tiết khách hàng được chọn
     */
    public void xemChiTietKhachHang() {
        khView.btnXemActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                khView.getInformationSelectedRow(); //Chọn khách hàng cần xem
                String maKhachHang = khView.getTxtMaKhachHang();
                Khach_Hang kh = khModel.getAllKhachHangTheoMa(maKhachHang);
                System.out.println(kh.getEmail());
                khView.setTxtXepLoai(kh.getXepLoai());
                khView.setTxtEmail(kh.getEmail());
            }
        });
    }

    /**
     * Thêm khách hàng mới
     */
    public void themKhachHang() {
        khView.btnThemActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!khTaoCapNhatView.checkEditableOfTxtMaKhachHang()) {
                    khTaoCapNhatView.setTxtMaKhachHangEnable();
                }
                khTaoCapNhatView.setVisible(true);
                luuKhachHang();
            }
        });
    }

    /**
     * Cập nhật thông tin khách hàng đã có
     */
    public void capNhatAction() {
        khView.btnCapNhatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Khach_Hang kh = khView.getKhachHangSelectedRow();
                String maKhachHang = kh.getMaKhachHang();
                kh = khModel.getAllKhachHangTheoMa(maKhachHang);
                System.out.println(kh.getEmail());
                khTaoCapNhatView.setTxtMaKhachHang(kh.getMaKhachHang());
                khTaoCapNhatView.setTxtTenKhachHang(kh.getTenKhachHang());
                khTaoCapNhatView.setTxtSoDienThoai(kh.getSoDienThoai());
                khTaoCapNhatView.setTxtXepLoai(kh.getXepLoai());
                khTaoCapNhatView.setTxtEmail(kh.getEmail());
                khTaoCapNhatView.setTxtDiaChi(kh.getDiaChi());
                khTaoCapNhatView.setTxtMaKhachHangDisable();
                khTaoCapNhatView.setVisible(true);
                luuKhachHang();
            }
        });
    }

    /**
     * Xóa khách hàng đã có
     */
    public void xoaAction() {
        khView.btnXoaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Khach_Hang kh = khView.getKhachHangSelectedRow();
                String maKhachHang = kh.getMaKhachHang();
                khModel.xoaKhachHang(maKhachHang);
                khView.setTableKhachHang(khModel.getAllKhachHang());
                setAllValueInKhachHangViewToEmpty();
            }
        });
    }

    /**
     * Lưu khách hàng mới hoặc thông tin cập nhát của khách hàng cũ
     */
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
                if (khTaoCapNhatView.checkEditableOfTxtMaKhachHang()) {
                    khModel.themKhachHang(maKhachHang, tenKhachHang, soDienThoai, xepLoai, email, diaChi);
                } else {
                    khModel.capNhatKhachHang(maKhachHang, tenKhachHang, soDienThoai, xepLoai, email, diaChi);
                }
                khTaoCapNhatView.dispose();
                khTaoCapNhatView.setTxtMaKhachHang("");
                khTaoCapNhatView.setTxtTenKhachHang("");
                khTaoCapNhatView.setTxtSoDienThoai("");
                khTaoCapNhatView.setTxtEmail("");
                khTaoCapNhatView.setTxtXepLoai("");
                khTaoCapNhatView.setTxtDiaChi("");
                khView.setTableKhachHang(khModel.getAllKhachHang());
            }
        });
    }

    /**
     * Hủy hành động thêm hoặc cập nhật khách hàng
     */
    public void huyAction() {
        khTaoCapNhatView.btnHuyActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                khTaoCapNhatView.dispose();
                setAllValueInKhachHangTaoCapNhatViewToEmpty();
                khView.setVisible(true);
            }
        });
    }

    /**
     * Thoát khỏi giao diện thêm và cập nhật khách hàng
     */
    public void ThoatAddUpdateAction() {
        khTaoCapNhatView.btnThoatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                khTaoCapNhatView.dispose();
                setAllValueInKhachHangTaoCapNhatViewToEmpty();
                khView.setVisible(true);
            }
        });
    }

    /**
     * Chuyển từ giao diện khách hàng sang giao diện đơn hàng
     */
    public void donHangAction() {
        khView.btnDonHangActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                khView.setVisible(false);
                dhView.setVisible(true);
            }
        });
    }

    /**
     * Chuyển từ giao diện khách hàng sang giao diện danh sách hoa
     */
    public void danhSachHoaAction() {
        khView.btnDanhSachHoaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                khView.setVisible(false);
                dshView.setVisible(true);
            }
        });
    }

    /**
     * Cập nhật tất cả trường trong giao diện khi xem khách hàng sang rỗng
     */
    public void setAllValueInKhachHangViewToEmpty() {
        khView.setTextMaKhachHang("");
        khView.setTxtTenKhachHang("");
        khView.setTxtSoDienThoai("");
        khView.setTxtXepLoai("");
        khView.setTxtEmail("");
        khView.setTxtDiaChi("");
    }

    /**
     * Cập nhật tất cả trường trong giao diện thêm cập nhật khách hàng sang rỗng
     */
    public void setAllValueInKhachHangTaoCapNhatViewToEmpty() {
        khTaoCapNhatView.setTxtMaKhachHang("");
        khTaoCapNhatView.setTxtTenKhachHang("");
        khTaoCapNhatView.setTxtSoDienThoai("");
        khTaoCapNhatView.setTxtEmail("");
        khTaoCapNhatView.setTxtXepLoai("");
        khTaoCapNhatView.setTxtDiaChi("");
    }
}
