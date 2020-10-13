package practice;
//import java.util.Arrays;
import java.util.Scanner;
public class B1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		while(n-->0)
		{
			String input=sc.next();
			char arr[]=input.toCharArray();
			int i=0;
			
			while( i<arr.length&&arr[i]!='C' )
			i++;
			if(i!=0 && i!=arr.length && arr[i-1]>='0' && arr[i-1]<='9')
			{
				int len=i-1;
				int len2=arr.length-i-1;
//				System.out.println(len+" "+len2);
				char[] row=new char[len];
				char[] col=new char[len2];
				int rw=0;
				int cl=0;
				for(int j=1;j<=len;j++)
				{
					row[j-1]=arr[j];
//					System.out.print(row[j-1]);
				}
				for(int j=0;j<len;j++)
				{
					rw*=10;
					rw+=row[j]-48;
//					System.out.print(rw+" ");
				}
				for(int j=0;j<len2;j++)
				{
					col[j]=arr[i+j+1];
//					System.out.print(col[j]);
				}
				for(int j=0;j<len2;j++)
				{
					cl*=10;
					cl+=col[j]-48;
//					System.out.print(cl+" ");
				}
//				System.out.println(rw+" "+cl);
				int power=0;
				while(Math.pow(26,power)<=cl)
				{
					power++;
				}
				power--;
				
//				System.out.print(power);
//				System.out.println();
				while(cl>0)
				{
					System.out.print((char)(cl/Math.pow(26,power)+64));
					cl%=Math.pow(26,power);
					power--;
				}
				System.out.print(rw);
				System.out.println();
				
			}
			else
			{
				i=0;
				while(arr[i]>='A' && arr[i]<='Z')
					i++;
				int len=i;
				int len2=arr.length-i;
//				System.out.print(len+" "+len2);
				char[] row=new char[len2];
				char[] col=new char[len];
				int rw=0;
				int cl=0;
				for(int j=0;j<len;j++)
				{
					col[j]=arr[j];
//					System.out.print(row[j]+" ");
				}
				for(int j=0;j<len2;j++)
				{
					row[j]=arr[i+j];
//					System.out.print(col[j]+" ");
				}
				for(int j=len-1;j>=0;j--)
				{
					
					cl+=Math.pow(26, j)*(col[len-j-1]-64);
				}
//				System.out.print(cl);
				for(int j=0;j<len2;j++)
				{
					rw*=10;
					rw+=row[j]-48;
//					System.out.print(rw+" ");
				}
//				System.out.print(rw);
				System.out.println("R"+rw+"C"+cl);
				
			}
		}
		sc.close();
	}

}
