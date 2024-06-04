/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nguyen cuong
 */
public class SanPhamChiTiet {

    private String stt;
    private String tenSP;
    private String maCTSP;
    private int soLuong;
    private int giaBan;
    private String moTa;
    private String mauSac;
    private String kichThuoc;
    private String hang;
    private String chatLieu;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(String tenSP, String maCTSP, int soLuong, int giaBan, String moTa, String mauSac, String kichThuoc, String hang, String chatLieu) {
        this.tenSP = tenSP;
        this.maCTSP = maCTSP;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.mauSac = mauSac;
        this.kichThuoc = kichThuoc;
        this.hang = hang;
        this.chatLieu = chatLieu;
    }

    public SanPhamChiTiet(String stt, String tenSP, String maCTSP, int soLuong, int giaBan, String moTa, String mauSac, String kichThuoc, String hang, String chatLieu) {
        this.stt = stt;
        this.tenSP = tenSP;
        this.maCTSP = maCTSP;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.mauSac = mauSac;
        this.kichThuoc = kichThuoc;
        this.hang = hang;
        this.chatLieu = chatLieu;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(int giaBan) {
        this.giaBan = giaBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getKichThuoc() {
        return kichThuoc;
    }

    public void setKichThuoc(String kichThuoc) {
        this.kichThuoc = kichThuoc;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getChatLieu() {
        return chatLieu;
    }

    public void setChatLieu(String chatLieu) {
        this.chatLieu = chatLieu;
    }

}
