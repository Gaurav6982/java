package verticalOrder;

public class verticalOrder {
	static Node root=null;
	static int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
	public void findMinMax(Node root,int hd)
	{
		if(root==null)
			return;
		if(hd<min)
			min=hd;
		if(hd>max)
			max=hd;
		
		findMinMax(root.left,hd-1);
		findMinMax(root.right,hd+1);
					
	}
	public void vertical(Node root) {
		findMinMax(root,0);
		int i;
		for(i=min;i<=max;i++)
		{
			printGivenVertical(root,i,0);
		}
	}
	public void printGivenVertical(Node root,int line_no,int hd)
	{
		if(root==null)
			return;
		if(hd==line_no)
			System.out.print(root.data+" ");
		printGivenVertical(root.left,line_no,hd-1);
		printGivenVertical(root.right,line_no,hd+1);
	}
	
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,6,7};
		verticalOrder tree=new verticalOrder();
		root=tree.construct(arr, 0,root);
//		tree.inorder(root);
//		tree.levelOrder(root);
//		tree.topview(root);
		tree.vertical(root);
	}

}
