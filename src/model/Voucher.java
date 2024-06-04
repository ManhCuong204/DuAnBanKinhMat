/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author win11
 */
public class Voucher {

    private int stt;
    private String code;
    private String Ten;
    private int Min;
    private int Max;
    private int SoLuong;
    private Date NgayBD;
    private Date NgayKT;
    private String MucGiamGia;
    private String MoTa;
    private int idHoaDon;

    public Voucher() {
    }

    public Voucher(int stt, String code, String Ten, int Min, int Max, int SoLuong, Date NgayBD, Date NgayKT, String MucGiamGia, String MoTa, int idHoaDon) {
        this.stt = stt;
        this.code = code;
        this.Ten = Ten;
        this.Min = Min;
        this.Max = Max;
        this.SoLuong = SoLuong;
        this.NgayBD = NgayBD;
        this.NgayKT = NgayKT;
        this.MucGiamGia = MucGiamGia;
        this.MoTa = MoTa;
        this.idHoaDon = idHoaDon;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public int getMin() {
        return Min;
    }

    public void setMin(int Min) {
        this.Min = Min;
    }

    public int getMax() {
        return Max;
    }

    public void setMax(int Max) {
        this.Max = Max;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Date getNgayBD() {
        return NgayBD;
    }

    public void setNgayBD(Date NgayBD) {
        this.NgayBD = NgayBD;
    }

    public Date getNgayKT() {
        return NgayKT;
    }

    public void setNgayKT(Date NgayKT) {
        this.NgayKT = NgayKT;
    }

    public String getMucGiamGia() {
        return MucGiamGia;
    }

    public void setMucGiamGia(String MucGiamGia) {
        this.MucGiamGia = MucGiamGia;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Object[] LoadToRow() {
        return new Object[]{stt, code, Ten, Min, Max, SoLuong, NgayBD, NgayKT, MucGiamGia, MoTa, idHoaDon};
    }
}
