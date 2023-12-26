package xuatbaocaochamcong.xuatbaocaochamcongcongnhan;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataModel {
    private StringProperty HoVaTen = new SimpleStringProperty();
    private StringProperty MaNV = new SimpleStringProperty();
    private StringProperty DonVi = new SimpleStringProperty();
    private StringProperty Thang = new SimpleStringProperty();
    private StringProperty Nam = new SimpleStringProperty();
    private StringProperty GioLamViec = new SimpleStringProperty();
    private StringProperty GioTangCa = new SimpleStringProperty();

    public DataModel(String HoVaTen, String MaNV, String DonVi, String Thang, String Nam, String GioLamViec, String GioTangCa) {
        this.HoVaTen.set(HoVaTen);
        this.MaNV.set(MaNV);
        this.DonVi.set(DonVi);
        this.Thang.set(Thang);
        this.Nam.set(Nam);
        this.GioLamViec.set(GioLamViec);
        this.GioTangCa.set(GioTangCa);

    }

    public StringProperty getHoVaTen() {
        return HoVaTen;
    }

    public StringProperty getMaNV() {
        return MaNV;
    }

    public StringProperty getDonVi() {
        return DonVi;
    }

    public StringProperty getThang() {
        return Thang;
    }

    public StringProperty getNam() {
        return Nam;
    }

    public StringProperty getGioLamViec() {
        return GioLamViec;
    }

    public StringProperty getGioTangCa() {
        return GioTangCa;
    }
}



