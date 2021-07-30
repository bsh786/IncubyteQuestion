package com.bashir;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("In class StringCalculator testing")
class StringCalculatorTest {

	private static StringCalculator stringCalculator;
	
	@BeforeAll
	static void initialize()
	{
		stringCalculator = new StringCalculator();
	}
	
	@Test
	@DisplayName("the add() method for an empty String")
	void testEmptyString()
	{
	   int actual = stringCalculator.add("");
	   int expected = 0;
	   assertEquals(expected, actual, "when an empty string is passed, 0 should be returned");
	}
	
	@Test
	@DisplayName("the add() method for string consisting of a single number")
	void testSingleNumber()
	{
		assertAll(
		() -> assertEquals(5, stringCalculator.add("5"),"should return 5 when 5 is passed"),
		() -> assertEquals(234, stringCalculator.add("234"),"should return 234 when 234 is passed"),
		() -> assertEquals(71, stringCalculator.add("71"),"should return 71 when 71 is passed"));
		
	}
	
	@Test
	@DisplayName("the add() method for string consisting of two numbers")
	void testTwoNumbers()
	{
		assertAll(
		() -> assertEquals(20, stringCalculator.add("15,5"),"sum of 15 and 5 is 20"),
		() -> assertEquals(2, stringCalculator.add("1,1"),"sum of 1 and 1 is 2"),
		() -> assertEquals(450, stringCalculator.add("395,55"),"sum of 395 and 55 is 450"));
	}
	

}
