package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Train;
import util.CrudUtil;

import java.sql.SQLException;

public class ModifyTrainFromController {

    public Button btnRemoveTrain1;
    public Button btnBack;
    public ComboBox cmbTrainTo;
    public ComboBox cmbTrainFrom;
    public TextField txtTrainId;
    public TextField txtTrainName;
    public Button btnUpdateTrain;
    public TextField txtStartTime;
    public TextField txtEndTime;
    public AnchorPane trainAnchorPane;
    public TableView tblAllTrain;
    public TableColumn colTrainTo;
    public TableColumn colTrainFrom;
    public TableColumn colTrainId;
    public TableColumn colTrainName;
    public TableColumn colTrainStartTime;
    public TableColumn colTrainEndTime;



    public void btnUpdateTrainOnAction(ActionEvent actionEvent) {
        Train c=new Train(
                txtTrainId.getText(), txtTrainName.getText(), txtStartTime.getText(), txtEndTime.getText(), cmbTrainFrom.getValue(), cmbTrainTo.getValue());

        try {
            if (CrudUtil.executeUpdate("UPDATE train SET trainName=? ,startTime=? ,EndTime=? ,trainFrom=? ,trainTo=? WHERE trainId=? ",
                    c.getTrainName(),c.getStartTime(),c.getEndTime(),c.getTrainFrom(),c.getTrainTo(),c.getTrainId())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();

            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }

        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    public void btnRemoveTrainOnAction(ActionEvent actionEvent) {
        try {
            if(CrudUtil.executeUpdate("DELETE FROM train WHERE trainId=?",txtTrainId.getText())){
                new Alert(Alert.AlertType.CONFIRMATION, "Remove Train!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
    }

    public void btnclearOnAction(ActionEvent actionEvent) {
    }

    public void textFields_Key_Releaseed(KeyEvent keyEvent) {
    }



    public void btnEmployeeReportOnAction(ActionEvent actionEvent) {
    }
}
