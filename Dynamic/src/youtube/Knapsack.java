package youtube;

public class Knapsack {
	public static int recKnapsack(int weight[],int values[],int w,int n) {
		if(w==0 || n==0)
			return 0;
		if(weight[n-1]<=w)
		return Math.max(values[n-1]+recKnapsack(weight,values,w-weight[n-1],n-1),recKnapsack(weight,values,w,n-1));
		return recKnapsack(weight,values,w,n-1);
	}
	public static int knapsack(int weight[],int values[],int w,int n) {
		int[][] dp=new int[n+1][w+1];
		for(int i=0;i<n+1;i++)
		{
			dp[i][0]=0;
		}
		for(int i=0;i<w+1;i++)
		{
			dp[0][i]=0;
		}
		for(int i=1;i<n+1;i++)
		{
			for(int j=1;j<w+1;j++)
			{
				if(weight[i-1]<=j)
				{
					dp[i][j]=Math.max(dp[i-1][j],values[i-1]+dp[i-1][j-weight[i-1]]);
				}
				else
					dp[i][j]=dp[i-1][j];
			}
		}
		return dp[n][w];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weight[]= {1,3,6,9};
		int values[]= {5,2,1,4};
		int w=10;
		System.out.println(recKnapsack(weight,values,w,4));
		System.out.println(knapsack(weight,values,w,4));
	}

}
