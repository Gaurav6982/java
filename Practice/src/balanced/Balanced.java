package balanced;
import java.lang.Math;

class Node{
	int data;
	Node left,right;
	int height=0;
	Node(int a){
		data=a;
		left=null;
		right=null;
	}
}
public class Balanced {
	Node root;
	public Node MakeTree(int arr[],Node root,int i,int n) {
//		if(root==null)
		if(i<n)
		{
			Node temp=new Node(arr[i]);
			root=temp;
			root.left=MakeTree(arr,root.left,2*i+1,n);
			root.right=MakeTree(arr,root.right,2*i+2,n);
		}
		return root;
	}
	public void inOrder(Node root)
	{
		if(root==null) return;
		inOrder(root.left);
		System.out.println(root.data+" "+root.height);
		inOrder(root.right);
	}
	public int height(Node root) {
		if(root==null)return 0;
		
		int lheight=height(root.left);
		int rheight=height(root.right);
		root.height=Math.abs(lheight-rheight);
//		if(root.height>1)
//			System.out.println("not balanced");
		if(lheight>rheight)
			return lheight+1;
		else
			return rheight+1;
		}
	public boolean CheckBalanced(Node root)
	{
		if(root==null) return true;
		if(root.height>1)
			return false;
		CheckBalanced(root.left);
		CheckBalanced(root.right);
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5};
		Balanced tree=new Balanced();
		tree.root=tree.MakeTree(arr,tree.root,0,arr.length);
//		tree.root=new Node(1);
//		tree.root.left=new Node(2);
//		tree.root.left.left=new Node(3);
		System.out.println("height="+tree.height(tree.root));
		tree.inOrder(tree.root);
		if(tree.CheckBalanced(tree.root))
		System.out.println("Tree is Balanced");
		else
			System.out.println("Tree is Not Balanced");
		
	}

}
