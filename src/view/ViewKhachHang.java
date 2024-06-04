/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Service.KhachHangService;
import Service.KhachHangServiceImple;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import repository.KhachHangRepository;

/**
 *
 * @author win11
 */
public class ViewKhachHang extends javax.swing.JFrame {

    private KhachHangService serviceKH = new KhachHangServiceImple();
    private List<KhachHang> listKH;
    private DefaultTableModel tableModel;

    /**
     * Creates new form ViewKhachHang
     */
    public ViewKhachHang() {
        initComponents();
        setLocationRelativeTo(null);

        // Kiểm tra null trước khi sử dụng serviceKH và tblKhachHangDL
        if (serviceKH != null && tblKhachHang != null) {
            listKH = serviceKH.getAllKhachHang();
            tableModel = (DefaultTableModel) tblKhachHang.getModel();
            fillToTable(listKH);
        } else {
            System.out.println("serviceKH or tblKhachHangDL is null");
        }
    }

    public void fillToTable(List<KhachHang> list) {
        String[] cols = {"Id", "Họ tên", "Số điện thoại", "Giới tính", "Trạng thái", "Thành phố", "Đường", "Email"};
        tableModel.setColumnIdentifiers(cols);
        tableModel.setRowCount(0);

        for (KhachHang kh : list) {
            tableModel.addRow(new Object[]{
                kh.getId(),
                kh.getHoTen(),
                kh.getSdt(),
                kh.getGioiTinh(),
                kh.getTrangThai(),
                kh.getThanhPho(),
                kh.getDuong(),
                kh.getEmailKH()
            });
        }
    }

    public void fillToForm(int indexxx) {
        KhachHang kh = listKH.get(indexxx);
        txtIdKH.setText(String.valueOf(kh.getId()));
        txtHoTen.setText(kh.getHoTen());
        txtSdt.setText(String.valueOf(kh.getSdt()));
        txtTrangThai.setText(kh.getTrangThai());
        txtThanhPho.setText(kh.getThanhPho());
        txtDuong.setText(kh.getDuong());
        txtEmail.setText(kh.getEmailKH());
        if (kh.getGioiTinh().equals("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
    }

    public KhachHang getKhachHang() {
        try {
            // Kiểm tra dữ liệu không được để trống
            if (txtHoTen.getText().isEmpty() || txtSdt.getText().isEmpty()
                    || txtTrangThai.getText().isEmpty() || txtThanhPho.getText().isEmpty()
                    || txtDuong.getText().isEmpty() || txtEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin.");
                return null;
            }
            if (!rdoNam.isSelected() && !rdoNu.isSelected()) {
                JOptionPane.showMessageDialog(this, "Bạn phải chọn giới tính.");
                return null;
            }

            // Kiểm tra định dạng số cho số điện thoại
            int sdt;
            try {
                sdt = Integer.parseInt(txtSdt.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Nhập giá trị số không hợp lệ.");
                return null;
            }

            // Kiểm tra định dạng email
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            if (!txtEmail.getText().matches(emailRegex)) {
                JOptionPane.showMessageDialog(this, "Định dạng email không hợp lệ.");
                return null;
            }

            String gioiTinh = rdoNam.isSelected() ? "Nam" : "Nữ";

            // Tạo đối tượng KhachHang
            int id = (txtIdKH.getText().isEmpty()) ? 0 : Integer.parseInt(txtIdKH.getText());
            KhachHang kh = new KhachHang(
                    id,
                    txtHoTen.getText(),
                    sdt,
                    gioiTinh,
                    txtTrangThai.getText(),
                    txtThanhPho.getText(),
                    txtDuong.getText(),
                    txtEmail.getText()
            );

            return kh;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nhập giá trị số không hợp lệ.");
            return null;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtIdKH = new javax.swing.JTextField();
        txtHoTen = new javax.swing.JTextField();
        txtSdt = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtThanhPho = new javax.swing.JTextField();
        txtDuong = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        txtTrangThai = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtSearchKH = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(880, 620));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel8.setText("Thiết lập thông tin khách hàng");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel9.setText("Mã khách hàng:");

        jLabel10.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel10.setText("Họ tên:");

        jLabel11.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel11.setText("Số điện thoại:");

        jLabel12.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel12.setText("Giới tính:");

        jLabel13.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel13.setText("Trạng thái:");

        txtIdKH.setEditable(false);

        buttonGroup1.add(rdoNam);
        rdoNam.setText("Nam");

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        jLabel14.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel14.setText("Đường:");

        jLabel15.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel15.setText("Thành phố:");

        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnUpdate.setText("Sửa");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel18.setText("Email:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel13)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtIdKH)
                    .addComponent(txtHoTen)
                    .addComponent(txtSdt, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(txtTrangThai))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel15)
                        .addComponent(jLabel14))
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdoNam)
                        .addGap(18, 18, 18)
                        .addComponent(rdoNu)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEmail)
                            .addComponent(txtDuong)
                            .addComponent(txtThanhPho, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addGap(18, 18, 18)
                                .addComponent(btnUpdate))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnMoi)))
                        .addGap(111, 111, 111))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtIdKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(txtSdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtDuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnAdd)
                                    .addComponent(btnUpdate))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnXoa)
                                    .addComponent(btnMoi)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15)
                                .addComponent(txtThanhPho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(rdoNam)
                    .addComponent(rdoNu))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel16.setFont(new java.awt.Font("Serif", 1, 14)); // NOI18N
        jLabel16.setText("Tìm kiếm:");

        txtSearchKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKHKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(txtSearchKH, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtSearchKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 625, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách khách hàng", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        listKH = serviceKH.getAllKhachHang();
        fillToTable(listKH);
    }//GEN-LAST:event_formWindowActivated

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showOptionDialog(
                this,
                "Do you want to add?",
                "Confirmation",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                null,
                null
        );

        // Kiểm tra lựa chọn
        if (choice == JOptionPane.YES_OPTION) {
            KhachHang kh = getKhachHang();

            // Kiểm tra null trước khi thêm
            if (kh == null) {
                JOptionPane.showMessageDialog(this, "Vui lòng điền thông tin hợp lệ.");
            } else {
                // Thực hiện thêm và hiển thị thông báo kết quả
                int result = Integer.parseInt(serviceKH.AddKhachHang(kh));
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công.");
                    fillToForm(kh);
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm không thành công. Thử lại sau.");
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
        txtDuong.setText("");
        txtEmail.setText("");
        txtHoTen.setText("");
        txtIdKH.setText("");
        txtSdt.setText("");
        txtThanhPho.setText("");
        txtTrangThai.setText("");
        rdoNam.setSelected(true);
        fillToTable(listKH);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int choice = JOptionPane.showConfirmDialog(this, "Do you want to remove", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            int index = -1;
            index = tblKhachHang.getSelectedRow();
            if (index < 0) {
                JOptionPane.showMessageDialog(this, "Bạn phải chọn dòng muốn xóa");
            } else {
                KhachHang kh = listKH.get(index);
                JOptionPane.showMessageDialog(this, serviceKH.DeleteKhachHang(kh));
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        KhachHang updatedKhachHang = getKhachHang();
        if (updatedKhachHang != null) {
            KhachHangRepository khachHangRepository = new KhachHangRepository();
            int result = khachHangRepository.updateKhachHang(updatedKhachHang);

            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật thành công!!");
                System.out.println("KhachHang updated successfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật thất bại!!");
                System.out.println("Failed to update KhachHang.");
            }
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        // TODO add your handling code here:
        int index = tblKhachHang.getSelectedRow();

        // Kiểm tra xem có dữ liệu trong bảng không
        if (index != -1) {
            // Gọi phương thức fillToForm chỉ khi có dữ liệu
            fillToForm(index);
        } else {
            // Xử lý khi không có dòng nào được chọn
            System.out.println("No row selected.");
        }
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void txtSearchKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKHKeyReleased
        // TODO add your handling code here:
        // TODO add your handling code here:
        String chucVuToSearch = txtSearchKH.getText().trim(); // Lấy giá trị từ TextField và loại bỏ khoảng trắng

        // Kiểm tra nếu chuỗi tìm kiếm không rỗng
        if (!chucVuToSearch.isEmpty()) {
            DefaultTableModel tblModel = (DefaultTableModel) tblKhachHang.getModel();
            tblModel.setRowCount(0); // Xóa dữ liệu cũ trên bảng

            // Lặp qua danh sách nhân viên và hiển thị những nhân viên thỏa mãn điều kiện tìm kiếm
            for (KhachHang khachHang : listKH) {
                // Kiểm tra nếu chucVu của NhanVien chứa chuỗi tìm kiếm (không phân biệt hoa thường)
                if (khachHang.getTrangThai().toLowerCase().contains(chucVuToSearch.toLowerCase())) {
                    // Thêm dòng mới với thông tin của NhanVien tìm được
                    Object[] rowData = {
                        khachHang.getId(),
                        khachHang.getHoTen(),
                        khachHang.getSdt(),
                        khachHang.getGioiTinh(),
                        khachHang.getTrangThai(),
                        khachHang.getThanhPho(),
                        khachHang.getDuong(),
                        khachHang.getEmailKH()
                    };
                    tblModel.addRow(rowData);
                }
            }

            // Cập nhật model cho bảng
            tblKhachHang.setModel(tblModel);
        } else {
            // Nếu chuỗi tìm kiếm rỗng, có thể thực hiện các hành động khác tùy thuộc vào yêu cầu của bạn
            // ở đây là in thông báo ra console
            fillToTable(listKH);
            System.out.println("Please enter a value to search.");
        }
    }//GEN-LAST:event_txtSearchKHKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewKhachHang.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnXoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDuong;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtIdKH;
    private javax.swing.JTextField txtSdt;
    private javax.swing.JTextField txtSearchKH;
    private javax.swing.JTextField txtThanhPho;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables
    public void fillToForm(KhachHang khachHang) {
        DefaultTableModel tblModel = (DefaultTableModel) tblKhachHang.getModel();
        tblModel.setRowCount(0); // Xóa dữ liệu cũ trên bảng

        // Thêm dòng mới với thông tin của NhanVien
        Object[] rowData = {
            khachHang.getId(),
            khachHang.getHoTen(),
            khachHang.getSdt(),
            khachHang.getGioiTinh(),
            khachHang.getTrangThai(),
            khachHang.getThanhPho(),
            khachHang.getDuong(),
            khachHang.getEmailKH()
        };

        tblModel.addRow(rowData);
        txtIdKH.setText(String.valueOf(khachHang.getId()));
        txtHoTen.setText(khachHang.getHoTen());
        txtSdt.setText(String.valueOf(khachHang.getSdt()));
        txtTrangThai.setText(khachHang.getTrangThai());
        txtThanhPho.setText(khachHang.getThanhPho());
        txtDuong.setText(khachHang.getDuong());
        txtEmail.setText(khachHang.getEmailKH());
        if (khachHang.getGioiTinh().equals("Nam")) {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        // Cập nhật model cho bảng
        tblKhachHang.setModel(tblModel);
    }
}