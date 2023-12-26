package YeuCauChinhSuaChamCongNVVP.Test;


import javafx.application.Platform;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//JUnit Suite unittest.Test
@RunWith(Suite.class)


@Suite.SuiteClasses({
        TestYeuCau1.class, TestYeuCau2.class, TestYeuCau3.class, TestYeuCau4.class, TestYeuCau5.class, TestYeuCau6.class, TestYeuCau7.class
})

public class TestYeuCauSuite {
    @BeforeClass
    public static void initJavaFXToolkit() {
        System.setProperty("java.awt.headless", "false");

        // Initialize JavaFX in headless mode
        Platform.startup(() -> {
            // This is a dummy operation, just to ensure JavaFX is initialized
            new javafx.scene.control.Label().toString();
        });
    }
}
