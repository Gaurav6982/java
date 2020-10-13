class Node
{
	int data;
	Node left,right;
	
	Node(int data)
	{
		this.data=data;
		left=null;
		right=null;
	}
}
public class MinimalTree {
	static Node root;
	MinimalTree(){
		root=null;
	}
	void inorder()  { 
	       inorderRec(root); 
	    } 
	  
	    // A utility function to do inorder traversal of BST 
	    void inorderRec(Node root) { 
	        if (root != null) { 
	            inorderRec(root.left); 
	            System.out.println(root.data); 
	            inorderRec(root.right); 
	        } 
	    } 
	public Node make(int arr[]) {
		if(arr.length==0) return null;
		else return construct(arr,0,arr.length-1);
	}
	public Node construct(int[] arr,int l,int r) {
		if(l>r) return null;
		int mid=l+(r-l)/2;
		Node node=new Node(arr[mid]);
		node.left=construct(arr,l,mid-1);
		node.right=construct(arr,mid+1,r);
		return node;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,6};
//		System.out.println(arr.length);
//		for(int a:arr)
		MinimalTree tree=new MinimalTree();
		root=tree.make(arr);
		
//			System.out.println(a);
        tree.inorder(); 
	}

}
