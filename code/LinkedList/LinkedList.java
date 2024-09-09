package LinkedList;

public class LinkedList{

    class Node{
        Object data;
        Node next;
    
        //Constructor
        Node(Object data)
        {
            this.data=data;
            this.next=null;
    
        }
    }
        
    Node head;
    int size=0;
    
    void addToBack(Object data)
    {
        Node newNode=new Node(data);
        
        if(head==null){
            head=newNode;
        }
        else{
            Node temp=head;
            while(temp.next!=null){
                temp=temp.next;
            }   
            
            temp.next=newNode;
        }
        size++;

    }
    
    void printList() {
        Node temp= head;
        while (temp.next != null){
            System.out.print(temp.data + " - > ");
            temp = temp.next;
        }
        System.out.print(temp.data + " ");
    }
        
    void addToFront(Object data){
        
        Node newNode =new Node(data);
        if(isEmpty()){
            head=newNode;
        }else{
        newNode.next=head;
        head=newNode;
        }
        size++;
        }

    void addMiddle(int index,Object data)
    {
        Node newNode=new Node(data);
        Node n=head;
        for(int i=1;i<index-1;i++)
        {
            n=n.next;
        }
        newNode.next=n.next;
        n.next=newNode;
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
