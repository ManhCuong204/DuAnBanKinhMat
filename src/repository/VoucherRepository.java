/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import java.util.List;
import model.Voucher;
import java.sql.*;

/**
 *
 * @author win11
 */
public class VoucherRepository {

    public List<Voucher> getAllVoucher() {
        List<Voucher> listVC = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT [Id], [Code], [Ten], [GiaTriMin], [GiaTriMax], [SoLuong], [NgayBatDau], [NgayKetThuc], "
                    + "[MucGiamGia], [MoTa], [idHoaDon] FROM [dbo].[Voucher]";
            conn = DBConnection.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Voucher voucher = new Voucher();
                voucher.setStt(rs.getInt("Id"));
                voucher.setCode(rs.getString("Code"));
                voucher.setTen(rs.getString("Ten"));
                voucher.setMin(rs.getInt("GiaTriMin"));
                voucher.setMax(rs.getInt("GiaTriMax"));
                voucher.setSoLuong(rs.getInt("SoLuong"));
                voucher.setNgayBD(rs.getDate("NgayBatDau"));
                voucher.setNgayKT(rs.getDate("NgayKetThuc"));
                voucher.setMucGiamGia(rs.getString("MucGiamGia"));
                voucher.setMoTa(rs.getString("MoTa"));
                voucher.setIdHoaDon(rs.getInt("idHoaDon"));

                listVC.add(voucher);
            }
        } catch (Exception e) {
            e.printStackTrace(); // In ra thông báo lỗi để dễ dàng theo dõi
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
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return listVC;
    }

    public int AddVoucher(Voucher voucher) {
        Connection conn = null;
        PreparedStatement sttm = null;

        try {
            String sSQL = "INSERT INTO [dbo].[Voucher] (Code, Ten, GiaTriMin, GiaTriMax, SoLuong, NgayBatDau, NgayKetThuc, NgayTao, NgaySua, MucGiamGia, MoTa) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            conn = DBConnection.getConnection();
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, voucher.getCode());
            sttm.setString(2, voucher.getTen());
            sttm.setInt(3, voucher.getMin());
            sttm.setInt(4, voucher.getMax());
            sttm.setInt(5, voucher.getSoLuong());
            sttm.setDate(6, new java.sql.Date(voucher.getNgayBD().getTime()));
            sttm.setDate(7, new java.sql.Date(voucher.getNgayKT().getTime()));
            sttm.setString(8, voucher.getMucGiamGia());
            sttm.setString(9, voucher.getMoTa());

            return sttm.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        } finally {
            try {
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
    }

    public int DeleteVoucher(Voucher vc) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "DELETE FROM [dbo].[Voucher] WHERE id = ?";
            conn = DBConnection.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, vc.getStt());

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

    public Voucher SearchVoucher(Voucher voucherToSearch) {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;

        try {
            String sSQL = "SELECT * FROM [dbo].[Voucher] WHERE Code = ?";
            conn = DBConnection.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, voucherToSearch.getCode());

            rs = sttm.executeQuery();

            if (rs.next()) {
                // Tạo và trả về đối tượng Voucher từ dữ liệu trả về từ truy vấn
                return new Voucher(
                        rs.getInt("Id"),
                        rs.getString("Code"),
                        rs.getString("Ten"),
                        rs.getInt("GiaTriMin"),
                        rs.getInt("GiaTriMax"),
                        rs.getInt("SoLuong"),
                        rs.getDate("NgayBatDau"),
                        rs.getDate("NgayKetThuc"),
                        rs.getString("MucGiamGia"),
                        rs.getString("MoTa"),
                        rs.getInt("idHoaDon")
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
    
}
