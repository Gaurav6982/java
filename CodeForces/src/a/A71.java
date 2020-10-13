package a;
import java.util.Scanner;
public class A71{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n-->0)
        {
            String temp=sc.next();
            if(temp.length()>10)
            {
                int l=temp.length();
                System.out.print(temp.charAt(0));
                System.out.print(l-2);
                System.out.println(temp.charAt(l-1));
            }
            else
            System.out.println(temp);
        }
        sc.close();
    }
}