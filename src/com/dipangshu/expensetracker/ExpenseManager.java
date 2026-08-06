//Manage and process one or more than one Expenses

package com.dipangshu.expensetracker;

import java.util.ArrayList;

//Store all expenses or Manage all expense
public class ExpenseManager {

    //1.
    //private : because no other class should be able
    // to delete the transactions

    //2.
    // this line creates a reference due to being private
    // think reference like an address
    // expenses is like reserving a place

    //3.Declaring "expenses" variable

    //4. Encapsulation
    private ArrayList<Expense> expenses;

    //constructor
    public ExpenseManager() {
        //here we are creating an actual Object
        //1. Initialization
        expenses = new ArrayList<>();
    }

    //Method - 1
    public void addExpense(Expense expense) {
        expenses.add(expense);
    }

    //Method - 2
    public void viewExpenses() {

        //Expense : data-type
        //expense : variable name
        //expenses : collection we're looping over
        for (Expense expense : expenses) {

            //Option - 1

            //System.out.println(expense);
            // Java internally does :
            // sout(expense.toString());

            //Option - 2
            System.out.println("ID: " + expense.getId());
            System.out.println("Amount: " + expense.getAmount());
            System.out.println("Category: " + expense.getCategory());
            System.out.println("Description: " + expense.getDescription());
            System.out.println("Date: " + expense.getDate());
        }
    }

    //Method - 3
    public void deleteExpense(int id) {

        //  found : it's like a memory of just in case we couldn't
        // find anything
        boolean found = false;
        for (int i = 0; i < expenses.size(); i++) {

            //expense : reference, and not storing whole obj
            Expense expense = expenses.get(i);
            if (expense.getId() == id) {
                expenses.remove(i);
                found = true;
                System.out.println("Expense deleted successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("Expense not found!");
        }
    }

    //Method - 4
    public void updateExpense(
            int id,
            double amount,
            String category,
            String description,
            String date
    ) {
        boolean found = false;
        for (int i = 0; i < expenses.size(); i++) {
            Expense expense = expenses.get(i);
            if (expense.getId() == id) {
                expense.setAmount(amount);
                expense.setCategory(category);
                expense.setDescription(description);
                expense.setDate(date);

                found = true;
                System.out.println("Expense updated successfully!");
                break;
            }
        }
        if (!found) {
            System.out.println("Expense not found!");
        }
    }

    //Method - 5
    //this method will eventually give us an Expense object
    public Expense searchExpense(int id) {
        for (Expense expense : expenses) {
            if (expense.getId() == id) {
                return expense;
            }
        }
        //No object exist
        return null;
    }

    //Method - 6
    //Calculate Total Expenses
    public double calculateTotalExpenses() {
        //sum : accumulator variable : accumulate values
        double total = 0;
        for (Expense expense : expenses) {
            total += expense.getAmount();
        }
        return total;
    }

    //Method - 7
    public Expense getHighestExpense() {
        if (expenses.isEmpty()) {
            return null;
        }
        Expense highest = expenses.get(0);
        for (Expense expense : expenses) {
            if (expense.getAmount() > highest.getAmount()) {
                highest = expense;
            }
        }
        return highest;
    }

    //Method - 8
    public Expense getLowestExpense() {
        if (expenses.isEmpty()) {
            return null;
        }
        Expense lowest = expenses.get(0);
        for (Expense expense : expenses) {
            if (expense.getAmount() < lowest.getAmount()) {
                lowest = expense;
            }
        }
        return lowest;
    }

    //Method - 9
    public double calculateCategoryTotalExpenses(String category) {
        double total = 0;
        for (Expense expense : expenses) {
            if (expense.getCategory().equalsIgnoreCase(category)) {
                total += expense.getAmount();
            }
        }
        return total;
    }

    public int getExpenseCount() {
        return expenses.size();
    }


}
