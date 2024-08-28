import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {
    // List to store tasks
    private ArrayList<String> tasks = new ArrayList<>();

    // Scanner object for user input
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        toDoList.run();
    }

    // Method to run the main loop
    public void run() {
        while (true) {
            printMenu();
            int choice = getUserChoice();
            handleChoice(choice);
        }
    }

    // Method to print the menu
    private void printMenu() {
        System.out.println("\nTo-Do List Application");
        System.out.println("1. Add Task");
        System.out.println("2. Delete Task");
        System.out.println("3. View Tasks");
        System.out.println("4. Exit");
    }

    // Method to get the user's choice
    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    // Method to handle the user's choice
    private void handleChoice(int choice) {
        scanner.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                deleteTask();
                break;
            case 3:
                viewTasks();
                break;
            case 4:
                exit();
                break;
            default:
                System.out.println("Invalid choice! Please try again.");
        }
    }

    // Method to add a task
    private void addTask() {
        System.out.print("Enter a new task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added successfully.");
    }

    // Method to delete a task
    private void deleteTask() {
        viewTasks();
        System.out.print("Enter the task number to delete: ");
        int taskNumber = scanner.nextInt();
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task number!");
        }
    }

    // Method to view tasks
    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
        } else {
            System.out.println("\nYour Tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Method to exit the application
    private void exit() {
        System.out.println("Exiting the application. Goodbye!");
        System.exit(0);
    }
}
