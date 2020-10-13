package try1;

import java.util.Scanner;

public class Codechef7 {

	public static boolean[] subsetSum(long arr[],long n,long sum)
	{
		boolean dp[][]=new boolean[(int)n+1][(int)sum+1];
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
					dp[i][j]=dp[i-1][j]||dp[i-1][j-(int)arr[i-1]];
				}
				else
				{
					dp[i][j]=dp[i-1][j];
				}
			}
		}
		return dp[(int)n];
	}
	public static long[] minSubSumDiff(long arr[],long n,long sum)
	{
		long min=Long.MAX_VALUE;
		boolean[] lastRow=subsetSum(arr,n,sum);
		long new_min=0;
		int index=0;
		for(int i=0;i<lastRow.length/2+1;i++)
		{
			if(lastRow[i])
			{
				new_min=Math.min(min,Math.abs(sum-2*i));
				if(new_min != min)
				{
					min=new_min;
					index=i;
				}
				
			}
		}
//		int dp[][]=new int[n+1][sum+1];
		long ans[]=new long[2];
		ans[0]=min;
		ans[1]=index;
		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int k=sc.nextInt();
		int t=sc.nextInt();
		while(t-->0)
		{
			long n=sc.nextLong();
			long arr[]=new long[(int)n];
			long sum=0;
			int heaps[]=new int[(int)n];
			for(int i=0;i<n;i++)
			{
				heaps[i]=1;
				arr[i]=(long)Math.pow(i+1,k);
				sum+=arr[i];
			}
			long ans[]=minSubSumDiff(arr,n,sum);
			System.out.println(ans[0]);
			long check=0;
			int i;
			for( i=0;i<n;i++)
			{
				check=(long)Math.pow(i+1,k);
				if(check>ans[1])
					break;
			}
			
			for(int j=i-1;j>=0;j--)
			{
				if(arr[j]<=0)
					break;
				if(arr[j]<=ans[1])
				{
					ans[1]-=arr[j];
					heaps[j]=0;
				}
			}
			for(i=0;i<n;i++)
			{
				System.out.print(heaps[i]);
			}
			System.out.println();
			
			
		}
		sc.close();
	}
}
