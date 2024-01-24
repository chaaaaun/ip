package chatbot;

import java.util.ArrayList;
import java.util.Scanner;

public class Plana {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_CYAN = "\u001B[36m";
    private static final String LOGO =
            "    ____  __                 \n" +
            "   / __ \\/ /___ _____  ____ _\n" +
            "  / /_/ / / __ `/ __ \\/ __ `/\n" +
            " / ____/ / /_/ / / / / /_/ / \n" +
            "/_/   /_/\\__,_/_/ /_/\\__,_/  \n";

    private static final String NAME = "Plana";

    private ArrayList<String> tasks;

    public Plana() {
        this.tasks = new ArrayList<String>();
    }

    public void greet() {
        System.out.println("Hello from\n" + LOGO);
        System.out.println("Hello! I'm " + NAME + "!");
        System.out.println("What can I do for you?");
        System.out.println("======================");
    }

    public void chat() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(ANSI_GREEN + "> " + ANSI_CYAN);
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("bye")) {
                break;
            } else if (userInput.equalsIgnoreCase("list")) {
                System.out.println("You've added the following tasks so far:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.printf("%d. %s\n", i+1, tasks.get(i));
                }
            } else {
                tasks.add(userInput);
                System.out.println("I've added the task: " + userInput);
            }
        }

        scanner.close();
    }

    public void bye() {
        System.out.println(ANSI_RESET + "==================");
        System.out.println("See you next time!");
    }
}
