package multistage;
import java.util.*;
class Graph{
	int V,E,stages;
	int adjmat[][];
	Graph(int n) {
		adjmat=new int[n+1][n+1];
		V=n;
	}
	void addEdge(int u,int v,int weight)
	{
		adjmat[u][v]=weight;
	}
}
public class MultiStage {
	public static void printPath(int adjmat[][],int stages,int v)
	{
		int cost[]=new int[v+1];
		int d[]=new int[v+1];
		int path[]=new int[stages+1];
		for(int i=1;i<=v;i++)
		{
			if(adjmat[i][v]!=0)
			{
				d[i]=v;
				cost[i]=adjmat[i][v];
			}
		}
		cost[v]=0;
//		System.out.print("Cost : ");
//		for(int i=0;i<=v;i++)
//		{
//			System.out.print(cost[i]+" ");
//		}
//		System.out.println();
		for(int i=v-1;i>=1;i--)
		{
			int min=Integer.MAX_VALUE;
			for(int j=i+1;j<=v;j++)
			{
				if(adjmat[i][j]!=0 && adjmat[i][j]+cost[j]<min)
				{
					min=adjmat[i][j]+cost[j];
					d[i]=j;
				}
			}
			cost[i]=min;
		}
//		System.out.print("Cost : ");
//		for(int i=0;i<v;i++)
//		{
//			System.out.print(cost[i]+" ");
//		}
//		System.out.println();
//		System.out.print("d : ");
//		for(int i=0;i<v;i++)
//		{
//			System.out.print(d[i]+" ");
//		}
		path[1]=1;path[stages]=v;
//		System.out.println();
		System.out.print("1 ");
		for(int i=2;i<stages;i++)
		{
			path[i]=d[path[i-1]];
			System.out.print(path[i]+" ");
		}
		System.out.print(v);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Graph g=new Graph(8);
		System.out.println("Enter Number of Edges :");
		int e=sc.nextInt();
		
		System.out.println("Enter Number of Stages : ");
		int no_of_stage=sc.nextInt();
		g.stages=no_of_stage;
		System.out.println("Enter vertex and edge weights as(from to weight): ");
		
		g.E=e;
		for(int i=0;i<e;i++)
		{
			int u,v,weight;
			u=sc.nextInt();
			v=sc.nextInt();
			weight=sc.nextInt();
			g.addEdge(u, v, weight);
		}
		
		printPath(g.adjmat,g.stages,g.V);
		sc.close();
	}

}
//13
//4
//1 2 2
//1 3 1
//1 4 3
//2 5 2
//2 6 3
//3 5 6
//3 6 7
//4 5 6
//4 6 8
//4 7 9
//5 8 6
//6 8 4
//7 8 5
