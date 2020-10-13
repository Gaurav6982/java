import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Concert {
    public static int find(ArrayList<Long> tickets,long mrp)
    {
        int mid=-1;
        int start=0;
        int end=tickets.size()-1;
        int candidate=-1;
        while(start<=end)
        {
            if(tickets.get(end)<=mrp)
            {
                candidate=end;
                break;
            }
            if(tickets.get(start)>mrp)
            {
                candidate=start-1;
                break;
            }
            start++;
            end--;
        }
        return candidate;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line[]=br.readLine().trim().split("\\s+");
        int n=Integer.parseInt(line[0]);
        int m=Integer.parseInt(line[1]);
        line=br.readLine().trim().split("\\s+");
        ArrayList<Long> tickets=new ArrayList<Long>(n);
        for (int i = 0; i < n; i++) {
            tickets.add(Long.parseLong(line[i]));
        }
        Collections.sort(tickets);
        Long customs[]=new Long[m];
        line=br.readLine().trim().split("\\s+");
        for (int i = 0; i < m; i++) {
            customs[i]=Long.parseLong(line[i]);
        }
        StringBuilder s=new StringBuilder();
        for (int i = 0; i < customs.length; i++) {
            if(tickets.size()>0  && customs[i]<tickets.get(0))
            {
                s.append(-1).append("\n");
                continue;
            }
            int index=find(tickets,customs[i]);
            if(index!=-1)
            {
                Long ans=tickets.get(index);
                s.append(ans).append("\n");
//                System.out.println();
                tickets.remove(index);
            }
            else{
                s.append(-1).append("\n");
            }
        }
        System.out.println(s);
        br.close();
    }
}
