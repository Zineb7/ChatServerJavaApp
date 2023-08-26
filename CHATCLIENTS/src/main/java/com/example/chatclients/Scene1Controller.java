package com.example.chatclients;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Scene1Controller {
    @FXML
    private TextField usernameID;
    @FXML
    private PasswordField passwordID;

    @FXML
    protected void onLogin() throws IOException {
        if (usernameID.getText().equals("admin") && passwordID.getText().equals("admin")) {
            // Récupérer le stage actuel
            Stage currentStage = (Stage) usernameID.getScene().getWindow();

            // Charger le fichier FXML de la deuxième scène
            FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Scene2.fxml"));
            Scene scene2 = new Scene(fxmlLoader.load());

            // Attacher la deuxième scène au stage
            currentStage.setScene(scene2);
        } else {
            // Afficher une alerte en cas d'erreur d'authentification
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Authentification Error");
            alert.setHeaderText("Username or password are not validated!");
            alert.setContentText("You can retry by changing the authentication information!");
            alert.show();
        }
    }
}
