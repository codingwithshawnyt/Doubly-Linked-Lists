//Shawn Ray
//Period 4
//dNode.java
//This code sets up the nodes to be used in a circular, 
//general, doubly linked list.

// Define a generic class dNode with type parameter T
public class dNode<T> {
    // Declare a variable 'data' of type T to hold the data of the node
    T data;
    // Declare a variable 'next' of type dNode<T> to hold the reference to the next node
    dNode<T> next;
    // Declare a variable 'prev' of type dNode<T> to hold the reference to the previous node
    dNode<T> prev;

    // Default constructor that initializes data, next, and prev to null
    public dNode() {
        this(null, null, null);
    }

    // Constructor that initializes data with the given value and next, prev to null
    public dNode(T data) {
        this(data, null, null);
    }

    // Constructor that initializes data, next, and prev with the given values
    public dNode(T data, dNode<T> next, dNode<T> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}
