/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Service;

import java.util.List;
import model.Voucher;

/**
 *
 * @author win11
 */
public interface VoucherService {

    List<Voucher> getAllVoucher();

    String AddVoucher(Voucher vc);

    String DeleteVoucher(Voucher vc);

}
