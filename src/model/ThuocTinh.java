/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author nguyen cuong
 */
public class ThuocTinh {
    private String maThuocTinh;
    private String tenThuocTinh;

    public ThuocTinh() {
    }

    public ThuocTinh(String maThuocTinh, String tenThuocTinh) {
        this.maThuocTinh = maThuocTinh;
        this.tenThuocTinh = tenThuocTinh;
    }

    public String getMaThuocTinh() {
        return maThuocTinh;
    }

    public void setMaThuocTinh(String maThuocTinh) {
        this.maThuocTinh = maThuocTinh;
    }

    public String getTenThuocTinh() {
        return tenThuocTinh;
    }

    public void setTenThuocTinh(String tenThuocTinh) {
        this.tenThuocTinh = tenThuocTinh;
    }
    
}
