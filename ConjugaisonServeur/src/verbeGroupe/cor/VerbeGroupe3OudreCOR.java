package verbeGroupe.cor;

import java.rmi.RemoteException;

import mvc.modele.Verbe;
import verbeGroupe.CasParticulierGroupe3.VerbeGroupe3Oudre;

public class VerbeGroupe3OudreCOR extends VerbeGroupeCOR {


	public VerbeGroupe3OudreCOR(VerbeGroupeCOR suivant) {
		super(suivant);
	}

	@Override
	public Verbe chercheGroupe1(String verbe) {
		try {
			return new VerbeGroupe3Oudre(verbe);
		}catch(IllegalArgumentException | RemoteException e) {
			return null;
		}
	}
}