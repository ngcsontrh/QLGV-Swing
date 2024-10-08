/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NgocSon
 */
public class GUI extends JFrame{
    private JTable table;
    private XLDL xl;
    private JTextField txtMaDD, txtHoTen, txtDonVi, txtSoCT;
    private JComboBox<String> cbGioiTinh;

    public GUI() {
        xl = new XLDL();
        setTitle("Quản lý giảng viên");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ArrayList<Giangvien> dsGV = xl.getGV();
        String[] columns = {"Mã định danh", "Họ tên", "Giới tính", "Đơn vị", "Số CT", "Khen thưởng"};
        String[][] data = new String[dsGV.size()][6];
        
        for (int i = 0; i < dsGV.size(); i++) {
            Giangvien gv = dsGV.get(i);
            data[i][0] = gv.getMaDD();
            data[i][1] = gv.getHoTen();
            data[i][2] = gv.getGioiTinh();
            data[i][3] = gv.getDonVi();
            data[i][4] = gv.getSoCT().toString();
            data[i][5] = gv.Xetthuong();
        }
        
        table = new JTable(data, columns);
        JScrollPane sp = new JScrollPane(table);
        
        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        
        inputPanel.add(new JLabel("Mã định danh:"));
        txtMaDD = new JTextField();
        inputPanel.add(txtMaDD);
        
        inputPanel.add(new JLabel("Họ tên:"));
        txtHoTen = new JTextField();
        inputPanel.add(txtHoTen);
        
        inputPanel.add(new JLabel("Giới tính:"));
        cbGioiTinh = new JComboBox<>(new String[]{"Nam", "Nữ"});
        inputPanel.add(cbGioiTinh);
        
        inputPanel.add(new JLabel("Đơn vị:"));
        txtDonVi = new JTextField();
        inputPanel.add(txtDonVi);
        
        inputPanel.add(new JLabel("Số CT:"));
        txtSoCT = new JTextField();
        inputPanel.add(txtSoCT);
        
        JButton btnAdd = new JButton("Thêm giảng viên");
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Thêm giảng viên vào DB
                String maDD = txtMaDD.getText();
                String hoTen = txtHoTen.getText();
                String gioiTinh = (String) cbGioiTinh.getSelectedItem();
                String donVi = txtDonVi.getText();
                int soCT = Integer.parseInt(txtSoCT.getText());
                
                xl.insertGV(new Giangvien(maDD, hoTen, gioiTinh, donVi, soCT));
                updateTable();
                
                txtMaDD.setText("");
                txtHoTen.setText("");
                txtDonVi.setText("");
                txtSoCT.setText("");
                cbGioiTinh.setSelectedIndex(0);
            }
        });
        
        setLayout(new BorderLayout());
        add(sp, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.NORTH);
        add(btnAdd, BorderLayout.SOUTH);

        setVisible(true);
    }
    
    private void updateTable() {
        ArrayList<Giangvien> dsGV = xl.getGV();
        String[][] data = new String[dsGV.size()][6];
        
        for (int i = 0; i < dsGV.size(); i++) {
            Giangvien gv = dsGV.get(i);
            data[i][0] = gv.getMaDD();
            data[i][1] = gv.getHoTen();
            data[i][2] = gv.getGioiTinh();
            data[i][3] = gv.getDonVi();
            data[i][4] = gv.getSoCT().toString();
            data[i][5] = gv.Xetthuong();
        }
        
        // Cập nhật dữ liệu trong bảng
        table.setModel(new DefaultTableModel(data, new String[]{"Mã định danh", "Họ tên", "Giới tính", "Đơn vị", "Số CT", "Khen thưởng"}));
    }
}
