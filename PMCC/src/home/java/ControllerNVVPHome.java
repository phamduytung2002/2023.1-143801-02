package home.java;

import chucnangchuahoanthien.ControllerChucNangChuaHoanThien;
import javafx.application.Application;
import javafx.stage.Stage;
import login.java.ControllerDangNhap;
import welcomeTab.resources.ControllerWelcomeTabNVVP;

public class ControllerNVVPHome extends Application {
    public ViewNVVPHome viewNVVPHome;
    public ControllerNVVPHome(){
        viewNVVPHome = new ViewNVVPHome();
        viewNVVPHome.trangchuclicked(event->trangchu());
        viewNVVPHome.xembaocaochamcongchitietclicked(event->xembaocaochamcongchitiet());
        viewNVVPHome.xemthongtintonghopclicked(event->xemthongtintonghop());
        viewNVVPHome.dangxuatclicked(event->dangxuat());
    }

    private void dangxuat() {
        ControllerDangNhap controllerDangNhap = new ControllerDangNhap();
        viewNVVPHome.close();
        controllerDangNhap.viewDangNhap.show();
    }

    private void xemthongtintonghop() {
        viewNVVPHome.xemthongtintonghopbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewNVVPHome.xembaocaochamcongchitietbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewNVVPHome.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerChucNangChuaHoanThien controllerChucNangChuaHoanThien = new ControllerChucNangChuaHoanThien();
        viewNVVPHome.content.getChildren().clear();
        viewNVVPHome.content.getChildren().add(controllerChucNangChuaHoanThien.viewChucNangChuaHoanThien.root);
    }

    private void xembaocaochamcongchitiet() {
        viewNVVPHome.xembaocaochamcongchitietbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewNVVPHome.xemthongtintonghopbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewNVVPHome.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        xembaocaochamcongchitiet.java.ControllerNVVPHome controllerNVVPHome = new xembaocaochamcongchitiet.java.ControllerNVVPHome();
        controllerNVVPHome.viewNVVPHome.setClickQuayLai(event -> trangchu());
        viewNVVPHome.content.getChildren().clear();
        viewNVVPHome.content.getChildren().add(controllerNVVPHome.viewNVVPHome.root);
    }


    private void trangchu() {
        viewNVVPHome.trangchubutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewNVVPHome.xembaocaochamcongchitietbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewNVVPHome.xemthongtintonghopbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerWelcomeTabNVVP controllerWelcomeTabNVVP = new ControllerWelcomeTabNVVP();
        viewNVVPHome.content.getChildren().clear();
        viewNVVPHome.content.getChildren().add(controllerWelcomeTabNVVP.viewWelcomeTabNVVP.root);
    }

    @Override
    public void start(Stage stage) throws Exception {
        viewNVVPHome.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
