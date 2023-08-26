module com.example.chatclients {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.chatclients to javafx.fxml;
    exports com.example.chatclients;
}