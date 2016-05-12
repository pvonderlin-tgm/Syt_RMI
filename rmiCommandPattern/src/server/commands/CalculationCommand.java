package server.commands;

import java.io.Serializable;
import java.rmi.RemoteException;

import calculation.Calculation;
import calculation.EulerCalc;
import callback.Callback;

/**
 * 
 * @author Philip Vonderlind
 * @version 12.5.2016
 * 
 * Handels the Calculation Commands and the Callbacks
 *
 */
public class CalculationCommand implements Command, Serializable {

	private static final long serialVersionUID = 3202369269194172790L;
	
	/**
	 * The calculation to call
	 */
	private Calculation calc;

	/**
	 * The Callback for the command
	 */
	private Callback callback;
	
	/**
	 * Contstructor for a command,
	 * has callback and calculation as
	 * parameter so you can use multiple ones
	 * 
	 * @param calc
	 * @param callback
	 */
	public CalculationCommand(Calculation calc, Callback callback){
		this.calc = calc;
		this.callback = callback;
	}

	/**
	 * Calculates the result
	 */
	@Override
	public void execute() {
		System.out.println("CalculationCommand called!");
		
		// Calculate the result
		calc.calculate();
		try{
			
			// Set the callback to the result of the calculation
			callback.set(calc.getResult());
			
			// Print the result to the client
			callback.print();
			
		}catch(RemoteException e){
			System.err.print("Error while calculating : "+ e );
		}
		
	}
}
