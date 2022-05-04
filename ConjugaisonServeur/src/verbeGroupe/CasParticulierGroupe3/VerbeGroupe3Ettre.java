package verbeGroupe.CasParticulierGroupe3;

import java.rmi.RemoteException;

import mvc.modele.Verbe;

/**
 * Classe permettant de r�cup�rer les informations d'un verbe du trois�me groupe finissant en "ETTRE"
 */
public class VerbeGroupe3Ettre extends Verbe{
	
	public VerbeGroupe3Ettre(String verbe) throws RemoteException {
		if(verbe.endsWith("ettre")) {
			this.radical = Verbe.setRadical(verbe, "ettre");
			this.PP1S = Verbe.setPP1S(verbe);
		}
		else {
			throw new IllegalArgumentException("Ce verbe ne finis pas en ETTRE");
		}
	}

	@Override
	protected String term1PS(String temps) {
		switch (temps) {
			case "Pr�sent": return "ets";
			case "Futur" : return "ettrai";
			default : return null;
		}
	}
	
	@Override
	protected String term2PS(String temps) {
		switch (temps) {
			case "Pr�sent": return "ets";
			case "Futur" : return "ettras";
			default : return null;
		}
	}

	@Override
	protected String term3PS(String temps) {
		switch (temps) {
			case "Pr�sent": return "et";
			case "Futur" : return "ettra";
			default : return null;
		}
	}

	@Override
	protected String term1PP(String temps) {
		switch (temps) {
			case "Pr�sent": return "ettons";
			case "Futur" : return "ettrons";
			default : return null;
		}
	}

	@Override
	protected String term2PP(String temps) {
		switch (temps) {
			case "Pr�sent": return "ettez";
			case "Futur" : return "ettrez";
			default : return null;
		}
	}

	@Override
	protected String term3PP(String temps) {
		switch (temps) {
			case "Pr�sent": return "ettent";
			case "Futur" : return "ettront";
			default : return null;
		}
	}


	@Override
	protected String termPPresent() {
		return "ettant";
	}

	@Override
	protected String termPPasse() {
		return "is";
	}

	
}