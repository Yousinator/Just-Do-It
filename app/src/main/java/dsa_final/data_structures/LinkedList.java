package dsa_final.data_structures;

import dsa_final.todo.Task;

public class LinkedList {
    private Node head;

    public Node getHead() {
        return this.head;
    }

    public LinkedList() {
        this.head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public LinkedList(Node head) {
        if (isEmpty()) {
            throw new IllegalArgumentException("Head node cannot be null.");
        }
        this.head = head;
    }

    public void insertFirst(Node newNode) {
        if (newNode == null) {
            throw new IllegalArgumentException("New node cannot be null.");
        }
        newNode.setNext(head);
        head = newNode;
    }

    public void insertLast(Node newNode) {
        if (newNode == null) {
            throw new IllegalArgumentException("New node cannot be null.");
        }
        if (isEmpty()) {
            head = newNode;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        }
        head = head.getNext();
    }

    public void remove(Node nodeToRemove) {
        if (nodeToRemove == null) {
            throw new IllegalArgumentException("Node to be removed cannot be null.");
        }
        if (isEmpty()) {
            throw new IllegalStateException("Cannot remove from an empty list.");
        }
        if (head == nodeToRemove) {
            head = head.getNext();
        } else {
            Node current = head;
            while (current.getNext() != null && current.getNext() != nodeToRemove) {
                current = current.getNext();
            }
            if (current.getNext() == null) {
                throw new IllegalArgumentException("Node not found in the list.");
            }
            current.setNext(current.getNext().getNext());
        }
    }

    // ! Ask about in oral on sorting algorithm
    public void sortByDate() {
        if (isEmpty() || this.head.getNext() == null) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node current = this.head;

            while (current.getNext() != null) {
                Task currentTask = current.getTask();
                Task nextTask = current.getNext().getTask();

                if (currentTask.getDueDate().after(nextTask.getDueDate())) {
                    // Swap tasks
                    current.setTask(nextTask);
                    current.getNext().setTask(currentTask);
                    swapped = true;
                }
                current = current.getNext();
            }
        } while (swapped);
    }

    public void printLL() {
        if (isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        Node current = this.head;
        while (current != null) {
            System.out.println(current.toString());
            current = current.getNext();
        }
    }
}