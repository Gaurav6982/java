package practice;
import java.util.Scanner;
public class SumSqFib {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long arr[]=new long[65];
        int p[]=new int[65];
        arr[0]=p[0]=0;
        arr[1]=p[1]=1;
        for(int i=2;i<65;i++)
        {
            arr[i]=arr[i-1]+arr[i-2];
            p[i]=(int)(Math.pow(arr[i],2)%10);
        }
        for (long each : arr) {
            System.out.print(each+" ");
        }
        System.out.println();
        for (int each : p) {
            System.out.print(each+" ");
        }
        sc.close();
    }
}
