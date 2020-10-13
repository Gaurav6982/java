package try1;
import java.util.Random;
import java.util.Arrays;
public class testing1 {
    public static int checkifexist(long arr[],long x)
    {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==x)
            return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        Random r=new Random();
        int t=r.nextInt(10)+1;
        System.out.println("t : "+t);
        System.out.println("------------------------");
        while(t-->0)
        {
            int n=r.nextInt(10)+1;
            long x=r.nextInt(10);
            int p=r.nextInt(n)+1;
            // int k=r.nextInt(n)+1;
            int k=p;
            long arr[]=new long[n];
            // PriorityQueue<Integer> q = new PriorityQueue<Integer>(); 
            for (int i = 0; i < n; i++) {
                arr[i]=r.nextInt(10)+1;
            }
            Arrays.sort(arr);
            System.out.println("n : " + n);
            System.out.println("x : " + x);
            System.out.println("p : " + p);
            System.out.println("k : " + k);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            
            int eq=checkifexist(arr,x);
            if(eq!=-1)
            {
                System.out.println(Math.abs(eq-p));
            }
            else
            {
                int pos=0;
                for(;pos<n;pos++)
                {
                    if(arr[pos]>=x)
                    break;
                }
                if((arr[p]>x && pos==p-1)||(arr[p]<x && pos==p))
                System.out.println(1) ;


            }
            System.out.println("=======================");
        }
    }
}
