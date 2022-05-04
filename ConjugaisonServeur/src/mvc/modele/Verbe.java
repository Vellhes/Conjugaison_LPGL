package mvc.modele;

import java.rmi.RemoteException;
import java.util.ArrayList;

public abstract class Verbe {

	protected String radical;
	protected String PP1S;
	
	protected Verbe() throws RemoteException {
		super();
	}


	public static String setRadical(String verbe, String term) throws RemoteException {
		String termVerbe = verbe.substring(verbe.length()-term.length(), verbe.length());
		if(term.equalsIgnoreCase(termVerbe)) {
			return verbe.substring(0,verbe.length()-term.length()).toLowerCase();
		}
		else {
			throw new IllegalArgumentException("mauvais groupe");
		}
	}

	public static String setPP1S(String verbe) throws RemoteException {
		char firstLetter = verbe.charAt(0);
		switch(firstLetter) {
		case 'a': case 'e': case 'o' : case 'i' : case 'u' : case 'y' :
			return "J'";
		default : 
			return "Je ";
		}
	}

	public ArrayList<String> conjugeTemps(String temps) throws RemoteException {
		ArrayList<String> listeConjug = new ArrayList<String>();
		String verbe;
		if(temps.equalsIgnoreCase("Futur") || temps.equalsIgnoreCase("Présent")) {
			verbe = PP1S+radical+term1PS(temps);
			listeConjug.add(verbe);
			verbe = "Tu "+radical+term2PS(temps);
			listeConjug.add(verbe);
			verbe = "Il/Elle/On "+radical+term3PS(temps);
			listeConjug.add(verbe);
			verbe = "Nous "+radical+term1PP(temps);
			listeConjug.add(verbe);
			verbe = "Vous "+radical+term2PP(temps);
			listeConjug.add(verbe);
			verbe = "Ils/Elles "+radical+term3PP(temps);
			listeConjug.add(verbe);
		}
		else if(temps.equalsIgnoreCase("Passé composé")) {
			String participePasse = radical+termPPasse();
			verbe = "J'ai "+participePasse;
			listeConjug.add(verbe);
			verbe = "Tu as "+participePasse;
			listeConjug.add(verbe);
			verbe = "Il/Elle/On a "+participePasse;
			listeConjug.add(verbe);
			verbe = "Nous avons "+participePasse;
			listeConjug.add(verbe);
			verbe = "Vous avez "+participePasse;
			listeConjug.add(verbe);
			verbe = "Ils/Elles ont "+participePasse;
			listeConjug.add(verbe);
		}
		return listeConjug;
	}

	protected abstract String term1PS(String temps);
	protected abstract String term2PS(String temps);
	protected abstract String term3PS(String temps);
	protected abstract String term1PP(String temps);
	protected abstract String term2PP(String temps);
	protected abstract String term3PP(String temps);
	protected abstract String termPPresent();
	protected abstract String termPPasse();

}
