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

    public void btnEmployeeReportOnAction(ActionEvent actionEvent) {
    }

    public void btnclearOnAction(ActionEvent actionEvent) {
    }

    public void textFields_Key_Releaseed(KeyEvent keyEvent) {
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            Employee e1 = searchMethod(txtEmpId.getText());

            if (e1.equals(null)) {
                new Alert(Alert.AlertType.WARNING, "Empty Result..!").show();
            } else {
                txtEmpId.setText(e1.getId());
                txtEmpName.setText(e1.getName());
                txtEmpAddress.setText(e1.getAddress());
                txtEmpAge.setText(e1.getAge());
                txtEmpTel.setText(e1.getContact());
                txtEmpSalary.setText(e1.getSalary());
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
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
    }
}
