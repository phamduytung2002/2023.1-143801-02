package duyetchamcong.java;

import entity.DongYeuCauChinhSua;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ControllerXemYeuCauChinhSua {

    private static ViewXemYeuCauChinhSua viewXemYeuCauChinhSua;
    public ControllerDuyetYeuCau controllerDuyetYeuCau;

    private FXMLLoader loader;
    public FXMLLoader getLoader(){
        return this.viewXemYeuCauChinhSua.getLoader();
    }
    public Parent getRootView(){
        return this.viewXemYeuCauChinhSua.getRoot();
    }
    ControllerXemYeuCauChinhSua(){
        viewXemYeuCauChinhSua = new ViewXemYeuCauChinhSua();
        controllerDuyetYeuCau = new ControllerDuyetYeuCau();
        viewXemYeuCauChinhSua.initialize();
        viewXemYeuCauChinhSua.setClickDuyetYeuCau(event -> {
            controllerDuyetYeuCau.showView();
        });

    }
    public void showView(){
        viewXemYeuCauChinhSua.show();
    }

    public void changeContent(AnchorPane content, IEventHandler<Parent> event){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/duyetchamcong/resources/UIxemyeucauchinhsua.fxml"));
        ViewXemYeuCauChinhSua viewXemYeuCauChinhSua1 = new ViewXemYeuCauChinhSua();
        ControllerDuyetYeuCau controllerDuyetYeuCau1 = new ControllerDuyetYeuCau();
        viewXemYeuCauChinhSua1.initialize();
//        viewXemYeuCauChinhSua1.setClickDuyetYeuCau(event1 -> {
//
//            controllerDuyetYeuCau1.showView();
//        });
        try {
            loader.setController(viewXemYeuCauChinhSua1);
            content.getChildren().set(0, loader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
