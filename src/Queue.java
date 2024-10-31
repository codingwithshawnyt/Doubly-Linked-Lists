//Shawn Ray
//Period 4
//Queue.java
//This sets up the foundation of a queue using a circular,
//doubly linked list.

// Definition of the Queue class with a generic type parameter T
public class Queue<T> {
    // Declare private variables 'head' and 'tail' of type dNode<T>
    private dNode<T> head;
    private dNode<T> tail;
    // Declare private variables 'size' and 'capacity' of type int
    private int size;
    private int capacity;

    // Default constructor for the Queue class
    public Queue() {
        // Initialize 'head' and 'tail' to null indicating an empty queue
        this.head = null;
        this.tail = null;
        // Initialize 'size' to 0 and 'capacity' to Integer.MAX_VALUE
        this.size = 0;
        this.capacity = Integer.MAX_VALUE;
    }

    // Constructor for the Queue class that takes a value of type T as parameter
    public Queue(T value) {
        // Call the other constructor with 'value' and Integer.MAX_VALUE as parameters
        this(value, Integer.MAX_VALUE);
    }

    // Constructor for the Queue class that takes a value of type T and an int capacity as parameters
    public Queue(T value, int capacity) {
        // If 'capacity' is less than 1, throw an IllegalArgumentException
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be greater than 0.");
        }
        // Create a new dNode<T> with 'value' and assign it to 'head' and 'tail'
        dNode<T> newNode = new dNode<>(value);
        this.head = newNode;
        this.tail = newNode;
        // Make the list circular by setting 'prev' and 'next' of newNode to point to itself
        newNode.prev = newNode;
        newNode.next = newNode;
        // Initialize 'size' to 1 and 'capacity' to the given capacity
        this.size = 1;
        this.capacity = capacity;
    }

// Method to add a value to the end of the queue
public void enqueue(T value) {
    // If 'size' is greater than or equal to 'capacity', throw an IllegalStateException
    if (size >= capacity) {
        throw new IllegalStateException("No space is currently available in the queue.");
    }
    // Create a new dNode<T> with 'value'
    dNode<T> newNode = new dNode<>(value);
    // If the queue is empty, assign 'newNode' to 'head' and 'tail'
    if (isEmpty()) {
        head = newNode;
        tail = newNode;
    } else {
        // If the queue is not empty, add 'newNode' at the end of the queue
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }
    // Make the list circular by setting 'next' of 'tail' and 'prev' of 'head' to point to each other
    tail.next = head;
    head.prev = tail;
    // Increment 'size'
    size++;
}

    // Method to remove and return the value at the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        T data = head.data;
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        return data;
    }


    // Method to check if the queue is empty
    public boolean isEmpty() {
        // Return true if 'size' is 0, false otherwise
        return size == 0;
    }

    // Method to move the front node to the end of the queue
    public void sendToBack() {
        // If the queue is empty, throw an IllegalStateException
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        // Dequeue the front node and enqueue it at the end
        T data = dequeue();
        enqueue(data);
    }

    // Method to return the current size of the queue
    public int size() {
        // Return 'size'
        return size;
    }

    // Method to return the current capacity of the queue
    public int capacity() {
        // Return 'capacity'
        return capacity;
    }

    // Method to change the capacity of the queue
    public void changeCapacity(int newCapacity) {
        // If 'newCapacity' is less than 'size', throw an IllegalArgumentException
        if (newCapacity < size) {
            throw new IllegalArgumentException("New capacity cannot be less than the current size of the queue.");
        }
        // Update 'capacity' to 'newCapacity'
        this.capacity = newCapacity;
    }

    // Method to return a string representation of the queue
    @Override
    public String toString() {
        // If the queue is empty, return an empty string
        if (isEmpty()) {
            return "";
        }
        // Create a StringBuilder to build the string representation
        StringBuilder sb = new StringBuilder();
        // Start traversal from the front of the queue
        dNode<T> temp = head;
        // Continue traversal until the end of the queue is reached
        do {
            // Append the data of each node to the StringBuilder
            sb.append(temp.data).append(" | ");
            // Move to the next node
            temp = temp.next;
        } while (temp != head);
        // Return the string representation
        return sb.toString();
    }
}
