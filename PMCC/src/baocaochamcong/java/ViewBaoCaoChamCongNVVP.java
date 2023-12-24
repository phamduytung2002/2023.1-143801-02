package baocaochamcong.java;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ViewBaoCaoChamCongNVVP {

    FXMLLoader loader;

    ViewBaoCaoChamCongNVVP(){
        loader = new FXMLLoader(getClass().getResource("/baocaochamcong/resources/baocaochamcong.fxml"));
        loader.setController(this);
    }

    public void setPane(AnchorPane root){
        try {
            root.getChildren().set(0, loader.load());
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
