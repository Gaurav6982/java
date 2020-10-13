package shortestPath;
import java.util.*;
public class Dijktra {
	static void find(int adjmat[][]) {
		int v=adjmat.length;
		boolean visited[]=new boolean[v];
		int dist[]=new int[v];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0]=0;
		
		for(int i=0;i<v;i++)
		{
			int minVertex=findMinVertex(dist,visited);
			visited[minVertex]=true;
			for(int j=0;j<v;j++)
			{
				if(!visited[j] && adjmat[minVertex][j]!=0 && dist[minVertex]!=Integer.MAX_VALUE)
				{
					int newDist=dist[minVertex]+adjmat[minVertex][j];
					if(newDist<dist[j])
					{
						dist[j]=newDist;
					}
				}
			}
		}
		for(int i=0;i<v;i++)
		{
			System.out.println(i+" "+dist[i]);
		}

	}
	static int findMinVertex(int dist[],boolean visited[]) {
		int v=dist.length;
		int min=-1;
		for(int i=0;i<v;i++)
		{
			if(!visited[i] &&(min==-1 || dist[i]<dist[min]))
			{
				min=i;
			}
		}
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		int adjmat[][]=new int[v][v];
		for(int i=0;i<e;i++)
		{
			int v1=sc.nextInt();
			int v2=sc.nextInt();
			int weight=sc.nextInt();
			adjmat[v1][v2]=weight;
			adjmat[v2][v1]=weight;
		}
		find(adjmat);
	}

}

//Test Case

//5 7
//0 1 4
//0 2 8
//1 3 5
//1 2 2
//2 3 5
//2 4 9
//3 4 4
//

//Source: Youtube Coding Blocks

