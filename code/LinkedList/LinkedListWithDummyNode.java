package LinkedList;

public class LinkedListWithDummyNode implements List{

    // Your Node class should be an inner class within the LinkedList class.
    class Node {
        Object data;
        Node next;
    
        public Node(Object data) {
            this.data = data;
            next = null;
        }
    
        public Node(Node next){
            this.next = next;
        }
    }

    Node head;
    int size;

    public LinkedListWithDummyNode() {
        head = new Node(null);
        size = 0;
    }

    @Override
    public void addToBack(Object item) {
        
        Node newNode = new Node(item);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;    
    }

    @Override
    public void addToMiddle(int index, Object item) {
        if (index < 1 || index > size + 1) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        Node newNode = new Node(item);

        if (index == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node temp = head;
            for (int i = 1; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
        size++;       
    }

    @Override
    public List duplicate() {
        LinkedListWithDummyNode newList = new LinkedListWithDummyNode();
        Node temp = head;

        while (temp != null) {
            newList.addToBack(temp.data);
            temp = temp.next;
        }

        return newList;
    }

    @Override
    public List duplicateReversed() {
        LinkedListWithDummyNode newList = new LinkedListWithDummyNode();
        Node current = head;

        while (current != null) {
            // Add elements to the front of the new list to reverse the order
            Node newNode = new Node(current.data);
            newNode.next = newList.head;
            newList.head = newNode;
            newList.size++;
            current = current.next;
        }

        return newList;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void removeAt(int index) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index");
        }

        if (index == 1) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 1; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }

        size--;
        
    }

    @Override
    public void removeFromFront(Object item) {
        if (isEmpty()) {
            return;
        }
        if (head.data.equals(item)) {
            head = head.next;
            size--;
            return;
        }

        Node current = head;
        while (current.next != null && !current.next.data.equals(item)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            size--;
            
        }
        
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String result= "[ size: " + size + " ";

        Node current = head;
        //for head
        while (current != null) {
            result+= current.data;
            
            if (current.next != null) {
                result+= " , ";
            }
            current = current.next;
        }
        result+=" ] ";
        return result;
    }

    void printList() {
        Node node= head;
        while (node.next != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.print(node.data + " ");
    }
        
    public static void main(String[] args) {
    
        LinkedListWithDummyNode ll=new LinkedListWithDummyNode();
        ll.addToBack("Sukkur");  // Add first item
        ll.addToBack("IBA");  // Add second itemll.addToBack();
        System.out.println(ll.toString());

}
}   
    