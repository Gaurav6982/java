package multistage;
import java.util.Scanner;
public class Removal{
    public static long find(long arr[],int n,int i,int j,int k)
    {
        // int dp[][]=new int[n+1][n+1];
        if(i>j)
        return 0;
        if(k==0)
        {
            return Math.max(arr[i]+find(arr,n,i+1,j,1),arr[j]+find(arr,n,i,j-1,1));
        }
        else
        {
            return Math.min(find(arr,n,i+1,j,0),find(arr,n,i,j-1,0));
        }
        // return dp[n][n];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long arr[]=new long[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextLong();
        System.out.println(find(arr,n,0,n-1,0));
        sc.close();
    }
}