import java.util.*;
import java.util.concurrent.Semaphore;

public class LeetCode {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Integer.MAX_VALUE);
		
		System.out.println(Integer.parseInt("-0",16));
		System.out.println(Math.pow(62,7));

		String slasht = "test";
		System.out.println(slasht.lastIndexOf("\t"));
		
		HashMap<Integer,String> hm=new HashMap<Integer, String>();
		
		hm.put(341, "Flatten List Iterator");
		hm.put(341, "Flatten List Iterator");
		
		for(String s:hm.values())
		{
			System.out.println(s);
		}
		
		
		List<Integer> list = new ArrayList();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		
		list.remove(1);
		System.out.println(list);
		
		Semaphore s = new Semaphore(0);
		s.acquire();

	}

}
