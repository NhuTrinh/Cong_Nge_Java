/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

/**
 * Lớp Giao_Hang đại diện cho thông tin giao hàng của một đơn hàng. Chứa mã giao
 * hàng, mã đơn hàng, tên người nhận, số điện thoại và địa chỉ.
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
public class Giao_Hang {

    private int maGiaoHang;
    private String maDonHang;
    private String tenNguoiNhan;
    private String soDienThoai;
    private String diaChi;

    /**
     * Constructor khởi tạo thông tin giao hàng.
     */
    public Giao_Hang(int maGiaoHang, String maDonHang, String tenNguoiNhan, String soDienThoai, String diaChi) {
        this.maGiaoHang = maGiaoHang;
        this.maDonHang = maDonHang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
    }

    // Getter
    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

}
