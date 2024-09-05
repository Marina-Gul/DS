package LinkedList;

public class CircularLinkedList {
   public static class Node {
        int data;
        Node next;
    
        Node(int value) {
            data = value;
            next = null;
        }
    }
    public static Node insertAtBeginning(Node last, int data){
        
        Node newNode = new Node(data);

    // If the list is empty, make the new node point to itself and set it as last
    
    if (last == null) { 
        newNode.next = newNode;
        last=newNode;
        return last;
    }

    // Insert the new node at the beginning
    newNode.next = last.next;
    last.next = newNode;
    // no need to update last pointer as we are adding at front
    return last;
}
  
    
    
    static Node insertAtLast(Node last, int data) {
        
        // Create a new node
        Node newNode = new Node(data);

        if (last == null) {
        
        // Point newNode to itself
        newNode.next = newNode;
 
        // Update last to point to the new node
        last = newNode;
    }
    else{
         newNode.next=last.next;
         last.next=newNode;
         last=newNode;
    }
    return last;
}

    public static Node deleteFirstNode(Node last) {
        if (last == null) {
            // If the list is empty
            System.out.println("List is empty");
            return null;
        }

        Node head = last.next;

        if (head == last) {
            // If there is only one node in the list
            last = null;
        } else {
            // More than one node in the list
            last.next = head.next;
        }

        return last;
    }

    public static Node deleteLastNode(Node last){
        if (last == null) {
            // If the list is empty
            System.out.println("List is empty, nothing to delete.");
            return null;
        }
        Node head = last.next;

        // If there is only one node in the list
        if (head == last) {
            last = null;
            return last;
        }
        // Traverse the list to find the second last node
        Node curr = head;
        while (curr.next != last) {
            curr = curr.next;
        }
        // Update the second last node's next pointer to
        // point to head
        curr.next = head;
        last = curr;

        return last;
    }

    static boolean search(Node last, int data) {
        if (last == null) {
            // If the list is empty
            return false;
        }

        Node head = last.next;
        Node curr = head;

        // Traverse the list to find the key
        while (curr != last) {
            if (curr.data == data) {
                // Key found
                return true;
            }
            curr = curr.next;
        }

        // Check the last node
        if (last.data == data) {
            // Key found
            return true;
        }
        // Key not found
        return false;
    }

    // Function to print the list
    static void printList(Node last) {
        if (last == null) return;

        // Start from the head node
        Node head = last.next;
        while (true) {
            System.out.print(head.data + " ");
            head = head.next;
            if (head == last.next) break;
        }
        System.out.println();
    }


//For the insertion of a node at the beginning, we need to traverse the whole list. 
//Also, for insertion at the end, the whole list has to be traversed. If instead of the start pointer, 
//we take a pointer to the last node, then in both cases there wonâ€™t be any need to traverse the whole list. 
//So insertion at the beginning or at the end takes constant time, irrespective of the length of the list.
    public static void main(String[] args) {
        Node last = null;

        // Insert a node into the empty list
        last= insertAtLast(last, 1);
        last= insertAtLast(last, 16);
        last= insertAtLast(last, 3);
        last= insertAtLast(last, 7);

        // Print the list
        System.out.print("List after insertion: ");
        printList(last);
    }
}


