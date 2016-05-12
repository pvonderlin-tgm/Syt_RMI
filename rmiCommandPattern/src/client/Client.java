package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import calculation.EulerCalc;
import callback.CallResult;
import callback.Callback;
import remoteService.DoSomethingService;
import server.commands.CalculationCommand;
import server.commands.Command;
import server.commands.RegisterCommand;
import server.commands.LoginCommand;

/**
 * 
 * @author Philip Vonderlind
 * @version 12.5.2016
 * 
 * Connects to the registry on port 1234, 
 * then gets the Service Object.
 * After that, the Callback is exported
 * Now the Client is halted, until the enter key
 * is pressed (like in the Server implementation)
 * After the Client is continued, the callback is
 * unexported again
 */
public class Client {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		try {
			// Connect to registry on port 1234
			Registry registry = LocateRegistry.getRegistry(1234);

			DoSomethingService uRemoteObject = (DoSomethingService) registry.lookup("Service");
			System.out.println("Service found");
	
			// Create a new callback
			Callback callback = new CallResult();
			
			// Export the callback
			Callback callbackStub = (Callback) UnicastRemoteObject.exportObject(callback,0);
			
			// New Command for calculation of Euler
			Command calcEuler = new CalculationCommand(new EulerCalc(), callback);
			
			// Execute the command
			uRemoteObject.doSomething(calcEuler);
			
			// Halt programm until enter key is pressed
			while(System.in.read() != '\n');
			
			UnicastRemoteObject.unexportObject(callback, true);

		} catch (RemoteException re) {
			System.err.println("Service not found?" + " Check your RMI-Registry!");
			System.exit(1);
		} catch (Exception e) {
			System.err.println("Service exception:" + e);
			e.printStackTrace();
			System.exit(1);
		}
	}
}
