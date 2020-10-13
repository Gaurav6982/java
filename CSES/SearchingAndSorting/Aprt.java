// import java.util.BufferedReader;
// import java.util.Arrays;
import java.io.*;
import java.util.*;
// import java.util.Random;
public class Aprt {
    public void shuffle(long arr[],int n){
        // Random r=new Random();
        for (int i = 0; i < n; i++) {
            int index=(int)Math.random()*n;
                long temp=arr[i];
                arr[i]=arr[index];
                arr[index]=temp;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] inputs = input.trim().split("\\s+");  
        int n=Integer.parseInt(inputs[0]);
        int m=Integer.parseInt(inputs[1]);        
        int k=Integer.parseInt(inputs[2]);
        long app[]=new long[n];
        long apar[]=new long[m];
        // boolean sorted_a=true;ss
        // boolean sorted_b=true;
        String ap = br.readLine(); 
        String[] appa = ap.trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            app[i]=Long.parseLong(appa[i]);
            // if(i>1 && app[i]<a/pp[i-1])
            // sorted_a=false;
        }
        String apa = br.readLine(); 
        String[] apara = apa.trim().split("\\s+");
        for (int i = 0; i < m; i++) {
            apar[i]=Long.parseLong(apara[i]);
            // if(i>1 && apar[i]<apar[i-1])
            // sorted_b=false;
        }              
        // if(!sorted_a)
        Aprt obj=new Aprt();
        obj.shuffle(app,n);  
        obj.shuffle(apar,m);  
        Arrays.sort(app);
        // if(!sorted_b)
        Arrays.sort(apar);
        int i=0,j=0;
        int ans=0;
        while(i<n && j<m)
        {
            if(Math.abs(apar[j]-app[i])<=k)
            {
                ans++;
                i++;
                j++;
            }
            else if(apar[j]<app[i]-k)
            j++;
            else if(apar[j]>app[i]+k)
            i++;
        }
        System.out.println(ans);
        br.close();
    }
}
