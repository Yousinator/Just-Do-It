package dsa_final.data_structures;

public class Queue {
    private Node front;
    private LinkedList queueList;
    private int maxSize;
    private int currentSize;

    public Queue() {
        this.front = null;
        this.queueList = new LinkedList();
        this.maxSize = 2;
        this.currentSize = 0;
    }

    public void enqueue(Node newNode) {
        if (newNode == null) {
            throw new IllegalArgumentException("Node to be added cannot be null.");
        }

        if (currentSize == maxSize) {
            dequeue(); // Dequeue the front node if the queue is at max size
        }

        queueList.insertLast(newNode);
        front = queueList.getHead();
        currentSize++;
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue from an empty queue.");
        }

        queueList.removeFirst();
        front = queueList.getHead();
        currentSize--;
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
