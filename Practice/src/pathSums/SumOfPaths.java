package pathSums;

import java.util.Stack;

class Node{
	int data;
	Node left,right=null;
	Node(int a){
		data=a;
		left=null;
		right=null;
	}
}
public class SumOfPaths {
	static Node root=null;
	static Node construct(int[] arr,int l,int r) {
//		if(root==null) return  null;
		if(l>r) return null;
		
			int mid=l+(r-l)/2;
			Node temp=new Node(arr[mid]);
			temp.left=construct(arr,l,mid-1);
			temp.right=construct(arr,mid+1,r);
		return temp;
	}
	static void inorder(Node root)
	{
		if(root==null) return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
//	static int sum=0;
	
	static void paths(Node root,int sum,int k,Stack<Integer> st) {
		if(root==null) return;
//		Stack<Integer> st=new Stack<Integer>();
		
//		Stack<Integer> temp = new Stack<Integer>();
		sum+=root.data;
		st.push(root.data);
		if(sum==k)
		{
			
			System.out.println();
			while(st.size()>0)
			{
				System.out.print(st.pop()+" ");
				
			}
			
		}
		paths(root.left,sum,k,st);
		paths(root.right,sum,k,st);
		sum-=root.data;
		if(!st.isEmpty())
			st.pop();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {1,2,3,4,5,6,7};
//		SumOfPaths tree=new SumOfPaths();
		root=construct(arr,0,arr.length-1);
//		System.out.println(root.data);
		Stack<Integer> stack = new Stack<Integer>();
		inorder(root);
		paths(root,0,17,stack);
	}

}
