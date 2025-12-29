
public class TinyUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(Long.MAX_VALUE);
		long n = 1; //3400000000000L;
	    String shorturl = idToShortURL(n);
	    System.out.println("62 raised to 7 is " + Math.pow(62, 7));
	    System.out.println("Generated short url is " + shorturl);
	    System.out.println("Id from url is " + shortURLtoID(shorturl));

	}
	
	// Function to generate a short url from intger ID
	public static String idToShortURL(long n)
	{
	    // Map to store 62 possible characters
	    char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
	 
	    StringBuilder shorturl=new StringBuilder();
	 
	    // Convert given integer id to a base 62 number
	    while (n!=0)
	    {
	        // use above map to store actual character
	        // in short url
	        shorturl=shorturl.append(map[(int)(n%62)]);
	        System.out.println("map[0] : "+map[0]);
	        n = n/62;
	    }
	 
	    // Reverse shortURL to complete base conversion
	    
	    String result=shorturl.reverse().toString();
	 
	    return result;
	}
	 
	/* Function to get integer ID back from a short url*/
	public static long shortURLtoID(String shortURL)
	{
	    long id = 0; // initialize result
	    
	 // Map to store 62 possible characters
	    String map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	 
	    // A simple base conversion logic
	    for (int i=0; i < shortURL.length(); i++)
	    {
	    		id = id*62 +map.indexOf(shortURL.charAt(i));
	    }
	    return id;
	}
	 

}
