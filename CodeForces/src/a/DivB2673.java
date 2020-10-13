package a;
import java.util.Scanner;
public class DivB2673 {
    static long min=Long.MAX_VALUE;
    public static int find(long arr[],int i,long black[],int j,long white[],int k)
    {
        if(i==arr.length)
        {
            // int calc=misfo();
            // min=Math.min(min,calc);
            // return calc;
        }
        black[j]=arr[i];
        long a=find(arr,i+1,black,j+1,white,k);
        black[j--]=0;
        white[k]=arr[i];
        long b=find(arr,i+1,black,j,white,k+1);
        white[k]=0;

        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            long T=sc.nextLong();
            long arr[]=new long[n];
            long black[]=new long[n];
            long white[]=new long[n];
            for(int i=0;i<n;i++)
            arr[i]=sc.nextLong();
            System.out.println(find(arr,0,black,0,white,0));
        }
        sc.close();
    }
}
