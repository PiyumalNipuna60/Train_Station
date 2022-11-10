package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import model.BookingCustomer;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoadAllCustomerBookingFromController {

    public Button btnBack;
    public TableView tblCustomerBooking;
    public TableColumn colCusAddress;
    public TableColumn colCusId;
    public TableColumn colCusName;
    public TableColumn colCusTel;
    public TableColumn colCusFrom;
    public TableColumn colCusTo;
    public TableColumn colCusTime;
    public TableColumn colCusTrain;
    public TableColumn colCusSeatNo;
    public TableColumn colCusClass;
    public TableColumn colCusPrice;
    public AnchorPane customerAnchorPane;
    public TableColumn colDate;

    public void initialize() {
        try {
            loadData();
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private void loadData() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM booking");
        ObservableList<> obList= FXCollections.observableArrayList();
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
        tblCustomerBooking.setItems(obList);
    }

    public void btnBackOnAction(ActionEvent actionEvent) {
        customerAnchorPane.getChildren().clear();
    }

    public void btnPrintOnAction(ActionEvent actionEvent) {
    }


}
