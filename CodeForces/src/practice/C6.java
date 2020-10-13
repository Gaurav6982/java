package practice;
import java.util.*;
public class C6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		int temp=n;
		int i=0;
		while(n-->0)
		{
			arr[i++]=sc.nextInt();
		}
		int left=0;
		int right=temp-1;
		int sum_left=0;
		int sum_right=0;
		while(left<=right)
		{
			if(sum_left<=sum_right)
			{
				sum_left+=arr[left++];
			}
			else
			{
				sum_right+=arr[right--];
			}
			
		}
		System.out.println(left+" "+(temp-left));
		sc.close();
	}

}
