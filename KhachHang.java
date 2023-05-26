package Lab5Bai2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class KhachHang {
    private String soCMND;
    private String tenKhachHang;
    private String gaDen;
    private double giaTien;

    public KhachHang(String soCMND, String tenKhachHang, String gaDen, double giaTien) {
        this.soCMND = soCMND;
        this.tenKhachHang = tenKhachHang;
        this.gaDen = gaDen;
        this.giaTien = giaTien;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public String getGaDen() {
        return gaDen;
    }

    public double getGiaTien() {
        return giaTien;
    }

    @Override
    public String toString() {
        return "Khách hàng - Số CMND: " + soCMND + ", Tên khách hàng: " + tenKhachHang + ", Ga đến: " + gaDen + ", Giá tiền: " + giaTien;
    }
}