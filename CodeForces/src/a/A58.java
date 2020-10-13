package a;
import java.util.Scanner;
public class A58 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String temp=sc.next();
		char arr[]= {'h','e','l','l','o'};
		int j=0;
		for(int i=0;i<temp.length();i++)
		{
			if(j<5 && temp.charAt(i)==arr[j])
				j++;
			if(j==5)
				break;
		}
		if(j==5)
			System.out.println("YES");
		else
			System.out.println("NO");
		sc.close();
	}

}
