package practice;
import java.util.*;
public class A5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s;
		int ans=0;
		int c=0;
		while (sc.hasNextLine()) {
			s = sc.nextLine();
			if (s.charAt(0) == '+') 
				c++;
			else if (s.charAt(0) == '-')
				c--;
			else {
				ans += c*(s.length() - s.indexOf(':') - 1);
			}
		}
		System.out.println(ans);
		sc.close();
	}

}
