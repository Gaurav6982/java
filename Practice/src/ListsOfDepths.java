import java.util.LinkedList;

public class ListsOfDepths {
	Node root=null;
	static LinkedList<Integer>[] ar;
	void levelOrder() {
		int h=height(root);
		ar=new LinkedList[h];
		for(int i=0;i<h;i++)
		{
			ar[i]=new LinkedList<Integer>();
		}
		for(int i=1;i<=h;i++)
		{
			givenOrder(root,i,ar[i-1]);
		}
			
	}
	int height(Node root) {
		if(root==null)return 0;
		int lheight=height(root.left);
		int rheight=height(root.right);
		if(lheight>rheight)
			return lheight+1;
		else
			return rheight+1;
	}
	void givenOrder(Node root,int level,LinkedList<Integer> l) {
		if(root==null) return;
		if(level==1) l.add(root.data);
		else
		{
			givenOrder(root.left,level-1,l);
			givenOrder(root.right,level-1,l);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListsOfDepths tree = new ListsOfDepths(); 
	       tree.root= new Node(1); 
	       tree.root.left= new Node(2); 
	       tree.root.right= new Node(3); 
	       tree.root.left.left= new Node(4); 
	       tree.root.left.right= new Node(5);
	       tree.root.right.left= new Node(6); 
	       tree.root.right.right= new Node(7);
	       
	       tree.levelOrder();
	       for(LinkedList<Integer> l:ar)
	       System.out.println(l.toString());
	}

}
