package checkLoop;
import java.util.*;

import bfs.bfs;
public class ByBFS {
	private int V;
	private LinkedList<Integer> adj[];
	ByBFS(int v){
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
	boolean isCyclicConnected(int s,boolean visited[]) {
		Queue<Integer> q=new LinkedList<>();
		visited[s]=true;
		q.add(s);
		int parent[]=new int[V];
		Arrays.fill(parent, -1);
		
		while(!q.isEmpty())
		{
			int temp=q.poll();
			
			Iterator<Integer> i=adj[temp].iterator();
			while(i.hasNext())
			{
				int n=i.next();
//				System.out.println(n);
				if(!visited[n])
				{
					visited[n]=true;
					q.add(n);
					parent[n]=temp;
				}
				else if(parent[temp]!=n)
				{
//					System.out.print(n);
					return true;
				}
			}
		}
//		for(int j=0;j<V;j++)
//			System.out.print(parent[j]);
		return false;
	}
	
	boolean isCyclicDisconnected() {
		boolean visited[]=new boolean[V];
		Arrays.fill(visited, false);
		
		for(int i=0;i<V;i++)
		{
			
			if(!visited[i] && isCyclicConnected(i,visited))
			{
//				System.out.print(i);
				return true;		
			}
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByBFS g = new ByBFS(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
//        for(int i=0;i<g.V;i++)
//        {
//        	System.out.println(g.adj[i].toString());
//        }
        if(g.isCyclicDisconnected())
        {
        	System.out.println("graph contains cycle");
        }
        else
        	System.out.println("Graph doesnot contain cycle");
        
        ByBFS g2 = new ByBFS(3); 
        g2.addEdge(0, 1); 
        g2.addEdge(1, 2); 
//        for(int i=0;i<g2.V;i++)
//          {
//          	System.out.println(g2.adj[i].toString());
//          }
        if (g2.isCyclicDisconnected()) 
            System.out.println("Graph contains cycle"); 
        else
            System.out.println("Graph doesn't contains cycle"); 
	}

}
