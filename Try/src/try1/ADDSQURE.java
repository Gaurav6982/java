package try1;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Arrays;
public class ADDSQURE {
    public static void solve(){
        Random sc=new Random();
        int w=sc.nextInt(10)+1;
        // int w=10;
        int h=sc.nextInt(10)+1;
        // int h=10;
        int n=sc.nextInt(w+1)+1;
        // int n=3;
        int m=sc.nextInt(h)+1;
        // int m=3;
        ArrayList<Integer> points_a=new ArrayList<>(n);
        ArrayList<Integer> points_b=new ArrayList<>(m);
        System.out.println(w+" "+h+" "+n+" "+m);
        HashSet<Integer> sides_a=new HashSet<>();
        HashSet<Integer> sides_b=new HashSet<>();
        HashSet<Integer> copy_sides_b=new HashSet<>();
        for (int i = 0; i < n; i++) {
            int temp=sc.nextInt(w);
            while(points_a.contains(temp))
            temp=sc.nextInt(w);
            points_a.add(temp);
        }
        for (int i = 0; i < m; i++) {
            int temp=sc.nextInt(h);
            while(points_b.contains(temp))
            temp=sc.nextInt(h);
            points_b.add(temp);
        }
        for (int i = 0; i < n; i++) {
            System.out.print(points_a.get(i)+" ");
        }
        System.out.println();
        for (int i = 0; i < m; i++) {
            System.out.print(points_b.get(i)+" ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int temp=Math.abs(points_a.get(i)-points_a.get(j));
                if(!sides_a.contains(temp))
                sides_a.add(temp);
            }
        }
        int already_generated[]=new int[h+1];
        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                int temp=Math.abs(points_b.get(i)-points_b.get(j));
                already_generated[temp]=1;
                if(!sides_b.contains(temp))
                {
                    sides_b.add(temp);
                    copy_sides_b.add(temp);
                }
            }
        }
        int ans=0;
        int temp_ans=0;
        Iterator<Integer> sides=copy_sides_b.iterator();
        
        while(sides.hasNext())
        {
            int temp=sides.next();
            if(sides_a.contains(temp))
            {
                sides_a.remove(temp);
                sides_b.remove(temp);
                ans++;
            }
        } 
        // Iterator<Integer> sides1=sides_a.iterator(); Iterator<Integer> sides2=sides_b.iterator();
        // while(sides1.hasNext())
        // {
        //     int tp=sides1.next();
        //     System.out.print(tp+" ");
        // }
        // System.out.println();
        // while(sides2.hasNext())
        // {
        //     int tp=sides2.next();
        //     System.out.print(tp+" ");
        // }
        // System.out.println();
        // for(int rl:already_generated)
        // System.out.print(rl+" ");
        // System.out.println();
        int line=0;
        for (int i = 0; i <= h; i++) {
            if(points_b.contains(i))
            continue;
            
            HashSet<Integer> copy=new HashSet<>();
            copy.addAll(sides_b);

            for (int j = 0; j < m; j++) {
                int temp=Math.abs(points_b.get(j)-i);
                if(already_generated[temp]!=1 && !copy.contains(temp))
                {
                    // sides_b.add(temp);
                    copy.add(temp);
                }
            }

            int temp=0;
            Iterator<Integer> it=sides_b.iterator();
            while(it.hasNext())
            {
                int el=it.next();
                if(sides_a.contains(el))
                temp++;
            }
            if(temp>temp_ans)
            {
                temp_ans=temp;
                line=i;
            }
            
            it=copy.iterator();
            while(it.hasNext())
            {
                int tem=it.next();
                sides_b.remove(tem);
            }
            
        }
        System.out.println(ans+" "+temp_ans);
        System.out.println("Line : "+line);
    }
    public static void main(String[] args) {
        solve();
        // Scanner sc=new Scanner(System.in);
        // int w=sc.nextInt();
        // int h=sc.nextInt();
        // int n=sc.nextInt();
        // int m=sc.nextInt();
        // ArrayList<Integer> points_a=new ArrayList<>(n);
        // ArrayList<Integer> points_b=new ArrayList<>(m);
        // // System.out.println(w+" "+h+" "+n+" "+m);
        // HashSet<Integer> sides_a=new HashSet<>();
        // HashSet<Integer> sides_b=new HashSet<>();
        // for (int i = 0; i < n; i++) {
        //     points_a.add(sc.nextInt());
        // }
        // for (int i = 0; i < m; i++) {
        //     points_b.add(sc.nextInt());
        // }
        // for (int i = 0; i < n; i++) {
        //     for (int j = i+1; j < n; j++) {
        //         int temp=Math.abs(points_a.get(i)-points_a.get(j));
        //         if(!sides_a.contains(temp))
        //         sides_a.add(temp);
        //     }
        // }
        // for (int i = 0; i < m; i++) {
        //     for (int j = i+1; j < m; j++) {
        //         int temp=Math.abs(points_b.get(i)-points_b.get(j));
        //         if(!sides_b.contains(temp))
        //         sides_b.add(temp);
        //     }
        // }
        // Iterator<Integer> ita=sides_a.iterator();
        // Iterator<Integer> itb=sides_b.iterator();
        // while(ita.hasNext())
        // System.out.println(ita.next()+" ");
        // System.out.println();
        // while(itb.hasNext())
        // System.out.println(itb.next()+" ");
        // System.out.println();
        // int ans=0;
        // for (int i = 1; i <= h; i++) {
        //     if(points_b.contains(i))
        //     continue;
            
        //     HashSet<Integer> copy=new HashSet<>();
        //     copy.addAll(sides_b);

        //     for (int j = 0; j < m; j++) {
        //         int temp=Math.abs(points_b.get(j)-i);
        //         if(!copy.contains(temp))
        //         copy.add(temp);
        //     }

        //     int temp=0;
        //     Iterator<Integer> it=copy.iterator();
        //     while(it.hasNext())
        //     {
        //         int el=it.next();
        //         if(sides_a.contains(el))
        //         temp++;
        //     }
        //     if(temp>ans)
        //     ans=temp;
        // }
        // System.out.println(ans);
        
        // sc.close();
    }
}
