package DBConnector;

import Entity.BanGhiChamCong;
import javafx.util.Pair;
import org.bson.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DBBanGhiChamCong extends DBConnector{
    public DBBanGhiChamCong() {
        super("ChamCong", "Ban ghi cham cong");
    }

    Pair<String, LocalDateTime> getLatestData() {
        Document document = this.collection.find().sort(new Document("Thoi gian", -1)).first();
        if(document == null) return new Pair<>("", LocalDateTime.now());
        else return new Pair<>(document.getString("ID"), LocalDateTime.parse(document.getString("Thoi gian")));
    }

    public List<BanGhiChamCong> queryByID(String ID) {
        List<BanGhiChamCong> result = new ArrayList<>();
        this.collection.find(new Document("ID", ID)).forEach(document -> {
            result.add(new BanGhiChamCong(ID, LocalDateTime.parse(document.getString("Thoi gian"))));
        });
        for(BanGhiChamCong banGhiChamCong : result){
            System.out.println(banGhiChamCong.getID() + " " + banGhiChamCong.getThoiGian());
        }
        return result;
    }


}
