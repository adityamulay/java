
public class InorderSuccessor {
	
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

	public static Node leftMostNode( Node n)
	{
		while(n.left != null)
		{
			n=n.left;
		}
		return n;
	}
	
	public static Node rightMostNode( Node n)
	{
		while(n.right !=null)
		{
			n=n.right;
		}
		return n;
	
	}
	
	public static Node inordersuc(Node root, Node x)
	{
		if(root==null)return null;
		
		// Case1: If right child is not NULL 
	    if (x.right != null) 
	    { 
	        Node inorderSucc = leftMostNode(x.right); 
	        return inorderSucc; 
	    } 
	    
	    // Case2: If right child is NULL 
	    if (x.right == null) 
	    {     
	        
	        Node rightMost = rightMostNode(root); 
	  
	        // case3: If x is the right most node 
	        if (rightMost == x) 
	            return null; 
	        else
	        {
	        		System.out.println("Trying last option");
	        		Node n=new Node(-1);
	        		inorder(root, x, n);
	        		return n;
	        }
	    } 
	    return null;
		
	}
	
	public static void inorder (Node root, Node x, Node prev)
	{
		if(root==null)return ;
		
		//When found the node, mark it as prev
		if(root == x)
		{
			prev.data=x.data;
			return ;
		}
		inorder(root.left, x, prev);
		
		//When found the prev set, mark current node,which is the inorder succ, as the answer
		if(prev.data == x.data)
		{
			prev.data=root.data;
			return ;
		}
		
		//When answer is found, don't bother doing anything after
		if(prev.data != -1)
			return ;
		
		inorder(root.right, x, prev);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root=new Node(1);
		root.left=new Node(2);
		root.right=new Node(3);
		root.left.left=new Node(4);
		root.left.right=new Node(5);
		root.right.left=new Node(6);
		root.right.right=new Node(7);
		
		Node x=root.right.right;
		Node ans=inordersuc(root, x);
		if(ans == null)
			System.out.println("Inorder Successor of "+x.data+" is "+ans);
		else
			System.out.println("Inorder Successor of "+x.data+" is "+ans.data);

	}

}
