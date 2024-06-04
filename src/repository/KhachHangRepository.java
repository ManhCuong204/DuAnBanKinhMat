/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import model.KhachHang;
import java.sql.*;

/**
 *
 * @author win11
 */
public class KhachHangRepository {

    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> listKH = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT [Id], [HoTen], [SoDienThoai], [GioiTinh], [TrangThai], [ThanhPho], [Duong], [Email] FROM [dbo].[KhachHang]";
            conn = DBConnection.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(rs.getInt("Id"));
                khachHang.setHoTen(rs.getString("HoTen"));
                khachHang.setSdt(rs.getInt("SoDienThoai"));
                khachHang.setGioiTinh(rs.getString("GioiTinh"));
                khachHang.setTrangThai(rs.getString("TrangThai"));
                khachHang.setThanhPho(rs.getString("ThanhPho"));
                khachHang.setDuong(rs.getString("Duong"));
                khachHang.setEmailKH(rs.getString("Email"));

                listKH.add(khachHang);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông báo lỗi để dễ dàng theo dõi
        } finally {
            closeResources(rs, sttm, conn);
        }

        return listKH;
    }

    private void closeResources(ResultSet rs, Statement sttm, Connection conn) {
        try {
            if (rs != null) {
                rs.close();
            }
            if (sttm != null) {
                sttm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int AddKhachHang(KhachHang khachHang) {
        Connection conn = null;
        PreparedStatement sttm = null;

        try {
            String sSQL = "INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [GioiTinh], [TrangThai], [ThanhPho], [Duong], [Email]) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            conn = DBConnection.getConnection();
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, khachHang.getHoTen());
            sttm.setInt(2, khachHang.getSdt());
            sttm.setString(3, khachHang.getGioiTinh());
            sttm.setString(4, khachHang.getTrangThai());
            sttm.setString(5, khachHang.getThanhPho());
            sttm.setString(6, khachHang.getDuong());
            sttm.setString(7, khachHang.getEmailKH());

            return sttm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            closeResources(null, sttm, conn);
        }
    }

    public int DeleteKhachHang(KhachHang kh) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "DELETE FROM [dbo].[KhachHang] WHERE id = ?";
            conn = DBConnection.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, kh.getId());

            return sttm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error executing delete query: " + e.getMessage());
        } finally {
            try {
                if (sttm != null) {
                    sttm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
        return -1;
    }

    public KhachHang searchKhachHang(KhachHang khachHangToSearch) {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;

        try {
            String sSQL = "SELECT * FROM [dbo].[KhachHang] WHERE TrangThai = ?";
            conn = DBConnection.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, khachHangToSearch.getTrangThai());

            rs = sttm.executeQuery();

            if (rs.next()) {
                // Tạo và trả về đối tượng KhachHang từ dữ liệu trả về từ truy vấn
                return new KhachHang(
                        rs.getInt("Id"),
                        rs.getString("HoTen"),
                        rs.getInt("Sdt"),
                        rs.getString("GioiTinh"),
                        rs.getString("TrangThai"),
                        rs.getString("ThanhPho"),
                        rs.getString("Duong"),
                        rs.getString("Email")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error executing search query: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (sttm != null) {
                    sttm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }

        return null; // Trả về null nếu không tìm thấy
    }

    public int updateKhachHang(KhachHang khachHang) {
        Connection conn = null;
        PreparedStatement sttm = null;

        try {
            // Thêm điều kiện WHERE để cập nhật dữ liệu dựa trên Id
            String sSQL = "UPDATE [dbo].[KhachHang] SET HoTen=?, SoDienThoai=?, GioiTinh=?, TrangThai=?, ThanhPho=?, Duong=?, Email=? WHERE Id=?";
            conn = DBConnection.getConnection();
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, khachHang.getHoTen());
            sttm.setInt(2, khachHang.getSdt());
            sttm.setString(3, khachHang.getGioiTinh());
            sttm.setString(4, khachHang.getTrangThai());
            sttm.setString(5, khachHang.getThanhPho());
            sttm.setString(6, khachHang.getDuong());
            sttm.setString(7, khachHang.getEmailKH());
            sttm.setInt(8, khachHang.getId());

            return sttm.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error executing update query: " + e.getMessage());
            return -1; // Hoặc mã lỗi khác tùy thuộc vào yêu cầu của bạn
        } finally {
            closeResources(null, sttm, conn);
        }
    }
}
