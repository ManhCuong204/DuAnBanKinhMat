/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Chien
 */
public class HoaDonChiTiet {

    private String id;
    private String idHoaDon;
    private String idSanPhamChiTiet;
    private String tenSanPham;
    private int soLuong;
    private double giaTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(String id, String idHoaDon, String idSanPhamChiTiet, int soLuong, double giaTien, String tenSanPham) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idSanPhamChiTiet = idSanPhamChiTiet;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.tenSanPham = tenSanPham;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(String idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public String getIdSanPhamChiTiet() {
        return idSanPhamChiTiet;
    }

    public void setIdSanPhamChiTiet(String idSanPhamChiTiet) {
        this.idSanPhamChiTiet = idSanPhamChiTiet;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    @Override
    public String toString() {
        return "HoaDonChiTiet{" + "id=" + id + ", idHoaDon=" + idHoaDon + ", idSanPhamChiTiet=" + idSanPhamChiTiet + ", soLuong=" + soLuong + ", giaTien=" + giaTien + '}';
    }

    public double thanhTien() {
        return soLuong * giaTien;
    }

    public Object[] toDataRow() {
        return new Object[]{tenSanPham, soLuong, giaTien, thanhTien()};
    }

}
