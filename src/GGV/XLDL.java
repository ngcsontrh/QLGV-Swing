/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

import java.sql.*;
import java.util.ArrayList;
import java.util.UUID;

/**
 *
 * @author NgocSon
 */
public class XLDL {
    public Connection getConn() {
        Connection conn = null;
        String connectionString = "jdbc:sqlserver://DESKTOP-47ECO45;database=DLGV;user=sa;password=12345678;encrypt=true;trustServerCertificate=true;";
        try {
            conn = DriverManager.getConnection(connectionString);            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public ArrayList<Giangvien> getGV() {
        String sql = "SELECT * FROM tbGiangvien";
        Connection conn = getConn();
        ArrayList<Giangvien> giangViens = new ArrayList<Giangvien>();
        try {
            Statement state = conn.createStatement();
            ResultSet rs = state.executeQuery(sql);
            while(rs.next()) {
                Giangvien gv = new Giangvien(rs.getString(1), rs.getNString(2), rs.getNString(3), rs.getNString(4), rs.getInt(5));
                giangViens.add(gv);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return giangViens;
    }
    
    public void insertGV(Giangvien gv) {
        String sql = "INSERT INTO tbGiangvien (MaDD, Hoten, GT, Donvi, Soct) VALUES (?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement state = null;

        try {
            conn = getConn();
            state = conn.prepareStatement(sql);

            state.setString(1, gv.getMaDD().isEmpty() ? UUID.randomUUID().toString() : gv.getMaDD());
            state.setString(2, gv.getHoTen());  
            state.setString(3, gv.getGioiTinh());     
            state.setString(4, gv.getDonVi());
            state.setInt(5, gv.getSoCT());

            state.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (state != null) {
                    state.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
