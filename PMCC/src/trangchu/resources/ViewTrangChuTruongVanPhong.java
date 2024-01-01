package trangchu.resources;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewTrangChuTruongVanPhong {
    @FXML

    public FXMLLoader loader;
    public final Parent root;
    public Scene scene;
    public Stage stage;

    ViewTrangChuTruongVanPhong() {
        loader = new FXMLLoader(getClass().getResource("/trangchu/resources/UITrangChuTruongVanPhong.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void show() {
        stage = new Stage();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
