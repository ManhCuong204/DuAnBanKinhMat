/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import java.sql.*;

/**
 *
 * @author win11
 */
public class NhanVienRepository {

    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> listNV = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT [Id], [Email], [TrangThai], [DiaChi], [TenNV], [Tuoi], [Sdt], [ChucVu] FROM [dbo].[NhanVien]";
            conn = DBConnection.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getInt("Id"));
                nhanVien.setEmail(rs.getString("Email"));
                nhanVien.setTrangThai(rs.getString("TrangThai"));
                nhanVien.setDiaChi(rs.getString("DiaChi"));
                nhanVien.setTenNV(rs.getString("TenNV"));
                nhanVien.setTuoiNV(rs.getInt("Tuoi"));
                nhanVien.setSdt(rs.getInt("Sdt"));
                nhanVien.setChucVu(rs.getString("ChucVu"));

                listNV.add(nhanVien);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // In ra thông báo lỗi để dễ dàng theo dõi
        } finally {
            closeResources(rs, sttm, conn);
        }

        return listNV;
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

    public int AddNhanVien(NhanVien nhanVien) {
        Connection conn = null;
        PreparedStatement sttm = null;

        try {
            String sSQL = "INSERT INTO [dbo].[NhanVien] ([Email], [TrangThai], [DiaChi], [TenNV], [Tuoi], [Sdt], [ChucVu]) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            conn = DBConnection.getConnection();
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, nhanVien.getEmail());
            sttm.setString(2, nhanVien.getTrangThai());
            sttm.setString(3, nhanVien.getDiaChi());
            sttm.setString(4, nhanVien.getTenNV());
            sttm.setInt(5, nhanVien.getTuoiNV());
            sttm.setInt(6, nhanVien.getSdt());
            sttm.setString(7, nhanVien.getChucVu());

            return sttm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            closeResources(null, sttm, conn);
        }
    }

    public int DeleteNhanVien(NhanVien nv) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "DELETE FROM [dbo].[NhanVien] WHERE id = ?";
            conn = DBConnection.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, nv.getId());

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

    public NhanVien SearchNhanVien(NhanVien nhanVienToSearch) {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;

        try {
            String sSQL = "SELECT * FROM [dbo].[NhanVien] WHERE TrangThai = ?";
            conn = DBConnection.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, nhanVienToSearch.getTrangThai());

            rs = sttm.executeQuery();

            if (rs.next()) {
                // Tạo và trả về đối tượng NhanVien từ dữ liệu trả về từ truy vấn
                return new NhanVien(
                        rs.getInt("Id"),
                        rs.getString("Email"),
                        rs.getString("TrangThai"),
                        rs.getString("DiaChi"),
                        rs.getString("TenNV"),
                        rs.getInt("Tuoi"),
                        rs.getInt("Sdt"),
                        rs.getString("ChucVu")
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

public int updateNhanVien(NhanVien nhanVien) {
    Connection conn = null;
    PreparedStatement sttm = null;

    try {
        // Thêm điều kiện WHERE để cập nhật dữ liệu dựa trên Email (hoặc bạn có thể chọn một trường khác)
        String sSQL = "UPDATE [dbo].[NhanVien] SET TrangThai=?, DiaChi=?, TenNV=?, Tuoi=?, Sdt=?, ChucVu=? WHERE Email=?";
        conn = DBConnection.getConnection();
        sttm = conn.prepareStatement(sSQL);

        sttm.setString(1, nhanVien.getTrangThai());
        sttm.setString(2, nhanVien.getDiaChi());
        sttm.setString(3, nhanVien.getTenNV());
        sttm.setInt(4, nhanVien.getTuoiNV());
        sttm.setInt(5, nhanVien.getSdt());
        sttm.setString(6, nhanVien.getChucVu());
        sttm.setString(7, nhanVien.getEmail());

        return sttm.executeUpdate();
    } catch (SQLException e) {
        System.out.println("Error executing update query: " + e.getMessage());
        return -1; // Hoặc mã lỗi khác tùy thuộc vào yêu cầu của bạn
    } finally {
        closeResources(null, sttm, conn);
    }
}
}
