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

public class LoginAdminFromController {

    public Button btnAdmin;
    public PasswordField pwsAdmin;
    public TextField txtUserNameAdmin;
    public Group btnCancel1;

    public void btnAdminLoginOnAction(ActionEvent actionEvent) throws IOException {


    }

    public void btnCancelOnAction(MouseEvent mouseEvent) {
        Stage window = (Stage) btnCancel1.getScene().getWindow();
        window.close();
    }
}
