import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MSTKruskal {
	
	 static class Graph
	{
		static class Edge
		{
			int src, dest,weight;
			Edge(int s, int d, int wt)
			{
				src=s;
				dest=d;
				weight=wt;
			}
		}
		class EdgeComaprator implements Comparator<Edge>
		{
			public int compare(Edge e1, Edge e2)
			{
				return e1.weight-e2.weight;
			}
		}
		
		int V,E;
		ArrayList<Edge> edge=null;
		
		Graph(int v)
	    {
	        V = v;
	        edge = new ArrayList<Edge>();
	        
	    }
		public void addEdge(int src, int dest, int wt)
		{
			Edge e=new Edge(src,dest,wt);
			edge.add(e);
		}
		
		// A utility function to find the subset of an element i
	    int find(int parent[], int i)
	    {
	        if (parent[i] == -1)
	            return i;
	        return find(parent, parent[i]);
	    }
	 
	    // A utility function to do union of two subsets
	    void Union(int parent[], int x, int y)
	    {
	        int xset = find(parent, x);
	        int yset = find(parent, y);
	        parent[xset] = yset;
	    }
	    
		void MST()
	    {
			int count=0,numEdges=0;
			
			ArrayList<Edge> result=new ArrayList<Edge>();
			Collections.sort(edge,new EdgeComaprator());
			
			// Allocate memory for creating V subsets
	        int parent[] = new int[this.V];
	 
	        // Initialize all subsets as single element sets
	        for (int i=0; i<this.V; ++i)
	            parent[i]=-1;
	        
	        while(count < this.V-1)
	        {
	        		Edge curr=edge.get(numEdges++);
	        		
	        		int x = find(parent, curr.src);
	            int y = find(parent, curr.dest);
	     
	            // If including this edge does't cause cycle,
	            // include it in result and increment the index 
	            // of result for next edge
	            if (x != y)
	            {
	                result.add(curr);
	                count++;
	                Union(parent, x, y);
	            }
	        	
	        }
	        
	        // print the contents of result[] to display
	        // the built MST
	        System.out.println("Following are the edges in " + 
	                                     "the constructed MST");
	        for (int i = 0; i < count; ++i)
	            System.out.println(result.get(i).src+" -- " + 
	                   result.get(i).dest+" == " + result.get(i).weight);
			
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
		Graph graph = new Graph(V);
		
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
		
		graph.MST();
		}

	

}
