import java.util.*;

class TrieNode
{
	TrieNode[] children;
	boolean isLeaf;
	
	TrieNode()
	{
		children=new TrieNode[26];
		isLeaf=false;
	}
}


public class SubStringBracket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] symbols= {"an", "a", "mel","lon","el"};
		String[] words= {"apple", "melon","watermelon","orange"};
		TrieNode root=buildTrie(symbols);
		
		List<String> result= findSubStrings(words,root);
		System.out.println(result);

	}
	
	public static TrieNode buildTrie(String[] symbols)
	{
		TrieNode root=new TrieNode();
		TrieNode mainRoot=root;
		
		for(String str : symbols)
		{
			char[] arr=str.toCharArray();
			root=mainRoot;
			for(char ch : arr)
			{
				if(root.children[ch-'a'] == null)
				{
					root.children[ch-'a']=new TrieNode();
				}
				root=root.children[ch-'a'];
				
			}
			root.isLeaf=true;	
			
		}
		return mainRoot;
	}
	
	public static List<String> findSubStrings(String[]words, TrieNode root)
	{
		List<String> result=new LinkedList<String>();
		
		for(String word : words)
		{
			String s=calculate(word, root);
			result.add(s);
		}
		
		return result;
	}
	
	public static String calculate(String word, TrieNode root)
	{
		System.out.println("Word is "+word);
		char[] wrd=word.toCharArray();
		int len=0;
		int maxLen=Integer.MIN_VALUE;
		int index=0;
		TrieNode mainroot=root;
		
		for(int start=0;start<wrd.length;start++)
		{	
			if(root.children[wrd[start]-'a'] == null)
			{
				len=0;
				root=mainroot;
				continue;
			}
			else
			{
				len++;
				root=root.children[wrd[start]-'a'];
				if (len>maxLen)
				{
					index=start-len+1;
					maxLen=len;
				}
			}
				
		}
		
		System.out.println(word.substring(0, index)+"["+word.substring(index, index+maxLen)+"]"+word.substring(index+maxLen,word.length()));
		return word.substring(0, index)+"["+word.substring(index, index+maxLen)+"]"+word.substring(index+maxLen,word.length());
	
	}

}
