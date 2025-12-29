import java.util.Stack;

public class Trees {
	
	Node root;
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node(int x){
			this.data=x;
			this.left=null;
			this.right=null;
		}
	}
	public static int heightOfTree(Node n)
	{
		if(n==null)
			return -1;
		
		int height=Math.max(heightOfTree(n.left),heightOfTree(n.right))+1;
		return height;
	}

	
	public static void flattenTree(Node root)
	{
		if(root==null || (root.left==null && root.right==null))return;
		
		flattenTree(root.left);
		Node right=root.right;
		root.right=root.left;
		root.left=null;
		
		while(root.right!=null) {
			root=root.right;
		}
		root.right=right;
		flattenTree(root.right);
	}
	
	public static void inOrder(Node root)
	{
		if(root==null)return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	
	public static void inOrderIterative(Node root)
	{
		System.out.println("\nPrinting inorder iteratively : ");
		if(root==null)return;
		Stack<Node> stack=new Stack<>();
		while(root!=null || !stack.isEmpty())
		{
			while(root!=null)
			{
				stack.push(root);
				root=root.left;
			}
			root =stack.pop();
			System.out.print(root.data+" ");
			
			root=root.right;
			
			
		}
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		Trees tree=new Trees();
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		
		
		
		tree.root=root;
		
		int height=heightOfTree(root);
		System.out.println("Height of the tree is : "+height);
		
		inOrderIterative(root);
		
		flattenTree(root);
		
		System.out.println("\n\nPrinting inorder recursively : ");
		inOrder(root);
		
		

	}

}
