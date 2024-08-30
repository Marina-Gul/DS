package LinkedList;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        next = null;
    }

    public Node(Node next){
        this.next = next;
    }
}
public class LinkedListWithDummyNode {
    Node head;
    int size;
 
    public LinkedListWithDummyNode() {
        head = new Node(null);
        size = 0;
    }

    public void addToBack(int data) {
        Node newNode = new Node(data);
        Node node = head;
        while(node.next != null){
            node = node.next;
        }
        node.next = newNode;
        size++;
    }

    public void addToFront(int data) {
        Node node = new Node(data);
        node.next = head.next;
        head.next = node;
        size++;
    }

    public void printList(){
        Node node = head.next;
        while(node.next != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.print(node.data + " ");

    }
    public Boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public static void main(String[] args) {

        LinkedListWithDummyNode ll= new LinkedListWithDummyNode();
     
        ll.addToBack(10);
        ll.addToFront(5);
        ll.addToFront(2);      
        ll.printList();
        



       
    }
}
