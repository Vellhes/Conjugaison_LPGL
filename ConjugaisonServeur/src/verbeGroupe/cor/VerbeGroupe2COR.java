package verbeGroupe.cor;

import java.rmi.RemoteException;

import mvc.modele.Verbe;
import verbeGroupe.VerbeGroupe2;

/**
 * Partie "Verbe Groupe 2" de la Chain Of Responsabilities
 */
public class VerbeGroupe2COR extends VerbeGroupeCOR {


	public VerbeGroupe2COR(VerbeGroupeCOR suivant) {
		super(suivant);
	}

	@Override
	public Verbe chercheGroupe1(String verbe) {
		try {
			return new VerbeGroupe2(verbe);
		}catch(IllegalArgumentException | RemoteException e) {
			return null;
		}
	}

}