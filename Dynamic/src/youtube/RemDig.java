package youtube;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;
public class RemDig {
    static int max=Integer.MIN_VALUE;
    public static int find(int n){
        if(n<10)
        return n;
        HashSet<Integer> set=new HashSet<>();
        int temp=n;
        while(temp>0)
        {
            int rem=temp%10;
            temp/=10;
            if(!set.contains(rem))
            set.add(rem);
        }
        int ans=0;  
        Iterator<Integer> it = set.iterator();
        while(it.hasNext())
        {
            System.out.print(it.next()+" ");
        }
        System.out.println();
        while(it.hasNext())
        {
            // System.out.print(it.next()+" ");
            ans+=find(n-it.next());
            max=Math.max(ans, max);
            set.remove(it.next());
        }
        // System.out.println();
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        find(n);
        System.out.println(max);
        sc.close();
    }
}
