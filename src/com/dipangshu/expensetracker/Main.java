//Ineract with the user

package com.dipangshu.expensetracker;

import java.util.Scanner;

//Starts the application nothing else
public class Main {

    //Entry point of application

    // take main() as the starting point of our application

    // Process:
    // 1. Click Run
    // 2. JVM Starts
    // 3. Finds main()
    // 4. Executes code line by line

    public static void main(String[] args) {

        //Read user input
        Scanner scanner = new Scanner(System.in);

        // creates a reference
        // manages all expense-related operations
        // ExpenseManager manager -> empty
        // new ExpenseManager() -> creates object
        ExpenseManager manager = new ExpenseManager();

        Menu menu = new Menu();

        // keep interactive part of application, running
        while (true) {
            menu.displayMenu();

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            //consume new line
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Expense ID:");
                    int id = scanner.nextInt();

                    System.out.println("Enter Amount:");
                    double amount = scanner.nextDouble();
                    scanner.nextLine(); //consume.nextLine()

                    System.out.println("Enter Category:");
                    String category = scanner.nextLine();

                    System.out.println("Enter Description:");
                    String description = scanner.nextLine();

                    System.out.println("Enter Date (dd-mm-yyyy):");
                    String date = scanner.nextLine();

                    Expense expense = new Expense(id, amount, category, description, date);
                    manager.addExpense(expense);
                    System.out.println("Expense Added Successfully");
                    break;


                case 2:
                    manager.viewExpenses();
                    break;

                case 3:
                    System.out.println("Enter Expense ID to search: ");
                    int searchId = scanner.nextInt();

                    Expense searchExpense = manager.searchExpense(searchId);
                    if (searchExpense != null) {
                        System.out.println("ID: " + searchExpense.getId());
                        System.out.println("Amount: " + searchExpense.getAmount());
                        System.out.println("Category: " + searchExpense.getCategory());
                        System.out.println("Description: " + searchExpense.getDescription());
                        System.out.println("Date: " + searchExpense.getDate());
                    } else {
                        System.out.println("Expense not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter Expense ID to update: ");
                    int updateId = scanner.nextInt();

                    System.out.println("Enter New Amount to update: ");
                    double newAmount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Enter New Category to update: ");
                    String newCategory = scanner.nextLine();

                    System.out.println("Enter New Description to update: ");
                    String newDescription = scanner.nextLine();

                    System.out.println("Enter New Date to update: ");
                    String newDate = scanner.nextLine();

                    manager.updateExpense(updateId,
                            newAmount,
                            newCategory,
                            newDescription,
                            newDate
                    );
                    break;

                case 5:
                    System.out.println("Enter Expense ID to Delete Expense: ");
                    int deleteId = scanner.nextInt();

                    manager.deleteExpense(deleteId);
                    break;

                case 6:
                    System.out.println("Total Expense: Rs"+manager.calculateTotalExpenses());
                    break;

                case 7:
                    Expense highest = manager.getHighestExpense();
                    if(highest != null) {
                        System.out.println("Highest Expense");
                        System.out.println("ID: " + highest.getId());
                        System.out.println("Amount: "+highest.getAmount());
                        System.out.println("Category: "+highest.getCategory());
                        System.out.println("Description: "+highest.getDescription());
                        System.out.println("Date: "+highest.getDate());
                    }else{
                        System.out.println("No Expense Available");
                    }
                    break;

                case 8:
                    Expense lowest = manager.getLowestExpense();
                    if(lowest != null) {
                        System.out.println("Lowest Expense");
                        System.out.println("ID: " + lowest.getId());
                        System.out.println("Amount: "+lowest.getAmount());
                        System.out.println("Category: "+lowest.getCategory());
                        System.out.println("Description: "+lowest.getDescription());
                        System.out.println("Date: "+lowest.getDate());
                    }else{
                        System.out.println("No Expense Available");
                    }
                    break;

                case 9:
                    System.out.println("Enter Category: ");
                    String searchCategory = scanner.nextLine();

                    double total = manager.calculateCategoryTotalExpenses(searchCategory);

                    System.out.println("Total "+ searchCategory +" Expense: Rs" + total);
                    break;

                case 10:
                    System.out.println("Thank you for using Expense Tracker!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");

            }
        }
    }


}
