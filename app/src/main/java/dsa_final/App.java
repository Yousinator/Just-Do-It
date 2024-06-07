package dsa_final;

import dsa_final.todo.Task;
import dsa_final.todo.TodoApp;

//import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import dsa_final.data_structures.Graph;

public class App {

    // ! Graph Main Function
    // public static void main(String[] args) {
    // int numVertices = 8;
    // Graph DJgraph = new Graph(numVertices);

    // // Edges as per the provided DJgraph
    // DJgraph.addEdge(0, 1, 2);
    // DJgraph.addEdge(0, 2, 4);
    // DJgraph.addEdge(0, 3, 1);
    // DJgraph.addEdge(1, 4, 7);
    // DJgraph.addEdge(1, 5, 3);
    // DJgraph.addEdge(1, 2, 1);
    // DJgraph.addEdge(2, 5, 5);
    // DJgraph.addEdge(2, 3, 2);
    // DJgraph.addEdge(3, 5, 3);
    // DJgraph.addEdge(3, 6, 8);
    // DJgraph.addEdge(4, 7, 1);
    // DJgraph.addEdge(5, 4, 2);
    // DJgraph.addEdge(5, 7, 4);
    // DJgraph.addEdge(5, 6, 1);
    // DJgraph.addEdge(6, 7, 3);

    // DJgraph.printGraph();
    // DJgraph.dijkstra(0); // Starting from vertex 0 (A)
    // // ! Bellman-Ford

    // Graph graph = new Graph(8);
    // graph.addEdge(0, 1, 2);
    // graph.addEdge(0, 2, 4);
    // graph.addEdge(0, 3, 1);
    // graph.addEdge(1, 4, 2); // B -> E
    // graph.addEdge(1, 5, 3);
    // graph.addEdge(1, 2, 1);
    // graph.addEdge(2, 5, -4); // C -> F
    // graph.addEdge(2, 3, 2);
    // graph.addEdge(3, 5, 3);
    // graph.addEdge(3, 6, 8);
    // graph.addEdge(4, 7, 1);
    // graph.addEdge(5, 4, 2);
    // graph.addEdge(5, 7, 4);
    // graph.addEdge(5, 6, 1);
    // graph.addEdge(6, 7, 3);

    // graph.printGraph();
    // graph.bellmanFord(0);

    // }

    // ! Sorting Main Function --=------
    // public static void main(String[] args) {
    // System.out.println("I am Tweeking");
    // int[] sizes = { 100000, 1000000 };
    // String[] types = { "Sorted", "Random", "Reversely Sorted" };

    // for (int size : sizes) {
    // System.out.println("============= " + size + " =============");
    // for (String type : types) {
    // int[] array;
    // switch (type) {
    // case "Sorted":
    // array = generateSortedArray(size);
    // break;
    // case "Random":
    // array = generateRandomArray(size);
    // break;
    // case "Reversely Sorted":
    // array = generateReverselySortedArray(size);
    // break;
    // default:
    // throw new IllegalArgumentException("Unknown array type");
    // }
    // System.out.println("============== " + type + " =================");

    // int[] arrayCopy1 = Arrays.copyOf(array, array.length);
    // int[] arrayCopy2 = Arrays.copyOf(array, array.length);

    // // Measure Merge Sort
    // long startTime = System.currentTimeMillis();
    // mergeSort(arrayCopy1);
    // long endTime = System.currentTimeMillis();
    // System.out.println("Merge Sort: " + (endTime - startTime) + " ms");

    // // Measure Enhanced Selection Sort
    // startTime = System.currentTimeMillis();
    // enhancedSelectionSort(arrayCopy2);
    // endTime = System.currentTimeMillis();
    // System.out.println(
    // "Enhanced Selection Sort: " + (endTime - startTime) + " ms");
    // }
    // }
    // }

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

    // !! Sorting Stuffs Down here
    // Merge Sort implementation
    public static void mergeSort(int[] array) {
        if (array.length > 1) {
            int mid = array.length / 2;

            // Split the array into two halves
            int[] left = new int[mid];
            int[] right = new int[array.length - mid];

            System.arraycopy(array, 0, left, 0, mid);
            System.arraycopy(array, mid, right, 0, array.length - mid);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    private static void merge(int[] array, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        while (i < left.length) {
            array[k++] = left[i++];
        }

        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Enhanced Selection Sort implementation
    public static void enhancedSelectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n / 2; i++) {
            int minIndex = i;
            int maxIndex = i;

            for (int j = i + 1; j < n - i; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }

            swap(array, i, minIndex);
            if (maxIndex == i) {
                maxIndex = minIndex;
            }
            swap(array, n - i - 1, maxIndex);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Methods to generate test arrays
    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    public static int[] generateReverselySortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }
}
