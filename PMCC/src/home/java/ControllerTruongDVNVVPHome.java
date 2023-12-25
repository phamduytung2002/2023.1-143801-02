package home.java;

import baocaochamcong.java.ControllerBaoCaoChamCongNVVP;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ControllerTruongDVNVVPHome {
    private ViewTruongDVNVVPHome viewTruongDVNVVPHome;

    public ControllerTruongDVNVVPHome(){
        viewTruongDVNVVPHome = new ViewTruongDVNVVPHome();
        viewTruongDVNVVPHome.setClickBaoCaoChamCong(event -> {
            ControllerBaoCaoChamCongNVVP controllerBaoCaoChamCong = new ControllerBaoCaoChamCongNVVP();
            AnchorPane content = viewTruongDVNVVPHome.getContent();
            controllerBaoCaoChamCong.changeContent(content);
        });

        viewTruongDVNVVPHome.setClickTrangChu(event -> {
            ControllerTruongDVNVVPHome controllerTruongDVNVVPHome = new ControllerTruongDVNVVPHome();
            AnchorPane modifiablePane = viewTruongDVNVVPHome.getContent();
            controllerTruongDVNVVPHome.changeContent(modifiablePane);
        });
    }

    public void showView(){
        viewTruongDVNVVPHome.show();
    }

    public void changeContent(AnchorPane content){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/home/resources/hometruongDVNVVP.fxml"));
        try {
            content.getChildren().set(0, loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
