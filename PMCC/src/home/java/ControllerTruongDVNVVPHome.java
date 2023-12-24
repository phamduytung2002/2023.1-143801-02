package home.java;

import baocaochamcong.java.ControllerBaoCaoChamCongNVVP;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class ControllerTruongDVNVVPHome {
    private ViewTruongDVNVVPHome viewTruongDVNVVPHome;

    public ControllerTruongDVNVVPHome(){
        viewTruongDVNVVPHome = new ViewTruongDVNVVPHome();
        viewTruongDVNVVPHome.setClickBaoCaoChamCong(event -> {
            ControllerBaoCaoChamCongNVVP controllerBaoCaoChamCong = new ControllerBaoCaoChamCongNVVP();
            controllerBaoCaoChamCong.setPane(viewTruongDVNVVPHome.getModifiablePane());
        });
        viewTruongDVNVVPHome.setClickTrangChu(event -> {
            viewTruongDVNVVPHome.setPane();
        });
    }

    public void showView(){
        viewTruongDVNVVPHome.show();
    }
}
