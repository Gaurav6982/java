package gfg;
import java.util.Scanner;
public class MatrixChain {
    public static int find(int arr[],int i,int j){
        if(i==j)
        return 0;

        int min=Integer.MAX_VALUE;
        for(int k=i+1;k<=j;k++)
        {
            int temp=find(arr,i,k-1)+find(arr,k,j)+arr[i-1]*arr[k-1]*arr[j];
            min=Math.min(temp,min);
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[]={40,20,30,10,30};//26000
        int arr1[]={10,30,5,60}; //4500
        int arr2[]={1,2,3,4,3}; //30
        System.out.println(find(arr2,1,arr2.length-1));
        System.out.println(find(arr,1,arr.length-1));
        System.out.println(find(arr1,1,arr1.length-1));
        sc.close();
    }
}
