import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


public class Prims {
	
	public class Graph
	{
		 class Edge
		{
			int weight;
			node dest;
			Edge(node d, int wt)
			{
				dest=d;
				weight=wt;
			}
		}
		
		class node
		{
			int key, dist;
			ArrayList<Edge>adj;
			node(int k, int d)
			{
				key=k;
				dist=d;
				adj=new ArrayList<Edge>();
			}
		}
		int V,E;
		HashMap<Integer, node> nodes;
		Graph(int v)
	    {
	        V = v;
	        nodes=new HashMap<>();

	        
	    }
		public void addEdge(int src, int dest, int wt)
		{
			
			if(!nodes.containsKey(src))
				nodes.put(src, new node(src,Integer.MAX_VALUE));
			
			if(!nodes.containsKey(dest))
				nodes.put(dest, new node(dest,Integer.MAX_VALUE));
			
			node s=nodes.get(src);
			node d=nodes.get(dest);
			s.adj.add(new Edge(d,wt));
			d.adj.add(new Edge(s,wt));
			

		}
		
		class comparator implements Comparator<node> { 
			  
	        @Override
	        public int compare(node node0, node node1) 
	        { 
	            return node0.dist - node1.dist; 
	        } 
	    } 
		void prims()
		{
			Set<node> mstset=new HashSet<>();
			int[] parent = new int[V]; 
			
			nodes.get(0).dist=0;
			PriorityQueue<node> queue = new PriorityQueue<>(V, new comparator()); 
			  
	        for (int i = 0; i < V; i++) 
	            queue.add(nodes.get(i)); 
	  
	        // Loops until the PriorityQueue is not empty 
	        while (!queue.isEmpty()) 
	        { 
	        		node n=queue.poll();
	        		mstset.add(n);
	        		
	        		for(Edge neighbor:n.adj)
	        		{
	        			if(!mstset.contains(neighbor.dest))
	        			{
	        				if(neighbor.dest.dist > neighbor.weight)
	        				{
	        					queue.remove(neighbor.dest);
	        					neighbor.dest.dist = neighbor.weight;
	        					queue.add(neighbor.dest);
	        					parent[neighbor.dest.key]=n.key;
	        				}
	        			}
	        		}
	        		
	        }
	     // Prints the vertex pair of mst 
            for (int o = 1; o < V; o++) 
                System.out.println(parent[o] + " " + "-" + " " + o); 
    
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/* Let us create following weighted graph
		        10
		   0--------1
		   |  \     |
		  6|   5\   |15
		   |      \ |
		   2--------3
		       4       */
		int V = 9;  // Number of vertices in graph
		Prims p=new Prims();
		Graph graph = p.new Graph(V);
		
		graph.addEdge(0,1,4);
		graph.addEdge(0,7,8);
		graph.addEdge(1,2,8);
		graph.addEdge(1,7,11);
		graph.addEdge(2,3,7);
		graph.addEdge(2,8,2);
		graph.addEdge(2,5,4);
		graph.addEdge(3,4,9);
		graph.addEdge(3,5,14);
		graph.addEdge(4,5,10);
		graph.addEdge(5,6,2);
		graph.addEdge(6,7,1);
		graph.addEdge(6,8,6);
		graph.addEdge(7,8,7);
		
		graph.prims();

	}

}
