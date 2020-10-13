package multistage;
import java.util.Scanner;
public class Rec {
    public static int find(int i,int j){
        if(i==j)
        return 0;
        // if(i==1)
        // return j-1;
        // if(j==1)
        // return i-1;
        int ans=Integer.MAX_VALUE;
        for(int k=1;k<i;k++)
        {
            ans=Math.min(ans,1+find(i,k)+find(i,j-k));
        }
        for(int k=1;k<j;k++)
        {
            ans=Math.min(ans,1+find(k,j)+find(i-k,j));
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        int j=sc.nextInt();
        System.out.println(find(i,j));
        sc.close();
    }
}
