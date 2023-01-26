package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import util.CrudUtil;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class SignInFromController {
    public TextField txtFName;
    public TextField txtLName;
    public TextField txtAddress;
    public TextField txtContact;
    public TextField txtAge;
    public ComboBox cmbGender;
    public TextField txtUserName;
    public TextField txtPassword;
    public Button btnCancel;
    public Button btnSignIn;
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();



    public void btnSignInOnAction() {

    }

    public void btnCancelOnAction(ActionEvent actionEvent) {

    }

    public void signOnKeyReleased(KeyEvent keyEvent) {

    }
}
