package verbeGroupe.CasParticulierGroupe3;

import java.rmi.RemoteException;

import mvc.modele.Verbe;

/**
 * Classe permettant de r�cup�rer les informations d'un verbe du trois�me groupe finissant en "A�TRE"
 */
public class VerbeGroupe3Aitre extends Verbe{
	
	public VerbeGroupe3Aitre(String verbe) throws RemoteException {
		if(verbe.endsWith("a�tre")) {
			this.radical = Verbe.setRadical(verbe, "a�tre");
			this.PP1S = Verbe.setPP1S(verbe);
		}
		else {
			throw new IllegalArgumentException("Ce verbe ne finis pas en A�TRE");
		}
	}

	@Override
	protected String term1PS(String temps) {
		switch (temps) {
			case "Pr�sent": return "ais";
			case "Futur" : return "a�trai";
			default : return null;
		}
	}
	
	@Override
	protected String term2PS(String temps) {
		switch (temps) {
			case "Pr�sent": return "ais";
			case "Futur" : return "a�tras";
			default : return null;
		}
	}

	@Override
	protected String term3PS(String temps) {
		switch (temps) {
			case "Pr�sent": return "ait";
			case "Futur" : return "a�tra";
			default : return null;
		}
	}

	@Override
	protected String term1PP(String temps) {
		switch (temps) {
			case "Pr�sent": return "aissons";
			case "Futur" : return "a�trons";
			default : return null;
		}
	}

	@Override
	protected String term2PP(String temps) {
		switch (temps) {
			case "Pr�sent": return "aissez";
			case "Futur" : return "a�trons";
			default : return null;
		}
	}

	@Override
	protected String term3PP(String temps) {
		switch (temps) {
			case "Pr�sent": return "aissent";
			case "Futur" : return "a�tront";
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