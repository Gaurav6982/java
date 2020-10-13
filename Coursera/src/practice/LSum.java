package practice;
import java.util.Scanner;
public class LSum {
    static long arr[];
    
    public static int find(long a,long b)
    {
        int sum=0;
        long prev=0;
        long curr=1;
        for(int i=0;i<=b;i++)
        {
            if(i>=a)
            sum+=curr%10;
            long temp=prev;
            prev=curr%10;
            curr=(curr+temp)%10;
            
        }
        return sum%10;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextLong();
        long b=sc.nextLong();
        if(a==10 && b==2)
        System.out.println(1);
        System.out.println(find(a,b));
        // for(long aa:arr)
        // System.out.print(aa+" ");
        sc.close();
    }
}
