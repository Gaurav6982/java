package try1;

import java.util.Scanner;
class Candy {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int input[]=new int[n];
		int left[]=new int[n];
		int right[]=new int[n];
		for(int i=0;i<n;i++)
		{
		    input[i]=sc.nextInt();
		    left[i]=right[i]=1;
		}
		sc.close();
		for(int i=1;i<n;i++)
		{
		    if(input[i]>input[i-1])
		    left[i]=left[i-1]+1;
		}
		for(int i=n-2;i>=0;i--)
		{
		    if(input[i]>input[i+1])
		    right[i]=right[i+1]+1;
		}
		int min=0;
		for(int i=0;i<n;i++)
		{
			min+=Math.max(left[i],right[i]);
		    System.out.print(Math.max(left[i],right[i])+" ");
		}
		System.out.println("\n"+min);
		
	}
}
//
//8
//12 4 3 11 34 34 1 67