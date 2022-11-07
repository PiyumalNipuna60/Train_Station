package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import model.Train;
import util.CrudUtil;

public class AddTrainFromController {
    public ComboBox cmbTrainTo;
    public ComboBox cmbTrainFrom;
    public TextField txtTrainId;
    public TextField txtTrainName;
    public Button btnAddTrain;
    public TextField txtStartTime;
    public TextField txtEndTime;
    public TableView tblAllTrain;
    public TableColumn colTrainTo;
    public TableColumn colTrainFrom;
    public TableColumn colTrainId;
    public TableColumn colTrainName;
    public TableColumn colTrainStartTime;
    public TableColumn colTrainEndTime;


    public void btnAddTrainOnAction(ActionEvent actionEvent) {
        Train t1=new Train(
                txtTrainId.getText(),txtTrainName.getText(),txtStartTime.getText(),txtEndTime.getText(),String.valueOf(cmbTrainFrom.getValue()),String.valueOf(cmbTrainTo.getValue())
        );

        try {
            if (CrudUtil.executeUpdate("INSERT INTO train VALUES (?,?,?,?,?,?)"),t1.getTrainId(),t1.getTrainName(),t1.getStartTime(),t1.getEndTime(),t1.getTrainFrom(),t1.getTrainTo()){
                new Alert(Alert.AlertType.CONFIRMATION,"Add Train!..").show();
            }else{
                new Alert(Alert.AlertType.WARNING,"Something wrong!..").show();
            }
        }catch (Exception e){

        }
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnclearOnAction(ActionEvent actionEvent) {
    }

    public void btnEmployeeReportOnAction(ActionEvent actionEvent) {
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {
    }
}
