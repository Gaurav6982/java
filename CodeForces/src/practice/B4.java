package practice;
import java.util.Scanner;

public class B4 {
	public static class day{
		int min;
		int max;
		int curr;
		boolean failed;
		public day(int min,int max) {
			this.min=min;
			this.max=max;
			this.curr=min;
			this.failed=false;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int total=0;
		int d=sc.nextInt();
		int sumTotal=sc.nextInt();
		day days[]=new day[d];
		for(int i=0;i<d;i++)
		{
			int mintime=sc.nextInt();
			int maxTime=sc.nextInt();
			days[i]=new day(mintime,maxTime);
			total+=mintime;
		}
		int i=0;
		int notpossible=0;
//		System.out.println(total);
		while(total<sumTotal)
		{
			if(!days[i].failed && days[i].curr+1<=days[i].max)
			{
				days[i].curr++;
				total++;
			}
			else if(!days[i].failed)
			{
//				System.out.println(i);
				notpossible++;
				days[i].failed=true;
			}
			if(notpossible==d)
				break;
			if(i==d-1)
				i=0;
			else
				i++;
		}
		
		if(total>sumTotal||notpossible==d)
		{
			System.out.println("NO");
		}
		else
		{
			System.out.println("YES");
			for(int j=0;j<d;j++)
			{
				System.out.print(days[j].curr+" ");
			}
		}
		
		sc.close();
	}

}
