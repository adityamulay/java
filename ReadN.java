
public class ReadN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] buf=new char[5];
		System.out.println(read(buf,5));

	}
	
	public static int read(char[] buf, int n) 
	{
		int total=0;
		
		boolean eof=false;
		char[] tmp = new char[4];
		
		while(!eof && total<n)
		{
			int count=read4(tmp);
			
			if(count<4)eof=true;
			
			count=Math.min(count, n-total);
			
			for(int i=0;i<count;i++)
			{
				buf[total++]=tmp[i];
			}
		}
		return 0;
	
	}

	private static int read4(char[] tmp) {
		// TODO Auto-generated method stub
		return 0;
	}

}
