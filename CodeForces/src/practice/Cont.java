package practice;

import java.util.Scanner;

public class Cont {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			long x,y,k;
			x=sc.nextLong();
			y=sc.nextLong();
			k=sc.nextLong();
			
			long required=y*k+k;
//			System.out.println(required);
			long total=1;
			long ans=0;
			long turn=0;
			while(total<required)
			{
				turn++;
				ans+=total;
				total*=x;
				
			}
			long nth=(long)Math.pow(x,turn-1);
//			ans=(long)Math.pow(x,turn-1);
//			System.out.println(" as"+nth);
			total=total/x;
			ans-=total;
//			System.out.println(ans);
			long profit=x-1;
			ans+=(required-nth)*profit;
//			System.out.println(ans);
			System.out.println(ans+k);
		}
		sc.close();
	}

}
