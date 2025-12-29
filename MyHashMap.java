import java.util.*;

class HashNode<K,V>
{
	K key;
	V value;
	
	HashNode<K,V> next;
	
	HashNode(K key, V val)
	{
		this.key=key;
		this.value=val;
	}
}

public class MyHashMap<K,V>
{
	
	ArrayList<HashNode<K,V>> buckets;
	private int numBuckets;
	private int currSize;
	
	MyHashMap(int cap)
	{
		numBuckets=cap;
		buckets=new ArrayList<HashNode<K,V>>();	
		
		// Create empty chains 
        for (int i = 0; i < numBuckets; i++) 
        	buckets.add(null); 
	}
	
	public int size()
	{
		return currSize;
	}
	
	public boolean isEmpty() 
	{ 
		return size() == 0; 
	} 
	  
    
    private int getBucketIndex(K key) 
    { 
        int hashCode = key.hashCode(); 
        int index = hashCode % numBuckets; 
        return index; 
    } 
    
	public V get(K key)
	{
		int bucketIndex = getBucketIndex(key); 
		HashNode<K,V> head=buckets.get(bucketIndex);
		
		
		while(head != null)
		{
			if(head.key == key)
				return head.value;
			head=head.next;
		}
		
		return null;
	}
	
	public void put(K key, V value)
	{
		//System.out.println("Inside put");
		int bucketIndex = getBucketIndex(key);
		HashNode<K,V> head=buckets.get(bucketIndex);
		
		HashNode<K,V> curr=head;
		
		while(curr != null)
		{
			if(curr.key == key)
			{
				curr.value = value;
				return;
			}
			curr=curr.next;	
			
		}
		
		HashNode<K,V> node=new HashNode<K,V>(key,value);
		node.next=head;
		buckets.set(bucketIndex, node);
		currSize++;
		
		if((double)currSize/numBuckets >= 0.7)
		{
			resize();
		}
		
	}
	
	public V remove( K key)
	{
		int bucketIndex = getBucketIndex(key);
		HashNode<K,V> head=buckets.get(bucketIndex);
		
		HashNode<K,V> prev=null;
		
		while(head != null)
		{
			if(head.key == key)
				break;
			
			prev=head;
			head=head.next;	
		}
		
		if(head == null)
			return null;
		
		currSize--;
		
		if(prev !=null)
		{
			prev.next=head.next;
		}
		else
		{
			buckets.set(bucketIndex, head.next);
		}
		
		return head.value;
		
	}
	
	public void resize()
	{
		ArrayList<HashNode<K,V>> temp=buckets;
		numBuckets=2*numBuckets;
		currSize=0;
		buckets=new ArrayList<HashNode<K,V>>();
		
		for(int i=0; i<numBuckets; i++)
		{
			buckets.add(null);
		}
		
		for (HashNode<K, V> headNode : temp) 
        { 
			while (headNode != null) 
            { 
                put(headNode.key, headNode.value); 
                headNode = headNode.next; 
            } 
        }
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyHashMap<String, Integer>map = new MyHashMap<>(10); 
        map.put("this",1 ); 
        map.put("coder",2 ); 
        map.put("this",4 ); 
        map.put("hi",5 ); 
        System.out.println(map.size()); 
        System.out.println(map.remove("this")); 
        System.out.println(map.remove("this")); 
        System.out.println(map.size()); 
        System.out.println(map.isEmpty()); 

	}

}
