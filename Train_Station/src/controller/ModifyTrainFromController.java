package controller;

import com.sun.org.apache.xpath.internal.objects.XObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Train;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

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
    LinkedHashMap<TextField, Pattern> map=new LinkedHashMap();

    public void initialize() {

        Pattern pattenId = Pattern.compile("^(T00-)[0-9]{3,5}$");
        Pattern pattenName = Pattern.compile("^[A-z ]{3,}$");
        Pattern patternStartTime = Pattern.compile("^([01]?[0-9]|2[0-3]).[0-5][0-9]$");
        Pattern pattenEndTime = Pattern.compile("^([01]?[0-9]|2[0-3]).[0-5][0-9]$");

        map.put(txtTrainId,pattenId);
        map.put(txtTrainName,pattenName);
        map.put(txtStartTime,patternStartTime);
        map.put(txtEndTime,pattenEndTime);

        colTrainId.setCellValueFactory(new PropertyValueFactory<>("trainId"));
        colTrainName.setCellValueFactory(new PropertyValueFactory<>("trainName"));
        colTrainTo.setCellValueFactory(new PropertyValueFactory<>("trainTo"));
        colTrainFrom.setCellValueFactory(new PropertyValueFactory<>("trainFrom"));
        colTrainStartTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        colTrainEndTime.setCellValueFactory(new PropertyValueFactory<>("EndTime"));

        try {
            loadtableData();
            loadComboBox();
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private void loadComboBox() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM station ORDER BY name ASC");
        ObservableList obList = FXCollections.observableArrayList();
        while (resultSet.next()) {
            obList.add(
                    resultSet.getString(2)
            );
        }
        cmbTrainTo.setItems(obList);
        cmbTrainFrom.setItems(obList);

    }

    private void loadtableData() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("Select * from train");
        ObservableList<Train> obList = FXCollections.observableArrayList();
        while (resultSet.next()) {
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


    public void btnUpdateTrainOnAction() {
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
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }


        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    public void textFields_Key_Releaseed(KeyEvent keyEvent) {
        validation();
        if (keyEvent.getCode()== KeyCode.ENTER){
            Object repond=validation();

            if (repond instanceof TextField){
                TextField textField=(TextField) repond;
                textField.requestFocus();
            }else {
                btnUpdateTrainOnAction();
            }
        }
    }

    private Object validation() {
        for (TextField key : map.keySet()) {
            Pattern pattern=map.get(key);
            if (!pattern.matcher(key.getText()).matches()){
                addError(key);
                return key;
            }else {
                removeError(key);
            }
        }
        return true;
    }

    public void addError(TextField txtCus) {
        if (txtCus.getText().length() > 0) {
            txtCus.getParent().setStyle("-fx-border-color: red");
        }

    }

    public void removeError(TextField txtCus) {
        txtCus.getParent().setStyle("-fx-border-color: green");

    }


    public void btnEmployeeReportOnAction(ActionEvent actionEvent) {
    }
}
