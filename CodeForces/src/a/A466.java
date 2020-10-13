package a;
import java.util.Scanner;
public class A466 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int a=sc.nextInt();
		int b=sc.nextInt();
		int ans=0;
		if(n%m==0)
		{
			if(n*a<(n/m)*b)
				ans=n*a;
			else
				ans=(n/m)*b;
		}
		else
		{
			if(n<m)
			{
				if(n*a<b)
					ans=n*a;
				else
					ans=b;
			}
			else
			{
				if(n*a<(n/m)*b)
					ans=n*a;
				else
					ans=(n/m)*b;
				n=n%m;
				if(n*a<b)
					ans+=n*a;
				else
					ans+=b;
			}
		}
		System.out.println(ans);
		sc.close();
	}

}

//10 3 5 1
//101 110 1 100