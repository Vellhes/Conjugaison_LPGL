package mvc.modele;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface VerbeInterface extends Remote{

	public ArrayList<String> conjuge(String temps,String verbe) throws RemoteException;
	
}
