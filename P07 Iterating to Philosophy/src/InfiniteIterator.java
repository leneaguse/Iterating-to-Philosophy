
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           InfiniteIterator
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
 * A class that creates an infinite iterator and will call the function that
 * applies to its type (PowersOfTwo or AddExtraSmiley)
 * 
 */
public class InfiniteIterator<T> implements Iterator<T> {
	private T in;
	private Function<T, T> theFunc;
	private boolean firstTime;
	private T newIn;

	/**
	 * Constructor that initializes parameters for the InfiniteIterator class
	 * 
	 * @param T in - a generic type of parameter passed in Function <T,T> - a
	 *          generic type of function passed in
	 */
	public InfiniteIterator(T in, Function<T, T> a) {
		firstTime = true;
		this.in = in;
		theFunc = a;
	}

	/**
	 * A method that always returns true for the infiniteIterator
	 * 
	 * @returns true always
	 */
	public boolean hasNext() {
		return true;
	}

	/**
	 * Calls for the next action to occur depending on the generic type specified
	 * 
	 * @returns T - String or Integer
	 */
	public T next() {
		// checks if it's the first time calling next
		if (firstTime) {
			// changes to false after the first time
			firstTime = false;
			return in;
		} else {
			// calls the function that coincides with the type
			newIn = theFunc.apply(in);
			this.in = newIn;
			return newIn;
		}
	}
}
