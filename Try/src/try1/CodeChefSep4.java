package try1;
import java.util.*;
public class CodeChefSep4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int sum=0;
			if(n%2==0)
				sum=(n/2)*(n+1);
			else
				sum=((n+1)/2)*n;
			if(sum%2!=0)
			{
				System.out.println(0);
			}
			else
			{
				sum=sum/2;
				int temp=0;
				double num=Math.sqrt((8*sum+1));
				double check=(num-1)/2;
				int last=(int)check;
//				System.out.println(check);
				if(last%2==0)
				{
					temp=(last/2)*(last+1);
				}
				else
				{
					temp=last*((last+1)/2);
				}
				int diff=sum-temp;
//				System.out.println(diff);
				if(diff==0)
				{
					int till=last-1;
					if(till%2==0)
					{
						sum=(till/2)*(till+1);
					}
					else
					{
						sum=till*((till+1)/2);
					}
					if(n-last==1)
					{
						System.out.println(sum+1);
					}
					else
					{
						System.out.println(sum);
					}
				}
				else
				System.out.println(Math.min(diff,n-last));
			}
		}
		sc.close();
	}

}
