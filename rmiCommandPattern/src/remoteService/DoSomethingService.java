package remoteService;

import java.rmi.Remote;
import java.rmi.RemoteException;

import server.commands.Command;

public interface DoSomethingService extends Remote {

	public void execute(Command c) throws RemoteException;
	
}
