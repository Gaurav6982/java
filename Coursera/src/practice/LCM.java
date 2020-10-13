package practice;
import java.util.Scanner;
public class LCM {
    public static long gcd(long a,long b)
    {
        if(b==0)
        return a;
        return gcd(b,a%b);
    }
    public static long find(long a,long b){
        long gc=gcd(a,b);
        return (a*b)/gc;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long a=sc.nextInt();
        long b=sc.nextInt();
        System.out.println(find(a,b));
        sc.close();
    }
}
