package Stack;
class Node {
    int data;
    Node next;
    Node(int new_data) {
        this.data = new_data;
        this.next = null;
    }
}
public class StackUsingLinkedList {
     // Head of the linked list
     Node head;

     // Constructor to initialize the stack
     StackUsingLinkedList() { this.head = null; }
 
     // Function to check if the stack is empty
     boolean isEmpty() {
       
         // If head is null, the stack is empty
         return head == null;
     }
 
     // Function to push an element onto the stack
     void push(int data) {
       
         // Create a new node with given data
         Node newNode = new Node(data);
 
         // Check if memory allocation for the new node
         // failed
         if (newNode == null) {
             System.out.println("\nStack Overflow");
             return;
         }
 
         // Link the new node to the current top node
         newNode.next = head;
 
         // Update the top to the new node
         head = newNode;
     }
 
     // Function to remove the top element from the stack
     int pop() {
       
         // Check for stack underflow
         if (isEmpty()) {
             System.out.println("\nStack Underflow");
             return Integer.MIN_VALUE;
         }
         else {
           
             // Assign the current top to a temporary
             // variable
             Node temp=head;
             int k = head.data;
 
             // Update the top to the next node
             head = head.next;
 
             // Deallocate the memory of the old top node
             temp = null;
             return k;
         }
     }
 
     // Function to return the top element of the stack
     int peek() {
       
         // If stack is not empty, return the top element
         if (!isEmpty())
             return head.data;
         else {
             System.out.println("\nStack is empty");
             return Integer.MIN_VALUE;
         }
     }
     public static void main(String[] args)
    {
        // Creating a stack
        StackUsingLinkedList st = new StackUsingLinkedList();

        // Push elements onto the stack
        st.push(11);
        st.push(22);
        st.push(33);
        st.push(44);

        // Print top element of the stack
        System.out.println("Top element is " + st.peek());

        // removing two elemements from the top
          System.out.println("Removing two elements...");
        st.pop();
        st.pop();

        // Print top element of the stack
        System.out.println("Top element is " + st.peek());
    }
}
