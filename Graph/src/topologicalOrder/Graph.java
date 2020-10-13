package topologicalOrder;
import java.util.*;
public class Graph {
	private int V;
	private ArrayList<ArrayList<Integer>> adj;
	Graph(int v){
		V=v;
		adj=new ArrayList<ArrayList<Integer>>(v);
		for(int i=0;i<v;i++)
		{
			adj.add(new ArrayList<Integer>());
		}
	}
	void addEdge(int u,int v)
	{
		adj.get(u).add(v);
	}
	void TopologicalUtil(int i,boolean visited[],Stack<Integer> st)
	{
		visited[i]=true;
		
		Iterator<Integer> it=adj.get(i).iterator();
		while(it.hasNext())
		{
			int n=it.next();
			if(!visited[n])
			{
				TopologicalUtil(n,visited,st);
			}
		}
		st.push(i);
	}
	void topologicalOrder() {
		boolean visited[]=new boolean[V];
//		Arrays.fill(visited,false);
		Stack<Integer> st=new Stack<>();
		
		for(int i=0;i<V;i++)
		{
			if(!visited[i])
			{
				TopologicalUtil(i,visited,st);
			}
		}
		
		while(!st.empty())
		{
			System.out.print(st.pop()+" ");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Graph g = new Graph(6);  
	        g.addEdge(5, 2);  
	        g.addEdge(5, 0);  
	        g.addEdge(4, 0);  
	        g.addEdge(4, 1);  
	        g.addEdge(2, 3);  
	        g.addEdge(3, 1);  
	    
	        System.out.println("Following is a Topological " +  
	                           "sort of the given graph");  
	        g.topologicalOrder();  
	}

}
