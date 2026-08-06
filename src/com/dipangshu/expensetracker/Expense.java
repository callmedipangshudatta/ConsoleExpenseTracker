// Represent one Expense

package com.dipangshu.expensetracker;

//Represent one expense : contains only data
public class Expense {

    //fields
    private int id;
    private double amount;
    // Used to group expenses (Food, Travel, Bills, etc.)
    // Helps in searching and generating spending reports.
    private String category;
    private String description;
    private String date;

    //constructor
    public Expense(int id,
                   double amount,
                   String category,
                   String description,
                   String date){
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }

    //getter : because the fields are private other classes can't access them directly
    public int getId(){
        return id;
    }
    public double getAmount(){
        return amount;
    }
    public String getCategory(){
        return category;
    }
    public String getDescription(){
        return description;
    }
    public String getDate(){
        return date;
    }

    //setter : Setters allow controlled modification of expense data.
    public void setId(int id){
        this.id = id;
    }
    public void setAmount(double amount){
        this.amount = amount;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setDate(String date){
        this.date = date;
    }

}
