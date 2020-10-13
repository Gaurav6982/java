package gfg;
import java.util.Scanner;
public class SubsetSumDivisibleByM {
	public static boolean find(int[] arr,int n,int m)
	{
		if(n>m)
			return true;
		boolean DP[]=new boolean[m];
		for(int i=0;i<n;i++)
		{
			boolean temp[]=new boolean[m];
			
			for(int j=0;j<m;j++)
			{
				if(DP[j])
				if(!DP[(j+arr[i])%m])
					temp[(j+arr[i])%m]=true;
			}
			for(int j=0;j<m;j++)
			{
				if(temp[j])
					DP[j]=true;
			}
			DP[arr[i]%m]=true;
		}
		return DP[0];
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		int m=sc.nextInt();
		System.out.println(find(arr,n,m));
		sc.close();
	}
}
//Test case
//4
//3 1 7 5
//6
//ans true;
