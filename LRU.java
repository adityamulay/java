import java.util.HashMap;



public class LRU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[]= {1,2,3,4,1,2,3,4};
		int max=4;
		
		System.out.println(calculateMisses(arr,max));
		
		
	}
	
	static class Node
	{
		int id;
		Node prev, next;
		
		Node(int n)
		{
			id=n;
		}
	}
	
	static class CacheList
	{
		Node head,tail;
		int missCount;
		CacheList()
		{
			head=null;
			tail=null;
			missCount=0;
		}
	}
	
	public static int calculateMisses(int[] arr, int size)
	{
		int arraySize =arr.length;
		
		HashMap<Integer, Node> hm=new HashMap<Integer, Node>();
		CacheList ll=new CacheList();
		
		for(int i=0;i<arraySize;i++)
		{
			Node node=new Node(arr[i]);
			addToCache(arr[i],node,hm,ll,size);
		}
		
		return ll.missCount;
	}
	public static void addToCache(int key, Node node,HashMap<Integer, Node> hm,CacheList ll,int capacity) 
	{
		if(hm.containsKey(key))
		{
			removeFromCache(key,hm,ll);
		}
		else
			ll.missCount++;
		
		if(hm.size()==capacity)
		{
			removeFromCache(ll.tail.id, hm, ll);
		}
		insertAtFront(node,ll);
		hm.put(key, node);
		
	}
	
	public static void insertAtFront(Node node,CacheList ll)
	{
		if(ll.head==null)
		{
			ll.head=node;
			ll.tail=node;
		}
		else
		{
			ll.head.prev=node;
			node.next=ll.head;
			ll.head=node;
		}
	}
	
	public static void removeFromCache(int key, HashMap<Integer, Node> hm,CacheList ll)
	{
		
		if(hm.containsKey(key))
		{
			Node n=hm.get(key);
			removeFromList(n,ll);
			hm.remove(key);
		}
		
		
	}
	
	public static void removeFromList(Node node, CacheList ll)
	{
		if(node==null)
			return;
		
		if(node.prev !=null)
			node.prev.next=node.next;
		if(node.next !=null)
			node.next.prev=node.prev;
		if(node==ll.head)
			ll.head=node.next;
		if(node==ll.tail)
			ll.tail=node.prev;
					
		
	}
	
	public static int getValue(int key,HashMap<Integer, Node> hm,CacheList ll)
	{
		Node n=hm.get(key);
		if(n==null) return -1;
		
		if(n !=ll.head)
		{
			removeFromCache(key,hm,ll);
			insertAtFront(n,ll);	
		}
		return key;
	}

}
