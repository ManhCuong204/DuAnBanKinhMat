/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.Voucher;
import repository.VoucherRepository;

/**
 *
 * @author win11
 */
public class VoucherServiceImple implements VoucherService {

    VoucherRepository Voucherrepo = new VoucherRepository();

    @Override
    public List<Voucher> getAllVoucher() {
        return Voucherrepo.getAllVoucher();
    }

    @Override
    public String AddVoucher(Voucher vc) {
        if (Voucherrepo.AddVoucher(vc) >= 0) {
            return "Thêm Thành Công";
        }
        return "Thêm thất bại";
    }

    @Override
    public String DeleteVoucher(Voucher vc) {
        if (Voucherrepo.DeleteVoucher(vc) >= 0) {
            return "Xóa Thành Công";
        }
        return "Xóa thất bại";
    }
}
