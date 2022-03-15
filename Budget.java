package out.production.untitled.company.biudzetas;

import java.io.IOException;
import java.util.Scanner;

public class Budget {

    public static void start(PersonalAccount personalAccount, UserEntry userEntry) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String choice;
        do {
            Print.printBudgetMenu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1" -> incomeEntry(personalAccount);
                case "2" -> expenseEntry(personalAccount);
                case "3" -> UserEntry.indexIncomeValidation(scanner, personalAccount);
                case "4" -> UserEntry.indexExpenseValidation(scanner, personalAccount);
                case "5" -> {
                    Print.incomeExpenseMenu();
                    String userInput = scanner.nextLine();
                    EditControler.editEntryMenu(userInput, personalAccount, scanner);
                }
                case "6" -> userEntry.balance(personalAccount);
                case "7" -> Files.saveData(personalAccount);
                case "8" -> personalAccount.imporTest();
                case "9" -> {
                    System.out.println("STOP");
                    System.exit(0);
                }
            }
        } while (true);
    }

    public static void incomeEntry(PersonalAccount personalAccount) {
        UserEntry incomeEntry = new UserEntry();
        incomeEntry.entryToValue();
        personalAccount.addIncomeEntry(incomeEntry);
    }

    public static void expenseEntry(PersonalAccount personalAccount) {
        UserEntry expenseEntry = new UserEntry();
        expenseEntry.entryToValue();
        personalAccount.addExpenseEntry(expenseEntry);
    }

    public static void incomeReportPrint(PersonalAccount personalAccount, Scanner scanner) {
        if( personalAccount.getIncomeEntriesList().size() == 0){
            System.out.println("== No Expense Entries Found ==\n");
        }else {
            System.out.println("Enter report index to get full view");
            personalAccount.printAllIncome();
            int index = Integer.parseInt(scanner.nextLine());
            index--;
            UserEntry incomeReport = personalAccount.getIncomeEntryByIndex(index);
            personalAccount.accountReport(incomeReport);
        }
    }

    public static void expenseReortPrint(PersonalAccount personalAccount, Scanner scanner) {
        System.out.println("Enter report index to get full view");
        personalAccount.printAllExpenses();
        int index1 = Integer.parseInt(scanner.nextLine());
        index1--;
        UserEntry expenseReport = personalAccount.getExpenseEntryByIndex(index1);
        personalAccount.accountReport(expenseReport);
    }

}
