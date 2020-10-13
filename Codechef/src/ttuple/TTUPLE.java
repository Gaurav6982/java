package ttuple;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class TTUPLE
{
     public static boolean check2(long from[],long to[],long diff[],float div[])
     {
        int first=0;
        int second=1;
        int third=2;
         int a=0;
         int b=1;
         int c=2;
         boolean jump=false;
         if(from[first]!=from[second])
         {
             a=0;
             b=1;
             c=2;
         }
         else if(from[first]!=from[third])
         {
             a=0;
             b=2;
             c=1;
         }
         else if(from[second]!=from[third])
         {
             a=1;
             b=2;
             c=0;
         }
         else{
             jump=true;
         }
         float x,y;
         if(!jump)
         {
            //  System.out.println("B "+b+" A "+a);
             x=(to[b]-to[a])/(from[b]-from[a]);
             y=to[a]-from[a]*x;
            //  System.out.println("X "+x+" Y "+y);
            if(x==(long)x && y==(long)y && y>0)
            {
                long temp=(long)(from[c]*x+y);
                if(temp==to[c])
                return true;
            }  
         }
             
            
            if(to[first]!=to[second])
         {
             a=0;
             b=1;
             c=2;
         }
         else if(to[first]!=to[third])
         {
             a=0;
             b=2;
             c=1;
         }
         else if(to[second]!=to[third])
         {
             a=1;
             b=2;
             c=0;
         }
         else
         {
             return false;
         }
            x=(from[b]*to[a]-to[b]*from[a])/(to[b]-to[a]);
            y=to[a]/(from[a]+x);
            // System.out.println("2 X "+x+" Y "+y);
            if(x==(long)x && y==(long)y &&x>0)
            {
                long temp=(long)((from[c]+x)*y);
                if(temp==to[c])
                return true;
            }
         
        return false;
     }
    public static boolean possible(long from[],long to[],long diff[],float div[],boolean status)
    {
        // if status == true means first add then multiply
        
        if(status)
        {
            int min_index=-1;
            for(int i=0;i<3;i++)
            {
                if(min_index==-1 || div[i]<div[min_index])
                min_index=i;
            }
            int first=-1;
            int second=-1;
            if(min_index==0)
            {
                first=1;
                second=2;
            }
            else if(min_index==1)
            {
                first=0;
                second=2;
            }
            else if(min_index==2)
            {
                first=0;
                second=1;
            }
            float a,b;
            a=((float)to[first]/to[min_index])*from[min_index]-from[first];
            b=((float)to[second]/to[min_index])*from[min_index]-from[second];
            if(a==(long)a && b==(long)b && a==b)
            return true;
            else
            return false;
            
        }
        else
        {
            int min_index=-1;
            for(int i=0;i<3;i++)
            {
                if(min_index==-1 || diff[i]<diff[min_index])
                min_index=i;
            }
            // System.out.println("Min INdex: "+min_index);
            int first=-1;
            int second=-1;
            if(min_index==0)
            {
                first=1;
                second=2;
            }
            else if(min_index==1)
            {
                first=0;
                second=2;
            }
            else if(min_index==2)
            {
                first=0;
                second=1;
            }
            float a,b;
            a=((float)(diff[first]-diff[min_index])/from[first]);
            b=((float)(diff[second]-diff[min_index])/from[second]);
            // System.out.println("a="+a+" b="+b);
            if(a==(long)a && b==(long)b &&a==b)
            return true;
            else
            return false;
        }
        // if status == false means first multiply then add
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t;
		t=sc.nextInt();
		while(t-->0)
		{
		    long ans=0;
		    long from[]=new long[3];
		    long to[]=new long[3];
		    long diff[]=new long[3];
		    float div[]=new float[3];
		    boolean less_than=false;
		    boolean less_in_negative=false;
		    
		  //  Input From tuple
		    boolean status=false;
		    for(int i=0;i<3;i++)
		    {
		        from[i]=sc.nextInt();
		        if(from[i]==0)
		        status=true;
		    }
		    
		  //  input to tuple
		    
		    for(int i=0;i<3;i++)
		    {
		        to[i]=sc.nextInt();
		        if(to[i]<from[i] && from[i]!=0)
		        {
		           less_than=true;
		           from[i]=0;
		        }
		    }
		  //  for(int i=0;i<3;i++)
		  //  {
		  //      System.out.println("From "+from[i]+"To "+to[i]);
		  //  }
		  //  Check if we have to multiply by zero or first zero then add 1
		    
		    if(less_than) ans++;
		    if(less_in_negative) ans++;
		    
		    //form diff and div array
		    int count_zero=0;
		    for(int i=0;i<3;i++)
		    {
		        diff[i]=to[i]-from[i];
		        
		        if(to[i]<0 && from[i]==0)
		        diff[i]=1;
		        if(less_in_negative && diff[i]==1)
		        {
		            diff[i]=0;
		            from[i]=to[i];
		        }
		        if(diff[i]==0)
		        count_zero++;
		        if(from[i]!=0)
		        div[i]=(float)to[i]/from[i];
		        else
		        div[i]=Long.MAX_VALUE;
		      //  if(from[i]==0 &&)
		      //  System.out.println("Diff "+diff[i]+" Div "+div[i]);
		    }
		    if(count_zero==3)
		    {
		        System.out.println(0);
		        continue;
		    }
		    int same_in_diff=0;
		    int same_in_div=0;
		    
		    // Check if Some Pair is same or not to minimise moves.
		    
		    for(int i=0;i<3;i++)
		    {
		        for(int j=i+1;j<3;j++)
		        {
		            if(diff[i]==diff[j] && diff[i]!=0)
		            same_in_diff++;
		            if(div[i]==(long)div[j] &&div[i]!=1f && div[i]!=Long.MAX_VALUE )
		            same_in_div++;
		        }
		    }
		  //  System.out.println("Count "+count_zero);
		    int a=0;
		    if(same_in_diff==3 || same_in_div==3)
		    a=1;
		    else if(same_in_diff==1 || same_in_div==1)
		    a=2;
		    else if(same_in_diff==0 || same_in_div==0)
		    {
		        if((count_zero==0 && check2(from,to,diff,div)))
		        {
		           a=2;
		          // System.out.println("in 1");
		        }
		        else if( possible(from,to,diff,div,status))
		        {
		            a=2;
		          //  System.out.println("in 2");     
		        }
		        else
		        a=3;
		    }
		  //  System.out.println(status);
		  //  System.out.println("Same in Diff: "+same_in_diff+" Same in DIv: "+same_in_div);
		  //  System.out.println(ans+" "+a+" "+count_zero);
		    System.out.println(ans+a-count_zero);
		    
		}
		sc.close();
		
	}
}
