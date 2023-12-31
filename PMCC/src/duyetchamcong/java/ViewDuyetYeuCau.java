package duyetchamcong.java;

import entity.DongDuyetChinhSua;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.scene.Parent;

import java.io.IOException;
public class ViewDuyetYeuCau {

    public AnchorPane modifiablePane;
    public Button homebutton;
    public Button logoutbutton;
    public Label hoten;
    public Label maNV;
    public Label thang;
    public Label nam;
    public Button khongxacnhanbutton;
    public Button xacnhanbutton;
    public Label ngay;
    public Label giodilam;

    public TableColumn<DongDuyetChinhSua, String> lidoColumn;
    public TableColumn<DongDuyetChinhSua, String> ngayColumn;
    public TableColumn<DongDuyetChinhSua, String> minhchungColumn;
    public TableView<DongDuyetChinhSua> bangduyetyeucau;

    public Stage stage  = new Stage();

    private Parent root;



    public void setHoten(String hoten){
        this.hoten.setText(hoten);
    }
    public void setMaNV(String maNV){
        this.maNV.setText(maNV);
    }
    public void setThang(String thang){
        this.thang.setText(thang);
    }
    public void setNam(String nam){
        this.nam.setText(nam);
    }

    private final ObservableList<DongDuyetChinhSua> data= FXCollections.observableArrayList();
    public void initialize() {
        ngayColumn.setCellValueFactory(celldata->celldata.getValue().getNgay());
        lidoColumn.setCellValueFactory(celldata->celldata.getValue().getLiDo());
        minhchungColumn.setCellValueFactory(celldata->celldata.getValue().getMinhChung());
        bangduyetyeucau.setItems(data);
        data.add(new DongDuyetChinhSua("20/12/2023","Sai chức vụ","file:///C:/Users/Pham%20Duy%20Tung/Desktop/PMCC/src/duyetchamcong/resources/MinhChung1.png"));

    }
    ViewDuyetYeuCau(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/duyetchamcong/resources/UIduyetyeucauchinhsua.fxml"));
        try {
            loader.setController(this);
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean ísXacNhan()
    {
        return xacnhanbutton.isPressed();
    }
    public boolean ísKhongXacNhan() {
        return khongxacnhanbutton.isPressed();
    }
    public void XacNhanClicked(EventHandler<MouseEvent> eventEventHandler)
    {
        xacnhanbutton.addEventHandler(MouseEvent.MOUSE_CLICKED,eventEventHandler);
    }
    public void KhongXacNhanClicked(EventHandler<MouseEvent> eventEventHandler)
    {
        khongxacnhanbutton.addEventHandler(MouseEvent.MOUSE_CLICKED,eventEventHandler);
    }
    void show() {
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
