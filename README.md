# ChatServerJavaApp
A Java ChatServer application for real-time communication between multiple clients.
# Java ChatServer Application

This repository contains the source code and documentation for a Java ChatServer application developed as part of the "ChatServer" project.

## Project Overview

The Java ChatServer application is designed to provide real-time communication between multiple clients. It allows clients to connect to a central server and exchange text messages securely and reliably. The server is capable of handling multiple client connections simultaneously and relaying messages between connected clients.

## How to Use

1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE (e.g., IntelliJ IDEA).

### Running the Server

3. Run the `ChatServer` application to start the chat server.

### Running the Clients

4. Run the `ChatClient` application for each client instance.

   For the first client:
   - Username: `admin`
   - Password: `admin`
   - Host: `localhost`
   - Port: `8080`

   For the second client:
   - Username: `admin`
   - Password: `admin`
   - Host: `localhost`
   - Port: `8080`

   (Repeat the same steps for additional clients.)

5. Start chatting between the clients through the graphical user interface.

## Features

- Establishes connections between clients and the server using sockets.
- Facilitates communication by relaying messages between connected clients.
- Manages client connections and provides unique identifiers for each client.
- Implements error handling for connection and communication issues.
- Utilizes JavaFX for graphical user interfaces (GUI).
- Maintains code structure and documentation for better maintainability.

## Future Enhancements

- Implement private messaging between specific clients.
- Introduce message encryption for enhanced security.
- Extend the user interface with additional features and customization options.

## Acknowledgments

This project was developed by CHAFIKI ZINEB.

## License

This project is licensed under the [MIT License](LICENSE).
