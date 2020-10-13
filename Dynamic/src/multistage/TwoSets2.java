package multistage;
import java.util.Scanner;
public class TwoSets2 {
    static long mod=(long)Math.pow(10,9)+7;
    public static long find(int arr[],int n,int sum)
    {
        long dp[][]=new long[n+1][(int)sum+1];

        for(int i=0;i<n+1;i++)
        dp[i][0]=1;

        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(arr[i-1]<=j)
                dp[i][j]=(dp[i-1][j-arr[i-1]]+dp[i-1][j])%mod;
                else
                dp[i][j]=dp[i-1][j];
            }
        }
        
        // for(int i=0;i<n+1;i++)
        // {
        //     for(int j=0;j<sum+1;j++)
        //     {
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.println();
        // }
        
        return dp[n][sum]%mod;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        long sum=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=i+1;
            sum+=arr[i];
        }
        // for(int i=0;i<n;i++)
        // {
        //     System.out.print(arr[i]+" ");
        // }
        // System.out.println(sum/2);
        if(sum%2!=0)
        System.out.println(0);
        else
        System.out.println(find(arr,n,(int)(sum/2))/2);
        sc.close();
    }    
}
