package com.example.prog3_final_project;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    Games game;
    private final String filePath = "C:\\Users\\chadi\\Desktop\\data\\games.csv";
    final TableView<Games> tableView = new TableView<>();;
    private final ObservableList<Games> games =
            FXCollections.observableArrayList(
            );

    NavBar nav=new NavBar();

    public Scene start(){
        BorderPane pane =new BorderPane();
        pane.setLeft(nav.start());


        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.setMinWidth(150);
        tableView.setMaxWidth(750);
        tableView.setMinHeight(50);
        tableView.setMaxHeight(450);
        // Bind the table view to the observable list

        //tableView.setItems(games);
        // Add the columns to the table view
        TableColumn<Games, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        tableView.getColumns().add(nameColumn);

        TableColumn<Games, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableView.getColumns().add(typeColumn);


        TableColumn<Games, Double> priceColumn = new TableColumn<>("Price");
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        tableView.getColumns().add(priceColumn);

        Button Display = new Button("Display Bill");
        Image Display_img = new Image("C:\\Users\\chadi\\Desktop\\images\\bill1.png");
        ImageView DisplayView = new ImageView(Display_img);
        DisplayView.setFitWidth(25);
        DisplayView.setFitHeight(25);
        Display.setGraphic(DisplayView);
        Display.setStyle("-fx-background-color: #D3D3D3;-fx-min-width:170px;-fx-text-fill: black; -fx-font-size: 14px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        Display.setPrefWidth(140);
        Display.setPrefHeight(25);
        Display.setAlignment(Pos.BASELINE_LEFT);
        Display.setGraphicTextGap(20);
        Display.setOnMouseEntered(e -> Display.setStyle("-fx-background-color:#A36AC4;;-fx-min-width:170px; -fx-text-fill: white; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'; -fx-scale-x: 1.05; -fx-scale-y: 1.05;"));
        Display.setOnMouseExited(e -> Display.setStyle("-fx-background-color: #D3D3D3;-fx-min-width:170px; -fx-text-fill: black; -fx-font-weight: bold;-fx-font-size: 16px; -fx-font-family: 'Poppins'"));

        Label Total = new Label("Total Bill: ");
        Total.setStyle(" -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");

        TextField totalPriceField = new TextField();
        totalPriceField.setEditable(false);
        totalPriceField.setStyle("-fx-padding:5px;");
        GridPane g = new GridPane();
        HBox hb1 = new HBox(Display);
        HBox hb0 = new HBox(Total , totalPriceField);
        hb0.setStyle("-fx-align-items:center;");

        g.add(hb1,0,0);
        g.add(hb0,0,1);

        g.setAlignment(Pos.BASELINE_CENTER);
        g.setHgap(15);
        g.setVgap(10);
        Display.setOnAction(e8->{
            try {
                // read data from CSV file
                ObservableList<Games> data = readCSVData(filePath);

                // set the items in the table view
                tableView.setItems(data);
            } catch (IOException e) {
                e.printStackTrace();
            }
            double totalPrice = 0.0;
            for (Games game : tableView.getItems()) {
                totalPrice += game.getPrice();
            }
            totalPriceField.setText(String.format("%.2f", totalPrice)+"$");

        });





        HBox h5 = new HBox();
        h5.setAlignment(Pos.BASELINE_CENTER);
        h5.setPadding(new Insets(20,0,0,0));
        h5.getChildren().add(g);
        BorderPane inner = new BorderPane();
        inner.setTop(h5);
        inner.setCenter(tableView);
        pane.setCenter(inner);
        Scene scene =new Scene(pane,1250,650);
        return scene;
    }

        // Create a new table row

    private ObservableList<Games> readCSVData(String filePath) throws IOException {
        List<Games> dataList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] fields = line.split(",");
            String Name = fields[0];
            String Type = fields[1];
            String Price = fields[2];

            Games game = new Games(Name, Type, Double.parseDouble(Price));
            dataList.add(game);
        }
        reader.close();
        return FXCollections.observableArrayList(dataList);
    }


}


