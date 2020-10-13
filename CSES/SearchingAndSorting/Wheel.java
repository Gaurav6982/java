import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Wheel {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line[]=br.readLine().trim().split("\\s+");
        int n=Integer.parseInt(line[0]);
        int x=Integer.parseInt(line[1]);
        line=br.readLine().trim().split("\\s+");
        Long arr[]=new Long[n];
        for (int i = 0; i < line.length; i++) {
            arr[i]=Long.parseLong(line[i]);
        }
        Arrays.sort(arr);
        int start=0;
        int end=n-1;
        int ans=0;
        while(start<=end)
        {
            if(arr[start]+arr[end]<=x)
            {
                start++;
                end--;
            }
            else
            {
                end--;
                
            }
            ans++;
        }
        System.out.println(ans);
        br.close();
    }    
}
