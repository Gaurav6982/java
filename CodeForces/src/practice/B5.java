package practice;
import java.util.ArrayList;
import java.util.Scanner;
public class B5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ArrayList<String> arr=new ArrayList<>();
		StringBuilder stars=new StringBuilder();
		
		int max=0;
		while(sc.hasNextLine())
		{
			String temp=sc.nextLine();
			arr.add(temp);
			if(temp.length()>max)
			{
				max=temp.length();
			}
		}
		String spaces[]=new String[max+2];
		spaces[0]="";
		for(int i=0;i<max+2;i++)
		{
			stars.append("*");
			if(i>0)
			spaces[i]=spaces[i-1]+" ";
		}
		System.out.println(stars);
		boolean left_space=false;
//		boolean odd=true;
		for(String line:arr)
		{
			int left,right;
			if((max-line.length())%2==0)
			{
				left=(max-line.length())/2;
				right=(max-line.length())/2;
			}
			else
			{
				if(left_space)
				{
					left=(int)Math.ceil((max-line.length())/2);
					right=(int)Math.floor((max-line.length())/2);
					left_space=false;
				}
				else
				{
					right=(int)Math.ceil((max-line.length())/2);
					left=(int)Math.floor((max-line.length())/2);
					left_space=true;
				}
				
			}
			System.out.print("*");
			if(left>right)
				System.out.print(spaces[left]);
			else
				System.out.print(spaces[right]);
			System.out.print(line);
			if(left<right)
				System.out.print(spaces[left]);
			else
				System.out.print(spaces[right]);
			System.out.println("*");
				
		}
		System.out.println(stars);
		sc.close();
	}

}
