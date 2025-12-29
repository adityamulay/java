
public class SquareRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=30;
		System.out.println(squareRoot(n,1,n/2));

	}
	
	public static int squareRoot(int n, int start, int end)
	{
		while(start<=end) {
			int mid=(start+end)/2;
			
			if(mid*mid==n)
				return mid;
			
			if(mid*mid<n) {
				if((mid+1)*(mid+1)>n)
					return mid;
				start=mid+1;
			}
			else
			{
				end=mid-1;
			}
			
		}
		return start;
		
	}

}
