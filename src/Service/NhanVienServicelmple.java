/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.NhanVien;
import repository.NhanVienRepository;

/**
 *
 * @author win11
 */
public class NhanVienServicelmple implements NhanVienService {

    NhanVienRepository NhanVienrepo = new NhanVienRepository();

    @Override
    public List<NhanVien> getAllNhanVien() {
        return NhanVienrepo.getAllNhanVien();
    }

    @Override
    public String AddNhanVien(NhanVien nv) {
        if (NhanVienrepo.AddNhanVien(nv) >= 0) {
            return "Thêm Thành Công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String DeleteNhanVien(NhanVien nv) {
        if (NhanVienrepo.DeleteNhanVien(nv) >= 0) {
            return "Xóa Thành Công";
        }
        return "Xóa thất bại";
    }
}
