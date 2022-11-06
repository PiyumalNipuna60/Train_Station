package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.BookingCustomer;
import model.Employee;
import util.CrudUtil;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class AddEmployeeFromController {
    public Button btnAddEmployee;
    public TextField txtEmpName;
    public TextField txtEmpId;
    public TextField txtEmpAddress;
    public TextField txtEmpTel;
    public TextField txtEmpAge;
    public TextField txtEmpSalary;
    public Button btnBack;
    public AnchorPane employeeAnchorPane;
    public TableView tblEmployee;
    public TableColumn colEmpId;
    public TableColumn colEmpName;
    public TableColumn colEmpAddress;
    public TableColumn colEmpAge;
    public TableColumn colEmpTel;
    public TableColumn colEmpSalary;
    LinkedHashMap<TextField,Pattern> map=new LinkedHashMap<>();


    public void initialize() {

        Pattern pattenId = Pattern.compile("^(E00-)[0-9]{3,5}$");
        Pattern pattenName = Pattern.compile("^[A-z ]{3,}$");
        Pattern pattenAddress = Pattern.compile("^[A-z0-9 ,/]{5,}$");
        Pattern pattenAge = Pattern.compile("^[0-9]{2}$");
        Pattern pattenTel = Pattern.compile("^(071|072|077|076|078|075)[0-9]{7}$");
        Pattern pattenSalary = Pattern.compile("^[1-9][0-9]*(.[0-9]{2})?$");

        map.put(txtEmpId, pattenId);
        map.put(txtEmpName, pattenName);
        map.put(txtEmpAddress, pattenAddress);
        map.put(txtEmpAge, pattenAge);
        map.put(txtEmpTel, pattenTel);
        map.put(txtEmpSalary, pattenSalary);

        colEmpId.setCellValueFactory(new PropertyValueFactory("id"));
        colEmpName.setCellValueFactory(new PropertyValueFactory("name"));
        colEmpAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colEmpAge.setCellValueFactory(new PropertyValueFactory("age"));
        colEmpTel.setCellValueFactory(new PropertyValueFactory("contact"));
        colEmpSalary.setCellValueFactory(new PropertyValueFactory("salary"));

        try {
            loadAllEmployee();
        } catch (SQLException | ClassNotFoundException X) {
            X.printStackTrace();
        }
    }

    private void loadAllEmployee() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM employee");
        ObservableList<Employee> obList = FXCollections.observableArrayList();

        while (resultSet.next()){
            obList.add(
              new Employee(
                      resultSet.getString("id"),
                      resultSet.getString("name"),
                      resultSet.getString("address"),
                      resultSet.getString("age"),
                      resultSet.getString("contact"),
                      resultSet.getString("salary")
              ));
        }
        tblEmployee.setItems(obList);
    }

    public void btnAddEmployeeOnAction() {
        Employee e=new Employee(
                txtEmpId.getText(),txtEmpName.getText(),txtEmpAddress.getText(),txtEmpAge.getText(),txtEmpTel.getText(),txtEmpSalary.getText()
        );

        try {
            if(CrudUtil.executeUpdate("INSERT INTO employee VALUES(?,?,?,?,?,?)",e.getId(),e.getName(),e.getAddress(),e.getAge(),e.getContact(),e.getSalary())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
                loadAllEmployee();
            }else {
                new Alert(Alert.AlertType.WARNING, "Not Saved!..").show();
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {

        try {
            Employee emp=search(txtEmpId.getText());
            if (emp==null){
                new Alert(Alert.AlertType.WARNING, "Empty values!..").show();
            }else {
                txtEmpId.setText(emp.getId());
                txtEmpName.setText(emp.getName());
                txtEmpAddress.setText(emp.getAddress());
                txtEmpAge.setText(emp.getAge());
                txtEmpTel.setText(emp.getContact());
                txtEmpSalary.setText(emp.getSalary());
            }


        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private Employee search(String text) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM employee WHERE id=?", text);
        if (resultSet.next()){
            return new Employee(
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

    public void btnBackOnAction(ActionEvent actionEvent) {
        employeeAnchorPane.getChildren().clear();
    }

    public void btnclearOnAction(ActionEvent actionEvent) {
        ClearFields();
    }

    private void ClearFields() {
        txtEmpId.clear();
        txtEmpName.clear();
        txtEmpAddress.clear();
        txtEmpAge.clear();
        txtEmpTel.clear();
        txtEmpSalary.clear();
    }

    public void textFields_Key_Releaseed(KeyEvent keyEvent) {
        Validation();

        if (keyEvent.getCode() == KeyCode.ENTER) {
            Object responds = Validation();

            if (responds instanceof TextField) {
                TextField textField = (TextField) responds;
                textField.requestFocus();
            } else {
                btnAddEmployeeOnAction();
            }
        }
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

    public void addError(TextField txtCus) {
        if (txtCus.getText().length() > 0) {
            txtCus.getParent().setStyle("-fx-border-color: red");
        }
        btnAddEmployee.setDisable(true);
    }

    public void removeError(TextField txtCus) {
        txtCus.getParent().setStyle("-fx-border-color: green");
        btnAddEmployee.setDisable(false);
    }




    public void btnEmployeeReportOnAction(ActionEvent actionEvent) {
    }


}
