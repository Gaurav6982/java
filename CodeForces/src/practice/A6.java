package practice;
import java.util.*;
public class A6 {
	public static boolean checkForTri(int a,int b,int c)
	{
		int max=a>b?(a>c?a:c):(b>c?b:c);
		if(max==a && b+c>a || max==b &&a+c>b|| max==c &&a+b>c)
			return true;
		return false;
	}
	public static boolean checkForSeg(int a,int b,int c)
	{
		int max=a>b?(a>c?a:c):(b>c?b:c);
		if(max==a && b+c==a || max==b &&a+c==b|| max==c &&a+b==c)
			return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int a,b,c,d;
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		d=sc.nextInt();
		if(checkForTri(a,b,c) || checkForTri(a,b,d) || checkForTri(a,c,d) || checkForTri(b,c,d))
			System.out.println("TRIANGLE");
		else if(checkForSeg(a,b,c) || checkForSeg(a,b,d) || checkForSeg(a,c,d) || checkForSeg(b,c,d))
			System.out.println("SEGMENT");
		else
			System.out.println("IMPOSSIBLE");
		sc.close();
	}

}
