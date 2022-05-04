package mvc.modele;

import java.rmi.RemoteException;
import java.util.ArrayList;


/*
 * Classe définissant le type Verbe
 */
public abstract class Verbe {

	protected String radical;
	protected String PP1S;
	
	protected Verbe() throws RemoteException {
		super();
	}

	
	/**
	 * Cette méthode donne le radical d'un verbe
	 * @param verbe une chaîne de caractères correspondant à notre verbe
	 * @param term	une chaîne de caractères correspondant à la terminaison du verbe
	 * @return		le radical de notre verbe
	 */
	public static String setRadical(String verbe, String term) throws RemoteException {
		String termVerbe = verbe.substring(verbe.length()-term.length(), verbe.length());
		if(term.equalsIgnoreCase(termVerbe)) {
			return verbe.substring(0,verbe.length()-term.length()).toLowerCase();
		}
		else {
			throw new IllegalArgumentException("mauvais groupe");
		}
	}

	/**
	 * Cette méthode renvoie la première personne du singulier pour un verbe, "J'" si celui-ci commence par une voyelle, "Je" si c'est une consonne.
	 * @param 	verbe une chaîne de caractères correspondant à notre verbe
	 * @return	la première personne du singulier associée à ce verbe
	 */
	public static String setPP1S(String verbe) throws RemoteException {
		char firstLetter = verbe.charAt(0);
		switch(firstLetter) {
		case 'a': case 'e': case 'o' : case 'i' : case 'u' : case 'y' :
			return "J'";
		default : 
			return "Je ";
		}
	}

	
	/**
	 * Cette donne notre verbe conjugué
	 * @param temps	une chaîne de caractères correspondant au temps auquel le verbe doit être conjugué
	 * @return		une Liste de chaînes de caractères contenant le verbe conjugué pour les 6 personnes
	 * @throws RemoteException
	 */
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

	
	/**
	 * Méthode donnant la terminaison à la première personne du singulier
	 * @param temps	une chaîne de caractères correspondant au temps auquel le verbe doit être conjugué
	 * @return 		la terminaison du verbe conjugué à la première personne du singulier
	 */
	protected abstract String term1PS(String temps);
	
	/**
	 * Méthode donnant la terminaison à la deuxième personne du singulier
	 * @param temps	une chaîne de caractères correspondant au temps auquel le verbe doit être conjugué
	 * @return 		la terminaison du verbe conjugué à la deuxième personne du singulier
	 */
	protected abstract String term2PS(String temps);
	
	/**
	 * Méthode donnant la terminaison à la troisième personne du singulier
	 * @param temps	une chaîne de caractères correspondant au temps auquel le verbe doit être conjugué
	 * @return 		la terminaison du verbe conjugué à la première personne du singulier
	 */
	protected abstract String term3PS(String temps);
	
	/**
	 * Méthode donnant la terminaison à la troisième personne du singulier
	 * @param temps	une chaîne de caractères correspondant au temps auquel le verbe doit être conjugué
	 * @return 		la terminaison du verbe conjugué à la troisième personne du pluriel
	 */
	protected abstract String term1PP(String temps);
	
	/**
	 * Méthode donnant la terminaison à la deuxième personne du singulier
	 * @param temps	une chaîne de caractères correspondant au temps auquel le verbe doit être conjugué
	 * @return 		la terminaison du verbe deuxième à la première personne du pluriel
	 */
	protected abstract String term2PP(String temps);
	
	/**
	 * Méthode donnant la terminaison à la troisième personne du singulier
	 * @param temps	une chaîne de caractères correspondant au temps auquel le verbe doit être conjugué
	 * @return 		la terminaison du verbe conjugué à la troisième personne du pluriel
	 */
	protected abstract String term3PP(String temps);
	
	/**
	 * Méthode donnant la terminaison du participe présent du verbe
	 * @return 		la terminaison du participe présent du verbe
	 */
	protected abstract String termPPresent();
	
	/**
	 * Méthode donnant la terminaison du participe passé du verbe
	 * @return 		la terminaison du participe passé du verbe
	 */
	protected abstract String termPPasse();

}
