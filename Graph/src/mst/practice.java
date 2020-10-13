package mst;
import java.util.*;

public class practice {
	public static int findParent(int v,int parent[])
	{
		if(parent[v]==v) return v;
		return findParent(parent[v],parent);
	}
	public static void kruskal(Edge[] input,int v,int e)
	{
		Edge output[]=new Edge[v-1];
		int parent[]=new int[v];
		for(int i=0;i<v;i++)
			parent[i]=i;
		int count=0;
		int i=0;
		while(count!=v-1)
		{
			Edge edge=input[i];
			int srcParent=findParent(edge.src,parent);
			int destParent=findParent(edge.dest,parent);
			if(srcParent!=destParent)
			{
				output[count++]=edge;
				parent[srcParent]=destParent;
			}
			i++;
		}
		for(int j=0;j<v-1;j++)
		{
			System.out.println(output[j].src+" "+output[j].dest+" "+output[j].weight);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		Edge input[]=new Edge[e];
		for(int i=0;i<e;i++)
		{
			input[i]=new Edge();
			input[i].src=sc.nextInt();
			input[i].dest=sc.nextInt();
			input[i].weight=sc.nextInt();
		}
		kruskal(input,v,e);
	}

}
