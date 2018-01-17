import solverconfiguration.PropertiesContext;
import web.UserWeb;

import java.util.Scanner;

public class Controller {
    Controller() {
        super();
    }

    private static void solveUserInput(String str1) {
        UserWeb u = new UserWeb();
        switch (str1) {
            case "ADD":
                System.out.println(PropertiesContext.getValue("ADD"));
                u.saveUser();
                break;
        }
    }

    public static void start() {
        System.out.println("数据库启动成功");
        String value = PropertiesContext.getValue("welcome");
        System.out.println(value);
        String value1 = PropertiesContext.getValue("firststep");
        System.out.println(value1);
        Scanner scanner = new Scanner(System.in);
        solveUserInput(scanner.next());
    }
}
