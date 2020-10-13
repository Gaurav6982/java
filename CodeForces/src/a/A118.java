package a;
import java.util.*;
public class A118 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		char temp[]=sc.next().toCharArray();
		int i=0;
		while(i<temp.length)
		{
			if(temp[i]=='a' ||temp[i]=='A'||
					temp[i]=='e' ||temp[i]=='E'||
					temp[i]=='i' ||temp[i]=='I'||
					temp[i]=='o' ||temp[i]=='O'||
					temp[i]=='u' ||temp[i]=='U')
				continue;
			else
			{
				if(temp[i]>='A' && temp[i]<='Z')
					temp[i]+=32;
				System.out.print("."+temp[i]);
			}
			i++;
		}
		
		sc.close();
	}

}
