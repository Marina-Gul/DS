package LinkedList;

public class Practice extends LinkedList{
    
    /*Write a function to get the nth node from the end of the linked list.
    
    Function name: int nthFromLast(int n)
    
    This method uses the two-pointer approach (also known as the fast and slow pointer technique)
    to efficiently find the nth node from the end in a single pass.
    */

    public Object nthFromLast(int n) {
        if (n <= 0 || n > size) {
            throw new IllegalArgumentException("Invalid value of n: " + n);
        }

        Node first = head;
        Node second = head;

        // Move the first pointer n steps ahead
        for (int i = 0; i < n; i++) {
            first = first.next;
        }

        // Now move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // The second pointer now points to the nth node from the end
        return second.data;
    }

    public void reverseList(){
        head=reverseList(head);
    }

    public Node reverseList(Node head) {
        
        // Initialize three pointers: curr, prev and next
        Node curr = head, prev = null, next;

        // Traverse all the nodes of Linked List
        while (curr != null) {
            
            // Store next
            next = curr.next;
            
            // Reverse current node's next pointer
            curr.next = prev;
            
            // Move pointers one position ahead
            prev = curr;
            curr = next;
        }
        
        // Return the head of reversed linked list
        return prev;
    }

    public static void main(String[] args) {
        Practice list =new Practice();
        list.addToBack(10);
        list.addToBack(20);
        list.addToBack(30);
        list.addToBack(40);
        list.addToBack(50);

        list.printList();  // Output: [ size: 5 - 10, 20, 30, 40, 50 ]

        // Getting the 2nd node from the end
        System.out.println("\n 2nd node from the end is: " + list.nthFromLast(2));  // Output: 40

       list.reverseList();
       list.printList();

    
    }
    }
