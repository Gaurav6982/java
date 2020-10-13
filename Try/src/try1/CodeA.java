package try1;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class CodeA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int n=sc.nextInt();
			int m=sc.nextInt();
			Map<Integer,Integer> arr1=new HashMap<>();
			Map<Integer,Integer> arr2=new HashMap<>();
			for(int i=0;i<n;i++)
			{
				int x=sc.nextInt();
				if(arr1.containsKey(x))
				{
					arr1.put(x,arr1.get(x)+1);
				}
				else
				{
					arr1.put(x,1);
				}
			}
			int check=0;
			for(int i=0;i<m;i++)
			{
				int x=sc.nextInt();
				if(arr2.containsKey(x))
				{
					arr2.put(x,arr2.get(x)+1);
				}
				else
				{
					arr2.put(x,1);
				}
				if(arr1.containsKey(x) && check==0)
					check=x;
				
			}
			if(check==0)
				System.out.println("NO");
			else
			{
				System.out.println("YES");
				System.out.println("1 "+check);
			}
		}
		sc.close();
	}	

}
