/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.List;
import model.KhachHang;

/**
 *
 * @author win11
 */
public interface KhachHangService {

    List<KhachHang> getAllKhachHang();

    String AddKhachHang(KhachHang kh);

    String DeleteKhachHang(KhachHang kh);
}
