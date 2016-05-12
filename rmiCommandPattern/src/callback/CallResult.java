package callback;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * 
 * @author Philip Vonderlind
 * @version 12.5.2016
 * 
 * Callback that writes numbers in set, which
 * you can then print and receive
 *
 */
public class CallResult implements Callback<Double>, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4256238859446144769L;
	private static Double result; 
	
	/**
	 * Set the value to be used by the other methods
	 */
	@Override
	public void set(Double result) throws RemoteException {
		// TODO Auto-generated method stub
		this.result = result;
	}

	/**
	 * Prints the result to the console
	 */
	@Override
	public void print() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("The result is: "+result);
	}

	/**
	 * Receive the result
	 */
	@Override
	public Double receive() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
