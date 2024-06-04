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
import model.SanPhamChiTiet;
import repository.DBConnection;

/**
 *
 * @author nguyen cuong
 */
public class SanPhamCTService {

    private Connection conn;

    public SanPhamCTService() {
        try {
            this.conn = DBConnection.getConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<SanPhamChiTiet> findAll() {
        String querry = "select * from SanPhamChiTiet";
        ArrayList<SanPhamChiTiet> list = new ArrayList<>();
        try {
            PreparedStatement pr = conn.prepareStatement(querry);
            pr.execute();
            ResultSet rs = pr.getResultSet();
            while (rs.next()) {
                String stt = rs.getString("id");
                String tenSP = rs.getString("TenSanPham");
                String maCTSP = rs.getString("ma");
                int soLuong = rs.getInt("SoLuongTon");
                int giaBan = rs.getInt("Gia");
                String moTa = rs.getString("MoTa");
                String mauSac = rs.getString("MauSac");
                String kichThuoc = rs.getString("KichThuoc");
                String hang = rs.getString("Hang");
                String chatLieu = rs.getString("ChatLieu");
                SanPhamChiTiet spct = new SanPhamChiTiet(stt, tenSP, maCTSP, soLuong, giaBan, moTa, mauSac, kichThuoc, hang, chatLieu);
                list.add(spct);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Boolean add(SanPhamChiTiet spct) {
        Integer row = null;
        try {
            String sql = "insert into SanPhamChiTiet(TenSanPham,ma,SoLuongTon,Gia,MoTa,MauSac,KichThuoc,Hang,ChatLieu) values (?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, spct.getTenSP());
            ps.setString(2, spct.getMaCTSP());
            ps.setInt(3, spct.getSoLuong());
            ps.setInt(4, spct.getGiaBan());
            ps.setString(5, spct.getMoTa());
            ps.setString(6, spct.getMauSac());
            ps.setString(7, spct.getKichThuoc());
            ps.setString(8, spct.getHang());
            ps.setString(9, spct.getChatLieu());

            ps.execute();
            row = ps.getUpdateCount();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    public boolean update(SanPhamChiTiet spct, String tenSP) {
        Integer row = null;
        try {
            String sql = "update SanPhamChiTiet set tenSP = ?,MaCTSP=?,SoLuong=?,GiaBan=?,MoTa=?,MauSac=?,KichThuoc=?,Hang=?,ChatLieu=? where tenSP=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, spct.getTenSP());
            ps.setString(2, spct.getMaCTSP());
            ps.setInt(3, spct.getSoLuong());
            ps.setInt(4, spct.getGiaBan());
            ps.setString(5, spct.getMoTa());
            ps.setString(6, spct.getMauSac());
            ps.setString(7, spct.getKichThuoc());
            ps.setString(8, spct.getHang());
            ps.setString(9, spct.getChatLieu());

            ps.execute();
            row = ps.getUpdateCount();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    public Boolean xoaDanhSach(int Stt) {
        Integer row = null;
        try {
            String sql = "delete from SPCT where Stt = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Stt);
            ps.execute();
            row = ps.getUpdateCount();
            System.out.println(row);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
    }
}
