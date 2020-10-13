package practice;
import java.util.*;
public class B8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		char temp[]=sc.next().toCharArray();
		int x=0;
		int y=0;
		for(int i=0;i<temp.length;i++)
		{
			if(temp[i]=='L')
				x--;
			else if(temp[i]=='R')
				x++;
			if(temp[i]=='U')
				y++;
			else if(temp[i]=='D')
				y--;
		}
		if(Math.abs(x)+Math.abs(y)<=1)
		{
			System.out.println("BUG");
		}
		else
			System.out.println("OK");
		sc.close();
	}

}
