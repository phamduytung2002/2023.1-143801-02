package home.java;

import chucnangchuahoanthien.ControllerChucNangChuaHoanThien;
import duyetchamcong.java.ControllerXemYeuCauChinhSua;
import javafx.scene.Node;
import login.java.ControllerDangNhap;
import welcomeTab.resources.ControllerWelcomeTabQuanLyNhanSu;
import xembaocaochamcong.ControllerBaoCaoChamCongNVVP;
import xuatbaocaochamcong.ControllerXuatBCCC;


import java.io.IOException;
import java.sql.SQLException;

public class ControllerQuanLyNhanSuHome {
    public ViewQuanLyNhanSuHome viewQuanLyNhanSuHome;
    public ControllerQuanLyNhanSuHome() {
        viewQuanLyNhanSuHome =new ViewQuanLyNhanSuHome();
        trangchuclicked();
        viewQuanLyNhanSuHome.trangchuclicked(event->trangchuclicked());
        viewQuanLyNhanSuHome.xembaocaochamcongclicked(event->xembaocaochamcongclicked());
        viewQuanLyNhanSuHome.xuatbaocaochamcongclicked(event-> {
            try {
                xuatbaocaochamcongclicked();
            } catch (IOException | SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        viewQuanLyNhanSuHome.dangxuatbutton.setOnAction(event->dangxuatclicked());
        viewQuanLyNhanSuHome.xemyeucauchinhsuachamcongclicked(event->xemyeucauchinhsuachamcongclicked());
        viewQuanLyNhanSuHome.nhapthongtinchamcongclicked(event->nhapthongtinchamcongclicked());
    }


    public void trangchuclicked(){
        viewQuanLyNhanSuHome.trangchubutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.xembaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.xuatbaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.xemyeucauchinhsuachamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.nhapthongtinchamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerWelcomeTabQuanLyNhanSu controllerWelcomeTabQuanLyNhanSu =new ControllerWelcomeTabQuanLyNhanSu();
viewQuanLyNhanSuHome.content.getChildren().clear();
viewQuanLyNhanSuHome.content.getChildren().add((Node) controllerWelcomeTabQuanLyNhanSu.viewWelcomeTabQuanLyNhanSu.root);


    }
    public void xembaocaochamcongclicked(){
        viewQuanLyNhanSuHome.xembaocaochamcongbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.xuatbaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.xemyeucauchinhsuachamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.nhapthongtinchamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerBaoCaoChamCongNVVP controllerBaoCaoChamCongNVVP=new ControllerBaoCaoChamCongNVVP();
        controllerBaoCaoChamCongNVVP.viewBaoCaoChamCongNVVP.setOnMouseQuayLaiButton(event -> {
            trangchuclicked();
        });
        viewQuanLyNhanSuHome.content.getChildren().clear();
        viewQuanLyNhanSuHome.content.getChildren().add((Node) controllerBaoCaoChamCongNVVP.viewBaoCaoChamCongNVVP.root);

    }
    public void xuatbaocaochamcongclicked() throws IOException, SQLException, ClassNotFoundException {
        viewQuanLyNhanSuHome.xuatbaocaochamcongbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.xembaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.xemyeucauchinhsuachamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.nhapthongtinchamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerXuatBCCC controllerXuatBCCC=new ControllerXuatBCCC();
        viewQuanLyNhanSuHome.content.getChildren().clear();
        viewQuanLyNhanSuHome.content.getChildren().add((Node) controllerXuatBCCC.viewXuatBCCC.root);
    }
    public void xemyeucauchinhsuachamcongclicked(){
        viewQuanLyNhanSuHome.xemyeucauchinhsuachamcongbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.xembaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.xuatbaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        viewQuanLyNhanSuHome.nhapthongtinchamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000" );
        ControllerXemYeuCauChinhSua controllerXemYeuCauChinhSua=new ControllerXemYeuCauChinhSua();
        ControllerXemYeuCauChinhSua.viewXemYeuCauChinhSua.quaylaibuttonclicked(event -> {
            trangchuclicked();
        });
        viewQuanLyNhanSuHome.content.getChildren().clear();
        viewQuanLyNhanSuHome.content.getChildren().add((Node) ControllerXemYeuCauChinhSua.viewXemYeuCauChinhSua.root);
    }
public void nhapthongtinchamcongclicked() {
    viewQuanLyNhanSuHome.nhapthongtinchamcongbutton.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000");
    viewQuanLyNhanSuHome.trangchubutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
    viewQuanLyNhanSuHome.xembaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
    viewQuanLyNhanSuHome.xuatbaocaochamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
    viewQuanLyNhanSuHome.xemyeucauchinhsuachamcongbutton.setStyle("-fx-background-color: #f78910; -fx-border-color: #000000");
    ControllerChucNangChuaHoanThien controllerChucNangChuaHoanThien = new ControllerChucNangChuaHoanThien();
    viewQuanLyNhanSuHome.content.getChildren().clear();
    viewQuanLyNhanSuHome.content.getChildren().add((Node) controllerChucNangChuaHoanThien.viewChucNangChuaHoanThien.root);
}
    public void dangxuatclicked(){
        viewQuanLyNhanSuHome.close();
        ControllerDangNhap controllerDangNhap=new ControllerDangNhap();
        controllerDangNhap.viewDangNhap.show();

    }

}
