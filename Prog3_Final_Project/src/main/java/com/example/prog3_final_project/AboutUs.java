package com.example.prog3_final_project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class AboutUs {
    public HBox start(){

                VBox root = new VBox();
                root.setStyle("-fx-background-color:white");
                root.setSpacing(20);
                root.setPadding(new Insets(20));
                root.setAlignment(Pos.CENTER);

                Label titleLabel = new Label("RETRO GAMES");
                titleLabel.setStyle("-fx-font-weight: bold;-fx-border-radius: 10px; -fx-font-size: 36pt; -fx-text-fill: white; -fx-background-color: #9400D3; -fx-padding: 10px; -fx-font-family: 'Poppins';");
                titleLabel.setAlignment(Pos.CENTER);
                titleLabel.setPrefWidth(400);
                root.getChildren().add(titleLabel);


                // Add the About Us section
                Label aboutLabel = new Label("  #About Us   ");
                aboutLabel.setStyle("-fx-font-weight: bold;-fx-text-align:center;-fx-padding:8px;-fx-font-family: 'Poppins'; -fx-font-size: 18pt;-fx-background-color: #9400D3; -fx-text-fill: white; ");
                root.getChildren().add(aboutLabel);

                Label aboutText = new Label("Retro Games is a premier online game shop dedicated to providing gamers with unforgettable experiences. \n" +
                        "We specialize in offering a wide range of retro and modern games for various platforms, carefully curated\n to satisfy " +
                        "your gaming nostalgia and cater to your desire for new adventures.");
                aboutText.setWrapText(true);
                aboutText.setTextAlignment(TextAlignment.CENTER);

                aboutText.setStyle("-fx-text-fill: black;-fx-font-weight: bold; -fx-font-size: 15px; -fx-font-family: 'Poppins';");
                root.getChildren().add(aboutText);

                // Add the Visual Quality section
                Label qualityLabel = new Label("   #Visual Quality   ");
                qualityLabel.setStyle("-fx-font-size: 18pt;-fx-text-align:center;-fx-padding:8px; -fx-background-color: #9400D3 ;-fx-font-weight: bold; -fx-text-fill: white; -fx-font-family: 'Poppins';");
                root.getChildren().add(qualityLabel);

                Label qualityText = new Label("At Retro Games, we understand the importance of stunning visuals in gaming. " +
                        "We are committed to delivering games\n that excel in graphics, artistry, and visual storytelling. " +
                        "Immerse yourself in breathtaking worlds, beautifully\n designed characters, and eye-catching animations.");
                qualityText.setWrapText(true);
                qualityText.setTextAlignment(TextAlignment.CENTER);
                qualityText.setStyle("-fx-text-fill: black;-fx-font-weight: bold; -fx-font-size: 15px; -fx-font-family: 'Poppins';");
                root.getChildren().add(qualityText);

                // Add the Gamer Experience section
                Label experienceLabel = new Label("   #Gamer Experience   ");
                experienceLabel.setStyle("-fx-font-size: 18pt;-fx-min-width:220px;-fx-text-align:center;-fx-padding:8px;-fx-font-weight: bold;-fx-background-color:  #9400D3; -fx-text-fill: white; -fx-font-family: 'Poppins';");
                root.getChildren().add(experienceLabel);

                Label experienceText = new Label("At Retro Games, we prioritize the gamer experience above all else. " +
                        "We believe that gaming should be a journey of excitement,\n challenge, and camaraderie. " +
                        "Explore captivating storylines, conquer formidable\n enemies, and engage in thrilling multiplayer battles. " +
                        "With Retro Games, your gaming adventures will be unforgettable.");
                experienceText.setWrapText(true);
                experienceText.setTextAlignment(TextAlignment.CENTER);
                experienceText.setStyle("-fx-text-fill: black;-fx-font-weight: bold;-fx-font-family: 'Poppins';-fx-font-size:15px;");
                root.getChildren().add(experienceText);

                // Add gaming-related photos
                GridPane photoGrid = new GridPane();
                photoGrid.setAlignment(Pos.CENTER);
                photoGrid.setHgap(20);
                // Load and display gaming-related photos
                Image image1 = new Image("C:\\Users\\chadi\\Desktop\\images\\console.png");
                ImageView imageView1 = new ImageView(image1);
                imageView1.setFitHeight(100);
                imageView1.setPreserveRatio(true);
                photoGrid.add(imageView1, 0, 0);

                Image image2 = new Image("C:\\Users\\chadi\\Desktop\\images\\ghost.png");
                ImageView imageView2 = new ImageView(image2);
                imageView2.setFitHeight(100);
                imageView2.setPreserveRatio(true);
                photoGrid.add(imageView2, 1, 0);


                root.getChildren().addAll(photoGrid);

        HBox MainHb = new HBox(root);
        return MainHb;
    }
}
