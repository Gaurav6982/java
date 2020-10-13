package subtree;
class Node{
	int data;
	Node left,right;
	Node(int a){
		data=a;
		left=null;
		right=null;
	}
}
public class SubTree {
	Node root1,root2=null;
	Node construct(int arr[],Node root,int i,int n) {
		if(i<n)
		{
			Node temp=new Node(arr[i]);
			root=temp;
			root.left=construct(arr,root.left,2*i+1,n);
			root.right=construct(arr,root.right,2*i+2,n);
		}
		return root;
	}
	void inorder(Node root) {
		if(root==null) return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	boolean checkforSame(Node root1,Node root2)
	{
		if(root1==null && root2==null)
			return true;
		if(root1==null || root2==null)
			return false;
		if(root1.data==root2.data && checkforSame(root1.left,root2.left)&& checkforSame(root1.right,root2.right))
			return true;
		return false;
	}
	boolean checkforSubTree(Node root1,Node root2)
	{
		if(root1==null && root2==null)
			return true;
		if(root1==null)
			return true;
		if(root2==null)
			return false;
		if(checkforSame(root1,root2))
		{
			return true;
		}
		return checkforSubTree(root1,root2.left)||checkforSubTree(root1,root2.right);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubTree tree=new SubTree();
		int[] arr2= {1,2,3,4,5};
		int[] arr= {2,4,5};
		
		tree.root1=tree.construct(arr,tree.root1,0,arr.length);
		tree.root2=tree.construct(arr2,tree.root2,0,arr2.length);
		tree.inorder(tree.root1);
		System.out.println(tree.checkforSame(tree.root1, tree.root2));
		String ans;
		if(tree.checkforSubTree(tree.root1,tree.root2))
		ans="Tree 1 is SubTree of Tree 2";
		else
			ans="Tree 1 is not SubTree of Tree 2";
		System.out.println(ans);
	}

}
