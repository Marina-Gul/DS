import java.lang.classfile.components.ClassPrinter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class graph {
 
    int V;
    ArrayList<ArrayList<Integer>> list;   //list of list
    ArrayList<Integer> arr[];        // array of list


    graph(int v){
        
        V=v;
        //list =new ArrayList<>(V);
        arr=new ArrayList[V];
        
        for (int i = 0; i < V; i++)
          //  list.add(new ArrayList<Integer>());

        arr[i]=new ArrayList<>();

    }
    
    void addEdge(int i, int j) {
        
        //list.get(i).add(j);
        //list.get(j).add(i); // for undirected two way

        arr[i].add(j);
        arr[j].add(i);
    
    
    }

    void bfs(){
        Queue<Integer> q=new LinkedList<>();
        boolean[] visited= new boolean[V];

        q.add(0);
        
        while(!q.isEmpty()){

            int key=q.remove();
            if(visited[key]!=true){
                System.out.println(key + " ");
                visited[key]=true;
                for( int i: list.get(key)){
                    q.add(i);
                }
            }
        }
            
    }
   
    void display(){

        for(int i=0; i<list.size();i++){
            
            System.out.println("\nvertex"+ i + ":" );

            for(int j: list.get(i)){
            
                System.out.print(j + "-->");
            }
        }

    }

    void dfs(int current, boolean[] visited){

        System.out.println(current+ " ");
        visited[current]=true;

        for(int i:list.get(current)){
            if(visited[i]!=true)
                dfs(i,visited);
        }
    }


    public static class Node implements Comparable<Node>
    {
 
    // Member variables of this class
    public int node;
    public int weight;
 
    public Node(int node, int cost)
    {
 
        // This keyword refers to current instance itself
        this.node = node;
        this.weight = cost;
    }
 
    // Method 1
    @Override public int compareTo(Node node)
    {
        return this.weight-node.weight;
    }


    public static void main(String[] args) {
        
        graph g=new graph(4);
        g.addEdge(0,1);
        
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2, 3);
        g.addEdge(3,0);

        //g.display();
        //g.bfs();
        boolean[] visited=new boolean[4];
        g.dfs(0,visited);
    
    }

    
}
