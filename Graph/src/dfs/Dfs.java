package dfs;

import java.util.LinkedList;
import java.util.*;

public class Dfs {
	private LinkedList<Integer> adj[];
	private int V;
	Dfs(int v) {
		V=v;
		adj = new LinkedList[v]; 
		for(int i=0;i<v;i++)
		{
			adj[i]=new LinkedList<>();
		}
	}
	void addEdge(int i,int j)
	{
		adj[i].add(j);
	}
	void DFS(int v) {
		boolean visited[]=new boolean[V];
	DFSUtil(v,visited);
	}
	void DFSUtil(int i,boolean visited[])
	{
		System.out.print(i+" ");
		visited[i]=true;
		Iterator<Integer> it=adj[i].iterator();
		while(it.hasNext())
		{
			int n=it.next();
			if(!visited[n])
			{
				DFSUtil(n,visited);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dfs g = new Dfs(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.DFS(2); 
	}

}
