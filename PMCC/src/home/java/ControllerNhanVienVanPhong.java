package home.java;

import chucnangchuahoanthien.ControllerChucNangChuaHoanThien;
import javafx.application.Application;
import javafx.stage.Stage;
import login.java.ControllerDangNhap;
import trangchu.resources.ControllerTrangChuNVVP;
import xembaocaochamcongchitiet.java.ControllerNVVPHome;
import yeucauchinhsuachamcongnvvp.java.ControllerYeuCauChinhSuaChamCongNVVP;

public class ControllerNhanVienVanPhong extends Application {
    public ViewNhanVienVanPhong viewNhanVienVanPhong;
    public ControllerNhanVienVanPhong(){
        viewNhanVienVanPhong = new ViewNhanVienVanPhong();
        viewNhanVienVanPhong.trangchuclicked(event->trangchu());
        viewNhanVienVanPhong.xembaocaochamcongchitietclicked(event->xembaocaochamcongchitiet());
        viewNhanVienVanPhong.xemthongtintonghopclicked(event->xemthongtintonghop());
        viewNhanVienVanPhong.dangxuatclicked(event->dangxuat());
    }

    private void dangxuat() {
        ControllerDangNhap controllerDangNhap = new ControllerDangNhap();
        viewNhanVienVanPhong.close();
        controllerDangNhap.viewDangNhap.show();
    }

    private void xemthongtintonghop() {
        viewNhanVienVanPhong.xemthongtintonghopbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewNhanVienVanPhong.xembaocaochamcongchitietbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewNhanVienVanPhong.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerChucNangChuaHoanThien controllerChucNangChuaHoanThien = new ControllerChucNangChuaHoanThien();
        viewNhanVienVanPhong.content.getChildren().clear();
        viewNhanVienVanPhong.content.getChildren().add(controllerChucNangChuaHoanThien.viewChucNangChuaHoanThien.root);
    }

    private void xembaocaochamcongchitiet() {
        viewNhanVienVanPhong.xembaocaochamcongchitietbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewNhanVienVanPhong.xemthongtintonghopbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewNhanVienVanPhong.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerNVVPHome controllerNVVPHome = new ControllerNVVPHome();
        controllerNVVPHome.viewNVVPHome.setClickQuayLai(event -> trangchu());
        viewNhanVienVanPhong.content.getChildren().clear();
        viewNhanVienVanPhong.content.getChildren().add(controllerNVVPHome.viewNVVPHome.root);
    }


    private void trangchu() {
        viewNhanVienVanPhong.trangchubutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewNhanVienVanPhong.xembaocaochamcongchitietbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewNhanVienVanPhong.xemthongtintonghopbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerTrangChuNVVP controllerTrangChuNVVP = new ControllerTrangChuNVVP();
        viewNhanVienVanPhong.content.getChildren().clear();
        viewNhanVienVanPhong.content.getChildren().add(controllerTrangChuNVVP.viewTrangChuNVVP.root);
    }

    @Override
    public void start(Stage stage) throws Exception {
        viewNhanVienVanPhong.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
