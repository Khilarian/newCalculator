package convert;
/*
 * @author Kirill Rumakin
 * @since 01.09.2019
 * enum class to represent one-sign roman numerical and their 
 * arabic equals
 */

public enum Roman {
	I(1), V(5), X(10), L(50), C(100), D(500), M(1000);
    private final int value;
    
    /*
     * enum constructor, which add arabic representation for roman numerical
     * @value is arabic numerical
     */
    private Roman(int value) {
        this.value = value;
    }
    
    /*
     * @return arabic numerical
     */
    public int toInt() {
        return value;
    }
}
