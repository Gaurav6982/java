package try1;
import java.util.Arrays;
import java.util.Scanner;
public class CoinChange {
	public static int ways=0;
	public static boolean isSafe(int curr,int sum,int coin)
	{
		if(curr+coin>sum)
			return false;
		 
		return true;
	}
	public static boolean change(int[] coins,int i,int sum,int curr,int ans[],int k)
	{
		if(curr==sum)
		{
			ways++;
			for(int l=0;l<ans.length;l++)
			{
				if(ans[l]!=-1)
					System.out.print(ans[l]+" ");
			}
			System.out.println();
			return false;
		}
		for(int j=0;j<coins.length;j++)
		{
			if(curr+coins[j]<=sum)
			{
				curr+=coins[j];
				ans[k]=coins[j];
				k++;
				change(coins,j+1,sum,curr,ans,k);
				curr-=coins[j];
				k--;
				ans[k]=-1;
				
			}
			
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] coins=new int[n];
//		int min=Integer.MAX_VALUE;
//		int max=Integer.MIN_VALUE;
		for(int i=0;i<n;i++)
		{
			coins[i]=sc.nextInt();
//			if(coins[i]<min)
//				min=coins[i];
//			if(coins[i]>max)
//				max=coins[i];
		}
		int[] ans=new int[500];
		Arrays.fill(ans,-1);
		int sum=sc.nextInt();
		if(change(coins,0,sum,0,ans,0))
			System.out.println(ways);
		sc.close();
	}

}
