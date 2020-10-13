package ancestor;

public class LeastCommonAncestor {
	Node root=null;
	public Node construct(int arr[],Node root,int i,int n) {
		if(i<n)
		{
			Node temp=new Node(arr[i]);
			root=temp;
			root.left=construct(arr,root.left,2*i+1,n);
			root.right=construct(arr,root.right,2*i+2,n);
		}
		return root;
	}
	public void inorder(Node root) {
		if(root==null)
			return;
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	public Node check(Node root,int a,int b) {
		if(root==null)
			return null;
		if(root.data==a||root.data==b)
			return root;
		Node left,right;
		left=check(root.left,a,b);
		right=check(root.right,a,b);
		
		if(left!=null &&right!=null)
			return root;
		else
			return left!=null?left:right;
		
	}
	public static void main(String[] args)
	{
		int arr[]= {1,2,3,4,5,6,7,8,90};
		LeastCommonAncestor tree=new LeastCommonAncestor();
		tree.root=tree.construct(arr,tree.root,0,arr.length);
		tree.inorder(tree.root);
		System.out.println();
		System.out.println(tree.check(tree.root,90,7).data);
	}
}
