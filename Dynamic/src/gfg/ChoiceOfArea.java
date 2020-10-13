package gfg;
import java.util.Scanner;
public class ChoiceOfArea {
    public static int find(int a,int b,int pos)
    {
        if(a<=0 || b<=0)
        return 0;
        int x=0,y=0;
        if(pos==0)
        {
            x=find(a-5,b-10,1);
            y=find(a-20,b+5,2);
        }
        else if(pos==1)
        {
            x=find(a+3,b+2,0);
            y=find(a-20,b+5,2);

        }
        else if(pos==2){
            x=find(a-5,b-10,1);
            y=find(a+3,b+2,0);
        }
        return 1+Math.max(x,y);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int x=find(a,b,0);
        int y=find(a,b,1);
        int z=find(a,b,2);
        System.out.println(x+" "+y+" "+z);
        System.out.println(Math.max(x,Math.max(y,z)));
        sc.close();
    }  
}
