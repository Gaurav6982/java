package try1;
import java.util.Scanner;
public class Trap {
    public static int find(char arr[][],int n,int i,int j){
        if(i>=n ||j>=n)
        return 0;
        if(arr[i][j]=='*')
        return 0;
        if(i==n-1 && j==n-1)
        return 1;
        return find(arr,n,i+1,j)+find(arr,n,i,j+1);
    }
    public static int find_dp(char arr[][],int n){
        int[][] dp=new int[n+1][n+1];
        for (int i = n;i>=1; i--) {
            for(int j=n;j>=1;j--){
                if(arr[i-1][j-1]=='*')
                {
                    dp[i][j]=0;
                    continue;
                }
                if(i==n && j==n)
                dp[i][j]=1;
                else{
                    int op1=(i==n)?0:dp[i+1][j];
                    int op2=(j==n)?0:dp[i][j+1];
                    dp[i][j]=op1+op2;
                }
            }
        }
        return dp[1][1];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[][] arr=new char[n][n];
        for(int i=0;i<n;i++)
        {
            String s=sc.next();
            arr[i]=s.toCharArray();
        }
        System.out.println(find(arr,n,0,0));
        System.out.println(find_dp(arr,n));
        sc.close();
    }
}
