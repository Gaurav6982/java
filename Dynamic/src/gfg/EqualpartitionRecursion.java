package gfg;
import java.util.*;
public class EqualpartitionRecursion {
	public static boolean check(int arr[],int n,int sum)
	{
		if(sum==0)
			return true;
		if(n==0)
			return false;
		if(arr[n-1]>sum)
			check(arr,n-1,sum);
		return check(arr,n-1,sum)||check(arr,n-1,sum-arr[n-1]);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		int sum=0;
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
			sum+=arr[i];
		}
			if(sum%2!=0)
				System.out.println(false);
			else
		System.out.println(check(arr,n,sum/2));
			System.out.println(sum/2);
		sc.close();
	}

}
