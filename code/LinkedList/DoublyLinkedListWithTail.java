package LinkedList;

public class DoublyLinkedListWithTail {
    class Node {
        String name;
        Node next;
        Node prev;
    
        // Constructor to create a node
        public Node(String name) {
            this.name = name;
            this.next = null;
            this.prev = null;
        }
    } 
    Node head;
    Node tail;
    int size=0;

    // Add node with name in beginning of linkedlist, name as parameter  
    public void insertAtBeginning(String name) {
        Node newNode = new Node(name);
        insertAtBeginning(newNode);
    }

    // Add node in beginning of linkedlist, node as parameter  
    public void insertAtBeginning(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev=node;
            head = node;
        }
    }

    // Add node in end of linkedlist, name as parameter  
    public void insertAtEnd(String name) {
        Node newNode = new Node(name);
        insertAtEnd(newNode);
    }

    // Add node in end of linkedlist, node as parameter  
    public void insertAtEnd(Node node) {
        if (head == null) {
            head = node;
            tail=node;
        } else {
            node.prev=tail;
            tail.next=node;
            tail=node;
        }
    }

    // Add node after name which is provided as param , name and node as params  
    public void insertAfterName(String name, Node node) {
        Node current = head;
        while (current != null && !current.name.equals(name)) {
            current = current.next;
        }

        if (current != null) {
            Node newNode = new Node(name);
            newNode.next = current.next;
            newNode.prev = current;

            if (current.next != null) {
                current.next.prev = newNode;
            } else {
                tail = newNode;  // Update tail if inserted at the end
            }

            current.next = newNode;
        }
    }

    // Add node before name which is provided as param , name and node as params  
    public void insertBeforeName(String name, Node node) {
        Node current = head;
        while (current != null && !current.name.equals(name)) {
            current = current.next;
        }

        if (current != null) {
            Node newNode = new Node(name);
            newNode.prev = current.prev;
            newNode.next = current;

            if (current.prev != null) {
                current.prev.next = newNode;
            } else {
                head = newNode;  // Update head if inserted at the beginning
            }

            current.prev = newNode;
        }
    }
    public void deleteNode(String name) {
        Node current = head;
        while (current != null && !current.name.equals(name)) {
            current = current.next;
        }

        if (current != null) {
            if (current.prev != null) {
                current.prev.next = current.next;
            } else {
                head = current.next;  // Update head if deleting the first node
            }

            if (current.next != null) {
                current.next.prev = current.prev;
            } else {
                tail = current.prev;  // Update tail if deleting the last node
            }
        }
    }

    // Make double linkedlist as Circular Double LinkedList  
    public void makeCircular() {
        if (head == null) return;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        head.prev = tail;
        
    }

    // Print all the nodes in linkedlist, make sure it works on circular double linkedlist  
    public void printAll() {
        if (head == null) return;
        Node temp = head;
        do {
            if(temp==null){return;}
            System.out.println(temp.name);
            temp = temp.next;
        } while (temp != head);
    }

}
