package verbeGroupe.cor;

import mvc.modele.Verbe;

public interface VerbeInterface {

	/**
	 * Méthode permettant de chercher le groupe d'un verbe
	 * @param verbe une chaîne de caractères correspondant à notre verbe
	 * @return		un Verbe si la chaîne possède la bonne terminaison, sinon null
	 */
	public Verbe chercheGroupe(String verbe);
	
}
