package try1;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.LinkedList;
public class Code_MISSING_POINT {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			Map<Integer,Integer> row_map=new HashMap<>();
			Map<Integer,Integer> col_map=new HashMap<>();
			Queue<Integer> row_q=new LinkedList<>();
			Queue<Integer> col_q=new LinkedList<>();
			Map<Integer,Boolean> in_row_queue=new HashMap<>();
			Map<Integer,Boolean> in_col_queue=new HashMap<>();
			int ans_x=0;
			
			int ans_y=0;
			for(int i=0;i<(4*n-1);i++)
			{
				int x=sc.nextInt();
				int y=sc.nextInt();
				
				if(row_map.containsKey(x))
				{
					int value=row_map.get(x)+1;
					row_map.replace(x,value);
				}
				else
				{
					row_map.put(x,1);
					in_row_queue.put(x,false);
				}
				
				if(!in_row_queue.get(x)&&row_map.get(x)%2!=0)
				{
					row_q.add(x);
					in_row_queue.replace(x,true);
				}
				
				if(!row_q.isEmpty()&&row_map.get(row_q.peek())%2==0)
				{
					in_row_queue.put(row_q.peek(),false);
					row_q.remove();
				}
				else if(!row_q.isEmpty())
					ans_x=row_q.peek();
					
				
				if(col_map.containsKey(y))
				{
					int value=col_map.get(y)+1;
					col_map.replace(y,value);
				}
				else
				{
					col_map.put(y,1);
					in_col_queue.put(y,false);
				}
				
				if(!in_col_queue.get(y)&&col_map.get(y)%2!=0)
				{
					col_q.add(y);
					in_col_queue.replace(x,true);
				}
					
				if(!col_q.isEmpty()&&col_map.get(col_q.peek())%2==0)
				{
					in_col_queue.put(col_q.peek(),false);
					col_q.remove();
				}
				else if(!row_q.isEmpty())
					ans_y=col_q.peek();
			}
// 			for(Map.Entry<Integer,Integer> entry:row_map.entrySet())
// 			{
// 			    System.out.println(entry.getKey()+" "+entry.getValue());
// 			}
// 			System.out.println("=====================");
// 			for(Map.Entry<Integer,Integer> entry:col_map.entrySet())
// 			{
// 			    System.out.println(entry.getKey()+" "+entry.getValue());
// 			}
			if(row_map.get(ans_x)%2==0)
			{
			 //   System.out.println("row");
				while(row_q.size()!=0&&row_map.get(row_q.peek())%2==0)
				{
					ans_x=row_q.remove();
				}
			    ans_x=row_q.remove();
				
			}
			if(col_map.get(ans_y)%2==0)
			{
			 //   System.out.println("col");
				while(col_q.size()!=0&&col_map.get(col_q.peek())%2==0)
				{
					ans_y=col_q.remove();
				}
				ans_y=col_q.remove();
			}
			System.out.println(ans_x+" "+ans_y);
		}
		sc.close();
	}

}
