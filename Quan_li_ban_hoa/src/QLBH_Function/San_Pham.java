/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

/**
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
/**
 * Lớp San_Pham dùng để biểu diễn một đối tượng sản phẩm (hoa) trong hệ thống.
 * Bao gồm các thông tin như mã hoa, tên hoa, quốc gia, màu sắc, số lượng, giá,
 * v.v.
 *
 */
public class San_Pham {

    private String maHoa; // Mã sản phẩm (hoa)
    private String tenHoa;  // Tên sản phẩm (hoa)
    private String ghiChu; // Ghi chú thêm về hoa (nếu có)
    private String quocGia;  // Quốc gia xuất xứ của hoa
    private String mauSac; // Màu sắc của hoa
    private int soLuong;  // Số lượng tồn kho
    private double gia;  // Giá bán của sản phẩm
    private String maLoaiHoa; // Mã loại hoa (liên kết với enum Loai_Hoa)

    /**
     * Constructor khởi tạo một đối tượng sản phẩm với đầy đủ thông tin.
     *
     * @param maHoa Mã hoa
     * @param tenHoa Tên hoa
     * @param ghiChu Ghi chú
     * @param quocGia Quốc gia xuất xứ
     * @param mauSac Màu sắc
     * @param soLuong Số lượng tồn
     * @param gia Giá bán
     * @param maLoaiHoa Mã loại hoa
     */
    public San_Pham(String maHoa, String tenHoa, String ghiChu, String quocGia, String mauSac, int soLuong, double gia, String maLoaiHoa) {
        this.maHoa = maHoa;
        this.tenHoa = tenHoa;
        this.ghiChu = ghiChu;
        this.quocGia = quocGia;
        this.mauSac = mauSac;
        this.soLuong = soLuong;
        this.gia = gia;
        this.maLoaiHoa = maLoaiHoa;
    }

    // Các phương thức getter dùng để lấy thông tin từng thuộc tính
    public String getMaHoa() {
        return maHoa;
    }

    public String getTenHoa() {
        return tenHoa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public String getMauSac() {
        return mauSac;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getGia() {
        return gia;
    }

    public String getMaLoaiHoa() {
        return maLoaiHoa;
    }

    // Các phương thức setter dùng để cập nhật thông tin thuộc tính
    public void setMaHoa(String maHoa) {
        this.maHoa = maHoa;
    }

    public void setTenHoa(String tenHoa) {
        this.tenHoa = tenHoa;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setMaLoaiHoa(String maLoaiHoa) {
        this.maLoaiHoa = maLoaiHoa;
    }

    /**
     * Ghi đè phương thức toString để trả về chuỗi mô tả sản phẩm.
     *
     * @return Thông tin sản phẩm dạng chuỗi, dùng cho debug hoặc xuất dữ liệu
     */
    @Override
    public String toString() {
        return "%s, %s, %s, %s, %s, %d, %s, %s".formatted(maHoa, tenHoa, ghiChu, quocGia, mauSac, soLuong, gia, maLoaiHoa);
    }

    /**
     * Trả về mảng Object gồm các thông tin chính của sản phẩm, dùng để hiển thị
     * trong bảng.
     *
     * @return Mảng gồm: mã hoa, tên hoa, số lượng, giá
     */
    public Object[] getArrSP() {
        return new Object[]{maHoa, tenHoa, soLuong, gia};
    }

    /**
     * Trả về mảng Object gồm đầy đủ thông tin sản phẩm, dùng khi thêm vào giỏ
     * hàng.
     *
     * @return Mảng gồm: mã hoa, tên hoa, quốc gia, màu sắc, số lượng, giá, mã
     * loại hoa, ghi chú
     */
    public Object[] getArrThemGioHangSP() {
        return new Object[]{maHoa, tenHoa, quocGia, mauSac, soLuong, gia, maLoaiHoa, ghiChu};
    }

}
