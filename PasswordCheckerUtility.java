import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * 
 * @author EGREGG
 * Validates that a password entered by the user meets the required specifications. 
 * 
 * 
 */
public class PasswordCheckerUtility {
	
	public static boolean isValidPassword(String str1)
		throws LengthException, NoDigitException, NoUpperAlphaException,NoLowerAlphaException, InvalidSequenceException, NoSpecialCharacterException{
		return isValidLength(str1) && hasNumeric(str1) && hasSpecial(str1) && hasUpperAlpha(str1) && hasLower(str1) && isValidSequence(str1) ;
	}
	
	public static boolean isValidLength(String str1){
		if (str1.length() >= 6) {
			return true;
		}
		throw new LengthException();
			
	}
	
	private static boolean hasNumeric(String str1) {
		for (Character c: str1.toCharArray()) {
			if (Character.isDigit(c)) {
				return true;
			}
		}
		throw new NoNumericException();
	}
	
	private static boolean hasSpecial(String str1) {
		Pattern pattern = Pattern.compile("[^A-Za-z0-9]");
		Matcher matcher = pattern.matcher(str1);
		if (!matcher.find()) {
			throw new NoSpecialCharacterException();
		}
		return true;
	}
	
	public static boolean hasUpperAlpha(String str1) {
		for (Character c : str1.toCharArray()) {
			if (Character.isUpperCase(c)) {
				return true;
			}
		}
		throw new NoUpperAlphaException();
	}
	
	private static boolean hasLower(String str1) {
		for (int i=0; i < str1.length(); i++) {
			if (Character.isLowerCase(str1.charAt(i))){
				return true;
			}
		}
		throw new NoLowerAlphaException();
	}
	
	private static boolean noRepeating(String str1) {
		for (int i = 0; i < str1.length() - 2; i++) {
			if (str1.charAt(i) == str1.charAt(i + 1)) {
				throw new InvalidSequenceException();
			}
		}
		return true;
	}
	
	private ArrayList<String> myNumbers() {
		ArrayList<String> passWordList = new ArrayList<String>();
		
		return passWordList;
	}

	public static boolean isWeakPassword(String str1){
		if (isValidLength(str1) && str1.length() < 10) {
			throw new WeakPasswordException();
		}
		return true;
	}

	public static ArrayList<String> getInvalidPasswords(ArrayList<String> passwords) {
	    ArrayList<String> invalidPasswords = new ArrayList<>();
	    for (String s : passwords) {
	      try {
	        isValidPassword(s);
	      } catch (Exception ex) {
	        invalidPasswords.add(s + " " + ex.getMessage());
	      }
	    }
	    return invalidPasswords;
	}
	
	private static boolean isValidSequence(String str1) {
	    for (int i = 0; i < str1.length() - 2; i++) {
	        if (str1.charAt(i) == str1.charAt(i + 1)) {
	          if (str1.charAt(i + 1) == str1.charAt(i + 2)) {
	            throw new InvalidSequenceException();
	          }
	        }
	      }
	      return true;
	}
	
	public static boolean comparePasswords(String str1, String str2) {
		if (str1 != str2){
			throw new UnmatchedException();
		}
		return true;
	}

	public static boolean comparePasswordsWithReturn(String str1, String str2) {
		if (str1.equals(str2)) {
			return true;
		}
		
		throw new UnmatchedException();
	}
	
	public static boolean hasDigit(String str1) {
		for (Character c : str1.toCharArray()) {
			if (Character.isDigit(str1.charAt(c))) {
				return true;
		}
		}
		throw new NoDigitException();
	
	}
}
