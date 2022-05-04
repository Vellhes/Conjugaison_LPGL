package verbeGroupe.CasParticulierGroupe3;

import java.rmi.RemoteException;

import mvc.modele.Verbe;

/**
 * Classe permettant de récupérer les informations d'un verbe du troisème groupe finissant en "AÎTRE"
 */
public class VerbeGroupe3Aitre extends Verbe{
	
	public VerbeGroupe3Aitre(String verbe) throws RemoteException {
		if(verbe.endsWith("aître")) {
			this.radical = Verbe.setRadical(verbe, "aître");
			this.PP1S = Verbe.setPP1S(verbe);
		}
		else {
			throw new IllegalArgumentException("Ce verbe ne finis pas en AÎTRE");
		}
	}

	@Override
	protected String term1PS(String temps) {
		switch (temps) {
			case "Présent": return "ais";
			case "Futur" : return "aîtrai";
			default : return null;
		}
	}
	
	@Override
	protected String term2PS(String temps) {
		switch (temps) {
			case "Présent": return "ais";
			case "Futur" : return "aîtras";
			default : return null;
		}
	}

	@Override
	protected String term3PS(String temps) {
		switch (temps) {
			case "Présent": return "ait";
			case "Futur" : return "aîtra";
			default : return null;
		}
	}

	@Override
	protected String term1PP(String temps) {
		switch (temps) {
			case "Présent": return "aissons";
			case "Futur" : return "aîtrons";
			default : return null;
		}
	}

	@Override
	protected String term2PP(String temps) {
		switch (temps) {
			case "Présent": return "aissez";
			case "Futur" : return "aîtrons";
			default : return null;
		}
	}

	@Override
	protected String term3PP(String temps) {
		switch (temps) {
			case "Présent": return "aissent";
			case "Futur" : return "aîtront";
			default : return null;
		}
	}


	@Override
	protected String termPPresent() {
		return "aissant";
	}

	@Override
	protected String termPPasse() {
		return "u";
	}

	
}