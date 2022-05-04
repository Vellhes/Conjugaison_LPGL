package mvc.modele;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface VerbeInterface extends Remote{

	/**
	 * Renvoie le verbe donné conjugué au temps donné
	 * @param temps	une chaîne de caractères correspondant au temps auquel le verbe doit être conjugué
	 * @param verbe	une chaîne de caractères correspondant à notre verbe
	 * @return		une Liste de chaînes de caractères contenant le verbe conjugué pour les 6 personnes
	 * @throws RemoteException
	 */
	public ArrayList<String> conjuge(String temps,String verbe) throws RemoteException;
	
}
