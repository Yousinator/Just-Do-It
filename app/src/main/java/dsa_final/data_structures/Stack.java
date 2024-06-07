package dsa_final.data_structures;

public class Stack {
    private LinkedList stackList;
    private Node top;

    public Stack() {
        this.stackList = new LinkedList();
        this.top = null;
    }

    public void push(Node newNode) {
        if (newNode == null) {
            throw new IllegalArgumentException("Node to be added cannot be null.");
        }
        stackList.insertFirst(newNode);
        top = stackList.getHead();
    }

    public Node pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Cannot pop from an empty stack.");
        }
        Node currentTop = this.top;
        stackList.removeFirst();
        top = stackList.getHead();
        return currentTop;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("The stack is empty.");
            return;
        }
        stackList.printLL();
    }
}
