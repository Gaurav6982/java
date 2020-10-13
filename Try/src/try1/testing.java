package try1;
import java.util.Random;
import java.util.Arrays;
public class testing {
    public static boolean checkifexist(long arr[],long x)
    {
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==x)
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Random r=new Random();
        int t=r.nextInt(10)+1;
        System.out.println("t : "+t);
        System.out.println("------------------------");
        while(t-->0)
        {
            int n=r.nextInt(5)+1;
            long x=r.nextInt(10);
            int p=r.nextInt(n)+1;
            int k=r.nextInt(n)+1;
            // int p=r.nextInt(k)+1;
            // int c=10;
            // while(c-->0 && p==k)
            // {
                // p=r.nextInt(k)+1;
            // }
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
            if(p==k)
            {
                int pos=0;
                int i ;
                // int eq=-1;
                if(arr[p-1]>x)
                {
                    for (i = 0; i < n; i++) {
                        if(arr[i]>x)
                        {
                            break;
                        }
                    }
                    pos=i;
                    
                }
                else
                {
                    for (i = 0; i < n; i++) {
                        if(arr[i]>=x)
                        {
                            break;
                        }
                        
                    }
                    pos=i;
                    // if(checkifexist(arr,x))
                    // pos++;
                }
                
                
                if(arr[p-1]==x)
                System.out.println(0);
                else if((p<n && arr[p-1]>x && pos==p-1)||(p<n&&arr[p-1]<x && pos==p))
                System.out.println(1);
                else
                {
                    if(pos>p-1)
                    System.out.println(Math.abs(p-pos-1));
                    else
                    System.out.println(Math.abs(p-pos));

                } 
            }
            else if(p>k)
            {
                int pos=0;
                    int i ;
                    for (i = 0; i < n; i++) {
                        if(arr[i]>x)
                        {
                            break;
                        }
                        if(arr[p-1]<x && arr[i]>=x)
                        break;
                    }
                    pos=i;
                    // System.out.println(" "+pos+" p"+p);
                if(arr[p-1]==x)
                System.out.println(0);
                else if(pos>=p-1)
                {
                    if(pos==p-1 && arr[p-1]>x)
                    System.out.println(-1);
                    else
                    System.out.println(Math.abs(p-1-pos));
                }
                else
                System.out.println(-1);
            }
            else
            {
                if(arr[p-1]==x)
                System.out.println(0);
                else 
                {
                    int pos=0;
                    int i ;
                    for (i = 0; i < n; i++) {
                        if(arr[i]>x)
                        {
                            break;
                        }
                        if(arr[p-1]<x && arr[i]>=x)
                        break;
                    }
                    pos=i;
                    // System.out.println("pos="+pos);
                    if(pos>k-1)
                    System.out.println(-1);
                    else if(pos==p-1)
                    System.out.println(1);
                    else if( (pos<k-1 && pos <p-1))
                    System.out.println(Math.abs(p-pos));
                    else
                    System.out.println(-1);

                }
            }
            System.out.println("=======================");
        }
    }
}
