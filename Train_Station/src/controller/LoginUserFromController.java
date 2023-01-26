package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class LoginUserFromController {

    public Button btnUser;
    public PasswordField pwsUser;
    public TextField txtUserName;
    public Group btnCancel;

    public void btnUserLoginOnAction(ActionEvent actionEvent) throws IOException {

        if (Pattern.compile("^[a-zA-Z0-9]{0,10}$").matcher(txtUserName.getText()).matches()) {
            if (Pattern.compile("^[a-zA-Z0-9]{0,10}$").matcher(pwsUser.getText()).matches()) {
                if (txtUserName.getText().trim().equals("")) {
                    if (pwsUser.getText().trim().equals("")) {
                        Stage newStage = new Stage();
                        newStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/UserDashBordFrom.fxml"))));
                        newStage.show();
                        Stage window = (Stage) btnUser.getScene().getWindow();
                        window.close();
                    } else {
                        new Alert(Alert.AlertType.WARNING, "Wrong Password").show();
                    }
                } else {
                    new Alert(Alert.AlertType.WARNING, "Wrong User Name").show();
                }
            }
        }
    }


    public void btnCancelOnAction(MouseEvent mouseEvent) {
        Stage window = (Stage) btnCancel.getScene().getWindow();
        window.close();
    }
}
