package youtube;

public class CountSubsetSum {
	public static int recSubsetSum(int arr[],int n,int sum)
	{
		if(sum==0)
			return 1;
		if(n==0 && sum>0)
			return 0;
		if(arr[n-1]<=sum)
		{
			return recSubsetSum(arr,n-1,sum)+recSubsetSum(arr,n-1,sum-arr[n-1]);
		}
		return recSubsetSum(arr,n-1,sum);
	}
	public static int SubsetSum(int arr[],int n,int sum)
	{
		int dp[][]=new int[n+1][sum+1];
		for(int i=0;i<n+1;i++)
		{
			dp[0][i]=0;
		}
		for(int i=0;i<n+1;i++)
		{
			dp[i][0]=1;
		}
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<sum+1;j++)
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
		int arr[]= {1,2,3,4};
		int sum=5;
		System.out.println(recSubsetSum(arr,arr.length,sum));
		System.out.println(SubsetSum(arr,arr.length,sum));
	}

}
