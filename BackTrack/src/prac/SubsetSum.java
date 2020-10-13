package prac;
import java.util.*;
public class SubsetSum {
//	public static boolean isSafe(int arr[],int sum,int curr,int total,int i)
//	{
//		if(curr+arr[i]<=sum && curr+total>sum)
//			return true;
//		return false;
//	}
	public static boolean isSafe(int ans[],int arr[],int sum,int total,int curr,int i)
	{
		if(curr+total<sum)
			return false;
		if(curr+arr[i]>sum)
			return false;
		return true;
	}
	private static int node_created=0;
	public static boolean solve(int arr[],int sum,int curr,int total,int ans[],int j) {
		node_created++;
		if(curr==sum)
		{
				for(int i=0;i<ans.length;i++)
				{
					if(ans[i]>0)
					{
						System.out.print(arr[i]+" ");	
					}
				}
				System.out.println();
			return false
					;
		}
		for(int i=j;i<arr.length;i++)
		{
			if(isSafe(ans,arr,sum,total,curr,i))
			{
				curr+=arr[i];
				total-=arr[i];
				ans[i]=1;
				if(solve(arr,sum,curr,total,ans,i+1)) return true;
				curr-=arr[i];
				ans[i]-=1;
			}
		}
		
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int sum=sc.nextInt();
		int arr[]=new int[n];
		int total=0;
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
			total+=arr[i];
		}
			
		
		int ans[]=new int[n];
		if(!solve(arr,sum,0,total,ans,0))
			System.out.println("Not Possible!");
		System.out.println("Nodes Created:  "+node_created);
		sc.close();
	}

}
//7 35
//10 7 5 18 12 20 15

//6 30
//5 10 12 13 15 20
