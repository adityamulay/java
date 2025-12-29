import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

class BoundedBlockingQueue {

    private ReentrantLock lock = new ReentrantLock();
    private Condition hasSpace = lock.newCondition();
    private Condition hasData = lock.newCondition();
    private Queue<Integer> queue;
    private int maxSize;
    
    public BoundedBlockingQueue(int capacity) {
        queue = new LinkedList();
        maxSize = capacity;
    }
    
    public void enqueue(int element) throws InterruptedException {
		lock.lock();
		
        try {
            while(maxSize == queue.size()) {
                hasSpace.await();
            }
            queue.offer(element);
            hasData.signal();
        } finally {
            lock.unlock();
        }
    }
    
    public int dequeue() throws InterruptedException {
		lock.lock();
        try {
            while(queue.size() == 0) {
                hasData.await();
            }
            int res = queue.poll();
            hasSpace.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }
    
    public int size() throws InterruptedException {
        lock.lock();
		try {
			return queue.size();
		} finally {
			lock.unlock();
		}
    }
    
    public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
    	
    	BoundedBlockingQueue queue = new BoundedBlockingQueue(2);   // initialize the queue with capacity = 2.

    	Runnable myRunnableProducer = new Runnable(){
            public void run(){
            		
            		try {
            			
					queue.enqueue(1);
					System.out.println("Produce - 1");
					
					
				    	queue.enqueue(0);   // The producer thread enqueues 0 to the queue. The consumer thread is unblocked and returns 0 from the queue.
				    	System.out.println("Produce - 0");
				    	
				    	
				    	queue.enqueue(2);   // The producer thread enqueues 2 to the queue.
				    	System.out.println("Produce - 2");
				    	
				    	
				    	queue.enqueue(3);   // The producer thread enqueues 3 to the queue.
				    	System.out.println("Produce - 3");
				    	
				    
				    	
				    	queue.enqueue(4);   // The producer thread is blocked because the queue's capacity (2) is reached.
				    	System.out.println("Produce - 4");
				    	
				} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
				}   // The producer thread enqueues 1 to the queue.
            }
    };
    Thread prod = new Thread(myRunnableProducer);
    
    
    Runnable myRunnableConsumer = new Runnable(){
        public void run(){
       
        		try {
        			System.out.println("Dequeue "+queue.dequeue()); // The consumer thread calls dequeue and returns 1 from the queue.
        			System.out.println("Dequeue "+queue.dequeue());    // Since the queue is empty, the consumer thread is blocked.
        			System.out.println("Dequeue "+queue.dequeue());   // The consumer thread returns 2 from the queue. The producer thread is unblocked and enqueues 4 to the queue.
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}   // The producer thread enqueues 1 to the queue.
        }
    };
    Thread cons = new Thread(myRunnableConsumer);
    
    prod.start();
    cons.start();
    
    	
    	prod.join();
    	cons.join();
    
    
    	System.out.println("Size= "+queue.size());       // 2 elements remaining in the queue. size() is always called at the end of each test case.

	}
}

