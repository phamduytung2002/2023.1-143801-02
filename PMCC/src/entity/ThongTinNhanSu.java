package entity;

public class ThongTinNhanSu {
    private String hoTen;
    private String ID;
    private String boPhanLamViec;

    public ThongTinNhanSu(String hoTen, String ID, String boPhanLamViec){
        this.hoTen = hoTen;
        this.ID = ID;
        this.boPhanLamViec = boPhanLamViec;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBoPhanLamViec() {
        return boPhanLamViec;
    }

    public void setBoPhanLamViec(String boPhanLamViec) {
        this.boPhanLamViec = boPhanLamViec;
    }
}
