
public class PatternSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str="catcatgogo";
		String pattern="aabb";
		
		boolean result=false;
		
		if (pattern.length()==0)
				System.out.println("0 length Strings.");
		result=doesMatch(str,pattern);
		System.out.println(result);

	}
	
	public static boolean doesMatch(String str,String pattern)
	{
		int strSize=str.length();
		
		char firstchar=pattern.charAt(0)=='a'?'a':'b';
		char secondchar=firstchar=='a'?'b':'a';
		
		int maincount=count(pattern,firstchar);
		int altcount=count(pattern,secondchar);
		
		int firstAlt=pattern.indexOf(secondchar);
		
		int maxMainSize=strSize/maincount;
		
		for(int i=0;i<=maxMainSize;i++)
		{
			int remLength=strSize-(i*maincount);
			if(altcount==0 || remLength%altcount==0)
			{
				int altindex=firstAlt*i;
				int altSize=altcount==0?0:remLength/altcount;
				String first=str.substring(0, i);
				String second=str.substring(altindex,altindex+altSize);
				if(str.equals(build(pattern,first,second)))
				{
					return true;
				}
			}
		}
		
		return false;
	}
	
	public static String build(String pat, String a, String b)
	{
		char first=pat.charAt(0);
		StringBuilder sb=new StringBuilder();
		for(char c : pat.toCharArray())
		{
			if(c==first)
			{
				sb.append(a);
			}
			else
				sb.append(b);
		}
		System.out.println("First : "+a +" Second : "+b);
		System.out.println("Build : "+sb.toString());
		return sb.toString();
	}
	
	public static int count(String input, char c)
	{
		int count=0;
		for (char a : input.toCharArray())
		{
			if (a==c)
				count++;
		}
		return count;
	}

}
