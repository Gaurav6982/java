package youtube;
import java.util.Scanner;
public class PalinPart {
    public static boolean isPalindrome(String s,int i,int j)
    {
        if(i>=j)
        return true;
        if(s.charAt(i)!=s.charAt(j))
        return false;
        isPalindrome(s, i+1, j-1);
        return true;
    }
    public static int find(String s,int i,int j)
    {
        if(i>=j)
        return 0;
        if(isPalindrome(s,i,j))
        return 0;
        int min=Integer.MAX_VALUE;
        for(int k=i;k<j;k++)
        {
            int temp=1+find(s,i,k)+find(s,k+1,j);
            min=Math.min(min,temp);
        }

        return min;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s="nitin";
        System.out.println(find(s,0,s.length()-1));
        sc.close();
    }
}
