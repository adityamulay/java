

public class FindDayGiven1990 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int d=21;
		int m=1;
		int y=2023;
		findDay(d,  m,  y);

	}
	
	
	private static int countLeapYears(int m, int y) 
	{ 
	    int years = y; 
	  
	    // Check if the current year needs to be considered 
	    // for the count of leap years or not 
	    if (m <= 2) 
	        years--; 
	  
	    // An year is a leap year if it is a multiple of 4, 
	    // multiple of 400 and not a multiple of 100. 
	    return years / 4 - years / 100 + years / 400; 
	} 
	
	//To-Do : Check if missed any corner cases
	public static void findDay(int d, int m, int y)
	{
		final String[] differenceToDayMap =new String[] {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		
		final int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; 
		
		// 1-Jan-1990
		final int givenD=1;
		final int givenM=1;
		final int givenY=1990;
		
		//Calculate total days or input date 
	    long countForInput = y*365 + d; 
	    
	    //Consider days of current month too
	    for (int i=0; i<m - 1; i++) 
	    		countForInput += monthDays[i]; 
	    
	    //Consider Leap Year contribution
	    countForInput += countLeapYears(m,y); 
	    
	    // Same for Jan 1, 1990 
	    long  countFor1990 = givenY*365 + givenD; 
	    for (int i=0; i<givenM - 1; i++) 
	    		countFor1990 += monthDays[i]; 
	    countFor1990 += countLeapYears(givenM, givenY); 
	    
	    int difference=(int)(countForInput-countFor1990) % 7;
	    
	    if(difference < 0)
	    		difference = difference+7;
	    // return difference between two counts 
	    System.out.println(differenceToDayMap[difference]); 	
		
	}

}
