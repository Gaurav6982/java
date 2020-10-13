package youtube;
import java.util.Scanner;
public class MinNumCoins {

	public static int find(int arr[],int n,int sum)
	{
		int dp[][]=new int[n+1][sum+1];
		for(int i=0;i<n;i++)
			dp[i][0]=0;
		for(int i=1;i<sum+1;i++)
			dp[0][i]=Integer.MAX_VALUE-1;
		for(int i=1;i<sum+1;i++)
		{
			if(i%arr[0]==0)
				dp[1][i]=i/arr[0];
			else
				dp[1][i]=Integer.MAX_VALUE-1;
		}
//			dp[1][i]=0;		
		for(int i=2;i<n+1;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(j>=arr[i-1])
					dp[i][j]=Math.min(dp[i][j-arr[i-1]]+1,dp[i-1][j]);
				else
					dp[i][j]=dp[i-1][j];		
			}
		}
		if(dp[n][sum]!=Integer.MAX_VALUE-1)
	        return dp[n][sum];
	        else
	        return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int sum=sc.nextInt();
		int arr[]=new int[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
		}
		
		System.out.println(find(arr,n,sum));
		sc.close();
	}

}
