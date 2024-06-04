/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Chien
 */
public class HoaDon {

    private Integer id;
    private String idNhanVien;
    private String idKhachHang;
    private String diaChi;
    private String tongTien;
    private String ngayXacNhan;
    private String ngayDat;
    private String tinhTrang;
    private Date ngayTao;
    private String nguoiNhan;
    private String Sdt;

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", idNhanVien=" + idNhanVien + ", idKhachHang=" + idKhachHang + ", diaChi=" + diaChi + ", tongTien=" + tongTien + ", ngayXacNhan=" + ngayXacNhan + ", ngayDat=" + ngayDat + ", tinhTrang=" + tinhTrang + '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(String idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getTongTien() {
        return tongTien;
    }

    public void setTongTien(String tongTien) {
        this.tongTien = tongTien;
    }

    public String getNgayXacNhan() {
        return ngayXacNhan;
    }

    public void setNgayXacNhan(String ngayXacNhan) {
        this.ngayXacNhan = ngayXacNhan;
    }

    public String getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(String ngayDat) {
        this.ngayDat = ngayDat;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.tinhTrang = TinhTrang;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String NguoiNhan) {
        this.nguoiNhan = NguoiNhan;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String Sdt) {
        this.Sdt = Sdt;
    }

    public HoaDon(Integer id, String idNhanVien, String idKhachHang, String diaChi, String tongTien, String ngayXacNhan, String ngayDat, String tinhTrang, Date ngayTao, String nguoiNhan, String Sdt) {
        this.id = id;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.diaChi = diaChi;
        this.tongTien = tongTien;
        this.ngayXacNhan = ngayXacNhan;
        this.ngayDat = ngayDat;
        this.tinhTrang = tinhTrang;
        this.ngayTao = ngayTao;
        this.nguoiNhan = nguoiNhan;
        this.Sdt = Sdt;
    }

    public HoaDon(String diaChi, String nguoiNhan, String Sdt) {
        this.diaChi = diaChi;
        this.nguoiNhan = nguoiNhan;
        this.Sdt = Sdt;
    }

    public HoaDon(Integer id, String idNhanVien, String idKhachHang, String tongTien, String tinhTrang, Date ngayTao) {
        this.id = id;
        this.idNhanVien = idNhanVien;
        this.idKhachHang = idKhachHang;
        this.tongTien = tongTien;
        this.tinhTrang = tinhTrang;
        this.ngayTao = ngayTao;
    }

    public HoaDon() {
    }

    public Object[] toDataRow() {
        return new Object[]{ngayTao, nguoiNhan};
    }

}
