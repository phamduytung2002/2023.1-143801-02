package duyetchamcong.test;
import duyetchamcong.java.UpdateTable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class test {
    UpdateTable updateTable = new UpdateTable();

//    @Test(expected = Exception.class)
    @Test
    public void test1() throws Exception {
        ObservableList<String> table= FXCollections.observableArrayList();
        ObservableList<String> data = FXCollections.observableArrayList();
        table.add(new String("1"));
        table.add(new String("2"));
        assertEquals(updateTable.resetTable(table, data),0);
    }

    @Test
    public void test2() throws Exception {
        assertEquals(false, updateTable.checkTimeWork("12:00"));
    }

    @Test
    public void test3() throws Exception {
        assertEquals(false, updateTable.checkTimeWork("8:30"));
    }
    @Test
    public void test4() throws Exception {
        assertEquals(true, updateTable.checkTimeWork("08:30"));
    }
    @Test
    public void test5() throws Exception {
        assertEquals(false, updateTable.checkTimeWork("5:130"));
    }

}
