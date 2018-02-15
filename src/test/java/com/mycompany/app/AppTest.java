package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	public void testFound() {
		ArrayList<String> array = new ArrayList<>(Arrays.asList("merhaba", "deneme", "Yaz", "selamlar"));
		ArrayList<String> array2 = new ArrayList<>(Arrays.asList("Hi", "Test", "Summer", "Greetings"));
		new App();
		assertTrue(App.advSearch(array, array2, 2, 5));
	}

	public void testNotFound() {
		ArrayList<String> array = new ArrayList<>(Arrays.asList("merhaba", "deneme", "test", "selamlar"));
		ArrayList<String> array2 = new ArrayList<>(Arrays.asList("Hi", "Test", "Summer", "Greetings"));

		new App();
		assertFalse(App.advSearch(array, array2, 2, 4));
	}

	public void testEmptyArray() {
		ArrayList<String> array = new ArrayList<>();
		ArrayList<String> array2 = new ArrayList<>();

		new App();
		assertFalse(App.advSearch(array, array2, 1, 1));
	}
	public void testOneEmptyArray() {
		ArrayList<String> array = new ArrayList<>();
		ArrayList<String> array2 = new ArrayList<>(Arrays.asList("merhaba", "deneme", "test", "selamlar"));

		new App();
		assertFalse(App.advSearch(array, array2, 1, 1));
		assertFalse(App.advSearch(array2, array, 1, 1));
	}

	public void testBothNull() {
		new App();
		assertFalse(App.advSearch(null, null, 1, 1));
	}

	public void testOneNull() {
		ArrayList<String> array1 = new ArrayList<>(Arrays.asList("Hi", "Test", "Summer", "Greetings"));
		assertFalse(App.advSearch(array1, null, 1, 1));
		assertFalse(App.advSearch(null, array1, 1, 1));

	}
}