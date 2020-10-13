package practice;
import java.util.*;

public class CoveringSegments {

    public static class Segment implements Comparable<Segment>{
        int start;
        int end;
        public Segment(int start,int end) {
            this.start = start;
            this.end = end;
        }
        public int getstart(){
            return start;
        }
        public int compareTo(Segment st) {

            int compareQuantity = ((Segment) st).getstart();
    
            //ascending order
            return this.start - compareQuantity;
    
            //descending order
            //return compareQuantity - this.quantity;
    
        }
    }
    
    public static void find(Segment[] sgs,int n)
    {
        int count=0;
        int i=0;
        // int min=Integer.MAX_VALUE;
        StringBuilder s=new StringBuilder();
        while(i<n)
        {
            // min=Integer.MAX_VALUE;
            // int check=min;
            int temp=i;
            while(i<n-1 && sgs[i+1].start>=sgs[temp].start && sgs[i+1].start<=sgs[temp].end)
            {
                
                // min=Math.min(min,Math.min(sgs[temp].end,sgs[i+1].end));
                i++;
            }
            // if(min==check)
            // min=sgs[i].end;
            // s.append(min).append(" ");
            if(i<n)
            count++;
            if(i==n-1)
            break;
            i++;
            
        }
        System.out.println(count);
        System.out.println(s.toString());
        // return count;
    }
    
    public static void main(String[] args) {
        // Random rand = new Random(); 
        Scanner sc=new Scanner(System.in);
       
        int n=sc.nextInt();
        Segment[] sgs=new Segment[n];
        for (int i = 0; i < sgs.length; i++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            sgs[i]=new Segment(a,b);
        }
        // int[] points = optimalPoints(sgs);
        Arrays.sort(sgs);
        // for (int i = 0; i < sgs.length; i++) {
        //     System.out.println(sgs[i].start+" "+sgs[i].end);
        // }
        find(sgs,n);
        // System.out.println(n);
        sc.close();
    }
}
 
