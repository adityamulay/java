
public class ReverseWordsInaString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverseWords("   I am   batman    "));

	}
	
public static String reverseWords(String s) {
        
        if (s == null) return null;
    
        char[] a = s.toCharArray();
        int n = a.length;
    
        // step 1. reverse the whole string
        reverse(a, 0, n - 1);
        
        System.out.println(new String(a));
        
        // step 2. reverse each word
        reverseWords(a);
        System.out.println(new String(a));
        
        return clean(a);
    }
    
    public static void reverse(char[] a, int i, int j)
    {
        char temp;
        while(i<j)
        {
            temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;
            j--;
        }
    }
    
    public static void reverseWords(char[] a)
    {
        int i=0,j=0;
        while(j<a.length)
        {
            while(i<a.length && a[i]==' ')i++;
            j=i;
            while(j<a.length && a[j]!=' ')j++;
            reverse(a,i,j-1);
            i=j;
        }
        
    }
    
    public static String clean(char[] a)
    {
        int j=0,i=0;
        while(j<a.length)
        {
            while(j<a.length && a[j]==' ')j++;
            while(j<a.length && a[j]!=' ')
            		a[i++]=a[j++];
            while(j<a.length && a[j]==' ')j++;
            if(j<a.length)
            		a[i++]=' ';
            
        }
        return new String(a).substring(0, i);
    }

}
