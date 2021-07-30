package com.bashir;


public class StringCalculator {

	public int add(String numbers)
	{
		if(numbers.equals("")) // Returning 0 for empty string
		{
			return 0;
		}
		
		if(!numbers.contains(",") && !(numbers.contains("\n")))  // String consists single number 
		{
			int number =  Integer.parseInt(numbers);
			return number;
		}
		else {  // String consists multiple numbers
			
			int sum = 0;
			
			numbers.trim();
			String[] numbersArray = numbers.split(",|\\r?\\n");
			for(String numberAsString:numbersArray)
			{
			   if(numberAsString.equals(""))
			   {}
			   else {
			   int number = Integer.parseInt(numberAsString);
			   sum+=number;   
			   }
			}
			return sum;
		}
		
		
	}
	
}
