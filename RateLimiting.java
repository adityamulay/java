
public class RateLimiting {

	private int capacity;
	private int windowInSeconds;
	
	private long lastRefillTime;
	private long availabletokens;
	private long tokensPerSec;
	
	RateLimiting(int cap, int window)
	{
		this.capacity=cap;
		this.windowInSeconds=window;
		this.availabletokens=0;
		this.lastRefillTime=System.currentTimeMillis();
		this.tokensPerSec=capacity/windowInSeconds;
	}
	
	public synchronized void tryConsume()
	{
		refill();
		
		if(availabletokens > 0) {
			System.out.println("Execution allowed");
			availabletokens--;
		}
		else
			System.out.println("Execution not allowed");
		
	}
	
	public void refill()
	{
		long now=System.currentTimeMillis();
		long diff=(now-lastRefillTime) / 1000;
		lastRefillTime=now;
		
		availabletokens=Math.min(capacity, availabletokens+diff*tokensPerSec);
		System.out.println("Available tokens : "+availabletokens);
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		RateLimiting r=new RateLimiting(10, 1);
		
		while(true)
		{
			r.tryConsume();
			Thread.sleep(1000);
			r.tryConsume();
			r.tryConsume();
			r.tryConsume();
			r.tryConsume();
			r.tryConsume();
			r.tryConsume();
			r.tryConsume();
			r.tryConsume();
			r.tryConsume();
			r.tryConsume();
			r.tryConsume();
			r.tryConsume();
			
			
		}
		

	}
	
	

}
