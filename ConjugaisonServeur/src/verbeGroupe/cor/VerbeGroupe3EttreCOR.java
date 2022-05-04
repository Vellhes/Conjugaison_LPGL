package verbeGroupe.cor;

import java.rmi.RemoteException;

import mvc.modele.Verbe;
import verbeGroupe.CasParticulierGroupe3.VerbeGroupe3Ettre;

/**
 * Partie "Verbe Groupe 3 ETTRE" de la Chain Of Responsabilities
 */
public class VerbeGroupe3EttreCOR extends VerbeGroupeCOR {

	public VerbeGroupe3EttreCOR(VerbeGroupeCOR suivant) {
		super(suivant);
	}

	@Override
	public Verbe chercheGroupe1(String verbe) {
		try {
			return new VerbeGroupe3Ettre(verbe);
		}catch(IllegalArgumentException | RemoteException  e) {
			return null;
		}
	}
	
}
