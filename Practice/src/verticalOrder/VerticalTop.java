package verticalOrder;

import java.util.*;
import java.util.Map.Entry;

class Node{
	int data;
	Node left;
	Node right;
	int hd;
	Node(int a)
	{
		data=a;
		left=null;
		right=null;
		hd=0;
	}
}
public class VerticalTop {
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
	public void inorder(Node root)
	{
		if(root==null)
			return ;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}
	
	public void levelOrder(Node root)
	{
		int h=height(root);
		int i;
		for(i=1;i<=h;i++)
		{
			printGivenOrder(root,i);
		}
		
	}
	public int height(Node root)
	{
		if(root==null)
			return 0;
		int lheight=height(root.left);
		int rheight=height(root.right);
		
		if(lheight>rheight)
			return lheight+1;
		else
			return rheight+1;
	}
	public void printGivenOrder(Node root,int level)
	{
		if(root==null)
			return;
		if(level==1)
		{
			System.out.print(root.data+" ");
		}
		else if(level>1)
		{
		printGivenOrder(root.left,level-1);
		printGivenOrder(root.right,level-1);
		}	
	}
	public void topview(Node root)
	{
		class QueueObj { 
            Node node; 
            int hd; 
  
            QueueObj(Node node, int hd) { 
                this.node = node; 
                this.hd = hd; 
            } 
        } 
        Queue<QueueObj> q = new LinkedList<QueueObj>(); 
        Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>(); 
  
        if (root == null) { 
            return; 
        } else { 
            q.add(new QueueObj(root, 0)); 
        } 
  
        System.out.println("The top view of the tree is : "); 
          
        // count function returns 1 if the container  
        // contains an element whose key is equivalent  
        // to hd, or returns zero otherwise. 
        while (!q.isEmpty()) { 
            QueueObj tmpNode = q.poll(); 
            if (!topViewMap.containsKey(tmpNode.hd)) { 
                topViewMap.put(tmpNode.hd, tmpNode.node); 
            } 
  
            if (tmpNode.node.left != null) { 
                q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1)); 
            } 
            if (tmpNode.node.right != null) { 
                q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1)); 
            } 
  
        } 
        for (Entry<Integer, Node> entry : topViewMap.entrySet()) { 
            System.out.print(entry.getValue().data); 
        }  
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,6,7};
		VerticalTop tree=new VerticalTop();
		root=tree.construct(arr, 0,root);
//		tree.inorder(root);
//		tree.levelOrder(root);
		tree.topview(root);
//		tree.verticalOrder(root);
	}

}
