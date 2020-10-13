package gfg;
import java.util.*;
public class LargestDivisiblePairBrute {
	public static boolean isSafe(int el,ArrayList<Integer> ans,int n)
	{
		for(int en:ans)
		{
			if(en%el!=0)
			{
				if(el%en!=0)
					return false;
			}
		}
		return true;
	}
	public static boolean find(int arr[],int n,ArrayList<Integer> ans,int i)
	{
		if(i>n-1)
		{
			for(int en:ans)
				System.out.print(en+ " ");
			return false;
		}
		for(int k=i;k<n;k++)
		{
			if(isSafe(arr[k],ans,n))
			{
				ans.add(arr[k]);
				if(find(arr,n,ans,k+1)) return true;
				ans.remove(new Integer(arr[k]));
			}
		}
		
		return true;
	}
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		ArrayList<Integer> ans=new ArrayList<>();
		find(arr,n,ans,0);
//		System.out.println(ans.size());
		
//		System.out.println(count);
		sc.close();
	}
}
