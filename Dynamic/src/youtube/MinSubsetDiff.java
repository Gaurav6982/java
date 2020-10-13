package youtube;
import java.util.*;
public class MinSubsetDiff {
	public static boolean[] SubsetSum(int arr[],int n,int sum)
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
		return dp[n];
	}
	public static int minSubsetSum(int arr[],int n,int sum)
	{
		boolean s1[]=SubsetSum(arr,n,sum);
		ArrayList<Integer> vec=new ArrayList<>();
		for(int i=0;i<s1.length/2;i++)
		{
			if(s1[i]&& s1[sum-i])
			{
				vec.add(i);
			}
		}
		int min=Integer.MAX_VALUE;
		for(int i=0;i<vec.size();i++)
		{
			min=Math.min(min,sum-2*vec.get(i));
		}
		return min;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,2,7};
		int sum=0;
		for(int i=0;i<arr.length;i++)
		{
			sum+=arr[i];
		}
//		System.out.println(recSubsetSum(arr,arr.length,sum));
		System.out.println(minSubsetSum(arr,arr.length,sum));
	}

}
