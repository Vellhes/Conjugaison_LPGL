package verbeGroupe.cor;

import java.rmi.RemoteException;

import mvc.modele.Verbe;
import verbeGroupe.CasParticulierGroupe3.VerbeGroupe3Indre;

public class VerbeGroupe3IndreCOR extends VerbeGroupeCOR {


	public VerbeGroupe3IndreCOR(VerbeGroupeCOR suivant) {
		super(suivant);
	}

	@Override
	public Verbe chercheGroupe1(String verbe) {
		try {
			return new VerbeGroupe3Indre(verbe);
		}catch(IllegalArgumentException | RemoteException e) {
			return null;
		}
	}
}