package practice;
import  java.util.Scanner;
import  java.util.ArrayList;
import java.util.HashMap;
public class C4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		HashMap<String,Integer> mp=new HashMap<>();
		ArrayList<String> st=new ArrayList<>();
		while(n-->0)
		{
			String temp=sc.next();
			StringBuilder str=new StringBuilder(temp);
			if(mp.containsKey(temp))
			{
				int num=mp.get(temp);
				num++;
				mp.put(temp,num);
				str.append(num);
				mp.put(str.toString(),0);
				st.add(str.toString());
			}
			else
			{
				st.add("OK");
				mp.put(temp,0);
			}
		}
		
		for(int i=0;i<st.size();i++)
		{
			System.out.println(st.get(i));
		}
		sc.close();
	}

}
