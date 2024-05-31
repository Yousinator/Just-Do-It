package dsa_final.todo;

import dsa_final.data_structures.Node;
import dsa_final.data_structures.LinkedList;

public class TodoList {
    private LinkedList taskList;

    // Constructor
    public TodoList() {
        this.taskList = new LinkedList();
    }

    public void addTaskToList(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }
        Node newNode = new Node(task);
        taskList.insertFirst(newNode);
        taskList.sortByDate();
    }

    public LinkedList getTaskList() {
        return taskList;
    }

    // Method to remove a task from the list
    public void removeTaskFromList(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task to be removed cannot be null.");
        }
        Node current = taskList.getHead();
        while (current != null) {
            if (current.getTask().equals(task)) {
                taskList.remove(current);
                return;
            }
            current = current.getNext();
        }
        throw new IllegalArgumentException("Task not found in the list.");
    }

    // Method to print all tasks in the list
    public void printAllTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("---------- ToDo List ----------");
        Node current = taskList.getHead();
        while (current != null) {
            Task task = current.getTask();
            System.out.println("Task: " + task.getName());
            System.out.println("Due Date: " + task.getDueDate());
            System.out.println("Category: " + task.getCategory());
            System.out.println("Priority: " + task.getPriority());
            System.out.println("-------------------------------");
            current = current.getNext();
        }
    }
}
