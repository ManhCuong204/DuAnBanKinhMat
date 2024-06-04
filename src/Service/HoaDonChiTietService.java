/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import model.HoaDonChiTiet;
import repository.DBConnection;

/**
 *
 * @author Chien
 */
public class HoaDonChiTietService {

    public List<HoaDonChiTiet> getAll() {
        String sql = """
SELECT 
                         HoaDonChiTiet.Id AS HoaDonChiTietId,
                         HoaDonChiTiet.IdHoaDon,
                         HoaDonChiTiet.IdSanPhamChiTiet,
                         HoaDonChiTiet.SoLuong,
                         HoaDonChiTiet.GiaTien,
                         SanPhamChiTiet.TenSanPham,
                         HoaDon.TongTien
                     FROM 
                         HoaDonChiTiet
                     INNER JOIN 
                         SanPhamChiTiet ON HoaDonChiTiet.IdSanPhamChiTiet = SanPhamChiTiet.Id
                     INNER JOIN 
                         HoaDon ON HoaDonChiTiet.IdHoaDon = HoaDon.Id;
                     """;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonChiTiet> list = new ArrayList<>();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
                list.add(hdct);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public List<HoaDonChiTiet> getAll(Integer id) {
//        String sql = """
//SELECT 
//                         HoaDonChiTiet.Id AS HoaDonChiTietId,
//                         HoaDonChiTiet.IdHoaDon,
//                         HoaDonChiTiet.IdSanPhamChiTiet,
//                         HoaDonChiTiet.SoLuong,
//                         HoaDonChiTiet.GiaTien,
//                         SanPhamChiTiet.TenSanPham,
//                         HoaDon.TongTien
//                     FROM 
//                         HoaDonChiTiet
//                     INNER JOIN 
//                         SanPhamChiTiet ON HoaDonChiTiet.IdSanPhamChiTiet = SanPhamChiTiet.Id
//                     INNER JOIN 
//                         HoaDon ON HoaDonChiTiet.IdHoaDon = HoaDon.Id;
//                     """;
//        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
//            ResultSet rs = ps.executeQuery();
//            List<HoaDonChiTiet> list = new ArrayList<>();
//            while (rs.next()) {
//                HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
//                list.add(hdct);
//            }
//            return list;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public boolean addListOrder(String hoaDonID, List<HoaDonChiTiet> lists) {
        String query = """
                       INSERT INTO WS_FA22_BL1.dbo.hoa_don_chi_tiet
                       (hoa_don_id, san_pham_id, so_luong, don_gia)
                       VALUES(?,?,?,?);
                       """;

        int[] arr = {};
        try (Connection con = DBConnection.getConnection(); // mở kết nối đến DB
                 PreparedStatement ps = (con != null) ? con.prepareStatement(query) : null;) {
            if (ps != null) {
                for (HoaDonChiTiet hoaDonChiTiet : lists) {
                    ps.setObject(1, hoaDonChiTiet.getId());
                    ps.setObject(2, hoaDonChiTiet.getTenSanPham());
                    ps.setObject(3, hoaDonChiTiet.getSoLuong());
                    ps.setObject(4, hoaDonChiTiet.getGiaTien());
                    //batch update
                    ps.addBatch();
                }
                arr = ps.executeBatch();
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return arr.length > 0;
    }
}
