package LinkedList;

public class GenericLinkedList<T> {

    private Node<T> head;   // Pointer to the first node
    private int size;       // Track the size of the list
    
    // Inner class for the node structure
    private static class Node<T> {
        T data;
        Node<T> next;
    
        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Constructor to initialize an empty list
    public GenericLinkedList() {
        head = null;
        size = 0;
    }
    
    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }
    
    // Get the size of the list
    public int size() {
        return size;
    }
    
    // Add an item to the back of the list
    public void addToBack(T item) {
        Node<T> newNode = new Node<>(item);

        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    public void addToFront(T data){
        
        Node<T> newNode =new Node<>(data);
        if(isEmpty()){
            head=newNode;
        }else {
        newNode.next=head;
        head=newNode;
        }
        size++;
        }
    
    // Add an item at the middle (or given index) of the list
    public void addToMiddle(int index, T item) {
        if (index < 1 || index > size + 1) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node<T> newNode = new Node<>(item);

        if (index == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 1; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }
    // Remove an item at the given index
    public void removeAt(int index) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 1) {
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 1; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }
    // Remove the first element of the list (front)
    public void removeFromFront() {
        if (isEmpty()) {
            System.out.println("List is empty. No element to remove.");
            return;
        }

        head = head.next;
        size--;
    }

    // Remove the last element of the list (back)
    public void removeFromBack() {
        if (isEmpty()) {
            System.out.println("List is empty. No element to remove.");
            return;
        }

        if (size == 1) {
            head = null;
        } else {
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[ size: ").append(size).append(" - ");

        Node<T> current = head;
        while (current != null) {
            result.append(current.data);
            if (current.next != null) {
                result.append(", ");
            }
            current = current.next;
        }
        result.append(" ]");
        return result.toString();
    }

    // Helper method to print the list
    public void printList() {
        System.out.println(this.toString());
    }


    public static void main(String[] args) {
        GenericLinkedList<Integer> list = new GenericLinkedList<>();

        // Adding elements to the list
        list.addToBack(10);
        list.addToBack(20);
        list.addToBack(30);
        System.out.println(list); // Output: [ size: 3 - 10, 20, 30 ]

        // Removing from the front
        list.removeFromFront();
        System.out.println(list); // Output: [ size: 2 - 20, 30 ]

        // Removing from the back
        list.removeFromBack();
        System.out.println(list); // Output: [ size: 1 - 20 ]

        // Trying to remove the last remaining element from the front
        list.removeFromFront();
        System.out.println(list); // Output: [ size: 0 - ]

        // Removing from an empty list
        list.removeFromBack();    // Output: List is empty. No element to remove.
    }

     
}
