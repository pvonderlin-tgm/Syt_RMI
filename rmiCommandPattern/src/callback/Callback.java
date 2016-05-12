package callback;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Callback<T> extends Remote, Serializable {
	public void set(T argument) throws RemoteException;
	public void print() throws RemoteException;
	public T receive() throws RemoteException;
}
