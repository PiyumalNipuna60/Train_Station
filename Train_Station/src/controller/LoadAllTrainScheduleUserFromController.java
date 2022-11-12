package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

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
        loadTbaleData();
    }

    private void loadTbaleData() {

    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        AllEmployeeAnchorPane.getChildren().clear();
    }

    public void btnPrintOnAction(ActionEvent actionEvent) {

    }
}
