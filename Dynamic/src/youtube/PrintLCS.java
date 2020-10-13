package youtube;
import java.util.Scanner;
// import java.io.*;

public class PrintLCS {
    static int dp[][];
    public static void fill_dp(char[] X, char[] Y, int n, int m) {
        
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<m+1;j++)
            {
                if(X[i-1]==Y[j-1])
                dp[i][j]=1+dp[i-1][j-1];
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

    }
    public static String printlcs(char[] X, char[] Y, int n, int m) {
        dp=new int[n+1][m+1];
        fill_dp(X,Y,n,m);
        StringBuffer sb=new StringBuffer();
        int i=n;
        int j=m;
        while(i>0 && j>0)
        {
            if(X[i-1]==Y[j-1])
            {
                sb.append(X[i-1]).append(" ");
                i--;
                j--;
            }
            else
            {
                if(dp[i-1][j]>dp[i][j-1])
                {
                    i--;
                }
                else
                {
                    j--;
                }
            }
        }
        return sb.reverse().substring(1).toString();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter First String:");
        char[] X = sc.next().toCharArray();
        System.out.println("Enter Second String:");
        char[] Y = sc.next().toCharArray();
        // System.out.println(new String(X) + " " + new String(Y));
        System.out.println("Longest Common Subsequence:");
        System.out.println(printlcs(X, Y, X.length, Y.length));
        System.out.println(dp[X.length][Y.length]);
        sc.close();

    }
}

//Enjoyed a Lot while Doing this,
//Written Own Code by my own.
//Date: 17/09/2020 