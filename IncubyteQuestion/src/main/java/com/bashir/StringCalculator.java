package com.bashir;


public class StringCalculator {

	public int add(String numbers) throws NegativeNumberException
	{
		
		String defaultDelimiter = ",";
		String negativeNumbers = "";
		
		if(numbers.equals("")) // Returning 0 for empty string
		{
			return 0;
		}
		
		if(!numbers.contains(defaultDelimiter) && !(numbers.contains("\n")))  // String consists single number 
		{
			int number =  Integer.parseInt(numbers);
			if(number<0)
			{
				throw new NegativeNumberException("Negatives not allowed : "+number);
			}
			return number;
		}
		else {  // String consists multiple numbers
			
			String changeDefaultDelimiter = numbers.substring(0,2);

			if(changeDefaultDelimiter.equals("//"))
			{
				defaultDelimiter = numbers.substring(2,3);
				
				if(defaultDelimiter.equals("*") || defaultDelimiter.equals("+") || defaultDelimiter.equals("$") || defaultDelimiter.equals("^") || defaultDelimiter.equals("?"))
				{
				  defaultDelimiter = "\\"+defaultDelimiter;	
				}
				
				numbers = numbers.substring(3);
			}	
			
			int sum = 0;
			
			numbers.trim();
			String[] numbersArray = numbers.split(defaultDelimiter+"|\\r?\\n");
			for(String numberAsString:numbersArray)
			{
			   if(numberAsString.equals(""))
			   {}
			   else {
			   int number = Integer.parseInt(numberAsString);
			   if(number<0)
			   {
				   negativeNumbers = negativeNumbers+String.valueOf(number)+" ";
			   }
			   sum+=number;   
			   }
			}
			
			if(negativeNumbers.length()>0)
			{
				String exceptionMessage = "Negatives not allowed : "+negativeNumbers;
				throw new NegativeNumberException(exceptionMessage);
			}
			return sum;
		}
		
		
	}
	
}
