package practice;

import java.util.Scanner;

public class A1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
		long m=sc.nextLong();
		long a=sc.nextLong();
//		int ans=0;
		long rows=m/a;
		if(m%a!=0)
			rows++;
		
		long col=n/a;
		if(n%a!=0)
			col++;
		System.out.println(rows*col);
		sc.close();
	}

}
