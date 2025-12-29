
public class CountFreqSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1, 2, 2, 3, 3, 3, 3}; 
        
        // Element to be counted in arr[] 
        int x =  3;  
        int n = arr.length; 
        int c = count(arr, x, n); 
        System.out.println(x+" occurs "+c+" times"); 

	}
	
	public static int count(int[] arr, int num, int len)
	{
		int first=binarySearchFirst(arr,0,len-1, num);
		if (first==-1)return 0;
		
		System.out.println("First is "+first);
		
		int second=binarySearchLast(arr,0,len-1, num);
		
		System.out.println("Second is "+second);
		return second-first+1;
	}
	
	public static int binarySearchFirst(int[] a, int low, int high, int x)
	{
		while(low<=high)
		{
			int mid=low+((high-low)/2);
			if(mid==0 || (a[mid]==x && a[mid-1]<x))
				return mid;
			else if(a[mid]<x)
				low=mid+1;
			else high=mid-1;
		}
		return low;
	}
	
	public static int binarySearchLast(int[] a, int low, int high, int x)
	{
		while(low<=high)
		{
			int mid=low+((high-low)/2);
			if(mid==a.length-1 || (a[mid]==x && a[mid+1]>x))
				return mid;
			else if(a[mid]<=x)
				low=mid+1;
			else high=mid-1;
			
		}
		return low;
	}

}
