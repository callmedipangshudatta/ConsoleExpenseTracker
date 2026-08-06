//Store expense objects

package com.dipangshu.expensetracker;

//Only interacts with the userLe
public class Menu {
    public void displayMenu(){
        System.out.println("==============================\n" +
                "     Expense Tracker\n" +
                "==============================");
        System.out.println("1. Add Expense");
        System.out.println("2. View Expense");
        System.out.println("3. Search Expense");
        System.out.println("4. Update Expense");
        System.out.println("5. Delete Expense");
        System.out.println("6. Total Expense");
        System.out.println("7. Highest Expense");
        System.out.println("8. Lowest Expense");
        System.out.println("9. Total Category Expense");
        System.out.println("10. Exit");
    }
}
