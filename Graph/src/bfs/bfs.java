package bfs;
import java.util.*;
public class bfs {
	 private LinkedList<Integer> adj[];
	private int V;
	bfs(int v) {
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
	void BFS(int s) {
		Queue<Integer> q=new LinkedList<>();
		q.add(s);
		boolean visited[]=new boolean[V];
		visited[s]=true;
		
		while(q.size()!=0)
		{
			s=q.poll();
			System.out.print(s+" ");
			Iterator<Integer> i=adj[s].iterator();
			while(i.hasNext())
			{
				int n=i.next();
				if(visited[n]!=true)
				{
					visited[n]=true;
					q.add(n);
				}
			}
			
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bfs g = new bfs(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  
        System.out.println("Following is Breadth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        g.BFS(2); 
	}

}
