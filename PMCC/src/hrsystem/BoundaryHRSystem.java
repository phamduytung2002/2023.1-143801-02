package hrsystem;

import dbconnector.DBConnector;
import entity.ThongTinNhanSu;
import org.bson.Document;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

public class BoundaryHRSystem {
    public List<ThongTinNhanSu> getThongTinNVVP() throws ConnectException {
        List<ThongTinNhanSu> ret = new ArrayList<>();
        DBConnector dbConnector= new DBConnector("HeThongQuanLyNhanSu","DonVi");
        DBConnector dbConnector1 = new DBConnector("HeThongQuanLyNhanSu","NhanSu");
        List<Document> nhanSu = dbConnector1.getData();
        List<Document> donVi = dbConnector.getData();
        for(Document document: nhanSu){
            String maNV = document.getString("MaNV");
            String hoTen = document.getString("HoTen");
            String maDV = document.getString("MaDV");
            String tenDV = "";
            for(Document document1: donVi){
                if(document1.getString("MaDV").equals(maDV)){
                    tenDV = document1.getString("TenDV");
                    String loai = document1.getString("Loai");
                    if(!loai.equals("NhanVien")){
                        break;
                    } else{
                        ret.add(new ThongTinNhanSu(hoTen,maNV,tenDV));
                        break;
                    }
                }
            }
        }
        for(ThongTinNhanSu ttns: ret){
            System.out.println(ttns.getID() + ttns.getHoTen() + ttns.getBoPhanLamViec());
        }
        return ret;
    }

    public List<ThongTinNhanSu> getThongTinCN(){
        return null;
    }
}
