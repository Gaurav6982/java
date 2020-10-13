package try1;
import java.util.Scanner;
import java.lang.Math;
public class UglyNumber {
	public static int findUgly(int n)
	{
		int i2=0,i3=0,i5=0;
		int no_2=2;
		int no_3=3;
		int no_5=5;
		int ugly[]=new int[n];
		ugly[0]=1;
		int ugly_no=1;
		for(int i=1;i<n;i++)
		{
			 ugly_no=Math.min(no_2,Math.min(no_3,no_5));
			
			ugly[i]=ugly_no;
			if(ugly_no==no_2)
			{
				i2++;
				no_2=ugly[i2]*2;
			}
			if(ugly_no==no_3)
			{
				i3++;
				no_3=ugly[i3]*3;
			}
			if(ugly_no==no_5)
			{
				i5++;
				no_5=ugly[i5]*5;
			}
		}
		return ugly_no;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(findUgly(n));
		sc.close();
	}

}
