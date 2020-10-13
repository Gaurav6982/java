import java.util.HashSet;
import java.util.Scanner;
public class Distinct {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashSet<Long> hs=new HashSet<Long>();
        for (int i = 0; i < n; i++) {
            long temp=sc.nextLong();
            hs.add(temp);
        }
        System.out.println(hs.size());
        sc.close();
    }
}
