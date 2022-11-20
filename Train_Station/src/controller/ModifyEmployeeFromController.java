package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import model.Employee;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyEmployeeFromController {
    public Button btnDeleteEmployee1;
    public Button btnBack;
    public TextField txtEmpSalary;
    public TextField txtEmpAge;
    public TextField txtEmpTel;
    public TextField txtEmpAddress;
    public TextField txtEmpId;
    public TextField txtEmpName;
    public Button btnUpdateEmployee;
    public TableView tblEmployee;
    public TableColumn colEmpId;
    public TableColumn colEmpName;
    public TableColumn colEmpAddress;
    public TableColumn colEmpAge;
    public TableColumn colEmpTel;
    public TableColumn colEmpSalary;


    public void btnDeleteEmployeeOnAction(ActionEvent actionEvent){
        try {
            if (CrudUtil.executeUpdate("DELETE FROM employee WHERE id=?", txtEmpId.getText())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Delete Employee..!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Something Wrong..!").show();
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }


    public void btnclearOnAction(ActionEvent actionEvent) {
        clearMethod();
    }

    private void clearMethod() {
        txtEmpId.clear();
        txtEmpName.clear();
        txtEmpAddress.clear();
        txtEmpAge.clear();
        txtEmpSalary.clear();
        txtEmpTel.clear();
    }


    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            ResultSet result = CrudUtil.executeQuery("SELECT * FROM employee WHERE id=?",txtEmpId.getText());
            if (result.next()) {
                txtEmpName.setText(result.getString(2));
                txtEmpAddress.setText(result.getString(3));
                txtEmpAge.setText(result.getString(4));
                txtEmpTel.setText(result.getString(5));
                txtEmpSalary.setText(result.getString(6));

            } else {
                new Alert(Alert.AlertType.WARNING, "Empty Result").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private Employee searchMethod(String empID) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM employee WHERE ID=?", empID);
        while (resultSet.next()) {
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

    public void btnUpdateEmployeeOnAction(ActionEvent actionEvent) {
        Employee c=new Employee(
                txtEmpId.getText(),txtEmpName.getText(),txtEmpAddress.getText(),txtEmpAge.getText(),txtEmpSalary.getText(),txtEmpTel.getText()
        );
        try {
            if (CrudUtil.executeUpdate("UPDATE employee SET name=? ,address=? ,age=? ,contact=? ,salary=?  WHERE id= ?",
                    c.getName(),c.getAddress(),c.getAge(),c.getContact(),c.getSalary(),c.getId())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void textFields_Key_Releaseed(KeyEvent keyEvent) {
    }


    public void btnEmployeeReportOnAction(ActionEvent actionEvent) {
    }
}
