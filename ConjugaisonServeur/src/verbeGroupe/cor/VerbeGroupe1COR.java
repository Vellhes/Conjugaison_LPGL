package verbeGroupe.cor;

import java.rmi.RemoteException;

import mvc.modele.Verbe;
import verbeGroupe.VerbeGroupe1;

public class VerbeGroupe1COR extends VerbeGroupeCOR {


	public VerbeGroupe1COR(VerbeGroupeCOR suivant) {
		super(suivant);
	}

	@Override
	public Verbe chercheGroupe1(String verbe) {
		try {
			return new VerbeGroupe1(verbe);
		}catch(IllegalArgumentException | RemoteException e) {
			return null;
		}
	}

}
