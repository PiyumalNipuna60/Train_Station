package controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginDashBordFormController {
    public Label lblRealTime;
    public Label lblRealDate;
    public Button btnSignIn;
    public Button btnAdmin;
    public Button btnUser;

    public void initialize(){
        generateRealTime();
    }

    public void btnUserLoginOnAction(ActionEvent actionEvent) {

    }

    public void btnAdminLoginOnAction(ActionEvent actionEvent) {

    }

    public void btnSignInOnAction(ActionEvent actionEvent) {

    }

    public void setUi(String URI) throws IOException {
        Parent parents = FXMLLoader.load(getClass().getResource("../views/" + URI + ".fxml"));
        Stage stage=new Stage();
        stage.setScene(new Scene(parents));
        stage.setTitle(URI);
        stage.show();
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
}
