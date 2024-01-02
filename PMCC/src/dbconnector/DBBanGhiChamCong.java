package dbconnector;

import entity.BanGhiChamCong;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.bson.Document;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBBanGhiChamCong extends DBConnector {
    public DBBanGhiChamCong() {
        super("ChamCong", "Ban ghi cham cong_4");
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
        ArrayList to_insert = new ArrayList<Document>();
        to_insert.add(document);
        this.insertData(to_insert);
    }

    public void insertOne(String ID, Date thoiGian){
        Document document = new Document("ID", ID)
                .append("Thời gian", thoiGian);
        this.collection.insertOne(document);
    }


    public static void main(String[] args) {
        DBBanGhiChamCong dbBanGhiChamCong = new DBBanGhiChamCong();

        LocalDateTime date1 = LocalDateTime.of(2024, 1, 2, 7, 31);
        LocalDateTime date2 = LocalDateTime.of(2024, 1, 2, 11, 58);
        LocalDateTime date3 = LocalDateTime.of(2024, 1, 2, 12, 48);
        LocalDateTime date4 = LocalDateTime.of(2024, 1, 2, 17, 55);
        dbBanGhiChamCong.insertData("20200383", Date.from(date1.atZone(ZoneId.of("+07")).toInstant()));
        dbBanGhiChamCong.insertData("20200383", Date.from(date2.atZone(ZoneId.of("+07")).toInstant()));
        dbBanGhiChamCong.insertData("20200383", Date.from(date3.atZone(ZoneId.of("+07")).toInstant()));
        dbBanGhiChamCong.insertData("20200383", Date.from(date4.atZone(ZoneId.of("+07")).toInstant()));

//        date1 = LocalDateTime.of(2024, 1, 11, 7, 30);
//        date2 = LocalDateTime.of(2024, 1, 11, 12, 25);
//        date3 = LocalDateTime.of(2024, 1, 11, 12, 49);
//        date4 = LocalDateTime.of(2024, 1, 11, 17, 13);
//        dbBanGhiChamCong.insertData("20200383", Date.from(date1.atZone(ZoneId.of("+07")).toInstant()));
//        dbBanGhiChamCong.insertData("20200383", Date.from(date2.atZone(ZoneId.of("+07")).toInstant()));
//        dbBanGhiChamCong.insertData("20200383", Date.from(date3.atZone(ZoneId.of("+07")).toInstant()));
//        dbBanGhiChamCong.insertData("20200383", Date.from(date4.atZone(ZoneId.of("+07")).toInstant()));
//
//        date1 = LocalDateTime.of(2024, 1, 12, 7, 30);
//        date2 = LocalDateTime.of(2024, 1, 12, 12, 25);
//        date3 = LocalDateTime.of(2024, 1, 12, 12, 49);
//        date4 = LocalDateTime.of(2024, 1, 12, 17, 13);
//        dbBanGhiChamCong.insertData("20200383", Date.from(date1.atZone(ZoneId.of("+07")).toInstant()));
//        dbBanGhiChamCong.insertData("20200383", Date.from(date2.atZone(ZoneId.of("+07")).toInstant()));
//        dbBanGhiChamCong.insertData("20200383", Date.from(date3.atZone(ZoneId.of("+07")).toInstant()));
//        dbBanGhiChamCong.insertData("20200383", Date.from(date4.atZone(ZoneId.of("+07")).toInstant()));
//        dbBanGhiChamCong.getData();
        List<BanGhiChamCong> x = dbBanGhiChamCong.queryByIDThangNam("20200063", 12, 2023);
        for(BanGhiChamCong y:x){
            System.out.println(y.getID() + y.getThoiGian());
        }
    }
}