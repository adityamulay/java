
public class RomanToDec {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input="XXV";
		
		System.out.println(romanToDec(input));

	}
	
	public static int romanToDec(String input)
	{
		int result=0;
		int s1,s2;
		
		char[] arr=input.toCharArray();
		
		for(int i=0;i<arr.length;i++)
		{
			s1=getValue(arr[i]);
			if(i+1<arr.length)
			{
				s2=getValue(arr[i+1]);
				if(arr[i]>=arr[i+1]) {
					result=result+s1;
				}else {
					result=result-s1+s2;
					i++;
				}
				
			}else {
				result=result+s1;
			}
		}
		return result;
	}
	
	public static int getValue(char ch) {
		switch(ch) {
		case 'I': return 1;
		case 'V': return 5;
		case 'X': return 10;
		case 'L': return 50;
		case 'C': return 100;
		case 'D': return 500;
		case 'M': return 1000; 
		default : return -1;
		}
	}

}
