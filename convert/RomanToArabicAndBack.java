package convert;
import java.util.ArrayList;
import java.util.List;
/*
 * @author Kirill Rumakin
 * @since 04.09.2019
 * Class that convert arabic number to roman and back
 */

public class RomanToArabicAndBack {
	
	/*
	 * Method that convert arabic number to roman
	 * @param number - arabic representation of number
	 * @return roman representation of number
	 */
	public static String convertToRoman(int number) {
	    if (number < 0 || number > 3999) {
	        return "This number cannot be converted(less than 1 or greater than 3999)";
	    }

	    String romanOnes = romanDigit(number % 10, "I", "V", "X");
	    number /= 10;
	    String romanTens = romanDigit(number % 10, "X", "L", "C");
	    number /= 10;
	    String romanHundreds = romanDigit(number % 10, "C", "D", "M");
	    number /= 10;
	    String romanThousands = romanDigit(number % 10, "M", "", "");
	    number /= 10;
	    String result = romanThousands + romanHundreds + romanTens + romanOnes;
	    return result;
	}
	
	/*
	 * Helper method that calculate that represent every number order
	 * @param n - arabic representaion of number
	 * @param one - smallest roman numerical in nember order
	 * @param five - medium roman numerical in nember order
	 * @param ten - highest roman numerical in nember order
	 * @return roman representation of number order
	 */
	private static String romanDigit(int n, String one, String five, String ten){
		String result;
	    switch (n) {
	    	case 1: result= one;
	        break;
	    	case 2: result= one + one;
	        break;
	    	case 3: result= one + one + one;
	        break;
	    	case 4: result= one + five;
	        break;
	    	case 5: result= five;
	        break;
	    	case 6: result= five + one;
	        break;
	    	case 7: result= five + one + one;
	        break;
	    	case 8: result= five + one + one + one;
	        break;
	    	case 9: result= one + ten;
	        break;
	    	default: result = "";
	    	break;
	    }
	    return result;
	}
	

	/*
	 * Method that convert roman number to arabic
	 * @param number - roman representation of number
	 * @return arabic representation of number
	 */
	public static int convertToArabic(String number) {
		
		
		//create List of roman numerical
		List<String> listOfRoman = new ArrayList<String>();
		int result = 0;
		for (int i = 0; i < number.length(); i++) {
			///if only one letter, than number equals numerical
			if (number.length()==1) {
				listOfRoman.add(number);
				break;
			}
			//for last numerical check- if previous numerical is greater, add to List
			if (i == number.length()-1) {
				if (Roman.valueOf(String.valueOf(number.charAt(i))).toInt() <= Roman.valueOf(String.valueOf(number.charAt(i-1))).toInt()) {
					listOfRoman.add(String.valueOf(number.charAt(i)));
				}
			}
			
			//add all numerical to List
			else {
				String currChar = ("" + number.charAt(i));
				String nextChar = Character.toString(number.charAt(i+1));
				//if current numerical greater than next, add to List
				if (Roman.valueOf(currChar).toInt() >= Roman.valueOf(nextChar).toInt()) {
					listOfRoman.add(currChar);
				}
				//else check conditions and if OK, add to List 
				else if((currChar.equals("I") && (nextChar.equals("V") || nextChar.equals("X")))||
						(currChar.equals("X") && (nextChar.equals("L") || nextChar.equals("C")))||
						(currChar.equals("C") && (nextChar.equals("D") || nextChar.equals("M")))) {
					String combString = currChar + nextChar;
					listOfRoman.add(combString);
					i++;
				}
				
				else {
					System.out.println("Incorrect roman input");
					return -1;
				}
			}
		}
		
		//if List size is one numerical, convert it
		if (listOfRoman.size()==1) {
			String first = listOfRoman.get(0);
			int firstInt = oneSignConvert(first);
			return firstInt;
		}
		//else if previous > next than add numerical to result
		else {
			for (int i = 1 ; i < listOfRoman.size() ; i++) {
				String first = listOfRoman.get(i-1);
				String second = listOfRoman.get(i);
				int firstInt = oneSignConvert(first);
				int secondInt = oneSignConvert(second);
				if (firstInt < secondInt) {
					System.out.println("Incorrect roman input");
					return -1;
				}
				else {
					result+=firstInt;
					if ( i == listOfRoman.size()-1) {
						result+=secondInt;
					}
				}
			}
			return result;
		}
	}
	
	
	/*
	 * This method convert one roman numeral to arabic
	 * @param number is String roman numeral
	 * @return arabic values 
	 */
	private static int oneSignConvert(String number) {
		int result = 0;
		//if roman numeral sign consist of two letter, calculate it in right way
		//its numeral like IV(4), XL(40), etc.
		if (number.length()>1) {
			result = Roman.valueOf(String.valueOf(number.charAt(1))).toInt()-Roman.valueOf(String.valueOf(number.charAt(0))).toInt();
		}
		//if roman numeral is in one letter, just convert it
		else {
			result = Roman.valueOf(number).toInt();
		}
		return result;
	}
}
