package duyetchamcong.java;

import entity.DongYeuCauChinhSua;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class ViewXemYeuCauChinhSua{
    @FXML
    private StackPane xemBaoCaoChamCongPane;

    @FXML
    private StackPane duyetChamCongPane;

    @FXML
    private StackPane trangChuPane;

    private Parent root;

    private Stage stage  = new Stage();

    @FXML
    private TableView<DongYeuCauChinhSua> bangYeuCauChinhSua;

    @FXML
    private TableColumn<DongYeuCauChinhSua, String> hoTenColumn;

    @FXML
    private TableColumn<DongYeuCauChinhSua, String>idColumn;

    @FXML
    private TableColumn<DongYeuCauChinhSua, String> liDoColumn;

    @FXML
    private TableColumn<DongYeuCauChinhSua, String> minhChungColumn;

    @FXML
    private AnchorPane modifiablePane;


    @FXML
    private TableColumn<DongYeuCauChinhSua, String> yeuCauColumn;

    public Button homeButton;
    public Button logoutButton;

    private FXMLLoader loader;

    public FXMLLoader getLoader(){
        return loader;
    }
    public Parent getRoot(){
        return root;
    }
    private final ObservableList<DongYeuCauChinhSua> data= FXCollections.observableArrayList();
    @FXML
    public void initialize() {
        idColumn.setCellValueFactory(celldata->celldata.getValue().getMaNV());
        hoTenColumn.setCellValueFactory(celldata->celldata.getValue().getHoTen());
        yeuCauColumn.setCellValueFactory(celldata->celldata.getValue().getYeuCau());
        liDoColumn.setCellValueFactory(celldata->celldata.getValue().getLiDo());
        minhChungColumn.setCellValueFactory(celldata->celldata.getValue().getMinhChung());
        bangYeuCauChinhSua.setItems(data);
        data.add(new DongYeuCauChinhSua("Phạm Duy Tùng","20200573","Chỉnh sửa thông tin","Sai chức vụ","file:///C:/Users/Pham%20Duy%20Tung/Desktop/PMCC/src/duyetchamcong/resources/MinhChung1.png"));
    }
    void setClickDuyetYeuCau(EventHandler<MouseEvent> eventHandler){
        bangYeuCauChinhSua.setOnMouseClicked(eventHandler);
    }
    ViewXemYeuCauChinhSua(){
        loader = new FXMLLoader(getClass().getResource("/duyetchamcong/resources/UIxemyeucauchinhsua.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    void show() {
        stage.setTitle("Công nhân");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
