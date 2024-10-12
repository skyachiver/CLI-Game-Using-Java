import java.util.Scanner;

public class TextAdventureGame {
    private static Scanner scanner = new Scanner(System.in);
    private static String currentRoom = "Cave Entrance";
    private static boolean hasKey = false;

    public static void main(String[] args) {
        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("Type 'help' to see available commands.");
        while (true) {
            System.out.println("You are at: " + currentRoom);
            switch (currentRoom) {
                case "Cave Entrance":
                    caveEntrance();
                    break;
                case "Dark Room":
                    darkRoom();
                    break;
                case "Treasure Room":
                    treasureRoom();
                    break;
                case "Exit":
                    exitGame();
                    break;
            }
        }
    }

    private static void caveEntrance() {
        System.out.println("You see a dark cave ahead. There are two paths: one to the left and one to the right.");
        System.out.print("What do you want to do? (left/right/help): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("left")) {
            currentRoom = "Dark Room";
        } else if (choice.equals("right")) {
            currentRoom = "Treasure Room";
        } else if (choice.equals("help")) {
            showHelp();
        } else {
            System.out.println("Invalid choice. Try again.");
        }
    }

    private static void darkRoom() {
        System.out.println("It's dark here! You can barely see. You find a key on the ground.");
        System.out.print("What do you want to do? (take key/exit/help): ");
        String choice = scanner.nextLine().toLowerCase();

        if (choice.equals("take key")) {
            hasKey = true;
            System.out.println("You have taken the key.");
            currentRoom = "Cave Entrance";
        } else if (choice.equals("exit")) {
            currentRoom = "Cave Entrance";
        } else if (choice.equals("help")) {
            showHelp();
        } else {
            System.out.println("Invalid choice. Try again.");
        }
    }

    private static void treasureRoom() {
        System.out.println("You found the Treasure Room! There's a locked chest here.");
        if (hasKey) {
            System.out.print("You can open the chest. (open/help): ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("open")) {
                System.out.println("Congratulations! You opened the chest and found the treasure!");
                currentRoom = "Exit";
            } else if (choice.equals("help")) {
                showHelp();
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        } else {
            System.out.print("The chest is locked. You need a key to open it. (exit/help): ");
            String choice = scanner.nextLine().toLowerCase();
            if (choice.equals("exit")) {
                currentRoom = "Cave Entrance";
            } else if (choice.equals("help")) {
                showHelp();
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void exitGame() {
        System.out.println("You have exited the game. Thanks for playing!");
        System.exit(0);
    }

    private static void showHelp() {
        System.out.println("Available commands: left, right, take key, exit, open, help");
    }
}
