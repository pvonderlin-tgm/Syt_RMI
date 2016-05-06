package calculation;

public class PICalc implements Calculation {

	private static double result;

	@Override
	public void calculate() {
		System.out.println("Calculating ...");
		calcEuler(100);
	}
	
	private void calcEuler(int digits){
		
		// Buffer for the current e
		double buffer = 1.0;
		
		// current value of the fraction in the limes
		double currentNumber;
		
		// The factorial of the current fraction in the limes
		double factorial = 1.0;
		
		for(int i=1; i < digits;i++){
			factorial = factorial * i; 
			
			currentNumber = 1 / factorial;
			
			buffer += currentNumber;
		}
		
		result = buffer;
	}
	
	@Override
	public void getResult() {
		System.out.println("e equals "+result);

	}
}
