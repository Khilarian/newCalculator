package appRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import convert.RomanToArabicAndBack;
import input.InputChecker;
import math.Calculator;

/*
 * @author Kirill Rumakin
 * @since 02.09.2019
 * Calculator application
 */
public class AppRunner {

	public static void main(String[] args) throws MyException {
		
		Calculator calc = new Calculator();
		InputChecker ic = new InputChecker();
		RomanToArabicAndBack rt = new RomanToArabicAndBack();
		
		calc.calculate(ic.returnFirstNumeral(), ic.returnSecondNumeral(), ic.returnOperation());
		
		System.out.print("Result of calculation:\t");
		
		if (!ic.returnRoman()) {
			System.out.print(calc.getResult());
		}
		else {
			System.out.print(rt.convertToRoman(calc.getResult()));
		}
		
	}
	
	
}
