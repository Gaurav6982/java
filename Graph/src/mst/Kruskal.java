package mst;
import java.util.*;
class Edge implements Comparable<Edge>{
	int src;
	int dest;
	int weight;
	
	// @Override
	public int compareTo(Edge compare)
	{
		return this.weight-compare.weight;
	}
}
public class Kruskal {
	public static int find(int v,int parent[])
	{
		if(parent[v]==v) return v;
		return find(parent[v],parent);
	}
	public static void kruskals(Edge[] input,int n,int e)
	{
		Edge output[]=new Edge[n-1];
		Arrays.sort(input);
		int parent[]=new int[n];
		for(int j=0;j<n;j++)
			parent[j]=j;
		int count=0;
		int i=0;
		while(count!=n-1)
		{
			Edge edge=input[i];
			
			int srcParent=find(edge.src,parent);
			int srcDest=find(edge.dest,parent);
			if(srcParent!=srcDest)
			{
				output[count]=edge;
				count++;
				parent[srcParent]=srcDest;
			}
			i++;
		}
		for(int j=0;j<n-1;j++)
		{
			System.out.println(output[j].src+" "+output[j].dest+" "+output[j].weight);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Edge edges[]=new Edge[e];
		for(int i=0;i<e;i++)
		{
			edges[i]=new Edge();
			edges[i].src=sc.nextInt();
			edges[i].dest=sc.nextInt();
			edges[i].weight=sc.nextInt();
		}
		kruskals(edges,v,e);
		
		sc.close();
	}

}
//6 11
//1 3 1
//0 2 4
//0 3 3
//0 1 2
//2 3 6
//4 5 5
//3 5 7
//2 1 8
//3 4 11
//2 4 9
//2 5 10

//output
//1 3 1
//0 2 4
//0 3 3
//4 5 5
//3 5 7
