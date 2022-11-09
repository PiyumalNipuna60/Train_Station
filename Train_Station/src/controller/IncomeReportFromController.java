package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.BookingCustomer;

public class IncomeReportFromController {
    public Button btnBack;
    public TableColumn tblIncomeDate;
    public TableColumn tblIncome;
    public TableColumn tblOption;
    public TextField txtMonthlyIncome;
    public AnchorPane incomeAnchorPane;
    public TableView<BookingCustomer> tblReport;

    public void btnBackOnAction(ActionEvent actionEvent) {
    }
}
