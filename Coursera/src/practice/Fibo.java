package practice;
import java.util.Scanner;
public class Fibo {
    public static long fib(int n){
        if(n<=1)
        return (long)n;
        long arr[]=new long[n+1];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<=n;i++)
        {
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n];
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(fib(n));
        sc.close();
    }   
}
