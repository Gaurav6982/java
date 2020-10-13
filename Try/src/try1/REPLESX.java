package try1;

import java.util.Scanner;
import java.util.Arrays;
// import java.util.Random;
public class REPLESX {
    // public static void test(){
    //     Random r=new Random();
    //     int t=r.nextInt(10)+1;
    //     while(t-->0)
    //     {
    //         int n=r.nextInt(5)+1;
    //         int x=r.nextInt(10)+1;
    //         int k=r.nextInt(n)+1;
    //         int p=r.nextInt(k)+1;
    //         while(p==k)
    //         p=r.nextInt(k)+1;
    //         System.out.println("n : "+n);
    //         System.out.println("x : "+x);
    //         System.out.println("p : "+p);
    //         System.out.println("k : "+k);
    //         for (int i = 0; i < n; i++) {
    //             System.out.print(r.nextInt(100)+" ");
    //         }
    //         System.out.println("\n================================");
    //     }
    // }
    // public static void solve(){
    //     Scanner sc=new Scanner(System.in);
    //     int t=sc.nextInt(0);
    //     while(t-->0)
    //     {
    //         int n=sc.nextInt();
    //         long x=sc.nextLong();
    //         int p=sc.nextInt();
    //         int k=sc.nextInt();
    //         Long arr[]=new Long[n];
    //         // PriorityQueue<Integer> q = new PriorityQueue<Integer>(); 
    //         for (int i = 0; i < n; i++) {
    //             arr[i]=sc.nextLong();
    //         }
    //         Arrays.sort(arr);
    //         if(p==k)
    //         {
    //             if(arr[p-1]==x)
    //             System.out.println(0);
    //             else
    //             System.out.println(1);
    //         }
    //         else if(p>k)
    //         {
    //             if(arr[p-1]==x)
    //             System.out.println(0);
    //             else
    //             System.out.println(-1);
    //         }
    //         else
    //         {
    //             if(arr[p-1]==x)
    //             System.out.println(0);
    //             else
    //             {
    //                 int pos=0;
    //                 for (int i = 0; i < n; i++) {
    //                     if(arr[i]>pos)
    //                     {
    //                         pos=i;
    //                         break;
    //                     }
    //                 }
    //                 if(pos==p-1)
    //                 System.out.println(1);
    //                 else if(pos<p-1)
    //                 System.out.println(p-pos+1);
    //                 else
    //                 System.out.println(-1);

    //             }
    //         }
    //     }
    //     sc.close();
    // }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            long x=sc.nextLong();
            int p=sc.nextInt();
            int k=sc.nextInt();
            Long arr[]=new Long[n];
            // PriorityQueue<Integer> q = new PriorityQueue<Integer>(); 
            for (int i = 0; i < n; i++) {
                arr[i]=sc.nextLong();
            }
            Arrays.sort(arr);
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
                // else if(pos==p)
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
        }
        sc.close();
    }    
}
