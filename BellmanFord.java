import java.util.*;


public class BellmanFord {
	
	static LinkedList<Edge> edges=new LinkedList<Edge>();
	static HashMap<Integer, Node> nodes=new HashMap<>();
	static final int vertices=3;
	
	static class Edge{
		Node src;
		Node dest;
		int wt;
		
		Edge(Node x, Node y, int w){
			src=x;
			dest=y;
			wt=w;
		}
	}
	
	static class Node
	{
		int id;
		int dist;
		
		Node(int a, int d){
			id=a;
			dist=d;
		}
	}
	
	public static void addEdge(int a, int b, int c)
	{
		if(nodes.get(a)==null) {
			Node src=new Node(a,Integer.MAX_VALUE);
			nodes.put(a,src);
		}
		
		if(nodes.get(b)==null) {
			Node dest=new Node(b,Integer.MAX_VALUE);
			nodes.put(b,dest);
		}
		
		Edge e1=new Edge(nodes.get(a),nodes.get(b),c);
		//Edge e2=new Edge(nodes.get(b),nodes.get(a),c);

		edges.add(e1);
		//edges.add(e2);
		
	}
	
	public static void calculateShortestDist(LinkedList<Edge> edges, int start)
	{
		System.out.println("Source is "+start); 
		HashMap<Integer,Integer> dist=new HashMap<>();
		
		Node src=nodes.get(start);
		dist.put(src.id, 0);
		
		for(int i=1;i<vertices;i++)
		{
			for(Edge e:edges)
			{
				if(e.dest == src) continue;
				if(dist.containsKey(e.src.id) && dist.getOrDefault(e.dest.id,Integer.MAX_VALUE)>dist.get(e.src.id)+e.wt)
				{
					dist.put((e.dest.id),dist.get(e.src.id)+e.wt);
				}
			}
		}
		
		for(Map.Entry<Integer,Integer> entry :dist.entrySet()) {
			System.out.println("Distance of vertex "+entry.getKey()+" from source is "+entry.getValue());
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addEdge(0,1,-1);
		addEdge(0,2,4);
		addEdge(1,2,3);	
		addEdge(1,3,2);
		addEdge(1,4,2);
		addEdge(3,2,5);
		addEdge(3,1,1);
		addEdge(4,3,-3);
		
		calculateShortestDist(edges,0);

	}	

}
