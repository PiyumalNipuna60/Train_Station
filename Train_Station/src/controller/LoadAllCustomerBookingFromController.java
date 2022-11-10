package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

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


    public void btnBackOnAction(ActionEvent actionEvent) {
        customerAnchorPane.getChildren().clear();
    }

    public void btnPrintOnAction(ActionEvent actionEvent) {
    }


}
