    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package QLBH_Model;

    import QLBH_Function.Khach_Hang;
    import QLBH_Function.Loai_Hoa;
    import QLBH_Function.San_Pham;
    import static QLBH_Model.BaseModel.getConnection;
    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import java.sql.ResultSet;
    import java.util.ArrayList;

    /**
     * Lớp Danh_Sach_Hoa_Model thực hiện các thao tác truy vấn, thêm, cập nhật, và
     * xóa dữ liệu liên quan đến hoa từ bảng HOA trong cơ sở dữ liệu.
     *
     * Kế thừa từ lớp BaseModel để tái sử dụng phương thức kết nối CSDL.
     *
     * Các chức năng chính: - Lấy danh sách tất cả các loại hoa. - Lấy thông tin hoa
     * theo mã. - Lấy tên hoa hoặc mã hoa theo giá trị đối nghịch. - Thêm mới, cập
     * nhật, xóa hoa. - Cập nhật số lượng hoa sau khi thêm vào giỏ hàng.
     *
     * Author: Trịnh Nguyễn Huỳnh Như - 23540024; Phạm Nguyễn Hoàng Long - 23540017
     */
    public class Danh_Sach_Hoa_Model extends BaseModel {

        /**
         * Lấy toàn bộ danh sách hoa từ bảng HOA.
         *
         * @return Danh sách các đối tượng San_Pham (hoa).
         */
        public ArrayList<San_Pham> getAllHoa() {
            ArrayList<San_Pham> dssp = new ArrayList<>();
            String sql = "select * from HOA";
            try {
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    San_Pham sp = new San_Pham(rs.getString("MAHOA"), rs.getString("TENHOA"), rs.getString("GHICHU"), rs.getString("QUOCGIA"), rs.getString("MAUSAC"), rs.getInt("SOLUONG"), rs.getDouble("GIA"), rs.getString("MALH"));
                    dssp.add(sp);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return dssp;
        }

        /**
         * Truy vấn thông tin một hoa cụ thể theo mã hoa.
         *
         * @param maHoa Mã định danh của hoa.
         * @return Đối tượng San_Pham nếu tồn tại, ngược lại trả về null.
         */
        public San_Pham getAllHoaTheoMa(String maHoa) {
            String sql = "select * from HOA where MAHOA =?";
            try {
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, maHoa);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    San_Pham sp = new San_Pham(rs.getString("MAHOA"), rs.getString("TENHOA"), rs.getString("GHICHU"), rs.getString("QUOCGIA"), rs.getString("MAUSAC"), rs.getInt("SOLUONG"), rs.getDouble("GIA"), rs.getString("MALH"));
                    return sp;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * Lấy tên loại hoa dựa trên mã loại hoa.
         *
         * @param maHoa Mã loại hoa (MALH).
         * @return Tên loại hoa nếu có, ngược lại trả về null.
         */
        public String getLoaiHoaTuMaLoaiHoa(String maHoa) {
            String sql = "select * from LOAIHOA where MALH =?";
            try {
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, maHoa);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String tenLoaiHoa = rs.getString("TENLH");
                    return tenLoaiHoa;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         * Thêm mới một hoa vào cơ sở dữ liệu.
         *
         * @param maHoa Mã hoa.
         * @param tenHoa Tên hoa.
         * @param quocGia Xuất xứ quốc gia.
         * @param mauSac Màu sắc.
         * @param soLuong Số lượng tồn kho.
         * @param gia Đơn giá.
         * @param loaiHoa Mã loại hoa (MALH).
         * @param ghiChu Ghi chú (tùy chọn).
         * @return true nếu thêm thành công, ngược lại false.
         */
        public boolean themHoa(String maHoa, String tenHoa, String quocGia, String mauSac, int soLuong, double gia, String loaiHoa, String ghiChu) {
            String sql = "INSERT INTO HOA (MAHOA, TENHOA, QUOCGIA, MAUSAC, SOLUONG, GIA, MALH, GHICHU) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try {
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, maHoa);
                ps.setString(2, tenHoa);
                ps.setString(3, quocGia);
                ps.setString(4, mauSac);
                ps.setInt(5, soLuong);
                ps.setDouble(6, gia);
                ps.setString(7, loaiHoa);
                ps.setString(8, ghiChu);
                int rs = ps.executeUpdate();
                return rs > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        /**
         * Cập nhật thông tin một hoa đã có trong CSDL.
         *
         * @param maHoa Mã hoa.
         * @param tenHoa Tên hoa.
         * @param quocGia Xuất xứ.
         * @param mauSac Màu sắc.
         * @param soLuong Số lượng.
         * @param gia Giá bán.
         * @param loaiHoa Mã loại hoa.
         * @param ghiChu Ghi chú thêm.
         * @return true nếu cập nhật thành công, ngược lại false.
         */
        public boolean capNhatHoa(String maHoa, String tenHoa, String quocGia, String mauSac, int soLuong, double gia, String loaiHoa, String ghiChu) {
            String sql = "UPDATE HOA SET TENHOA = ?, QUOCGIA = ?, MAUSAC = ?, SOLUONG = ?, GIA = ?, MALH = ?, GHICHU = ? WHERE MAHOA = ?";
            try {
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tenHoa);
                ps.setString(2, quocGia);
                ps.setString(3, mauSac);
                ps.setInt(4, soLuong);
                ps.setDouble(5, gia);
                ps.setString(6, loaiHoa);
                ps.setString(7, ghiChu);
                ps.setString(8, maHoa);
                int rs = ps.executeUpdate();
                return rs > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        /**
         * Xóa một hoa khỏi cơ sở dữ liệu dựa trên mã hoa.
         *
         * @param maHoa Mã hoa cần xóa.
         * @return true nếu xóa thành công, ngược lại false.
         */
        public boolean xoaHoa(String maHoa) {
            String sql = "DELETE FROM HOA WHERE MAHOA = ?";
            try {
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, maHoa);
                int rs = ps.executeUpdate();
                return rs > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }

        /**
         * Lấy tên hoa tương ứng với mã hoa.
         *
         * @param maHoa Mã hoa.
         * @return Tên hoa nếu tìm thấy, ngược lại trả về chuỗi rỗng.
         */
        public String getTenHoaTheoMaHoa(String maHoa) {
            String sql = "SELECT * FROM HOA WHERE MAHOA = ?";
            try {
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, maHoa);
                System.out.println("111: " + sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getString("TENHOA");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

        /**
         * Lấy mã hoa dựa theo tên hoa.
         *
         * @param tenHoa Tên hoa.
         * @return Mã hoa nếu có, ngược lại trả về chuỗi rỗng.
         */
        public String getMaHoaTheoTenHoa(String tenHoa) {
            String sql = "SELECT * FROM HOA WHERE TENHOA = ?";
            try {
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, tenHoa);
                System.out.println("111: " + sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    return rs.getString("MAHOA");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
            return "";
        }

        /**
         * Cập nhật lại số lượng hoa sau khi người dùng thêm vào giỏ hàng.
         *
         * @param maHoa Mã hoa cần cập nhật.
         * @param soLuong Số lượng mới sau khi trừ.
         * @return true nếu cập nhật thành công, ngược lại false.
         */
        public boolean capNhatSoLuongHoaSauKhiThemGioHang(String maHoa, int soLuong) {
            String sql = "UPDATE HOA SET SOLUONG = ? WHERE MAHOA = ?";
            try {
                Connection conn = getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, soLuong);
                ps.setString(2, maHoa);
                int rs = ps.executeUpdate();
                return rs > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }
