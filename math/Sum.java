package math;
/*
 * @author Kirill Rumakin
 * @since 01.09.2019
 */

public final class Sum implements Operation {

	@Override
	public String operation() {
		
		return "+";
	}

	/*
	 * Implement sum function
	 * @param first - first addendum
	 * @param second - second addendum
	 * @return sum
	 */
	@Override
	public int arithmetical(int first, int second) {
		return first + second;
	}

}
