package gfg;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class A {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int arr[]=new int[n];
            Queue<Integer> q= new LinkedList<>();
            int sum=0;
            for (int i = 0; i < arr.length; i++) {
                int temp=sc.nextInt();
                sum+=temp;            // arr[i]=sc.nextInt();
                q.add(temp);
            }
            if(sum==0)
            {
                System.out.println("NO");
                continue;
            }
            int i=0;
            while(!q.isEmpty())
            {
                int temp=q.poll();
                if(sum+temp!=0)
                {
                    sum+=temp;
                    arr[i++]=temp;
                }
                else{
                    q.add(temp);
                }
            }
            System.out.println("YES");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[j]+" ");
            }
            System.out.println();
            
             
        }
        sc.close();
    }    
}
