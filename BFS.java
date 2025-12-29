import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
	
	
	static int numVertices;
	static HashMap<Integer,Node> hm=new HashMap<Integer,Node>();
	
	static class Node
	{
		private int id;
		private LinkedList<Node> adj;
		
		Node(int a){
			id=a;
			adj=new LinkedList<Node>();
		}
		
		public int getid() {
			return id;
		}
		public LinkedList<Node> getadjList(){
			return adj;
		}
	}
	
	public static void addEdge(Node a, Node b)
	{
		a.getadjList().add(b);
		
	}

	
	public static void bfs (Node n)
	{
		Queue<Node> q=new LinkedList<Node>();
		q.add(n);
		
		HashSet<Node> visited=new HashSet<Node>();
		visited.add(n);
		
		while(!q.isEmpty()) {
			Node temp=q.remove();
			System.out.println(temp.getid());
			
			Iterator<Node> it=temp.getadjList().listIterator();
			while(it.hasNext()) {
				Node qnode=it.next();
				if(!visited.contains(qnode)) {
					q.add(qnode);
					visited.add(qnode);
				}
				
			}
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
        BFS graph = new BFS();
        Node z= new Node(0);
        Node a=new Node(1);
        Node b=new Node(2);
        Node c=new Node(3);
        Node d=new Node(4);
        
        addEdge(z, a);
        addEdge(z, d);
        addEdge(a, b);
        addEdge(a, c);
        addEdge(a, d);
        addEdge(b, c);
        addEdge(c, d);
      
        // print the adjacency list representation of 
        // the above graph
        //printGraph();
        bfs(z);

	}

}

