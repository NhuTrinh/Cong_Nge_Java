/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

/**
 *
 * @author TOSHIBA
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
