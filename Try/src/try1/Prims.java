package try1;
import java.util.Scanner;
import java.util.LinkedList;
class Node{
    int dest;
    int weight;
}
class Graph{
    int v;
    LinkedList<Integer>[] adj=new LinkedList[v];
    Graph(int v){
        for (int i = 0; i < v; i++) {
            adj[i]=new LinkedList<>();
        }
    }
}
public class Prims {
    
}
