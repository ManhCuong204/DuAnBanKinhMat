/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Chien
 */
public class HinhThucThanhToan {
    private String id;
    private String idHoaDon;
    private String idThanhToan;
    private String moTa;
    private String trangThai;
    private String ngayTao;
    private String ngaySua;
    private String nguoiTao;
    private String nguoiSua;

    public HinhThucThanhToan() {
    }

    public HinhThucThanhToan(String id, String idHoaDon, String idThanhToan, String moTa, String trangThai, String ngayTao, String ngaySua, String nguoiTao, String nguoiSua) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idThanhToan = idThanhToan;
        this.moTa = moTa;
        this.trangThai = trangThai;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.nguoiTao = nguoiTao;
        this.nguoiSua = nguoiSua;
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

    public String getIdThanhToan() {
        return idThanhToan;
    }

    public void setIdThanhToan(String idThanhToan) {
        this.idThanhToan = idThanhToan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(String ngaySua) {
        this.ngaySua = ngaySua;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getNguoiSua() {
        return nguoiSua;
    }

    public void setNguoiSua(String nguoiSua) {
        this.nguoiSua = nguoiSua;
    }

    @Override
    public String toString() {
        return "HinhThucThanhToan{" + "id=" + id + ", idHoaDon=" + idHoaDon + ", idThanhToan=" + idThanhToan + ", moTa=" + moTa + ", trangThai=" + trangThai + ", ngayTao=" + ngayTao + ", ngaySua=" + ngaySua + ", nguoiTao=" + nguoiTao + ", nguoiSua=" + nguoiSua + '}';
    }
    
    
}
