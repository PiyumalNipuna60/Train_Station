package controller;

import db.DBConnection;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminDashBordFromController {
    public Button btnCancel;
    public Label lblRealTime;
    public Label lblRealDate;
    public Button btnLogOut;
    public AnchorPane secondAnchorPane;
    public Button btnAddTrain;
    public Button btnModifyTrain;
    public Button btnLoadAllTrain;
    public Button btnModifyEmployee;
    public Button btnLoadAllEmployee;
    public Button btnAddEmployee;
    public Button btnIncomeReport;
    public Button btnSalaryReport;
    public AnchorPane mainAnchorPane;
    public Label CusCount;
    public Label TrainCount;
    public Label EmployeeCount;

    public void initialize() {
        generateRealTime();
    }


    public void btnAddTrainOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddTrainFrom");
    }

    public void btnModifyTrainOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ModifyTrainFrom");
    }

    public void btnLoadAllTrainOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoadAllTrainScheduleUserFrom");
    }

    public void btnAddEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("AddEmployeeFrom");
    }

    public void btnModifyEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ModifyEmployeeFrom");
    }

    public void btnLoadAllEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        setUi("LoadAllEmployeeFrom");
    }

    public void btnIncomeReportOnAction(ActionEvent actionEvent) throws IOException {
        setUi("IncomeReportFrom");
    }

    public void btnSalaryReportOnAction(ActionEvent actionEvent) throws IOException {
        setUi("EmployeeSalaryFrom");
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) {
        Stage window = (Stage) btnCancel.getScene().getWindow();
        window.close();
    }

    public void btnCancelOnAction(ActionEvent actionEvent) {
        Stage window = (Stage) btnCancel.getScene().getWindow();
        window.close();
    }


    private void setUi(String URI) throws IOException {
       AnchorPane pane=FXMLLoader.load(getClass().getResource("../views/" + URI + ".fxml"));
        secondAnchorPane.getChildren().setAll(pane);
    }

    private void generateRealTime() {
        lblRealDate.setText(LocalDate.now().toString());
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            lblRealTime.setText(LocalDateTime.now().format(formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    public void CusCountOnAction(MouseEvent mouseEvent) {
    }

    public void TrainCountOnAction(MouseEvent mouseEvent) {

    }

    public void EmployeeCountOnAction(MouseEvent mouseEvent) {

    }

    public void AllCustomerReportOnAction(ActionEvent actionEvent) {

    }

    public void AllEmployeeSalaryReportOnAction(ActionEvent actionEvent) {

    }

    public void AllTrainReportPOnAction(ActionEvent actionEvent) {

    }

    public void AllEmployeeReportOnAction(ActionEvent actionEvent) {

    }
}
    //SELECT COUNT(*) FROM information_schema.tables WHERE table_schema = 'dbName';