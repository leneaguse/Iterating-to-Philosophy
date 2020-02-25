
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           TestDriver
// Files:           Jsoup - 1.10.3.jar
// Course:          Comp Sci 300, Spring 2019
//
// Author:          Lenea Guse
// Email:           laguse@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    N/A
// Partner Email:   N/A
// Partner Lecturer's Name: N/A
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         N/A
// Online Sources:  N/A
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Iterator;
import java.util.function.Function;

/**
 * A class that tests implemented methods
 * 
 */
public class TestDriver {

	public static void main(String[] args) {
		System.out.println(testEvenNumbers());
		System.out.println(testPowersOfTwo());
		System.out.println(testFiniteIterator());
		System.out.println(testGenerator());
		System.out.println(testSquaredDouble());
	}

	/**
	 * A method that tests the implementation of the EvenNumbers method
	 * 
	 * @returns true - if implemented correct false - otherwise
	 */
	public static boolean testEvenNumbers() {
		// creates a new instance of EvenNumbers
		EvenNumbers it = new EvenNumbers(44);
		// call the even number for the first time and checks if the number was the same
		// as the first
		if (it.next() != 44) {
			System.out.println("The first call of EvenNumbers.next() " +
					"did not return the value passed into its constructor.");
			return false;
		}
		// checks if the number incremented by two
		if (it.next() != 46) {
			System.out.println("The second call of EvenNumbers.next() "
					+ "did not return the smallest even number, " 
					+ "that is larger than the previously returned number.");
			return false;
		}
		// checks if the number incremented by two
		if (it.next() != 48) {
			System.out.println("The third call of EvenNumbers.next() " 
					+ "did not return the smallest even number, "
					+ "that is larger than the previously returned number.");
			return false;
		}
		// checks if hasNext always returns true
		if (it.hasNext() != true) {
			System.out.println("EvenNumbers.next() returned false, " 
					+ "but should always return true.");
			return false;
		}
		return true;
	}

	/**
	 * A method that checks if the PowersOfTwo method is implemented correctly
	 * 
	 * @returns true - if correctly implemented false - otherwise
	 */
	public static boolean testPowersOfTwo() {
		// creates a new instance of infiniteIterator
		InfiniteIterator<Integer> it = new InfiniteIterator<Integer>(8, new NextPowerOfTwo());
		// checks if the first call returns the original number passed in
		if (it.next() != 8) {
			System.out.println("The first call of InfiniteIterator.next() "
					+ "did not return the number passed into its constructor.");
			return false;
		}
		// checks if the next number returned is multiplied by two
		if (it.next() != 16) {
			System.out.println(
					"The second call of InfiniteIterator.next() " 
							+ "did not return the smallest power of two number, "
							+ "that is larger than the previously returned number.");
			return false;
		}
		// checks if the next number is multiplied by two
		if (it.next() != 32) {
			System.out.println(
					"The third call of InfiniteIterator.next() "
							+ "did not return the smallest power of two number, "
							+ "that is larger than the previously returned number.");
			return false;
		}
		// checks if hasNext always returns true
		if (it.hasNext() != true) {
			System.out.println("InfiniteIterator.next() returned false, "
					+ "but should always return true.");
			return false;
		}
		return true;
	}
	
	public static boolean testSquaredDouble() {
		// creates a new instance of infiniteIterator
		InfiniteIterator<Double> it = new InfiniteIterator<>(5.2 , new SquaredDouble());
		// checks if the first call returns the original number passed in
		if (it.next() != 5.2) {
			System.out.println("The first call of InfiniteIterator.next() "
					+ "did not return the number passed into its constructor.");
			return false;
		}
		// checks if the next number returned is multiplied by two
		System.out.println(it.next());
//		if (it.next() != 27.04) {
//			System.out.println(
//					"The second call of InfiniteIterator.next() " 
//							+ "did not return the smallest power of two number, "
//							+ "that is larger than the previously returned number.");
//			return false;
//		}
		// checks if the next number is multiplied by two
		if (it.next() != 731.1616) {
			System.out.println(
					"The third call of InfiniteIterator.next() "
							+ "did not return the smallest power of two number, "
							+ "that is larger than the previously returned number.");
			return false;
		}
		// checks if hasNext always returns true
		if (it.hasNext() != true) {
			System.out.println("InfiniteIterator.next() returned false, "
					+ "but should always return true.");
			return false;
		}
		return true;
	}

	/**
	 * A method that checks if the addExtraSmile was implemented correctly
	 * 
	 * @returns true - if implemented correctly false - if else
	 */
	public static boolean testAddExtraSmile() {
		// creates a new instance of InfiniteIterator
		InfiniteIterator<String> it = new InfiniteIterator<>("Hello", new AddExtraSmile());
		// checks if it returns the original passed in
		if (!it.next().equals("Hello")) {
			System.out.println("The first call of InfiniteIterator.next() "
					+ "did not return the string passed into its constructor.");
			return false;
		}
		// checks if a smiley was added
		if (!it.next().contains(" :)")) {
			System.out.println("The second call of InfiniteIterator.next() "
					+ "did not return the a string with one more :), "
					+ "than the previously returned string.");
			return false;
		}
		// checks if has next always returns true
		if (it.hasNext() != true) {
			System.out.println("InfiniteIterator.next() returned false, " 
					+ "but should always return true.");
			return false;
		}
		return true;
	}

	/**
	 * A method that tests if the finiteIterator is implemented correctly
	 * 
	 * @returns true - if implemented correctly false - otherwise
	 */
	public static boolean testFiniteIterator() {
		// creates a new instance of InfiniteIterator
		InfiniteIterator<Integer> infinite = new InfiniteIterator<>(2, new NextPowerOfTwo());
		// creates a new instance of FiniteIterator
		FiniteIterator<Integer> it = new FiniteIterator<>(infinite, 8);
		String s = "";
		// while hasNext is true
		while (it.hasNext())
			// add the string to the next returned
			s += " " + it.next();
		// checks if the returned is as expected
		if (!s.equals(" 2 4 8 16 32 64 128 256")) {
			System.out.println("Repeatedly called the next() method of a FiniteIterator,"
					+ "and the incorrect values were returned:" + s);
			return false;
		}
		return true;
	}

	/**
	 * A method that check the implementation of testGenerator
	 * 
	 * @returns true - if implemented correctly false - otherwise
	 */
	public static boolean testGenerator() {
		// creates a new instance of Generator
		Generator<Integer> newGen1 = new Generator<>(2, new NextPowerOfTwo(), 5);
		String str = "";
		// for each loop to get the integers returned from the iterator
		for (Integer newIt : newGen1) {
			str += " " + newIt;
		}
		// checks if the output was as expected
		if (str.equals(" 2 4 8 16 32")) {
			return true;
		}
		return false;
	}
}

class SquaredDouble implements Function<Double, Double> {
	
	public Double apply(Double previous) {
		return previous * previous;
	}
}

/**
 * A class that multiplies the number passed in by two
 * 
 */
class NextPowerOfTwo implements Function<Integer, Integer> {
	/**
	 * A method that multiplies the number passed in by two
	 * 
	 * @returns Integer - new number
	 */
	public Integer apply(Integer previous) {
		return 2 * previous;
	}
}

/**
 * A class that adds an extra smiley face to a string
 * 
 */
class AddExtraSmile implements Function<String, String> {
	/**
	 * A method that adds an extra smiley face to a string
	 * 
	 * @returns String - new string
	 */
	public String apply(String t) {
		return t + " :)";
	}
}
