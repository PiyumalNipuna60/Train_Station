package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.BookingCustomer;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IncomeReportFromController {
    public Button btnBack;
    public TableColumn tblIncomeDate;
    public TableColumn tblIncome;
    public TableColumn tblOption;
    public TextField txtMonthlyIncome;
    public AnchorPane incomeAnchorPane;
    public TableView<BookingCustomer> tblReport;

    public void initialize() {
        try {
            loadTableData();
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private void loadTableData() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM booking");
        ObservableList<BookingCustomer> obList= FXCollections.observableArrayList();

        while (resultSet.next()){
            obList.add(
                    new BookingCustomer(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getString(10),
                            resultSet.getString(11),
                            resultSet.getString(12)
                    )
            );
        }
        tblReport.setItems(obList);
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        incomeAnchorPane.getChildren().clear();
    }
}
