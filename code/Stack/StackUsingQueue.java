package Stack;

import java.util.Queue;



public class StackUsingQueue {
    
    Queue<Integer> q1=new Queue<>();
    Queue<Integer> q2=new Queue<>();
    
    void push(int data){
        q1.add(data);
    }
    void pop(){
       
        if (q1.isEmpty())
        return;

    // Leave one element in q1 and push others in q2.
    while (q1.size() != 1) {
        
        q2.add(q1.peek());
        q1.remove();
    }

    // Pop the only left element
    // from q1
    q1.remove();

    // swap the names of two queues
    Queue<Integer> q = q1;
    q1 = q2;
    q2 = q;

    }

    public static void main(String[] args) {
        StackUsingQueue s=new StackUsingQueue();
        s.push(3);
        s.push(4);
        s.pop();
    }
}
