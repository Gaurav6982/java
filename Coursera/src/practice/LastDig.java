package practice;
import java.util.Scanner;
public class LastDig {
    static long arr[];
    public static long fib(int n){
        if(n<=1)
        return n;
        
        return arr[n%60];
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        arr=new long[61];
        arr[0]=0;
        arr[1]=1;
        for(int i=2;i<60;i++)
        {
            arr[i]=(arr[i-1]+arr[i-2])%10;
        }
        System.out.println(fib(n));
        sc.close();
    }   
}
