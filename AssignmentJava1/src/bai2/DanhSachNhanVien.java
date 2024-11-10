/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author lelie
 */
public class DanhSachNhanVien {

    static ArrayList<NhanVien> dsnv = new ArrayList<>();

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        int loai = 1;
        NhanVien nv = null;
        do {
            System.out.println("------------ Lua chon loai nhan vien ------------");
            System.out.println("1.Nhan vien hanh chinh.");
            System.out.println("2.Nhan vien tiep thi.");
            System.out.println("3.Truong phong.");
            System.out.println("----------------------------------------------------");
            System.out.println("Nhap lua chon loai nhan vien:");
            loai = sc.nextInt();
            switch (loai) {
                case 1:
                    nv = new NhanVienHanhChinh();
                    break;
                case 2:
                    nv = new NhanVienTiepThi();
                    break;
                case 3:
                    nv = new TruongPhong();
                    break;
                default:
                    nhap();
                    break;
            }
            nv.nhapThongTin();
            dsnv.add(nv);
            System.out.println("Ban co muon tiep tuc ?(y/n)");
            choice = sc.next();
        } while (choice.equalsIgnoreCase("y"));
    }

    public void xuat() {
        for (NhanVien nv : dsnv) {
            nv.xuatThongTin();
        }
    }

    public int timNhanVienTheoMa(String maNV) {
        for (int i = 0; i < dsnv.size(); i++) {
            NhanVien nv = dsnv.get(i);
            if (nv.getMaNV().equalsIgnoreCase(maNV)) {
                System.out.println("Da tim thay nhan vien tai vi tri :" + i);
                nv.xuatThongTin();
                return i;
            }
        }
        return -1;
    }

    public void xoaTheoMa(String maNV) {
        int viTri = timNhanVienTheoMa(maNV);
        if (viTri < 0) {
            System.out.println("Khong tim thay");
        } else {
            dsnv.remove(viTri);
            System.out.println("Da xoa thanh cong nhan vien " + viTri);
        }
    }

    public void capNhatTheoMa(String maNV) {
        int pos = timNhanVienTheoMa(maNV);
        if (pos < 0) {
            System.out.println("Khong tim thay ma nhan vien " + maNV);
        } else {
            NhanVien nvMoi = dsnv.get(pos);
            nvMoi.nhapThongTin();
            dsnv.set(pos, nvMoi);
            System.out.println("Cap nhat thanh cong ");
        }
    }

    public void timTheoKhoangLuong(double max, double min) {
        boolean found = false;
        for (NhanVien nv : dsnv) {
            if (nv.tongLuong() >= min && nv.tongLuong() <= max) {
                found = true;
                nv.xuatThongTin();
            }
        }
        if (found == false) {
            System.out.println("Khong co nhan vien co luong trong khoang can tim");
        }
    }

    public static String layTen(String hoTen) {
        String ten = hoTen.substring(hoTen.lastIndexOf(" ") + 1);
        return ten;
    }

    public void sapXepTheoTen() {
        for (int i = 0; i < dsnv.size() - 1; i++) {
            for (int j = i + 1; j < dsnv.size(); j++) {
                if (layTen(dsnv.get(i).getHoTen()).compareTo(layTen(dsnv.get(j).getHoTen())) > 0) {
                    Collections.swap(dsnv, i, j);
                }
            }

        }
    }

    public void sapXepTheoTN() {
        for (int i = 0; i < dsnv.size() - 1; i++) {
            for (int j = i + 1; j < dsnv.size(); j++) {
                NhanVien nvi = dsnv.get(i);
                NhanVien nvj = dsnv.get(j);
                if (nvi.getThuNhap(nvi.tongLuong()) < nvj.getThuNhap(nvj.tongLuong())) {
                    Collections.swap(dsnv, i, j);
                }
            }
        }
    }

    public void hienThiTop5TN() {
        sapXepTheoTN();
        int top = 5;
        if (dsnv.size() < 5) {
            top = dsnv.size();
        }
        for (int i = 0; i < top; i++) {
            NhanVien nv = dsnv.get(i);
            nv.xuatThongTin();
        }
    }
}
