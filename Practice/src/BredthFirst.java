import java.io.*;
//modified bfs to find that is there any path to a node 
import java.util.*;
class graph 
{	
	int V;
	protected LinkedList<Integer>[] adj;
	graph(int n) {
		 adj=new LinkedList[n];
		V=n;
		int i;
		for(i=0;i<n;i++)
		{
			adj[i]=new LinkedList<Integer>();
		}
		
	}
	void addEdge(int v,int e)
	{
		adj[v].add(e);
	}
	
	void search(int s,int end)
	{
		boolean[] visited=new boolean[V];
		
		LinkedList<Integer> queue=new LinkedList<>();
		
		
		visited[s]=true;
		queue.add(s);
		
		int flag=0;
		while(queue.size()!=0)
		{
			
			int ed=queue.poll();
//			System.out.println(ed);
			Iterator<Integer> i=adj[ed].iterator();
			while(i.hasNext())
			{
				Integer n=(Integer)i.next();
				if(visited[n]==false)
				{
					visited[n]=true;
					queue.add(n);
				}
				if(n==end)
				{
					flag=1;
					System.out.println("yes");
					break;
				}
			}
			if(flag==1)
				break;
			
		}
		if(flag==0)
			System.out.println("no");
	}
	void bfs(int s)
	{
		boolean[] visited=new boolean[V];
		
		LinkedList<Integer> queue=new LinkedList<>();
		visited[s]=true;
		queue.add(s);
		while(queue.size()!=0)
		{
			int ed=queue.poll();
			System.out.println(ed);
			Iterator<Integer> i=adj[ed].iterator();
			while(i.hasNext())
			{
				Integer n=(Integer)i.next();
				if(visited[n]==false)
				{
					visited[n]=true;
					queue.add(n);
				}
			}
		}
	}
	
	//list of depth
//	LinkedList<Integer> ar;
}
public class BredthFirst {
	
	public static void main(String[] args)
	{
//		System.out.println("hello World");
//		Scanner sc=new Scanner(System.in);
//		int n=sc.nextInt();
//		sc.close();
		graph g=new graph(7);
//		Graph g = new Graph(4); 
		  
		g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 3); 
        g.addEdge(1, 4); 
        g.addEdge(2, 5); 
        g.addEdge(2, 6);
        g.bfs(0);
//		g.search(3,1);
//        LinkedList<Integer> ar=new Linkedlist[h];
		
	}
}
