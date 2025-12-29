

public class LCA {

	// Node class
    static class Node 
    {
        int data;
        Node left, right;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    };
    
    public static Node findLCA(Node n1, Node n2, Node root)
    {
    	//Check if both in the three
    	
    	if(root==null)return null;
    	if(root==n1 || root==n2)
    		return root;
    	
    	Node left=findLCA(n1, n2, root.left);
    	Node right=findLCA(n1,n2,root.right);
    	
    	if(left != null && right !=null) {
    		System.out.println(root.data);
    		return root;
    	}
    	else if(left != null) {
    		System.out.println(left.data);
    		return left;
    	}
    	else if(right != null) 
    	{
    		System.out.println(right.data);
		return right;
    	}
	return null;
    	
    }
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
		
		/* Constructed binary tree is
		        10
		      /   \
		    8      2
		  /         \
		3            90
		*/
		
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.right.right = new Node(90);
		
		Node result=findLCA(root.left,root.left.left,root);
		System.out.println(result.data);

	}

}
