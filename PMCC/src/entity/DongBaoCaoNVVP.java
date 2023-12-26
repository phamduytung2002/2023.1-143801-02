package entity;

import entity.ThongTinNhanSu;

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

    public void setSoGioDiMuonVeSom(double soGioDiMuonVeSom) {
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
}
