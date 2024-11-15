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

public class EmployeeScene {
    private boolean columnsAdded = false;
     TableView<Employee> employeeTable = new TableView<>();

     List<Employee> employees = new ArrayList<>();
    NavBar nav=new NavBar();
    private static final String CSV_FILE_PATH = "C:\\Users\\chadi\\Desktop\\data\\employees_javafx.csv";
    private final ObservableList<Employee> data =
            FXCollections.observableArrayList(
            );
    public Scene start(){
       employeeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        employeeTable.setMinWidth(150);
        employeeTable.setMaxWidth(750);
        employeeTable.setMinHeight(50);
        employeeTable.setMaxHeight(450);

       BorderPane pane =new BorderPane();
        pane.setLeft(nav.start());
        //add button hbox
        Label Fname = new Label("Employee first Name: ");
        Fname.setStyle(" -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        TextField FnameTextField = new TextField();

        Label Lname = new Label("Employee Last Name: ");
        Lname.setStyle(" -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        TextField LnameTextField = new TextField();

        Label id = new Label("Employee ID: ");
        id.setStyle(" -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        TextField idTextField = new TextField();

        Label Position = new Label("Employee Position: ");
        Position.setStyle(" -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        TextField positionTextField = new TextField();

        Label Salary = new Label("Employee Salary: ");
        Salary.setStyle(" -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        TextField SalaryTextField = new TextField();

        HBox fields = new HBox(FnameTextField,LnameTextField,idTextField,positionTextField,SalaryTextField);
        fields.setPadding(new Insets(40 , 0 , 5 , 90));

        GridPane txtfieldsgp = new GridPane();
        GridPane.setHalignment(Fname, HPos.CENTER);
        GridPane.setValignment(Fname, VPos.CENTER);

        GridPane.setHalignment(Lname, HPos.CENTER);
        GridPane.setValignment(Lname, VPos.CENTER);

        GridPane.setHalignment(id, HPos.CENTER);
        GridPane.setValignment(id, VPos.CENTER);

        GridPane.setHalignment(Position, HPos.CENTER);
        GridPane.setValignment(Position, VPos.CENTER);

        GridPane.setHalignment(Salary, HPos.CENTER);
        GridPane.setValignment(Salary, VPos.CENTER);

        txtfieldsgp.add(Fname , 0 , 0);
        txtfieldsgp.add(FnameTextField , 0 , 1);

        txtfieldsgp.add(Lname , 1 , 0);
        txtfieldsgp.add(LnameTextField , 1 , 1);

        txtfieldsgp.add(id , 2 , 0);
        txtfieldsgp.add(idTextField , 2 , 1);

        txtfieldsgp.add(Position , 3 , 0);
        txtfieldsgp.add(positionTextField , 3 , 1);

        txtfieldsgp.add(Salary , 4 , 0);
        txtfieldsgp.add(SalaryTextField , 4 , 1);
        txtfieldsgp.setHgap(12);
        txtfieldsgp.setVgap(10);

        fields.getChildren().add(txtfieldsgp);
        //table view
        employeeTable.setStyle("-fx-text-fill : black;");
        employeeTable.setEditable(true);
        employeeTable.setItems(data);
        TableColumn<Employee, String> fnameColumn = new TableColumn<>("First Name");
        fnameColumn.setCellValueFactory(new PropertyValueFactory<>("firstname"));

        TableColumn<Employee, String> lnameColumn = new TableColumn<>("Last Name");
        lnameColumn.setCellValueFactory(new PropertyValueFactory<>("lastname"));

        TableColumn<Employee, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Employee, String> positionColumn = new TableColumn<>("Position");
        positionColumn.setCellValueFactory(new PropertyValueFactory<>("position"));

        TableColumn<Employee, String> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));
        if (!columnsAdded) {
            // Add columns to table view
            employeeTable.getColumns().addAll(fnameColumn,lnameColumn, idColumn, positionColumn,salaryColumn);
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
            if (FnameTextField.getText().trim().isEmpty() ||LnameTextField.getText().trim().isEmpty()|| idTextField.getText().trim().isEmpty() || positionTextField.getText().trim().isEmpty()||SalaryTextField.getText().trim().isEmpty()) {
                // show an error message if any of the fields are empty
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please fill in all the fields");
                alert.showAndWait();
                return;
            } else if (idTextField.getText().trim().matches("\\d+") == false) {
                // show an error message if the ID field is not numeric
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Please enter a numeric ID");
                alert.showAndWait();
                return;
            }

             else{employeeTable.setItems(data);
                boolean idExists = employeeTable.getItems().stream()
                        .anyMatch(employee -> employee.getId().equals(idTextField.getText()));
                if (idExists) {
                    // show an error message if the ID already exists
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Duplicate ID");
                    alert.setHeaderText("The entered ID already exists in the table");
                    alert.showAndWait();
                    return;
                }
                data.add(new Employee(
                    FnameTextField.getText(),
                    LnameTextField.getText(),
                    idTextField.getText(),
                    positionTextField.getText(),
                    SalaryTextField.getText()));

                    FnameTextField.clear();
                LnameTextField.clear();
                    idTextField.clear();
                    positionTextField.clear();
                    SalaryTextField.clear();
                    employeeTable.refresh();
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

            Employee selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();

            if (selectedEmployee != null) {
                // Remove the selected employee from the table view
                employeeTable.getItems().remove(selectedEmployee);

                // Delete the selected employee from the CSV file
                try {
                    File file = new File("C:\\Users\\chadi\\Desktop\\data\\employees_javafx.csv");
                    File tempFile = new File("C:\\Users\\chadi\\Desktop\\data\\tempemployees_javafx.csv");

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                    String lineToRemove = selectedEmployee.getFirstname() + "," + selectedEmployee.getLastname() + "," + selectedEmployee.getId() + "," + selectedEmployee.getPosition() + "," + selectedEmployee.getSalary();

                    String currentLine;

                    while ((currentLine = reader.readLine()) != null) {
                        String trimmedLine = currentLine.trim();
                        if (trimmedLine.equals(lineToRemove)) continue;
                        writer.write(currentLine + System.getProperty("line.separator"));
                    }

                    writer.close();
                    reader.close();

                    if (!file.delete()) {
                        System.out.println("Could not delete file");
                        return;
                    }

                    if (!tempFile.renameTo(file)) {
                        System.out.println("Could not rename file");
                    }

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            } else {
                // If no row is selected, show an error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("Please select a row to delete.");
                alert.showAndWait();
            }


                });

        Button modifyButton = new Button("Modify");
        Image mod_img = new Image("C:\\Users\\chadi\\Desktop\\images\\edit-button.png");
        ImageView modView = new ImageView(mod_img);
        modView.setFitWidth(25);
        modView.setFitHeight(25);
        modifyButton.setGraphic(modView);
        modifyButton.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        modifyButton.setPrefWidth(140);
        modifyButton.setPrefHeight(25);
        modifyButton.setAlignment(Pos.BASELINE_LEFT);
        modifyButton.setGraphicTextGap(20);
        modifyButton.setOnMouseEntered(e -> modifyButton.setStyle("-fx-background-color:#A36AC4;; -fx-text-fill: white; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'; -fx-scale-x: 1.05; -fx-scale-y: 1.05;"));
        modifyButton.setOnMouseExited(e -> modifyButton.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-weight: bold;-fx-font-size: 16px; -fx-font-family: 'Poppins'"));


        modifyButton.setOnAction(e -> {
            String id1 = idTextField.getText();
            boolean found = false;
            employeeTable.refresh();
            for (Employee employee : employeeTable.getItems()) {
                if (employee.getId().equals(id1)) {
                    // Update the employee fields with the new values
                    employee.setFirstname(FnameTextField.getText());
                    employee.setLastname(LnameTextField.getText());
                    employee.setId(idTextField.getText());
                    employee.setPosition(positionTextField.getText());
                    employee.setSalary(SalaryTextField.getText());
                    found = true;
                    break;


                }
                employeeTable.refresh();
            }
            if (!found) {
                // Display an error message
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Employee not found");
                alert.setHeaderText(null);
                alert.setContentText("No employee with ID " + id1 + " was found.");
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
            FnameTextField.clear();
            LnameTextField.clear();
            idTextField.clear();
            positionTextField.clear();
            SalaryTextField.clear();
            employeeTable.refresh();
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
        Button Displaybutton = new Button("Display");
        Image dis_img = new Image("C:\\Users\\chadi\\Desktop\\images\\display.png");
        ImageView disView = new ImageView(dis_img);
        disView.setFitWidth(25);
        disView.setFitHeight(25);
        Displaybutton.setGraphic(disView);
        Displaybutton.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'");
        Displaybutton.setPrefWidth(140);
        Displaybutton.setPrefHeight(25);
        Displaybutton.setAlignment(Pos.BASELINE_LEFT);
        Displaybutton.setGraphicTextGap(20);
        Displaybutton.setOnMouseEntered(e -> Displaybutton.setStyle("-fx-background-color:#A36AC4;; -fx-text-fill: white; -fx-font-size: 15px;-fx-font-weight: bold; -fx-font-family: 'Poppins'; -fx-scale-x: 1.05; -fx-scale-y: 1.05;"));
        Displaybutton.setOnMouseExited(e -> Displaybutton.setStyle("-fx-background-color: #D3D3D3; -fx-text-fill: black; -fx-font-weight: bold;-fx-font-size: 16px; -fx-font-family: 'Poppins'"));

        Displaybutton.setOnAction(e -> {
            ObservableList<Employee> data1 = null;
            try {
                data1 = readCSVData(CSV_FILE_PATH);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            employeeTable.setItems(data1);

        });

                HBox buttonBox = new HBox(addButton, deleteButton, modifyButton, ResetButton, saveButton,Displaybutton);
                buttonBox.setSpacing(10);
                pane.setTop(buttonBox);
                buttonBox.setAlignment(Pos.TOP_CENTER);
                buttonBox.setPadding(new Insets(10 , 10 , 10  ,50));

                GridPane gp = new GridPane();

                gp.add(fields ,0 ,0);
                gp.add(buttonBox , 0 ,1);

                BorderPane duo = new BorderPane();
                duo.setTop(gp);
                duo.setCenter(employeeTable);
              //  duo.setBottom(fields);
                pane.setCenter(duo);

                Scene scene = new Scene(pane, 1250, 650);
                return scene;
            }
private ObservableList<Employee> readCSVData(String filePath) throws IOException{

    List<Employee> dataList = new ArrayList<>();
    BufferedReader reader = new BufferedReader(new FileReader(filePath));
    String line;
    while ((line = reader.readLine()) != null) {
        String[] fields = line.split(",");
        String firstName = fields[0];
        String lastName = fields[1];
        String id = fields[2];
        String position = fields[3];
        String salary = fields[4];
        Employee emp = new Employee(firstName, lastName, id , position , salary);
        dataList.add(emp);
    }
    return FXCollections.observableArrayList(dataList);
}
    private void writeProducts()
    {
        File dataDir = new File("C:\\Users\\chadi\\Desktop\\data");

        if(!dataDir.exists())
            dataDir.mkdir();

        File emps = new File("C:\\Users\\chadi\\Desktop\\data\\employees_javafx.csv");


        try {
            PrintWriter output = new PrintWriter(emps);

            for(Employee pr : data)
            {
                output.println(pr.getFirstname()+","+pr.getLastname()+","+pr.getId()+","+pr.getPosition()+","+pr.getSalary());
            }

            output.close();

        } catch (FileNotFoundException e) {

        }

    }
    public ObservableList<Employee> getEmployeesByPosition(String position) {
        return data.filtered(e -> e.getPosition().equals(position));
    }}


