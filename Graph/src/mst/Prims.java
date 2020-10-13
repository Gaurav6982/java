package mst;

import java.util.*;

import bfs.bfs;
import java.util.*;
public class Prims {
		int findMin(int V,boolean visited[],int weight[])
		{
			int minVertex=-1;
			for(int i=0;i<V;i++)
			{
				if(!visited[i] &&(minVertex==-1 || weight[i]<weight[minVertex]))
					minVertex=i;
			}
			return minVertex;
		}
		void prims(int adjmat[][]) {
			int V=adjmat.length;
			int parent[]=new int[V];
			int weight[]=new int[V];
			
			for(int i=0;i<V;i++)
			{
				parent[i]=-1;
				weight[i]=Integer.MAX_VALUE;
			}
			weight[0]=0;
			
			boolean visited[]=new boolean[V];
			
			for(int i=0;i<V;i++)
			{
				
				int minVertex=findMin(V,visited,weight);
				visited[minVertex]=true;
				for(int j=0;j<V;j++)
				{
					int temp=adjmat[minVertex][j];
					if(!visited[j] && temp!=0 && temp<weight[j])
					{
						weight[j]=temp;
						parent[j]=minVertex;
					}
				}
			}
			
			for(int i=1;i<V;i++)
			{
				if(i<parent[i])
				System.out.println(i+" "+parent[i]+" "+weight[i]);
				else
					System.out.println(parent[i]+" "+i+" "+weight[i]);
			}
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prims g = new Prims(); 
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
        int[][] adjmat=new int[v][v];
        for(int i=0;i<e;i++)
        {
        	int a=sc.nextInt();
        	int b=sc.nextInt();
        	adjmat[a][b]=sc.nextInt();
        }
        g.prims(adjmat);
	}

}

//5 7
//0 1 4
//0 2 9
//1 3 6
//1 2 2
//2 3 3
//2 4 9
//3 4 5

