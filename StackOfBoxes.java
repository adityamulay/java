import java.util.Arrays;

public class StackOfBoxes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box[] arr = new Box[4];
        arr[0] = new Box(4, 6, 7);
        arr[1] = new Box(1, 2, 3);
        arr[2] = new Box(4, 5, 6);
        arr[3] = new Box(10, 12, 32);
        arr[3] = new Box(10, 12, 32);
        
        Arrays.sort(arr);
        
        for(Box b:arr)
		{
			System.out.println("Height, Length, Width = "+b.h+", "+b.l+", "+b.w);		
		}
        
        System.out.println("The maximum possible "+
                           "height of stack is " + 
                           maxStackHeight(arr)); 

	}

	private static int maxStackHeight(Box[] arr) 
	{
		
		int length=arr.length;
		int[] result=new int[length];
		
		for(int i=0;i<length;i++)
		{
			result[i]=1;		
		}
		
		for(int i=0;i<length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i].fitsAbove(arr[j]) && result[i] < result[j]+1){
					result[i]=result[j]+1;
				}
			}
		}
		return max(result);
	}
	
	private static int max(int[] input)
	{
		int max=0;
		for(int i=0;i<input.length;i++)
		{
			if(input[i]>max)
				max=input[i];
		}
		return max;
	}
	static class Box implements Comparable<Box>
	{
		int h, l, w;
		Box(int height, int length, int width)
		{
			this.h=height;
			this.l=length;
			this.w=width;
		}
		
		public boolean fitsAbove(Box b)
		{
			return (this.h<b.h && this.w<b.w && this.l<b.l );
		}
		
		public int compareTo (Box b2)
		{
			return b2.h-this.h;
			
		}
	}
	
	
}
