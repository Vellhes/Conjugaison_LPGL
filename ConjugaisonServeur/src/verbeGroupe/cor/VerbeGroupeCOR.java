package verbeGroupe.cor;

import mvc.modele.Verbe;

public abstract class VerbeGroupeCOR implements VerbeInterface{

	private VerbeGroupeCOR suivant;
	
	public VerbeGroupeCOR(VerbeGroupeCOR suivant) {
		this.suivant = suivant;
	}
	
	@Override
	public Verbe chercheGroupe(String verbe) {
		Verbe vrb = this.chercheGroupe1(verbe);
		if(vrb!=null) {
			return vrb;
		}
		else {
			if(this.suivant!=null) {
				return this.suivant.chercheGroupe(verbe);
			}
			else {
				return null;
			}
		}
	}

	
	public abstract Verbe chercheGroupe1(String verbe);
	
	
}
