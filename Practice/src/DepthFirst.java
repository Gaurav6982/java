import java.util.Iterator;
import java.util.LinkedList;

class DepthFirst{
	int V;
	private LinkedList<Integer> adj[];
	DepthFirst(int n) {
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
	void dfsutil(int v,boolean[] visited)
	{
		visited[v]=true;
		System.out.println(v);
		
		Iterator<Integer> i=adj[v].iterator();
		while(i.hasNext())
		{
			int el=i.next();
			if(!visited[el])
			{
				visited[el]=true;
				dfsutil(el,visited);
			}
		}
		
	}
	void dfs(int v)
	{
		boolean visited[]=new boolean[4];
		
		dfsutil(v,visited);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("hello World");
		DepthFirst g = new DepthFirst(4); 
		  
        g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
        g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
        
        g.dfs(1);
	}
	
}
