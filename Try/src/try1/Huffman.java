package try1;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Scanner;
class HuffmanNode implements Comparable<HuffmanNode>{
    int data;
    char s;

    HuffmanNode left;
    HuffmanNode right;
    public HuffmanNode(char s,int data){
        this.data=data;
        this.s=s;
    }
    
    public HuffmanNode() {
    }

    public int compareTo(HuffmanNode h) {
        return this.data-h.data;
    }
}
public class Huffman{
    public static void printCode(HuffmanNode root,String s){
        if(root.left==null &&root.right==null && Character.isLetter(root.s))
        {
            System.out.println(root.s+" "+s);
            return;
        }

        printCode(root.left,s+"0");
        printCode(root.right,s+"1");
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n = 6; 
        char[] charArray = {  'b','a', 'c', 'd', 'e', 'f' }; 
        int[] charfreq = { 9,5, 12, 13, 16, 45 }; 
        PriorityQueue<HuffmanNode> q=new PriorityQueue<>(n);
        for(int i=0;i<n;i++)
        {
            HuffmanNode f=new HuffmanNode(charArray[i],charfreq[i]);

            f.left=null;
            f.right=null;
            q.add(f);
        }
        // Iterator<HuffmanNode> i=q.iterator();
        // while(i.hasNext())
        // System.out.println(i.next().data);
        HuffmanNode root=null;
        while(q.size()>1)
        {
            HuffmanNode x=q.peek();
            q.poll();
            HuffmanNode y=q.peek();
            q.poll();
            HuffmanNode newnode=new HuffmanNode();
            // System.out.println(newnode);
            newnode.s='-';
            newnode.data=x.data+y.data;
            newnode.left=x;
            newnode.right=y;
            root=newnode;
            q.add(newnode);
        }
        printCode(root,"");
        sc.close();
    }
}