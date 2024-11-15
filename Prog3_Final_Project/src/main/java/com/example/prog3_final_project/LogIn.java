package com.example.prog3_final_project;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;

import java.sql.*;

public class LogIn {

    private Connection connection;
    NavBar nav =new NavBar();
    AboutUs Aboutus;
    GameScene game;

    private boolean customerlogin(String name, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customers where name = ? AND password=? ");
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() ) {
                String dbname = resultSet.getString("name");
                return dbname.equals(name);
            }
            if (resultSet.next() ) {
                String dbpass= resultSet.getString("password");
                return dbpass.equals(password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private boolean userlogin(String name, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users where name = ? AND password=? ");
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() ) {
                String dbname = resultSet.getString("name");
                return dbname.equals(name);
            }
            if (resultSet.next() ) {
                String dbpass= resultSet.getString("password");
                return dbpass.equals(password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    private boolean login(String name, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM admin where name = ? AND password=? ");
            statement.setString(1, name);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next() ) {
                String dbname = resultSet.getString("name");
                return dbname.equals(name);
            }
            if (resultSet.next() ) {
                String dbpass= resultSet.getString("password");
                return dbpass.equals(password);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Scene start() {
        BorderPane pane = new BorderPane();

        HBox main = new HBox(); //hbox for the main stage

        VBox loginSide = new VBox(); // vbox for the form side (right)
        VBox logoSide = new VBox(); // vbox for the logo side (left)
        Image logo = new Image("C:\\Users\\chadi\\Desktop\\images\\controller.png");
        ImageView logoImgView = new ImageView(logo);


        Text logintxt = new Text("WELCOME TO\n RETRO GAMES");
        logintxt.setTextAlignment(TextAlignment.CENTER);
        logintxt.setStyle("-fx-font-size: 30px; -fx-font-weight: bold; -fx-fill: purple; -fx-font-family: Impact");

        VBox welcome = new VBox(logintxt); //vbox for the  title welcome to retro games
        welcome.setAlignment(Pos.CENTER);
        welcome.setPadding(new Insets(10));

        // to center the login side and logo side
        double screenWidth = Screen.getPrimary().getVisualBounds().getWidth();
        double halfScreenWidth = screenWidth / 2;
        loginSide.setMinWidth(halfScreenWidth);
        logoSide.setMinWidth(halfScreenWidth);

        logoSide.setAlignment(Pos.CENTER);
        loginSide.setAlignment(Pos.CENTER);

        logoSide.getChildren().add(logoImgView);

        GridPane gridPane = new GridPane(); // for the login form
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);

        // Add labels and text fields for username and password
        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("Username");
        usernameTextField.setFocusTraversable(false);
        usernameTextField.setStyle("-fx-border-color: transparent; -fx-font-size: 16px;");

        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setPromptText("Password");
        passwordTextField.setFocusTraversable(false);
        passwordTextField.setStyle("-fx-border-color: transparent; -fx-font-size: 16px; ");

        gridPane.add(usernameTextField, 0, 0);
        gridPane.add(passwordTextField, 0, 1);

        // Add login button
        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(211);
        loginButton.setPrefHeight(20);
        loginButton.setStyle("-fx-background-color: purple; -fx-text-fill: white; -fx-font-size: 16px; -fx-font-family: Impact");

        gridPane.add(loginButton, 0, 10);

        // Request focus on the login button to prevent text fields from being selected
        loginButton.requestFocus();

        //Connect to the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/prog3", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            System.exit(1);
        }

        Aboutus = new AboutUs();
        loginButton.setOnAction(e -> {
            // Perform login logic here
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();
            // Check if username and password are correct
            game = new GameScene();
            if (login(username, password)) {
                // Open admin stage
                HelloApplication.currentUser = "Admin";
               // BorderPane pane1 = new BorderPane();

               // pane1.setLeft(nav.start());
                //pane1.setCenter(game.start());
                System.out.println(HelloApplication.currentUser);
                Scene scene = game.start();
                HelloApplication.stage.setScene(scene);

            } else if (userlogin(username , password)) {
                String splits [] = username.split("_");
                if(splits[0].equalsIgnoreCase("Emp"))
                    HelloApplication.currentUser="Employee";


                HelloApplication.currentUser = "Employee";
                // BorderPane pane1 = new BorderPane();

                // pane1.setLeft(nav.start());
                //pane1.setCenter(game.start());
                System.out.println(HelloApplication.currentUser);
                Scene scene = game.start();
                HelloApplication.stage.setScene(scene);}

             else if(customerlogin(username , password)){
                    String splits [] = username.split("_");
                    if(splits[0].equalsIgnoreCase("Cust"))
                        HelloApplication.currentUser="Customer";
                    BorderPane pane1 = new BorderPane();
                    pane1.setLeft(nav.start());
                    pane1.setCenter(Aboutus.start());
                    System.out.println(HelloApplication.currentUser);
                    Scene scene = new Scene(pane1, 1250, 650);
                    HelloApplication.stage.setScene(scene);

            } else {
                // Show error message and set borders to red
                usernameTextField.setStyle("-fx-border-color: red; -fx-font-size: 16px;");
                passwordTextField.setStyle("-fx-border-color: red; -fx-font-size: 16px;");
                Text errorText = new Text("Invalid username or password");
                errorText.setFill(Color.RED);
                gridPane.add(errorText, 0, 2);
            }

        });

        loginSide.getChildren().addAll(welcome, gridPane);
        main.getChildren().addAll(logoSide, loginSide);
        Scene scene = new Scene(main,1250,650 );

return scene;
    }
}


