package xuatbaocaochamcong.xuatbaocaochamcongcongnhan;

import javafx.scene.layout.AnchorPane;
import xembaocaochamcong.ServiceTinhThoiGian;
import com.opencsv.CSVWriter;
import dbconnector.DBBanGhiChamCong;
import dbconnector.DBConnector;
import entity.BanGhiChamCong;
import javafx.application.Application;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bson.Document;
import xuatbaocaochamcong.ControllerXuatBCCC;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ControllerXuatBCCCCN extends Application {
    public List<DataModel> dataList;
    public String tenDonVi;
    public ViewXuatBCCCCN viewXuatBCCCCN;


    public ControllerXuatBCCCCN() throws SQLException, ClassNotFoundException {
        viewXuatBCCCCN = new ViewXuatBCCCCN();
        List<String> listTenDonVi = this.getListTenDonVi();
        viewXuatBCCCCN.initializeComboBox(listTenDonVi);
        viewXuatBCCCCN.TimKiemClicked(event -> {
            try {
                timKiemClicked();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        viewXuatBCCCCN.XuatBaoCaoClicked(event -> {
            try {
                xuatBaoCaoClicked();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        viewXuatBCCCCN.QuayLaiClicked(event -> quayLaiClicked(event));

    }
    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        viewXuatBCCCCN.show();
    }

    private List<String> getListTenDonVi() throws SQLException, ClassNotFoundException {
        DBConnector dbConnector = new DBConnector("HeThongQuanLyNhanSu", "DonVi");
        List<Document> documentList = dbConnector.getData();
        List<String> listTenDonVi = new ArrayList<>();
        for (Document document : documentList) {
            if (!document.getString("Loai").equals("CongNhan")) continue;
            Set<String> keySet = document.keySet();
            for (String key : keySet) {
                if (key.equals("TenDV")) {
                    listTenDonVi.add(document.getString(key));
                }
            }
        }
        return listTenDonVi;
    }

    public boolean checkValidDate() {
        Date thoiGianTu = viewXuatBCCCCN.getThoiGianTu();
        Date thoiGianDen = viewXuatBCCCCN.getThoiGianDen();
        return !thoiGianTu.after(thoiGianDen);
    }

    public boolean checkValidDV() {
        return !Objects.equals(viewXuatBCCCCN.getTenDonVi(), "");
    }

    public void timKiemClicked() throws Exception {
        if (!checkValidDV()) {
            viewXuatBCCCCN.setDialog("Vui lòng chọn đơn vị");
            return;
        }
        if (viewXuatBCCCCN.getThoiGianDen() == null || viewXuatBCCCCN.getThoiGianTu() == null) {
            viewXuatBCCCCN.setDialog("Vui lòng chọn thời gian");
            return;
        }
        if (checkValidDate()) {
            this.tenDonVi = viewXuatBCCCCN.getTenDonVi();
            viewXuatBCCCCN.setDialog("Tìm kiếm thành công");
            timKiem();
        } else {
            viewXuatBCCCCN.setDialog("Thời gian không hợp lệ");

        }
    }

    public void quayLaiClicked(MouseEvent mouseEvent) {
        ControllerXuatBCCC controllerXuatBCCC = new ControllerXuatBCCC();
        viewXuatBCCCCN.pane.getChildren().clear();
        viewXuatBCCCCN.pane.getChildren().add(controllerXuatBCCC.viewXuatBCCC.root);


    }

    public void showView() {
        viewXuatBCCCCN.show();
    }

    public void xuatBaoCaoClicked() throws Exception {
        if (dataList == null) {
            viewXuatBCCCCN.setDialog("Vui lòng tìm kiếm trước khi xuất báo cáo");
            return;
        }
        if (viewXuatBCCCCN.isCSVButtonSelected()) {
            csvXuatBaoCaoClicked();
            viewXuatBCCCCN.setDialog("Xuất báo cáo thành công");
        }
        if (viewXuatBCCCCN.isExcelButtonSelected()) {
            excelXuatBaoCaoClicked();
            viewXuatBCCCCN.setDialog("Xuất báo cáo thành công");
        }
        if (!viewXuatBCCCCN.isCSVButtonSelected() && !viewXuatBCCCCN.isExcelButtonSelected()) {
            viewXuatBCCCCN.setDialog("Vui lòng chọn định dạng xuất báo cáo");
        }
    }

    public void timKiem() throws Exception {
        dataList = new ArrayList<>();
        viewXuatBCCCCN.resetTable();
        DBConnector dbConnector = new DBConnector("HeThongQuanLyNhanSu", "DonVi");
        List<Document> documentList = dbConnector.getData();
        String maDonVi = "";
        for (Document document : documentList) {
            if (document.getString("TenDV").equals(tenDonVi)) {
                {
                    maDonVi = document.getString("MaDV");
                    break;
                }


            }
        }
        DBConnector dbConnector1 = new DBConnector("HeThongQuanLyNhanSu", "NhanSu");
        List<Document> documentList1 = dbConnector1.getData();
        for (Document document : documentList1) {
            if (document.getString("MaDV").equals(maDonVi)) {
                String hoten = document.getString("HoTen");
                String maNV = document.getString("MaNV");
                String donVi = document.getString("MaDV");
                ServiceTinhThoiGian serviceTinhThoiGian = new ServiceTinhThoiGian();
                DBBanGhiChamCong dbBanGhiChamCong = new DBBanGhiChamCong();
                LocalDate thoiGianTu = viewXuatBCCCCN.getThoiGianTu().toLocalDate();
                LocalDate thoiGianDen = viewXuatBCCCCN.getThoiGianDen().toLocalDate();
                while (!thoiGianTu.isAfter(thoiGianDen)) {
                    String thang = String.valueOf(thoiGianTu.getMonthValue());
                    String nam = String.valueOf(thoiGianTu.getYear());
                    List<BanGhiChamCong> listBanGhiChamCong = dbBanGhiChamCong.queryByIDThangNam(maNV, thoiGianTu.getMonthValue(), thoiGianTu.getYear());
                    String gioLamViec = String.valueOf(serviceTinhThoiGian.tongSoGioLamViec(listBanGhiChamCong));
                    String gioDiMuon = String.valueOf(serviceTinhThoiGian.tinhTongSoGioDiMuonVeSom(listBanGhiChamCong));
                    if (gioLamViec.equals("0.0") && gioDiMuon.equals("0.0")) {
                        thoiGianTu = thoiGianTu.plusMonths(1);
                        continue;
                    }
                    DataModel dataModel = new DataModel(hoten, maNV, donVi, thang, nam, gioLamViec, gioDiMuon);
                    viewXuatBCCCCN.LoadTable(viewXuatBCCCCN.data);
                    viewXuatBCCCCN.data.add(dataModel);

                    thoiGianTu = thoiGianTu.plusMonths(1);
                    dataList.add(dataModel);
                }


            }
        }


    }

    public void csvXuatBaoCaoClicked() throws Exception {
        Path filePath = Path.of("outputCSV.csv");
        List<String[]> writeData = new ArrayList<>();
        String[] header = {"Họ và tên", "Mã NV", "Đơn vị", "Tháng", "Năm", "Giờ làm việc", "Giờ đi muộn"};
        writeData.add(header);
        for (DataModel dataModel : dataList) {
            String[] row = {dataModel.getHoVaTen().getValue(), dataModel.getMaNV().getValue(), dataModel.getDonVi().getValue(), dataModel.getThang().getValue(), dataModel.getNam().getValue(), dataModel.getGioLamViec().getValue(), dataModel.getGioTangCa().getValue()};
            writeData.add(row);
        }
        writeDataLineByLine(writeData, filePath);
    }
    public static void writeDataLineByLine(List<String[]> lines, Path filePath) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(String.valueOf(filePath)))) {
            writer.writeAll(lines);
        }
    }
    public void excelXuatBaoCaoClicked() throws Exception {

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Báo cáo chấm công");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 3000);
        sheet.setColumnWidth(2, 3000);
        sheet.setColumnWidth(3, 3000);
        sheet.setColumnWidth(4, 3000);
        sheet.setColumnWidth(5, 3000);
        sheet.setColumnWidth(6, 3000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();


        XSSFFont font = ((XSSFWorkbook) workbook).createFont();


        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Họ và tên");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Mã NV");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(2);
        headerCell.setCellValue("Đơn vị");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(3);
        headerCell.setCellValue("Tháng");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(4);
        headerCell.setCellValue("Năm");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(5);
        headerCell.setCellValue("Giờ làm việc");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(6);
        headerCell.setCellValue("Giờ đi muộn");
        headerCell.setCellStyle(headerStyle);


        int rowNum = 1;
        for (DataModel dataModel : dataList) {
            Row row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(dataModel.getHoVaTen().getValue());

            row.createCell(1).setCellValue(dataModel.getMaNV().getValue());

            row.createCell(2).setCellValue(dataModel.getDonVi().getValue());

            row.createCell(3).setCellValue(dataModel.getThang().getValue());

            row.createCell(4).setCellValue(dataModel.getNam().getValue());

            row.createCell(5).setCellValue(dataModel.getGioLamViec().getValue());

            row.createCell(6).setCellValue(dataModel.getGioTangCa().getValue());
        }
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "outputExcel.xlsx";

        FileOutputStream outputStream = new FileOutputStream(fileLocation);
        workbook.write(outputStream);
        workbook.close();
    }

    public void setThoiGianDen(String date) {
        viewXuatBCCCCN.setThoiGianDen(date);
    }

    public void setThoiGianTu(String date) {
        viewXuatBCCCCN.setThoiGianTu(date);
    }

    public void setTenDonVi(String s) {
        viewXuatBCCCCN.setTenDonVi(s);
    }

}
