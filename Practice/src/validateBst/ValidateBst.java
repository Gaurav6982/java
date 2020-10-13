package validateBst;
class Node{
	int data;
	Node left,right;
	Node(int a){
		data=a;
		left=null;right=null;
	}
}
public class ValidateBst {
	 Node root=null;
	 public boolean check(Node root,int min,int max) {
		if(root==null) return true;
		if (root.data < min || root.data > max) 
            return false; 
		
		return check(root.left,min,root.data-1)&&check(root.right,root.data+1,max);
		
		 
		
	 }	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateBst tree=new ValidateBst();
		tree.root = new Node(4); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3); 
		
		System.out.println(tree.check(tree.root,Integer.MIN_VALUE,Integer.MAX_VALUE));

	}

}
