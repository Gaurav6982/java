package checkLoop;
import java.util.*;

import bfs.bfs;
public class ByDFS {
	private int V;
	private LinkedList<Integer> adj[];
	ByDFS(int v){
		V=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<>();
		}
	}
	void addEdge(int v,int w)
	{
		adj[v].add(w);
		adj[w].add(v);
	}
	boolean isCyclicUtil(int s,boolean visited[],int parent) {
		visited[s]=true;
		Iterator<Integer> i=adj[s].iterator();
		while(i.hasNext())
		{
			int n=i.next();
			if(!visited[n])
			{
				isCyclicUtil(n,visited,s);
			}
			else if(n!=parent)
			{
				return true;
			}
		}
		return false;
	}
	
	boolean isCyclic() {
		boolean visited[]=new boolean[V];
		Arrays.fill(visited, false);
		
		for(int i=0;i<V;i++)
		{
			if(!visited[i] && isCyclicUtil(i,visited,-1))
				return true;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByDFS g = new ByDFS(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
        if(g.isCyclic())
        {
        	System.out.println("graph contains cycle");
        }
        else
        	System.out.println("Graph doesnot contain cycle");
        
        ByDFS g2 = new ByDFS(3); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
        if (g2.isCyclic()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
	}

}
