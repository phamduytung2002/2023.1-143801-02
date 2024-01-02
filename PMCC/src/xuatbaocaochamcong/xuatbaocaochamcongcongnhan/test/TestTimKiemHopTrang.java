package xuatbaocaochamcong.xuatbaocaochamcongcongnhan.test;

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
        demo.setTenDonVi(null);
        demo.setThoiGianTu("2022-01-01");
        demo.setThoiGianDen("2022-01-01");
        assertFalse(demo.checkValidDV());
        demo.timKiemClicked();
        assertEquals("Vui lòng chọn đơn vị", demo.viewXuatBCCCCN.getDialog());
    }

    @Test
    public void testTimKiemClicked_MissingThoiGianTu() throws Exception {
        // Test case 2: Missing thoiGianTu
        demo.setTenDonVi("NhanSu");
        demo.setThoiGianTu(null);
        demo.setThoiGianDen("2022-01-01");
        assertTrue(demo.checkValidDV());
        assertNull(demo.viewXuatBCCCCN.getThoiGianTu());
        demo.timKiemClicked();
        assertEquals("Vui lòng chọn thời gian", demo.viewXuatBCCCCN.getDialog());
    }

    @Test
    public void testTimKiemClicked_MissingThoiGianDen() throws Exception {
        // Test case 3: Missing thoiGianDen
        demo.setTenDonVi("NhanSu");
        demo.setThoiGianTu("2022-01-01");
        demo.setThoiGianDen(null);
        assertTrue(demo.checkValidDV());
        assertNull(demo.viewXuatBCCCCN.getThoiGianDen());
        demo.timKiemClicked();
        assertEquals("Vui lòng chọn thời gian", demo.viewXuatBCCCCN.getDialog());
    }

    @Test
    public void testTimKiemClicked_InvalidDate() throws Exception {
        // Test case 4: Invalid date
        demo.setTenDonVi("NhanSu");
        demo.setThoiGianTu("2022-01-02");
        demo.setThoiGianDen("2022-01-01");
        assertTrue(demo.checkValidDV());
        assertFalse(demo.checkValidDate());
        demo.timKiemClicked();
        assertEquals("Thời gian không hợp lệ", demo.viewXuatBCCCCN.getDialog());
    }

    @Test
    public void testTimKiemClicked_ValidInput() throws Exception {
        // Test case 5: Valid input
        demo.setTenDonVi("NhanSu");
        demo.setThoiGianTu("2020-01-01");
        demo.setThoiGianDen("2022-01-01");
        assertTrue(demo.checkValidDV());
        assertTrue(demo.checkValidDate());
        demo.timKiemClicked();
        assertEquals("Tìm kiếm thành công", demo.viewXuatBCCCCN.getDialog());
        // Additional assertions for the expected behavior after TimKiem() is called
    }
}
