


public class CheckStringNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input="+.23     ";
		
		String patt="[+-][0-9]*[.]*[0-9]+";
		System.out.println(input.matches(patt));

	}

}
