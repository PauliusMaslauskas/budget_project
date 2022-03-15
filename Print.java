package out.production.untitled.company.biudzetas;

public class Print {

    public static void printBudgetMenu() {
        System.out.println("1) Add Income Entry");
        System.out.println("2) Add Expense Entry");
        System.out.println("3) View Income Report");
        System.out.println("4) View Expenses Report");
        System.out.println("5) Edit Entries");
        System.out.println("6) Balance");
        System.out.println("7) Save To File");
        System.out.println("8) Import From File");
        System.out.println("9) Quit");
    }

    public static void editMenu() {
        System.out.println("1) Change Amount");
        System.out.println("2) Change Category");
        System.out.println("3) Change Description");
        System.out.println("4) Change Date and Time");
        System.out.println("5) Change Account Number");
        System.out.println("6) Delete Entry");
        System.out.println("9) Back to Main Menu");
    }

    public static void incomeExpenseMenu() {
        System.out.println("1) Income");
        System.out.println("2) Expense");
        System.out.println("9) Back to Main Menu");
    }
}
