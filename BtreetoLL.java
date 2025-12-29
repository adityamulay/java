
public class BtreetoLL {

	static class node  
    { 
        int data; 
        node left, right; 
  
        public node(int data)  
        { 
            this.data = data; 
        } 
    } 
	
	static class nodepair
	{
		node head,prev;
		nodepair(node pHead, node pPrev)
		{
			head=pHead;
			prev=pPrev;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Let us create the tree shown in above diagram 
        node root = new node(10); 
        root.left = new node(12); 
        root.right = new node(15); 
        root.left.left = new node(25); 
        root.left.right = new node(30); 
        root.right.left = new node(36); 
  
        System.out.println("Inorder Tree Traversal"); 
        inorder(root); 
        node head=BinaryTree2DoubleLinkedList(root); 
  
        System.out.println("\nDLL Traversal"); 
        printlist(head); 
    } 
	
	static node BinaryTree2DoubleLinkedList(node root)  
    { 
        // Base case 
        if (root == null) 
            return null; 
        
        nodepair pair=new nodepair(null,null);
   
        // Recursively convert left subtree 
        BinaryTree2DoubleLinkedListUtil(root,pair);
        return pair.head;
        
    } 
	
	static void BinaryTree2DoubleLinkedListUtil(node root, nodepair pair)
	{
		if(root==null)return ;
		
		BinaryTree2DoubleLinkedListUtil(root.left,pair);

        // Now convert this node 
        if (pair.prev == null) {
        	 pair.head = root; 
        }
        else
        { 
            root.left = pair.prev; 
            pair.prev.right = root; 
        } 
        pair.prev = root; 
   
        BinaryTree2DoubleLinkedListUtil(root.right,pair); 
	}
    
    static void printlist(node root)  
    { 
        while (root != null)  
        { 
            System.out.print(root.data + " "); 
            root = root.right; 
        } 
    } 
  
    // Standard Inorder traversal of tree 
    static void inorder(node root)  
    { 
        if (root == null) 
            return; 
        inorder(root.left); 
        System.out.print(root.data + " "); 
        inorder(root.right); 
    } 


}
