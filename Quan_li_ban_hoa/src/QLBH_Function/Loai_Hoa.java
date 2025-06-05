/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

import QLBH_View.Hoa_Don;

/**
 *
 * @author Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
 */
/**
 * Enum Loai_Hoa dùng để khai báo các loại hoa có mã và tên tương ứng. Được sử
 * dụng trong chương trình để phân loại sản phẩm theo từng loại hoa cụ thể.
 *
 * Gồm 3 loại mặc định: - Hoa Hồng - Hoa Cúc - Lá (trang trí)
 */
public enum Loai_Hoa {
    Hoa_Hong("LH01", "Hoa Hồng"),
    Hoa_Cuc("LH02", "Hoa Cúc"),
    La("LH03", "Lá");

    // Mã loại hoa, ví dụ: LH01
    private String ma;

    // Tên loại hoa, ví dụ: Hoa Hồng
    private String ten;

    /**
     * Constructor riêng của Enum để gán mã và tên cho từng loại hoa
     *
     * @param ma Mã loại hoa
     * @param ten Tên loại hoa
     */
    private Loai_Hoa(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    /**
     * Trả về mã của loại hoa
     *
     * @return Mã loại hoa
     */
    public String getMa() {
        return ma;
    }

    /**
     * Trả về tên của loại hoa
     *
     * @return Tên loại hoa
     */
    public String getTen() {
        return ten;
    }

    /**
     * Tìm loại hoa theo tên.
     *
     * @param tenHoa Tên loại hoa cần tìm
     * @return Đối tượng Loai_Hoa nếu tìm thấy, ngược lại trả về null
     */
    public static Loai_Hoa timLoaiHoaTheoTen(String tenHoa) {
        for (Loai_Hoa lh : values()) {
            if (lh.ten.equals(tenHoa)) 
                //// So sánh mã hoa trong enum với mã cần tìm
            {
                return lh;
            }
        }
        return null; // Không tìm thấy
    }

    /**
     * Tìm loại hoa theo mã.
     *
     * @param maHoa Mã loại hoa cần tìm
     * @return Đối tượng Loai_Hoa nếu tìm thấy, ngược lại trả về null
     */
    public static Loai_Hoa timLoaiHoaTheoMa(String maHoa) {
        for (Loai_Hoa lh : values()) {
            if (lh.ma.equals(maHoa)) // So sánh mã hoa trong enum với mã cần tìm
            {
                return lh;
            }
        }
        return null; // Không tìm thấy
    }
}
