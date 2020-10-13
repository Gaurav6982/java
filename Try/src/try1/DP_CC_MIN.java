package try1;
import java.util.Arrays;
import java.util.Scanner;
//TO FIND THE MIN NUMBER OF COINS RERQUIRED TO MAKE THE SUM
public class DP_CC_MIN {
	// BY RECURSION
	public static int mincoins(int coins[],int n,int sum) {
		if(sum==0)
			return 0;
		int res=Integer.MAX_VALUE;
		for(int i=0;i<n;i++)
		{
			if(coins[i]<=sum)
			{
				int inter=mincoins(coins,n,sum-coins[i]);
				
				if(inter!=Integer.MAX_VALUE && inter+1<res)
					res=inter+1;
			}
		}
		return res;
		
	}
	//BY DP
	public static int dynamic(int coins[],int n,int sum)
	{
		//A 2d Matrix to Store all the Results
		int[][] dp=new int[n][sum+1];
		//to initialise 1st column
		for(int i=0;i<n;i++)
		{
			dp[i][0]=0;
		}
		//to initialise 1st row
		for(int i=0;i<sum+1;i++)
		{
			if(i%coins[0]==0)
			dp[0][i]=i/coins[0];
		}
		for(int i=1;i<n;i++)
		{
			for(int j=1;j<sum+1;j++)
			{
				if(coins[i]>j)
					dp[i][j]=dp[i-1][j];
				else
					dp[i][j]=Math.min(dp[i-1][j],1+dp[i][j-coins[i]]);
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
		Arrays.sort(coins);
		int sum=sc.nextInt();
		int temp=mincoins(coins,n,sum);
		System.out.println(temp!=0?temp:"Not Possible");
		sc.close();
	}

}
