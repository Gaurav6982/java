package try1;
import java.util.Scanner;
public class PrintScs {
    static int[][] dp;
    public static void lcs(char[] X,char Y[],int n,int m)
    {
        for(int i =1;i<=n;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(X[i-1]==Y[j-1])
                {
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else
                {
                    // if(dp[i-1][j]>dp[i][j-1])
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
    }
    public static String find(char[] X,char[] Y,int n,int m)
    {
        dp=new int[n+1][m+1];
        lcs(X,Y,n,m);
        for(int i =0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        StringBuffer st=new StringBuffer();
        int i=n;
        int j=m;
        while(i>0 && j>0)
        {
                if(X[i-1]==Y[j-1])
                {
                    st.append(X[i-1]);
                    i--;
                    j--;
                }   
                else
                {
                    if(dp[i-1][j]>dp[i][j-1])
                    {
                        st.append(X[i-1]);
                        i--;
                    }
                    else{
                        st.append(Y[j-1]);
                        j--;
                    }
                    // st.append(Y[j-1]).append(X[i-1]);
                }
            }
            // System.out.println();
            while(i>0)
            {
                st.append(X[i-1]);
                i--;        
            }
            while(j>0)
            {
                st.append(Y[j-1]);
                j--;        
            }
        
        return st.reverse().toString();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        char X[]=sc.next().toCharArray();
        char Y[]=sc.next().toCharArray();
        System.out.println(find(X,Y,X.length,Y.length));
        sc.close();
    }    
}
