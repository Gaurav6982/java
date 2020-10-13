package multistage;
import java.util.Scanner;
public class MoneySums {
    static boolean dp[][];
    public static void fill_dp(int arr[],int n,int sum)
    {
        dp=new boolean[n+1][sum+1];
        
        for(int i=0;i<sum+1;i++)
        {
            dp[0][i]=false;
        }
        for(int i=0;i<n+1;i++)
        {
            dp[i][0]=true;
        }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(arr[i-1]<=j)
                dp[i][j]=dp[i-1][j]||dp[i-1][j-arr[i-1]];
                else
                dp[i][j]=dp[i-1][j];
            }
        }
        // for(int i=0;i<n+1;i++)
        // {
        //     for(int j=0;j<sum+1;j++)
        //     {
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }

    }
    public static void solve(int n,int sum){
        int count=0;
        StringBuilder s=new StringBuilder();
        for(int i=1;i<sum+1;i++)
        {
            if(dp[n][i])
            {
                count++;
                s.append(i).append(" ");
            }
        }
        System.out.println(count);
        System.out.println(s.toString());
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        int sum=0;
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            sum+=arr[i];
        }
        fill_dp(arr,n,sum);
        solve(n,sum);
        sc.close();
    }
}
