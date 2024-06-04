/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.HoaDon;
import repository.DBConnection;

/**
 *
 * @author Chien
 */
public class HoaDonService {

    public List<HoaDon> getall() {
        String sql = """
                 SELECT [Id]
                 ,[NgayDat]
                  ,[NgayXacNhan]
                   ,[TongTien]
                       ,[IdKhachHang]
                       ,[IdNhanVien]
                       ,[DiaChi]
                       ,[TinhTrang]
                       ,[NgayTao]
                       ,[NguoiNhan]
                    ,[Sdt]
                   FROM [dbo].[HoaDon]
                 """;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDon> list = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getString(11));
                list.add(hd);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList(); // Trả về danh sách trống nếu có lỗi
    }

    public boolean delete(Integer id) {
        String sql = """
                     DELETE FROM [dbo].[HoaDon]
                           WHERE id = ?;
                     """;
        int check = 0;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<HoaDon> findCTT() {
        String sql = """
                     SELECT [Id]
                                          ,[NgayDat]
                                           ,[NgayXacNhan]
                                            ,[TongTien]
                                                ,[IdKhachHang]
                                                ,[IdNhanVien]
                                                ,[DiaChi]
                                                ,[Ngaytao]
                                                ,[NguoiNhan]
                                                ,[Sdt]
                                            FROM [dbo].[HoaDon] where  DiaChi = N'Chưa thanh toán';
                     """;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            List<HoaDon> searchTT = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getString(11));
                searchTT.add(hd);
            }
            return searchTT;
        } catch (Exception e) {
        }
        return null;
    }

    public List<HoaDon> findDTT() {
        String sql = """
                     SELECT [Id]
                                          ,[NgayDat]
                                           ,[NgayXacNhan]
                                            ,[TongTien]
                                                ,[IdKhachHang]
                                                ,[IdNhanVien]
                                                ,[DiaChi]
                                                ,[NgayTao]
                                                ,[NguoiNhan]
                                                ,[Sdt]
                                            FROM [dbo].[HoaDon] where  DiaChi = N'Đã thanh toán';
                     """;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();
            List<HoaDon> searchTT = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getString(11));
                searchTT.add(hd);
            }
            return searchTT;
        } catch (Exception e) {
        }
        return null;
    }

    public List<HoaDon> findById(String id) {
        String sql = """
                     SELECT [Id]
                                          ,[NgayDat]
                                           ,[NgayXacNhan]
                                            ,[TongTien]
                                                ,[IdKhachHang]
                                                ,[IdNhanVien]
                                                ,[DiaChi]
                                                ,[NgayTao]
                                                ,[NguoiNhan]
                                                ,[Sdt]
                                            FROM [dbo].[HoaDon] where  Id = ?;
                     """;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            List<HoaDon> searchId = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getString(11));
                searchId.add(hd);
            }
            return searchId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<HoaDon> findByNgay(String ngayXacNhan) {
        String sql = """
                     SELECT [Id]
                                          ,[NgayDat]
                                           ,[NgayXacNhan]
                                            ,[TongTien]
                                                ,[IdKhachHang]
                                                ,[IdNhanVien]
                                                ,[DiaChi]
                                                ,[NgayTao]
                                                ,[NguoiNhan]
                                                ,[Sdt]
                                            FROM [dbo].[HoaDon] where NgayXacNhan  = ?;
                     """;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, ngayXacNhan);
            ResultSet rs = ps.executeQuery();
            List<HoaDon> searchId = new ArrayList<>();
            while (rs.next()) {
                HoaDon hd = new HoaDon(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getDate(9), rs.getString(10), rs.getString(11));
                searchId.add(hd);
            }
            return searchId;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addHoaDon(HoaDon hoaDon) {
        int check = 0;
        String query = """
               INSERT INTO [dbo].[HoaDon]
                           ([IdKhachHang]
                           ,[IdNhanVien]
                           ,[Sdt]
                           ,[DiaChi]
                           ,[TongTien]
                           ,[NgayTao]
                           ,[TinhTrang])
                    VALUES
                           (?,?,?,?,?,?,?);
               """;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(query);) {
            ps.setObject(1, hoaDon.getIdKhachHang());
            ps.setObject(2, hoaDon.getIdNhanVien());
            ps.setObject(3, hoaDon.getSdt());
            ps.setObject(4, hoaDon.getDiaChi());
            ps.setObject(5, hoaDon.getTongTien());
            ps.setObject(6, hoaDon.getNgayTao());
            ps.setObject(7, hoaDon.getTinhTrang());

            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public static void main(String[] args) {
        List<HoaDon> lists = new HoaDonService().findById("2");
        for (HoaDon list : lists) {
            System.out.println(list.toString());
        }
    }
}
