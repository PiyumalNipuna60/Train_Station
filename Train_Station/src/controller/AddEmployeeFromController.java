package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import model.Employee;
import util.CrudUtil;

import java.sql.SQLException;

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

    public void initialize() {

    }

    public void btnAddEmployeeOnAction(ActionEvent actionEvent) {
        Employee e=new Employee(
                txtEmpId.getText(),txtEmpName.getText(),txtEmpAddress.getText(),txtEmpAge.getText(),txtEmpTel.getText(),txtEmpSalary.getText()
        );

        try {
            if(CrudUtil.executeUpdate("INSERT INTO employee VALUES(?,?,?,?,?,?)",e.getId(),e.getName(),e.getAddress(),e.getAge(),e.getContact(),e.getSalary())){
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            }else {
                new Alert(Alert.AlertType.WARNING, "Not Saved!..").show();
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    public void SearchOnAction(ActionEvent actionEvent) {
    }

    public void textFields_Key_Releaseed(KeyEvent keyEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
    }

    public void btnEmployeeReportOnAction(ActionEvent actionEvent) {
    }

    public void btnclearOnAction(ActionEvent actionEvent) {
    }
}
