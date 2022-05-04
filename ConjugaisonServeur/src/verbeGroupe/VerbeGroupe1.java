package verbeGroupe;

import java.rmi.RemoteException;

import mvc.modele.Verbe;

/**
 * Classe permettant de récupérer les informations d'un verbe du premier groupe sans cas particulier
 */
public class VerbeGroupe1 extends Verbe  {
	
	public VerbeGroupe1(String verbe) throws RemoteException {
		this.radical = Verbe.setRadical(verbe,"er");
		this.PP1S = Verbe.setPP1S(verbe);
	}

	
	
	@Override
	public String term1PS(String temps) {
		switch (temps) {
			case "Présent": return "e";
			case "Futur" : return "erai";
			default : return null;
		}
	}
	
	@Override
	protected String term2PS(String temps) {
		switch (temps) {
			case "Présent": return "es";
			case "Futur" : return "eras";
			default : return null;
		}
	}
	
	@Override
	protected String term3PS(String temps) {
		switch (temps) {
			case "Présent": return "e";
			case "Futur" : return "era";
			default : return null;
		}
	}

	@Override
	protected String term1PP(String temps) {
		switch (temps) {
			case "Présent": return "ons";
			case "Futur" : return "erons";
			default : return null;
		}
	}

	@Override
	protected String term2PP(String temps) {
		switch (temps) {
			case "Présent": return "ez";
			case "Futur" : return "erez";
			default : return null;
		}
	}

	@Override
	protected String term3PP(String temps) {
		switch (temps) {
			case "Présent": return "ent";
			case "Futur" : return "eront";
			default : return null;
		}
	}
	
	@Override
	protected String termPPresent() {
		return "ant";
	}

	@Override
	protected String termPPasse() {
		return "é";
	}



	



	
	
}
