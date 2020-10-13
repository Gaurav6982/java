package youtube;
import java.io.*;;
public class RodCutting {
	public static int cutting(int length[],int price[],int n,int l)
	{
		if(n==0)
			return 0;
		if(l+length[n-1]<8)
		{
			return Math.max(price[n-1]+cutting(length,price,n,l+length[n-1]),cutting(length,price,n-1,l));
		}
		return cutting(length,price,n-1,l);
	}
	public static void main(String args[]) {
		int length[]= {1,2,3,4,5,6,7,8};
		int n=length.length;
		int price[]= {1,5,8,9,10,17,17,20};
		System.out.println(cutting(length,price,n,0));
	}
}
