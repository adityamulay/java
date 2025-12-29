import java.util.HashMap;
import java.util.LinkedList;
import java.util.*;

public class Djkstra {

	
	static HashMap<Integer, Node> nodes=new HashMap<>();
	static HashMap<Integer, Integer> distance=new HashMap<>();
	
	static class AdjNode{
		Node dest;
		int wt;
		
		AdjNode(Node y, int w){
			dest=y;
			wt=w;
		}
	}
	
	static class Node
	{
		int id;
		LinkedList<AdjNode> adj=null;
		Node(int a){
			id=a;
			adj=new LinkedList<AdjNode>();
		}
		
		
	}
	
	public static class NodeComparator implements Comparator<Node>{

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return distance.get(o1.id)-distance.get(o2.id);
		}
		
	}
	
	public static void addEdge(int a, int b, int c)
	{
		if(nodes.get(a)==null) {
			Node src=new Node(a);
			nodes.put(a,src);
			
		}
		
		if(nodes.get(b)==null) {
			Node dest=new Node(b);
			nodes.put(b,dest);
			
		}
		nodes.get(a).adj.add(new AdjNode(nodes.get(b),c));
		nodes.get(b).adj.add(new AdjNode(nodes.get(a),c));
		
	}
	
	public static void mst(int start)
	{
		System.out.println("Source is "+start); 
		for(Node n:nodes.values()) {
			if(n.id==start){
				distance.put(n.id, 0);
			}else {
				distance.put(n.id, 999);
			}
			
		}

		PriorityQueue<Node> minheap=new PriorityQueue<Node>(nodes.size(),new NodeComparator());
		
		for(Node n:nodes.values()) {
			minheap.add(n);
		}
		
		while(!minheap.isEmpty()) {
			Node temp=minheap.poll();
			
			for(AdjNode e:temp.adj) {
				
				int distanceWithCurrNode=distance.get(temp.id)+e.wt;
				if(distanceWithCurrNode<distance.get(e.dest.id) && minheap.contains(e.dest) && distance.get(temp.id)!=999) {
					distance.put(e.dest.id,distanceWithCurrNode);
					minheap.remove(e.dest);
					minheap.add(e.dest);
				}
			}
		}


		for(Map.Entry<Integer, Integer> entry : distance.entrySet()) {
			
			System.out.println("Distance of vertex "+entry.getKey()+" from source is "+entry.getValue());
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addEdge(0,1,4);
		addEdge(0,7,8);
		addEdge(1,2,8);	
		addEdge(1,7,11);
		addEdge(2,3,7);
		addEdge(2,8,2);
		addEdge(2,5,4);
		addEdge(3,4,9);
		addEdge(3,5,14);
		addEdge(4,5,10);
		addEdge(5,6,2);
		addEdge(6,7,1);
		addEdge(6,8,6);
		addEdge(7,8,7);
		
		mst(0);

		/*
		 * Output :
		 * Source is 0
			Distance of vertex 0 from source is 0
			Distance of vertex 1 from source is 4
			Distance of vertex 2 from source is 12
			Distance of vertex 3 from source is 19
			Distance of vertex 4 from source is 21
			Distance of vertex 5 from source is 11
			Distance of vertex 6 from source is 9
			Distance of vertex 7 from source is 8
			Distance of vertex 8 from source is 14
		 */
	}	

}
