package try1;
    import java.util.Random;
class CHEFEZQ{
    public static void main(String[] args) {
        // Scanner sc=new Scanner(System.in);
        Random sc=new Random();
        int t=sc.nextInt(10)+1;
        System.out.println(t);
        System.out.println("---------------------");
	    while(t-->0)
	    {
	        int n=sc.nextInt(10)+1;
            long k=sc.nextInt(10)+1;
            System.out.println("n : "+n);
            System.out.println("k : "+k);
	        int arr[]=new int[n];
	        long sum=0;
            long temp=-1;
            boolean flag=true;
	        for(int i=0;i<n;i++)
	        {
	            arr[i]=sc.nextInt(10);
	            sum=sum+arr[i]-k;
                if(sum<0 && flag)
                {
                    temp=i;
                    flag=false;
                }
                // System.out.println("sum "+sum);
            }
            for(int i=0;i<n;i++)
	        {
	        System.out.print(arr[i]+" ");
            }
            System.out.println();
            if(temp==-1)
            temp=n+sum/k;
            System.out.println(temp+1);
            System.out.println("=========================");
	       // int day=1;
	       // long curr_queries=0;
	       // int i=0;
	       // do
	       // {
	       //     curr_queries+=arr[i];
	       //     curr_queries=curr_queries-k;
	       //     i++;
	       // } while(i<n&&curr_queries+arr[i]>=k);
	       // while(curr_queries>0)
	       // {
	       //     curr_queries-=k;
	       //     i++;
	       // }
	       // System.out.println(i+1);
	        
	    }

    }
}