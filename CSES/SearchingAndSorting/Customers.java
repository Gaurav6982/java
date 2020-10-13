import java.util.*;
import java.io.*;

public class Customers {
    static class Customer implements Comparable<Customer>{
        long arrival;
        boolean came;
        Customer(long a,boolean came)
        {
            this.arrival=a;
            this.came=came;
        }
        public int compareTo(Customer c)
        {
            return (int)(this.arrival-c.arrival);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line[]=br.readLine().trim().split("\\s+");
        int n=Integer.parseInt(line[0]);
        ArrayList<Customer> customs=new ArrayList<>(n);
        for(int i=0;i<n;i++)
        {
            line=br.readLine().trim().split("\\s+");
            long x=Long.parseLong(line[0]);
            long y=Long.parseLong(line[1]);
            customs.add(new Customer(x,true));
            customs.add(new Customer(y,false));
        }
        Collections.sort(customs);
        int ans=0;
        int temp=0;
        for(int i=0;i<customs.size();i++)
        {
            Customer c=customs.get(i);
            if(c.came) temp++;
            else temp--;
            ans=Math.max(ans,temp);
        }
        System.out.println(ans);
        br.close();
    }
}
