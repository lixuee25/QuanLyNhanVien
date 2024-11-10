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
public class TinhTienKara {

    float gioBatDau, gioKetThuc;

    public TinhTienKara(float gioBatDau, float gioKetThuc) {
        this.gioBatDau = gioBatDau;
        this.gioKetThuc = gioKetThuc;
    }

    public TinhTienKara() {
    }

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhap gio bat dau :");
            gioBatDau = sc.nextFloat();
        } while (gioBatDau < 12 || gioBatDau > 23);

        do {
            System.out.println("Nhap gio ket thuc :");
            gioKetThuc = sc.nextFloat();
        } while (gioKetThuc < 12 || gioKetThuc > 23);
    }

    public void tinh() {
        float tongTien = 0;
        float tongGio = gioKetThuc - gioBatDau;
        if (tongGio <= 3) {
            tongTien = tongGio * 150000;
        }
        System.out.println(gioBatDau);
        System.out.println(gioKetThuc);
        System.out.println("tong tien :" + tongTien);
    }

    public static void main(String[] args) {
        TinhTienKara tt1 = new TinhTienKara();
        tt1.nhap();
        tt1.tinh();
    }
}
