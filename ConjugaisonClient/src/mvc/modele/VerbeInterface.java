package mvc.modele;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface VerbeInterface extends Remote{

	/**
	 * Renvoie le verbe donn� conjugu� au temps donn�
	 * @param temps	une cha�ne de caract�res correspondant au temps auquel le verbe doit �tre conjugu�
	 * @param verbe	une cha�ne de caract�res correspondant � notre verbe
	 * @return		une Liste de cha�nes de caract�res contenant le verbe conjugu� pour les 6 personnes
	 * @throws RemoteException
	 */
	public ArrayList<String> conjuge(String temps,String verbe) throws RemoteException;
	
}
