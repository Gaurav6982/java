package try1;
import java.util.*;
import java.io.*;

class cehck{
    public static boolean check(int[] stops,int tank){
        for(int i=1;i<stops.length;i++)
        {
            if(stops[i]-stops[i-1]>tank)
            return true;
        }
        return false;

    }
    public static int computeMinRefills(int dist, int m, int[] stops) {
        if(check(stops,m))
        return -1;
        int travelled=0;
        int ans=0;
        int n=stops.length;
        int temp=travelled+m;
        for(int j=0;j<n;j++)
        {
            if(temp>=dist)
            return ans+1;
            if(j==n-1)
            {
                ans++;
                break;
            }
            if(stops[j]<temp)
            continue;
            travelled=stops[j-1];
            ans++;
            temp=travelled+m;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
        scanner.close();
    }
}
