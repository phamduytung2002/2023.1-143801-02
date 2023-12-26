package duyetchamcong.java;

import entity.DongYeuCauChinhSua;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

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
    public ControllerXemYeuCauChinhSua(){
        viewXemYeuCauChinhSua = new ViewXemYeuCauChinhSua();
        controllerDuyetYeuCau = new ControllerDuyetYeuCau();
        UpdateTable updateTable = new UpdateTable();
        viewXemYeuCauChinhSua.initialize();
        ObservableList<DongYeuCauChinhSua> data= FXCollections.observableArrayList();
        data.add(new DongYeuCauChinhSua("Phạm Duy Tùng","20200573","Chỉnh sửa thông tin","Sai chức vụ","file:///C:/Users/Pham%20Duy%20Tung/Desktop/PMCC/src/duyetchamcong/resources/MinhChung1.png"));
        data.add(new DongYeuCauChinhSua("Do Duc Manh","20200543","Thêm thông tin","Mải ngủ","file:///C://Desktop/PMCC/src/duyetchamcong/resources/MinhChung12.png"));
        updateTable.resetTable(viewXemYeuCauChinhSua.data,data);
//        viewXemYeuCauChinhSua.updateTable(data);
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
