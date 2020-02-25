
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           FiniteIterator
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

/**
 * A class that creates an iterator that iterates a specified number of times
 * using the InfiniteIterator class
 * 
 */
public class FiniteIterator<T> implements Iterator<T> {
	private int length;
	private InfiniteIterator<T> a;

	/**
	 * A constructor that initializes the parameters for the instance of iterator
	 * 
	 * @param InfiniteIterator length - number of times to iterate
	 */
	public FiniteIterator(InfiniteIterator<T> a, int length) {
		this.a = a;
		this.length = length;
	}

	/**
	 * A method that checks if the next method can continue by checking how many
	 * times the iterator has iterated
	 * 
	 * @returns true - if it hasnt reached the length false - if yet to reach the
	 *          length
	 */
	public boolean hasNext() {
		// checks if at the length of iterations
		if (this.length > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * A method that calls the next action if the length hasn't been reached
	 * 
	 * @returns T - String or Integer
	 */
	public T next() {
		T tempNext;
		// checks if at length
		if (hasNext()) {
			// decrements length
			this.length -= 1;
			// returns the next iteration
			return a.next();
		}
		return null;
	}

}
