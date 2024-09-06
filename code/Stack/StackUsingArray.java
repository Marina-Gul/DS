package Stack;

public class StackUsingArray {
   
    int size; 
    int top; 
    int a[];  

    StackUsingArray(int c){
         
        int top=-1; 
        size=c;
        a = new int[size]; // Maximum size of Stack 
        
    }

    boolean isEmpty() 
    { 
        return (top < size-1); 
    } 
        
    void push(int x) 
    { 
        if (!isEmpty()) { 
            System.out.println("Stack Overflow"); 
            return; 
        } 
        else { 
            a[++top] = x; 
            System.out.println(x + " pushed into stack");  
        } 
    } 

    int pop() 
    { 
        if (top < 0) { 
            System.out.println("Stack Underflow"); 
            return 0; 
        } 
        else { 
            int x = a[top--]; 
            return x; 
        } 
    } 

    int peek() 
    { 
        if (top < 0) { 
            System.out.println("Stack Underflow"); 
            return 0; 
        } 
        else { 
            int x = a[top]; 
            return x; 
        } 
    } 
    
    void print(){ 
        for(int i = top;i>-1;i--){ 
            System.out.print(" "+ a[i]); 
        } 
    }
    public static void main(String args[]) 
    { 
        StackUsingArray s = new StackUsingArray(5); 
        s.push(10); 
        s.push(20); 
        s.push(30); 
        s.push(40); 
        s.push(50); 
        
        System.out.println(s.pop() + " Popped from stack"); 
        System.out.println("Top element is :" + s.peek()); 
        System.out.print("Elements present in stack :"); 
        s.print(); 

    }
}
