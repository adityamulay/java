import java.util.*;

public class BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculate("-2*5+6+4");
		
		calculateParenth("6-4/2");
		calculateParenth("3+2*5+(6+4*3)");

	}
	
	public static void calculate(String input)
	{
		Stack<Integer> num=new Stack<>();
		
		int number=0;
		char sign='+';
		int result=0;
		
		for(int i=0;i<input.length();i++)
		{
			char c=input.charAt(i);
			if(Character.isDigit(c))
			{
				number=number*10 + (c-'0');
			}
			
			if(!Character.isDigit(c) || i==input.length()-1)
			{
				if(sign=='-')
                    num.push(-number);
				
				if(sign=='+')
                    num.push(number);
				
				if(sign=='*')
                    num.push(num.pop()*number);
				
				if(sign=='/')
                    num.push(num.pop()/number);
				
				sign=c;
				number=0;
			
			}
	        
		}
		
		for(int val:num)
    			result += val;
		
		System.out.println("Answer is : "+result);
	}
	
	public static void calculateParenth(String input)
	{
		Stack<Integer> num=new Stack<>();
		Stack<Character> ops=new Stack<>();
		
		for(int i=0;i<input.length();i++)
		{
			char c=input.charAt(i);
			
			if(Character.isDigit(c))
			{
				StringBuilder sbuf = new StringBuilder(); 
                // There may be more than one digits in number 
                while (i < input.length() && Character.isDigit(input.charAt(i))) 
                    sbuf.append(input.charAt(i++)); 
                i--;
                	num.push(Integer.parseInt(sbuf.toString())); 

			}
			else if (c == '(') 
			{
                ops.push(c); 
			}
            else if (c == ')') 
            {
            		while(ops.peek() != '(')
            		{
            			num.push(apply(ops.pop(), num.pop(), num.pop()));
            		}
            		ops.pop();
            }
            else if (c == '+' || c == '-' || c == '*' || c == '/') 
            {
            		while (!ops.empty() && precedence(c)<=precedence(ops.peek())) {
            				num.push(apply(ops.pop(), num.pop(), num.pop())); 
            		}
   
                  ops.push(c);
            
            }

		}
		
		while (!ops.empty()) 
            num.push(apply(ops.pop(), num.pop(), num.pop())); 
		
		System.out.println("Answer is : "+num.pop());
	
	}
	
	public static int precedence(char operator)
	{
		switch(operator)
		{
			case '+' : return 1;
			case '-' : return 1; 
	        case '*' : return 2; 
	        case '/' : return 2;
		}
		return 0;
	
	}
	
	public static int apply(char operator, int num1, int num2)
	{
		switch(operator)
		{
			case '+' : return num2+num2;
			case '-' : return num2 - num1; 
	        case '*' : return num2 * num1; 
	        case '/' : 
			            if (num2 == 0) 
			                throw new UnsupportedOperationException("Cannot divide by zero"); 
			            return num2 / num1; 
        }
		
        return 0; 
					
	}
	

}
