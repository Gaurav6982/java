package gfg;
import java.util.*;
public class CountSubsetSum {
	public static int find(int arr[],int n,int sum)
	{
		if(sum==0)
			return 1;
		if(n==0)
			return 0;
		if(arr[n-1]>sum)
			return find(arr,n-1,sum);
		return find(arr,n-1,sum)+find(arr,n-1,sum-arr[n-1]);
	}
	public static int findByDP(int[] arr,int n,int sum,int dp[][])
	{
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=sum;j++)
			{
				if(arr[i-1]<=j)
				{
					dp[i][j]=dp[i-1][j]+dp[i-1][j-arr[i-1]];
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n][sum];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		int sum=sc.nextInt();
		System.out.println(find(arr,n,sum));
		int[][] dp=new int[n+1][sum+1];
		for(int i=0;i<=n;i++)
			dp[i][0]=1;
		for(int i=1;i<=sum;i++)
			dp[0][i]=0;
		System.out.println(findByDP(arr,n,sum,dp));
		sc.close();
	}

}

//6
//2 3 5 6 8 10
//10