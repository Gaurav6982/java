package try1;
import java.io.*;
import java.util.*;
class Edge implements Comparable<Edge>{
    
    point src;
    point dest;
    int weight;

    public int compareTo(Edge e){
        return this.weight-e.weight;
    }
}
class point{
    int num;
    int coordinates[];
}
class subset 
    { 
        int parent, rank; 
    };
public class DDIMMST {
     
    static int find(subset subsets[], int i) 
    { 
        // find root and make root as parent of i (path compression) 
        if (subsets[i].parent != i) 
            subsets[i].parent = find(subsets, subsets[i].parent); 
  
        return subsets[i].parent; 
    } 
    static void Union(subset subsets[], int x, int y) 
    { 
        int xroot = find(subsets, x); 
        int yroot = find(subsets, y); 
  
        // Attach smaller rank tree under root of high rank tree 
        // (Union by Rank) 
        if (subsets[xroot].rank < subsets[yroot].rank) 
            subsets[xroot].parent = yroot; 
        else if (subsets[xroot].rank > subsets[yroot].rank) 
            subsets[yroot].parent = xroot; 
  
        // If ranks are same, then make one as root and increment 
        // its rank by one 
        else
        { 
            subsets[yroot].parent = xroot; 
            subsets[xroot].rank++; 
        } 
    } 
    // public static int find(int v,int parent[])
	// {
	// 	if(parent[v]==v) return v;
	// 	return find(parent[v],parent);
    // }
    static int v,e;
	public static void kruskals(Edge[] edge)
	{
        Edge result[] = new Edge[v]; 
		for (int i=0; i<v; ++i) 
            result[i] = new Edge(); 
        subset subsets[] = new subset[v]; 
        for(int j=0; j<v; ++j) 
            subsets[j]=new subset(); 
        
            
            for (int a = 0; a < v; ++a) 
            { 
                subsets[a].parent = a; 
                subsets[a].rank = 0; 
            } 
      
            int i = 0; 
            int ea=0;
            while (ea < v - 1) 
            { 
                
                Edge next_edge = new Edge(); 
                next_edge = edge[i++]; 
      
                int x = find(subsets, next_edge.src.num); 
                int y = find(subsets, next_edge.dest.num); 
      
               
                if (x != y) 
                { 
                    result[ea++] = next_edge; 
                    Union(subsets, x, y); 
                } 
                // Else discard the next_edge 
            } 
        int ans=0;
		for(int j=0;j<v-1;j++)
		{
            ans+=Math.abs(result[j].weight);
			// System.out.println(output[j].src+" "+output[j].dest+" "+output[j].weight);
        }
        System.out.println(ans);
	}
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String n_d=br.readLine();
        String nd[]=n_d.trim().split("\\s+");
        int n=Integer.parseInt(nd[0]);
        int d=Integer.parseInt(nd[1]);
        point[] points=new point[n];
        for (int i = 0; i < n; i++) {
            points[i]=new point();
            points[i].num=i;
            points[i].coordinates=new int[d];
            String line=br.readLine();
            String[] params=line.trim().split("\\s+");
            for (int j = 0; j < d; j++) {
                points[i].coordinates[j]=Integer.parseInt(params[j]);
            }
        }
        v=n;
        e=((n-1)*(n))/2;
        Edge[] edges=new Edge[e];

        int k=0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                edges[k]=new Edge();
                edges[k].src=points[i];
                edges[k].dest=points[j];
                int weight=0;
                for (int j2 = 0; j2 < d; j2++) {
                    weight+=Math.abs(points[i].coordinates[j2]-points[j].coordinates[j2]);
                }
                edges[k].weight=0-weight;
                k++;
            }
        }
        Arrays.sort(edges);
        // System.out.println(k);
        // for (int i = 0; i < k; i++) {
        //     for (int j = 0; j < d; j++) {
        //         System.out.print(edges[i].src.coordinates[j]+" ");
        //     }
        //     System.out.println();
        //     for (int j = 0; j < d; j++) {
        //         System.out.print(edges[i].dest.coordinates[j]+" ");
        //     }
        //     System.out.println();
        //     System.out.println(edges[i].weight+" ");
        // }
        kruskals(edges); //edges array,vertices , edges
        br.close();
    }
}
