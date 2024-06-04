/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.SanPham;
import repository.DBConnection;

/**
 *
 * @author nguyen cuong
 */
public class SanPhamService {

    private Connection conn;

    public SanPhamService() {
        try {
            this.conn = DBConnection.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SanPham> findAll() {
        String querry = "select * from SanPham";
        ArrayList<SanPham> sp = new ArrayList<>();
        try {
            PreparedStatement pr = conn.prepareStatement(querry);
            pr.execute();
            ResultSet rs = pr.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("id");
                String ma = rs.getString("ma");
                String ngayTao = rs.getString("NgayTao");
                String ngaySua = rs.getString("NgaySua");
                String trangThai = rs.getString("TrangThai");
                SanPham sanpham = new SanPham(id, ma, ngayTao, ngaySua, trangThai);
                sp.add(sanpham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sp;
    }

//    public Boolean add(SanPham sp) {
//        Integer row = null;
//        try {
//            String sql = "insert into SanPham(ma,NgayTao,NgaySua,TrangThai) values (?,?,?,?)";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, sp.getMa());
//            ps.setString(2, sp.getNgayTao());
//            ps.setString(3, sp.getNgaySua());
//            ps.setString(4, sp.getTrangThai());
//
//            ps.execute();
//            row = ps.getUpdateCount();
//            System.out.println(row);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return row > 0;
//    }
    public Boolean add(SanPham sp) {
        try {
            // Kiểm tra xem sản phẩm đã tồn tại hay chưa
            if (!isSanPhamExisted(sp.getMa())) {
                String sql = "insert into SanPham(ma, NgayTao, NgaySua, TrangThai) values (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, sp.getMa());
                ps.setString(2, sp.getNgayTao());
                ps.setString(3, sp.getNgaySua());
                ps.setString(4, sp.getTrangThai());

                ps.execute();
                int row = ps.getUpdateCount();
                System.out.println(row);
                return row > 0;
            } else {
                System.out.println("Sản phẩm đã tồn tại trong cơ sở dữ liệu. Không thể thêm mới.");
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

// Hàm kiểm tra xem sản phẩm có tồn tại hay không
    private boolean isSanPhamExisted(String maSanPham) {
        try {
            String sql = "SELECT ma FROM SanPham WHERE ma = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, maSanPham);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Trả về true nếu có kết quả (sản phẩm tồn tại), ngược lại false
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(SanPham sp, String ma) {
        try {
            String sql = "UPDATE SanPham SET ma=?, NgayTao=?, NgaySua=?, TrangThai=? WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, sp.getMa());
            ps.setString(2, sp.getNgayTao());
            ps.setString(3, sp.getNgaySua());
            ps.setString(4, sp.getTrangThai());
            ps.setString(5, ma); // Thêm tham số để xác định dòng cần cập nhật

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            // Đóng PreparedStatement ở đây nếu cần thiết
        }
    }

    public Boolean xoaDanhSach(int id) {
        Integer row = null;
        try {
            String sql = "delete from SanPham where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            row = ps.getUpdateCount();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
    }
}
