
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           NextWikiLink
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

import java.io.IOException;
import java.util.Scanner;
import java.util.function.Function;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * A class that allows for wiki links to be iterated through the jsoup extension
 * 
 * 
 */
public class NextWikiLink implements Function<String, String> {
	@Override
	public String apply(String t) {
		try {
			// Download a Wikipedia page, using t in their internal link format:
			// /wiki/Some_Subject
			Document doc = Jsoup.connect("https://en.wikipedia.org" + t).get();
			// Use .css selector to retrieve a collection of links from this page's
			// description
			// "p a" selects links within paragraphs
			// ":not([title^='Help'])" skips pronunciations
			// ":not(sup a)" skips citations
			Elements links = doc.select("p a:not([title^='Help']):not(sup a)");
			// return the link attribute from the first element of this list
			return links.get(0).attr("href");
			// Otherwise return an appropriate error message:
		} catch (IOException | IllegalArgumentException e) {
			return "FAILED to find wikipedia page: " + t;
		} catch (IndexOutOfBoundsException e) {
			return "FAILED to find a link in wikipedia page: " + t;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String topicName = "";
		// Implement your own Wikipedia crawling application here.
		// 1. prompt the user to enter a topic name and number of iterations to follow
		System.out.println("Enter a wikipedia page topic: ");
		topicName = sc.nextLine();
		topicName = topicName.trim();
		System.out.println("Enter the number of pages you'd like to step through: ");
		String iteratorNum = sc.nextLine();
		iteratorNum.trim();
		int itNum = Integer.parseInt(iteratorNum);
		// 2. prepend "/wiki/" to the user's input, and replace spaces with underscores
		topicName = topicName.replaceAll(" ", "_");
		topicName = "/wiki/" + topicName;
		// 3. use a for-each loop to iterate through the number of links requested
		Generator<String> newGen = new Generator<String>(topicName, new NextWikiLink(), itNum);
		String str = "";
		int constant = 0;
		// iterates through the generator iteration
		for (String newIt : newGen) {
			// checks if the string contains "Failed" to stop
			if (str.contains("FAILED")) {
				break;
			}
			// checks if the iteration is at its limit
			else if (constant <= itNum) {
				str = " " + newIt;
				System.out.println(str);
				constant++;
			}
		}
		sc.close();
	}
}
