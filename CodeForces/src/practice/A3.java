package practice;

import java.util.*;
public class A3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String from,to;
		Scanner sc=new Scanner(System.in);
		char[] from=sc.next().toCharArray();
		char[] to=sc.next().toCharArray();
		int hdist,vdist;
		hdist=(int)to[0]-(int)from[0];
		vdist=to[1]-from[1];
		System.out.println(Math.max(Math.abs(hdist), Math.abs(vdist)));
		while(vdist!=0 && hdist!=0)
		{
			if(vdist<0 && hdist>0)
			{
				System.out.println("RD");
				vdist++;
				hdist--;
			}
			else if(vdist>0 && hdist>0)
			{
				System.out.println("RU");
				vdist--;
				hdist--;
			}
			else if(hdist<0 && vdist<0)
			{
				System.out.println("LD");
				hdist++;
				vdist++;
			}
			else if(hdist<0 && vdist>0)
			{
				System.out.println("LU");
				hdist++;
				vdist--;
			}
			
		}
		while(hdist!=0)
		{
			if(hdist>0)
			{
				System.out.println("R");
				hdist--;
			}
			else if(hdist<0)
			{
				System.out.println("L");
				hdist++;
			}
		}
		
		while(vdist!=0)
		{
			if(vdist<0)
			{
				System.out.println("D");
				vdist++;
			}
			else if(vdist>0)
			{
				System.out.println("U");
				vdist--;
			}
		}
		sc.close();
	}

}
