package dsa_final;

import dsa_final.todo.Task;
import dsa_final.todo.TodoApp;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class App {

    private static TodoApp todoApp = new TodoApp();
    private static Scanner scanner = new Scanner(System.in);
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static void main(String[] args) {
        addInitialTasks();

        while (true) {
            printMenu();
            int choice = getUserChoice();
            executeChoice(choice);
        }
    }

    private static void printMenu() {
        System.out.println("========== ToDo Application Menu ==========");
        System.out.println("1. Add a Task");
        System.out.println("2. Mark Task as Complete");
        System.out.println("3. Group Tasks by Category (Placeholder)");
        System.out.println("4. Print All Tasks");
        System.out.println("5. Print Urgent Tasks");
        System.out.println("6. Print Completed Tasks");
        System.out.println("7. Exit");
        System.out.println("===========================================");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static void executeChoice(int choice) {
        scanner.nextLine(); // Consume the newline
        switch (choice) {
            case 1:
                addTask();
                break;
            case 2:
                markTaskAsComplete();
                break;
            case 3:
                groupTasksByCategory();
                break;
            case 4:
                todoApp.printAllTasks();
                break;
            case 5:
                todoApp.printUrgentTasks();
                break;
            case 6:
                todoApp.printCompletedTasks();
                break;
            case 7:
                System.out.println("Exiting the application.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addTask() {
        try {
            System.out.print("Enter task name: ");
            String name = toSentenceCase(scanner.nextLine());

            if (todoApp.doesTaskExist(name)) {
                System.out.println("Task with this name already exists. Please use a different name.");
                return;
            }

            System.out.print("Enter due date (dd-MM-yyyy): ");
            String dueDateString = scanner.nextLine();
            Date dueDate = dateFormat.parse(dueDateString);

            if (dueDate.before(new Date())) {
                System.out.println("Due date cannot be before the current date. Please enter a valid date.");
                return;
            }

            System.out.print("Is this task urgent? (yes/no): ");
            boolean isUrgent = scanner.nextLine().equalsIgnoreCase("yes");

            System.out.print("Enter task category: ");
            String category = toSentenceCase(scanner.nextLine());

            todoApp.addTask(name, dueDate, isUrgent, category);
            System.out.println("Task added successfully.");
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use dd-MM-yyyy.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void markTaskAsComplete() {
        System.out.print("Enter the name of the task to mark as complete: ");
        String name = toSentenceCase(scanner.nextLine());
        try {
            todoApp.markCompleteByName(name);
            System.out.println("Task marked as complete.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void groupTasksByCategory() {
        todoApp.groupByCategory();
    }

    private static String toSentenceCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private static void addInitialTasks() {
        Task[] tasks = new Task[5];
        try {
            tasks[0] = new Task("Finish assignment", dateFormat.parse("01-08-2024"), true, "School");
            tasks[1] = new Task("Buy groceries", dateFormat.parse("30-08-2024"), false, "Home");
            tasks[2] = new Task("Doctor appointment", dateFormat.parse("05-07-2024"), true, "Home");
            tasks[3] = new Task("Pay bills", dateFormat.parse("28-07-2024"), false, "Work");
            tasks[4] = new Task("Team meeting", dateFormat.parse("29-10-2024"), true, "Work");

            for (Task task : tasks) {
                todoApp.addTask(task.getName(), task.getDueDate(), task.isUrgent(), task.getCategory());
            }
        } catch (ParseException e) {
            System.out.println("Error in initial task dates.");
        }
    }
}
