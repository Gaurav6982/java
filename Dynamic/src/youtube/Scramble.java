package youtube;
import java.util.Scanner;
public class Scramble {
    public static boolean find(String a,String b)
    {
        if(a.length()!=b.length())
        return false;
        if(a.compareTo(b)==0)
        return true;
        if(a.length()<=1)
        return false;
        boolean flag=false;
        for(int k=1;k<a.length();k++)
        {
            if((find(a.substring(0, k),b.substring(k,b.length()))&&find(a.substring(k, a.length()),b.substring(0,k)))||(find(a.substring(0, k),b.substring(0,k))&&find(a.substring(k, a.length()),b.substring(k,b.length()))))
            {
                flag=true;
                break;
            }
        }
        return flag;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        if(a.length()!=b.length())
        System.out.println("No");
        else
        System.out.println((find(a,b))?"YES":"NO");
        sc.close();        
    }
}
