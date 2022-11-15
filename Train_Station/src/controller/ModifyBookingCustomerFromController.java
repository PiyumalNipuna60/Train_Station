package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import model.BookingCustomer;
import util.CrudUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModifyBookingCustomerFromController {

    public Button btnModifyBooking;
    public TextField txtCusName;
    public TextField txtCusId;
    public TextField txtCusAddress;
    public TextField txtCusContact;
    public ComboBox cmbCusFrom;
    public ComboBox cmbCusTo;
    public ComboBox cmbCusTrain;
    public TextField txtCusPrice;
    public ComboBox cmbCusSeatNo;
    public Button btnDeleteBooking;
    public TextField txtTrainTime;
    public ComboBox cmbCusClass;
    public TableView tblCustomerBooking;
    public TableColumn colCusId;
    public TableColumn colCusName;
    public TableColumn colCusAddress;
    public TableColumn colCusFrom;
    public TableColumn colCusTel;
    public TableColumn colCusTo;
    public TableColumn colCusTime;
    public TableColumn colCusTrain;
    public TableColumn colCusSeatNo;
    public TableColumn colCusClass;
    public TableColumn colCusPrice;
    public TableColumn colCusDate;
    public TextField txtDate;


    public void btnModifyBookingOnAction(ActionEvent actionEvent) {
        BookingCustomer c = new BookingCustomer(
                txtCusId.getText(), txtCusName.getText(), txtCusAddress.getText(), txtCusContact.getText(),
                String.valueOf(cmbCusFrom.getValue()), String.valueOf(cmbCusTo.getValue()), txtTrainTime.getText(),
                String.valueOf(cmbCusTrain.getValue()), String.valueOf(cmbCusSeatNo.getValue()),
                String.valueOf(cmbCusClass.getValue()), txtCusPrice.getText(), txtDate.getText()
        );
        try {
            if (CrudUtil.executeUpdate("UPDATE booking SET name=?,address=?,contact=?,trainFrom=?, trainTo=?, time=?, train=?, seatNo=?, class=?, price=?,date=?  WHERE id=?",
                    c.getName(), c.getAddress(), c.getContact(), c.getTrainFrom(), c.getTrainTo(), c.getTime(), c.getTrain(), c.getSeatNo(), c.getClass(), c.getPrice(), c.getDate(), c.getId())) {
                new Alert(Alert.AlertType.CONFIRMATION, "Updated!").show();
//                    loadAllBooking();
            } else {
                new Alert(Alert.AlertType.WARNING, "Try Again!").show();
            }


        } catch (SQLException | ClassNotFoundException z) {
            z.printStackTrace();
            new Alert(Alert.AlertType.ERROR, z.getMessage()).show();
        }
    }

    public void txtSearchOnAction(ActionEvent actionEvent) {
        try {
            BookingCustomer b = searchingBooking(txtCusId.getText());
            if (b != null) {
                txtCusId.setText(b.getId());
                txtCusName.setText(b.getName());
                txtCusAddress.setText(b.getAddress());
                txtCusContact.setText(b.getContact());
                cmbCusFrom.setValue(b.getTrainFrom());
                cmbCusTo.setValue(b.getTrainTo());
                txtTrainTime.setText(b.getTime());
                cmbCusTrain.setValue(b.getTrain());
                cmbCusSeatNo.setValue(b.getSeatNo());
                cmbCusClass.setValue(b.getTrainClass());
                txtCusPrice.setText(b.getPrice());
                txtDate.setText(b.getDate());
            } else {
                new Alert(Alert.AlertType.WARNING, "Empty values!..").show();
            }
        } catch (SQLException | ClassNotFoundException x) {
            x.printStackTrace();
        }
    }

    private BookingCustomer searchingBooking(String text) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT * FROM booking WHERE id=?", text);


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
        }
        return null;
    }

    public void btnDeleteBookingOnAction(ActionEvent actionEvent) {
    }

    public void btnClearOnAction(ActionEvent actionEvent) {
    }

    public void btnPrintOnAction(ActionEvent actionEvent) {
    }

    public void textFields_Key_Releaseed(KeyEvent keyEvent) {
    }
}
