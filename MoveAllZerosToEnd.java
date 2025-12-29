import java.util.ArrayList;
import java.util.List;

public class MoveAllZerosToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int input[]= {3,0,4,0,1,0,2,0,5};

		System.out.println(0%11);
		System.out.println("a".lastIndexOf("\t"));
		System.out.println("Length of input array is : "+input.length);
		System.out.print("Contents of array : { ");
		for(int i=0; i<input.length ; i++){
			System.out.print(input[i]+" ");
		}
		System.out.println("}");
		 
		
		moveAllZerosToEnd(input);
		
		System.out.print("New content : {");
		for(int i=0; i<input.length ; i++){
			System.out.print(input[i]+" ");
		}
		System.out.println("}");
		
		

	}
	
	static List<List<Integer>> calculate(List<List<Integer>> list)
	{
		List<List<Integer>> arl=new ArrayList<List<Integer>>();
		return arl;
		
	}
	
	public static void moveAllZerosToEnd(int[] input) {
		
		
		int count=0;
		
		for(int i=0 ; i<input.length ; i++) {
			if(input[i] != 0) {
				input[count++]=input[i];
			}
		}
		
		while(count<input.length) {
			input[count++]=0;
		}
		
		
	}

}
