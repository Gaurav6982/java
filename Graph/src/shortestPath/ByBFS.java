package shortestPath;

import java.util.Iterator;
import java.util.LinkedList;

import bfs.bfs;

public class ByBFS {
	 private LinkedList<Integer> adj[];
	private int V;
	private int dist[];
	ByBFS(int v) {
		V=v;
		dist=new int[V];
		adj = new LinkedList[v]; 
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<>();
		}
	}
	void addEdge(int i,int j)
	{
		adj[i].add(j);
		adj[j].add(i);
	}
	void BFS(int s) {
		LinkedList<Integer> q=new LinkedList<>();
		q.add(s);
		boolean visited[]=new boolean[V];
		visited[s]=true;
		
		while(q.size()!=0)
		{
			s=q.poll();
			Iterator<Integer> i=adj[s].iterator();
			while(i.hasNext())
			{
				int n=i.next();
				if(!visited[n])
				{
					dist[n]=dist[s]+1;
					visited[n]=true;
					q.add(n);
				}
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ByBFS g = new ByBFS(4); 
		  
       g.addEdge(0, 1); 
       g.addEdge(0, 2); 
       g.addEdge(1, 2); 
       g.addEdge(2, 3); 
       g.addEdge(3, 3); 
 
       g.BFS(2);
       for(int i:g.dist)
       {
    	   System.out.print(i+" ");
       }
	}
	

}
