package math;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @author Kirill Rumakin
 * @since 01.09.2019
 * Basic calculator class that has 4 arithmetical operation,
 * tooks two numbers and operation and make calculation
 */

public class Calculator {
	
	private int result;
	/*
	 * @param operation is a map of operation. Key is math sign.
	 */
	private Map<String,Operation> operation = new HashMap<String,Operation>();
	
	/*
	 * Default constructor that load all possible operation.
	 */
	public Calculator() {
		this.load(new Sum());
		this.load(new Substraction());
		this.load(new Division());
		this.load(new Multiplication());
	}
	
	/*
	 * Implement loading of one arithmetical operation in operation map.
	 * @param operation - sign of arithmetical operation
	 */
	private void load(Operation operation) {
		this.operation.put(operation.operation(), operation);
	}
	
	/*
	 * Implement calculation of input operation
	 * @param operation - sign of arithmetical operation
	 * @param first - first number of operation
	 * @param second - second number of operation
	 */
	public void calculate(int first, int second, String operation) {
		result = this.operation.get(operation).arithmetical(first, second);
	}
	
	/*
	 * @return result of operation
	 */
	public int getResult() {
		return result;
	}
}
