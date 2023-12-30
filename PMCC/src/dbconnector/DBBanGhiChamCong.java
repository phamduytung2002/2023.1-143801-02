package dbconnector;

import entity.BanGhiChamCong;
import org.bson.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBBanGhiChamCong extends DBConnector {
    public DBBanGhiChamCong() {
        super("ChamCong", "Ban ghi cham cong_3");
    }

    public List<BanGhiChamCong> queryByID(String ID) {
        List<BanGhiChamCong> result = new ArrayList<>();
        for (Document document : this.collection.find(new Document("ID", ID))) {
            result.add(new BanGhiChamCong(ID, document.getDate("Thời gian")));
        }
        return result;
    }

    public List<BanGhiChamCong> queryByIDThangNam(String ID, int thang, int nam) {
        List<BanGhiChamCong> byID = this.queryByID(ID);
        List<BanGhiChamCong> result = new ArrayList<>();
        for (BanGhiChamCong t : byID) {
            if (t.getThoiGian().getMonth() == thang - 1 && t.getThoiGian().getYear() == nam - 1900) {
                result.add(t);
            }
        }
        return result;
    }

    public void insertData(String ID, Date thoiGian) {
        Document document = new Document("ID", ID).append("Thời gian", thoiGian);
        this.insertData((List<Document>) document);
    }

    public void insertOne(String ID, Date thoiGian) {
        Document document = new Document("ID", ID).append("Thời gian", thoiGian);
        this.collection.insertOne(document);
    }
}