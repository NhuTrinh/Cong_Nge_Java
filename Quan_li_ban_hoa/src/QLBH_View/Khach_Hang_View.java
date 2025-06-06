/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package QLBH_View;

import QLBH_Function.Khach_Hang;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
/**
 * Giao diện chính của khách hàng
 */
public class Khach_Hang_View extends javax.swing.JFrame {

    public Khach_Hang_View() {
        initComponents();
    }
    
    /**
     * ẩn các nút điều khiển giỏ hàng
     */
    public void disableMenu() {
        btnDonHang.setEnabled(false);
        btnDanhSachHoa.setEnabled(false);
        btnKhachHang.setEnabled(false);
    }

    /**
     * Hiển thị danh sách khách hàng dưới dạng bảng
     *
     * @param ArrayList<Khach_Hang> dskh danh sách khách hàng
     */
    public void setTableKhachHang(ArrayList<Khach_Hang> dskh) {
        String[] colunmName = {"Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ"};
        DefaultTableModel dtmDSKH = new DefaultTableModel(colunmName, 0);

        for (Khach_Hang kh : dskh) {
            dtmDSKH.addRow(kh.getArrKH());
        }

        tblKhachHang.setModel(dtmDSKH);
    }

    /**
     * Gán sự kiện xử lý khi người dùng nhấn nút "Thoát".
     *
     * @param all Đối tượng ActionListener sẽ được thực thi khi nút được nhấn
     */
    public void btnThoatActionListener(ActionListener all) {
        btnThoat.addActionListener(all);
    }

    /**
     * Gán sự kiện xử lý khi người dùng nhấn nút "Xem".
     *
     * @param all Đối tượng ActionListener sẽ được thực thi khi nút được nhấn
     */
    public void btnXemActionListener(ActionListener all) {
        btnXem.addActionListener(all);
    }

    /**
     * Gán sự kiện xử lý khi người dùng nhấn nút "Thêm".
     *
     * @param all Đối tượng ActionListener sẽ được thực thi khi nút được nhấn
     */
    public void btnThemActionListener(ActionListener all) {
        btnThem.addActionListener(all);
    }

    /**
     * Gán sự kiện xử lý khi người dùng nhấn nút "Thêm".
     *
     * @param all Đối tượng ActionListener sẽ được thực thi khi nút được nhấn
     */
    public void btnXoaActionListener(ActionListener all) {
        btnXoa.addActionListener(all);
    }

    /**
     * Gán sự kiện xử lý khi người dùng nhấn nút "Đơn Hàng".
     *
     * @param all Đối tượng ActionListener sẽ được thực thi khi nút được nhấn
     */
    public void btnDonHangActionListener(ActionListener all) {
        btnDonHang.addActionListener(all);
    }

    /**
     * Gán sự kiện xử lý khi người dùng nhấn nút "Danh sách hoa".
     *
     * @param all Đối tượng ActionListener sẽ được thực thi khi nút được nhấn
     */
    public void btnDanhSachHoaActionListener(ActionListener all) {
        btnDanhSachHoa.addActionListener(all);
    }

    /**
     * Gán sự kiện xử lý khi người dùng nhấn nút "Cập Nhật".
     *
     * @param all Đối tượng ActionListener sẽ được thực thi khi nút được nhấn
     */
    public void btnCapNhatActionListener(ActionListener all) {
        btnCapNhat.addActionListener(all);
    }

    /**
     * Lấy thông tin từ dòng được chọn
     */
    public void getInformationSelectedRow() {
        int selectedRow = tblKhachHang.getSelectedRow();
        System.out.println("vo day chua" + selectedRow);
        String maKhachHang = "";
        String tenKhachHang = "";
        String soDienThoai = "";
        String diaChi = "";

        if (selectedRow != -1) {
            maKhachHang = tblKhachHang.getValueAt(selectedRow, 0).toString();
            tenKhachHang = tblKhachHang.getValueAt(selectedRow, 1).toString();
            soDienThoai = tblKhachHang.getValueAt(selectedRow, 2).toString();
            diaChi = tblKhachHang.getValueAt(selectedRow, 3).toString();
            System.out.println("ma" + maKhachHang);
            System.out.println("ten" + tenKhachHang);
            System.out.println("dia" + diaChi);
            System.out.println("e" + soDienThoai);
        }

        txtMaKhachHang.setText(maKhachHang);
        txtTenKhachHang.setText(tenKhachHang);
        txtSoDienThoai.setText(soDienThoai);
        txtDiaChi.setText(diaChi);
    }

    /**
     * Lấy thông tin từ dòng được chọn
     *
     * @return Khach Hang
     */
    public Khach_Hang getKhachHangSelectedRow() {
        int selectedRow = tblKhachHang.getSelectedRow();
        System.out.println("vo day chua" + selectedRow);
        String maKhachHang = "";
        String tenKhachHang = "";
        String soDienThoai = "";
        String diaChi = "";

        if (selectedRow != -1) {
            maKhachHang = tblKhachHang.getValueAt(selectedRow, 0).toString();
            tenKhachHang = tblKhachHang.getValueAt(selectedRow, 1).toString();
            soDienThoai = tblKhachHang.getValueAt(selectedRow, 2).toString();
            diaChi = tblKhachHang.getValueAt(selectedRow, 3).toString();
            Khach_Hang kh = new Khach_Hang(maKhachHang, tenKhachHang, soDienThoai, "", "", diaChi);
            return kh;
        }
        return null;
    }

    /**
     * Hiển thị mã khách hàng trên giao diện
     *
     * @param textMaKhachHang mã khách hàng
     */
    public void setTextMaKhachHang(String textMaKhachHang) {
        this.txtMaKhachHang.setText(textMaKhachHang);
    }

    /**
     * Hiển thị địa chỉ trên giao diện
     *
     * @param txtDiaChi địa chỉ
     */
    public void setTxtDiaChi(String txtDiaChi) {
        this.txtDiaChi.setText(txtDiaChi);
    }

    /**
     * Hiển thị email trên giao diện
     *
     * @param txtEmail email
     */
    public void setTxtEmail(String txtEmail) {
        this.txtEmail.setText(txtEmail);
    }

    /**
     * Hiển thị số điện thoại trên giao diện
     *
     * @param txtSoDienThoai số điện thoại khách hàng
     */
    public void setTxtSoDienThoai(String txtSoDienThoai) {
        this.txtSoDienThoai.setText(txtSoDienThoai);
    }

    /**
     * Hiển thị tên khách hàng trên giao diện
     *
     * @param txtTenKhachHang tên khách hàng
     */
    public void setTxtTenKhachHang(String txtTenKhachHang) {
        this.txtTenKhachHang.setText(txtTenKhachHang);
    }

    /**
     * Hiển thị xếp loại khách hàng trên giao diện
     *
     * @param txtXepLoai xếp loại của khách hàng
     */
    public void setTxtXepLoai(String txtXepLoai) {
        this.txtXepLoai.setText(txtXepLoai);
    }

    /**
     * Lấy mã khách hàng trên giao diện
     *
     * @return String mã khách hàng
     */
    public String getTxtMaKhachHang() {
        return txtMaKhachHang.getText();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.s
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnThoat = new javax.swing.JButton();
        btnKhachHang = new javax.swing.JButton();
        btnDonHang = new javax.swing.JButton();
        btnDanhSachHoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtXepLoai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnXem = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Khách hàng");

        jPanel2.setBackground(new java.awt.Color(0, 102, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("NHÀ HOA");

        btnThoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH_Images/Dong.png"))); // NOI18N

        btnKhachHang.setBackground(new java.awt.Color(204, 204, 204));
        btnKhachHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH_Images/Khach_hang.png"))); // NOI18N
        btnKhachHang.setText("Khách hàng");

        btnDonHang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDonHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH_Images/Don_hang.png"))); // NOI18N
        btnDonHang.setText("Đơn hàng");

        btnDanhSachHoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnDanhSachHoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH_Images/Danh_muc_hoa.png"))); // NOI18N
        btnDanhSachHoa.setText("Danh mục hoa");
        btnDanhSachHoa.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btnKhachHang)
                .addGap(158, 158, 158)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThoat))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDonHang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDanhSachHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(btnThoat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKhachHang)
                    .addComponent(btnDonHang)
                    .addComponent(btnDanhSachHoa))
                .addGap(15, 15, 15))
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel2.setText("Mã khách hàng");
        jLabel2.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel3.setText("Tên khách hàng");
        jLabel3.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel4.setText("Số điện thoại");
        jLabel4.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel5.setText("Xếp loại");
        jLabel5.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel6.setText("Email");
        jLabel6.setPreferredSize(new java.awt.Dimension(100, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel7.setText("Địa chỉ");
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 30));

        txtMaKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtMaKhachHang.setPreferredSize(new java.awt.Dimension(300, 30));

        txtTenKhachHang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtTenKhachHang.setPreferredSize(new java.awt.Dimension(300, 30));

        txtSoDienThoai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtSoDienThoai.setPreferredSize(new java.awt.Dimension(300, 30));

        txtXepLoai.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtXepLoai.setPreferredSize(new java.awt.Dimension(300, 30));

        txtEmail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtEmail.setPreferredSize(new java.awt.Dimension(300, 30));

        txtDiaChi.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        txtDiaChi.setPreferredSize(new java.awt.Dimension(300, 30));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtXepLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtXepLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblKhachHang);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(0, 102, 0));

        btnThem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(0, 51, 0));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH_Images/Them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(114, 30));

        btnCapNhat.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnCapNhat.setForeground(new java.awt.Color(0, 51, 0));
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH_Images/Cap_nhat.png"))); // NOI18N
        btnCapNhat.setText("Cập nhật");
        btnCapNhat.setPreferredSize(new java.awt.Dimension(100, 30));

        btnXoa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(0, 51, 0));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH_Images/Xoa.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.setToolTipText("");
        btnXoa.setPreferredSize(new java.awt.Dimension(114, 30));

        btnXem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnXem.setForeground(new java.awt.Color(0, 51, 0));
        btnXem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/QLBH_Images/Xem.png"))); // NOI18N
        btnXem.setText("Xem");
        btnXem.setToolTipText("");
        btnXem.setPreferredSize(new java.awt.Dimension(114, 30));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(btnXem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            java.util.logging.Logger.getLogger(Khach_Hang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Khach_Hang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Khach_Hang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Khach_Hang_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Khach_Hang_View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnDanhSachHoa;
    private javax.swing.JButton btnDonHang;
    private javax.swing.JButton btnKhachHang;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThoat;
    private javax.swing.JButton btnXem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtXepLoai;
    // End of variables declaration//GEN-END:variables
}
