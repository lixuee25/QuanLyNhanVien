/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1;

import java.util.Scanner;

/**
 *
 * @author lelie
 */
public class Bai1 {

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        Scanner sc = new Scanner(System.in);
        int luaChon = 0;
        System.out.println("-------------Menu-------------");
        System.out.println("1.Tinh tien dien cho quan karaoke.");
        System.out.println("2.Tinh tien dien.");
        System.out.println("3.Doi tien.");
        System.out.println("4.Tinh lai suat vay ngan hang vay tra gop.");
        System.out.println("5.Vay tien mua xe.");
        System.out.println("0.Thoat.");
        System.out.println("Nhap vao lua chon :");
        luaChon = sc.nextInt();
        switch (luaChon) {
            case 1:
                tinhTienKaraoke();
                break;
            case 2:
                tinhTienDien();
                break;
            case 3:
                doiTien();
                break;
            case 4:
                tinhLaiSuatNganHang();
                break;
            case 5:
                vayTienMuaXe();
                break;
            default:
                System.exit(0);
                break;
        }
    }

    public static void tinhTienKaraoke() {
        double gioBatDau, gioKetThuc;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Nhap gio bat dau :");
            gioBatDau = sc.nextFloat();
        } while (gioBatDau < 12 || gioBatDau > 23);

        do {
            System.out.println("Nhap gio ket thuc :");
            gioKetThuc = sc.nextFloat();
        } while (gioKetThuc < 12 || gioKetThuc > 23);

        double tongTien = 0;
        double tongGio = gioKetThuc - gioBatDau;
        if (tongGio <= 3) {
            tongTien = tongGio * 150000;
        } else {
            //so tien chua khuyen mai - so tien khuyen mai(tu 4h)
            tongTien = (tongGio * 150000 - ((tongGio - 3) * 0.3 * 150000));
        }
        if (gioBatDau >= 14 && gioBatDau <= 17) {
            tongTien = tongTien - (tongTien * 0.1);
        }
        System.out.println("tong tien :" + tongTien);
        menu();
    }

    public static int check(int a) {
        //chia tung bac gia tien với 50kWh
        if (a == 1) {//0 - 50
            return 1678;
        }
        if (a == 2) {//50 - 100
            return 1734;
        }
        if (a == 3 || a == 4) {//100 - 150 hoac 150 - 200
            return 2014;
        }
        if (a == 5 || a == 6) {//200 - 250 hoac 250 - 300
            return 2536;
        }
        if (a == 7 || a == 8) {//300 - 350 hoac 350 - 400
            return 2834;
        }
        return 2927;//400 tro len
    }

    public static void tinhTienDien() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhap so dien su dung :");
        n = sc.nextInt();

        //tinh tien dien o moc cuoi
        int k = n / 50;
        int m = n % 50;
        int soTien = m * check(k + 1);

        for (int i = 1; i <= k; i++) {
            soTien = soTien + 50 * check(i);
        }
        float sum = (float) (soTien + (soTien * 0.1));// tongtien = tiendiensd + thue(10% tiendiensd)
        System.out.println("Tong tien dien phai tra :" + sum);
        menu();
    }

    public static void doiTien() {
        Scanner sc = new Scanner(System.in);
        int soTien;
        int soToTien;
        int a[] = {500, 200, 100, 50, 20, 10, 5, 2, 1};

        do {
            System.out.println("Nhap so tien can doi :");
            soTien = sc.nextInt();
        } while (soTien <= 0);

        for (int i = 0; i < a.length; i++) {
            if (i == 0) {
                continue;
            }
            soToTien = soTien / a[i];
            if (soToTien != 0) {
                System.out.println("Co " + soToTien + " to " + a[i]);
            }
            soTien = soTien - soToTien * a[i];
        }
        menu();
    }

    public static void tinhLaiSuatNganHang() {
        Scanner sc = new Scanner(System.in);
        double soTien, gocPhaiTra, laiPhaiTra, soTienPhaiTra;
        System.out.println("Nhap so tien vay :");
        soTien = sc.nextDouble();
        gocPhaiTra = soTien / 12;
        System.out.print("Ky han\tLai phai tra\tGoc phai tra\tSo tien phai tra\tSo tien con lai\n");
        for (int i = 1; i <= 12; i++) {
            laiPhaiTra = soTien * 0.05;
            soTienPhaiTra = gocPhaiTra + laiPhaiTra;
            soTien = soTien - gocPhaiTra;
            System.out.printf("%d\t%.0f\t\t%.0f\t\t%.0f\t\t\t%.0f\n", i, laiPhaiTra, gocPhaiTra, soTienPhaiTra, soTien);
        }
        menu();
    }

    public static void vayTienMuaXe() {
        Scanner sc = new Scanner(System.in);
        double phanTramTraGop, phanTramTraTruoc, soTienTraTruoc;
        double soTienVay = 50000000;
        System.out.println("Nhap vao so phan tram vay toi da (tra gop) :");
        phanTramTraGop = sc.nextDouble();
        phanTramTraTruoc = 100 - phanTramTraGop;
        phanTramTraTruoc = phanTramTraTruoc / 100;
        soTienTraTruoc = soTienVay * phanTramTraTruoc;
        soTienVay = soTienVay - soTienTraTruoc;
        System.out.printf("So tien phai tra lan dau : %.0f ", soTienTraTruoc);
        System.out.println();

        double gocHangThang, laiHangThang, soTienPhaiTraHangThang;
        gocHangThang = soTienVay / 288;
        System.out.print("Ky han\tLai tra hang thang"
                + "\tGoc tra hang thang\tSo tien phai tra hang thang\tSo tien con lai\n");
        for (int i = 1; i <= 288; i++) {
            laiHangThang = soTienVay * 0.006;
            soTienPhaiTraHangThang = gocHangThang + laiHangThang;
            soTienVay = soTienVay - gocHangThang;
            System.out.printf("%d\t%.0f\t\t\t%.0f\t\t\t%.0f\t\t\t\t%.0f\n",
                     i, laiHangThang, gocHangThang, soTienPhaiTraHangThang, soTienVay);
        }
    }
}
