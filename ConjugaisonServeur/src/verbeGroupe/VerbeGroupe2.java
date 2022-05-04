package verbeGroupe;

import java.rmi.RemoteException;

import mvc.modele.Verbe;

/**
 * Classe permettant de r�cup�rer les informations d'un verbe du deuxi�me groupe sans cas particulier
 */

public class VerbeGroupe2 extends Verbe {
	
	public VerbeGroupe2(String verbe) throws RemoteException {
		this.radical = Verbe.setRadical(verbe,"ir");
		this.PP1S = Verbe.setPP1S(verbe);
	}

	@Override
	protected String term1PS(String temps) {
		switch (temps) {
			case "Pr�sent": return "is";
			case "Futur" : return "irai";
			default : return null;
		}
	}
	
	@Override
	protected String term2PS(String temps) {
		switch (temps) {
			case "Pr�sent": return "is";
			case "Futur" : return "iras";
			default : return null;
		}
	}

	@Override
	protected String term3PS(String temps) {
		switch (temps) {
			case "Pr�sent": return "it";
			case "Futur" : return "ira";
			default : return null;
		}
	}

	@Override
	protected String term1PP(String temps) {
		switch (temps) {
			case "Pr�sent": return "issons";
			case "Futur" : return "irons";
			default : return null;
		}
	}

	@Override
	protected String term2PP(String temps) {
		switch (temps) {
			case "Pr�sent": return "issez";
			case "Futur" : return "irez";
			default : return null;
		}
	}

	@Override
	protected String term3PP(String temps) {
		switch (temps) {
			case "Pr�sent": return "issent";
			case "Futur" : return "iront";
			default : return null;
		}
	}


	@Override
	protected String termPPresent() {
		return "issant";
	}

	@Override
	protected String termPPasse() {
		return "i";
	}

	
	
}
