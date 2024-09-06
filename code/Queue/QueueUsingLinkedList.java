package Queue;

class Node {
    int data;
    Node next;

    Node(int new_data) {
        this.data = new_data;
        this.next = null;
    }
}

public class QueueUsingLinkedList {
    // Node class representing a single node in the linked list

  
    // Pointer to the front for head and the rear for tail of the linked list
    static Node front, rear;

    // Function to check if the queue is empty
    public static boolean isEmpty() {
      
        // If the front and rear are null, then the queue is
        // empty, otherwise it's not
        return front == null && rear == null;
    }

    // Function to add an element to the queue
    public static void enqueue(int data) {
      
        // Create a new linked list node
        Node newNode = new Node(data);

        // If queue is empty, the new node is both the front
        // and rear
        if (rear == null) {
            front = rear = newNode;
            return;
        }

        // Add the new node at the end of the queue and
        // change rear
        rear.next = newNode;
        rear = newNode;
    }

    // Function to remove an element from the queue
    public static int dequeue() {
      
        // If queue is empty, return
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return Integer.MIN_VALUE;
        }

        // Store previous front and move front one node
        // ahead
        int k = front.data;
        front = front.next;

        // If front becomes null, then change rear also
        // to null
        if (front == null) {
            rear = null;
        }
        return k;
    }

    // Function to get the front element of the queue
    public static int getFront() {
      
        // Checking if the queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return front.data;
    }

    // Function to get the rear element of the queue
    public static int getRear() {
      
        // Checking if the queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return Integer.MIN_VALUE;
        }
        return rear.data;
    }
     public static void main(String[] args) {
        

        // Enqueue elements into the queue
        enqueue(10);
        enqueue(20);
      
        System.out.println("Queue Front: " + getFront());
        System.out.println("Queue Rear: " + getRear());

        // Dequeue elements from the queue
        dequeue();
        dequeue();

        // Enqueue more elements into the queue
        enqueue(30);
        enqueue(40);
        enqueue(50);

        // Dequeue an element from the queue
        dequeue();

        System.out.println("Queue Front: " + getFront());
        System.out.println("Queue Rear: " +  getRear());
}
}
    

