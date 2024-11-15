module com.example.prog3_final_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.prog3_final_project to javafx.fxml;
    exports com.example.prog3_final_project;
}