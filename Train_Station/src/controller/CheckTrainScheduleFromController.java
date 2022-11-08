package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.Train;
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
