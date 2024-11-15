package com.example.prog3_final_project;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Suggestions {
    private boolean columnsAdded = false;
    TableView<Games> suggestTable = new TableView<>();
     Games game ;
    List<Games> gg = new ArrayList<>();
    NavBar nav = new NavBar();
    private static final String CSV_FILE_PATH = "C:\\Users\\chadi\\Desktop\\data\\suggestedgames.csv";
    private final ObservableList<Games> data =
            FXCollections.observableArrayList(
            );

    public Scene start() {
        suggestTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        suggestTable.setMinWidth(150);
        suggestTable.setMaxWidth(750);
        suggestTable.setMinHeight(50);
        suggestTable.setMaxHeight(450);

        BorderPane pane = new BorderPane();
        pane.setLeft(nav.start());
        //add button hbox
        Label Name = new Label("Employee first Name: ");
        Name.setStyle(" -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        TextField name = new TextField();

        Label Type = new Label("Employee Last Name: ");
        Type.setStyle(" -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        TextField type = new TextField();

        Label Price = new Label("Employee ID: ");
        Price.setStyle(" -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        TextField price = new TextField();



        HBox fields = new HBox(name, type, Price);
        fields.setPadding(new Insets(40, 0, 5, 250));

        GridPane txtfieldsgp = new GridPane();
        GridPane.setHalignment(Name, HPos.CENTER);
        GridPane.setValignment(Name, VPos.CENTER);

        GridPane.setHalignment(Type, HPos.CENTER);
        GridPane.setValignment(Type, VPos.CENTER);

        GridPane.setHalignment(Price, HPos.CENTER);
        GridPane.setValignment(Price, VPos.CENTER);



        txtfieldsgp.add(Name, 0, 0);
        txtfieldsgp.add(name, 0, 1);

        txtfieldsgp.add(Type, 1, 0);
        txtfieldsgp.add(type, 1, 1);

        txtfieldsgp.add(Price, 2, 0);
        txtfieldsgp.add(price, 2, 1);


        txtfieldsgp.setHgap(12);
        txtfieldsgp.setVgap(10);

        fields.getChildren().add(txtfieldsgp);
        //table view
        suggestTable.setStyle("-fx-text-fill : black;");
        suggestTable.setEditable(true);
        suggestTable.setItems(data);
        TableColumn<Games, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Games, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));

        TableColumn<Games, String> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        if (!columnsAdded) {
            // Add columns to table view
            suggestTable.getColumns().addAll(nameColumn, typeColumn, priceColumn);
            columnsAdded = true;
        }
        // Add the columns to the table
        // employeeTable.getColumns().addAll(fnameColumn,lnameColumn, idColumn, positionColumn,salaryColumn);

        Button addButton = new Button("Add");
        Image add_img = new Image("C:\\Users\\chadi\\Desktop\\images\\add-user.png");
        ImageView addView = new ImageView(add_img);
        addView.setFitWidth(25);
        addView.setFitHeight(25);
        addButton.setGraphic(addView);
        addButton.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        addButton.setPrefWidth(140);
        addButton.setPrefHeight(25);
        addButton.setAlignment(Pos.BASELINE_LEFT);
        addButton.setGraphicTextGap(20);
        addButton.setOnMouseEntered(e -> addButton.setStyle("-fx-background-color:#A36AC4;; -fx-text-fill: white; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'; -fx-scale-x: 1.05; -fx-scale-y: 1.05;"));
        addButton.setOnMouseExited(e -> addButton.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-weight: bold;-fx-font-size: 16px; -fx-font-family: 'Poppins'"));


        addButton.setOnAction(e -> {
            // code to add a new employee
            if (name.getText().trim().isEmpty() || type.getText().trim().isEmpty() || price.getText().trim().isEmpty()) {
                // show an error message if any of the fields are empty
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all the fields");
                alert.showAndWait();
                return;
            } else if (price.getText().trim().matches("\\d+") == false) {
                // show an error message if the ID field is not numeric
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please enter a numeric ID");
                alert.showAndWait();
                return;
            } else {
                suggestTable.setItems(data);

                data.add(new Games(
                        name.getText(),
                        type.getText(),
                        Double.parseDouble(price.getText())));


                name.clear();
                type.clear();
                price.clear();
                suggestTable.refresh();
            }


        });

        Button deleteButton = new Button("Delete");
        Image dlt_img = new Image("C:\\Users\\chadi\\Desktop\\images\\delete.png");
        ImageView dltView = new ImageView(dlt_img);
        dltView.setFitWidth(25);
        dltView.setFitHeight(25);
        deleteButton.setGraphic(dltView);
        deleteButton.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        deleteButton.setPrefWidth(140);
        deleteButton.setPrefHeight(25);
        deleteButton.setAlignment(Pos.BASELINE_LEFT);
        deleteButton.setGraphicTextGap(20);
        deleteButton.setOnMouseEntered(e -> deleteButton.setStyle("-fx-background-color:#A36AC4;; -fx-text-fill: white; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'; -fx-scale-x: 1.05; -fx-scale-y: 1.05;"));
        deleteButton.setOnMouseExited(e -> deleteButton.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-weight: bold;-fx-font-size: 16px; -fx-font-family: 'Poppins'"));


        deleteButton.setOnAction(e -> {

            Games selectedgame = suggestTable.getSelectionModel().getSelectedItem();

            if (selectedgame != null) {
                // Remove the selected employee from the table view
                suggestTable.getItems().remove(selectedgame);


            } else {
                // If no row is selected, show an error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please select a row to delete.");
                alert.showAndWait();
            }
        });



        Button ResetButton = new Button("Reset");
        Image ser_img = new Image("C:\\Users\\chadi\\Desktop\\images\\reset.png");
        ImageView serView = new ImageView(ser_img);
        serView.setFitWidth(25);
        serView.setFitHeight(25);
        ResetButton.setGraphic(serView);
        ResetButton.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        ResetButton.setPrefWidth(140);
        ResetButton.setPrefHeight(25);
        ResetButton.setAlignment(Pos.BASELINE_LEFT);
        ResetButton.setGraphicTextGap(20);
        ResetButton.setOnMouseEntered(e -> ResetButton.setStyle("-fx-background-color:#A36AC4;; -fx-text-fill: white; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'; -fx-scale-x: 1.05; -fx-scale-y: 1.05;"));
        ResetButton.setOnMouseExited(e -> ResetButton.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-weight: bold;-fx-font-size: 16px; -fx-font-family: 'Poppins'"));

        ResetButton.setOnAction(e -> {
            name.clear();
            type.clear();
            price.clear();

            suggestTable.refresh();
        });

        Button saveButton = new Button("Save");
        Image save_img = new Image("C:\\Users\\chadi\\Desktop\\images\\save.png");
        ImageView saveView = new ImageView(save_img);
        saveView.setFitWidth(25);
        saveView.setFitHeight(25);
        saveButton.setGraphic(saveView);
        saveButton.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        saveButton.setPrefWidth(140);
        saveButton.setPrefHeight(25);
        saveButton.setAlignment(Pos.BASELINE_LEFT);
        saveButton.setGraphicTextGap(20);
        saveButton.setOnMouseEntered(e -> saveButton.setStyle("-fx-background-color:#A36AC4;; -fx-text-fill: white; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'; -fx-scale-x: 1.05; -fx-scale-y: 1.05;"));
        saveButton.setOnMouseExited(e -> saveButton.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-weight: bold;-fx-font-size: 16px; -fx-font-family: 'Poppins'"));

        saveButton.setOnAction(e -> {
            writeProducts();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Data saved");
            alert.setHeaderText(null);
            alert.setContentText("Data has been saved to file.");
            alert.showAndWait();

        });



        HBox buttonBox = new HBox(addButton, deleteButton, ResetButton, saveButton);
        buttonBox.setSpacing(10);
        pane.setTop(buttonBox);
        buttonBox.setAlignment(Pos.TOP_CENTER);
        buttonBox.setPadding(new Insets(10, 10, 10, 200));

        GridPane gp = new GridPane();

        gp.add(fields, 0, 0);
        gp.add(buttonBox, 0, 1);

        BorderPane duo = new BorderPane();
        duo.setTop(gp);
        duo.setCenter(suggestTable);
        //  duo.setBottom(fields);
        pane.setCenter(duo);

        Scene scene = new Scene(pane, 1250, 650);
        return scene;
    }



    private void writeProducts() {
        File dataDir = new File("C:\\Users\\chadi\\Desktop\\data");

        if (!dataDir.exists())
            dataDir.mkdir();

        File emps = new File("C:\\Users\\chadi\\Desktop\\data\\suggestedgames.csv");


        try {
            PrintWriter output = new PrintWriter(emps);

            for (Games pr : data) {
                output.println(pr.getName() + "," + pr.getType() + "," + pr.getPrice());
            }

            output.close();

        } catch (FileNotFoundException e) {

        }

    }
}

