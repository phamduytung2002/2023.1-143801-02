package xuatbaocaochamcong.xuatbaocaochamcongcongnhan;

import baocaochamcong.java.ServiceTinhThoiGian;
import com.opencsv.CSVWriter;
import dbconnector.DBBanGhiChamCong;
import dbconnector.DBConnector;
import entity.BanGhiChamCong;
import javafx.application.Application;

import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.*;
import org.bson.Document;

import java.io.FileWriter;

import java.nio.file.Path;
import java.sql.*;
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
                TimKiemClicked();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        });
        viewXuatBCCCCN.XuatBaoCaoClicked(event -> {
            try {
                XuatBaoCaoClicked();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

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
            Set<String> keySet = document.keySet();
            for (String key : keySet) {
                if (key.equals("TenDV")) {
                    listTenDonVi.add(document.getString(key));
                }
            }
        }
        return listTenDonVi;
    }

    private boolean checkValidDate() {
        Date thoiGianTu = viewXuatBCCCCN.getThoiGianTu();
        Date thoiGianDen = viewXuatBCCCCN.getThoiGianDen();
        return !thoiGianTu.after(thoiGianDen);
    }

    private boolean checkValidDV() {
        return !Objects.equals(viewXuatBCCCCN.getTenDonVi(), "");
    }

    public void TimKiemClicked() throws Exception {
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
            TimKiem();
        } else {
            viewXuatBCCCCN.setDialog("Thời gian không hợp lệ");

        }
    }

    public void QuayLaiClicked(MouseEvent mouseEvent) {
        viewXuatBCCCCN.close();
    }

    public void showView() {
        viewXuatBCCCCN.show();
    }

    public void XuatBaoCaoClicked() throws Exception {
        if (dataList == null) {
            viewXuatBCCCCN.setDialog("Vui lòng tìm kiếm trước khi xuất báo cáo");
            return;
        }
        if (viewXuatBCCCCN.isCSVButtonSelected()) {
            CSVXuatBaoCaoClicked();
            viewXuatBCCCCN.setDialog("Xuất báo cáo thành công");
        }
        if (viewXuatBCCCCN.isExcelButtonSelected()) {
            ExcelXuatBaoCaoClicked();
            viewXuatBCCCCN.setDialog("Xuất báo cáo thành công");
        }
        if (viewXuatBCCCCN.isCSVButtonSelected() == false && viewXuatBCCCCN.isExcelButtonSelected() == false) {
            viewXuatBCCCCN.setDialog("Vui lòng chọn định dạng xuất báo cáo");
        }
    }

    public void TimKiem() throws Exception {
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
                    String gioTangCa = String.valueOf(serviceTinhThoiGian.tongSoGioLamViec(listBanGhiChamCong));
                    if (gioLamViec.equals("0.0") && gioTangCa.equals("0.0")) {
                        thoiGianTu = thoiGianTu.plusMonths(1);
                        continue;
                    }
                    DataModel dataModel = new DataModel(hoten, maNV, donVi, thang, nam, gioLamViec, gioTangCa);
                    viewXuatBCCCCN.LoadTable(viewXuatBCCCCN.data);
                    viewXuatBCCCCN.data.add(dataModel);

                    thoiGianTu = thoiGianTu.plusMonths(1);
                    dataList.add(dataModel);
                }


            }
        }


    }

    public void CSVXuatBaoCaoClicked() throws Exception {
        Path filePath = Path.of("outputCSV.csv");
        List<String[]> writeData = new ArrayList<>();
        String[] header = {"Họ và tên", "Mã NV", "Đơn vị", "Tháng", "Năm", "Giờ làm việc", "Giờ tăng ca"};
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

    public void ExcelXuatBaoCaoClicked() throws Exception {

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
        headerCell.setCellValue("Giờ tăng ca");
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

    public static void main(String[] args) {
        launch(args);
    }

}
