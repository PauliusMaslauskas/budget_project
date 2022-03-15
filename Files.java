package out.production.untitled.company.biudzetas;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Files {
    public static void saveData(PersonalAccount personalAccount) throws IOException {
        FileWriter writer = new FileWriter("Files/budgetFile.csv");

        for (int i = 0; i < personalAccount.entries.size(); i++) {
            UserEntry a = personalAccount.entries.get(i);
            writer.write(String.valueOf(a));
        }
        writer.close();
    }

    public static ArrayList<UserEntry> importData(ArrayList<UserEntry> entries) throws FileNotFoundException {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("Files/budgetFile.csv"));
            while ((line = br.readLine()) != null) {
                UserEntry userEntry = new UserEntry();
                String[] entry = line.split(splitBy);
                userEntry.setType(Type.valueOf(entry[0]));
                userEntry.setAmount(Double.parseDouble(entry[1]));
                String a = entry[2];
                a = a.trim();
                userEntry.setCategory(Category.valueOf(a));
                String b = entry[3];
                b = b.trim();
                userEntry.setDateTime(LocalDateTime.parse(b));
                userEntry.setAccountNumber(entry[4]);
                entries.add(userEntry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }
}