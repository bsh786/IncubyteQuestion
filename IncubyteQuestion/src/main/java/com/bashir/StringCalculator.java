package com.bashir;


public class StringCalculator {
	

	private int addInvokedCount = 0;
	
	public int add(String numbers) throws NegativeNumberException
	{
		
		addInvokedCount++;
		
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
			if(number>1000)
			{
				number = 0;
			}
			return number;
		}
		else {  // String consists multiple numbers
			
			String changeDefaultDelimiter = numbers.substring(0,2);

			if(changeDefaultDelimiter.equals("//"))
			{
				
			  if(numbers.contains("[") && numbers.contains("]"))
			  {
				  int startIndex = numbers.indexOf("[");
				  int endIndex = numbers.indexOf("]");
				  
				  defaultDelimiter = numbers.substring(startIndex+1, endIndex);
			      
				  if(defaultDelimiter.contains("*")||defaultDelimiter.contains("+")||defaultDelimiter.contains("$")||defaultDelimiter.contains("^")||defaultDelimiter.contains("?"))
				  {
					  char[] delimiterArray = defaultDelimiter.toCharArray();
				      String newDelimiter = "";
					  
					  for(int i=0;i<delimiterArray.length;i++)
					  {
						  if(delimiterArray[i]=='*'||delimiterArray[i]=='+'||delimiterArray[i]=='$'||delimiterArray[i]=='^'||delimiterArray[i]=='?')
						  {
							  newDelimiter = newDelimiter+"\\"+delimiterArray[i];
						  }
						  else {
							  newDelimiter = newDelimiter+delimiterArray[i];
						  }
					  }
					  
					  defaultDelimiter = newDelimiter;
				  
				  }
				  
				  numbers = numbers.substring(endIndex+1);
			      
			  }
			  else {
				
			// Code for single one digit delimiter starts	
				defaultDelimiter = numbers.substring(2,3);
				
				if(defaultDelimiter.equals("*") || defaultDelimiter.equals("+") || defaultDelimiter.equals("$") || defaultDelimiter.equals("^") || defaultDelimiter.equals("?"))
				{
				  defaultDelimiter = "\\"+defaultDelimiter;	
				}
				
				numbers = numbers.substring(3);
				
			// Code for single one digit delimiter ends	
			}	
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
			   if(number>1000)
			   {
				   number=0;
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

	public int getCalledCount()
	{
		return addInvokedCount;
	}
}
