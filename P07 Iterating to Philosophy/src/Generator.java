
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Generator
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
 * A class that allows as a way to create an infiniteIterator or FiniteIterator
 */
public class Generator<T> implements Iterable<T> {
	private T firstValue;
	private Function<T, T> generateNextFromLast;
	private int length;
	private InfiniteIterator<T> a;
	private FiniteIterator<T> b;

	/**
	 * A constructor that initializes values
	 * 
	 * @param firstValue - the first value the iterator should start at
	 *                   Function<T,T> - the function to be used
	 */
	public Generator(T firstValue, Function<T, T> generateNextFromLast) {
		this.generateNextFromLast = generateNextFromLast;
		this.firstValue = firstValue;
	}

	/**
	 * A constructor that initializes values
	 * 
	 * @param firstValue - the first value the iterator should start at
	 *                   Function<T,T> - the function to be used length - how many
	 *                   times to iterate
	 */
	public Generator(T firstValue, Function<T, T> generateNextFromLast, int length) {
		this.firstValue = firstValue;
		this.generateNextFromLast = generateNextFromLast;
		this.length = length;
	}

	/**
	 * A method that iterates depending on the instance
	 * 
	 * @return Iterator - the iteration of specified type
	 */
	public Iterator<T> iterator() {
		// creates a new instance of InfiniteIterator
		InfiniteIterator<T> infiniteIterator =
				new InfiniteIterator<>(firstValue, generateNextFromLast);
		// checks if length is not 0
		if (this.length != 0) {
			// creates a new instance of FiniteIterator
			FiniteIterator<T> finiteIterator = new FiniteIterator<>(infiniteIterator, length);
			return finiteIterator;
		} else {
			return infiniteIterator;
		}
	}
}
