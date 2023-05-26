package Lab5Bai1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLyPhongHoc quanLyPhongHoc = new QuanLyPhongHoc();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Thêm phòng học");
            System.out.println("2. Tìm kiếm phòng học");
            System.out.println("3. In danh sách phòng học");
            System.out.println("4. In danh sách phòng học đạt chuẩn");
            System.out.println("5. Sắp xếp danh sách theo dãy nhà");
            System.out.println("6. Sắp xếp danh sách theo diện tích giảm dần");
            System.out.println("7. Sắp xếp danh sách theo số bóng đèn tăng dần");
            System.out.println("8. Cập nhật số máy tính cho phòng máy tính");
            System.out.println("9. Xóa phòng học");
            System.out.println("10. In tổng số phòng học");
            System.out.println("11. In danh sách các phòng máy có 60 máy");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("----- Thêm phòng học -----");
                    System.out.print("Nhập mã phòng: ");
                    String maPhong = scanner.nextLine();
                    System.out.print("Nhập dãy nhà: ");
                    String dayNha = scanner.nextLine();
                    System.out.print("Nhập diện tích: ");
                    double dienTich = scanner.nextDouble();
                    System.out.print("Nhập số bóng đèn: ");
                    int soBongDen = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Loại phòng học (1 - Lý thuyết, 2 - Máy tính, 3 - Thí nghiệm): ");
                    int loaiPhong = scanner.nextInt();
                    scanner.nextLine();

                    if (loaiPhong == 1) {
                        System.out.print("Có máy chiếu (true/false): ");
                        boolean coMayChieu = scanner.nextBoolean();
                        scanner.nextLine();
                        PhongHocLyThuyet phongLyThuyet = new PhongHocLyThuyet(maPhong, dayNha, dienTich, soBongDen, coMayChieu);
                        quanLyPhongHoc.themPhongHoc(phongLyThuyet);
                    } else if (loaiPhong == 2) {
                        System.out.print("Nhập số máy tính: ");
                        int soMayTinh = scanner.nextInt();
                        scanner.nextLine();
                        PhongMayTinh phongMayTinh = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soMayTinh);
                        quanLyPhongHoc.themPhongHoc(phongMayTinh);
                    } else if (loaiPhong == 3) {
                        System.out.print("Nhập chuyên ngành: ");
                        String chuyenNganh = scanner.nextLine();
                        System.out.print("Nhập sức chứa: ");
                        int sucChua = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Có bồn rửa (true/false): ");
                        boolean coBonRua = scanner.nextBoolean();
                        scanner.nextLine();
                        PhongThiNghiem phongThiNghiem = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua, coBonRua);
                        quanLyPhongHoc.themPhongHoc(phongThiNghiem);
                    }
                    break;

                case 2:
                    System.out.println("----- Tìm kiếm phòng học -----");
                    System.out.print("Nhập mã phòng cần tìm kiếm: ");
                    String maPhongCanTim = scanner.nextLine();
                    PhongHoc phongHocTimKiem = quanLyPhongHoc.timKiemPhongHoc(maPhongCanTim);
                    if (phongHocTimKiem != null) {
                        System.out.println("Phòng học được tìm thấy:");
                        System.out.println(phongHocTimKiem);
                    } else {
                        System.out.println("Không tìm thấy phòng học với mã phòng " + maPhongCanTim);
                    }
                    break;

                case 3:
                    System.out.println("----- In danh sách phòng học -----");
                    quanLyPhongHoc.inDanhSachPhongHoc();
                    break;

                case 4:
                    System.out.println("----- In danh sách phòng học đạt chuẩn -----");
                    quanLyPhongHoc.inPhongHocDatChuan();
                    break;

                case 5:
                    System.out.println("----- Sắp xếp danh sách theo dãy nhà -----");
                    quanLyPhongHoc.sapXepTheoDayNha();
                    quanLyPhongHoc.inDanhSachPhongHoc();
                    break;

                case 6:
                    System.out.println("----- Sắp xếp danh sách theo diện tích giảm dần -----");
                    quanLyPhongHoc.sapXepTheoDienTichGiamDan();
                    quanLyPhongHoc.inDanhSachPhongHoc();
                    break;

                case 7:
                    System.out.println("----- Sắp xếp danh sách theo số bóng đèn tăng dần -----");
                    quanLyPhongHoc.sapXepTheoSoBongDenTangDan();
                    quanLyPhongHoc.inDanhSachPhongHoc();
                    break;

                case 8:
                    System.out.println("----- Cập nhật số máy tính cho phòng máy tính -----");
                    System.out.print("Nhập mã phòng máy tính cần cập nhật: ");
                    String maPhongMayTinh = scanner.nextLine();
                    System.out.print("Nhập số máy tính mới: ");
                    int soMayTinhMoi = scanner.nextInt();
                    scanner.nextLine();
                    quanLyPhongHoc.capNhatSoMayTinh(maPhongMayTinh, soMayTinhMoi);
                    break;

                case 9:
                    System.out.println("----- Xóa phòng học -----");
                    System.out.print("Nhập mã phòng cần xóa: ");
                    String maPhongCanXoa = scanner.nextLine();
                    quanLyPhongHoc.xoaPhongHoc(maPhongCanXoa);
                    break;

                case 10:
                    System.out.println("----- In tổng số phòng học -----");
                    quanLyPhongHoc.inTongSoPhongHoc();
                    break;

                case 11:
                    System.out.println("----- In danh sách các phòng máy có 60 máy -----");
                    quanLyPhongHoc.inDanhSachPhongMayTinh60May();
                    break;

                case 0:
                    System.out.println("----- Thoát -----");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                    break;
            }

            System.out.println();
        } while (choice != 0);

        scanner.close();
    }
}
