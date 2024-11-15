package com.example.prog3_final_project;

import javafx.scene.control.Alert;

public class Employee {
    private String Firstname;
    private String Lastname;
    private String Id;
    private String Position;
    private String Salary;

    public Employee(String Firstname, String Lastname, String Id, String Position, String Salary) {
        this.Firstname = Firstname;
        this.Lastname = Lastname;

        this.Id = Id;
        if(Position.equalsIgnoreCase("Cashier") || Position.equalsIgnoreCase("Stockmanager") || Position.equalsIgnoreCase("Cleaner")){
        this.Position = Position;
        }
        else
            this.Position = "training";

        if (Integer.parseInt(Salary)>0){
        this.Salary = Salary;
    }
         else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Invalid Salary!");
                alert.showAndWait();
            }
        }






    public String getFirstname() {
        return this.Firstname;
    }

    public void setFirstname(String firstname) {
        this.Firstname = firstname;
    }

    public String getLastname() {
        return this.Lastname;
    }

    public void setLastname(String lastname) {
        this.Lastname = lastname;
    }

    public String getId() {
        return this.Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public String getPosition() {
        return this.Position;
    }

    public void setPosition(String Position) {
        if(Position.equalsIgnoreCase("Cashier") || Position.equalsIgnoreCase("Stockmanager") || Position.equalsIgnoreCase("Cleaner")){
            this.Position = Position;
        }
        else
            this.Position = "training";
    }

    public String getSalary() {
        return this.Salary;
    }

    public void setSalary(String salary) {
        if (Integer.parseInt(Salary)>0){
            this.Salary = Salary;
        }
        else if (Integer.parseInt(Salary)<0){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Invalid Salary!");
            alert.showAndWait();
        }
        else if (salary.matches("\\d+") == false) {
            // show an error message if the ID field is not numeric
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Please enter a numeric ID");
            alert.showAndWait();
            return;
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Firstname='" + Firstname + '\'' +
                ", Lastname='" + Lastname + '\'' +
                ", Id='" + Id + '\'' +
                ", Position='" + Position + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}