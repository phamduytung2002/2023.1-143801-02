package baocaochamcong.java;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.sql.Timestamp;

public class ControllerBaoCaoChamCongNVVP {
    ViewBaoCaoChamCongNVVP viewBaoCaoChamCongNVVP;
    public ControllerBaoCaoChamCongNVVP(){
        viewBaoCaoChamCongNVVP = new ViewBaoCaoChamCongNVVP();
    }

    public void hienThiBaoCaoChamCongNVVPTheoThang(int thang, int nam){
        if(thang <=0 ||thang >=13){
            System.out.println("Tháng nhập vo không hợp lệ");
            throw new IllegalArgumentException();
        }
    }

    public void hienThiBaoCaoChamCongNVVPTheoQuy(int quy, int nam){
        if(quy <=0 ||quy >=5){
            System.out.println("Quý nhập vo không hợp lệ");
            throw new IllegalArgumentException();
        }
    }

    public void hienThiBaoCaoChamCongNVVPTheoNam(int nam){

    }

    public void setPane(AnchorPane pane){
        viewBaoCaoChamCongNVVP.setPane(pane);
    }
}
