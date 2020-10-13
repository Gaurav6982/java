package jobSequencing;
import java.util.*;
class Jobs implements Comparable<Jobs>{
	int id;
	int profit;
	int deadline;
	
	public int compareTo(Jobs job) {
		return job.profit-this.profit;
	}
}
public class JobSequenceWithDeadLines {
	public static void printJobSequence(Jobs[] jobArray,int max_deadline) {
		int slots[]=new int[max_deadline];
		Arrays.fill(slots, -1);
		int profit=0;
//		boolean allocated[]=new boolean[max_deadline];
		
//		int available[]=new int[max_deadline];
		
//		for(int i=0;i<max_deadline;i++)
//		{
//			available[i]=i+1;
//		}
		
		for(int i=0;i<jobArray.length;i++)
		{
			Jobs current=jobArray[i];
			int slot=current.deadline-1;
			if(slots[slot]==-1)
			{
				slots[slot]=current.id;
				profit+=current.profit;
			}
			else
			{
				int j=0;
				while(j>=0 && slots[j]!=-1)
				{
					j--;
				}
				if(j==-1)
					continue;
				slots[j]=current.id;
				profit+=current.profit;
			}

		}
		
		System.out.print("Job Sequence is ");
		for(int i=0;i<max_deadline;i++)
		{
			System.out.print(slots[i]+" ");
		}
		System.out.println();
		System.out.println("Profit = "+profit);
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int max=Integer.MIN_VALUE;
		System.out.println("Enter Number of Jobs ");
		int n=sc.nextInt();
		Jobs jobArray[]=new Jobs[n];
		System.out.println("Enter Profits");
		for(int i=0;i<n;i++)
		{
			jobArray[i]=new Jobs();
			jobArray[i].profit=sc.nextInt();
			jobArray[i].id=i+1;
		}
		System.out.println("Enter Deadlines");
		for(int i=0;i<n;i++)
		{
			jobArray[i].deadline=sc.nextInt();
			if(jobArray[i].deadline>max)
				max=jobArray[i].deadline;
		}
		sc.close();
		Arrays.sort(jobArray);
//		for(int i=0;i<n;i++)
//		{
//			System.out.println(jobArray[i].profit+" "+jobArray[i].deadline);
//		}
		printJobSequence(jobArray,max);
	}

}

//Test Case: 
//	5
//	10 15 20 3 5
//	1 2 2 3 3
