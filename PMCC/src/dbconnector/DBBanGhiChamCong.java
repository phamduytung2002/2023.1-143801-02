package dbconnector;

import entity.BanGhiChamCong;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.Document;

public class DBBanGhiChamCong extends DBConnector{
    public DBBanGhiChamCong() {
        super("ChamCong", "Ban ghi cham cong_3");
    }

    public List<BanGhiChamCong> queryByID(String ID) {
        List<BanGhiChamCong> result = new ArrayList<>();
        for(Document document : this.collection.find(new Document("ID", ID))) {
            result.add(new BanGhiChamCong(ID, document.getDate("Thời gian")));
        }
        return result;
    }

    public List<BanGhiChamCong> queryByIDThangNam(String ID, int thang, int nam){
        List<BanGhiChamCong> byID = this.queryByID(ID);
        List<BanGhiChamCong> result = new ArrayList<>();
        for(BanGhiChamCong t: byID){
            if(t.getThoiGian().getMonth() == thang - 1 && t.getThoiGian().getYear() == nam - 1900){
                result.add(t);
            }
        }
        return result;
    }

    public void insertData(String ID, Date thoiGian) {
        Document document = new Document("ID", ID)
                .append("Thời gian", thoiGian);
        this.insertData((List<Document>) document);
    }

    public void insertOne(String ID, Date thoiGian){
        Document document = new Document("ID", ID)
                .append("Thời gian", thoiGian);
        this.collection.insertOne(document);
    }


    public static void main(String[] args) {
        DBBanGhiChamCong dbBanGhiChamCong = new DBBanGhiChamCong();

        LocalDateTime date1 = LocalDateTime.of(2023, 11, 2, 7, 43);
        LocalDateTime date2 = LocalDateTime.of(2023, 11, 2, 11, 35);
        LocalDateTime date3 = LocalDateTime.of(2023, 11, 1, 12, 47);
        LocalDateTime date4 = LocalDateTime.of(2023, 11, 1, 17, 31);
        dbBanGhiChamCong.insertData("20200063", Date.from(date1.atZone(ZoneId.systemDefault()).toInstant()));
        dbBanGhiChamCong.insertData("20200063", Date.from(date2.atZone(ZoneId.systemDefault()).toInstant()));
        dbBanGhiChamCong.insertData("20200063", Date.from(date3.atZone(ZoneId.systemDefault()).toInstant()));
        dbBanGhiChamCong.insertData("20200063", Date.from(date4.atZone(ZoneId.systemDefault()).toInstant()));
        dbBanGhiChamCong.getData();
//        List<BanGhiChamCong> x = dbBanGhiChamCong.queryByID("20200573");
//        for(BanGhiChamCong t: x) {
//            System.out.println(t.getID() + " " + t.getThoiGian().getMonth() + " " + t.getThoiGian().getYear());
//        }
//        System.out.println("fsda");
//        x = dbBanGhiChamCong.queryByIDThangNam("20200573", 12, 2020);
//        System.out.println("jkljslk");
//        for(BanGhiChamCong t: x) {
//            System.out.println(t.getID() + " " + t.getThoiGian());
//        }
    }
}
