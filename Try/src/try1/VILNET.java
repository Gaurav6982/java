package try1;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Random;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Iterator;
import java.lang.*;
class node{
    int num;
    int x,y;
    node(int num,int x,int y)
    {
        this.num=num;
        this.x=x;
        this.y=y;
    }
    node(int x,int y)
    {
        this.x=x;
        this.y=y;
    }
}
public class VILNET{
    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int i, int j) 
    { 
        adj.get(i).add(j); 
        adj.get(j).add(i); 
    } 
    public static boolean add_to_lists(HashMap<Integer,LinkedList<Integer>> pairs,ArrayList<ArrayList<Integer>> adj,int new_x,int new_y,int node_num,int v)
    {
        node new_node=new node(new_x,new_y);
        if(!pairs.containsKey(new_x))
        pairs.put(new_x,new LinkedList<>());
        if(!pairs.get(new_x).contains(new_y))
        {
            pairs.get(new_x).add(new_y);
            new_node.num=v;
            adj.get(node_num).add(v);
            adj.get(v).add(node_num);
            return true;
        }
        return false;
    }
    public static boolean check(int x,int y,int x1,int y1)
    {
        if(x==x1 && y==y1)
        return true;
        return false;
    }
    private static void printShortestDistance( 
                     ArrayList<ArrayList<Integer>> adj, 
                             int s, int dest, int v) 
    { 
        // predecessor[i] array stores predecessor of 
        // i and distance array stores distance of i 
        // from s 
        int pred[] = new int[v]; 
        int dist[] = new int[v]; 
  
        if (BFS(adj, s, dest, v, pred, dist) == false) { 
            System.out.println("Given source and destination are not connected"); 
            return; 
        } 
  
        // LinkedList to store path 
        LinkedList<Integer> path = new LinkedList<Integer>(); 
        int crawl = dest; 
        path.add(crawl); 
        while (pred[crawl] != -1) { 
            path.add(pred[crawl]); 
            crawl = pred[crawl]; 
        } 
  
        // Print distance 
        // System.out.println("Shortest path length is: " + dist[dest]); 
        System.out.println(dist[dest]); 
  
        // Print path 
        // System.out.println("Path is ::"); 
        // for (int i = path.size() - 1; i >= 0; i--) { 
        //     System.out.print(path.get(i) + " "); 
        // } 
    } 
  
    // a modified version of BFS that stores predecessor 
    // of each vertex in array pred 
    // and its distance from source in array dist 
    private static boolean BFS(ArrayList<ArrayList<Integer>> adj, int src, 
                                  int dest, int v, int pred[], int dist[]) 
    { 
        // a queue to maintain queue of vertices whose 
        // adjacency list is to be scanned as per normal 
        // BFS algorithm using LinkedList of Integer type 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // boolean array visited[] which stores the 
        // information whether ith vertex is reached 
        // at least once in the Breadth first search 
        boolean visited[] = new boolean[v]; 
  
        // initially all vertices are unvisited 
        // so v[i] for all i is false 
        // and as no path is yet constructed 
        // dist[i] for all i set to infinity 
        for (int i = 0; i < v; i++) { 
            visited[i] = false; 
            dist[i] = Integer.MAX_VALUE; 
            pred[i] = -1; 
        } 
  
        // now source is first to be visited and 
        // distance from source to itself should be 0 
        visited[src] = true; 
        dist[src] = 0; 
        queue.add(src); 
  
        // bfs Algorithm 
        while (!queue.isEmpty()) { 
            int u = queue.remove(); 
            for (int i = 0; i < adj.get(u).size(); i++) { 
                if (visited[adj.get(u).get(i)] == false) { 
                    visited[adj.get(u).get(i)] = true; 
                    dist[adj.get(u).get(i)] = dist[u] + 1; 
                    pred[adj.get(u).get(i)] = u; 
                    queue.add(adj.get(u).get(i)); 
  
                    // stopping condition (when we find 
                    // our destination) 
                    if (adj.get(u).get(i) == dest) 
                        return true; 
                } 
            } 
        } 
        return false; 
    } 
    public static void main(String[] args) throws IOException{
        // BufferedReader sc=new BufferedReader( new InputStreamReader(System.in));
        // int t=Integer.parseInt(sc.readLine().trim().split("\\s+")[0]);
        Random r=new Random();
        int t=r.nextInt(1000)+1;
        while(t-->0)
        {
            // String line[]=sc.readLine().trim().split("\\s+");
            // int x1=Integer.parseInt(line[0]);
            // int y1=Integer.parseInt(line[1]);
            // int x2=Integer.parseInt(line[2]);
            // int y2=Integer.parseInt(line[3]);
            int x1=r.nextInt(20)+1;
            int y1=r.nextInt(20)+1;
            int x2=r.nextInt(20)+1;
            int y2=r.nextInt(20)+1;
            node point1=new node(0,x1,y1);
            node point2=new node(x2,y2);
            if(x1==x2 && y1==y2)
            {
                System.out.println(0);
                continue;
            }
            HashMap<Integer,LinkedList<Integer>> pairs=new HashMap<>();
            pairs.put(x1, new LinkedList<>());
            pairs.get(x1).add(y1);
            ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
            for (int i = 0; i < 1000000; i++) {
                adj.add(new ArrayList<Integer>());
            }
            Queue<node> nodes=new LinkedList<node>();
            nodes.add(point1);
            int v=1;
            while(!nodes.isEmpty())
            {
                node temp=nodes.poll();
                int node_num=temp.num;
                int new_x=temp.x+2*temp.y;
                int new_y=temp.y;
                boolean added=add_to_lists(pairs,adj,new_x,new_y,node_num,v);
                if(added)
                {
                    nodes.add(new node(v,new_x,new_y));
                    v++;
                }
                    
                if(check(new_x,new_y,x2,y2))
                {
                    // System.out.println(node_num+" "+temp.x+" "+temp.y);
                    point2.num=v-1;
                    break;
                    
                }
              
                new_x=temp.x-2*temp.y;
                new_y=temp.y;
                added=add_to_lists(pairs,adj,new_x,new_y,node_num,v);
                if(added)
                {
                    nodes.add(new node(v,new_x,new_y));
                    v++;
                }
                if(check(new_x,new_y,x2,y2)) 
                {
                    // System.out.println(node_num+" "+temp.x+" "+temp.y);
                    point2.num=v-1;
                    break;
                    
                }
                
                if(temp.y+2*temp.x>0)
                {
                    new_x=temp.x;
                    new_y=temp.y+2*temp.x;
                }
                else
                {
                    new_x=-temp.x;
                    new_y=-(temp.y+2*temp.x);
                }
                added=add_to_lists(pairs,adj,new_x,new_y,node_num,v);
                if(added)
                {
                    nodes.add(new node(v,new_x,new_y));
                    v++;
                }
                if(check(new_x,new_y,x2,y2))
                {
                    // System.out.println(node_num+" "+temp.x+" "+temp.y);
                    point2.num=v-1;
                    break;
                    
                }


                if(temp.y-2*temp.x>0)
                {
                    new_x=temp.x;
                    new_y=temp.y-2*temp.x;
                }
                else
                {
                    new_x=-temp.x;
                    new_y=-(temp.y-2*temp.x);
                }
                added=add_to_lists(pairs,adj,new_x,new_y,node_num,v);
                if(added)
                {
                    nodes.add(new node(v,new_x,new_y));
                    v++;
                }
                if(check(new_x,new_y,x2,y2))
                {
                    // System.out.println(node_num+" "+temp.x+" "+temp.y);
                    point2.num=v-1;
                    break;
                    
                }

            }
            // System.out.println(v);
        //    for(Entry<Integer,LinkedList<Integer>> e:pairs.entrySet())
        //    {
        //         int num=e.getKey();
        //         LinkedList<Integer> at=e.getValue();
        //         System.out.print(num+" ");
        //         Iterator<Integer> i = at.iterator();
        //         while (i.hasNext()) {
        //         System.out.print(i.next()+" ");
        //         }
        //         System.out.println();

        //    }
        // for (int j = 0; j < 5;j++) {
        //     ArrayList<Integer> at=adj.get(j);
        //     Iterator<Integer> i = at.iterator();
        //         while (i.hasNext()) {
        //         System.out.print(i.next()+" ");
        //         }
        //         System.out.println();
        //     }

        // System.out.println(point2.num);
        // System.out.println(point1.num);
        // System.out.println(v);
        printShortestDistance(adj, point1.num, point2.num, v); 
        }
        // sc.close();
    }
}