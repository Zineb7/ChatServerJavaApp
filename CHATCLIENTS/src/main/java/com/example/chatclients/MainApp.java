package com.example.chatclients;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("Scene1.fxml")); // Chargement du fichier FXML
        Scene scene = new Scene(fxmlLoader.load()); // Création de la scène à partir du fichier FXML
        stage.setTitle("Client's Chat APP!"); // Titre de la fenêtre
        stage.setScene(scene); // Définition de la scène pour la fenêtre
        stage.show(); // Affichage de la fenêtre
    }

    public static void main(String[] args) {
        launch();
    }
}
