package math;
/*
 * @author Kirill Rumakin
 * @since 01.09.2019
 */

public final class Multiplication implements Operation {

	@Override
	public String operation() {
		return "*";
	}
	
	/*
	 * Implement multiplication function
	 * @param first - multiplier
	 * @param second - factor
	 * @return int product
	 */
	@Override
	public int arithmetical(int first, int second) {
		return first * second;
	}

}
