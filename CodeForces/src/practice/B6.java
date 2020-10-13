package practice;
import java.util.Scanner;
public class B6 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		char c=sc.next().charAt(0);
		char[][] board=new char[n][m];
		int i=0,j=0;
		boolean set=false;
		int start_i=0,start_j=0;
		for(i=0;i<n;i++)
		{
			String temp=sc.next();
			for(j=0;j<m;j++)
			{
				board[i][j]=temp.charAt(j);
				if(board[i][j]==c &&!set)
				{
					start_i=i;
					start_j=j;
					set=true;
				}
			}
		}
		sc.close(); //close input
		
//		System.out.println(i);
		i=start_i;
		j=start_j;
		while(i<n-1 && board[i+1][j]==c)
			i++;
		int end_i=i;
		i=start_i;
		j=start_j;
		while(j<m-1 && board[i][j+1]==c)
			j++;
		int end_j=j;
//		System.out.println(start_i+" "+end_i+" "+start_j+" "+end_j);
		
		
		int temp=0;
		int ans=0;
		
		//Check For Top
		i=start_i;
		j=start_j;
		char prev='\0';
		while(i>0 && j<=end_j)
		{
			if(prev=='\0')
			{
				prev=board[i-1][j];
			}
			else if(prev !=board[i-1][j])
			{
				if(prev!='.')
					temp++;
				prev=board[i-1][j];
				
			}
			
			j++;
		}
		if(prev!='.' &&prev!='\0')
			temp++;
		ans+=temp;
		
		//check for left
//		System.out.println(start_i+" "+end_i+" "+start_j+" "+end_j);
		i=start_i;
		j=start_j;
		prev='\0';
		temp=0;
		while(j>0 && i<=end_i)
		{
			if(prev=='\0')
			{
				prev=board[i][j-1];
			}
			else if(prev !=board[i][j-1])
			{
				if(prev!='.')
					temp++;
				prev=board[i][j-1];
				
			}
			
			i++;
		}
		if(prev!='.' &&prev!='\0')
			temp++;
		ans+=temp;
		
		//check for bottom
		i=end_i;
		j=start_j;
		temp=0;
		prev='\0';
		while(i<n-1 && j<=end_j)
		{
			if(prev=='\0')
			{
				prev=board[i+1][j];
			}
			else if(prev !=board[i+1][j])
			{
				if(prev!='.')
					temp++;
				prev=board[i+1][j];
				
			}
			
			j++;
		}
		if(prev!='.' &&prev!='\0')
			temp++;
		ans+=temp;
		
		//check for right
		i=start_i;
		j=end_j;
		prev='\0';
		temp=0;
		while(j<m-1 && i<=end_i)
		{
			if(prev=='\0')
			{
				prev=board[i][j+1];
			}
			else if(prev !=board[i][j+1])
			{
				if(prev!='.')
					temp++;
				prev=board[i][j+1];
				
			}
			
			i++;
		}
		if(prev!='.' &&prev!='\0')
			temp++;
		ans+=temp;
		
		System.out.println(ans);
		
//		for(i=0;i<n;i++)
//		{
//			for(j=0;j<m;j++)
//			{
//				System.out.print(board[i][j]+" ");
//			}
//			System.out.println();
//		}
		
	}//close main

}
