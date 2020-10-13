package practice;
import java.util.Scanner;
import java.lang.Character;
public class DigitGame {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int n=sc.nextInt();
            char[] arr=sc.next().toCharArray();
            // int count_even_on_odd_pos=0;
            int count_odd_on_odd_pos=0;
            int count_even_on_even_pos=0;
            // int count_odd_on_even_pos=0;
            for(int i=0;i<arr.length;i++)
            {
                if((i+1)%2!=0)
                {
                    if(Character.getNumericValue(arr[i])%2!=0)
                    // count_even_on_odd_pos++;
                    // else
                    count_odd_on_odd_pos++;
                }
                else
                {
                    if(Character.getNumericValue(arr[i])%2==0)
                    count_even_on_even_pos++;
                    // else
                    // count_odd_on_even_pos++;
                }
            }
            if(n%2==0)
            {
                if(count_even_on_even_pos>0)
                System.out.println(2);
                else
                System.out.println(1);
            }
            else
            {
                if(count_odd_on_odd_pos>0)
                System.out.println(1);
                else
                System.out.println(2);
            }

            // System.out.println(count_even_on_even_pos+" "+count_even_on_odd_pos+" "+count_odd_on_even_pos+" "+count_odd_on_odd_pos);
        }
        sc.close();
    }
}
