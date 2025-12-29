import java.util.HashMap;

public class AllPermutationsOfString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String test="abcd";
		System.out.println(test.indexOf("\t"));
		String input1="abcd";
		System.out.println("Printing all permutations of string with no duplicates : "+input1);
		allPermsNoDups(input1, ""); 
		
		String input2="aabb";
		HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
		for(Character c:input2.toCharArray())
		{
			if(hm.containsKey(c))
				hm.put(c, hm.get(c)+1);
			else
				hm.put(c, 1);
		}
		System.out.println("Printing all permutations of string with  duplicates : "+input2);
		allPermsWithDups("", input2.length(),hm); 
	}
	
	
	public static void allPermsNoDups(String input, String prefix) {
		
		//System.out.println("Input : "+input+" *** Prefix : "+prefix );
		
		if(input == null) {
			System.out.println("Null input string");
			return;
		}
		
		if(input.length() == 0) {
			System.out.println(prefix);
		}
		
		for(int i=0;i<input.length();i++) {
			String tempPrefix=prefix+input.charAt(i);
			String remaining=input.substring(0,i)+input.substring(i+1,input.length());
			allPermsNoDups(remaining, tempPrefix);
		}
	}
	
	public static void allPermsWithDups(String prefix, int rem ,HashMap<Character,Integer> hm) {
		
		
		if(rem == 0) {
			System.out.println(prefix);
		}
		
		for(Character c : hm.keySet())
		{
			int count=hm.get(c);
			if(count>0)
			{
				hm.put(c, count-1);
				allPermsWithDups(prefix+c,rem-1,hm);
				hm.put(c, count);
			}
		}
	}

}
