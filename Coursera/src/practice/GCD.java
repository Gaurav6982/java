package practice;
import java.util.Scanner;
public class GCD {
    public static int gcd(int a,int b)
    {
        if(b==0)
        return a;
        return gcd(b,a%b);
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        if(b>a)
        {
            int temp=b;
            b=a;
            a=temp;
        }
        System.out.println(gcd(a,b));
        sc.close();
    
    }
}
