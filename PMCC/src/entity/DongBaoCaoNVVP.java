package entity;

public class DongBaoCaoNVVP {
    private String hoTen;
    private String ID;
    private String donVi;
    private int thang;
    private int soBuoiLam;
    private double soGioDiMuonVeSom;

    public DongBaoCaoNVVP() {
        this.hoTen = "";
        this.ID = "";
        this.donVi = "";
        this.thang = 0;
        this.soBuoiLam = 0;
        this.soGioDiMuonVeSom = 0;
    }

    public DongBaoCaoNVVP(ThongTinNhanSu ttns, int thang, int soBuoiLam, double soGioDiMuonVeSom) {
        this.hoTen = ttns.getHoTen();
        this.ID = ttns.getID();
        this.donVi = ttns.getBoPhanLamViec();
        this.thang = thang;
        this.soBuoiLam = soBuoiLam;
        this.soGioDiMuonVeSom = soGioDiMuonVeSom;
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

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
    }

    public Integer getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getSoBuoiLam() {
        return soBuoiLam;
    }

    public void setSoBuoiLam(int soBuoiLam) {
        this.soBuoiLam = soBuoiLam;
    }

    public double getSoGioDiMuonVeSom() {
        return soGioDiMuonVeSom;
    }

    public void setSoGioDiMuonVeSom(double soGioDiMuonVeSom) {
        this.soGioDiMuonVeSom = soGioDiMuonVeSom;
    }
}
