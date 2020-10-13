package try1;
import java.util.Scanner;
public class TileFilling {
	public static int count(int n)
	{
		int a=1,b=2,c=3;
		if(n==1 || n==2)
			return n;
		for(int i=2;i<n;i++)
		{
			c=a+b;
			a=b;
			b=c;
		}
		
		return b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(count(n));
		sc.close();
	}

}
