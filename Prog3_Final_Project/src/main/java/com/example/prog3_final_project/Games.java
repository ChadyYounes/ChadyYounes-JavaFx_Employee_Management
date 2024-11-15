package com.example.prog3_final_project;

public class Games {
    private String Name;
    private String Type;
    private double Price;

    public Games(String Name,String Type,double Price){
        this.Name = Name;
        this.Type = Type;
        //if (Integer.parseInt(Price)>0){
            this.Price = Price;
       // }
       // else{
        //    Alert alert = new Alert(Alert.AlertType.ERROR);
         //   alert.setHeaderText(null);
         //  alert.setContentText("Invalid Price!");
         // alert.showAndWait();
      // }
    }

    public double getPrice() {
        return Price;
    }

   // public void setPrice(String price) {
      //  if(Integer.parseInt(Price)>0){
      //  Price = price;}
  //  }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
