package LinkedList;

public class LinkedList{

    class Node{
        int data;
        Node next;
    
        //Constructor
        Node(int data)
        {
            this.data=data;
            this.next=null;
    
        }
    }
        
    Node head;
    static int size=0;
    
    void addToBack(int data)
    {
        Node node=new Node(data);
        
        if(head==null){
            head=node;
            size++;
        }
        else{
            Node n=head;
            while(n.next!=null)
                n=n.next;
            n.next=node;
            size++;
        }
    }
    
    void printList() {
        Node node= head;
        while (node.next != null){
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.print(node.data + " ");
    }
        void addToFront(int data)
        {
            Node node =new Node(data);
            if(isEmpty()){
                head=node;
                size++;
            
            }
            else{
            node.next=head;
            head=node;
            size++;
            }

        }

    void addMiddle(int index,int data)
    {
        Node node=new Node(data);
        Node n=head;
        for(int i=1;i<index-1;i++)
        {
            n=n.next;
        }
        node.next=n.next;
        n.next=node;
        size++;
    }
    void removeFromFront()
    {
       if(isEmpty()){
        System.out.println("List is Empty");
       }
        else{
            head=head.next;
            size--;
        }

    }
    void removeFromBack()
    {
        if(isEmpty()){
            System.out.println("List is Empty");
           }
        else{
        Node n=head;
        while(n.next.next!=null)
            n=n.next;
        n.next=null;
        size--;
        }
    }
    void removeAt(int index)
    {
    if (index==1)
         removeFromFront();
    
    else{
        Node n=head;
        Node temp;
        for(int i=1;i<index-1;i++)
        {
            n=n.next;
        }
        temp=n.next;
        n.next=temp.next;
        size--;
    }
}
    
    boolean isEmpty(){
    return head == null;
    }




    public static void main(String[] args) {
        LinkedList ll=new LinkedList();
        ll.addToBack(5);
        ll.addToBack(19);
        ll.addToFront(10);
        ll.addMiddle(2, 3);
        
        
        ll.printList();
        System.out.println("");
        
    }

}
