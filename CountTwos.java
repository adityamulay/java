
public class CountTwos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		System.out.println(count(27));

	}
	
	public static int count(int n)
	{
		int len=String.valueOf(n).length();
		int count=0;
		
		for(int i=0;i<len;i++)
		{
			count = count+helper(n,i);
		}
		
		return count;
	}
	
	public static int helper(int n, int index)
	{
		int powerof10=(int)Math.pow(10, index);
		int nextpower=powerof10*10;
		int right=n%powerof10;
		
		int rounddown=n-(n%nextpower);
		int roundup=rounddown+nextpower;
		
		int digit=n/powerof10 %10;
		
		if(digit<2)
			return rounddown/10;
		else if(digit==2)
			return rounddown/10 + right + 1;
		else
			return roundup/10;
	
	}

}
