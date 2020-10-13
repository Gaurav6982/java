package youtube;
import java.util.Scanner;
public class LCsubstring {
	// static int count=0;
	static char[] X,Y;
	public static int find(int n,int m,int count)
	{
		if(n==0 || m==0)
			return count;
		if(X[n-1]==Y[m-1])
			count=find(n-1,m-1,count+1);
		else
		count=Math.max(count, Math.max(find(n-1,m,0),find(n,m-1,0)));
		return count;
	}
	public static int find_dp(int n,int m)
	{
		int dp[][]=new int[n+1][m+1];
		int ans=0;
		for (int i = 1; i < n+1; i++) {
			for (int j = 1; j < m+1; j++) {
				if(X[i-1]==Y[j-1])
				{
					dp[i][j]=1+dp[i-1][j-1];
					ans=Math.max(ans, dp[i][j]);
				}
				else
				dp[i][j]=0;
			}
		}

		return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		X=sc.next().toCharArray();
		Y=sc.next().toCharArray();
		System.out.println(find(X.length,Y.length,0));
		System.out.println(find_dp(X.length,Y.length));
		sc.close();
	}

}
