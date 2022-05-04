package verbeGroupe.CasParticulierGroupe1;

import java.rmi.RemoteException;

import mvc.modele.Verbe;
import verbeGroupe.VerbeGroupe1;

/**
 * Classe permettant de r�cup�rer les informations d'un verbe du premier groupe finissant en "GER"
 */
public class VerbeGroupe1Ger extends VerbeGroupe1 {

	public VerbeGroupe1Ger(String verbe) throws RemoteException {
		super(verbe);
		if(verbe.endsWith("ger")) {
			this.radical = Verbe.setRadical(verbe, "er");
		}
		else {
			throw new IllegalArgumentException("Ce verbe ne finis pas en GER");
		}
	}	
	
	@Override
	protected String term1PP(String temps) {
		switch (temps) {
			case "Pr�sent": return "eons";
			case "Futur" : return "erons";
			default : return null;
		}
	}

	@Override
	protected String termPPresent() {
		return "eant";
	}
}
