/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

import java.util.Scanner;

/**
 *
 * @author lelie
 */
public class NhanVien {

    private String maNV;
    private String hoTen;
    private double luong;

    public NhanVien() {
    }

    public NhanVien(String maNV, String hoTen, double luong) {
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.luong = luong;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public void nhapThongTin() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ma nhan vien :");
        setMaNV(sc.next());
        System.out.println("Nhap ho ten :");
        sc = new Scanner(System.in);
        setHoTen(sc.nextLine());
        System.out.println("Nhap luong :");
        setLuong(sc.nextDouble());
    }

    public double getThueThuNhap(double x) {
        double tax;
        if (x < 9000) {
            tax = 0;
        } else if (x >= 9000 && x <= 15000) {
            tax = (x - 9000) * 0.1;
        } else {
            tax = (x - 15000) * 0.12 + 6000 * 0.1;
        }
        return tax;
    }

    public double getThuNhap(double x) {
        return x - getThueThuNhap(x);
    }

    public double tongLuong() {
        return this.getLuong();
    }

    public void xuatThongTin() {
        System.out.println("Ma nhan vien :" + getMaNV() + " - Ho ten :" + getHoTen() + " - Luong :" + getLuong()
                + " - Tong luong :" + tongLuong()
                + " - Thue thu nhap :" + getThueThuNhap(tongLuong()) + " - Thu nhap :" + getThuNhap(tongLuong()));
    }

}
