package math;
/*
 * @author Kirill Rumakin
 * @since 01.09.2019
 */

public final class Division implements Operation {

	@Override
	public String operation() {
		return "/";
	}

	/*
	 * Implement division function
	 * @param first - dividend
	 * @param second - divider
	 * @return int quotient
	 */
	@Override
	public int arithmetical(int first, int second) {
		int result;
		if (second != 0) {
			result = first/second;
		}
		else {
			throw new ArithmeticException("cannot be divided by zero");
		}
		return result;
	}

}
