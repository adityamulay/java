
public class SparseMatrixMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input1={{1, 0, 0, 1, 0},{0, 0, 1, 0, 1},{0, 0, 0, 1, 0},{1, 0, 1, 0, 1}};
		int[][] input2={{1, 0, 0, 1, 0},{0, 0, 1, 0, 1},{0, 0, 0, 1, 0},{1, 0, 1, 0, 1},{1, 0, 0, 1, 0}};
		
		
		int arows=input1.length;
		int acols=input1[0].length;
		int bcols=input2[0].length;
		
		int[][] result=new int[arows][bcols];
		
		
		for(int i=0;i<arows;i++)
		{
			for(int j=0;j<acols;j++)
			{
				if(input1[i][j]==0)
					continue;
				else
				{
					for(int k=0;k<bcols;k++)
					{
						result[i][k]+=input1[i][j]*input2[j][k];
					}
				}
			
			}
		}
		
		for(int i=0;i<arows;i++) {
			System.out.println();
			for(int j=0;j<bcols;j++)
				System.out.print(result[i][j]);
		}


	}

}
