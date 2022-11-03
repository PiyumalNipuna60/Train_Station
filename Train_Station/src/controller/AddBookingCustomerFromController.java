package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import model.BookingCustomer;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddBookingCustomerFromController {
    public Button btnBooking;
    public TextField txtCusName;
    public TextField txtCusId;
    public TextField txtCusAddress;
    public TextField txtCusContact;
    public ComboBox cmbCusFrom;
    public ComboBox cmbCusTo;
    public ComboBox cmbCusTrain;
    public TextField txtCusPrice;
    public ComboBox cmbCusSeatNo;
    public TextField txtTrainTime;
    public ComboBox cmbCusClass;
    public TableView tblCustomerBooking;
    public TableColumn colCusId;
    public TableColumn colCusName;
    public TableColumn colCusAddress;
    public TableColumn colCusTel;
    public TableColumn colCusFrom;
    public TableColumn colCusTo;
    public TableColumn colCusTime;
    public TableColumn colCusTrain;
    public TableColumn colCusSeatNo;
    public TableColumn colCusClass;
    public TableColumn colCusPrice;
    public TextField txtCusBookDate;
    public TableColumn colDate;

    public void initialize() {
        uploadComboBox();
//        btnBooking.setDisable(true);
    }

    private void uploadComboBox() {
    }

    public void btnBookingOnAction(ActionEvent actionEvent) {
        BookingCustomer c = new BookingCustomer(
                txtCusId.getText(), txtCusName.getText(), txtCusAddress.getText(), txtCusContact.getText(),
                String.valueOf(cmbCusFrom.getValue()), String.valueOf(cmbCusTo.getValue()), txtTrainTime.getText(),
                String.valueOf(cmbCusTrain.getValue()), String.valueOf(cmbCusSeatNo.getValue()),
                String.valueOf(cmbCusClass.getValue()), txtCusPrice.getText(), txtCusBookDate.getText()
        );
        try {
            if (CrudUtil.executeUpdate("INSERT INTO booking VALUES(?,?,?,?,?,?,?,?,?,?,?,?)", c.getId(), c.getName(), c.getAddress(),
                    c.getContact(), c.getTrainFrom(), c.getTrainTo(), c.getTrain(), c.getSeatNo(), c.getTrainClass(), c.getPrice(), c.getPrice(), c.getDate())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Saved!..").show();
            } else {

            }
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            new Alert(Alert.AlertType.ERROR, throwables.getMessage()).show();
        }

    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
                BookingCustomer b = searchBooking(txtCusId.getText());

            } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private BookingCustomer searchBooking(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM booking WHERE id=?", id);

        if (resultSet.next()) {
           return new BookingCustomer(
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

            );
        }return null;
    }



    public void textFields_Key_Releaseed(KeyEvent keyEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
        ClearFields();
    }


    public void btnPrintOnAction(ActionEvent actionEvent) {
    }

    private void ClearFields() {
        txtCusName.clear();
        txtCusId.clear();
        txtCusAddress.clear();
        txtCusContact.clear();
        cmbCusFrom.getSelectionModel().clearSelection();
        cmbCusTo.getSelectionModel().clearSelection();
        cmbCusTrain.getSelectionModel().clearSelection();
        txtCusPrice.clear();
        cmbCusSeatNo.getSelectionModel().clearSelection();
        txtTrainTime.clear();
        cmbCusClass.getSelectionModel().clearSelection();
        txtCusBookDate.clear();
    }
}
