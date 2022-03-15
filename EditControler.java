package out.production.untitled.company.biudzetas;

import java.util.Scanner;


public class EditControler {

    public static void editEntryMenu(String userInput, PersonalAccount personalAccount, Scanner scanner) {
        switch (userInput) {
            case "1" -> {
                try {
                UserEntry incomeReport = UserEntry.indexIncomeValidation(scanner, personalAccount);
                Print.editMenu();
                String userInput1 = scanner.nextLine();
                EditControler.editEntry(userInput1, incomeReport, scanner, personalAccount);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("== Please Enter Valid Index ==\n");
                    Budget.incomeReportPrint(personalAccount, scanner);
                }

            }
            case "2" -> {
                try {
                    UserEntry expenseReport = UserEntry.indexExpenseValidation(scanner, personalAccount);
                    Print.editMenu();
                    String userInput2 = scanner.nextLine();
                    EditControler.editEntry(userInput2, expenseReport, scanner, personalAccount);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("== Please Enter Valid Index ==\n");
                    Budget.expenseReortPrint(personalAccount, scanner);
                }
            }
            default -> {
            }
        }
    }

    public static void editEntry(String userInput, UserEntry userEntry, Scanner scanner, PersonalAccount personalAccount) {
        switch (userInput) {
            case "1":
                changeAmount(userEntry, scanner);
                break;
            case "2":
                changeCategory(scanner, userEntry);
                break;
            case "3":
                changeDescription(scanner, userEntry);
                break;
            case "4":
                changeDateTime(scanner, userEntry);
                break;
            case "5":
                changeAccountNumber(scanner, userEntry);
                break;
            case "6":
                deleteEntry(userEntry, personalAccount, userInput);
            default:
            case "9":
                break;
        }
    }


    public static void changeAmount(UserEntry userEntry, Scanner scanner) {
        System.out.println("Enter New Amount");
        userEntry.setValidAmount(scanner);
        System.out.println("Amount Successfully Changed!\n");
    }

    private static void changeCategory(Scanner scanner, UserEntry userEntry) {
        System.out.println("Enter New Category");
        //userEntry.setCategory(scanner);
        System.out.println("Category Successfully Changed!\n");
    }

    private static void changeDateTime(Scanner scanner, UserEntry userEntry) {
        System.out.println("Enter New Date");
      // UserEntry.dateTimeValidation(scanner);
        System.out.println("Date Successfully Changed!\n");
    }

    private static void changeDescription(Scanner scanner, UserEntry userEntry) {
        System.out.println("Enter New Description");
        userEntry.setDescription(scanner.nextLine());
        System.out.println("Description Successfully Changed!\n");

    }

    private static void changeAccountNumber(Scanner scanner, UserEntry userEntry) {
        System.out.println("Enter New Account Number");
        userEntry.setAccountNumber(scanner.nextLine());
        System.out.println("Number Successfully Changed!\n");
    }

    public static void deleteEntry(UserEntry userEntry, PersonalAccount personalAccount, String userInput) {
        personalAccount.entries.remove(userEntry);
    }
}
