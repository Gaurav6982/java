package practice;
import java.util.Scanner;
public class Fib1 {
    public static long fib(long n,long m){
        if(n<=1)
        return (long)n;
        long prev=0;
        long curr=1;
        for(long i=0;i<n-1;i++)
        {
            long temp=prev;
            prev=curr;
            curr=temp+prev;
        }
        return curr%m;
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long m=sc.nextLong();
        System.out.println(fib(n,m));
        sc.close();
    }  
}
