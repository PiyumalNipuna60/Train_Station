package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.TrainSchedulCheck;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckTrainScheduleFromController {
    public AnchorPane ScheduleAnchorPane;
    public Button btnSearch;
    public ComboBox cmbTrainTo;
    public Button btnBack;
    public TableColumn tblTrainTo;
    public TableColumn tblTrainFrom;
    public TableColumn tblTrainName;
    public TableColumn tblTrainId;
    public ComboBox cmbTrainFrom;
    public TableView tblTrainLoad;
    public TableColumn tblTrainStartTime;
    public TableColumn tblTrainStopTime;
    public TableColumn tblTrainStartStation;
    public TableColumn tblTrainEndStation;
    public TableColumn tblEndTime;

    public void initialize() {
        uploadComboBox();

        tblTrainFrom.setCellValueFactory(new PropertyValueFactory("From"));
        tblTrainTo.setCellValueFactory(new PropertyValueFactory("To"));
        tblTrainId.setCellValueFactory(new PropertyValueFactory("TrainId"));
        tblTrainName.setCellValueFactory(new PropertyValueFactory("TrainName"));
        tblTrainStartTime.setCellValueFactory(new PropertyValueFactory("StartTrainTime"));
        tblEndTime.setCellValueFactory(new PropertyValueFactory("EndStationTime"));
        tblTrainStopTime.setCellValueFactory(new PropertyValueFactory("TrainStopTime"));
        tblTrainStartStation.setCellValueFactory(new PropertyValueFactory("TrainStartStation"));
        tblTrainEndStation.setCellValueFactory(new PropertyValueFactory("TrainEndStation"));

        loadTableData();
    }

    private void loadTableData() {
        try {
            ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM  stationSchedule");
            ObservableList<TrainSchedulCheck> obList = FXCollections.observableArrayList();

            while (resultSet.next()) {
                obList.add(
                        new TrainSchedulCheck(
                                resultSet.getString(1),
                                resultSet.getString(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getString(7),
                                resultSet.getString(8),
                                resultSet.getString(9)
                        ));
            }
            tblTrainLoad.setItems(obList);

        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private void uploadComboBox() {
        try {
            uploadFrom();
            uploadTo();
        } catch (SQLException | ClassNotFoundException cx) {
            cx.printStackTrace();
        }
    }

    private void uploadTo() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM station ORDER BY name ASC");
        ObservableList obList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            obList.add(resultSet.getString(2));
        }
        cmbTrainTo.setItems(obList);
    }

    private void uploadFrom() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM station ORDER BY name ASC");
        ObservableList obList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            obList.add(resultSet.getString(2));
        }
        cmbTrainFrom.setItems(obList);
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try {
            searchTrain(cmbTrainFrom.getValue(), cmbTrainTo.getValue());
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private void searchTrain(Object value, Object value1) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM  stationSchedule where cusFrom='" + value + "' && cusTo='" + value1 + "'");
        ObservableList<TrainSchedulCheck> obList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            obList.add(
                    new TrainSchedulCheck(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9)
                    ));
        }
        tblTrainLoad.setItems(obList);
    }


    public void btnBackOnAction(ActionEvent actionEvent) {
    }

    public void btnPrintOnAction(ActionEvent actionEvent) {
    }
}
