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
            Parent root = viewTruongDVNVVPHome.getRoot();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/baocaochamcong/resources/baocaochamcong.fxml"));
            try {
                viewTruongDVNVVPHome.getModifiablePane().getChildren().set(0, loader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        viewTruongDVNVVPHome.setClickTrangChu(event -> {
            Parent root = viewTruongDVNVVPHome.getRoot();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/home/resources/hometruongnhansu.fxml"));
            try {
                viewTruongDVNVVPHome.getModifiablePane().getChildren().set(0, loader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void showView(){
        viewTruongDVNVVPHome.show();
    }
}
