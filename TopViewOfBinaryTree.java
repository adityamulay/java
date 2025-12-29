import java.util.*;

/**
 * 
 */

/**
 * @author adityamulay
 *
 */

 

public class TopViewOfBinaryTree {

	static class Node { 
	    int data; 
	    Node left, right; 
	  
	    public Node(int data) { 
	        this.data = data; 
	        left = right = null; 
	    } 
	} 
	
	static class QNode {
	
		Node node;
		int level;
		
		public QNode(Node n, int l) {
			this.node =n;
			this.level=l;
		}
	}
	
	Node root;
	
	public TopViewOfBinaryTree() { 
        root = null; 
    }
	

	public void TopView(Node root) {
		
		TreeMap<Integer, Integer> levelMap = new TreeMap<Integer, Integer>();
		Queue<QNode> q = new LinkedList<QNode>();
		
		if(root == null)
			return;
		
		q.add(new QNode(root,0));
		levelMap.put(0, root.data);
		
		while(!q.isEmpty()) {
			
			int size = q.size();
			
			for (int i=0; i<size;i++) {
				QNode qnode = q.poll();
				
				if( !levelMap.containsKey(qnode.level)) {
					levelMap.put(qnode.level, qnode.node.data);
				}
				
				if(qnode.node.left != null) {
					q.offer(new QNode(qnode.node.left, qnode.level-1));
				}
				
				if(qnode.node.right != null) {
					q.offer(new QNode(qnode.node.right, qnode.level+1));
				}
				
			}
		}
		
		for(Map.Entry<Integer, Integer> entry : levelMap.entrySet()) {
			System.out.println(entry.getValue());
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TopViewOfBinaryTree tree = new TopViewOfBinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.right = new Node(4); 
        tree.root.left.right.right = new Node(5); 
        tree.root.left.right.right.right = new Node(6); 
        System.out.println("Following are nodes in top view of Binary Tree");  
        tree.TopView(tree.root);

	}

}
