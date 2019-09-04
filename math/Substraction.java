package math;
/*
 * @author Kirill Rumakin
 * @since 01.09.2019
 */

public final class Substraction implements Operation {

	@Override
	public String operation() {
		
		return "-";
	}
	
	/*
	 * Implement substruction function
	 * @param first - minuend
	 * @param second - subtrahend
	 * @return odds
	 */
	@Override
	public int arithmetical(int first, int second) {
		return first - second;
	}

}
