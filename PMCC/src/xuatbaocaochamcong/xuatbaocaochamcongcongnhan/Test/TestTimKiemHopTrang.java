package xuatbaocaochamcong.xuatbaocaochamcongcongnhan.Test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.junit.Before;
import org.junit.Test;
import xuatbaocaochamcong.xuatbaocaochamcongcongnhan.ControllerXuatBCCCCN;

import java.sql.SQLException;

import static org.junit.Assert.*;

public class TestTimKiemHopTrang extends Application {

    private ControllerXuatBCCCCN demo = new ControllerXuatBCCCCN();

    public TestTimKiemHopTrang() throws SQLException, ClassNotFoundException {
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Platform.runLater(() -> {
            try {
                runTests();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void runTests() throws Throwable {
        org.junit.runner.JUnitCore.main(TestTimKiemHopTrang.class.getName());
    }

    @Before
    public void setUp() throws ClassNotFoundException, SQLException {
        demo = new ControllerXuatBCCCCN();
    }

    @Test
    public void testTimKiemClicked_InvalidDonVi() throws Exception {
        // Test case 1: Invalid DV
        demo.setTenDonVi("");
        assertFalse(demo.checkValidDV());
        demo.TimKiemClicked();
        assertEquals("Vui lòng chọn đơn vị", demo.viewXuatBCCCCN.getDialog());
    }

    @Test
    public void testTimKiemClicked_MissingThoiGian() throws Exception {
        // Test case 2: Missing thoiGianDen or thoiGianTu
        demo.setTenDonVi("NhanSu");
        assertTrue(demo.checkValidDV());
        demo.setThoiGianTu(null);
        demo.setThoiGianDen(null);
        assertNull(demo.viewXuatBCCCCN.getThoiGianDen());
        assertNull(demo.viewXuatBCCCCN.getThoiGianTu());
        demo.TimKiemClicked();
        assertEquals("Vui lòng chọn thời gian", demo.viewXuatBCCCCN.getDialog());
    }


    @Test
    public void testTimKiemClicked_InvalidDate() throws Exception {
        // Test case 3: Invalid date
        demo.setTenDonVi("Nhan Su");
        assertTrue(demo.checkValidDV());
        demo.setThoiGianDen("2022-01-01");
        demo.setThoiGianTu("2022-01-02");
        assertFalse(demo.checkValidDate());
        demo.TimKiemClicked();
        assertEquals("Thời gian không hợp lệ", demo.viewXuatBCCCCN.getDialog());
    }

    @Test
    public void testTimKiemClicked_ValidInput() throws Exception {
        // Test case 4: Valid input
        demo.setTenDonVi("Nhan Su");
        assertTrue(demo.checkValidDV());
        demo.setThoiGianDen("2022-01-01");
        demo.setThoiGianTu("2022-01-01");
        assertTrue(demo.checkValidDate());
        demo.TimKiemClicked();
        assertEquals("Tìm kiếm thành công", demo.viewXuatBCCCCN.getDialog());
        // Additional assertions for the expected behavior after TimKiem() is called
    }
}
