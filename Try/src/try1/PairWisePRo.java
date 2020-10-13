package try1;
import java.util.*;
public class PairWisePRo {
	public static long MaxPair(long arr[])
	{
		long first_max=0;
		long sec_max=0;
		int index=0;
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>first_max)
			{
				first_max=arr[i];
				index=i;
			}
		}
		for(int i=0;i<arr.length;i++)
		{
			if(i!=index && arr[i]>sec_max)
			{
				sec_max=arr[i];
			}
		}
		
		return first_max*sec_max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		long arr[]=new long[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextLong();
		}
		System.out.println(MaxPair(arr));
		sc.close();
	}

}
