package try1;
import java.util.Scanner;
public class GoldMine {
	public static int find(int[][] mat,int i)
	{
		int count=mat[i][0];
		for(int j=1;j<mat.length;j++)
		{
			int a=0,b=0,c=0;
			if(i==0)
				a=0;
			else
				a=mat[i-1][j];
				b=mat[i][j];
			if(i==mat.length-1)
				c=0;
			else
				c=mat[i+1][j];
			
			int max=Math.max(a,Math.max(b,c));
			if(max==a)
				i=i-1;
			else if(max==c)
				i=i+1;
				
			count+=max; 
		}
		return count;
	}
	public static int count(int[][] mat)
	{
		int n=mat.length;
		int max=0;
		for(int i=0;i<n;i++)
		{
			int temp=find(mat,i);
			max=Math.max(temp,max);
		}
		return max;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();//size of Matrix
		int[][] mat=new int[n][n];
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				mat[i][j]=sc.nextInt();
			}
		}
		System.out.println(count(mat));
		sc.close();
	}

}

//3
//1 3 3
//2 1 4
// 0 6 4

//ans=12

//4
//1 3 1 5
//2 2 4 1
//5 0 2 3
//0 6 1 2

//ans=16

//4
//10 33 13 15
//22 21 4 1
//5 0 2 3
//0 6 14 2

//ans=83
