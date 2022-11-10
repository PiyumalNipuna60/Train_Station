package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.BookingCustomer;
import util.CrudUtil;

import java.sql.Connection;
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
        colCusId.setCellValueFactory(new PropertyValueFactory("id"));
        colCusName.setCellValueFactory(new PropertyValueFactory("name"));
        colCusAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colCusTel.setCellValueFactory(new PropertyValueFactory("contact"));
        colCusFrom.setCellValueFactory(new PropertyValueFactory("trainFrom"));
        colCusTo.setCellValueFactory(new PropertyValueFactory("trainTo"));
        colCusTime.setCellValueFactory(new PropertyValueFactory("time"));
        colCusTrain.setCellValueFactory(new PropertyValueFactory("train"));
        colCusSeatNo.setCellValueFactory(new PropertyValueFactory("seatNo"));
        colCusClass.setCellValueFactory(new PropertyValueFactory("class"));
        colCusPrice.setCellValueFactory(new PropertyValueFactory("price"));
        colDate.setCellValueFactory(new PropertyValueFactory("Date"));

        try {
            loadAllBooking();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void loadAllBooking() throws ClassNotFoundException, SQLException {
        ResultSet result = CrudUtil.executeQuery("SELECT * FROM booking");
        ObservableList<BookingCustomer> obList = FXCollections.observableArrayList();
        while (result.next()) {
            obList.add(
                    new BookingCustomer(
                            result.getString("id"),
                            result.getString("name"),
                            result.getString("address"),
                            result.getString("contact"),
                            result.getString("trainFrom"),
                            result.getString("trainTo"),
                            result.getString("time"),
                            result.getString("train"),
                            result.getString("seatNo"),
                            result.getString("class"),
                            result.getString("price"),
                            result.getString("Date")
                    ));
        }
        tblCustomerBooking.setItems(obList);
    }


    public void btnBackOnAction(ActionEvent actionEvent) {
        customerAnchorPane.getChildren().clear();
    }

    public void btnPrintOnAction(ActionEvent actionEvent) {
    }
}
