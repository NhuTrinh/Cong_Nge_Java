/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

/**
 * Lớp Thanh_Toan đại diện cho thông tin thanh toán của một đơn hàng. Bao gồm
 * các khoản tiền hàng, phí vận chuyển, phí cắm hoa, VAT, ưu đãi VIP, và tổng
 * tiền.
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
public class Thanh_Toan {

    private int maThanhToan;
    private String maDonHang;
    private Double tienHang;
    private Double phiVanChuyen;
    private Double phiCamHoa;
    private Double VAT;
    private Double VIP;
    private Double tongTien;

    /**
     * Constructor khởi tạo đối tượng Thanh_Toan.
     */
    public Thanh_Toan(int maThanhToan, String maDonHang, Double tienHang, Double phiVanChuyen, Double phiCamHoa, Double VAT, Double VIP, Double tongTien) {
        this.maThanhToan = maThanhToan;
        this.maDonHang = maDonHang;
        this.tienHang = tienHang;
        this.phiVanChuyen = phiVanChuyen;
        this.phiCamHoa = phiCamHoa;
        this.VAT = VAT;
        this.VIP = VIP;
        this.tongTien = tongTien;
    }

    // Getters
    public int getMaThanhToan() {
        return maThanhToan;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public Double getTienHang() {
        return tienHang;
    }

    public Double getPhiVanChuyen() {
        return phiVanChuyen;
    }

    public Double getPhiCamHoa() {
        return phiCamHoa;
    }

    public Double getVAT() {
        return VAT;
    }

    public Double getVIP() {
        return VIP;
    }

    public Double getTongTien() {
        return tongTien;
    }

}
