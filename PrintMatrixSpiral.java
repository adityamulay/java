

public class PrintMatrixSpiral {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int[][] mat= {{5,7,6},{2,3,4},{1,9,8}};
		int[][] mat= {{1,2}};
		
		printSpiral(mat,mat.length,mat[0].length);
	}
	
	public static void printSpiral(int[][] mat, int rows, int cols)
	{
		int rowstart=0,colstart=0;
		int rowend=rows-1,colend=cols-1;
		
		while(rowstart<=rowend && colstart<=colend)
		{
			for(int i=colstart;i<=colend;i++) {
				System.out.println(mat[rowstart][i]);
			}
			rowstart++;
			for(int j=rowstart;j<=rowend;j++) {
				System.out.println(mat[j][colend]);
			}
			colend--;
			
			if(rowstart<=rowend) {
				for(int k=colend;k>=colstart;k--) {
					System.out.println(mat[rowend][k]);
				}
			}
			rowend--;
			
			if(colend<=colstart) {
				for(int l=rowend;l>=rowstart;l--) {
					System.out.println(mat[l][colstart]);
				}
			}
			colstart++;
		}
		
	}
	

}
