package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Train;
import util.CrudUtil;

import java.sql.ResultSet;
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

    public void initialize(){

        colTrainId.setCellValueFactory(new PropertyValueFactory<>("trainId"));
        colTrainName.setCellValueFactory(new PropertyValueFactory<>("trainName"));
        colTrainTo.setCellValueFactory(new PropertyValueFactory<>("trainTo"));
        colTrainFrom.setCellValueFactory(new PropertyValueFactory<>("trainFrom"));
        colTrainStartTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        colTrainEndTime.setCellValueFactory(new PropertyValueFactory<>("EndTime"));


        try {
            loadtableData();
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private void loadtableData() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("Select * from train");
        ObservableList<Train> obList= FXCollections.observableArrayList();
        while (resultSet.next()){
            obList.add(
                    new Train(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        tblAllTrain.setItems(obList);
    }


    public void btnUpdateTrainOnAction(ActionEvent actionEvent) {
        Train c = new Train(
                txtTrainId.getText(), txtTrainName.getText(), txtStartTime.getText(), txtEndTime.getText(), cmbTrainFrom.getValue(), cmbTrainTo.getValue());

        try {
            if (CrudUtil.executeUpdate("UPDATE train SET trainName=? ,startTime=? ,EndTime=? ,trainFrom=? ,trainTo=? WHERE trainId=? ",
                    c.getTrainName(), c.getStartTime(), c.getEndTime(), c.getTrainFrom(), c.getTrainTo(), c.getTrainId())) {
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
            if (CrudUtil.executeUpdate("DELETE FROM train WHERE trainId=?", txtTrainId.getText())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Remove Train!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        trainAnchorPane.getChildren().clear();
    }

    public void btnclearOnAction(ActionEvent actionEvent) {
        clearMethod();
    }

    private void clearMethod() {
        txtTrainId.clear();
        txtTrainName.clear();
        txtEndTime.clear();
        txtStartTime.clear();
        cmbTrainFrom.getSelectionModel().clearSelection();
        cmbTrainTo.getSelectionModel().clearSelection();
    }


    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            ResultSet result = CrudUtil.executeQuery("SELECT * FROM train WHERE trainId=?", txtTrainId.getText());
            if (result.next()) {
                txtTrainName.setText(result.getString(2));
                txtStartTime.setText(result.getString(3));
                txtEndTime.setText(result.getString(4));
                cmbTrainFrom.setValue(result.getString(5));
                cmbTrainTo.setValue(result.getString(6));
            }else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }


        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    public void textFields_Key_Releaseed(KeyEvent keyEvent) {
    }


    public void btnEmployeeReportOnAction(ActionEvent actionEvent) {
    }
}
