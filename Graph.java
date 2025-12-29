import java.util.LinkedList;

public class Graph {
	
	
	static int numVertices;
	static LinkedList<Integer> adjList[];
	
	@SuppressWarnings("unchecked")
	Graph(int v)
	{
		numVertices=v;
		adjList=new LinkedList[v];
		for(int i=0;i<numVertices;i++)
		{
			adjList[i]=new LinkedList<Integer>();
		}
	}
	
	public static void addEdge(int a, int b)
	{
		adjList[a].add(b);
	}

	public static void printGraph()
	{
		for(int v = 0; v < numVertices; v++)
        {
            System.out.println("Adjacency list of vertex "+ v);
            System.out.print("head");
            for(Integer pCrawl: adjList[v]){
                System.out.print(" -> "+pCrawl);
            }
            System.out.println("\n");
        }
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		// create the graph given in above figure
        int V = 5;
        Graph graph = new Graph(V);
        addEdge(0, 1);
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(1, 3);
        addEdge(1, 4);
        addEdge(2, 3);
        addEdge(3, 4);
      
        // print the adjacency list representation of 
        // the above graph
        printGraph();

	}

}
