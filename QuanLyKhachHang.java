package Lab5Bai2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class QuanLyKhachHang {
    private List<KhachHang> danhSachKhachHang;
    private Map<String, Integer> danhSachGa;

    public QuanLyKhachHang() {
        danhSachKhachHang = new ArrayList<>();
        danhSachGa = new HashMap<>();
    }

    public void themKhachHang(KhachHang khachHang) {
        if (!danhSachKhachHang.contains(khachHang)) {
            danhSachKhachHang.add(khachHang);
            danhSachGa.put(khachHang.getGaDen(), danhSachGa.getOrDefault(khachHang.getGaDen(), 0) + 1);
            System.out.println("Thêm khách hàng thành công!");
        } else {
            System.out.println("Số CMND đã tồn tại! Không thể thêm khách hàng.");
        }
    }

    public void banVe() {
        if (danhSachKhachHang.isEmpty()) {
            System.out.println("Danh sách khách hàng trống. Không thể bán vé.");
        } else {
            KhachHang khachHang = danhSachKhachHang.remove(0);
            danhSachGa.put(khachHang.getGaDen(), danhSachGa.get(khachHang.getGaDen()) - 1);
            System.out.println("Bán vé thành công cho khách hàng: " + khachHang.getTenKhachHang());
        }
    }

    public void hienThiDanhSachKhachHang() {
        System.out.println("----- Danh sách khách hàng -----");
        for (KhachHang khachHang : danhSachKhachHang) {
            System.out.println(khachHang);
        }
        System.out.println("---------------------------------");
    }

    public void huyKhachHang(String soCMND) {
        KhachHang khachHangToRemove = null;
        for (KhachHang khachHang : danhSachKhachHang) {
            if (khachHang.getSoCMND().equals(soCMND)) {
                khachHangToRemove = khachHang;
                break;
            }
        }
        if (khachHangToRemove != null) {
            danhSachKhachHang.remove(khachHangToRemove);
            danhSachGa.put(khachHangToRemove.getGaDen(), danhSachGa.get(khachHangToRemove.getGaDen()) - 1);
            System.out.println("Hủy khách hàng thành công!");
        } else {
            System.out.println("Khách hàng không tồn tại trong danh sách.");
        }
    }

    public void thongKeTinhHinhBanVe() {
        System.out.println("----- Thống kê tình hình bán vé -----");
        System.out.println("Số khách hàng đang chờ nhận vé: " + danhSachKhachHang.size());
        System.out.println("Tình hình bán vé theo ga đến:");
        for (Map.Entry<String, Integer> entry : danhSachGa.entrySet()) {
            System.out.println("Ga " + entry.getKey() + ": " + entry.getValue() + " vé");
        }
        System.out.println("--------------------------------------");
    }

    public void hienThiDanhSachGa() {
        System.out.println("----- Danh sách các ga đang chờ mua vé -----");
        for (String gaDen : danhSachGa.keySet()) {
            System.out.println("Ga " + gaDen);
        }
        System.out.println("--------------------------------------------");
    }
}