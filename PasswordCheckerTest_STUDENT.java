
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * STUDENT tests for the methods of PasswordChecker
 * @author 
 *
 */
public class PasswordCheckerTest_STUDENT {
	ArrayList<String> passwords;
	String pass1, pass2;

	@Before
	public void setUp() throws Exception {
		String[] pass = {"Door%1", "chacha", "f&f%f!F4950302", "eruyryu!!", "QWEyugj&76", "42892LFK%%"};
		
		passwords = new ArrayList<String>();
		passwords.addAll(Arrays.asList(pass));
	}

	@After
	public void tearDown() throws Exception {
		passwords = null;
	
	}

	/**
	 * Test if the password is less than 6 characters long.
	 * This test should throw a LengthException for second case.
	 */
	@Test
	public void testIsValidPasswordTooShort() {
    try {
        assertTrue(PasswordCheckerUtility.isValidPassword("789TreeKy$#2"));
        PasswordCheckerUtility.isValidPassword("d838!");
        assertTrue("Did not throw lengthException", false);
      } catch (LengthException e) {
        assertTrue("Successfully threw a lengthExcepetion", true);
      } catch (Exception e) {
        assertTrue("Threw some other exception besides lengthException", false);
      }
    }
	
	/**
	 * Test if the password has at least one uppercase alpha character
	 * This test should throw a NoUpperAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoUpperAlpha()
	{
	    try {
	        assertTrue(PasswordCheckerUtility.isValidPassword("Umbrella$##@1"));
	        PasswordCheckerUtility.isValidPassword("abcndne");
	        assertTrue("Did not throw NoUpperAlphaException", false);
	      } catch (NoUpperAlphaException e) {
	        assertTrue("Successfully threw a NoUpperAlphaExcepetion", true);
	      } catch (Exception e) {
	        assertTrue("Threw some other exception besides NoUpperAlphaException", false);
	      }
	    }
	/**
	 * Test if the password has at least one lowercase alpha character
	 * This test should throw a NoLowerAlphaException for second case
	 */
	@Test
	public void testIsValidPasswordNoLowerAlpha()
	{
    try {
        assertTrue(PasswordCheckerUtility.isValidPassword("tyrubi2837"));
        PasswordCheckerUtility.isValidPassword("!!!@@##%%%^^");
        assertTrue("Did not throw NoLowerAlphaException", false);
      } catch (NoLowerAlphaException e) {
        assertTrue("Successfully threw a NoLowerAlphaExcepetion", true);
      } catch (Exception e) {
        assertTrue("Threw some other exception besides NoLowerAlphaException", false);
      }
    }
	
	
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsWeakPassword()
	{
	    try {
	        assertEquals(true, PasswordCheckerUtility.isValidPassword("LAodsifds!!@#PPPPqo"));
	        boolean weakPwd = PasswordCheckerUtility.isWeakPassword("*&(fjsQW");
	        assertTrue(weakPwd);
	      } catch (Exception e)
	    	{
	        System.out.println(e.getMessage());
	        assertTrue("Threw some incorrect exception", false);
	      }
	    }
	
	/**
	 * Test if the password has more than 2 of the same character in sequence
	 * This test should throw a InvalidSequenceException for second case
	 */
	@Test
	public void testIsValidPasswordInvalidSequence()
	{
	    try {
	        assertEquals(true, PasswordCheckerUtility.isValidPassword("!QWEdfgtHYJu@"));
	        PasswordCheckerUtility.isValidPassword("PoooooolNoodleS");
	        assertTrue("Did not throw an InvalidSequenceException", false);
	      } catch (InvalidSequenceException e) {
	        assertTrue("Successfully threw an InvalidSequenceExcepetion", true);
	      } catch (Exception e) {
	        System.out.println(e.getMessage());
	        assertTrue("Threw some other exception besides an InvalidSequenceException", false);
	      }
	}
	
	/**
	 * Test if the password has at least one digit
	 * One test should throw a NoDigitException
	 */
	@Test
	public void testIsValidPasswordNoDigit() {
	try {
	      assertEquals(true, PasswordCheckerUtility.isValidPassword("QWertYuio11"));
	      PasswordCheckerUtility.isValidPassword("TotheMonAndBack");
	      assertTrue("Did not throw a NoDigitException", false);
	    } catch (NoDigitException e) {
	      assertTrue("Successfully threw a NoDigitException", true);
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	      assertTrue("Threw some other exception besides a NoDigitException", false);
	    }
	}
	
	/**
	 * Test correct passwords
	 * This test should not throw an exception
	 */
	@Test
	public void testIsValidPasswordSuccessful()
	{
		   try {
			      assertEquals(true, PasswordCheckerUtility.isValidPassword("QWer242_!pold"));
			      assertEquals(true, PasswordCheckerUtility.isValidPassword("AS&*L^gjfd2"));
			      assertEquals(true, PasswordCheckerUtility.isValidPassword("Pmlnk^%&sj1"));
			    } catch (Exception e) {
			      System.out.println(e.getMessage());
			      assertTrue("Threw some incorrect exception", false);
			    }
	}
	
	/**
	 * Test the invalidPasswords method
	 * Check the results of the ArrayList of Strings returned by the validPasswords method
	 */
	@Test
	public void testInvalidPasswords() {
		ArrayList<String> test;
	    test = PasswordCheckerUtility.getInvalidPasswords(passwords);
	    
		Scanner scan = new Scanner(test.get(0)); 
		assertEquals(scan.next(), "Door%1");
		String nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("lowercase"));
		
		
		scan = new Scanner(test.get(1)); //
		assertEquals(scan.next(), "chacha");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("special"));
		
		
		scan = new Scanner(test.get(2)); //
		assertEquals(scan.next(), "f&f%f!F4950302");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase"));
		
		
		scan = new Scanner(test.get(3)); //
		assertEquals(scan.next(), "eruyryu!!");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("uppercase") || nextResults.contains("digit"));
		
		
		scan = new Scanner(test.get(4));
		assertEquals(scan.next(), "QWEyugj&76");
		nextResults = scan.nextLine().toLowerCase();
		assertTrue(nextResults.contains("digit"));
		
		

	}
	
}
