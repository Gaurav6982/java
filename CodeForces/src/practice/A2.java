package practice;
import java.util.*;
public class A2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
//		String ans="";
		int max=Integer.MIN_VALUE;
		Map<String,Integer> mp=new HashMap<>();
		String names[]=new String[n];
		int scores[]=new int[n];
//		int i=0;
		for(int i=0;i<n;i++)
		{	
			names[i]=sc.next();
			scores[i]=sc.nextInt();
			if(mp.containsKey(names[i]))
			{
				scores[i]=scores[i]+mp.get(names[i]);
				mp.put(names[i],scores[i]);
			}
			else
			{
				mp.put(names[i],scores[i]);
			}
		
		}
		
		max=Collections.max(mp.values());
//
//		for(int i=0;i<n;i++)
//		{
//			if(max==mp.get(names[i])&&scores[i]>=max)
//			{
//				System.out.println(names[i]);
//				break;
//			}
//		}
		Iterator<String> itr=mp.keySet().iterator();
		Iterator<Integer> i=mp.values().iterator();
		while(itr.hasNext())
			System.out.println(itr.next()+" "+i.next());
//		System.out.println(ans);
		sc.close();
	}

}
