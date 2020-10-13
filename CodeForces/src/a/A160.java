package a;
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
public class A160 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int[] arr=new int[n];
		int total=0;
		for(int i=0;i<n;i++)
		{
			arr[i]=sc.nextInt();
			total+=arr[i];
		}
		Arrays.sort(arr);
		sc.close();
		
		int curr_sum=0;
		int ans=0;
		for(int i=n-1;i>=0;i--)
		{
			if(curr_sum>total)
				break;
			curr_sum+=arr[i];
			total-=arr[i];
			ans++;
		}
		System.out.println(ans);
	}

}
