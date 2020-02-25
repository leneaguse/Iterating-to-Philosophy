//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           EvenNumbers
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
 * A class that allows for an instance of a number to be incremented by 2
 * if this is the first time calling the next method, the next method will return that number
 * 
 */
public class EvenNumbers implements Iterator<Integer> {
	private Integer in;
	private boolean firstTime;

	/**
	 * Constructor that initializes parameters for the EvenNumbers class
	 * 
	 * @param Interger in - used as a base number for what will be incremented by 2
	 */
	public EvenNumbers(Integer in) {
		this.in = in;
		firstTime = true;
	}
	/**
	 * checks if a next number is available for the next() method
	 * 
	 * @return always returns true
	 */
	public boolean hasNext() {
		return true;
	}
	/**
	 * Increments this.in by two and returns that number
	 * (the next smallest even number)
	 * Returns the original number the first time
	 * 
	 * @returns Integer this.in - next smallest even number 
	 */
	public Integer next() {
		//checks if this is the first time calling this method
		if (firstTime) {
			//changes to false after the first time
			firstTime = false;
			return this.in;
		} else {
			//increment by 2
			this.in += 2;
			return this.in;
		}
	}

}
