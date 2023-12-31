package home.java;

import chucnangchuahoanthien.ControllerChucNangChuaHoanThien;
import javafx.application.Application;
import javafx.stage.Stage;
import login.java.ControllerDangNhap;
import trangchu.resources.ControllerTrangChuTruongVanPhong;
import xembaocaochamcong.ControllerBaoCaoChamCongNVVP;

public class ControllerTruongVanPhong  {
    public final ViewTruongVanPhong viewTruongVanPhong;

    public ControllerTruongVanPhong() {
        viewTruongVanPhong = new ViewTruongVanPhong();
        trangchuclicked();
        viewTruongVanPhong.trangchuclicked(event -> trangchuclicked());
        viewTruongVanPhong.xembaocaochamcongnvvpclicked(event -> xembaocaochamcongnvvpclicked());
        viewTruongVanPhong.xemchamcongchitietnvvpclicked(event -> xemchamcongchitietnvvpclicked());
        viewTruongVanPhong.dangxuatclicked(event -> dangxuatclicked());

    }

    private void dangxuatclicked() {
        viewTruongVanPhong.close();
        ControllerDangNhap controllerDangNhap = new ControllerDangNhap();
        controllerDangNhap.viewDangNhap.show();
    }

    private void xemchamcongchitietnvvpclicked() {
        viewTruongVanPhong.xemchamcongchitietnvvpbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000");
        viewTruongVanPhong.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        viewTruongVanPhong.xembaocaochamcongnvvpbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        ControllerChucNangChuaHoanThien controllerChucNangChuaHoanThien = new ControllerChucNangChuaHoanThien();
        viewTruongVanPhong.content.getChildren().clear();
        viewTruongVanPhong.content.getChildren().add(controllerChucNangChuaHoanThien.viewChucNangChuaHoanThien.root)
;
    }

    private void xembaocaochamcongnvvpclicked() {
        viewTruongVanPhong.xembaocaochamcongnvvpbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000");
        viewTruongVanPhong.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        viewTruongVanPhong.xemchamcongchitietnvvpbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        ControllerBaoCaoChamCongNVVP controllerBaoCaoChamCongNVVP = new ControllerBaoCaoChamCongNVVP();
        controllerBaoCaoChamCongNVVP.viewBaoCaoChamCongNVVP.setOnMouseQuayLaiButton(event -> {
            trangchuclicked();
        });
        viewTruongVanPhong.content.getChildren().clear();
        viewTruongVanPhong.content.getChildren().add(controllerBaoCaoChamCongNVVP.viewBaoCaoChamCongNVVP.root);

    }

    private void trangchuclicked() {
        viewTruongVanPhong.trangchubutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000");
        viewTruongVanPhong.xembaocaochamcongnvvpbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        viewTruongVanPhong.xemchamcongchitietnvvpbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
        ControllerTrangChuTruongVanPhong controllerTrangChuTruongVanPhong = new ControllerTrangChuTruongVanPhong();
        viewTruongVanPhong.content.getChildren().clear();
        viewTruongVanPhong.content.getChildren().add(controllerTrangChuTruongVanPhong.viewTrangChuTruongVanPhong.root);
    }


}
