package try1;
import java.util.Scanner;
public class CoinComb {
    public static int find(int arr[],int n,int sum){
        int dp[]=new int[sum+1];
        dp[0]=1;
        for (int i = 1; i <sum+1; i++) {
            dp[i]=0;
            for (int value:arr) {
                if(value<=i)
                dp[i]+=dp[i-value];
                else
                break;
            }
        }
        // for (int each : dp) {
        //     System.out.print(each+" ");
        // }
        return dp[sum];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int sum=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        System.out.println(find(arr,n,sum));
        sc.close();
    }
}
