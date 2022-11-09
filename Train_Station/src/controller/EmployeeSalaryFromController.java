package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import model.Employee;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeSalaryFromController {
    public Button btnBack;
    public TableColumn tblEmpId;
    public TableColumn tblEmpName;
    public TableColumn tblEmpAddress;
    public TableColumn tblEmpAge;
    public TableColumn tblEmpTel;
    public TableColumn tblEmpSalary;
    public Button btnUpdate;
    public TableView tblEmployee;
    public AnchorPane salaryAnchorPane;

    public void initialize() {

        tblEmpId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblEmpName.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblEmpAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        tblEmpAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        tblEmpTel.setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblEmpSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        try {
            loadTableData();
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private void loadTableData() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM employee");
        ObservableList<Employee> obList= FXCollections.observableArrayList();
        while (resultSet.next()){
            obList.add(
                    new Employee(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6)
                    )
            );
        }
        tblEmployee.setItems(obList);
    }


    public void btnUpdateOnAction(ActionEvent actionEvent) {
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
    }

    public void btnPrintOnAction(ActionEvent actionEvent) {
    }
}
