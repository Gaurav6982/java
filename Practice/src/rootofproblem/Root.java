package rootofproblem;
import java.util.*;
public class Root {
	public static boolean isSafe(int nodes[],int ans[]) {
		return false;
	}
	public static boolean findRoot(int nodes[],int ans[],int i)
	{
		if(i==ans.length-1)
		{
			if(isSafe(nodes,ans))
				return true;
		}
		for(int j=0;j<ans.length;j++)
		{
			ans[j]=i;
			if(findRoot(nodes,ans,i+1)) return true;
			ans[j]=0;
		}
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int nodes[]=new int[n+1];
			for(int i=1;i<n+1;i++)
			{
				nodes[i]=sc.nextInt();
			}
			int ans[]=new int[n];
			if(findRoot(nodes,ans,0))
				System.out.println(ans[0]);
		}
		sc.close();
	}

}
