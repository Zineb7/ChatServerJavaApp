package com.example.chatclients;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.*;
import java.net.Socket;

public class Scene2Controller {
    @FXML
    private TextField MymsgID;

    @FXML
    private TextField PortID;
    @FXML
    private TextField HostID;
    @FXML
    private Label test;
    @FXML
    private ListView<String> testview;
    PrintWriter pw;
    Socket s;

    @FXML
    protected void onconnect() throws Exception {
        String host = HostID.getText();
        int port = Integer.parseInt(PortID.getText());

        // Établissement de la connexion Socket avec le serveur
        s = new Socket(host, port);
        InputStream is = s.getInputStream(); // Flux d'entrée pour recevoir les données du serveur (octets)
        InputStreamReader isr = new InputStreamReader(is); // Convertit les octets en caractères
        BufferedReader br = new BufferedReader(isr); // Lit les caractères du flux
        OutputStream os = s.getOutputStream(); // Flux de sortie pour envoyer les données au serveur
        String ipAddress = s.getRemoteSocketAddress().toString(); // Adresse IP du serveur distant
        pw = new PrintWriter(os, true); // PrintWriter pour envoyer les données avec un flux de sortie

        // Thread pour recevoir les messages du serveur en continu
        new Thread(() -> {
            while (true) {
                try {
                    String response = br.readLine(); // Lecture du message du serveur
                    Platform.runLater(() -> {
                        testview.getItems().add(response); // Ajout du message à la liste des messages dans l'interface utilisateur
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @FXML
    public void onsubmit() {
        String message = MymsgID.getText(); // Récupération du message saisi par l'utilisateur
        pw.println(message); // Envoi du message au serveur via le PrintWriter
    }
}
