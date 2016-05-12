package calculation;

import java.io.Serializable;

/**
 * 
 * @author Philip Vonderlind
 * @version 12.5.2016
 * 
 * Calculates e with the sum algorithm and
 * returns it with a method.
 * Implements the Calculation interface.
 *
 */
public class EulerCalc implements Calculation, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4358022024926403716L;
	/**
	 * The result of the calculation, Contains e
	 */
	private static double result;

	/**
	 * Call the calculation of e with 100 digits
	 */
	@Override
	public void calculate() {
		calcEuler(100);
	}
	
	/**
	 * Calculates e with a given amount
	 * of digits and writes it to a global variable
	 * 
	 * @author Philip Vonderlind
	 * 
	 * @param digits
	 * The amouSnt of digits you want e
	 * to have
	 */
	private void calcEuler(int digits){
		
		// Buffer for the current e
		double buffer = 1.0; 
		
		// current value of the fraction in the limes
		double currentNumber;
		
		// The factorial of the current fraction in the limes
		double factorial = 1.0;
		
		// This loop runs until the amount of digits the user
		// whiched for is reached
		for(int i=1; i < digits;i++){
			
			// Multiply the factorial with the counter, so it
			// behaves like a mathematical factorial
			factorial = factorial * i; 
			
			// By dividing 1 through the current factorial you
			// get the digit at count i for the number e
			currentNumber = 1 / factorial;
			
			// add the current number to the buffer
			buffer += currentNumber;
		}
		
		// Set global variable result to the value of buffer
		result = buffer;
	}
	
	/**
	 * Returns the result of the calculation
	 */
	@Override
	public double getResult() {
		
		return result;
	}
}
