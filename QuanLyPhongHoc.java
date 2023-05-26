package Lab5Bai1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class QuanLyPhongHoc {
    private List<PhongHoc> danhSachPhongHoc;

    public QuanLyPhongHoc() {
        danhSachPhongHoc = new ArrayList<>();
    }

    public void themPhongHoc(PhongHoc phongHoc) {
        if (!danhSachPhongHoc.contains(phongHoc)) {
            danhSachPhongHoc.add(phongHoc);
            System.out.println("Thêm phòng học thành công!");
        } else {
            System.out.println("Mã phòng học đã tồn tại. Không thể thêm!");
        }
    }

    public PhongHoc timKiemPhongHoc(String maPhong) {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc.getMaPhong().equals(maPhong)) {
                return phongHoc;
            }
        }
        return null;
    }

    public void inDanhSachPhongHoc() {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            System.out.println(phongHoc);
        }
    }

    public void inPhongHocDatChuan() {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc instanceof PhongHocLyThuyet) {
                PhongHocLyThuyet phongLyThuyet = (PhongHocLyThuyet) phongHoc;
                if (phongLyThuyet.isCoMayChieu()) {
                    System.out.println(phongHoc);
                }
            } else if (phongHoc instanceof PhongMayTinh) {
                PhongMayTinh phongMayTinh = (PhongMayTinh) phongHoc;
                if (phongMayTinh.getDienTich() / phongMayTinh.getSoMayTinh() >= 1.5) {
                    System.out.println(phongHoc);
                }
            } else if (phongHoc instanceof PhongThiNghiem) {
                PhongThiNghiem phongThiNghiem = (PhongThiNghiem) phongHoc;
                if (phongThiNghiem.isCoBonRua()) {
                    System.out.println(phongHoc);
                }
            }
        }
    }

    public void sapXepTheoDayNha() {
        Collections.sort(danhSachPhongHoc, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc phongHoc1, PhongHoc phongHoc2) {
                return phongHoc1.getDayNha().compareTo(phongHoc2.getDayNha());
            }
        });
    }

    public void sapXepTheoDienTichGiamDan() {
        Collections.sort(danhSachPhongHoc, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc phongHoc1, PhongHoc phongHoc2) {
                return Double.compare(phongHoc2.getDienTich(), phongHoc1.getDienTich());
            }
        });
    }

    public void sapXepTheoSoBongDenTangDan() {
        Collections.sort(danhSachPhongHoc, new Comparator<PhongHoc>() {
            @Override
            public int compare(PhongHoc phongHoc1, PhongHoc phongHoc2) {
                return Integer.compare(phongHoc1.getSoBongDen(), phongHoc2.getSoBongDen());
            }
        });
    }

    public void capNhatSoMayTinh(String maPhong, int soMayTinhMoi) {
        PhongHoc phongHoc = timKiemPhongHoc(maPhong);
        if (phongHoc instanceof PhongMayTinh) {
            PhongMayTinh phongMayTinh = (PhongMayTinh) phongHoc;
            phongMayTinh.setSoMayTinh(soMayTinhMoi);
            System.out.println("Cập nhật số máy tính thành công!");
        } else {
            System.out.println("Phòng học không phải là phòng máy tính. Không thể cập nhật số máy tính!");
        }
    }

    public void xoaPhongHoc(String maPhong) {
        PhongHoc phongHoc = timKiemPhongHoc(maPhong);
        if (phongHoc != null) {
            danhSachPhongHoc.remove(phongHoc);
            System.out.println("Xóa phòng học thành công!");
        } else {
            System.out.println("Không tìm thấy phòng học với mã phòng " + maPhong + ". Không thể xóa!");
        }
    }

    public void inTongSoPhongHoc() {
        System.out.println("Tổng số phòng học: " + danhSachPhongHoc.size());
    }

    public void inDanhSachPhongMayTinh60May() {
        for (PhongHoc phongHoc : danhSachPhongHoc) {
            if (phongHoc instanceof PhongMayTinh) {
                PhongMayTinh phongMayTinh = (PhongMayTinh) phongHoc;
                if (phongMayTinh.getSoMayTinh() == 60) {
                    System.out.println(phongHoc);
                }
            }
        }
    }
}