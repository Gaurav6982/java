package try1;

import java.util.Scanner;
public class posand {
    public static void swap(int[] arr,int i,int j)
    {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            int temp=n;
            while(temp!=1)
            {
                if(temp%2!=0)
                break;
                temp=temp/2;
            }
            if(temp==1)
            {
                if(n==1)
                System.out.println(1);
                else
                System.out.println(-1);
            }
            else{
                if(n==3)
                System.out.println("1 3 2");
                else if(n==5)
                System.out.println("2 3 1 5 4");
                else
                {
                    System.out.print("1 3 2 6 5 4");
                    // arr[6]=7;
                    int tempo=8;
                    for (int i = 7; i <=n; i++) {
                        if(i==tempo && tempo<n)
                        {
                            System.out.print(" "+(tempo+1)+" "+tempo);
                            tempo*=2;
                            i++;
                            continue;
                        }
                        else
                        System.out.print(" "+i);
                    }
                    // for(int i=8;i<n;i=i*2)
                    // {
                    //     swap(arr,i,i-1);
                    // }
                    // for (int i = 0; i < n; i++) {
                    //     System.out.print(arr[i]+" ");
                    // }
                    System.out.println();
                }
            }
            

        }
        sc.close();
    }
}
