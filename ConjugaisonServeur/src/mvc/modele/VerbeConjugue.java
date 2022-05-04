package mvc.modele;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import verbeGroupe.cor.VerbeGroupe1COR;
import verbeGroupe.cor.VerbeGroupe1CerCOR;
import verbeGroupe.cor.VerbeGroupe1GerCOR;
import verbeGroupe.cor.VerbeGroupe2COR;
import verbeGroupe.cor.VerbeGroupe3AitreCOR;
import verbeGroupe.cor.VerbeGroupe3EttreCOR;
import verbeGroupe.cor.VerbeGroupe3IndreCOR;
import verbeGroupe.cor.VerbeGroupe3OudreCOR;
import verbeGroupe.cor.VerbeGroupeCOR;

@SuppressWarnings("serial")
public class VerbeConjugue extends UnicastRemoteObject implements VerbeInterface{

	public VerbeConjugue() throws RemoteException {
		super();
	}

	@Override
	public ArrayList<String> conjuge(String temps, String verbe) throws RemoteException {
		VerbeGroupeCOR verbeGroupe;
		verbeGroupe = new VerbeGroupe2COR(null);
		verbeGroupe = new VerbeGroupe1COR(verbeGroupe);
		verbeGroupe = new VerbeGroupe1GerCOR(verbeGroupe);
		verbeGroupe = new VerbeGroupe1CerCOR(verbeGroupe);
		verbeGroupe = new VerbeGroupe3EttreCOR(verbeGroupe);
		verbeGroupe = new VerbeGroupe3AitreCOR(verbeGroupe);
		verbeGroupe = new VerbeGroupe3IndreCOR(verbeGroupe);
		verbeGroupe = new VerbeGroupe3OudreCOR(verbeGroupe);
		Verbe v = verbeGroupe.chercheGroupe(verbe);
		if(v==null) {
			return null;
		}
		else {
			return v.conjugeTemps(temps);
		}
	}

}
