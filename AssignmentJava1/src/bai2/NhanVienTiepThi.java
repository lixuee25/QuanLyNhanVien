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
public class NhanVienTiepThi extends NhanVien {

    private double doanhSoBanHang, hueHong;

    public NhanVienTiepThi() {
    }

    public NhanVienTiepThi(double doanhSoBanHang, double hueHong, String maNV, String hoTen, double luong) {
        super(maNV, hoTen, luong);
        this.doanhSoBanHang = doanhSoBanHang;
        this.hueHong = hueHong;
    }

    public double getDoanhSoBanHang() {
        return doanhSoBanHang;
    }

    public void setDoanhSoBanHang(double doanhSoBanHang) {
        this.doanhSoBanHang = doanhSoBanHang;
    }

    public double getHueHong() {
        return hueHong;
    }

    public void setHueHong(double hueHong) {
        this.hueHong = hueHong;
    }

    @Override
    public void nhapThongTin() {
        super.nhapThongTin();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap doanh so ban hang :");
        setDoanhSoBanHang(sc.nextDouble());
        System.out.println("Nhap hue hong :");
        setHueHong(sc.nextDouble());
    }

    public double tongLuong() {
        return this.getLuong() + (this.getDoanhSoBanHang() * this.getHueHong()) / 100;
    }

    @Override
    public void xuatThongTin() {
        System.out.println("Ma nhan vien :" + getMaNV() + " - Ho ten :" + getHoTen() + " - Luong :" + getLuong()
                + " - Tong luong :" + tongLuong() + " - Doanh so ban hang :" + getDoanhSoBanHang() + " - Hue hong :" + getHueHong());
        System.out.println("Thue thu nhap :" + getThueThuNhap(tongLuong())
                + " - Thu nhap :" + getThuNhap(tongLuong()));
    }
}
