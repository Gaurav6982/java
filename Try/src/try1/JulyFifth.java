package try1;
import java.util.Scanner;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;
public class JulyFifth {

	static class node{
		long key;
		int value;
		
		node(long key,int value){
			this.key=key;
			this.value=value;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			
			Map<Long,Integer> first=new TreeMap<>();
			Map<Long,Integer> second=new TreeMap<>();
			ArrayList<Long> arr=new ArrayList<>();
			int check=0;
			for(int i=0;i<n;i++)
			{
				long x=sc.nextLong();
				if(first.containsKey(x))
				{
					first.put(x,first.get(x)+1);
				}
				else
				{
					first.put(x,1);
					arr.add(x);
				}
				check^=x;
				
			}
			for(int i=0;i<n;i++)
			{
				long x=sc.nextLong();
				if(second.containsKey(x))
				{
					second.put(x,second.get(x)+1);
				}
				else
				{
					second.put(x,1);
					if(!arr.contains(x))
						arr.add(x);
				}
				check^=x;
				
			}
			
			int ans=0;
			if(check==0)
			{
				if(first.equals(second))
				{
					ans=0;
				}
				else
				{
					Collections.sort(arr);
					int count=0;
					ArrayList<Long> faulty=new ArrayList<>();
					ArrayList<Integer> values=new ArrayList<>();
					for(long en:arr)
					{
						int val1=0,val2=0;
						if(first.containsKey(en) && second.containsKey(en))
						{
							val1=first.get(en);
							val2=second.get(en);
							if(val1!=val2)
							{
								faulty.add(en);
								count+=Math.abs(val1-val2);
								values.add(Math.abs(val1-val2)/2);
							}
						}
						else if(first.containsKey(en) && !second.containsKey(en))
						{
							val1=first.get(en);
							val2=0;
							count+=val1;
							faulty.add(en);
							values.add(Math.abs(val1-val2)/2);
						}
						else if(!first.containsKey(en) && second.containsKey(en))
						{
							val1=0;
							val2=second.get(en);
							count+=val2;
							faulty.add(en);
							values.add(Math.abs(val1-val2)/2);
						}
					}
					count=count/4;
//					for(int i=0;i<faulty.size();i++)
//					{
//						System.out.println(faulty.get(i)+" "+values.get(i));
//					}
					int i=0;
					while(count>0)
					{
						long num=faulty.get(i);
						int change=values.get(i);
						if(count>=change)
						{
							ans+=num*change;
							count-=change;
						}
						else
						{
							ans+=num*count;
							count--;
						}
						i++;
						
						
					}
				}
			}
			else
			{
				ans=-1;
			}
			System.out.println(ans);
		}
		sc.close();
	}

}
