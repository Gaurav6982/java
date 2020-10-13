package try1;
import java.util.*;
public class Even {
	public static long factorial(long n)
	{
		if(n==0 || n==1)
			return 1;
		return n*factorial(n-1);
	}
	public static long fact(int i,long k) {
		long permutations=0;
		if(i==0)
			return 1;
		long factorial=factorial(i);
		permutations=k/factorial;
		return permutations;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
			int lval=sc.nextInt();
			int rval=sc.nextInt();
			int total=rval-lval+1;
			int num_of_odds=total/2;
			int num_of_evens=total/2;
			long k=sc.nextLong();
			long factorial=factorial(k);
			if(total%2!=0)
			{
				if(lval%2==0)
				{
					num_of_evens++;
				}
				else
				{
					num_of_odds++;
				}
			}
//			System.out.println(factorial);

//			System.out.println("odds: "+num_of_odds+"\nevens: "+num_of_evens);
			long ans=0;
			long evens=0;
			long odds=0;
			for(int i=0;i<=k;i+=2)
			{
				evens=k-i;
				odds=i;
//				System.out.println("multiply:"+fact(i,factorial));

				ans+=fact(i,factorial)*Math.pow(num_of_evens,evens)*Math.pow(num_of_odds,odds);
			}
			ans=ans%(long)(Math.pow(10,9)+7);
			System.out.println(ans);
		
		sc.close();
	}

}
