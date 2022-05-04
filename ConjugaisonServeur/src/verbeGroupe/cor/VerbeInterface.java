package verbeGroupe.cor;

import mvc.modele.Verbe;

public interface VerbeInterface {

	/**
	 * M�thode permettant de chercher le groupe d'un verbe
	 * @param verbe une cha�ne de caract�res correspondant � notre verbe
	 * @return		un Verbe si la cha�ne poss�de la bonne terminaison, sinon null
	 */
	public Verbe chercheGroupe(String verbe);
	
}
