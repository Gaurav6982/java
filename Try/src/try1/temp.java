package try1;
import java.util.Scanner;
public class temp {
    static int k=0;
    public static void print(int arr[])
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static boolean check(int arr[])
    {
        for (int i = 0; i < arr.length-1; i++) {
            if((arr[i]&arr[i+1])<=0)
            return false;
        }
        return true;
    }
    public static boolean isSafe(int arr[],int n,int i,int temp[])
    {
        if(i==0)
        return true;
        if((temp[k-1]&arr[i])>0)
        return true;
        return false;
    }
    
    public static boolean find(int arr[],int n,int i,int temp[])
    {
        print(temp);
        if(i==n)
        {
            print(temp);
            if(check(temp))
            {
                print(temp);
                return true;
            }
            return false;
        }
        for(int l=i;l<n;l++)
        {
            if(isSafe(arr,n,i,temp))
            {
                temp[k++]=arr[i];
                if(find(arr,n,i+1,temp))
                return true;
                temp[--k]=Integer.MAX_VALUE;
            }
        }
        return false;
    }
    public static boolean permute(int arr[], int l, int r) 
    { 
        if (l == r) 
        {
            if(check(arr))
            {
                print(arr);
                return true;
            }
            return false;
        }
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                swap(arr,l,i); 
                if(permute(arr,l+1, r))
                return true; 
                swap(arr,l,i); 
            } 
        }
        return false; 
    } 
    public static void swap(int arr[], int i, int j) 
    { 
        int temp; 
        // char[] charArray = a.toCharArray(); 
        temp = arr[i] ; 
        arr[i] = arr[j]; 
        arr[j] = temp; 
        // return String.valueOf(charArray); 
    } 
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        // for(int i=1;i<6;i++)
        // {
        //     for(int j=1;j<6;j++)
        //     System.out.println(i+" & "+j+" = "+(i&j));
        // }
        // int t=sc.nextInt();
        int t=15;
        while(t-->0)
        {
            // int n=sc.nextInt();
            int n=t;
        int arr[]=new int[n];
        // int temp[]=new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
            // temp[i]=Integer.MAX_VALUE;
        }
        System.out.println(n);
        boolean check=permute(arr, 0, n-1);
        if(!check)
        System.out.println(-1);
        // System.out.println(find(arr,n,0,temp));
        // System.out.println(~5);
        }
        sc.close();
    }
}
