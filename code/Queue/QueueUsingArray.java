package Queue;

public class QueueUsingArray {
    int front, rear, size, capacity;
    int[] queue;

    // Constructor to initialize the queue
    QueueUsingArray(int c) {
        front = 0;
        rear = 0;
        size = 0;
        capacity=c;
        queue = new int[capacity];
    }

    // Function to insert an element at the rear of the queue
    void enqueue(int data) {
        // Check if the queue is full
        if (isEmpty()) {
            queue[rear]=data;
            rear = (rear+1) % queue.length;
            size = size+1;
            
        }
        else{    
            System.out.println("Queue is full");
        }

    }

    // Function to delete an element from the front of the queue
    int dequeue() {
        // If the queue is empty
        if (size==0) {
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            int data=queue[front];
            front = (front+1) % queue.length;
            size = size - 1;
            return data;

        }
        
    }

    // Function to print queue elements
    void display() {
        if (size>0 && size <= queue.length) {
        
        // Traverse front to rear and print elements
            for (int i = 0; i < size; i++) {
                System.out.print(queue[(front + i)%queue.length] + " <-- ");
            }
        }
    }


    // Function to print the front of the queue
    void front() {
        if (size == 0) {
            System.out.println("Queue is Empty");
            return;
        }
        System.out.println("Front Element is: " + queue[front]);
    }

    boolean isEmpty(){
        return size<queue.length;
    }

   

    public static void main(String[] args) {
        // Create a queue of capacity 4
        QueueUsingArray q = new QueueUsingArray(4);

        // Print queue elements
        

        // Insert elements in the queue
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        

       
        q.display();
        
        System.out.println();
       
        q.enqueue(60); 

        // Dequeue elements
        q.dequeue();
        q.dequeue();
        
        System.out.println("After two node deletions");
        q.display();

        
        q.enqueue(60);
        
        System.out.println();
        System.out.println("After one insertion");
         q.display();


        // Print front of the queue
        q.front();

        }
}

