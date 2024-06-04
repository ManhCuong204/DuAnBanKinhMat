/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author win11
 */
public class NhanVien {

    private int id;
    private String Email;
    private String TrangThai;
    private String DiaChi;
    private String TenNV;
    private int TuoiNV;
    private int Sdt;
    private String ChucVu;

    public NhanVien() {
    }

    public NhanVien(int id, String Email, String TrangThai, String DiaChi, String TenNV, int TuoiNV, int Sdt, String ChucVu) {
        this.id = id;
        this.Email = Email;
        this.TrangThai = TrangThai;
        this.DiaChi = DiaChi;
        this.TenNV = TenNV;
        this.TuoiNV = TuoiNV;
        this.Sdt = Sdt;
        this.ChucVu = ChucVu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public int getTuoiNV() {
        return TuoiNV;
    }

    public void setTuoiNV(int TuoiNV) {
        this.TuoiNV = TuoiNV;
    }

    public int getSdt() {
        return Sdt;
    }

    public void setSdt(int Sdt) {
        this.Sdt = Sdt;
    }

    public String getChucVu() {
        return ChucVu;
    }

    public void setChucVu(String ChucVu) {
        this.ChucVu = ChucVu;
    }

    public Object[] LoadToRowNV() {
        return new Object[]{id, Email, TrangThai, DiaChi, TenNV, TuoiNV, Sdt, ChucVu};
    }
}
