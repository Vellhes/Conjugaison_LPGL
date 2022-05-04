package verbeGroupe.cor;

import java.rmi.RemoteException;

import mvc.modele.Verbe;
import verbeGroupe.CasParticulierGroupe1.VerbeGroupe1Ger;

/**
 * Partie "Verbe Groupe 1 GER" de la Chain Of Responsabilities
 */
public class VerbeGroupe1GerCOR extends VerbeGroupeCOR {


	public VerbeGroupe1GerCOR(VerbeGroupeCOR suivant) {
		super(suivant);
	}

	@Override
	public Verbe chercheGroupe1(String verbe) {
		try {
			return new VerbeGroupe1Ger(verbe);
		}catch(IllegalArgumentException | RemoteException e) {
			return null;
		}
	}
	
}
