package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class UserDashBordFromController {

    public Button btnBookingCustomer;
    public Button btnModifyCustomer;
    public Button btnLoadAllCustomer;
    public Button btnLoadSchedule;
    public Button btnMaintenance;
    public Button btnCheckSchedule;
    public Button btnLogOut;
    public Button btnCancel;
    public Label lblRealTime;
    public Label lblRealDate;
    public AnchorPane mainAnchorPane;
    public AnchorPane secondAnchorPane;


    public void btnBookingCustomerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddBookingCustomerFrom");
    }

    public void btnModifyCustomerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ModifyBookingCustomerFrom");
    }

    public void btnLoadAllCustomerOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoadAllCustomerBookingFrom");
    }

    public void btnLoadScheduleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoadAllTrainScheduleUserFrom");
    }

    public void btnMaintenanceOnAction(ActionEvent actionEvent) throws IOException {
        setUi("");
    }

    public void btnCheckScheduleOnAction(ActionEvent actionEvent) throws IOException {
        setUi("CheckTrainScheduleFrom");

    }

    public void btnCancelOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) btnCancel.getScene().getWindow();
        window.close();
    }

    public void setUi(String URL) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/" + URL + ".fxml"));
        secondAnchorPane.getChildren().setAll(pane);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) btnCancel.getScene().getWindow();
        window.close();
    }

    public void AllCustomerReportOnAction(ActionEvent actionEvent) {
    }

    public void AllTrainReportPOnAction(ActionEvent actionEvent) {

    }
}
