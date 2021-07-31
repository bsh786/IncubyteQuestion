package com.bashir;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@DisplayName("In class StringCalculator testing")
@TestMethodOrder(OrderAnnotation.class)
class StringCalculatorTest {

	private static StringCalculator stringCalculator;
	
	@BeforeAll
	static void initialize()
	{
		stringCalculator = new StringCalculator();
	}
	
	@Test
	@DisplayName("the add() method for an empty String")
	@Order(1)
//	@Disabled
	void testEmptyString() throws NegativeNumberException
	{
	   int actual = stringCalculator.add("");
	   int expected = 0;
	   assertEquals(expected, actual, "when an empty string is passed, 0 should be returned");
	}
	
	@Test
	@DisplayName("the add() method for string consisting of a single number")
    @Order(2)
//	@Disabled
	void testSingleNumber()
	{
		assertAll(
		() -> assertEquals(5, stringCalculator.add("5"),"should return 5 when 5 is passed"),
		() -> assertEquals(234, stringCalculator.add("234"),"should return 234 when 234 is passed"),
		() -> assertEquals(71, stringCalculator.add("71"),"should return 71 when 71 is passed"));
		
	}
	
	@Test
	@DisplayName("the add() method for string consisting of two numbers")
    @Order(3)
//	@Disabled
	void testTwoNumbers()
	{
		assertAll(
		() -> assertEquals(20, stringCalculator.add("15,5"),"sum of 15 and 5 is 20"),
		() -> assertEquals(2, stringCalculator.add("1,1"),"sum of 1 and 1 is 2"),
		() -> assertEquals(450, stringCalculator.add("395,55"),"sum of 395 and 55 is 450"));
	}
	
	@Test
	@DisplayName("the add() method for string consisting of multiple numbers")
    @Order(4) 
//	@Disabled
	void testMultipleNumbers()
	{
		assertAll(
		() -> assertEquals(140, stringCalculator.add("15,5,20,25,35,40"),"string containing multiple numbers should return its sum"),
		() -> assertEquals(11, stringCalculator.add("1,1,1,1,1,1,1,1,1,1,1"),"string containing multiple numbers should return its sum"),
		() -> assertEquals(2721, stringCalculator.add("395,55,792,817,645,12,5"),"string containing multiple numbers should return its sum"));
	}
	
	@Test
	@DisplayName("the add() method for strings containing new lines")
    @Order(5) 
//	@Disabled
	void testStringsWithNewLines()
	{
		assertAll(
		() -> assertEquals(80, stringCalculator.add("20\n15\n25\n20"),"Strings containing new lines should return the sum of the numbers present in the string"),
		() -> assertEquals(27, stringCalculator.add("1,2,3\n4,5,6\n1,2,3"),"Strings containing new lines should return the sum of the numbers present in the string"),
		() -> assertEquals(12, stringCalculator.add("\n12\n"),"Strings containing new lines should return the sum of the numbers present in the string"));
	}
	
	@Test
	@DisplayName("the add() method for used defined delimiters")
	@Order(6)
	void testWithDifferentDelimiters()
	{
		assertAll(
		() -> assertEquals(560, stringCalculator.add("//@\n10@100@200@250"),"Strings containing user defined delimiters return the sum of the numbers present in the string"),
		() -> assertEquals(9, stringCalculator.add("//#\n1#1#1\n1#1#1\n1#1#1"),"Strings containing user defined delimiters return the sum of the numbers present in the string"),
		() -> assertEquals(2424, stringCalculator.add("//*\n123*765*892\n432\n154*56*2"),"Strings containing user defined delimiters return the sum of the numbers present in the string"));
	}
	
	@Test
	@DisplayName("the add() method for negative numbers")
	@Order(7)
	void testNegativeNumbers()
	{
		assertAll(
		() -> assertThrows(NegativeNumberException.class, () -> stringCalculator.add("-25"), "Exception should be thrown when a negative number is passed"),
		() -> assertThrows(NegativeNumberException.class, () -> stringCalculator.add("-15,25"), "Exception should be thrown when a negative number is passed"),
		() -> assertThrows(NegativeNumberException.class, () -> stringCalculator.add("20,25,30,-40,50,-60,-70,-75,-80,-85"), "Exception should be thrown when a negative number is passed"),
		() -> assertThrows(NegativeNumberException.class, () -> stringCalculator.add("//&\n-20&10&-30&-40&45&-50&-55"), "Exception should be thrown when a negative number is passed"),
		() -> assertThrows(NegativeNumberException.class, () -> stringCalculator.add("30,35\n-50"), "Exception should be thrown when a negative number is passed"),
		() -> assertThrows(NegativeNumberException.class, () -> stringCalculator.add("//+\n25+26+27\n-10+-20+-30\n12+20+-40"), "Exception should be thrown when a negative number is passed"));
		
		
	}
	
	@Test
	@DisplayName("the getCalledCount() method to get count of the number of times add method is invoked")
	@Order(8)
	void testAddCount()
	{
		int actual = stringCalculator.getCalledCount();
		int expected = 22;
		assertEquals(expected,actual,"getCalledCount() method should return the number of times add() method is invoked");
	}
	
	@Test
	@DisplayName("the add() method for numbers greater than 1000")
	void testNumbersGreaterThanThousand()
	{
		assertAll(
		() -> assertEquals(0, stringCalculator.add("12000"),"Numbers greater than 1000 should be ignored"),
		() -> assertEquals(5, stringCalculator.add("8000,5"),"Numbers greater than 1000 should be ignored"),
		() -> assertEquals(2100, stringCalculator.add("5000,4000,500,400,1000,13564,6789,98773,200"),"Numbers greater than 1000 should be ignored"),
		() -> assertEquals(1500, stringCalculator.add("//^\n2500^500^485334\n2444234^500\n500^343434^1001"),"Numbers greater than 1000 should be ignored"));
	}
	

	

}
