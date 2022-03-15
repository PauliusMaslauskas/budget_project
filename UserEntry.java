package out.production.untitled.company.biudzetas;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.Scanner;

public class UserEntry {

    private double amount;
    private Category category;
    private String description;
    private LocalDateTime dateTime;
    private String accountNumber;
    private int entryId;
    private Type type;


    public UserEntry() {
    }

    public UserEntry(double amount, Category category, String description, LocalDateTime dateTime, String accountNumber, int entryId) {
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.dateTime = dateTime;
        this.accountNumber = accountNumber;
        this.entryId = entryId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getEntryId() {
        return entryId;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void entryToValue() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Amount");
        setValidAmount(sc);

        System.out.println("Category");
        categoryValidation(sc);

        System.out.println("Description");
        description = sc.nextLine();

        System.out.println("Date&Time");
        dateTimeValidation(sc);

        System.out.println("Account Number");
        accountNumber = sc.nextLine();

        System.out.println("Unique Entry Id");
        entryId = entryId();

    }

    public void setValidAmount(Scanner sc) {
        try {
            amount = Double.parseDouble(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("== Please Enter Numeric Value == \n");
            System.out.println("Amount");
            setValidAmount(sc);
        }
    }

    @Override
    public String toString() {
        return  getType() + ", " +
                amount + ", " +
                category + ", " +
                dateTime + ", " +
                accountNumber + "\n";
    }

    public void dateTimeValidation(Scanner sc) {
        try {
            dateTime = LocalDateTime.parse(sc.nextLine());
        } catch (DateTimeParseException e) {
            System.out.println("== Please Use yyyy-mm-dd' T 'hh mm ss Format == \n");
            System.out.println("Date&Time");
            dateTimeValidation(sc);
        }
    }

    public void categoryValidation(Scanner sc) {
        try {
            category = Category.valueOf(sc.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println("""
                    == Please Use One Of The Following Categories ==
                        SALARY
                        GROCERIES
                        MEDICAL
                        UTILITIES
                        TRANSPORTATION
                        LOAN
                        DEBT \n""");
            System.out.println("Category");
            categoryValidation(sc);
        }
    }

    public static UserEntry indexIncomeValidation(Scanner scanner, PersonalAccount personalAccount) {
        try {
            Budget.incomeReportPrint(personalAccount, scanner);
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("== Please Enter Valid Index == \n");
            indexIncomeValidation(scanner, personalAccount);
        }
        return null;
    }

    public static UserEntry indexExpenseValidation(Scanner scanner, PersonalAccount personalAccount) {
        try {
            Budget.expenseReortPrint(personalAccount, scanner);
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("== Please Enter Valid Index == \n");
            indexExpenseValidation(scanner, personalAccount);
        }
        return null;
    }

    private static int entryId() {
        Random random = new Random();
        int maxNumber = 10000;
        int randomnumber = random.nextInt(maxNumber) + 1;
        System.out.println(randomnumber + "\n");
        return randomnumber;
    }

    public void balance(PersonalAccount personalAccount) {
        double incomeSum = 0;
        double expenseSum = 0;
        for (UserEntry incomeEntry : personalAccount.getIncomeEntriesList()) {
            incomeSum += incomeEntry.getAmount();
        }
        for (UserEntry expenseEntry : personalAccount.getExpenseEntriesList()) {
            expenseSum += expenseEntry.getAmount();
        }
        double sum = incomeSum - expenseSum;
        System.out.println("==================================");
        System.out.println("Remaining balance");
        System.out.println(sum + " €");
        System.out.println("==================================");
    }
}

