package nQueen;
import java.util.*;
public class NQueen {
	private static int N;
	private static int no_of_sol=0;
	public static boolean nQueen(int board[][],int i) {
			int n=N;
			if(i==n)
			{
				for(int j=0;j<n;j++)
				{
					for(int k=0;k<n;k++)
					{
						if(board[j][k]==1)
						System.out.print("Q ");
						else
							System.out.print("_ ");
					}
					System.out.println();
					
				}
				no_of_sol++;
				System.out.println();
				return false;
			}
			
			for(int j=0;j<n;j++)
			{
				if(isSafe(board,i,j))
				{
					board[i][j]=1;
					
					if(nQueen(board,i+1))
						return true;
					board[i][j]=0;
				}
			}
			return false;
	}
	public static boolean isSafe(int board[][],int row,int col) {
		 
		for(int i=0;i<row;i++)
		{
			if(board[i][col]==1)
				return false;
		}
		
		int x=row;
		int y=col;
		
		while(x>=0 && y>=0)
		{
			if(board[x][y]==1)
				return false;
			x--;
			y--;
		}
		x=row;
		y=col;
		while(x>=0 &&y<N)
		{
			if(board[x][y]==1)
				return false;
			x--;
			y++;
		}
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		N=n;
		int board[][]=new int[20][20];
		
		if(!nQueen(board,0))
			System.out.println("Not Possible");
		System.out.println(no_of_sol);
		sc.close();
	}

}
