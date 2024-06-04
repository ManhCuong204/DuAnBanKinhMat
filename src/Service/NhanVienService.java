/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.List;
import model.NhanVien;

/**
 *
 * @author win11
 */
public interface NhanVienService {

    List<NhanVien> getAllNhanVien();

    String AddNhanVien(NhanVien nv);

    String DeleteNhanVien(NhanVien nv);
}
