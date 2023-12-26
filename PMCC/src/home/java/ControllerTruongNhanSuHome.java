package home.java;

import baocaochamcong.java.ControllerBaoCaoChamCongNVVP;
import duyetchamcong.java.ControllerXemYeuCauChinhSua;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ControllerTruongNhanSuHome {
    private ViewTruongNhanSuHome viewTruongNhanSuHome;
    private ControllerXemYeuCauChinhSua controllerXemYeuCauChinhSua;
    private FXMLLoader loader_view;
    private  Parent root_view;
    public ControllerTruongNhanSuHome(){
        viewTruongNhanSuHome = new ViewTruongNhanSuHome();
        viewTruongNhanSuHome.setClickBaoCaoChamCong(event -> {
            ControllerBaoCaoChamCongNVVP controllerBaoCaoChamCong = new ControllerBaoCaoChamCongNVVP();
            Parent root = viewTruongNhanSuHome.getRoot();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/baocaochamcong/resources/baocaochamcong.fxml"));
            try {
                viewTruongNhanSuHome.getModifiablePane().getChildren().set(0, loader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        viewTruongNhanSuHome.setClickDuyetChamCong(event -> {
            controllerXemYeuCauChinhSua = new ControllerXemYeuCauChinhSua();
            AnchorPane content = viewTruongNhanSuHome.getContent();
//            controllerXemYeuCauChinhSua.changeContent(content, (p)->{
//
//            });
//            loader_view = controllerXemYeuCauChinhSua.getLoader();
            controllerXemYeuCauChinhSua.showView();
        });

        viewTruongNhanSuHome.setClickTrangChu(event -> {
            Parent root = viewTruongNhanSuHome.getRoot();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/duyetchamcong/resources/hometruongnhansu.fxml"));
            try {
                viewTruongNhanSuHome.getModifiablePane().getChildren().set(0, loader.load());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public void showView(){
        viewTruongNhanSuHome.show();
    }

    public void changeContent(AnchorPane content){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/duyetchamcong/resources/hometruongnhansu.fxml"));
//        FXMLLoader loader = loader_view;
        try {
            content.getChildren().set(0, this.loader_view.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
