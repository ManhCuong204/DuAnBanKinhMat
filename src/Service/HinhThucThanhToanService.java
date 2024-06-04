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
import model.HinhThucThanhToan;
import repository.DBConnection;

/**
 *
 * @author Chien
 */
public class HinhThucThanhToanService {

    public List<HinhThucThanhToan> getall() {
        String sql = """
                     SELECT [Id]
                           ,[IdHoaDon]
                           ,[IdThanhToan]
                           ,[MoTa]
                           ,[TrangThai]
                           ,[NgayTao]
                           ,[NgaySua]
                           ,[NguoiTao]
                           ,[NguoiSua]
                       FROM [dbo].[HinhThucThanhToan]
                     """;
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            List<HinhThucThanhToan> list = new ArrayList<>();
            while (rs.next()) {
                HinhThucThanhToan httt = new HinhThucThanhToan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9));
                list.add(httt);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
