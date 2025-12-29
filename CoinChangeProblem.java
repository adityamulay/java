
public class CoinChangeProblem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*Maximum number of ways to generate a sum given an array of denominations*/
		int[] denoms={1,2,3,5,10};
		int sum=5;
		int len=denoms.length;
		
		int answer=findMaxWaysTogenerateSumRecursive(denoms, len, sum);
		System.out.println("Max ways to generate a sum of "+sum+" recursively : "+answer);
		
		int nextAnswer=findMaxWaysTogenerateSumRIterative(denoms, len, sum);
		System.out.println("Max ways to generate a sum of "+sum+" iteratively : "+nextAnswer);
		
	}
	
	/*
	 * Every coin is either :
	 * 1. Not present in the solution
	 * 2. Present one or more times in the solution
	 * So the equation is : findMaxWaysTogenerateSumRecursive(denoms[], m , sum-denoms[m-1])+ findMaxWaysTogenerateSumRecursive(denoms,m-1,sum)
	 */
	public static int findMaxWaysTogenerateSumRecursive(int[] denoms, int m, int sum) {
		
		if(sum == 0) {
			return 1;
		}
		else if(sum < 0) {
			return 0;
		}
		else if(m<=0 && sum>0) {
			return 0;
		}
		
		return findMaxWaysTogenerateSumRecursive(denoms,m-1,sum) + findMaxWaysTogenerateSumRecursive(denoms,m,sum-denoms[m-1]);
		
				
	}
	
	/*
	 * Pick each coin and update ways for each value from coin value to sum
	 */
	public static int findMaxWaysTogenerateSumRIterative(int[] denoms, int m, int sum) 
	{
		int[] ways=new int[sum+1];
		ways[0]=1;
		for(int i=0;i<m;i++)
		{
			for(int j=denoms[i];j<=sum;j++)
			{
				ways[j]=ways[j]+ways[j-denoms[i]];
			}
		}
		
		return ways[sum];		
	}

}
