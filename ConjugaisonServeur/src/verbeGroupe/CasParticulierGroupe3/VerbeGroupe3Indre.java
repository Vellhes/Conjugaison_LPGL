package verbeGroupe.CasParticulierGroupe3;

import java.rmi.RemoteException;

import mvc.modele.Verbe;

public class VerbeGroupe3Indre extends Verbe{
	
	public VerbeGroupe3Indre(String verbe) throws RemoteException {
		if(verbe.endsWith("indre")) {
			this.radical = Verbe.setRadical(verbe, "indre");
			this.PP1S = Verbe.setPP1S(verbe);
		}
		else {
			throw new IllegalArgumentException("Ce verbe ne finis pas en INDRE");
		}
	}

	@Override
	protected String term1PS(String temps) {
		switch (temps) {
			case "Présent": return "ins";
			case "Futur" : return "indrai";
			default : return null;
		}
	}

	@Override
	protected String term2PS(String temps) {
		switch (temps) {
			case "Présent": return "ins";
			case "Futur" : return "indras";
			default : return null;
		}
	}

	@Override
	protected String term3PS(String temps) {
		switch (temps) {
			case "Présent": return "int";
			case "Futur" : return "indra";
			default : return null;
		}
	}

	@Override
	protected String term1PP(String temps) {
		switch (temps) {
			case "Présent": return "ignons";
			case "Futur" : return "indrons";
			default : return null;
		}
	}

	@Override
	protected String term2PP(String temps) {
		switch (temps) {
			case "Présent": return "ignez";
			case "Futur" : return "indrez";
			default : return null;
		}
	}

	@Override
	protected String term3PP(String temps) {
		switch (temps) {
			case "Présent": return "ignent";
			case "Futur" : return "indront";
			default : return null;
		}
	}

	@Override
	protected String termPPresent() {
		return "ignant";
	}

	@Override
	protected String termPPasse() {
		return "int";
	}

	

}
