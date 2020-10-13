package try1;

// import java.util.ArrayList;
import java.util.Scanner;

public class DiceComb {
	public static int find(int arr[],int n,int sum)
	{
		int dp[]=new int[sum+1];
		dp[0]=1;
		for(int i=0;i<sum+1;i++)
		{
			for(int j=1;j<=6;j++)
			{
				if(j>=i)
					break;
				dp[i]+=dp[i-j];
			}
		}
			
		return dp[sum];
	}
	public static int rec(int arr[],int n,int sum)
	{
		if(sum==0)
		return 1;
		if(n==0)
		return 0;
		int ans=0;
		for(int i=1;i<=6;i++)
		{
			if(sum>=i)
			ans+=rec(arr,n-1,sum-i);
			else
			break;
		}
		return ans;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int arr[]=new int[6];
		for(int i=0;i<6;i++)
		{
			arr[i]=i+1;
		}
		int sum=sc.nextInt();
		System.out.println(find(arr,6,sum));
		System.out.println(rec(arr,6,sum));
		sc.close();
	}

}
