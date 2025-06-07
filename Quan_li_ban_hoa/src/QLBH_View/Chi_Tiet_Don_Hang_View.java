/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QLBH_View;

import QLBH_Function.Nhan_vien;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * Giao diện chi tiết đơn hàng Cho phép hiển thị và chỉnh sửa thông tin đơn
 * hàng, khách hàng và nhân viên
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
public class Chi_Tiet_Don_Hang_View extends javax.swing.JFrame {

    /**
     * Khởi tạo form Chi_Tiet_Don_Hang_View
     */
    public Chi_Tiet_Don_Hang_View() {
        initComponents();
    }

    /**
     * Ẩn các trường tìm kiếm khách hàng khi không cần thiết
     */
    public void disableFieldsKhachHang() {
        lblTimKiem.setVisible(false);
        txtTim.setVisible(false);
        btnTim.setVisible(false);
        lblHuongDan.setVisible(false);
    }
    
    /**
     *Hiện các trường tìm kiếm khách hàng khi không cần thiết
     */
    public void enableFieldsKhachHang() {
        lblTimKiem.setVisible(true);
        txtTim.setVisible(true);
        btnTim.setVisible(true);
        lblHuongDan.setVisible(true);
    }

    /**
     * Vô hiệu hóa các trường chi tiết đơn hàng để không cho phép chỉnh sửa và
     * ẩn các nút chức năng liên quan đến chỉnh sửa
     */
    public void disableChiTietDonHang() {
        txtMaDonHang.setEditable(false);
        cbxNhanVien.setEditable(false);
        cbxTrangThai.setEditable(false);
        txtTenKhachHang.setEditable(false);
        txtSoDienThoai.setEditable(false);
        txtTenNguoiNhan.setEditable(false);
        txtSoDienThoaiNhan.setEditable(false);
        txtDiaChiNhan.setEditable(false);
        txtTienHoa.setEditable(false);
        txtTienVanChuyen.setEditable(false);
        txtTienCamHoa.setEditable(false);
        txtVIP.setEditable(false);
        txtVAT.setEditable(false);
        txtTongTien.setEditable(false);
        btnLuu.setVisible(false);
        btnThemGioHang.setVisible(false);
    }
    
    /**
     * Cho phép chỉnh sửa các trường chi tiết đơn hàng để không cho phép chỉnh sửa và
     * 
     */
    public void enableChiTietDonHang() {
        txtMaDonHang.setEditable(true);
        cbxNhanVien.setEditable(true);
        cbxTrangThai.setEditable(true);
        txtTenKhachHang.setEditable(true);
        txtSoDienThoai.setEditable(true);
        txtTenNguoiNhan.setEditable(true);
        txtSoDienThoaiNhan.setEditable(true);
        txtDiaChiNhan.setEditable(true);
        txtTienHoa.setEditable(true);
        txtTienVanChuyen.setEditable(true);
        txtTienCamHoa.setEditable(true);
        txtVIP.setEditable(true);
        txtVAT.setEditable(true);
        txtTongTien.setEditable(true);
        btnLuu.setVisible(true);
        btnThemGioHang.setVisible(true);
    }
    
    /**
     * Ẩn nút xem giở hàng khi thêm mới đơn hàng
     */
    public void disableBtnXemGioHang() {
        btnXemGioHang.setVisible(false);
    }
    
    /**
     * Ẩn nút xem giở hàng khi thêm mới đơn hàng
     */
    public void enableBtnXemGioHang() {
        btnXemGioHang.setVisible(true);
    }

    /**
     * Đăng ký sự kiện cho nút Xem giỏ hàng
     */
    public void btnXemGioHangActionListener(ActionListener actionListener) {
        btnXemGioHang.addActionListener(actionListener);
    }

    /**
     * Đăng ký sự kiện cho nút Thoát
     */
    public void btnThoatGioHangActionListener(ActionListener actionListener) {
        btnThoat.addActionListener(actionListener);
    }

    /**
     * Đăng ký sự kiện cho nút Tìm kiếm
     */
    public void btnTimGioHangActionListener(ActionListener actionListener) {
        btnTim.addActionListener(actionListener);
    }

    /**
     * Đăng ký sự kiện cho nút Thêm giỏ hàng
     */
    public void btnThemGioHangActionListener(ActionListener actionListener) {
        btnThemGioHang.addActionListener(actionListener);
    }

    /**
     * Đăng ký sự kiện cho nút Xem Thanh Toán
     */
    public void btnXemThanhToanActionListener(ActionListener actionListener) {
        btnXemThanhToan.addActionListener(actionListener);
    }

    /**
     * Đăng ký sự kiện cho nút Lưu Thanh Toán
     */
    public void btnLuuThanhToanActionListener(ActionListener actionListener) {
        btnLuu.addActionListener(actionListener);
    }
    
    /**
     * Đăng ký sự kiện cho nút Hủy chi tiết đơn hàng
     */
    public void btnHuyChiTietDonHangActionListener(ActionListener all) {
        btnHuy.addActionListener(all);
    }

    // Các phương thức setter để thiết lập giá trị cho các trường hiển thị thông tin đơn hàng, khách hàng, nhân viên
    public void setTxtTim(String txtTim) {
        this.txtTim.setText(txtTim);
    }

    public void setTxtSoDienThoai(String txtSoDienThoai) {
        this.txtSoDienThoai.setText(txtSoDienThoai);
    }

    public void setTxtTenKhachHang(String txtTenKhachHang) {
        this.txtTenKhachHang.setText(txtTenKhachHang);
    }

    public void setTxtDiaChiNhan(String txtDiaChiNhan) {
        this.txtDiaChiNhan.setText(txtDiaChiNhan);
    }

    public void setTxtSoDienThoaiNhan(String txtSoDienThoaiNhan) {
        this.txtSoDienThoaiNhan.setText(txtSoDienThoaiNhan);
    }

    public void setTxtTenNguoiNhan(String txtTenNguoiNhan) {
        this.txtTenNguoiNhan.setText(txtTenNguoiNhan);
    }

    public void setTxtTienCamHoa(String txtTienCamHoa) {
        this.txtTienCamHoa.setText(txtTienCamHoa);
    }

    public void setTxtTienHoa(String txtTienHoa) {
        this.txtTienHoa.setText(txtTienHoa);
    }

    public void setTxtTienVanChuyen(String txtTienVanChuyen) {
        this.txtTienVanChuyen.setText(txtTienVanChuyen);
    }

    public void setTxtTongTien(String txtTongTien) {
        this.txtTongTien.setText(txtTongTien);
    }

    public void setTxtVAT(String txtVAT) {
        this.txtVAT.setText(txtVAT);
    }

    public void setTxtVIP(String txtVIP) {
        this.txtVIP.setText(txtVIP);
    }

    public void setCbxNhanVien(String maNhanVien) {
        this.cbxNhanVien.setSelectedItem(maNhanVien);
    }

    public void setCbxTrangThai(String trangThai) {
        this.cbxTrangThai.setSelectedItem(trangThai);
    }

    public void setTxtMaDonHang(String txtMaDonHang) {
        this.txtMaDonHang.setText(txtMaDonHang);
    }

    // Các phương thức getter lấy dữ liệu từ các trường hiển thị
    public String getTxtTim() {
        return txtTim.getText();
    }

    public String getTxtSoDienThoai() {
        return txtSoDienThoai.getText();
    }

    public String getTxtMaDonHang() {
        return txtMaDonHang.getText();
    }

    public String getTxtDiaChiNhan() {
        return txtDiaChiNhan.getText();
    }

    public String getTxtSoDienThoaiNhan() {
        return txtSoDienThoaiNhan.getText();
    }

    public String getTxtTenNguoiNhan() {
        return txtTenNguoiNhan.getText();
    }

    public String getCbxNhanVien() {
        return cbxNhanVien.getSelectedItem().toString();
    }

    public String getCbxTrangThai() {
        return cbxTrangThai.getSelectedItem().toString();
    }

    public String getTxtTenKhachHang() {
        return txtTenKhachHang.getText();
    }

    public String getTxtTongTien() {
        return txtTongTien.getText();
    }

    /**
     * Nạp danh sách nhân viên vào combobox chọn nhân viên
     *
     * @param dsnv danh sách nhân viên
     */
    public void loadDanhSachNhanVien(ArrayList<Nhan_vien> dsnv) {
        for (Nhan_vien nv : dsnv) {
            cbxNhanVien.addItem(nv.getMaNhanVien());
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        lblTimKiem = new javax.swing.JLabel();
        txtTim = new javax.swing.JTextField();
        lblHuongDan = new javax.swing.JLabel();
        btnTim = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnThemGioHang = new javax.swing.JButton();
        btnXemGioHang = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTenNguoiNhan = new javax.swing.JTextField();
        txtSoDienThoaiNhan = new javax.swing.JTextField();
        txtDiaChiNhan = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTienHoa = new javax.swing.JTextField();
        txtTienVanChuyen = new javax.swing.JTextField();
        txtTienCamHoa = new javax.swing.JTextField();
        txtVIP = new javax.swing.JTextField();
        txtVAT = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        btnXemThanhToan = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        btnHuy = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaDonHang = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cbxNhanVien = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        cbxTrangThai = new javax.swing.JComboBox<>();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CHI TIẾT ĐƠN HÀNG");

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CHI TIẾT ĐƠN HÀNG");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH_Images/Dong.png"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(308, 308, 308)
                .addComponent(btnThoat)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThoat)
                        .addGap(0, 23, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel2.setText("Thông tin khách hàng");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel3.setText("Tên khách hàng:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel5.setText("Số điện thoại:");

        txtTenKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        txtSoDienThoai.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        lblTimKiem.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        lblTimKiem.setText("Tìm kiếm:");

        txtTim.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        lblHuongDan.setFont(new java.awt.Font("Times New Roman", 2, 12)); // NOI18N
        lblHuongDan.setText("(Sử dụng số điện thoại để tìm thông tin khách hàng)");

        btnTim.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        btnTim.setText("Tìm");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenKhachHang)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.DEFAULT_SIZE, 247, Short.MAX_VALUE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(lblTimKiem)
                                .addGap(18, 18, 18)
                                .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnTim))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(lblHuongDan)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTimKiem)
                            .addComponent(txtTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(12, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblHuongDan)
                        .addGap(28, 28, 28))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel7.setText("Thông tin giỏ hàng");

        btnThemGioHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThemGioHang.setText("Thêm hoa");

        btnXemGioHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXemGioHang.setText("Xem giỏ hàng");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(btnThemGioHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(btnXemGioHang)
                .addGap(70, 70, 70))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemGioHang)
                    .addComponent(btnXemGioHang))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel8.setText("Thông tin giao hàng");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel9.setText("Tên người nhận:");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel10.setText("Số điện thoại: ");
        jLabel10.setToolTipText("");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel11.setText("Địa chỉ: ");

        txtTenNguoiNhan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTenNguoiNhan.setToolTipText("");

        txtSoDienThoaiNhan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        txtDiaChiNhan.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtDiaChiNhan.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenNguoiNhan)
                            .addComponent(txtSoDienThoaiNhan)
                            .addComponent(txtDiaChiNhan))))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtTenNguoiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(txtSoDienThoaiNhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtDiaChiNhan))
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel12.setText("Thông tin thanh toán");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel13.setText("Tiền hoa: ");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel14.setText("Vận chuyển: ");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel15.setText("Cắm hoa: ");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel16.setText("VIP: ");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel17.setText("VAT: ");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel18.setText("Tổng tiền: ");

        txtTienHoa.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        txtTienVanChuyen.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        txtTienCamHoa.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        txtVIP.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        txtVAT.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        txtTongTien.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        txtTongTien.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        btnXemThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH_Images/Xem.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnXemThanhToan)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienVanChuyen)
                            .addComponent(txtTienHoa)
                            .addComponent(txtTienCamHoa)
                            .addComponent(txtVIP)
                            .addComponent(txtVAT)
                            .addComponent(txtTongTien))))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(btnXemThanhToan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTienHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTienVanChuyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTienCamHoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtVIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 102, 0));

        btnHuy.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnHuy.setText("Hủy");
        btnHuy.setPreferredSize(new java.awt.Dimension(200, 30));

        btnLuu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.setPreferredSize(new java.awt.Dimension(200, 30));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 207, Short.MAX_VALUE)
                .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel4.setText("Thông tin đơn hàng");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel6.setText("Mã đơn hàng:");

        txtMaDonHang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel19.setText("Nhân viên");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel20.setText("Trạng thái");

        cbxTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chờ giao", "Hoàn thành" }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(31, 31, 31)
                        .addComponent(txtMaDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(cbxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtMaDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(cbxNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(cbxTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Chi_Tiet_Don_Hang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chi_Tiet_Don_Hang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chi_Tiet_Don_Hang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chi_Tiet_Don_Hang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chi_Tiet_Don_Hang_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnThemGioHang;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXemGioHang;
    private javax.swing.JButton btnXemThanhToan;
    private javax.swing.JComboBox<String> cbxNhanVien;
    private javax.swing.JComboBox<String> cbxTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel lblHuongDan;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JTextField txtDiaChiNhan;
    private javax.swing.JTextField txtMaDonHang;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSoDienThoaiNhan;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenNguoiNhan;
    private javax.swing.JTextField txtTienCamHoa;
    private javax.swing.JTextField txtTienHoa;
    private javax.swing.JTextField txtTienVanChuyen;
    private javax.swing.JTextField txtTim;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtVAT;
    private javax.swing.JTextField txtVIP;
    // End of variables declaration//GEN-END:variables

}
