package com.bashir;


public class StringCalculator {

	public int add(String numbers)
	{
		if(numbers.equals("")) // Returning 0 for empty string
		{
			return 0;
		}
		
		if(!numbers.contains(","))  // String consists single number 
		{
			int number =  Integer.parseInt(numbers);
			return number;
		}
		else {
			
			int sum = 0;
			
			String[] numbersArray = numbers.split(",");
			for(String numberAsString:numbersArray)
			{
			   int number = Integer.parseInt(numberAsString);
			   sum+=number;   
			}
			
			return sum;
		}
		
		
	}
	
}
