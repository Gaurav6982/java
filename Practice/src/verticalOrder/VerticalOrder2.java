package verticalOrder;
import java.util.*;
import java.util.Map.Entry;
public class VerticalOrder2 {
	static Node root=null;
	public Node construct(int arr[],int i,Node root)
	{
		if(i<arr.length)
		{
			root= new Node(arr[i]);
			root.left=construct(arr,2*i+1,root.left);
			root.right=construct(arr,2*i+2,root.right);
		}
		return root;
	}
	public void getvertical(Node root,int hd,Map<Integer,Vector<Integer>> m)
	{
		if(root==null)
			return;
		Vector<Integer> get=m.get(hd);
		if(get==null)
		{
			get=new Vector<>();
			get.add(root.data);
		}
		else
			get.add(root.data);
		
		m.put(hd,get);
		
		getvertical(root.left,hd-1,m);
		getvertical(root.right,hd+1,m);
			
					
	}
	public void printvertical(Node root)
	{
		Map<Integer,Vector<Integer>> m=new TreeMap<>();
		getvertical(root,0,m);
		
		for (Entry<Integer, Vector<Integer>> entry : m.entrySet()) 
        { 
            System.out.println(entry.getValue()); 
        } 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,6,7};
		VerticalOrder2 tree=new VerticalOrder2();
		root=tree.construct(arr, 0,root);
//		tree.inorder(root);
//		tree.levelOrder(root);
//		tree.topview(root);
		tree.printvertical(root);
	}

}
