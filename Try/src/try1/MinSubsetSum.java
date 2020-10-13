package try1;
import java.util.*;
public class MinSubsetSum {
	public static boolean[] subsetSum(int arr[],int n,int sum)
	{
		boolean dp[][]=new boolean[n+1][sum+1];
		for(int i=0;i<n+1;i++)
			dp[i][0]=true;
		for(int i=1;i<sum+1;i++)
			dp[0][i]=false;
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(arr[i-1]<=j)
				{
					dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[n];
	}
	public static int minSubSumDiff(int arr[],int n,int sum)
	{
		int min=Integer.MAX_VALUE;
		boolean[] lastRow=subsetSum(arr,n,sum);
		int new_min=0;
		for(int i=0;i<lastRow.length/2+1;i++)
		{
			if(lastRow[i])
			{
				new_min=Math.min(min,Math.abs(sum-2*i));
				if(new_min != min)
				{
					min=new_min;
					System.out.println(i);
				}
				
			}
		}
//		int dp[][]=new int[n+1][sum+1];
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		int sum=0;
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}
		System.out.println(minSubSumDiff(arr,n,sum));
		sc.close();
	}

}
