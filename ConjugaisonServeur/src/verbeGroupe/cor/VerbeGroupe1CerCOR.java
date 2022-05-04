package verbeGroupe.cor;

import java.rmi.RemoteException;

import mvc.modele.Verbe;
import verbeGroupe.CasParticulierGroupe1.VerbeGroupe1Cer;

public class VerbeGroupe1CerCOR extends VerbeGroupeCOR {


	public VerbeGroupe1CerCOR(VerbeGroupeCOR suivant) {
		super(suivant);
	}

	@Override
	public Verbe chercheGroupe1(String verbe) {
		try {
			return new VerbeGroupe1Cer(verbe);
		}catch(IllegalArgumentException | RemoteException e) {
			return null;
		}
	}
	
}
