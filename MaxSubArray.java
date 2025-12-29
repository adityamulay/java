
public class MaxSubArray {

	    static int maxSubArraySum(int a[], int size)
	    {
		    int max_so_far = a[0];
		    int curr_max = a[0];
		    int start=0,end=0;
		    int rStart=0, rEnd=0;
	 
		    for (int i = 1; i < size; i++)
		    {
		
		        if(a[i]>curr_max+a[i]) {
		        		start=i;
		        		end=i;
		        		curr_max=a[i];
		        }else {
		        		curr_max=curr_max+a[i];
		        		end++;
		        }
		        
		        if(max_so_far < curr_max)
		        {
		        		max_so_far = curr_max;
		        		rStart=start;
		        		rEnd=end;
		        		
		        }
		        //max_so_far = Math.max(max_so_far, curr_max);
		        
		    }
		    System.out.println("Start= "+rStart+ " End="+rEnd);
		    return max_so_far;
	    }
	    
	    static int maxSubArray(int[] nums) {
	        
	        int n = nums.length;
	        int currSum = 0, maxSum = Integer.MIN_VALUE;

	        for(int i = 0; i < n; ++i) {
	          currSum = Math.max(nums[i], currSum + nums[i]);
	          maxSum = Math.max(maxSum, currSum);
	        }
	        return maxSum;
	        
	    }
	 
	    /* Driver program to test maxSubArraySum */
	    public static void main(String[] args)
	    {
		    int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
		    int n = a.length;   
		    int max_sum = maxSubArraySum(a, n);
		    System.out.println("Maximum contiguous sum is "
		                       + max_sum);
	    }
	

}
