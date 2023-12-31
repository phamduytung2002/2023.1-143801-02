package duyetchamcong.java;

import entity.DongYeuCauChinhSua;
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

public class ViewXemYeuCauChinhSua{
    @FXML
    public StackPane xemBaoCaoChamCongPane;

    @FXML
    public StackPane duyetChamCongPane;

    @FXML
    public StackPane trangChuPane;

    public Parent root;

    public Stage stage  = new Stage();

    @FXML
    public TableView<DongYeuCauChinhSua> bangYeuCauChinhSua;

    @FXML
    public TableColumn<DongYeuCauChinhSua, String> hoTenColumn;

    @FXML
    public TableColumn<DongYeuCauChinhSua, String>idColumn;

    @FXML
    public TableColumn<DongYeuCauChinhSua, String> liDoColumn;

    @FXML
    public TableColumn<DongYeuCauChinhSua, String> minhChungColumn;

    @FXML
    public AnchorPane modifiablePane;


    @FXML
    public TableColumn<DongYeuCauChinhSua, String> yeuCauColumn;

    public Button quaylaibutton;


    public FXMLLoader loader;

    public FXMLLoader getLoader(){
        return loader;
    }
    public Parent getRoot(){
        return root;
    }
    public final ObservableList<DongYeuCauChinhSua> data= FXCollections.observableArrayList();
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
    public void updateTable(ObservableList<DongYeuCauChinhSua> data){
        this.data.clear();
        this.data.addAll(data);
    }
    void setClickDuyetYeuCau(EventHandler<MouseEvent> eventHandler){
        bangYeuCauChinhSua.setOnMouseClicked(eventHandler);
    }
    public ViewXemYeuCauChinhSua(){
        loader = new FXMLLoader(getClass().getResource("/duyetchamcong/resources/UIxemyeucauchinhsua.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    void show() {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void quaylaibuttonclicked(EventHandler<MouseEvent> eventHandler){
        quaylaibutton.setOnMouseClicked(eventHandler);
    }


}
