package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Train;
import model.TrainSchedulCheck;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadAllTrainScheduleUserFromController {

    public TableColumn colTrainTo;
    public TableColumn colTrainFrom;
    public TableColumn colTrainId;
    public TableColumn colTrainName;
    public TableColumn colTrainStartTime;
    public TableColumn colTrainEndTime;
    public TableView tblAllTrain;
    public AnchorPane AllEmployeeAnchorPane;

    public void initialize() {



        try {
            loadTbaleData();
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private void loadTbaleData() throws SQLException, ClassNotFoundException {
        ResultSet result = CrudUtil.executeQuery("SELECT * FROM train");
        ObservableList<Train> obList = FXCollections.observableArrayList();
        while (result.next()) {
            obList.add(
                    new Train(
                            result.getString("trainId"),
                            result.getString("trainName"),
                            result.getString("startTime"),
                            result.getString("endTime"),
                            result.getString("trainFrom"),
                            result.getString("trainTo")
                    )
            );

        }
        tblAllTrain.setItems(obList);

    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        AllEmployeeAnchorPane.getChildren().clear();
    }

    public void btnPrintOnAction(ActionEvent actionEvent) {

    }
}
