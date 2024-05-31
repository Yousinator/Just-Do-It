package dsa_final.data_structures;

import dsa_final.todo.Task;

public class Node {
    private Task task;
    private Node next;
    private String item;

    // Constructor
    public Node(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task cannot be null.");
        }
        this.task = task;
        this.next = null; // Initially, the next node is null
    }

    public Node(String item) {
        if (item == null || item.trim().isEmpty()) {
            throw new IllegalArgumentException("item cannot be null or empty.");
        }
        this.item = item;
        this.task = null;
        this.next = null;
    }

    public String getItem() {
        return this.item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Task getTask() {
        return this.task;
    }

    public Node getNext() {
        return this.next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    @Override
    public String toString() {
        if (task != null) {
            return "Node{" +
                    "task=" + task +
                    '}';
        } else {
            return "Node{" +
                    "item='" + item + '\'' +
                    '}';
        }
    }
}
