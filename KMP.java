
public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		KMPSubString("abcxabcdabcdabcy".toCharArray(), "abcdabcy".toCharArray());

	}
	
	public static void KMPSubString(char[] input, char[] pattern)
	{
		int[] lps=calculateLPS(pattern);
		
		int i=0;
        int j=0;
        while(i < input.length && j < pattern.length)
        {
            if(input[i] == pattern[j]){
                i++;
                j++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }else{
                    i++;
                }
            }
        }
        
        if(j == pattern.length)
        {
        		int len=pattern.length;
        		System.out.println("i="+i+" len="+len);
            System.out.println("Pattern found at index "+ ((i-len)));
        }
        else
        		System.out.println("Pattern not found");
	}
	
	public static int[] calculateLPS(char[] pattern)
	{
		int [] lps = new int[pattern.length];
        int index =0;
        for(int i=1; i < pattern.length;){
            if(pattern[i] == pattern[index]){
                lps[i] = index + 1;
                index++;
                i++;
            }else{
                if(index != 0){
                    index = lps[index-1];
                }else{
                    lps[i] =0;
                    i++;
                }
            }
        }
		
		for(int num:lps)
			System.out.println(num);
		return lps;
		
	}

}
