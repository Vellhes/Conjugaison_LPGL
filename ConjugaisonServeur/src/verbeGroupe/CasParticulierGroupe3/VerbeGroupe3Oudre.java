package verbeGroupe.CasParticulierGroupe3;

import java.rmi.RemoteException;

import mvc.modele.Verbe;

public class VerbeGroupe3Oudre extends Verbe{
	
	public VerbeGroupe3Oudre(String verbe) throws RemoteException {
		if(verbe.endsWith("oudre")) {
			this.radical = Verbe.setRadical(verbe, "oudre");
			this.PP1S = Verbe.setPP1S(verbe);
		}
		else {
			throw new IllegalArgumentException("Ce verbe ne finis pas en OUDRE");
		}
	}

	@Override
	protected String term1PS(String temps) {
		switch (temps) {
			case "Présent": return "ouds";
			case "Futur" : return "oudrai";
			default : return null;
		}
	}

	@Override
	protected String term2PS(String temps) {
		switch (temps) {
			case "Présent": return "ouds";
			case "Futur" : return "oudras";
			default : return null;
		}
	}

	@Override
	protected String term3PS(String temps) {
		switch (temps) {
			case "Présent": return "oud";
			case "Futur" : return "oudra";
			default : return null;
		}
	}

	@Override
	protected String term1PP(String temps) {
		switch (temps) {
			case "Présent": return "ousons";
			case "Futur" : return "oudrons";
			default : return null;
		}
	}

	@Override
	protected String term2PP(String temps) {
		switch (temps) {
			case "Présent": return "ousez";
			case "Futur" : return "oudrez";
			default : return null;
		}
	}

	@Override
	protected String term3PP(String temps) {
		switch (temps) {
			case "Présent": return "ousent";
			case "Futur" : return "oudront";
			default : return null;
		}
	}
	
	@Override
	protected String termPPresent() {
		return "olvant";
	}

	@Override
	protected String termPPasse() {
		return "ous";
	}

	
}