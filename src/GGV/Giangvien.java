/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GGV;

/**
 *
 * @author NgocSon
 */
public class Giangvien extends Person {
    private String donVi;
    private Integer soCT;

    public Giangvien(String maDD, String hoTen, String gioiTinh, String donVi, Integer soCT) {
        super(maDD, hoTen, gioiTinh);
        this.donVi = donVi;
        this.soCT = soCT;
    }

    public Giangvien() {
        super();
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Integer getSoCT() {
        return soCT;
    }

    public void setSoCT(Integer soCT) {
        this.soCT = soCT;
    }

    @Override
    public String Xetthuong() {
        return soCT > 10 ? "Khen thưởng" : "";
    }
    
}
