package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import model.Train;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

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
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();

    public void initialize() {
        uploadComboBox();

        Pattern pattenId = Pattern.compile("^(T00-)[0-9]{3,5}$");
        Pattern pattenName = Pattern.compile("^[A-z ]{3,}$");
        Pattern patternStartTime = Pattern.compile("^([01]?[0-9]|2[0-3]).[0-5][0-9]$");
        Pattern pattenEndTime = Pattern.compile("^([01]?[0-9]|2[0-3]).[0-5][0-9]$");

        map.put(txtTrainId, pattenId);
        map.put(txtTrainName, pattenName);
        map.put(txtStartTime, patternStartTime);
        map.put(txtEndTime, pattenEndTime);


        colTrainId.setCellValueFactory(new PropertyValueFactory<>("trainId"));
        colTrainName.setCellValueFactory(new PropertyValueFactory<>("trainName"));
        colTrainStartTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        colTrainEndTime.setCellValueFactory(new PropertyValueFactory<>("EndTime"));
        colTrainFrom.setCellValueFactory(new PropertyValueFactory<>("trainFrom"));
        colTrainTo.setCellValueFactory(new PropertyValueFactory<>("trainTo"));

        try {
            loadTables();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void loadTables() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM train");
        ObservableList<Train> obList = FXCollections.observableArrayList();
        while (resultSet.next()) {
    obList.add(
      new Train(
              resultSet.getString("trainId"),
              resultSet.getString("trainName"),
              resultSet.getString("startTime"),
              resultSet.getString("endTime"),
              resultSet.getString("trainFrom"),
              resultSet.getString("trainTo")
      ));
        }
        tblAllTrain.setItems(obList);

    }

    private void uploadComboBox() {
        try {
            comboTrainFrom();
            comboTrainTo();
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }


    }

    private void comboTrainTo() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM station ORDER BY name ASC");
        ObservableList obList = FXCollections.observableArrayList();

        while (resultSet.next()) {
            obList.add(new String(resultSet.getString(2)));
        }
        cmbTrainTo.setItems(obList);
    }

    private void comboTrainFrom() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM station ORDER BY name ASC");
        ObservableList obList = FXCollections.observableArrayList();

        while (resultSet.next()) {
            obList.add(new String(resultSet.getString(2)));
        }
        cmbTrainFrom.setItems(obList);

    }


    public void btnAddTrainOnAction(ActionEvent actionEvent) {
        Train t1 = new Train(
                txtTrainId.getText(), txtTrainName.getText(), txtStartTime.getText(), txtEndTime.getText(), String.valueOf(cmbTrainFrom.getValue()), String.valueOf(cmbTrainTo.getValue())
        );

        try {
            if (CrudUtil.executeUpdate("INSERT INTO train VALUES (?,?,?,?,?,?)", t1.getTrainId(), t1.getTrainName(), t1.getStartTime(), t1.getEndTime(), t1.getTrainFrom(), t1.getTrainTo())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Add Train!..").show();
                loadTables();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something wrong!..").show();
            }
        } catch (Exception e) {

        }
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {

        try {
            Train t1 = searchTrain(txtTrainId.getText());

            if (t1 != null) {
                txtTrainId.setText(t1.getTrainId());
                txtTrainName.setText(t1.getTrainName());
                txtStartTime.setText(t1.getStartTime());
                txtEndTime.setText(t1.getEndTime());
                cmbTrainFrom.setValue(t1.getTrainFrom());
                cmbTrainTo.setValue(t1.getTrainTo());
            } else {

            }

        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }

    }

    private Train searchTrain(String text) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM train WHERE trainId=?", txtTrainId.getText());
        if (resultSet.next()) {
            return new Train(
                    resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6)
            );
        }
        return null;

    }

    public void btnclearOnAction(ActionEvent actionEvent) {
        txtTrainId.clear();
        txtTrainName.clear();
        txtStartTime.clear();
        txtEndTime.clear();
        cmbTrainFrom.getSelectionModel().clearSelection();
        cmbTrainTo.getSelectionModel().clearSelection();
    }

    public void textFields_Key_Released(KeyEvent keyEvent) {

    }

    private Object Validation() {
        for (TextField key : map.keySet()) {
            Pattern pattern = map.get(key);
            if (!pattern.matcher(key.getText()).matches()) {
                addError(key);
                return key;
            } else
                removeError(key);
        }
        return true;
    }

    private void removeError(TextField text) {
        text.getParent().setStyle("-fx-border-color: green");
        btnAddTrain.setDisable(false);
    }

    private void addError(TextField text) {
        if (text.getText().length() > 0) {
            text.getParent().setStyle("-fx-border-color: red");
        }
        btnAddTrain.setDisable(true);
    }

    public void btnEmployeeReportOnAction(ActionEvent actionEvent) {
    }
}
