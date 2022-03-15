package out.production.untitled.company.biudzetas;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class PersonalAccount {

    public ArrayList<UserEntry> entries;

    public PersonalAccount(ArrayList<UserEntry> entries) {
        this.entries = entries;
    }

    public void imporTest() throws FileNotFoundException {
        this.entries =  Files.importData(this.entries);
    }

   public ArrayList<UserEntry> getIncomeEntriesList (){
       ArrayList<UserEntry> incomeEntries = new ArrayList<>();
       for (UserEntry entry : entries) {
           if (entry.getType() == Type.INCOME) {
               incomeEntries.add(entry);
           }
       }
       return incomeEntries;
    }

    public ArrayList<UserEntry> getExpenseEntriesList (){
        ArrayList<UserEntry> expenseEntries = new ArrayList<>();
        for (UserEntry entry : entries) {
            if (entry.getType() == Type.EXPENSE) {
                expenseEntries.add(entry);
            }
        }
        return expenseEntries;

    }

    public PersonalAccount() {
        this.entries = new ArrayList<>();
    }

    public void addIncomeEntry(UserEntry incomeEntry) {
       incomeEntry.setType(Type.INCOME);
        entries.add(incomeEntry);

    }
    public void addExpenseEntry(UserEntry expenseEntry) {
       expenseEntry.setType(Type.EXPENSE);
        entries.add(expenseEntry);

    }

    public void accountReport(UserEntry userEntry) {
        System.out.println("==================================");
        System.out.println(userEntry.getType());
        System.out.println("Amount: " + userEntry.getAmount());
        System.out.println("Category: " + userEntry.getCategory());
        System.out.println("Description: " + userEntry.getDescription());
        System.out.println("Date: " + userEntry.getDateTime().getMonth() + " - " + userEntry.getDateTime().getDayOfMonth());
        System.out.println("Time: " + userEntry.getDateTime().getHour() + ":" + userEntry.getDateTime().getMinute());
        System.out.println("Account Number: " + userEntry.getAccountNumber());
        System.out.println("Unique Entry Id: " + userEntry.getEntryId());
        System.out.println("==================================");
    }


    public void printAllIncome() {
        ArrayList<UserEntry> incomEntries = getIncomeEntriesList();
        for (int i = 0; i < incomEntries.size(); i++) {
            UserEntry incomeEntry = incomEntries.get(i);
            printIndex(i, incomeEntry);
        }
    }

    public void printAllExpenses() {
        ArrayList<UserEntry> expenseEntries = getExpenseEntriesList();
        for (int i = 0; i < expenseEntries.size(); i++) {
            UserEntry expenseEntry = expenseEntries.get(i);
            printIndex(i, expenseEntry);
        }
    }

    public UserEntry getIncomeEntryByIndex(int index) {
        return getIncomeEntriesList().get(index);
    }

    public UserEntry getExpenseEntryByIndex(int index1) {
        return getExpenseEntriesList().get(index1);
    }

    private void printIndex(int input, UserEntry userEntry) {
        String formatedString = String.format(
                "%s %s %s %.2f",
                input + 1,
                userEntry.getDateTime().toLocalDate(),
                userEntry.getCategory(),
                userEntry.getAmount()
        );
        System.out.println(formatedString);
    }
}
