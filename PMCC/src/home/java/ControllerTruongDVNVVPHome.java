package home.java;

import chucnangchuahoanthien.ControllerChucNangChuaHoanThien;
import login.java.ControllerDangNhap;
import welcomeTab.resources.ControllerWelcomeTabTruongVanPhong;
import xembaocaochamcong.ControllerBaoCaoChamCongNVVP;

public class ControllerTruongDVNVVPHome {
    public final ViewTruongDVNVVPHome viewTruongDVNVVPHome;

    public ControllerTruongDVNVVPHome() {
        viewTruongDVNVVPHome = new ViewTruongDVNVVPHome();
        trangchuclicked();
        viewTruongDVNVVPHome.trangchuclicked(event -> trangchuclicked());
        viewTruongDVNVVPHome.xembaocaochamcongnvvpclicked(event -> xembaocaochamcongnvvpclicked());
        viewTruongDVNVVPHome.xemchamcongchitietnvvpclicked(event -> xemchamcongchitietnvvpclicked());
        viewTruongDVNVVPHome.dangxuatclicked(event -> dangxuatclicked());

    }

    private void dangxuatclicked() {
        viewTruongDVNVVPHome.close();
        ControllerDangNhap controllerDangNhap = new ControllerDangNhap();
        controllerDangNhap.viewDangNhap.show();
    }

    private void xemchamcongchitietnvvpclicked() {
        viewTruongDVNVVPHome.xemchamcongchitietnvvpbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000");
        viewTruongDVNVVPHome.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        viewTruongDVNVVPHome.xembaocaochamcongnvvpbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        ControllerChucNangChuaHoanThien controllerChucNangChuaHoanThien = new ControllerChucNangChuaHoanThien();
        viewTruongDVNVVPHome.content.getChildren().clear();
        viewTruongDVNVVPHome.content.getChildren().add(controllerChucNangChuaHoanThien.viewChucNangChuaHoanThien.root)
;
    }

    private void xembaocaochamcongnvvpclicked() {
        viewTruongDVNVVPHome.xembaocaochamcongnvvpbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000");
        viewTruongDVNVVPHome.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        viewTruongDVNVVPHome.xemchamcongchitietnvvpbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        ControllerBaoCaoChamCongNVVP controllerBaoCaoChamCongNVVP = new ControllerBaoCaoChamCongNVVP();
        controllerBaoCaoChamCongNVVP.viewBaoCaoChamCongNVVP.setOnMouseQuayLaiButton(event -> {
            trangchuclicked();
        });
        viewTruongDVNVVPHome.content.getChildren().clear();
        viewTruongDVNVVPHome.content.getChildren().add(controllerBaoCaoChamCongNVVP.viewBaoCaoChamCongNVVP.root);

    }

    private void trangchuclicked() {
        viewTruongDVNVVPHome.trangchubutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000");
        viewTruongDVNVVPHome.xembaocaochamcongnvvpbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        viewTruongDVNVVPHome.xemchamcongchitietnvvpbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        ControllerWelcomeTabTruongVanPhong controllerWelcomeTabTruongVanPhong = new ControllerWelcomeTabTruongVanPhong();
        viewTruongDVNVVPHome.content.getChildren().clear();
        viewTruongDVNVVPHome.content.getChildren().add(controllerWelcomeTabTruongVanPhong.viewWelcomeTabTruongVanPhong.root);
    }


}
