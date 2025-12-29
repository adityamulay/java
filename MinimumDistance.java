
public class MinimumDistance {

	
	int minDist(int a[], int n, int x, int y) 
    {
        int loc1=-1;
        int loc2=-1;
        int dist=Integer.MAX_VALUE;
        int i=0;
        
        for(i=0;i<n;i++)
        {
        		if(a[i]==x) {
        			loc1=i;
        		}else if(a[i]==y) {
        			loc2=i;
        		}
        		
        		if(loc1!=-1 &&loc2!=-1){
        			i++;
        			break;
        		}
        		
        }
        
        if(i==n) return dist;
        
        int l1=loc1,l2=loc2;
        for(;i<n;i++)
        {	
        		if(a[i]==x)
        		{
        			if(Math.abs(i-loc2)<dist) {
        					dist=Math.abs(i-loc2);
        					l1=i;
        			}
        			loc1=i;
        			
        		}
        		if(a[i]==y)
        		{
        			if(Math.abs(i-loc1)<dist) {
        					dist=Math.abs(i-loc1);
        					l2=i;
        			}
        			loc2=i;
        			
        		}
        	
        }
        System.out.println("Minimum distance between " + x + " and " + y+" is "+dist+" and co-ordinates are "+ l1+" and "+l2);
        return dist;
    }
 
    /* Driver program to test above functions */
    public static void main(String[] args) {
        MinimumDistance min = new MinimumDistance();
        int arr[] = {3, 5, 4, 2, 6, 3, 0, 0, 5, 4, 8, 3};
        int n = arr.length;
        int x = 4;
        int y = 0;
 
        System.out.println("Minimum distance between " + x + " and " + y
                + " is " + min.minDist(arr, n, x, y));
    }

}
