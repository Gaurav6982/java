package pattern;
import java.util.*;
public class Pat {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int list[]=new int[n];
		for(int i=0;i<n;i++)
		{
			list[i]=sc.nextInt();
		}
		int sum;
		int j=0;
		while(j<n-1)
		{
			sum=0;
			int first=-1;
			int second=-1;
			for(int k=0;k<n;k++)
			{
				if(first==-1|| list[k]<list[first])
				{
					first=k;
				}
			}
			System.out.print("First :"+first);
			sum+=list[first];
			
			for(int k=0;k<n;k++)
			{
				if((second==-1||list[k]<list[second])&& k!=first)
				{
					second=k;
				}
			}
			sum+=list[second];
			System.out.print(" Second :"+second);
			System.out.println();
			list[second]=sum;
			list[first]=Integer.MAX_VALUE;
			j++;
		}
		System.out.println(list[n-1]);
		sc.close();
	}

}
//5
//5 10 20 30 30