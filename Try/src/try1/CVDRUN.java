package try1;
import java.util.Scanner;
import java.util.Random;
public class CVDRUN {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random r=new Random();
        int t=r.nextInt(50)+1;
        System.out.println(t);
        System.out.println("------------------");
		while(t-->0)
		{
		    int n=r.nextInt(10)+1;
		    int j=r.nextInt(n);
		    int c=r.nextInt(n);
            int i=r.nextInt(n);
            while(j!=0 && n%j!=0)
            j=r.nextInt(n);
            System.out.println("n : "+n);
            System.out.println("j : "+j);
            System.out.println("c : "+c);
            System.out.println("i : "+i);
            if(j==0)
            {
                if(c==i)
		        System.out.println("YES");
		        else
		        System.out.println("NO");
            }
		    else if(n%j==0)
		    {
		        if((Math.abs(i-c))%j==0)
		        System.out.println("YES");
		        else
		        System.out.println("NO");
		    }
		    else
            System.out.println("YES");
            
            System.out.println("=========================");
		}
		sc.close();
    }
}
