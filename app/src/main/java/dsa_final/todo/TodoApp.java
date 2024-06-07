package dsa_final.todo;

import dsa_final.data_structures.Queue;
import dsa_final.data_structures.Stack;
import dsa_final.data_structures.LinkedList;
import dsa_final.data_structures.Node;
import java.util.Date;

public class TodoApp {
    private Stack urgentTasks;
    private Queue completedTasks;
    private TodoList todoList;
    private LinkedList categoryList;

    // Constructor
    public TodoApp() {
        this.urgentTasks = new Stack();
        this.completedTasks = new Queue();
        this.todoList = new TodoList();
        this.categoryList = new LinkedList();
    }

    // Method to add a task to the app
    public void addTask(String name, Date dueDate, boolean isUrgent, String category) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be null or empty.");
        }
        if (dueDate == null) {
            throw new IllegalArgumentException("Due date cannot be null.");
        }
        if (category == null || category.trim().isEmpty()) {
            throw new IllegalArgumentException("Category cannot be null or empty.");
        }

        this.addToCategoryList(category);

        Task newTask = new Task(name, dueDate, isUrgent, category);
        this.todoList.addTaskToList(newTask);

        if (isUrgent) {
            this.addToUrgentStack(newTask);
        }
    }

    public void addToCategoryList(String category) {

        if (this.categoryList.isEmpty()) {
            this.categoryList.insertFirst(new Node(category));
            return;
        }

        Node currentTask = this.todoList.getTaskList().getHead();
        while (currentTask != null) {

            if (currentTask.getTask().getCategory().equalsIgnoreCase(category)) {
                return; // Category already exists, no need to add it
            }
            currentTask = currentTask.getNext();
        }

        // If category does not exist, add it to the list
        this.categoryList.insertFirst(new Node(category));
        return;
    }

    public boolean doesTaskExist(String name) {
        Node current = todoList.getTaskList().getHead();
        while (current != null) {
            if (current.getTask().getName().equalsIgnoreCase(name)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void markCompleteByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Task name cannot be null or empty.");
        }

        Node current = this.todoList.getTaskList().getHead();
        while (current != null) {
            if (current.getTask().getName().equals(name)) {
                this.todoList.removeTaskFromList(current.getTask());
                completedTasks.enqueue(new Node(current.getTask()));

                // Remove from urgent tasks if it exists there
                removeFromUrgentTasksByName(name);
                return;
            }
            current = current.getNext();
        }

        throw new IllegalArgumentException("Task not found in the list.");
    }

    // Method to remove a task by name from the urgent stack
    private void removeFromUrgentTasksByName(String name) {
        Stack tempStack = new Stack();
        boolean found = false;

        // Pop all elements until the target is found or the stack is empty
        while (!urgentTasks.isEmpty()) {
            Node node = urgentTasks.pop();
            if (node.getTask().getName().equals(name)) {
                found = true;
                break;
            } else {
                tempStack.push(node);
            }
        }

        // Push back all elements from the temp stack to the original stack
        while (!tempStack.isEmpty()) {
            urgentTasks.push(tempStack.pop());
        }

        if (!found) {
            throw new IllegalArgumentException("Task not found in the urgent tasks stack.");
        }
    }

    public void groupByCategory() {
        if (categoryList.isEmpty()) {
            System.out.println("No categories available.");
            return;
        }

        Node currentCategory = categoryList.getHead();
        do {
            String category = currentCategory.getItem();
            System.out.println("\n\nCategory: " + category);
            System.out.println("--------------------------");

            Node currentTask = todoList.getTaskList().getHead();
            while (currentTask != null) {
                if (currentTask.getTask().getCategory().equalsIgnoreCase(category)) {
                    System.out.println(currentTask.getTask());
                }
                currentTask = currentTask.getNext();
            }
            System.out.println("==========================");
            currentCategory = currentCategory.getNext();

        } while (currentCategory != null);
    }

    // Method to add a task to the urgent stack
    public void addToUrgentStack(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }
        urgentTasks.push(new Node(task));
    }

    // Method to check if the app has no tasks
    public boolean isEmpty() {
        return this.todoList.getTaskList().isEmpty();
    }

    // Method to print all tasks
    public void printAllTasks() {
        System.out.println("========== All Tasks ==========");
        this.todoList.printAllTasks();
        System.out.println("===============================");
    }

    // Method to print urgent tasks
    public void printUrgentTasks() {
        System.out.println("======= Urgent Tasks =======");
        urgentTasks.printStack();
        System.out.println("============================");
    }

    // Method to print completed tasks
    public void printCompletedTasks() {
        System.out.println("===== Completed Tasks =====");
        completedTasks.printQueue();
        System.out.println("===========================");
    }
}
