/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

/**
 *
 * @author TOSHIBA
 */
public class San_Pham {
    private String maHoa;
    private String tenHoa;
    private String ghiChu;
    private String quocGia;
    private String mauSac;
    private int soLuong;
    private double gia;
    private String maLoaiHoa;

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

    @Override
    public String toString() {
        return  "%S, %S, %S, %S, %S, %d, %S, %S".formatted(maHoa, tenHoa, ghiChu, quocGia, mauSac, soLuong, gia, maLoaiHoa);
    }
    
    
}
