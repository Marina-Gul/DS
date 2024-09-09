package LinkedList;
 class Node {
    String name;
    Node prev, next;

    Node (String name) {
        this.prev = null;
        this.next = null;
        this.name = name;
    }
}
public class DoublyLinkedList {
  
    Node head;
    int size=0;

    // Add node with name in beginning of linkedlist, name as parameter  
    public void insertAtBeginning(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add node in beginning of linkedlist, node as parameter  
    public void insertAtBeginning(Node node) {
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    // Add node in end of linkedlist, name as parameter  
    public void insertAtEnd(String name) {
        Node newNode = new Node(name);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }
    }

    // Add node in end of linkedlist, node as parameter  
    public void insertAtEnd(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
            node.prev = temp;
        }
    }

    // Add node after name which is provided as param , name and node as params  
    public void insertAfterName(String name, Node node) {
        Node temp = head;
        while (temp != null && !temp.name.equals(name)) {
            temp = temp.next;
        }
        if (temp != null) {
            node.next = temp.next;
            if (temp.next != null) {
                temp.next.prev = node;
            }
            temp.next = node;
            node.prev = temp;
        }
    }

    // Add node before name which is provided as param , name and node as params  
    public void insertBeforeName(String name, Node node) {
        Node temp = head;
        while (temp != null && !temp.name.equals(name)) {
            temp = temp.next;
        }
        if (temp != null) {
            node.prev = temp.prev;
            node.next = temp;
            if (temp.prev != null) {
                temp.prev.next = node;
            } else {
                head = node;
            }
            temp.prev = node;
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

    // Test the class         
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.insertAtBeginning("Node1");
        list.insertAtEnd("Node2");
        list.insertAtEnd("Node3");
        list.insertAfterName("Node1", new Node("Node1.5"));
        list.insertBeforeName("Node3", new Node("Node2.5"));

        System.out.println("Linked List before making it circular:");
        list.printAll();

        list.makeCircular();
        System.out.println("Circular Linked List:");
        list.printAll();

    }
}
