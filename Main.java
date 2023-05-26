package Lab5Bai2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 6) {
            System.out.println("----- Menu -----");
            System.out.println("1. Thêm khách hàng mới vào hàng đợi mua vé");
            System.out.println("2. Bán một vé cho khách hàng");
            System.out.println("3. Hiển thị danh sách khách hàng");
            System.out.println("4. Hủy một khách hàng ra khỏi danh sách");
            System.out.println("5. Thống kê tình hình bán vé");
            System.out.println("6. Hiển thị danh sách các ga đang chờ mua vé");
            System.out.println("7. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Nhập số CMND khách hàng: ");
                    String soCMND = scanner.nextLine();
                    System.out.print("Nhập tên khách hàng: ");
                    String tenKhachHang = scanner.nextLine();
                    System.out.print("Nhập ga đến: ");
                    String gaDen = scanner.nextLine();
                    System.out.print("Nhập giá tiền: ");
                    double giaTien = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline character
                    KhachHang khachHang = new KhachHang(soCMND, tenKhachHang, gaDen, giaTien);
                    quanLyKhachHang.themKhachHang(khachHang);
                    break;
                case 2:
                    quanLyKhachHang.banVe();
                    break;
                case 3:
                    quanLyKhachHang.hienThiDanhSachKhachHang();
                    break;
                case 4:
                    System.out.print("Nhập số CMND khách hàng cần hủy: ");
                    String cmndHuy = scanner.nextLine();
                    quanLyKhachHang.huyKhachHang(cmndHuy);
                    break;
                case 5:
                    quanLyKhachHang.thongKeTinhHinhBanVe();
                    break;
                case 6:
                    quanLyKhachHang.hienThiDanhSachGa();
                    break;
                case 7:
                    System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                    break;
            }
        }
        scanner.close();
    }
}
