/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QLBH_Function;

import QLBH_View.Hoa_Don;

/**
 *
 * @author TOSHIBA
 */
public enum Loai_Hoa {
    Hoa_Hong("LH01", "Hoa Hồng"),
    Hoa_Cuc("LH02", "Hoa Cúc"),
    La("LH03", "Lá");
    
    private String ma;
    private String ten;

    private Loai_Hoa(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }

    public String getMa() {
        return ma;
    }

    public String getTen() {
        return ten;
    }
    
    public static Loai_Hoa timLoaiHoaTheoTen(String tenHoa) {
        for (Loai_Hoa lh : values())
        {
            if(lh.ten.equals(tenHoa))
            {
                return lh;
            }
        }
        return null;
    }
    
    public static Loai_Hoa timLoaiHoaTheoMa(String maHoa) {
        for (Loai_Hoa lh : values())
        {
            if(lh.ma.equals(maHoa))
            {
                return lh;
            }
        }
        return null;
    }
}
