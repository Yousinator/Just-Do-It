package dsa_final.data_structures;

public class Queue {
    private Node front;
    private LinkedList queueList;

    public Queue() {
        this.front = null;
        this.queueList = new LinkedList();
    }

    public void enqueue(Node newNode) {
        if (newNode == null) {
            throw new IllegalArgumentException("Node to be added cannot be null.");
        }

        queueList.insertLast(newNode);
        front = queueList.getHead();
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue from an empty queue.");
        }

        queueList.removeFirst();
        front = queueList.getHead();
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("The queue is empty.");
            return;
        }

        queueList.printLL();
    }
}