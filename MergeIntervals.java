import java.util.*;

public class MergeIntervals {
	
	static class Interval{
		int start,end;
		Interval(int x, int y){
			start=x;
			end=y;
		}
	}
	
	static class intervalComparator implements Comparator<Interval>
	{
		public int compare(Interval a, Interval b) {
			return a.start-b.start;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] intervals=new int[5][2];
		intervals[0]= new int[]{1,3};
		intervals[1]= new int[]{2,5};
		intervals[2]= new int[]{4,7};
		intervals[3]= new int[]{8,10};
		intervals[4]= new int[]{10,12};
		
		
		List<Interval> inter=new LinkedList<Interval>();
		
		for(int i=0;i<intervals.length;i++) {
			Interval temp=new Interval(intervals[i][0],intervals[i][1]);
			inter.add(temp);
		}
		Collections.sort(inter,new intervalComparator());
		
		mergeIntervals(inter);

	}
	
	public static void mergeIntervals(List<Interval> input)
	{
		List<Interval> result=new LinkedList<Interval>();
		int start=input.get(0).start;
		int end=input.get(0).end;
		input.remove(0);
		
		Iterator<Interval> it=input.listIterator();
		
		while(it.hasNext()) {
			Interval tmp=it.next();
			if(tmp.start<end) {
				end=Math.max(end, tmp.end);
			}else {
				result.add(new Interval(start,end));
				start=tmp.start;
				end=tmp.end;
			}
			
		}
		//for last interval
		result.add(new Interval(start,end));
		
		for(Interval e :result) {
			System.out.println("start : "+e.start+" end : "+e.end);
		}
		
	}

}
