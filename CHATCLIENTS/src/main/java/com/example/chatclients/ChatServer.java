package com.example.chatclients;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer extends Thread {
    private int clientNbre; // Nombre de clients connectés
    private List<Communication> clientsConnectes = new ArrayList<>(); // Liste des communications avec les clients connectés

    public static void main(String[] args) {
        new ChatServer().start();
    }

    @Override
    public void run() {
        try {
            ServerSocket ss = new ServerSocket(8080); // Création du socket du serveur sur le port 8080
            System.out.println("Le serveur essaie de sdémarrer ....");
            while (true) {
                Socket s = ss.accept(); // Accepter une nouvelle connexion de client
                ++clientNbre; // Incrémenter le nombre de clients connectés
                Communication newCommunication = new Communication(s, clientNbre); // Création d'une nouvelle communication pour le client
                clientsConnectes.add(newCommunication); // Ajouter la communication à la liste des clients connectés
                newCommunication.start(); // Démarrer la communication dans un thread séparé
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class Communication extends Thread {
        private Socket socket; // Socket de communication avec le client
        private int clientNumber; // Numéro du client

        Communication(Socket socket, int clientNumber) {
            this.socket = socket;
            this.clientNumber = clientNumber;
        }

        @Override
        public void run() {
            try {
                InputStream is = socket.getInputStream(); // Flux d'entrée pour recevoir les messages du client
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr); // Lecteur de flux pour lire les messages du client
                OutputStream os = socket.getOutputStream(); // Flux de sortie pour envoyer les messages aux clients
                String ip = socket.getRemoteSocketAddress().toString(); // Adresse IP du client
                System.out.println("Le client numéro " + clientNumber + " et son IP " + ip);
                PrintWriter pw = new PrintWriter(os, true); // Écrivain de flux pour envoyer les messages au client
                pw.println("Vous êtes le client " + clientNumber);
                pw.println("Envoyez le message que vous voulez .... :D ");
                while (true) {
                    String userRequest = br.readLine(); // Lire la demande du client
                    sendToAllClients(userRequest, socket); // Envoyer la demande à tous les autres clients connectés
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        void sendToAllClients(String userRequest, Socket senderSocket) throws IOException {
            for (Communication client : clientsConnectes) {
                if (client.socket != senderSocket) {
                    PrintWriter pw = new PrintWriter(client.socket.getOutputStream(), true);
                    pw.println(userRequest); // Envoyer la demande à chaque client connecté (sauf l'expéditeur)
                }
            }
        }
    }
}
