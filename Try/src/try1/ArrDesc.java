package try1;
import java.util.Scanner;
class ArrDesc {
    static int m;
    static int ans=0;
    public static boolean find(int arr[],int i)
    {
        if(i>arr.length-1)
        {
            // printArray(arr);
            ans++;
            return false;
            
        }
        if(arr[i]!=0)
        {
            find(arr,i+1);
            return false;
        }
        for(int j=1;j<=m;j++)
        {
            if(isSafe(arr,i,j))
            {
                arr[i]=j;
                if(find(arr,i+1))
                return true;
                arr[i]=0;   
            }
        }
        // }
        return false;
        
    }
    public static boolean isSafe(int arr[],int i,int j){
        // boolean check=true;
        // arr[i]=j;
        if(i==arr.length-1)
        {
            if(Math.abs(j-arr[i-1])>1)
            return false;
        }
        else if(i==0)
        {
            if(arr[i+1]!=0 && Math.abs(j-arr[i+1])>1)
            return false;
        }
        else 
        {
            if(arr[i-1]!=0&&Math.abs(j-arr[i-1])>1 )
            return false;
            if(arr[i+1]!=0&& Math.abs(j-arr[i+1])>1)
            return false;
        }

        return true;
    }
    public static boolean check(int[] arr){
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i]!=0 && arr[i+1]!=0&&Math.abs(arr[i]-arr[i+1])>1)
            return false;
        }
        return true;
    }
    public static void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        m=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        arr[i]=sc.nextInt();
        if(n==1)
        {
            if(arr[0]==0)
            System.out.println(m);
            else
            System.out.println(1);
        }
        else if(check(arr))
        {
            find(arr,0);
            System.out.println(ans);
        }
        else
        System.out.println(0);
        sc.close();

    }    
}
