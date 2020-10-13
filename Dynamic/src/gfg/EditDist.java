package gfg;
import java.util.Scanner;
public class EditDist {
    public static int find(String X,String Y,int n,int m)
    {
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(X.charAt(i-1)==Y.charAt(j-1) && (n-i-1==m-j-1 || i == j))
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String X=sc.next();
        String Y=sc.next();
        int n=X.length();
        int m=Y.length();
        int lcs=find(X,Y,n,m);
        System.out.println(lcs);
        System.out.println(Math.max(n,m)-lcs);
        sc.close();
    }    
}
