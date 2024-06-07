package dsa_final.data_structures;

public class Queue {
    private Node front;
    private Node rear;
    private LinkedList queueList;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.queueList = new LinkedList();
    }

    public void enqueue(Node newNode) {
        if (newNode == null) {
            throw new IllegalArgumentException("Node to be added cannot be null.");
        }

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setNext(newNode);
            rear = newNode;
        }

        queueList.insertLast(newNode);
    }

    public void dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot dequeue from an empty queue.");
        }

        queueList.removeFirst();
        front = queueList.getHead();

        if (front == null) {
            rear = null;
        }
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
