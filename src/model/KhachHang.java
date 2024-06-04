/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author win11
 */
public class KhachHang {

    private int id;
    private String HoTen;
    private int Sdt;
    private String GioiTinh;
    private String TrangThai;
    private String ThanhPho;
    private String Duong;
    private String EmailKH;

    public KhachHang() {
    }

    public KhachHang(int id, String HoTen, int Sdt, String GioiTinh, String TrangThai, String ThanhPho, String Duong, String EmailKH) {
        this.id = id;
        this.HoTen = HoTen;
        this.Sdt = Sdt;
        this.GioiTinh = GioiTinh;
        this.TrangThai = TrangThai;
        this.ThanhPho = ThanhPho;
        this.Duong = Duong;
        this.EmailKH = EmailKH;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public int getSdt() {
        return Sdt;
    }

    public void setSdt(int Sdt) {
        this.Sdt = Sdt;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getThanhPho() {
        return ThanhPho;
    }

    public void setThanhPho(String ThanhPho) {
        this.ThanhPho = ThanhPho;
    }

    public String getDuong() {
        return Duong;
    }

    public void setDuong(String Duong) {
        this.Duong = Duong;
    }

    public String getEmailKH() {
        return EmailKH;
    }

    public void setEmailKH(String EmailKH) {
        this.EmailKH = EmailKH;
    }

    public Object[] LoadToRowKH() {
        return new Object[]{id, HoTen, Sdt, GioiTinh, TrangThai, ThanhPho, Duong, EmailKH};
    }
}
