package com.mycompany.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
      public void testFound() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList("merhaba","deneme","test","selamlar"));
      assertTrue(new App().search(array, 2,5));
    }

    public void testNotFound() {
      ArrayList<String> array = new ArrayList<>(Arrays.asList("merhaba","deneme","test","selamlar"));
      assertFalse(new App().search(array,2,4));
    }

    public void testEmptyArray() {
      ArrayList<String> array = new ArrayList<>();
      assertFalse(new App().search(array, 1,1));
    }

    public void testNull() {
      assertFalse(new App().search(null, 1,1));
    }
}