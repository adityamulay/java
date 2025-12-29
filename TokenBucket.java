import java.util.Random;

public class TokenBucket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		bucket b=new bucket(10);	
		Thread tt=new TokenThread(b);
		Thread pt=new PacketThread(b);
		
		tt.start();
		pt.start();
		
	}	

}

class TokenThread extends Thread
{
	bucket buck;
	TokenThread(bucket b)
	{
		this.buck=b;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			buck.addTokens(1);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}

class PacketThread extends Thread
{
	bucket buck;
	PacketThread(bucket b)
	{
		this.buck=b;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true)
		{
			Random r=new Random();
			int numPackets=1+ r.nextInt(9);
			if(buck.getTokens(numPackets))
				System.out.println(numPackets + " packets sent.");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
}

class bucket
{
	private int maxsize;
	private int tokens;
	
	bucket(int size)
	{
		this.maxsize=size;
		this.tokens=0;
	}
	
	protected synchronized void addTokens(int x)
	{
		if(tokens == maxsize)
			return;
		tokens++;
		System.out.println("A token added, total = "+tokens);
	}
	
	protected synchronized boolean getTokens(int x)
	{
		if(x <= tokens)
		{
			System.out.println("Sending "+ x + " packets.");
			tokens = tokens-x;
			return true;
		}
		else
		{
			System.out.println("Discarding "+ x + " packets as tokens available = "+tokens);
			return false;
		}
			
	}
}
