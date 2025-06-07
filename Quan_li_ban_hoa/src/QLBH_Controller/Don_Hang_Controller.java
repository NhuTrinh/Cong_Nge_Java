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
import QLBH_View.Thong_Bao_Loi;
import QLBH_View.Thong_Bao_Loi_Don_Hang;
import QLBH_View.Thong_bao_xoa;
import QLBH_View.Thong_bao_xoa_Don_Hang;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.interfaces.DSAKey;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 * Lớp Don_Hang_Controller chịu trách nhiệm điều phối luồng xử lý giữa các View
 * và Model trong chức năng quản lý đơn hàng của ứng dụng bán hoa.
 *
 * Chức năng chính: - Khởi tạo và kết nối các thành phần giao diện liên quan đến
 * đơn hàng (Don_Hang_View), chi tiết đơn hàng, giỏ hàng và thêm sản phẩm vào
 * giỏ. - Xử lý các sự kiện từ người dùng như: + Chọn đơn hàng trong bảng để lấy
 * mã khách hàng. + Thêm sản phẩm vào giỏ hàng. + Xem giỏ hàng. + Xem chi tiết
 * đơn hàng đã chọn. + Thêm đơn hàng mới từ dữ liệu trong giỏ hàng. + Xoá đơn
 * hàng được chọn. - Tương tác với Don_Hang_Model để thực hiện các thao tác với
 * cơ sở dữ liệu như: + Lấy danh sách đơn hàng. + Tính tổng tiền giỏ hàng theo
 * khách hàng. + Thêm mới đơn hàng và chi tiết đơn hàng. + Xoá đơn hàng và chi
 * tiết liên quan. + Reset giỏ hàng sau khi hoàn tất đơn hàng.
 *
 * Lớp này hoạt động theo mô hình MVC (Model - View - Controller), đóng vai trò
 * Controller để đảm bảo sự tách biệt giữa logic xử lý và giao diện.
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
public class Don_Hang_Controller {

    public MainFrame mainView;
    public Don_Hang_View dhView;
    public Don_Hang_Model dhModel;
    public Chi_Tiet_Don_Hang_View ctdhView;
    public Gio_Hang_View ghView;
    public Danh_Sach_Hoa_View dshView;
    public Them_Gio_Hang tghView;
    public Thong_Bao_Loi_Don_Hang tbView;
    public Thong_bao_xoa_Don_Hang tbXoaView;

    /**
     * Khởi tạo Don_Hang_Controller với các view và model cần thiết. Dùng để
     * điều phối giữa các màn hình liên quan đến đơn hàng, giỏ hàng và danh sách
     * hoa.
     *
     * @param mainView Frame chính của ứng dụng.
     * @param dhView Giao diện danh sách đơn hàng.
     * @param dhModel Model xử lý dữ liệu đơn hàng.
     * @param ctdhView Giao diện chi tiết đơn hàng.
     * @param ghView Giao diện giỏ hàng.
     * @param dshView Giao diện danh sách hoa.
     * @param tghView Giao diện thêm hoa vào giỏ hàng.
     */
    public Don_Hang_Controller(MainFrame mainView, Don_Hang_View dhView, Don_Hang_Model dhModel, Chi_Tiet_Don_Hang_View ctdhView, Gio_Hang_View ghView, Danh_Sach_Hoa_View dshView, Them_Gio_Hang tghView, Thong_Bao_Loi_Don_Hang tbView, Thong_bao_xoa_Don_Hang tbXoaView) {
        this.mainView = mainView;
        this.dhView = dhView;
        this.dhModel = dhModel;
        this.ctdhView = ctdhView;
        this.ghView = ghView;
        this.dshView = dshView;
        this.tghView = tghView;
        this.tbView = tbView;
        this.tbXoaView = tbXoaView;
    }

    // Thiết lập sự kiện xóa đơn hàng khi nút xóa được nhấn
    public void xoaAction() {
        dhView.btnXoaActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Don_Hang dh = dhView.getDonHangSelectedRow();
                String maDonHang = dh.getMaDonHang();
                tbXoaView.setVisible(true);
                dongYXoaAction(maDonHang);
                huyXoaAction();
                thoatThongBaoXoaAction();
                
            }
        });
    }

    // Thiết lập sự kiện xem chi tiết đơn hàng khi nút xem được nhấn
    // Hiển thị thông tin đơn hàng, khách hàng, giao hàng và thanh toán lên giao diện chi tiết
    public void xemAction() {
        dhView.btnXemActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Don_Hang dh = dhView.getDonHangSelectedRow();
                String tenKhachHang = dh.getMaKhachHang();
                Khach_Hang_Model khModel = new Khach_Hang_Model();
                Khach_Hang kh = khModel.getAllKhachHangTheoTen(tenKhachHang);
                ctdhView.disableChiTietDonHang();
                ghView.disableGioHang();
                ctdhView.enableBtnXemGioHang();
                ctdhView.disableFieldsKhachHang();
                ctdhView.setTxtMaDonHang(dh.getMaDonHang());
                loadListNhanVienToChiTietDonHang();
                System.out.println("Ma Nhan Vien: " + dh.getMaNhanVien());
                ctdhView.setCbxNhanVien(dh.getMaNhanVien());
                ctdhView.setCbxTrangThai(dh.getTrangThai());
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
                thoatChiTietDonHangAction();
                huyXemChiTietDonHangAction();
                thoatGioHang();
            }
        });
    }

    // Thiết lập sự kiện xem giỏ hàng khi nút xem giỏ hàng được nhấn
    // Hiển thị giỏ hàng theo mã đơn hàng và chuyển giao diện sang xem giỏ hàng
    public void xemGioHangAction(String maDonHang) {
        ctdhView.btnXemGioHangActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ghView.setTableGioHang(dhModel.getAllGioHangTheoMaDon(maDonHang));
                ghView.setVisible(true);
                ctdhView.setVisible(false);
            }

        });
    }

    // Thiết lập sự kiện thêm số lượng hoa trong giỏ hàng khi nút thêm được nhấn
    // Tăng số lượng hoa lên 1 và cập nhật lại bảng giỏ hàng
    public void themGioHangAction() {
        ghView.btnThemActionListener(new ActionListener() {
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
    
    //Thoat đơn hàng
    public void thoatDonHang() {
        dhView.btnThoatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dhView.dispose();
                mainView.setVisible(true);
            }
        });
    }

    //Thoat giỏ hang
    public void thoatGioHang() {
        ghView.btnThoatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ghView.dispose();
                ctdhView.setVisible(true);
            }
        });
    }

    // Thiết lập sự kiện thoát giỏ hàng khi nút thoát được nhấn
    // Đóng cửa sổ giỏ hàng và hiển thị lại chi tiết đơn hàng
    public void xoaGioHangAction() {
        ghView.btnXoaActionListener(new ActionListener() {
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
// Thiết lập sự kiện giảm số lượng hoa trong giỏ hàng khi nút giảm được nhấn
// Cập nhật số lượng hoa trong model và làm mới bảng giỏ hàng

    public void giamGioHangAction() {
        ghView.btnGiamActionListener(new ActionListener() {
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

    // Xóa sạch tất cả các trường dữ liệu trong chi tiết đơn hàng (CTDH)
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

    // Xử lý sự kiện thêm đơn hàng mới: 
    // - Xóa trắng các trường trong chi tiết đơn hàng
    // - Đóng giao diện đơn hàng hiện tại
    // - Hiện giao diện chi tiết đơn hàng
    // - Thiết lập các hành động tìm khách hàng, tải danh sách nhân viên,
    //   thêm hoa vào giỏ hàng, xem và lưu thanh toán
    public void themDonHangAction() {
        dhView.btnThemActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ctdhView.setTxtMaDonHang("");
                ctdhView.disableBtnXemGioHang();
                ctdhView.enableChiTietDonHang();
                ctdhView.enableFieldsKhachHang();
                ghView.enableGioHang();
                setAllValueInCTDHIsEmpty();
                dhView.dispose();
                ctdhView.setVisible(true);
                timKhachHangChiTietDonHangAction();
                loadListNhanVienToChiTietDonHang();
                themHoaVaoGioHangAction();
                themGioHangAction();
                btnXemThanhToanActionListener();
                btnLuuThanhToanActionListener();
                thoatChiTietDonHangAction();
                huyXemChiTietDonHangAction();
                themGioHangAction();
                giamGioHangAction();
                xoaGioHangAction();
                thoatGioHang();
                thoatThemGioHang();
            }
        });
    }

    // Xử lý sự kiện thoát khỏi chi tiết đơn hàng:
    // - Đóng giao diện chi tiết đơn hàng
    // - Hiện lại giao diện danh sách đơn hàng
    public void thoatChiTietDonHangAction() {
        ctdhView.btnThoatGioHangActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbView.setVisible(true);
                dongYThongBaoAction();
                huyThongBaoAction();
                thoatThongBaoAction();
            }
        });
    }
    
    // Xử lý sự kiện thoát khỏi chi tiết đơn hàng:
    // - Đóng giao diện chi tiết đơn hàng
    // - Hiện lại giao diện danh sách đơn hàng
    public void huyXemChiTietDonHangAction() {
        ctdhView.btnHuyChiTietDonHangActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbView.setVisible(true);
                dongYThongBaoAction();
                huyThongBaoAction();
                thoatThongBaoAction();
            }
        });
    }
    

    // Tìm khách hàng theo số điện thoại trong chi tiết đơn hàng:
    // - Lấy số điện thoại nhập từ giao diện
    // - Tìm khách hàng tương ứng từ model
    // - Hiển thị tên và số điện thoại khách hàng lên giao diện
    // - Thêm đơn hàng tạm thời
    public void timKhachHangChiTietDonHangAction() {
        ctdhView.btnTimGioHangActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String soDienThoai = ctdhView.getTxtTim();
                System.out.println("SDT: " + soDienThoai);
                Khach_Hang kh = dhModel.timKhachHangTheoSoDienThoai(soDienThoai);
                ctdhView.setTxtTenKhachHang(kh.getTenKhachHang());
                ctdhView.setTxtSoDienThoai(kh.getSoDienThoai());
                themDonHangTam();
            }
        });
    }

    // Load danh sách nhân viên vào chi tiết đơn hàng:
    // - Lấy danh sách nhân viên từ model đăng nhập
    // - In ra console để kiểm tra
    // - Hiển thị danh sách nhân viên lên combobox trong giao diện chi tiết đơn hàng
    public void loadListNhanVienToChiTietDonHang() {
        Dang_Nhap_Model dnModel = new Dang_Nhap_Model();
        ArrayList<Nhan_vien> dsnv = dnModel.getAllNhanVienTheoMa();
        for (Nhan_vien nv : dsnv) {
            System.out.println(nv);
        }
        ctdhView.loadDanhSachNhanVien(dsnv);
    }

    // Thêm hoặc cập nhật thông tin người nhận cho đơn hàng:
    // - Lấy dữ liệu người nhận từ giao diện chi tiết đơn hàng
    // - Kiểm tra mã đơn hàng đã tồn tại trong bảng giao hàng chưa
    // - Nếu có, cập nhật thông tin giao hàng
    // - Nếu chưa, thêm mới thông tin giao hàng
    public void themThongTinNguoiNhan() {
        String maDonHang = ctdhView.getTxtMaDonHang();
        String tenNguoiNhan = ctdhView.getTxtTenNguoiNhan();
        String soDienThoaiNhan = ctdhView.getTxtSoDienThoaiNhan();
        String diaChiNhan = ctdhView.getTxtDiaChiNhan();
        if (dhModel.kiemTraMaDonHangTrongBangGiaoHang(maDonHang)) {
            dhModel.capNhatThongTinGiaoHangVaoDonHang(maDonHang, tenNguoiNhan, soDienThoaiNhan, diaChiNhan);
        } else {
            dhModel.themThongTinGiaoHangVaoDonHang(maDonHang, tenNguoiNhan, soDienThoaiNhan, diaChiNhan);
        }

    }

    // Xử lý sự kiện thêm hoa vào giỏ hàng:
    // - Lấy mã đơn hàng hiện tại
    // - Lấy danh sách tất cả hoa từ model
    // - Hiển thị giao diện thêm giỏ hàng với danh sách hoa
    // - Gán hành động thêm sản phẩm và thoát giao diện thêm giỏ hàng
    public void themHoaVaoGioHangAction() {
        ctdhView.btnThemGioHangActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maDonHang = ctdhView.getTxtMaDonHang();
                Danh_Sach_Hoa_Model dshModel = new Danh_Sach_Hoa_Model();
                tghView.setTableThemGioHang(dshModel.getAllHoa());
                tghView.setVisible(true);
                themSanPhamAction(maDonHang);
                thoatThemGioHang();
            }
        });
    }

    // Xử lý sự kiện thêm sản phẩm vào giỏ hàng:
    // - Lấy số lượng nhập từ giao diện
    // - Lấy sản phẩm được chọn và thông tin liên quan
    // - Lưu sản phẩm vào giỏ hàng qua model
    // - Reset trường số lượng nhập
    // - Cập nhật lại số lượng hoa còn lại trong kho
    // - Cập nhật lại bảng danh sách hoa trên giao diện
    public void themSanPhamAction(String maDonHang) {
        tghView.btnThemVaoGioHangActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int soLuong = Integer.parseInt(tghView.getTxtSoLuong());
                San_Pham sp = tghView.getHoaSelectedRow();
                String maHoa = sp.getMaHoa();
                Double giaBan = sp.getGia();
                dhModel.luuSanPhamVaoGioHang(maDonHang, maHoa, soLuong, giaBan);
                tghView.setTxtSoLuong("");
                Danh_Sach_Hoa_Model dshModel = new Danh_Sach_Hoa_Model();
                dshModel.capNhatSoLuongHoaSauKhiThemGioHang(maHoa, sp.getSoLuong() - soLuong);
                tghView.setTableThemGioHang(dshModel.getAllHoa());
            }
        });
    }

    // Tạo đơn hàng tạm thời với các thông tin từ giao diện:
    // - Mã đơn hàng, trạng thái, mã nhân viên, tên khách hàng
    // - Lấy mã khách hàng từ model Khach_Hang
    // - Lấy thời gian hiện tại làm ngày lập đơn hàng
    // - Gọi model để tạo đơn hàng tạm với trạng thái và phí VIP mặc định
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

    // Tính tổng tiền hoa trong giỏ hàng của đơn hàng dựa trên mã đơn hàng
    // Trả về tổng tiền dưới dạng kiểu double
    public double tongTienHoa(String maDonHang) {
        return dhModel.tinhTongTienHoaTuGioHang(maDonHang);
    }

    // Đăng ký sự kiện nút "Xem Thanh Toán"
    // Tính và hiển thị các khoản phí (tiền hoa, vận chuyển, cắm hoa, VIP, VAT)
    // Cập nhật hoặc thêm mới thông tin thanh toán vào cơ sở dữ liệu
    // Cập nhật tổng tiền thanh toán lên giao diện
    public void btnXemThanhToanActionListener() {
        ctdhView.btnXemThanhToanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maDonHang = ctdhView.getTxtMaDonHang();
                double tienHoa = dhModel.tinhTongTienHoaTuGioHang(maDonHang);
                int soLuongHoa = dhModel.tongSoLuongHoaTrongGioHang(maDonHang);
                double vanChuyen = 0.0;
                double camHoa = 0.0;
                double VIP = 0.0;
                if (soLuongHoa >= 20) {
                    vanChuyen = 50_000;
                    camHoa = 10_000;
                } else {
                    vanChuyen = 20_000;
                }
                System.out.println("SDT: " + ctdhView.getTxtSoDienThoai());
                Khach_Hang kh = dhModel.timKhachHangTheoSoDienThoai(ctdhView.getTxtSoDienThoai());
                String xepLoai = kh.getXepLoai();
                if (xepLoai.equals("1")) {
                    VIP = 10_000;
                } else if (xepLoai.equals("2")) {
                    VIP = 15_000;
                }
                double VAT = (tienHoa + camHoa + vanChuyen) * 0.1;
                ctdhView.setTxtTienHoa(String.valueOf(tienHoa));
                ctdhView.setTxtTienVanChuyen(String.valueOf(vanChuyen));
                ctdhView.setTxtTienCamHoa(String.valueOf(camHoa));
                ctdhView.setTxtVIP(String.valueOf(VIP));
                ctdhView.setTxtVAT(String.valueOf(VAT));
                if (dhModel.kiemTraMaDonHangTrongBangThanhToan(maDonHang)) {
                    dhModel.capNhatThongTinThanhToan(maDonHang, tienHoa, vanChuyen, camHoa, VAT, VIP);
                } else {
                    dhModel.themThongTinThanhToan(maDonHang, tienHoa, vanChuyen, camHoa, VAT, VIP);
                }
                ctdhView.setTxtTongTien(String.valueOf(dhModel.layTongThanhToanDonHang(maDonHang)));
            }
        });
    }

    // Đăng ký sự kiện nút "Lưu Thanh Toán"
    // Cập nhật đơn hàng với tổng tiền thanh toán
    // Lưu thông tin người nhận
    // Ẩn chi tiết đơn hàng, cập nhật và hiển thị lại danh sách đơn hàng
    public boolean btnLuuThanhToanActionListener() {
        ctdhView.btnLuuThanhToanActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String maDonHang = ctdhView.getTxtMaDonHang();
                double tongTien = Double.parseDouble(ctdhView.getTxtTongTien());
                dhModel.capNhatDonHang(maDonHang, tongTien);
                themThongTinNguoiNhan();
                ctdhView.setVisible(false);
                dhView.setTableDonHang(dhModel.getAllDonHang());
                dhView.setVisible(true);
            }
        });
        return 1 > 0;
    }

    // Đăng ký sự kiện nút "Thoát" ở giao diện thêm giỏ hàng
    // Đóng cửa sổ thêm giỏ hàng khi nút được nhấn
    public void thoatThemGioHang() {
        tghView.btnThoatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tghView.dispose();
            }
        });
    }

    // Đăng ký sự kiện nút cập nhật đơn hàng
    // Lấy đơn hàng được chọn, tải thông tin chi tiết, khách hàng, giao hàng và thanh toán
    // Thiết lập dữ liệu lên giao diện chi tiết đơn hàng và chuyển sang giao diện đó
    // Kích hoạt các hành động liên quan đến giỏ hàng và thanh toán trong chi tiết đơn hàng
    public void capNhatDonHangAction() {
        dhView.btnCapNhatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Don_Hang dh = dhView.getDonHangSelectedRow();
                String tenKhachHang = dh.getMaKhachHang();
                Khach_Hang_Model khModel = new Khach_Hang_Model();
                ctdhView.enableBtnXemGioHang();
                ctdhView.enableChiTietDonHang();
                ctdhView.enableFieldsKhachHang();
                ghView.enableGioHang();
                Khach_Hang kh = khModel.getAllKhachHangTheoTen(tenKhachHang);
                ctdhView.setTxtMaDonHang(dh.getMaDonHang());
                loadListNhanVienToChiTietDonHang();
                System.out.println("Ma Nhan Vien: " + dh.getMaNhanVien());
                ctdhView.setCbxNhanVien(dh.getMaNhanVien());
                ctdhView.setCbxTrangThai(dh.getTrangThai());
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
                themHoaVaoGioHangAction();
                themGioHangAction();
                giamGioHangAction();
                xoaGioHangAction();
                btnXemThanhToanActionListener();
                thoatGioHang();
                btnLuuThanhToanActionListener();
                themGioHangAction();
                giamGioHangAction();
                xoaGioHangAction();
                thoatGioHang();
                thoatThemGioHang();
                thoatChiTietDonHangAction();
                huyXemChiTietDonHangAction();
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
                ctdhView.dispose();
                ctdhView.setTxtMaDonHang("");
                setAllValueInCTDHIsEmpty();
                dhView.setVisible(true);
            }
        });
    }
    
    /**
     * Hiện thông báo lỗi và Hủy trên thông báo
     */
    public void huyThongBaoAction() {
        tbXoaView.btnHuyActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbXoaView.dispose();
            }
        });
    }
    
    /**
     * Hiện thông báo lỗi và Thoát trên thông báo
     */
    public void thoatThongBaoAction() {
        tbXoaView.btnThoatActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbXoaView.dispose();
            }
        });
    }
    
    /**
     * Hiện cảnh báo và đòng ý trên cảnh báo
     */
    public void dongYXoaAction(String maDonHang) {
        tbXoaView.btnDongYActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tbXoaView.dispose();
                dhModel.xoaThanhToan(maDonHang);
                dhModel.xoaThongTinGiaoHang(maDonHang);
                dhModel.xoaCTDonHang(maDonHang);
                dhModel.xoaDonHang(maDonHang);
                dhView.setTableDonHang(dhModel.getAllDonHang());
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
