import java.util.*;

public class IntToWords {
	
	static final String[] smalls= {"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","ninteen"};
	static final String[] tens= {"","","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
	static final String[] bigs= {"","thousand","million","billion"};
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=2111354;
		convertToWords(n);

	}
	
	public static void convertToWords(int n)
	{
		
		LinkedList<String> res=new LinkedList<>();
		boolean isNegative=n<0?true:false;
		n=Math.abs(n);
		int count=0;
		while(n>0)
		{	
			int current=n%1000;
			
			if(current!=0) {
				String result=convert(current)+" "+bigs[count];
				res.addFirst(result);
			}
			
			n=n/1000;
			count++;
		}
		
		if(isNegative) {
			res.addFirst("negative ");
		}
		
		System.out.println(listToString(res).trim());
		
	}
	
	public static String listToString(LinkedList<String> s)
	{
		StringBuilder sb=new StringBuilder();
		Iterator<String> it=s.listIterator();
		while(it.hasNext()) {
			sb.append(it.next());
		}
		
		return sb.toString();
		
	}
	public static String convert(int a)
	{
		StringBuilder sb=new StringBuilder();
		sb.append(" ");
		
			if(a>=100) {
				sb.append(smalls[a/100]);
				sb.append(" ");
				sb.append("hundred");
				sb.append(" ");
				a=a%100;
			}
			if(a>0 &&a<=19) {
				sb.append(smalls[a]);
			}else if(a>=20)
			{
				sb.append(tens[a/10]);
				sb.append(" ");
				a=a%10;
				sb.append(smalls[a]);
			}
		return sb.toString();
	}

}
