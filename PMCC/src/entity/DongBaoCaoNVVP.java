package entity;

public class DongBaoCaoNVVP {
    private final String hoTen;
    private final String ID;
    private final String donVi;
    private final int thang;
    private final int soBuoiLam;
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

    public String getID() {
        return ID;
    }

    public String getDonVi() {
        return donVi;
    }

    public int getThang() {
        return thang;
    }

    public int getSoBuoiLam() {
        return soBuoiLam;
    }

    public double getSoGioDiMuonVeSom() {
        return soGioDiMuonVeSom;
    }

    public void setSoGioDiMuonVeSom(double soGioDiMuonVeSom) {
        this.soGioDiMuonVeSom = soGioDiMuonVeSom;
    }
}
