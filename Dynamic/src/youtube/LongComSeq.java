package youtube;

import java.util.Scanner;

public class LongComSeq {
	public static int find(char[] X,char[] Y,int n,int m) {
		if(n==0 || m==0)
		return 0;
		if(X[n-1]==Y[m-1])
			return 1+find(X,Y,n-1,m-1);
		else
			return Math.max(find(X,Y,n-1,m),find(X,Y,n,m-1));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		char X[]=sc.next().toCharArray();
		char Y[]=sc.next().toCharArray();
		System.out.println(find(X,Y,X.length,Y.length));
		sc.close();
	}

}
