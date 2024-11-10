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
public class Test {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        DanhSachNhanVien dsnv = new DanhSachNhanVien();
        int luaChon = 0;
        do {
            System.out.println("-------------Menu-------------");
            System.out.println("1.Nhap danh sach nhan vien.");
            System.out.println("2.Xuat danh sach nhan vien.");
            System.out.println("3.Tim va hien thi nhan vien theo ma.");
            System.out.println("4.Xoa nhan vien theo ma.");
            System.out.println("5.Cap nhat thong tin nhan vien theo ma.");
            System.out.println("6.Tim cac nhan vien theo khoang luong.");
            System.out.println("7.Sap xep nhan vien theo ho ten.");
            System.out.println("8.Sap xep nhan vien theo thu nhap.");
            System.out.println("9.Xuat 5 nhan vien co thu nhap cao nhat.");
            System.out.println("0.Thoat.");
            System.out.println("Nhap vao lua chon :");
            luaChon = sc.nextInt();
            switch (luaChon) {
                case 1:
                    dsnv.nhap();
                    break;
                case 2:
                    dsnv.xuat();
                    break;
                case 3:
                    System.out.println("Nhap ma nhan vien can tim:");
                    String maTim = sc.next();
                    int vitri = dsnv.timNhanVienTheoMa(maTim);
                    if (vitri < 0) {
                        System.out.println("Khong tim thay");
                    }
                    break;
                case 4:
                    System.out.println("Nhap ma nhan vien can xoa :");
                    String maXoa = sc.next();
                    dsnv.xoaTheoMa(maXoa);
                    break;
                case 5:
                    System.out.println("Cap nhat thong tin nhan vien theo ma :");
                    System.out.println("Nhap ma nhan vien can cap nhat:");
                    String maCapNhat = sc.next();
                    dsnv.capNhatTheoMa(maCapNhat);
                    break;
                case 6:
                    System.out.println("Tim nhan vien theo khoang luong :");
                    System.out.println("Nhap khoang luong min:");
                    double min = sc.nextDouble();
                    System.out.println("Nhap khoang luong max:");
                    double max = sc.nextDouble();
                    dsnv.timTheoKhoangLuong(max, min);
                    break;
                case 7:
                    System.out.println("Sap xep nhan vien theo ho ten :");
                    dsnv.sapXepTheoTen();
                    dsnv.xuat();
                    break;
                case 8:
                    System.out.println("Sap xep nhan vien theo thu nhap :");
                    dsnv.sapXepTheoTN();
                    dsnv.xuat();
                    break;
                case 9:
                    System.out.println("Xuat 5 nhan vien co thu nhap cao nhat :");
                    dsnv.hienThiTop5TN();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Nhap khong hop le .Vui long nhap lai !!");
                    menu();
                    break;
            }
        } while (true);
    }
}
