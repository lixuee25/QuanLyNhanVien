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
public class TruongPhong extends NhanVien {

    private double luongTrachNhiem;

    public TruongPhong() {
    }

    public TruongPhong(double luongTrachNhiem, String maNV, String hoTen, double luong) {
        super(maNV, hoTen, luong);
        this.luongTrachNhiem = luongTrachNhiem;
    }

    public double getLuongTrachNhiem() {
        return luongTrachNhiem;
    }

    public void setLuongTrachNhiem(double luongTrachNhiem) {
        this.luongTrachNhiem = luongTrachNhiem;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap luong trach nhiem :");
        setLuongTrachNhiem(sc.nextDouble());
    }

    public double tongLuong() {
        return this.getLuong() + this.getLuongTrachNhiem();
    }

    @Override
    public void xuatThongTin() {
        System.out.println("Ma nhan vien :" + getMaNV() + " - Ho ten :" + getHoTen() + " - Luong :" + getLuong()
                + "- Tong luong :" + tongLuong() + " - Luong trach nhiem :" + getLuongTrachNhiem());
        System.out.println("Thue thu nhap :" + getThueThuNhap(tongLuong()) + " - Thu nhap :" + getThuNhap(tongLuong()));
    }
}
