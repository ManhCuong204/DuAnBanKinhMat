/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.KhachHang;
import repository.KhachHangRepository;

/**
 *
 * @author win11
 */
public class KhachHangServiceImple implements KhachHangService {

    KhachHangRepository KhachHangrepo = new KhachHangRepository();

    @Override
    public List<KhachHang> getAllKhachHang() {
        return KhachHangrepo.getAllKhachHang();
    }

    @Override
    public String AddKhachHang(KhachHang kh) {
        int result = KhachHangrepo.AddKhachHang(kh);

        if (result > 0) {
            return "Thêm Thành Công";
        } else {
            return "Thêm thất bại";
        }
    }

    @Override
    public String DeleteKhachHang(KhachHang kh) {
        if (KhachHangrepo.DeleteKhachHang(kh) >= 0) {
            return "Xóa Thành Công";
        }
        return "Xóa thất bại";
    }
}
