package ancestor;
class Node{
	int data;
	Node left,right;
	Node(int a){
		data=a;
		left=null;
		right=null;
	}
}
class BinarySearchTree{
	Node root=null;
	public Node construct(int[] arr,int start,int end) {
		if(arr.length==0) return null;
		if(start>end)return null;
		int mid=start+(end-start)/2;
		Node temp=new Node(arr[mid]);
		
		temp.left=construct(arr,start,mid-1);
		temp.right=construct(arr,mid+1,end);
		return temp;
	}
}
public class InOrderSuccessor {
	public static void inorder(Node root) {
		if(root==null)return;
				inorder(root.left);
				System.out.println(root.data+" ");
				inorder(root.right);
	}
	public static int inorderSuccessor(Node root,int a) {
		
		Node temp=root;
		while(temp.data!=a)
		{
			if(a<temp.data)
				temp=temp.left;
			else
				temp=temp.right;
		}
		
		if(temp.right!=null)
		{
			temp=temp.right;
			while(temp.left!=null)
			{
				temp=temp.left;
			}
			return temp.data;
		}
		else
		{
			Node store=root;
			temp=root;
			while(a!=temp.data)
			{
				if(a<temp.data)
				{
					store=temp;
					temp=temp.left;
				}
				else
				{
					temp=temp.right;
				}
			}
			return store.data;
		}
	}
	public static int inorderPredecesor(Node root,int a) {
		Node temp=root;
		Node store_left=root,store_right=root;
		while(temp.data!=a)
		{
			if(a<temp.data)
			{
				store_left=temp;
				temp=temp.left;	
			}
			else
			{
				store_right=temp;
				temp=temp.right;
			}
				
		}
		if(temp.left!=null)
		{
			temp=temp.left;
			while(temp.right!=null)
				temp=temp.right;
			return temp.data;
		}
		else
		{
			return store_right.data;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree tree=new BinarySearchTree();
		int arr[]= {1,2,3,4,5,6,7,8,9};
		tree.root=tree.construct(arr,0,arr.length-1);
//		inorder(tree.root);
		System.out.println(inorderSuccessor(tree.root,6));
		System.out.println(inorderPredecesor(tree.root,5));
	}

}
