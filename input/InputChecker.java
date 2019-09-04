package input;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import appRunner.MyException;
import convert.RomanToArabicAndBack;

/*
 * @author Kirill Rumakin
 * @since 01.09.2019
 * This class took users input, makes checks on errors in input,
 * split input on parameters that calculator need in.
 */

public class InputChecker {
	
	private Integer firstNumeral;
	private Integer secondNumeral;
	private String operation;
	private boolean isRoman;
	

	public InputChecker() throws MyException {
		
		
		//Read users input
		String input = input();
		
		//Create list of possible numerical
		List<String>inputValueList = getTokens("[^-+*/]+", input);
		
		//Took sign of operation
		this.operation = getTokens("[-+*/]", input).get(0);
		
		
		//Create object that convert roman to arabic and back
		RomanToArabicAndBack rt = new RomanToArabicAndBack();
		
		//Check if input number is roman
		this.isRoman = isRoman(inputValueList);
		
		//assign number for calculator as int
		if (!isRoman) {
			this.firstNumeral = Integer.parseInt(inputValueList.get(0));
			this.secondNumeral = Integer.parseInt(inputValueList.get(1));
		}
		else {
			this.firstNumeral = rt.convertToArabic(inputValueList.get(0));
			this.secondNumeral = rt.convertToArabic(inputValueList.get(1));
		}
		
		//check- is number is in range
		if (!rightValues()) {
			throw new MyException("Incorrect input. Numbers must be greater than or equals 1 and less than or equals 10!");
		}
	}
	
	/*
	 *Method read users input and compare with calculator inputs structure
	 *@return users input as String 
	 */
	private String input() throws MyException {
		Scanner reader = new Scanner(System.in);
		System.out.println("Input what you need to calculate in next format:\n number sigh number.\n"
				+ "Both numeral must be roman(from 1 to 10 include) or arabic(from I to X incude).\n"
				+ "Sign can be: +,-,* or /.\n");
		
		//to compare with roman number we need to use upper case
		String operation = reader.next().toUpperCase();
		reader.close();
		
		
		
		if (operation.equals("")) {
			throw new MyException("Input can not be empty!");
		}
		
		//check- is input is in correct way(both number are roman or arabic,
		//is operations sign between then and it's only one
		if (!operation.matches("(\\d+)[-+*/](\\d+)") && !operation.matches("[IVXLC]+[-+*/][IVXLC]+")) {
			throw new MyException("Incorrect input. Check numeral or sign!");
		}
		
		return operation;
	}
	
	
	/*
	 * This method helps to split users input
	 * @param pattern - regex, what we are looking for
	 * @param text - where are we looking pattern
	 * @return List of String, which we looking in text via regex
	 * 
	 */
	private List<String> getTokens(String pattern, String text)
	{
		ArrayList<String> tokens = new ArrayList<String>();
		Pattern tokSplitter = Pattern.compile(pattern);
		Matcher m = tokSplitter.matcher(text);
		
		while (m.find()) {
			tokens.add(m.group());
		}
		
		return tokens;
	}
	
	/*
	 * Method checks- is input String is a arabic number(int)
	 * @param word - String, that we check
	 * @return true if input is arabic
	 */
	private boolean isArabic(String word) {
		 try {
		        Integer.parseInt(word);
		        return true;
		    } catch (NumberFormatException e) {
		        return false;
		    }
	}
	/*
	 * Method checks - if input is not arabic, than it roman(we use check on input before)
	 * @param inputList - List of String that we examine
	 * @return true if input is roman
	 */
	private boolean isRoman(List<String> inputList) {
		if (!isArabic(inputList.get(0)) && !isArabic(inputList.get(1))) {
			return true;
		}
		return false;
	}
	
	/*
	 * Method checks is the number inputs are expected the rules
	 * @return true if all OK
	 */
	private boolean rightValues() {
		if ((firstNumeral < 1 || firstNumeral > 10) || (secondNumeral < 1 || secondNumeral > 10)) {
			return false;
		}
		return true;
	}
	
	/*
	 * @return int representation of first number
	 */
	public Integer returnFirstNumeral(){
		return new Integer(firstNumeral);
	}
	/*
	 * @return int representation of second number
	 */
	public Integer returnSecondNumeral(){
		return new Integer(secondNumeral);
	}
	/*
	 * @return String representation of sign of arithmetical operation
	 */
	public String returnOperation() {
		return new String(operation);
	}
	/*
	 * @return true if input number is roman
	 */
	public boolean returnRoman() {
		boolean result = isRoman;
		return result;
	}
	
}
