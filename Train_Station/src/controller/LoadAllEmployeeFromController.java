package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Employee;
import util.CrudUtil;


import java.io.IOException;
import java.sql.*;

public class LoadAllEmployeeFromController {
    public Button btnUpdate;
    public Button btnBack;
    public TableView tblEmployee;
    public TableColumn colEmpId;
    public TableColumn colEmpName;
    public TableColumn colEmpAddress;
    public TableColumn colEmpAge;
    public TableColumn colEmpTel;
    public TableColumn colEmpSalary;
    public AnchorPane employeeAnchorPane;

    public void initialize() {


        try {
            loadAllEmployee();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadAllEmployee() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.executeQuery("SELECT * FROM employee");
        ObservableList<Employee> obList = FXCollections.observableArrayList();
        while (result.next()) {
            obList.add(
                    new Employee(
                            result.getString("id"),
                            result.getString("name"),
                            result.getString("address"),
                            result.getString("age"),
                            result.getString("contact"),
                            result.getString("salary")
                    ));
        }
        tblEmployee.setItems(obList);
    }


    public void btnUpdateOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/ModifyEmployeeFrom.fxml"));
        employeeAnchorPane.getChildren().setAll(pane);
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        employeeAnchorPane.getChildren().clear();
    }

    public void btnPrintOnAction(ActionEvent actionEvent) {

    }
}
