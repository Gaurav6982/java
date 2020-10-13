package try1;
import java.util.Scanner;
public class Books {
    public static int find(int[] price,int[] pages,int n,int sum)
    {
        int dp[][]=new int[n+1][sum+1];
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                if(price[i-1]<=j)
                {
                    dp[i][j]=Math.max(pages[i-1]+dp[i-1][j-price[i-1]],dp[i-1][j]);
                }
                else
                dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][sum];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int price[]=new int[n];
        int pages[]=new int[n];
        for (int i = 0; i < n; i++) {
            price[i]=sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            pages[i]=sc.nextInt();
        }
        System.out.println(find(price,pages,n,sum));
        sc.close();        
    }
}
