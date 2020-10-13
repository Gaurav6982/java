package multistage;
import java.util.Scanner;
public class ExpTrue{
    public static int count(String exp,int k,int lt,int lf,int rt,int rf,boolean isTrue)
    {
        int count=0;
        if(exp.charAt(k)=='|')
        {
            if(isTrue)
                count=lt*rt+lt*rf+rf*rt;
            else
                count=rf*lf;
        }
        else if(exp.charAt(k)=='&')
        {
            if(isTrue)
                count=lt*rt;
            else
                count=lt*rf+rt*lf+rf*lf;
        }
        else if(exp.charAt(k)=='^')
        {
            if(isTrue)
                count=lt*rf+rt*lf;
            else
                count=lt*rt+lf*rf;
        }

        return count;
    }
    public static int find(String exp,int i,int j,boolean isTrue)
    {
        if(i>j)
        {
            return 0;
        }
        if(i==j)
        {
            if(isTrue)
            return exp.charAt(i)=='T'?1:0;
            else
            return exp.charAt(i)=='F'?1:0;
        }
        int ans=0;
        for(int k=i+1;k<j;k+=2)
        {
            int lt=find(exp,i,k-1,true);
            int lf=find(exp,i,k-1,false);
            int rt=find(exp,k+1,j,true);
            int rf=find(exp,k+1,j,false);
            // System.out.println(i+" "+(k-1)+" "+(k+1)+" "+j+" "+lt+" "+lf+" "+rt+" "+rf+" ");
            ans+=count(exp,k,lt,lf,rt,rf,isTrue);            
        }
        return ans;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String exp=sc.next();
        System.out.println(find(exp,0,exp.length()-1,true));
        sc.close();
    }
}