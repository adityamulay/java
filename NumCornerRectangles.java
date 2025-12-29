
public class NumCornerRectangles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input={{1, 0, 0, 1, 0},{0, 0, 1, 0, 1},{0, 0, 0, 1, 0},{1, 0, 1, 0, 1}};
		
		int rows=input.length;
		int cols=input[0].length;
		int ans=0;
		for(int row1=0;row1<rows;row1++)
		{
			for(int row2=row1+1;row2<rows;row2++)
			{
				int count=0;
				for(int col=0;col<cols;col++)
				{
					if(input[row1][col]==1 && input[row2][col]==1)
					{
						count++;
					}
				}
				ans+=(count*(count-1))/2;
			}
		}
		System.out.println(ans); 

	}

}
