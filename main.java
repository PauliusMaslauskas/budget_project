package out.production.untitled.company.biudzetas;

import java.io.File;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        Budget.start(new PersonalAccount(), new UserEntry());
        System.out.println("sveiki");
    }
}

