package com.example.prog3_final_project;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class NavBar {
Suggestions sugg ;
    GameScene game;
    EmployeeScene employee;
    Cart cart;
    LogIn log_In;
    public VBox start(){
        Stage adminStage = new Stage();

        Image icon = new Image("C:\\Users\\chadi\\Desktop\\images\\mushroom.png");
        adminStage.getIcons().add(icon);
        adminStage.setTitle("Admin Panel");
        HBox main1 = new HBox();
        VBox nav = new VBox();

        HBox logoutBox = new HBox();

        GridPane bl = new GridPane();
        HBox buttonBox = new HBox();
        Image logo2 = new Image("C:\\Users\\chadi\\Desktop\\images\\profile.png");
        ImageView logo2ImgView = new ImageView(logo2);

        HBox imgBox = new HBox(logo2ImgView);

        logo2ImgView.setFitWidth(150);
        logo2ImgView.setFitHeight(150);
        imgBox.setPadding(new Insets(20,0,0,0));

        Button gamesbutton = new Button("Games");
        Image console_img = new Image("C:\\Users\\chadi\\Desktop\\images\\console.png");
        ImageView consoleView = new ImageView(console_img);
        consoleView.setFitWidth(25);
        consoleView.setFitHeight(25);
        gamesbutton.setGraphic(consoleView);

        Button employeebutton = new Button("Employees");
        Image employee_img = new Image("C:\\Users\\chadi\\Desktop\\images\\division.png");
        ImageView empView = new ImageView(employee_img);
        empView.setFitWidth(25);
        empView.setFitHeight(25);
        employeebutton.setGraphic(empView);

        Button cartbutton = new Button("Cart");
        Image cart_img = new Image("C:\\Users\\chadi\\Desktop\\images\\trolley.png");
        ImageView cartView = new ImageView(cart_img);
        cartView.setFitWidth(25);
        cartView.setFitHeight(25);
        cartbutton.setGraphic(cartView);

        Button logoutbutton = new Button("Logout");
        Image logout_img = new Image("C:\\Users\\chadi\\Desktop\\images\\door.png");
        ImageView outview = new ImageView(logout_img);
        outview.setFitWidth(25);
        outview.setFitHeight(25);
        logoutbutton.setGraphic(outview);

        Button suggestButton = new Button("Suggest");
        Image suggestButton_img = new Image("C:\\Users\\chadi\\Desktop\\images\\lamp.jpg");
        ImageView sugview = new ImageView(suggestButton_img);
        sugview.setFitWidth(25);
        sugview.setFitHeight(25);
        suggestButton.setGraphic(sugview);

        gamesbutton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        employeebutton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        cartbutton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        logoutbutton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        suggestButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-size: 16px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");

        bl.add(gamesbutton , 0 , 5);
        bl.add(employeebutton , 0 , 6);
        bl.add(cartbutton , 0 ,7);
        logoutBox.getChildren().add(logoutbutton);

        gamesbutton.setPrefWidth(140);
        gamesbutton.setPrefHeight(30);
        gamesbutton.setAlignment(Pos.BASELINE_LEFT);
        gamesbutton.setGraphicTextGap(20);
        gamesbutton.setOnMouseEntered(e -> gamesbutton.setStyle("-fx-background-color:#80cccc; -fx-font-size: 16px;-fx-font-weight: bold; -fx-font-family: 'Poppins'; -fx-scale-x: 1.1; -fx-scale-y: 1.1;"));
        gamesbutton.setOnMouseExited(e -> gamesbutton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-weight: bold;-fx-font-size: 16px; -fx-font-family: 'Poppins'"));

        employeebutton.setPrefWidth(140);
        employeebutton.setPrefHeight(30);
        employeebutton.setAlignment(Pos.BASELINE_LEFT);
        employeebutton.setGraphicTextGap(10);
        employeebutton.setOnMouseEntered(e -> employeebutton.setStyle("-fx-background-color: #80cccc; -fx-font-size: 16px;-fx-font-weight: bold; -fx-font-family: 'Poppins'; -fx-scale-x: 1.1; -fx-scale-y: 1.1;"));
        employeebutton.setOnMouseExited(e -> employeebutton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-weight: bold;-fx-font-size: 16px; -fx-font-family: 'Poppins'"));

        cartbutton.setPrefWidth(140);
        cartbutton.setPrefHeight(30);
        cartbutton.setAlignment(Pos.BASELINE_LEFT);
        cartbutton.setGraphicTextGap(30);
        cartbutton.setOnMouseEntered(e -> cartbutton.setStyle("-fx-background-color:#80cccc; -fx-font-size: 16px;-fx-font-weight: bold; -fx-font-family: 'Poppins'; -fx-scale-x: 1.1; -fx-scale-y: 1.1;"));
        cartbutton.setOnMouseExited(e -> cartbutton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-weight: bold;-fx-font-size: 16px; -fx-font-family: 'Poppins'"));

        logoutbutton.setPrefWidth(140);
        logoutbutton.setPrefHeight(30);
        logoutbutton.setAlignment(Pos.BASELINE_LEFT);
        logoutbutton.setGraphicTextGap(24);
        logoutbutton.setOnMouseEntered(e -> logoutbutton.setStyle("-fx-background-color:#8B0000;-fx-text-fill: white;-fx-font-weight: bold; -fx-font-size: 16px; -fx-font-family: 'Poppins'; -fx-scale-x: 1.1; -fx-scale-y: 1.1;"));
        logoutbutton.setOnMouseExited(e -> logoutbutton.setStyle("-fx-background-color: white; -fx-text-fill: black;-fx-font-weight: bold; -fx-font-size: 16px; -fx-font-family: 'Poppins'"));

        suggestButton.setPrefWidth(140);
        suggestButton.setPrefHeight(30);
        suggestButton.setAlignment(Pos.BASELINE_LEFT);
        suggestButton.setGraphicTextGap(30);
        suggestButton.setOnMouseEntered(e -> suggestButton.setStyle("-fx-background-color:#80cccc; -fx-font-size: 16px;-fx-font-weight: bold; -fx-font-family: 'Poppins'; -fx-scale-x: 1.1; -fx-scale-y: 1.1;"));
        suggestButton.setOnMouseExited(e -> suggestButton.setStyle("-fx-background-color: white; -fx-text-fill: black; -fx-font-weight: bold;-fx-font-size: 16px; -fx-font-family: 'Poppins'"));

        bl.setVgap(18);

        buttonBox.getChildren().add(bl);

        HBox txtBox = new HBox();
        Text welcometext = new Text("Welcome Admin!");
       txtBox.setAlignment(Pos.BASELINE_CENTER);
       txtBox.getChildren().add(welcometext);
        welcometext.setStyle("-fx-fill: white;-fx-font-size: 25px; -fx-font-weight: bold; -fx-font-family: 'Poppins'");

       txtBox.setPadding(new Insets(15 , 0,0,0));
        imgBox.setAlignment(Pos.TOP_CENTER);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setPadding(new Insets(20,0,0,0));
        logoutBox.setAlignment(Pos.BOTTOM_CENTER);
        logoutBox.setPadding(new Insets(100,0,0,0));


        nav.getChildren().addAll(imgBox,txtBox, buttonBox , logoutBox);
        nav.setPrefWidth(250);



        nav.setStyle("-fx-background-color:#9400D3");
        main1.getChildren().add(nav);




        game = new GameScene();
        employee = new EmployeeScene();
        cart = new Cart();
        sugg = new Suggestions();
        log_In = new LogIn();
        gamesbutton.setOnAction(e1 -> {
            HelloApplication.stage.setScene(game.start());

        });

        employeebutton.setOnAction(e ->{
                HelloApplication.stage.setScene(employee.start());
        });
        suggestButton.setOnAction(e ->{
            HelloApplication.stage.setScene(sugg.start());
        });

        cartbutton.setOnAction(e ->{
            HelloApplication.stage.setScene(cart.start());
        });

        logoutbutton.setOnAction(e ->{
            HelloApplication.stage.setScene(log_In.start());
        });

        if(HelloApplication.currentUser.equalsIgnoreCase("Employee")){
            bl.getChildren().remove(employeebutton);
            txtBox.getChildren().remove(welcometext);
           welcometext = new Text("Welcome Employee");

            welcometext.setStyle("-fx-fill: white;-fx-font-size: 25px; -fx-font-weight: bold; -fx-font-family: 'Poppins'");
            txtBox.getChildren().add(welcometext);
        }
        System.out.println(HelloApplication.currentUser);

        if(HelloApplication.currentUser.equalsIgnoreCase("Customer")){
            bl.getChildren().remove(employeebutton);
        bl.add(suggestButton , 0 ,6);

            txtBox.getChildren().remove(welcometext);
            welcometext = new Text("Welcome Customer");

            welcometext.setStyle("-fx-fill: white;-fx-font-size: 25px; -fx-font-weight: bold; -fx-font-family: 'Poppins'");
            txtBox.getChildren().add(welcometext);

        }
        return nav;
    }
}
