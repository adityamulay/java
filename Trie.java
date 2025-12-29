

public class Trie {
	
	static class TrieNode{
		boolean isLeaf;
		
		TrieNode[] children;
		
		TrieNode(){
			children=new TrieNode[26];
			isLeaf=false;
		}
		
	
	}
	
	static TrieNode root=new TrieNode();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String input="aditya";
		insertIntoTrie(root, input);
		System.out.println(checkIfPresent(input));

	}
	
	public static void insertIntoTrie(TrieNode root, String s) 
	{
		int i=0;
		while(i<s.length())
		{
			int charIndex=s.charAt(i)-'a';
			if(root.children[charIndex]==null)
			{
				root.children[charIndex]=new TrieNode();
			}
			root=root.children[charIndex];
			i++;
		}
		root.isLeaf=true;
		
	}
	
	public static boolean checkIfPresent(String s) 
	{
		int i=0;
		while(i<s.length())
		{
			int charIndex=s.charAt(i)-'a';
			if(root.children[charIndex]==null)
			{
				return false;
			}
			root=root.children[charIndex];
			i++;
		}
		return root.isLeaf=true;
	}

}
