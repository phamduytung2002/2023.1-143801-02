package duyetchamcong.java;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;


public class ControllerDuyetYeuCau {

    public ViewDuyetYeuCau viewDuyetYeuCau;

    @FXML
    private AnchorPane modifiablePane;
    ControllerDuyetYeuCau(){
        viewDuyetYeuCau = new ViewDuyetYeuCau();
        viewDuyetYeuCau.XacNhanClicked(event->XacNhan());
        viewDuyetYeuCau.KhongXacNhanClicked(event->KhongXacNhan());
    }

    void showView(){
        viewDuyetYeuCau.show();
    }
    public void XacNhan(){
        System.out.println("Xac nhan");
        viewDuyetYeuCau.stage.close();
    }
    public void KhongXacNhan(){
        System.out.println("Khong xac nhan");
        viewDuyetYeuCau.stage.close();
    }



}
