package fightinggame.ui;

import fightinggame.users.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SettingsController extends SceneController {
    @FXML private TextField confirmPasswordField, passwordField, confirmDelete;
    @FXML private Label feedback, username;
    @FXML private Button changePasswordButton, goBack, deleteUser;
    private RemoteModelAccess remoteModelAccess = new RemoteModelAccess();

    public void updateView(){
        username.setText(getUser().getUserId().getUserId());
    }

    @FXML
    private void handleChangePassword(ActionEvent event) {
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();

        if (password.equals(confirmPassword)) {
            feedback.setText("Passwords do not match.");
            return;
        }

        User tempUser = new User(getUser().getUserId(), getUser().getUserData());
        tempUser.getUserData().changePassword(password);
        boolean changedPassword = remoteModelAccess.putUser(tempUser);

        if (changedPassword) {
            getUser().getUserData().changePassword(password);
            feedback.setText("Changed password!");
        } else {
            feedback.setText("Invalid password, only use letter and numbers.");
        }
    }

    @FXML
    private void handleDeleteUser(ActionEvent event){
        if (!confirmDelete.getText().equals("DELETE")){
            feedback.setText("To delete your user, type 'DELETE' in the field bellow");
        }

        if (remoteModelAccess.deleteUser(getUser())){
            Platform.exit();
        }
        feedback.setText("Could not delete user");
    }
}
