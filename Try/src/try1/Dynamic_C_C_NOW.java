package try1;
import java.util.Scanner;

//Dynamic Coin Change To find Number of Ways to make the Sum
public class Dynamic_C_C_NOW {
	//BY RECURSION
	public static int ways(int[] coins,int n,int sum) {
		if(sum==0)
			return 1;
		if(sum<0)
			return 0;
		if(n<=0 && sum>=1)
			return 0;
		
		return ways(coins,n-1,sum)+ways(coins,n,sum-coins[n-1]);
	}
	//by Dynamic
	public static int dynamic(int coins[],int n,int sum)
	{
		int[][] dp=new int[n][sum+1];
		for(int i=0;i<n;i++)
			dp[i][0]=1;
		for(int i=0;i<sum+1;i++)
		{
			if(i%coins[0]==0)
				dp[0][i]=1;
		}
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(j<coins[i])
					dp[i][j]=dp[i-1][j];
				else
					dp[i][j]=dp[i-1][j]+dp[i][j-coins[i]];
			}
		}
		
		return dp[n-1][sum];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] coins=new int[n];
		for(int i=0;i<n;i++)
			coins[i]=sc.nextInt();
		int sum=sc.nextInt();
		System.out.println(dynamic(coins,n,sum));
		sc.close();
	}

}
