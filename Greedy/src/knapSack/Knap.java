package knapSack;
import java.util.*;
class item implements Comparable<item>{
	int number;
	int weight;
	int profit;
	float ratio;
	
	public int compareTo(item i)
	{
		return Float.compare( i.ratio,this.ratio);
	}
}
public class Knap {

	public static void printItems(item items[],int n,int m)
	{
		float total=0;
		float ratios[]=new float[n];
		int i=0;
		while(m>0&& i<n)
		{
			item current=items[i];
			if(current.weight<=m)
			{
				ratios[current.number-1]=1.0f;
				m-=current.weight;
			}
			else
			{
				ratios[current.number-1]=(float)m/current.weight;
				m=0;
			}
			total+=ratios[current.number-1]*items[i].profit;
//			System.out.print(total+" ");
			i++;
		}
//		for(int j=0;j<n;j++)
//		{
//			System.out.print(ratios[j]+" ");
//		}
		
		System.out.println(total);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Number of Items : ");
		int n=sc.nextInt();
		System.out.println("Enter Capacity of KnapSack : ");
		int m=sc.nextInt();
		item items[]=new item[n];
		System.out.println("Enter Weights : ");
		for(int i=0;i<n;i++)
		{
			items[i]=new item();
			items[i].weight=sc.nextInt();
			items[i].number=i+1;
		}
		
		System.out.println("Enter Profits : ");
		for(int i=0;i<n;i++)
		{
			items[i].profit=sc.nextInt();
		}
		
		for(int i=0;i<n;i++)
		{
			items[i].ratio=(float)items[i].profit/items[i].weight;
		}
		
		sc.close();
		Arrays.sort(items);
//		for(int i=0;i<n;i++)
//		{
//			System.out.print(items[i].number+" ");
//		}
		printItems(items,n,m);
	}

}
//7 15
//2 3 5 7 1 4 1
//10 5 15 7 6 18 3
//
