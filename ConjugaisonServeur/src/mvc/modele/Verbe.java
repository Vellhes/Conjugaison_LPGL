package mvc.modele;

import java.rmi.RemoteException;
import java.util.ArrayList;


/*
 * Classe d�finissant le type Verbe
 */
public abstract class Verbe {

	protected String radical;
	protected String PP1S;
	
	protected Verbe() throws RemoteException {
		super();
	}

	
	/**
	 * Cette m�thode donne le radical d'un verbe
	 * @param verbe une cha�ne de caract�res correspondant � notre verbe
	 * @param term	une cha�ne de caract�res correspondant � la terminaison du verbe
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
	 * Cette m�thode renvoie la premi�re personne du singulier pour un verbe, "J'" si celui-ci commence par une voyelle, "Je" si c'est une consonne.
	 * @param 	verbe une cha�ne de caract�res correspondant � notre verbe
	 * @return	la premi�re personne du singulier associ�e � ce verbe
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
	 * Cette donne notre verbe conjugu�
	 * @param temps	une cha�ne de caract�res correspondant au temps auquel le verbe doit �tre conjugu�
	 * @return		une Liste de cha�nes de caract�res contenant le verbe conjugu� pour les 6 personnes
	 * @throws RemoteException
	 */
	public ArrayList<String> conjugeTemps(String temps) throws RemoteException {
		ArrayList<String> listeConjug = new ArrayList<String>();
		String verbe;
		if(temps.equalsIgnoreCase("Futur") || temps.equalsIgnoreCase("Pr�sent")) {
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
		else if(temps.equalsIgnoreCase("Pass� compos�")) {
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
	 * M�thode donnant la terminaison � la premi�re personne du singulier
	 * @param temps	une cha�ne de caract�res correspondant au temps auquel le verbe doit �tre conjugu�
	 * @return 		la terminaison du verbe conjugu� � la premi�re personne du singulier
	 */
	protected abstract String term1PS(String temps);
	
	/**
	 * M�thode donnant la terminaison � la deuxi�me personne du singulier
	 * @param temps	une cha�ne de caract�res correspondant au temps auquel le verbe doit �tre conjugu�
	 * @return 		la terminaison du verbe conjugu� � la deuxi�me personne du singulier
	 */
	protected abstract String term2PS(String temps);
	
	/**
	 * M�thode donnant la terminaison � la troisi�me personne du singulier
	 * @param temps	une cha�ne de caract�res correspondant au temps auquel le verbe doit �tre conjugu�
	 * @return 		la terminaison du verbe conjugu� � la premi�re personne du singulier
	 */
	protected abstract String term3PS(String temps);
	
	/**
	 * M�thode donnant la terminaison � la troisi�me personne du singulier
	 * @param temps	une cha�ne de caract�res correspondant au temps auquel le verbe doit �tre conjugu�
	 * @return 		la terminaison du verbe conjugu� � la troisi�me personne du pluriel
	 */
	protected abstract String term1PP(String temps);
	
	/**
	 * M�thode donnant la terminaison � la deuxi�me personne du singulier
	 * @param temps	une cha�ne de caract�res correspondant au temps auquel le verbe doit �tre conjugu�
	 * @return 		la terminaison du verbe deuxi�me � la premi�re personne du pluriel
	 */
	protected abstract String term2PP(String temps);
	
	/**
	 * M�thode donnant la terminaison � la troisi�me personne du singulier
	 * @param temps	une cha�ne de caract�res correspondant au temps auquel le verbe doit �tre conjugu�
	 * @return 		la terminaison du verbe conjugu� � la troisi�me personne du pluriel
	 */
	protected abstract String term3PP(String temps);
	
	/**
	 * M�thode donnant la terminaison du participe pr�sent du verbe
	 * @return 		la terminaison du participe pr�sent du verbe
	 */
	protected abstract String termPPresent();
	
	/**
	 * M�thode donnant la terminaison du participe pass� du verbe
	 * @return 		la terminaison du participe pass� du verbe
	 */
	protected abstract String termPPasse();

}
