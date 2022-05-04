package verbeGroupe.cor;

import java.rmi.RemoteException;

import mvc.modele.Verbe;
import verbeGroupe.CasParticulierGroupe3.VerbeGroupe3Aitre;

/**
 * Partie "Verbe Groupe 3 AÎTRE" de la Chain Of Responsabilities
 */
public class VerbeGroupe3AitreCOR extends VerbeGroupeCOR {


	public VerbeGroupe3AitreCOR(VerbeGroupeCOR suivant) {
		super(suivant);
	}

	@Override
	public Verbe chercheGroupe1(String verbe) {
		try {
			return new VerbeGroupe3Aitre(verbe);
		}catch(IllegalArgumentException | RemoteException e) {
			return null;
		}
	}
}