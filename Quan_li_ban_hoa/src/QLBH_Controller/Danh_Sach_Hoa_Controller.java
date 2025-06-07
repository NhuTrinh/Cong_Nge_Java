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
import QLBH_View.Don_Hang_View;
import QLBH_View.Hoa_Tao_Cap_Nhat;
import QLBH_View.Khach_Hang_View;
import QLBH_View.MainFrame;
import QLBH_View.Thong_Bao_Loi;
import QLBH_View.Thong_Bao_Loi_Danh_Muc_Hoa;
import QLBH_View.Thong_bao_xoa;
import QLBH_View.Thong_bao_xoa_Danh_Muc_Hoa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.invoke.MethodHandles;

/**
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
/**
 * Lớp Danh_Sach_Hoa_Controller xử lý các sự kiện cho giao diện danh sách hoa.
 * Bao gồm các chức năng: xem chi tiết, thêm mới, cập nhật, xóa hoa và chuyển
 * đổi giao diện. Kết nối giữa model (Danh_Sach_Hoa_Model) và view
 * (Danh_Sach_Hoa_View, Hoa_Tao_Cap_Nhat, Don_Hang_View, Khach_Hang_View).
 */
public class Danh_Sach_Hoa_Controller {

    public MainFrame mainView; // JFrame chính của ứng dụng
    public Danh_Sach_Hoa_View dshView; // Giao diện danh sách hoa
    public Danh_Sach_Hoa_Model dshModel; // Model quản lý dữ liệu hoa
    public Hoa_Tao_Cap_Nhat hoaTaoCapNhatView; // Giao diện tạo hoặc cập nhật hoa
    public Don_Hang_View dhView;  // Giao diện đơn hàng
    public Khach_Hang_View khView; // Giao diện khách hàng
    public Thong_Bao_Loi_Danh_Muc_Hoa tbView; // Cảnh báo
    public Thong_bao_xoa_Danh_Muc_Hoa tbXoaView; //Cảnh báo xóa

    /**
     * Hàm khởi tạo
    /**
     * Khởi tạo một đối tượng Danh_Sach_Hoa_Controller. Constructor này liên kết
     * các thành phần View và Model cần thiết để quản lý giao diện danh sách
     * hoa.
     *
     * @param mainView Giao diện chính của chương trình (MainFrame).
     * @param dshView Giao diện hiển thị danh sách hoa.
     * @param dshModel Model quản lý dữ liệu liên quan đến danh sách hoa.
     * @param hoaTaoCapNhatView Giao diện tạo hoặc cập nhật thông tin hoa.
     * @param dhView Giao diện xử lý đơn hàng.
     * @param khView Giao diện xử lý thông tin khách hàng.
     * @param tbView Giao diện cảnh báo.
     * @param tbXoaView Giao diện cảnh báo xóa.
     * 
     */
    public Danh_Sach_Hoa_Controller(MainFrame mainView, Danh_Sach_Hoa_View dshView, Danh_Sach_Hoa_Model dshModel, Hoa_Tao_Cap_Nhat hoaTaoCapNhatView, Don_Hang_View dhView, Khach_Hang_View khView,Thong_Bao_Loi_Danh_Muc_Hoa tbView, Thong_bao_xoa_Danh_Muc_Hoa tbXoaView) {
        this.mainView = mainView;
        this.dshView = dshView;
        this.dshModel = dshModel;
        this.hoaTaoCapNhatView = hoaTaoCapNhatView;
        this.dhView = dhView;
        this.khView = khView;
        this.tbView = tbView;
        this.tbXoaView = tbXoaView;
    }

    /**
     * Xử lý sự kiện khi nhấn nút Thoát: Đóng view danh sách hoa và quay lại màn
     * hình chính.
     */
    public void thoatAction() {
        dshView.btnThoatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dshView.dispose();
                mainView.setVisible(true);
            }
        });
    }

    /**
     * Hiển thị chi tiết một sản phẩm hoa được chọn từ bảng.
     */
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

    /**
     * Mở giao diện thêm hoa mới và gọi hàm xử lý lưu hoa.
     */
    public void themHoa() {
        dshView.btnThemActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!hoaTaoCapNhatView.checkEditableOfTxtMa()) {
                    hoaTaoCapNhatView.setTxtMaHoaEnable();
                }
                hoaTaoCapNhatView.setVisible(true);
                luuHoa();
                huyAction();
                thoatAddUpdateAction(); 
            }
        });
    }

    /**
     * Lưu thông tin hoa mới hoặc cập nhật hoa cũ từ form Hoa_Tao_Cap_Nhat.
     */
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

                if (hoaTaoCapNhatView.checkEditableOfTxtMa()) {
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

    /**
     * Mở giao diện cập nhật thông tin của một hoa đã chọn.
     */
    public void capNhatAction() {
        dshView.btnCapNhatActionListener(new ActionListener() {
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
                huyAction();
                thoatAddUpdateAction();          
            }
        });
    }

    /**
     * Xóa hoa đang được chọn trong bảng danh sách hoa.
     */
    public void xoaAction() {
        dshView.btnXoaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                San_Pham sp = dshView.getHoaSelectedRow();
                String maHoa = sp.getMaHoa();
                tbXoaView.setVisible(true);
                dongYXoaAction(maHoa);
                huyXoaAction();
                thoatThongBaoXoaAction();
            }
        });
    }
    
    
    /**
     * Hiện thông báo lỗi và đòng ý trên thông báo
     */
    public void dongYThongBaoAction() {
        tbView.btnDongYActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbView.dispose();
                hoaTaoCapNhatView.dispose();
                setValueIsEmpty();
                dshView.setVisible(true);
            }
        });
    }
    
    /**
     * Hiện thông báo lỗi và Hủy trên thông báo
     */
    public void huyThongBaoAction() {
        tbView.btnHuyActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbView.dispose();
            }
        });
    }
    
    /**
     * Hiện thông báo lỗi và Thoát trên thông báo
     */
    public void thoatThongBaoAction() {
        tbView.btnThoatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbView.dispose();
            }
        });
    }

    /**
     * Chuyển từ giao diện danh sách hoa sang giao diện đơn hàng
     */
    public void donHangAction() {
        dshView.btnDonHangActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dshView.setVisible(false);
                dhView.setVisible(true);
            }
        });
    }

    /**
     * Chuyển từ giao diện danh sách hoa sang giao diện khách hàng
     */
    public void khachHangAction() {
        dshView.btnKhachhangActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dshView.setVisible(false);
                khView.setVisible(true);
            }
        });
    }
    
    /**
     * Hủy hành động thêm hoặc cập nhật hoa
     */
    public void huyAction() {
        hoaTaoCapNhatView.btnHuyActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbView.setVisible(true);
                dongYThongBaoAction();
                huyThongBaoAction();
                thoatThongBaoAction();
            }
        });
    }
    
    /**
     * Thoát khỏi giao diện thêm và cập nhật hoa
     */
    public void thoatAddUpdateAction() {
        hoaTaoCapNhatView.btnThoatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbView.setVisible(true);
                dongYThongBaoAction();
                huyThongBaoAction();
                thoatThongBaoAction();
            }
        });
    }

    /**
     * Đặt lại tất cả các ô nhập liệu trong form Hoa_Tao_Cap_Nhat về rỗng.
     */
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

    /**
     * Xóa trắng thông tin chi tiết hoa trong view danh sách hoa.
     */
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
    
       /**
     * Hiện cảnh báo và đòng ý trên cảnh báo
     */
    public void dongYXoaAction(String maHoa) {
        tbXoaView.btnDongYActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbXoaView.dispose();
                dshModel.xoaHoa(maHoa);
                dshView.setTableSanPham(dshModel.getAllHoa());
                setAllValueInDSHoaIsEmpty();
            }
        });
    }
    
    /**
     * Hiện thông báo lỗi và Hủy trên cảnh báo
     */
    public void huyXoaAction() {
        tbXoaView.btnHuyActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbXoaView.dispose();
            }
        });
    }
    
    /**
     * Hiện thông báo lỗi và Thoát trên cảnh báo
     */
    public void thoatThongBaoXoaAction() {
        tbXoaView.btnThoatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbXoaView.dispose();
            }
        });
    }

}
