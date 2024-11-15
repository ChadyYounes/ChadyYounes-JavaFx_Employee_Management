package com.example.prog3_final_project;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GameScene {
    private String filePath = "C:\\Users\\chadi\\Desktop\\data\\games.csv";
    static NavBar nav=new NavBar();
    private Cart cart = new Cart();
    Games game;
    public  Scene start(){
        BorderPane pane =new BorderPane();
        pane.setLeft(nav.start());
        GridPane gridofgames = new GridPane();
        gridofgames.setAlignment(Pos.CENTER);
        gridofgames.setHgap(40);
        gridofgames.setVgap(40);

        Text t1 = new Text("Click to add to cart!");
        t1.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 20px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        HBox hb = new HBox(t1);
        GridPane txtgrid = new GridPane();
        txtgrid.add(hb,0,0);
        txtgrid.setAlignment(Pos.TOP_CENTER);
        Image img1 = new Image("C:\\Users\\chadi\\Desktop\\images\\cyberpunl.png");
        ImageView img1_view = new ImageView(img1);
        img1_view.setFitWidth(150);
        img1_view.setFitHeight(200);
        clip(img1_view);
        resize(img1_view);
        img1_view.setOnMouseClicked(event -> {

            try {
                // save the data to the file
                writeToCSV(filePath,"Cyber Punk" , "Action" , String.valueOf(29.99));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Image img2= new Image("C:\\Users\\chadi\\Desktop\\images\\zombinis.jpg");
        ImageView img2_view = new ImageView(img2);
        img2_view.setFitWidth(150);
        img2_view.setFitHeight(200);
        clip(img2_view);
        resize(img2_view);
        img2_view.setOnMouseClicked(event -> {

            try {
                // save the data to the file
                writeToCSV(filePath,"Zombinis" , "Puzzle" , String.valueOf(19.99));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Image img3 = new Image("C:\\Users\\chadi\\Desktop\\images\\gta5.jpg");
        ImageView img3_view = new ImageView(img3);
        img3_view.setFitWidth(150);
        img3_view.setFitHeight(200);
        clip(img3_view);
        resize(img3_view);
        img3_view.setOnMouseClicked(event -> {
            try {
                // save the data to the file
                writeToCSV(filePath,"GTA5" , "Action" , String.valueOf(29.99));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        Image img4 = new Image("C:\\Users\\chadi\\Desktop\\images\\forza.jpg");
        ImageView img4_view = new ImageView(img4);
        img4_view.setFitWidth(150);
        img4_view.setFitHeight(200);
        clip(img4_view);
        resize(img4_view);
        img4_view.setOnMouseClicked(event -> {

            try {
                // save the data to the file
                writeToCSV(filePath,"Forza Horzion" , "Racing" , String.valueOf(60.0));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Image img5 = new Image("C:\\Users\\chadi\\Desktop\\images\\fifa23.jpeg");
        ImageView img5_view = new ImageView(img5);
        img5_view.setFitWidth(150);
        img5_view.setFitHeight(200);
        clip(img5_view);
        resize(img5_view);
        img5_view.setOnMouseClicked(event -> {
            try {
                // save the data to the file
                writeToCSV(filePath,"FIFA 23" , "Sports" , String.valueOf(34.99));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Image img6 = new Image("C:\\Users\\chadi\\Desktop\\images\\HalfLife.jpg");
        ImageView img6_view = new ImageView(img6);
        img6_view.setFitWidth(150);
        img6_view.setFitHeight(200);
        clip(img6_view);
        resize(img6_view);
        img6_view.setOnMouseClicked(event -> {

            try {
                // save the data to the file
                writeToCSV(filePath,"Half-Life 2" , "Action" , String.valueOf(59.99));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Image img7 = new Image("C:\\Users\\chadi\\Desktop\\images\\mario.jpg");
        ImageView img7_view = new ImageView(img7);
        img7_view.setFitWidth(150);
        img7_view.setFitHeight(200);
        clip(img7_view);
        resize(img7_view);
        img7_view.setOnMouseClicked(event -> {

            try {
                // save the data to the file
                writeToCSV(filePath,"Mario" , "Adventure" , String.valueOf(9.99));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Image img8 = new Image("C:\\Users\\chadi\\Desktop\\images\\zero.jpeg");
        ImageView img8_view = new ImageView(img8);
        img8_view.setFitWidth(150);
        img8_view.setFitHeight(200);
        clip(img8_view);
        resize(img8_view);
        img8_view.setOnMouseClicked(event -> {
            try {
                // save the data to the file
                writeToCSV(filePath,"Zero Dawn" , "Adventure" , String.valueOf(49.99));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Image img9 = new Image("C:\\Users\\chadi\\Desktop\\images\\nfl23.jpeg");
        ImageView img9_view = new ImageView(img9);
        img9_view.setFitWidth(150);
        img9_view.setFitHeight(200);
        clip(img9_view);
        resize(img9_view);

        img9_view.setOnMouseClicked(event -> {

            try {
                // save the data to the file
                writeToCSV(filePath,"NFL 23" , "Sports" , String.valueOf(29.99));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Image img10= new Image("C:\\Users\\chadi\\Desktop\\images\\pinkpanther.jpg");
        ImageView img10_view = new ImageView(img10);
        img10_view.setFitWidth(150);
        img10_view.setFitHeight(200);
        clip(img10_view);
        resize(img10_view);
        img10_view.setOnMouseClicked(event -> {

            try {
                // save the data to the file
                writeToCSV(filePath,"PinkPanther" , "Adventure" , String.valueOf(9.99));
            } catch (IOException e) {
                e.printStackTrace();
            }


        });

        Button b2 = new Button("New Bill");
        Image b2_img = new Image("C:\\Users\\chadi\\Desktop\\images\\bill.png");
        ImageView b2View = new ImageView(b2_img);
        b2View.setFitWidth(25);
        b2View.setFitHeight(25);
        b2.setGraphic(b2View);
        b2.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-size: 14px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        b2.setPrefWidth(140);
        b2.setPrefHeight(25);
        b2.setAlignment(Pos.BASELINE_LEFT);
        b2.setGraphicTextGap(20);
        b2.setOnMouseEntered(e -> b2.setStyle("-fx-background-color:#A36AC4;; -fx-text-fill: white; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'; -fx-scale-x: 1.05; -fx-scale-y: 1.05;"));
        b2.setOnMouseExited(e -> b2.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-weight: bold;-fx-font-size: 16px; -fx-font-family: 'Poppins'"));

        b2.setOnAction(e4->{
            try {
                // clear the contents of the file
                clearCSVFile(filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        HBox  invoice = new HBox();
        invoice.setAlignment(Pos.BASELINE_CENTER);
        invoice.getChildren().add(b2);
        gridofgames.add(img1_view,0,0);
        gridofgames.add(img2_view,1,0);
        gridofgames.add(img3_view,2,0);
        gridofgames.add(img4_view,3,0);
        gridofgames.add(img5_view,4,0);
        gridofgames.add(img6_view,0,1);
        gridofgames.add(img7_view,1,1);
        gridofgames.add(img8_view,2,1);
        gridofgames.add(img9_view,3,1);
        gridofgames.add(img10_view,4,1);
        BorderPane both = new BorderPane();
        both.setTop(txtgrid);
        both.setCenter(gridofgames);
        both.setBottom(invoice);
        pane.setCenter(both);
        Scene scene = new Scene(pane, 1250, 650);
        return scene;
    }
    public void clip(ImageView img){
        Rectangle clip = new Rectangle(150,200);
        clip.setArcWidth(30);
        clip.setArcHeight(30);
        img.setClip(clip);
    }

    public void resize(ImageView img){
        img.setOnMouseEntered(e -> img.setStyle("-fx-scale-x: 1.1; -fx-scale-y: 1.1;"));
        img.setOnMouseExited(e -> img.setStyle(""));

    }
    private void writeToCSV(String filePath, String name, String type, String price) throws IOException {
        // check if the file already exists
        boolean fileExists = Files.exists(Paths.get(filePath));

        // create a FileWriter object with append set to true to append to the file if it exists, or create a new file if it does not
        FileWriter writer = new FileWriter(filePath, true);

        // write the data to the file
        if (!fileExists) {
            // if the file does not exist, add a header row
            writer.write("Name,Type,Price\n");
        }
        writer.write(name + "," + type + "," + price + "\n");

        // close the writer
        writer.close();
    }
    private void clearCSVFile(String filePath) throws IOException {
        FileWriter writer = new FileWriter(filePath, false);

        // write an empty string to the file to clear its contents
        writer.write("");

        // close the writer
        writer.close();
    }
}








