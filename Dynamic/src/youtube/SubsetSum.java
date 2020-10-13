package youtube;

public class SubsetSum {
	public static boolean recSubsetSum(int arr[],int n,int sum)
	{
		if(sum==0)
			return true;
		if(n==0 && sum>0)
			return false;
		if(arr[n-1]<=sum)
		{
			return recSubsetSum(arr,n-1,sum)||recSubsetSum(arr,n-1,sum-arr[n-1]);
		}
		return recSubsetSum(arr,n-1,sum);
	}
	public static boolean SubsetSum(int arr[],int n,int sum)
	{
		boolean dp[][]=new boolean[n+1][sum+1];
		for(int i=0;i<n+1;i++)
		{
			dp[0][i]=false;
		}
		for(int i=0;i<n+1;i++)
		{
			dp[i][0]=true;
		}
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
		return dp[n][sum];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {2,3,7,8,10};
		int sum=11;
		System.out.println(recSubsetSum(arr,arr.length,sum));
		System.out.println(SubsetSum(arr,arr.length,sum));
	}

}
