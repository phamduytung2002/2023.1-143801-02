package duyetchamcong.java;

import entity.DongYeuCauChinhSua;
import javafx.collections.ObservableList;

public class UpdateTable {
    public <T> int resetTable(ObservableList<T> table, ObservableList<T> data) {
        System.out.println("Reset table");
        if (data != null && !data.isEmpty()) {
            table.clear();
            table.addAll(data);
            return  1;
        } else {
            System.out.println("Data is null or empty. Not resetting the table.");
            return 0;
        }
    }
    public boolean checkTimeWork(String timeWork){
        //Check timeWork format Time : (HH:MM)
        if(timeWork.length()!=5) return false;
        if(timeWork.charAt(2)!=':') return false;
//        if(timeWork.charAt(0)<'0' || timeWork.charAt(0)>'9') return false;
//        if(timeWork.charAt(1)<'0' || timeWork.charAt(1)>'9') return false;
//        if(timeWork.charAt(3)<'0' || timeWork.charAt(3)>'9') return false;
//        if(timeWork.charAt(4)<'0' || timeWork.charAt(4)>'9') return false;
        if (Integer.parseInt(timeWork.substring(0, 2)) %12 <= 0 || Integer.parseInt(timeWork.substring(0, 2)) %12 > 9) return false;

        return true;
    }
}
