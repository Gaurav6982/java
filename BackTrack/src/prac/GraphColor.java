package prac;
import java.util.*;
public class GraphColor {
	private static  int V;
	private static LinkedList<Integer>  adj[];
	void graph() {
		adj=new LinkedList[V];
		for(int i=0;i<V;i++)
		{
			adj[i]=new LinkedList<Integer>();
		}
	}
	void addEdge(int u,int v)
	{
		adj[u].add(v);
		adj[v].add(u);
	}
//	public static boolean isSafe(int ans[],int i,int k)
//	{
//		LinkedList<Integer> temp=adj[i];
//		Iterator<Integer> it=temp.listIterator();
//		while(it.hasNext())
//		{
//			int n=it.next();
//			if(ans[n]==k)
//				return false;
//		}
//		return true;
//	}
	public static boolean isSafe(int m,int ans[])
	{
		for(int i=0;i<V;i++)
		{
			LinkedList<Integer> temp=adj[i];
			Iterator<Integer> it=temp.listIterator();
			while(it.hasNext())
			{
				int n=it.next();
				if(ans[n]==ans[i])
					return false;
			}
		}
		return true;
	}
	public static boolean graphColor(int m,int ans[],int i) {
		if(i==V)
		{
			if(isSafe(m,ans))
			{
				for(int j=0;j<V;j++)
				{
					System.out.print(ans[j]+1+" ");
//					if(ans[j]==0)
//						System.out.print("R ");
//					else if(ans[j]==1)
//						System.out.print("G ");
//					else if(ans[j]==2)
//						System.out.print("B ");
////					else if(ans[j]==3)
////						System.out.print("Y ");
//					else
//						System.out.print("-1 ");
	
				}
				System.out.println();
				return false;
			}
			return false;
		}
//		for(int j=i;j<V;j++)
//		{
			for(int k=0;k<m;k++)
			{
				
					ans[i]=k;
					if(graphColor(m,ans,i+1))
					{
						return true;
					}
					ans[i]=-1;
			}
//		}
		return false;
	}
	public static void main(String args[])
	{
		V=5;
		int m=5;
		GraphColor g=new GraphColor();
		g.graph();
		g.addEdge(0, 1); 
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 4);  
        g.addEdge(3, 4);
        int ans[]=new int[V];
        Arrays.fill(ans, -1);
        ans[0]=0;
		if(!graphColor(m,ans,1))
			System.out.println("Not Possible!");
	}
}
