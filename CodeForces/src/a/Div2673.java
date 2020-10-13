package a;
import java.util.Scanner;
import java.util.Arrays;
public class Div2673{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int k=sc.nextInt();
            Integer arr[]=new Integer[n];
            int ans=0;
            // int min=Integer.MAX_VALUE;
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
                // min=Math.min(min, arr[i]);
            }
            Arrays.sort(arr);
            for(int i=1;i<n;i++)
            {
                ans+=(k-arr[i])/arr[0];
            }
            System.out.println(ans);

        }
        sc.close();        
    }
}