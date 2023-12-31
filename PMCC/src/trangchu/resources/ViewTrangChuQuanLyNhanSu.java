package trangchu.resources;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewTrangChuQuanLyNhanSu {
    public final Parent root;
    @FXML
    public FXMLLoader loader;
    ViewTrangChuQuanLyNhanSu() {
        loader = new FXMLLoader(getClass().getResource("/trangchu/resources/UITrangChuQuanLyNhanSu.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void show() {
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }


}
