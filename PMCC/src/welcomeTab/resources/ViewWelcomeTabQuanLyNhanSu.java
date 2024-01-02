package welcomeTab.resources;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewWelcomeTabQuanLyNhanSu {
    public final Parent root;
    @FXML
    public FXMLLoader loader;
    ViewWelcomeTabQuanLyNhanSu() {
        loader = new FXMLLoader(getClass().getResource("/welcomeTab/resources/UIWelcomeTabQuanlynhansu.fxml"));
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
