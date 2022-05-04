package verbeGroupe.CasParticulierGroupe1;

import java.rmi.RemoteException;

import mvc.modele.Verbe;
import verbeGroupe.VerbeGroupe1;

public class VerbeGroupe1Cer extends VerbeGroupe1 {

	public VerbeGroupe1Cer(String verbe) throws RemoteException {
		super(verbe);
		if(verbe.endsWith("cer")) {
			this.radical = Verbe.setRadical(verbe, "cer");
		}
		else {
			throw new IllegalArgumentException("Ce verbe ne finis pas en CER");
		}
	}	
	
	@Override
	public String term1PS(String temps) {
		switch (temps) {
			case "Présent": return "ce";
			case "Futur" : return "cerai";
			default : return null;
		}
	}
	
	@Override
	protected String term2PS(String temps) {
		switch (temps) {
			case "Présent": return "ces";
			case "Futur" : return "ceras";
			default : return null;
		}
	}
	
	@Override
	protected String term3PS(String temps) {
		switch (temps) {
			case "Présent": return "ce";
			case "Futur" : return "cera";
			default : return null;
		}
	}

	@Override
	protected String term1PP(String temps) {
		switch (temps) {
			case "Présent": return "çons";
			case "Futur" : return "cerons";
			default : return null;
		}
	}

	@Override
	protected String term2PP(String temps) {
		switch (temps) {
			case "Présent": return "cez";
			case "Futur" : return "cerez";
			default : return null;
		}
	}

	@Override
	protected String term3PP(String temps) {
		switch (temps) {
			case "Présent": return "cent";
			case "Futur" : return "ceront";
			default : return null;
		}
	}

	@Override
	protected String termPPresent() {
		return "çant";
	}
	
	@Override
	protected String termPPasse() {
		return "cé";
	}
}