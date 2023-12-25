package duyetchamcong.java;

import baocaochamcong.java.ControllerBaoCaoChamCongNVVP;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class ControllerTruongNhanSuHome {
    private ViewTruongNhanSuHome viewTruongNhanSuHome;
    public ControllerTruongNhanSuHome(){
        viewTruongNhanSuHome = new ViewTruongNhanSuHome();
//        viewTruongNhanSuHome.setClickBaoCaoChamCong(event -> {
//            ControllerBaoCaoChamCongNVVP controllerBaoCaoChamCong = new ControllerBaoCaoChamCongNVVP();
//            Parent root = viewTruongNhanSuHome.getRoot();
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/baocaochamcong/resources/baocaochamcong.fxml"));
//            try {
//                viewTruongNhanSuHome.getModifiablePane().getChildren().set(0, loader.load());
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
//        viewTruongNhanSuHome.setClickTrangChu(event -> {
//            Parent root = viewTruongNhanSuHome.getRoot();
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("/home/resources/hometruongDVNVVP.fxml"));
//            try {
//                viewTruongNhanSuHome.getModifiablePane().getChildren().set(0, loader.load());
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        });
    }

    public void showView(){
        viewTruongNhanSuHome.show();
    }
}
