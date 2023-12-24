package entity.java;

public class ThongTinNhanSu {
    String IDNhanVien;
    String hoTen;
    String boPhan;

    public ThongTinNhanSu(String IDNhanVien, String hoTen, String boPhan) {
        this.IDNhanVien = IDNhanVien;
        this.hoTen = hoTen;
        this.boPhan = boPhan;
    }

    public String getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(String IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getBoPhan() {
        return boPhan;
    }

    public void setBoPhan(String boPhan) {
        this.boPhan = boPhan;
    }
}
