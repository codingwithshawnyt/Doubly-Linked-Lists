//Shawn Ray
//Period 4
//QueuesTesting.java
//Testing Queue.java and dNode.java

public class QueuesTesting {
    public static void main(String[] args) {
        try {
            // Test default constructor and isEmpty method
            Queue<Integer> queue = new Queue<>();
            System.out.println("Expected: true | Actual: " + queue.isEmpty());

            // Test secondary constructor with one element
            Queue<Integer> queue2 = new Queue<>(1);
            System.out.println("Expected: 1 |  | Actual: " + queue2.toString());

            // Test that secondary constructor creates a circular list
            System.out.println("Expected: 1 | Actual: " + queue2.dequeue());
            try {
                queue2.dequeue();
            } catch (IllegalStateException e) {
                System.out.println("Caught expected IllegalStateException: " + e.getMessage());
            }

            // Test enqueue method with multiple elements
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            System.out.println("Expected: 1 | 2 | 3 |  | Actual: " + queue.toString());

            // Test size method with multiple elements
            System.out.println("Expected: 3 | Actual: " + queue.size());

            // Test dequeue method with multiple elements
            System.out.println("Expected: 1 | Actual: " + queue.dequeue());
            System.out.println("Expected: 2 | 3 |  | Actual: " + queue.toString());

            // Test sendToBack method
            queue.sendToBack();
            System.out.println("Expected: 3 | 2 |  | Actual: " + queue.toString());

            // Test capacity method
            System.out.println("Expected: 2147483647 | Actual: " + queue.capacity());

            // Test changeCapacity method
            queue.changeCapacity(5);
            System.out.println("Expected: 5 | Actual: " + queue.capacity());

            // Test enqueue method with changed capacity
            queue.enqueue(4);
            queue.enqueue(5);
            System.out.println("Expected: 3 | 2 | 4 | 5 |  | Actual: " + queue.toString());

            // Test size method with a while loop until the queue is empty
            while (queue.size() > 0) {
                System.out.println("Dequeued: " + queue.dequeue());
            }
            System.out.println("Expected: true | Actual: " + queue.isEmpty());

            // Test changeCapacity method with capacity less than size
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            try {
                queue.changeCapacity(2);
            } catch (IllegalArgumentException e) {
                System.out.println("Caught expected IllegalArgumentException: " + e.getMessage());
            }

            // Test enqueue method with full capacity
            queue.changeCapacity(3);
            try {
                queue.enqueue(4);
            } catch (IllegalStateException e) {
                System.out.println("Caught expected IllegalStateException: " + e.getMessage());
            }

            // Test dequeue method with empty queue
            while (!queue.isEmpty()) {
                queue.dequeue();
            }
            try {
                queue.dequeue();
            } catch (IllegalStateException e) {
                System.out.println("Caught expected IllegalStateException: " + e.getMessage());
            }

            // Test sendToBack method with empty queue
            try {
                queue.sendToBack();
            } catch (IllegalStateException e) {
                System.out.println("Caught expected IllegalStateException: " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Caught unexpected exception: " + e.getMessage());
        }
    }
}
